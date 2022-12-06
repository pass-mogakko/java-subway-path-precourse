package subway.dto;

import java.util.List;

public class PathDto {

    private final int distance;
    private final int time;
    private final List<String> stationNames;

    public PathDto(int distance, int time, List<String> stationNames) {
        this.distance = distance;
        this.time = time;
        this.stationNames = stationNames;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public List<String> getStationNames() {
        return stationNames;
    }
}
