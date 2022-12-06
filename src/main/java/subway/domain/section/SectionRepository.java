package subway.domain.section;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.constant.ErrorMessage;
import subway.domain.DummyData;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();
    private static final WeightedMultigraph<String, DefaultWeightedEdge> shortestPathGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final WeightedMultigraph<String, DefaultWeightedEdge> minimumTimeGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    private static final DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(shortestPathGraph);
    private static final DijkstraShortestPath dijkstraMinimumTime = new DijkstraShortestPath(minimumTimeGraph);

    static {
        insertDummyData();
        computePath();
    }

    private static void insertDummyData() {
        Arrays.stream(DummyData.values())
                .forEach(section -> sections.add(section.getSection()));
    }

    private static void computePath() {
        sections.forEach(SectionRepository::computePath);
    }

    private static void computePath(Section section) {
        String srcStationName = section.getSrcStationName();
        String dstStationName = section.getDstStationName();
        int distance = section.getDistance();
        int time = section.getTime();
        shortestPathGraph.setEdgeWeight(shortestPathGraph.addEdge(srcStationName, dstStationName), distance);
        minimumTimeGraph.setEdgeWeight(minimumTimeGraph.addEdge(srcStationName, dstStationName), time);
    }

    public static GraphPath findShortestPath(String srcStation, String dstStation) {
        return dijkstraShortestPath.getPath(srcStation, dstStation);
    }

    public static int findShortestPathTime(List<String> stations) {
        return IntStream.range(0, stations.size() - 1)
                .map(stationIndex -> findShortestPathTime(stations, stationIndex))
                .sum();
    }

    private static int findShortestPathTime(List<String> stations, int stationIndex) {
        String srcStationName = stations.get(stationIndex);
        String dstStationName = stations.get(stationIndex + 1);
        Section section = findSectionByStationName(srcStationName, dstStationName);
        return section.getTime();
    }

    private static Section findSectionByStationName(String srcStationName, String dstStationName) {
        return sections.stream()
                .filter(section -> section.isSameSrcStation(srcStationName) && section.isSameDstStation(dstStationName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_SECTION));
    }
}
