package subway.domain.station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.DummyData;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    static {
        insertDummyData();
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    private static void insertDummyData() {
        Arrays.stream(DummyData.values())
                .map(dummyData -> dummyData.getSection())
                .map(section -> section.getSrcStationName())
                .distinct()
                .forEach(stationName -> stations.add(new Station(stationName)));
    }

}
