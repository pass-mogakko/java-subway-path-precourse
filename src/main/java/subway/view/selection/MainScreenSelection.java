package subway.view.selection;

import java.util.Arrays;
import subway.constant.ErrorMessage;
import subway.constant.Message;

public enum MainScreenSelection {
    ONE("1", "경로 조회"),
    QUIT("Q", "종료");

    private final String selection;
    private final String content;

    MainScreenSelection(String selection, String content) {
        this.selection = selection;
        this.content = content;
    }

    public static void validate(String selection) {
        boolean isAnyMatch = Arrays.stream(MainScreenSelection.values())
                .anyMatch(mainScreenSelection -> mainScreenSelection.selection.equals(selection));
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
