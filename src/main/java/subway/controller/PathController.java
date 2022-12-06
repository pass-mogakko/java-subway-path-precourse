package subway.controller;

import subway.constant.ErrorMessage;
import subway.domain.optimum.OptimumPath;
import subway.domain.path.PathCriterion;
import subway.domain.station.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class PathController {
    public static void run() {
        printPathCriterionView();
        PathCriterion function = readFunction();
        if (PathCriterion.byShortestDistance(function)) {
            computeShortestDistancePath();
        }
        if (PathCriterion.byMinimumTime(function)) {
            computeMinimumTimePath();
        }
        if (PathCriterion.isTurnBack(function)) {
            MainController.viewMain();
        }
    }

    private static void printPathCriterionView() {
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

    private static void computeShortestDistancePath() {
        try {
            String departureStation = readDepartureStation();
            String arrivalStation = readArrivalStation();
            validateStations(departureStation, arrivalStation);
            List<String> optimumPath = OptimumPath.getShortestDistance(departureStation, arrivalStation);
            printOptimumPath(optimumPath);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }

    private static void computeMinimumTimePath() {
        try {
            String departureStation = readDepartureStation();
            String arrivalStation = readArrivalStation();
            validateStations(departureStation, arrivalStation);
            List<String> optimumPath = OptimumPath.getMinimumTime(departureStation, arrivalStation);
            printOptimumPath(optimumPath);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }

    private static void printOptimumPath(List<String> optimumPath){
        System.out.println(optimumPath);
    }

    private static String readDepartureStation() {
        try {
            String stationName = InputView.inputDepartureStation();
            return StationRepository.findByName(stationName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readDepartureStation();
        }
    }

    private static String readArrivalStation() {
        try {
            String stationName = InputView.inputArrivalStation();
            return StationRepository.findByName(stationName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readArrivalStation();
        }
    }

    private static void validateStations(String departureStation, String arrivalStation) {
        if (departureStation.equals(arrivalStation)) {
            throw new IllegalArgumentException(ErrorMessage.SAME_STATION);
        }
    }
}
