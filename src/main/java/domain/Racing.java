package domain;

import util.RacingGameUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 레이싱 domain
 */
public class Racing {

    private final static int ADVANCE_CONDITION = 4;
    private final List<List<Car>> matchResult = new ArrayList<>();

    // 게임실행
    public String start(String carNames, int numberOfAttempts) {
        List<Car> participationCars = Car.createCarListByCarNames(carNames);
        // 경기 시작
        for (int nthMatch = 0; nthMatch < numberOfAttempts; nthMatch++) {
            List<Car> currentMatchResult = new ArrayList<>();
            for (Car participationCar : participationCars) {
                int randomAdvance = RacingGameUtil.randomAdvanceDraw();
                if (isAccel(randomAdvance)) {
                    participationCar.accel();
                }
                currentMatchResult.add(participationCar);
            }
            matchResult.add(currentMatchResult);
        }
        return RacingGameUtil.winnerOutput(matchResult);
    }

    private static boolean isAccel(int randomAdvance) {
        return randomAdvance >= ADVANCE_CONDITION;
    }
}
