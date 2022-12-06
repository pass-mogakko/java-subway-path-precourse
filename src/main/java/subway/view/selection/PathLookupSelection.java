package subway.view.selection;

import java.util.Arrays;
import subway.constant.ErrorMessage;
import subway.constant.Message;

public enum PathLookupSelection {
    ONE("1", "최단 거리"),
    TWO("2", "최소 시간"),
    BACK("B", "돌아가기");

    private final String selection;
    private final String content;

    PathLookupSelection(String selection, String content) {
        this.selection = selection;
        this.content = content;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(PathLookupSelection.values())
                .anyMatch(pathLookupSelection -> pathLookupSelection.selection.equals(selection));
        if (!isAnyMatch) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_SELECTION);
        }
    }

    public String toKorean() {
        return String.format(Message.SELECTION_MESSAGE_FORM, selection, content);
    }

    public String getSelection() {
        return selection;
    }
}
