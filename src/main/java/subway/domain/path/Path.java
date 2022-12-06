package subway.domain.path;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public class Path {
    private final WeightedMultigraph<String, DefaultWeightedEdge> distances;
    private final WeightedMultigraph<String, DefaultWeightedEdge> times;

    public Path() {
        this.distances = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        this.times = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    }

    public void addStation(String station) {
        distances.addVertex(station);
        times.addVertex(station);
    }

    public void addDistanceAndTime(String departureStation, String arrivalStation, final double distance, final double time) {
        setDistance(departureStation, arrivalStation, distance);
        setTime(departureStation, arrivalStation, time);
    }

    private void setDistance(String departureStation, String arrivalStation, final double distance) {
        distances.setEdgeWeight(distances.addEdge(departureStation, arrivalStation), distance);
    }

    private void setTime(String departureStation, String arrivalStation, final double time) {
        times.setEdgeWeight(times.addEdge(departureStation, arrivalStation), time);
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> getDistances() {
        return distances;
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> getTimes() {
        return times;
    }
}
