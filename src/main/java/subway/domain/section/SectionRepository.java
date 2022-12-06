package subway.domain.section;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import subway.domain.DummyData;

public class SectionRepository {

    private static final List<Section> sections = new ArrayList<>();

    static {
        insertDummyData();
    }

    private static void insertDummyData() {
        Arrays.stream(DummyData.values())
                .forEach(section -> sections.add(section.getSection()));
    }
}
