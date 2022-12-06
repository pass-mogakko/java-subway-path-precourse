package subway.controller;

import java.util.HashMap;
import java.util.Map;
import subway.dto.PathDto;
import subway.service.PathLookupService;
import subway.utils.Utils;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.selection.PathLookupSelection;

public class PathLookupController {

    private final Map<String, Runnable> selectionNavigator = new HashMap<>();
    private final PathLookupService pathLookupService = new PathLookupService();

    public PathLookupController() {
        selectionNavigator.put(PathLookupSelection.ONE.getSelection(), this::findShortestPath);
        selectionNavigator.put(PathLookupSelection.TWO.getSelection(), this::findMinimumTimePath);
    }

    public void run() {
        String pathLookupSelection = Utils.requestInput(InputView::requestPathLookupSelection, OutputView::printErrorMessage);
        if (pathLookupSelection.equals(PathLookupSelection.BACK.getSelection())) {
            return;
        }
        Runnable nextAction = selectionNavigator.get(pathLookupSelection);
        Utils.exceptionHandlingRepeat(nextAction, OutputView::printErrorMessage);
    }

    private void findShortestPath() {
        String srcStation = InputView.requestSrcStation();
        String dstStation = InputView.requestDstStation();
        PathDto pathDto = pathLookupService.findShortestPath(srcStation, dstStation);
        OutputView.printPathResult(pathDto);
    }

    private void findMinimumTimePath() {
        String srcStation = InputView.requestSrcStation();
        String dstStation = InputView.requestDstStation();

    }
}
