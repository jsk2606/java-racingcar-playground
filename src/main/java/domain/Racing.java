package domain;

import util.RacingGameUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 레이싱 domain
 */
public class Racing {

    private final List<String> carNames;
    private final Integer numberOfAttempts;
    private final Map<Integer, List<Car>> matchResult =  new HashMap<>();
    private final static int ADVANCE_CONDITION = 4;

    public Racing(List<String> carNames, int numberOfAttempts) {
        this.carNames = carNames;
        this.numberOfAttempts = numberOfAttempts;
    }

    public void start() {
        List<Car> participationCars = participationCarsInitialize();
        gameProgress(participationCars);
    }

    public Map<Integer, List<Car>> getMatchResult() {
        return matchResult;
    }

    private Car advance(Car car){
        int randomResult = RacingGameUtil.randomAdvanceDraw();
        if(randomResult >= ADVANCE_CONDITION) {
            car.accel();
        }
        return car;
    }

    private List<Car> participationCarsInitialize() {
        List<Car> result = new ArrayList<>();
        for(String carName : carNames) {
            result.add(new Car(carName));
        }
        return result;
    }

    private void gameProgress(List<Car> participationCars) {
        for(int nthMatch = 0; nthMatch < numberOfAttempts; nthMatch++) {
            List<Car> currentMatchResult = new ArrayList<>();
            for(Car participationCar : participationCars) {
                currentMatchResult.add(advance(participationCar));
            }
            matchResult.put(nthMatch, currentMatchResult);
        }
    }
}
