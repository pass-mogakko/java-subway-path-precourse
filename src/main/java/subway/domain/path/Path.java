package subway.domain.path;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class Path {
    private final WeightedMultigraph<String, DefaultWeightedEdge> distances;
    private final WeightedMultigraph<String, DefaultWeightedEdge> times;

    public Path() {
        this.distances = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        this.times = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    }

    public void addStation(List<String> stations) {
        for (String station : stations) {
            distances.addVertex(station);
            times.addVertex(station);
        }
    }

    public void addDistanceAndTime(String startStation, String endStation, final double distance, final double time) {
        setDistance(startStation, endStation, distance);
        setTime(startStation, endStation, time);
    }

    private void setDistance(String startStation, String endStation, final double distance) {
        distances.setEdgeWeight(distances.addEdge(startStation, endStation), distance);
    }

    private void setTime(String startStation, String endStation, final double time) {
        times.setEdgeWeight(times.addEdge(startStation, endStation), time);
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> getDistances() {
        return distances;
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> getTimes() {
        return times;
    }
}
