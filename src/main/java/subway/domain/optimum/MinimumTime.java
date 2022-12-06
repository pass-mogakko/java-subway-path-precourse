package subway.domain.optimum;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.path.Path;
import subway.domain.path.PathRepository;

import java.util.List;

public class MinimumTime {
    private static final Path path = PathRepository.path();

    public static List<String> getMinimumTime(String departureStation, String arrivalStation) {
        final WeightedMultigraph<String, DefaultWeightedEdge> times = path.getTimes();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(times);
        List<String> minimumTimePath = dijkstraShortestPath
                .getPath(departureStation, arrivalStation)
                .getVertexList();
        return minimumTimePath;
    }
}
