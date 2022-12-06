package subway.domain.path;

import subway.constant.ErrorMessage;
import subway.domain.MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum PathCriterion {
    BY_SHORTEST_DISTANCE("1", "최단 거리"),
    BY_MINIMUM_TIME("2", "최소 시간"),
    TURN_BACK("B", "돌아가기");

    private final String key;
    private final String content;

    PathCriterion(final String key, final String content) {
        this.key = key;
        this.content = content;
    }

    public static PathCriterion find(final String command) {
        return Arrays.stream(PathCriterion.values())
                .filter(function -> Objects.equals(function.getKey(), command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_FUNCTION));
    }

    public static boolean byShortestDistance(PathCriterion criterion){
        return criterion == BY_SHORTEST_DISTANCE;
    }

    public static boolean byMinimumTime(PathCriterion criterion){
        return criterion == BY_MINIMUM_TIME;
    }

    public static boolean isTurnBack(PathCriterion command){
        return command == TURN_BACK;
    }

    public static List<String> getFunctions() {
        List<String> functions = new ArrayList<>();
        for (PathCriterion function : PathCriterion.values()) {
            functions.add(function.toString());
        }
        return functions;
    }

    public String getKey() {
        return this.key;
    }

    @Override
    public String toString() {
        return key + ". " + content;
    }
}
