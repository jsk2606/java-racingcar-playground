package util;

import domain.Car;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGameUtil {
    private static final String ENTER_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ENTER_NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String MATCH_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "%s가 최종 우승했습니다.";

    private static final String CAR_NAME_SEPARATOR = ",";
    private static final int RANDOM_ADVANCE_DRAW_MAX = 10;

    // 자동차 이름 입력
    public static List<String> enterCarNames() {
        System.out.println(ENTER_CAR_NAMES_MESSAGE);
        String carNames = inputSystemIn();
        return Arrays.stream(carNames.split(CAR_NAME_SEPARATOR))
                .collect(Collectors.toList());
    }

    // 시도 횟수 입력
    public static int enterNumberOfAttempts() {
        System.out.println(ENTER_NUMBER_OF_ATTEMPTS_MESSAGE);
        String numberOfAttempts = inputSystemIn();
        return Integer.parseInt(numberOfAttempts);
    }

    // 경기 결과 출력
    public static void winnerOutput(Map<Integer, List<Car>> matchResult) {
        System.out.println(MATCH_RESULT_MESSAGE);
        List<Car> lastMatchResult = new ArrayList<>();
        int bestMoveForward = 0;
        for (Map.Entry<Integer, List<Car>> entry : matchResult.entrySet()) {
            List<Car> cars = entry.getValue();
            for (Car car : cars) {
                System.out.println(car.statusToString());
                if (bestMoveForward < car.getPosition()) {
                    bestMoveForward = car.getPosition();
                }
            }
            lastMatchResult = entry.getValue();
        }

        int finalBestMoveForward = bestMoveForward;
        System.out.println(String.format(WINNER_MESSAGE, lastMatchResult.stream()
                .filter(car -> car.getPosition() == finalBestMoveForward)
                .map(Car::getCarName)
                .collect(Collectors.toList())
                .toString()));
    }

    private static String inputSystemIn() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }

    public static int randomAdvanceDraw() {
        Random random = new Random();
        return random.nextInt(RANDOM_ADVANCE_DRAW_MAX);
    }
}
