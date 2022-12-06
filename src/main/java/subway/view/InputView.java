package subway.view;

import java.util.Arrays;
import java.util.Scanner;
import subway.constant.Message;
import subway.view.selection.MainScreenSelection;
import subway.view.selection.PathLookupSelection;

public class InputView {

    private static Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static String requestMainScreenSelection() {
        printTitleMessage(Message.MAIN_SCREEN);
        Arrays.stream(MainScreenSelection.values())
                .map(MainScreenSelection::toKorean)
                .forEach(System.out::println);
        printSelectFunction();
        String mainScreenSelection = scanner.nextLine();
        MainScreenSelection.validate(mainScreenSelection);
        return mainScreenSelection;
    }

    private static void printTitleMessage(String message) {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, message);
        System.out.println();
    }

    private static void printSelectFunction() {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, Message.SELECT_FUNCTION);
        System.out.println();
    }

    public static String requestSrcStation() {
        printTitleMessage(Message.REQUEST_SRC_STATION);
        return scanner.nextLine();
    }

    public static String requestDstStation() {
        printTitleMessage(Message.REQUEST_DST_STATION);
        return scanner.nextLine();
    }

    public static String requestPathLookupSelection() {
        printTitleMessage(Message.BASE_PATH);
        Arrays.stream(PathLookupSelection.values())
                .map(PathLookupSelection::toKorean)
                .forEach(System.out::println);
        printSelectFunction();
        String pathLookupSelection = scanner.nextLine();
        PathLookupSelection.validate(pathLookupSelection);
        return pathLookupSelection;
    }
}
