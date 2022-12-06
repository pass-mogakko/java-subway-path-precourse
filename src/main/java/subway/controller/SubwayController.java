package subway.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import subway.utils.Utils;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.selection.MainScreenSelection;

public class SubwayController {

    private final InputView inputView;
    private final Map<String, Runnable> selectionNavigator = new HashMap<>();

    public SubwayController(Scanner scanner) {
        inputView = new InputView(scanner);
        PathLookupController pathLookupController = new PathLookupController();
        selectionNavigator.put(MainScreenSelection.ONE.getSelection(), pathLookupController::run);
    }

    public void run() {
        String mainScreenSelection = Utils.requestInput(InputView::requestMainScreenSelection, OutputView::printErrorMessage);
        if (mainScreenSelection.equals(MainScreenSelection.QUIT.getSelection())) {
            return;
        }
        Runnable nextAction = selectionNavigator.get(mainScreenSelection);
        nextAction.run();
        run();
    }
}
