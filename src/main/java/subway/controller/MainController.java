package subway.controller;

import subway.domain.MainFunction;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class MainController {

    public static void viewMain() {
        printMainView();
        final MainFunction function = readFunction();
        runMain(function);
    }

    private static void runMain(MainFunction function) {
        if(MainFunction.isSearchRoute(function)){
            PathController.run();
        }
    }

    private static void printMainView() {
        List<String> functions = MainFunction.getFunctions();
        OutputView.printMainView(functions);
    }

    private static MainFunction readFunction(){
        try{
            String functionKey = InputView.inputFunction();
            return MainFunction.find(functionKey);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readFunction();
        }
    }

}
