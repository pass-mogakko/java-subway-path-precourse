package subway.domain.path;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PathRepository {
    private static final HashMap<Line, Path> linePaths;

    static {
        linePaths = new HashMap<>();
        setLineTwo();
        setLineThree();
        setLineShinBunDang();
    }

    public static HashMap<Line, Path> linePaths() {
        return (HashMap<Line, Path>) Collections.unmodifiableMap(linePaths);
    }

    private static void setLineTwo() {
        Line lineTwo = LineRepository.findByName("2호선");
        Path lineTwoPath = new Path();
        lineTwoPath.addStation(List.of("교대역", "강남역", "역삼역"));
        lineTwoPath.addDistanceAndTime("교대역", "강남역", 2, 3);
        lineTwoPath.addDistanceAndTime("강남역", "역삼역", 2, 3);
        linePaths.put(lineTwo, lineTwoPath);
    }

    private static void setLineThree() {
        Line lineThree = LineRepository.findByName("3호선");
        Path lineThreePath = new Path();
        lineThreePath.addStation(List.of("교대역", "남부터미널역", "양재역", "매봉역"));
        lineThreePath.addDistanceAndTime("교대역", "남부터미널역", 3, 2);
        lineThreePath.addDistanceAndTime("남부터미널역", "양재역", 6, 5);
        lineThreePath.addDistanceAndTime("양재역", "매봉역", 1, 1);
        linePaths.put(lineThree, lineThreePath);
    }

    private static void setLineShinBunDang() {
        Line lineShinBunDang = LineRepository.findByName("신분당선");
        Path lineShinBunDangPath = new Path();
        lineShinBunDangPath.addStation(List.of("강남역", "양재역", "양재시민의숲역"));
        lineShinBunDangPath.addDistanceAndTime("강남역", "양재역", 2, 8);
        lineShinBunDangPath.addDistanceAndTime("양재역", "양재시민의숲역", 10, 3);
        linePaths.put(lineShinBunDang, lineShinBunDangPath);
    }
}
