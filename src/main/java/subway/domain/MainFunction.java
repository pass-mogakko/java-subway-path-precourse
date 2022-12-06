package subway.domain;

import subway.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum MainFunction {
    SEARCH_ROUTE("1", "경로 조회"),
    EXIT("Q", "종료");

    private final String key;
    private final String content;

    MainFunction(final String key, final String content) {
        this.key = key;
        this.content = content;
    }

    public static MainFunction find(final String command) {
        return Arrays.stream(MainFunction.values())
                .filter(function -> Objects.equals(function.getKey(), command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_FUNCTION));
    }

    public static boolean isSearchRoute(MainFunction function){
        return function == SEARCH_ROUTE;
    }

    public static List<String> getFunctions() {
        List<String> functions = new ArrayList<>();
        for (MainFunction function : MainFunction.values()) {
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
