package subway.domain.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.DummyData;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    static {
        insertDummyData();
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    private static void insertDummyData() {
        Arrays.stream(DummyData.values())
                .map(dummyData -> dummyData.getSection())
                .map(section -> section.getLineName())
                .distinct()
                .forEach(lineName -> lines.add(new Line(lineName)));
    }


}
