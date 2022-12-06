package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathGroupRepository {
    private static final List<PathGroupByLine> pathGroups = new ArrayList<>();

    static {
        pathGroups.add(new PathGroupByLine("2호선", List.of(
                new Path(List.of("교대역", "강남역"), 2, 3),
                new Path(List.of("강남역", "역삼역"), 2, 3)
        )));
        pathGroups.add(new PathGroupByLine("3호선", List.of(
                new Path(List.of("교대역", "남부터미널역"), 3, 2),
                new Path(List.of("남부터미널역", "양재역"), 6, 5),
                new Path(List.of("양재역", "매봉역"), 1, 1)
        )));
        pathGroups.add(new PathGroupByLine("신분당선", List.of(
                new Path(List.of("강남역", "양재역"), 2, 8),
                new Path(List.of("양재역", "양재시민의숲역"), 10, 3)
        )));
    }

    public static List<PathGroupByLine> pathGroups() {
        return Collections.unmodifiableList(pathGroups);
    }

    // TODO getAllPaths
}