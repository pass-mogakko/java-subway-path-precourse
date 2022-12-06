package subway.controller;

import subway.domain.path.PathCriterion;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class PathController {
    public void run() {
        printPathCriterionView();
        PathCriterion function = readFunction();

    }

    private void printPathCriterionView() {
        List<String> functions = PathCriterion.getFunctions();
        OutputView.printPathCriterionView(functions);
    }

    private static PathCriterion readFunction() {
        try {
            String functionKey = InputView.inputFunction();
            return PathCriterion.find(functionKey);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readFunction();
        }
    }

}
