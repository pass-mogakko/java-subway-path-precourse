package subway.view;

import java.util.List;
import subway.constant.ErrorMessage;
import subway.constant.Message;
import subway.dto.PathDto;

public class OutputView {

    public static void printErrorMessage(String message) {
        System.out.println();
        System.out.printf(ErrorMessage.ERROR_MESSAGE_FORM, message);
        System.out.println();
    }

    public static void printPathResult(PathDto pathDto) {
        int distance = pathDto.getDistance();
        int time = pathDto.getTime();
        List<String> stationNames = pathDto.getStationNames();

        printTitleMessage(Message.LOOKUP_RESULT);
        printInfoMessage(Message.DIVISION_LINE);
        String totalDistance = String.format(Message.TOTAL_DISTANCE, distance);
        printInfoMessage(totalDistance);
        String totalTime = String.format(Message.TOTAL_TIME, time);
        printInfoMessage(totalTime);
        printInfoMessage(Message.DIVISION_LINE);
        stationNames.forEach(OutputView::printInfoMessage);
    }

    private static void printTitleMessage(String message) {
        System.out.println();
        System.out.printf(Message.TITLE_MESSAGE_FORM, message);
        System.out.println();
    }

    private static void printInfoMessage(String message) {
        System.out.printf(Message.INFO_MESSAGE_FORM, message);
        System.out.println();
    }
}
