package subway.domain.optimum;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.path.PathRepository;

import java.util.List;

public class ShortestDistance {
    private static final WeightedMultigraph<String, DefaultWeightedEdge> distances
            = PathRepository.path().getDistances();
    private static final DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distances);

    public static List<String> getPath(String departureStation, String arrivalStation) {
        return dijkstraShortestPath
                .getPath(departureStation, arrivalStation)
                .getVertexList();
    }

    public static double getTotalDistance(String departureStation, String arrivalStation) {
        return dijkstraShortestPath.getPath(departureStation, arrivalStation)
                .getWeight();
    }

    public static double getTotaltime() {
        //
        return 0;
    }

}
