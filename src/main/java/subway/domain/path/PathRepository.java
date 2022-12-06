package subway.domain.path;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;

import java.util.List;

public class PathRepository {
    private static final Path path = new Path();

    static {
        setAllStations();
        setLineTwoPath();
        setLineThreePath();
        setLineShinBunDangPath();
    }

    public static Path path() {
        return path;
    }

    private static void setAllStations() {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            path.addStation(station.getName());
        }
    }

    private static void setLineTwoPath() {
        path.addDistanceAndTime("교대역", "강남역", 2, 3);
        path.addDistanceAndTime("강남역", "역삼역", 2, 3);
    }

    private static void setLineThreePath() {
        path.addDistanceAndTime("교대역", "남부터미널역", 3, 2);
        path.addDistanceAndTime("남부터미널역", "양재역", 6, 5);
        path.addDistanceAndTime("양재역", "매봉역", 1, 1);
    }

    private static void setLineShinBunDangPath() {
        path.addDistanceAndTime("강남역", "양재역", 2, 8);
        path.addDistanceAndTime("양재역", "양재시민의숲역", 10, 3);
    }
}
