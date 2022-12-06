package subway.view;

import java.util.List;

public class OutputView {
    private static final String INFO = "[INFO] %s" + System.lineSeparator();

    public static void printMainView(List<String> functions) {
        System.out.println("## 메인 화면");
        for(String function : functions){
            System.out.printf(function);
        }
    }
}
