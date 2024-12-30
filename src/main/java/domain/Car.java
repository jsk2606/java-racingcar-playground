package domain;

import exception.CarNameExceedsCharacterLimitException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private final static int NAME_MAX_SIZE = 5;
    private static final String CAR_NAME_SEPARATOR = ",";
    private final static String STATUS_FORMAT = "%s : %s";
    private final String carName;
    private short position = 0;

    public Car(String carName) {
        if (carName.length() > NAME_MAX_SIZE) {
            throw new CarNameExceedsCharacterLimitException();
        }
        this.carName = carName;
    }

    public static List<Car> createCarListByCarNames(String carNames) {
        List<String> carNameList = Arrays.stream(carNames.split(CAR_NAME_SEPARATOR))
                .collect(Collectors.toList());
        List<Car> participationCars = new ArrayList<>();
        for (String carName : carNameList) {
            participationCars.add(new Car(carName));
        }
        return participationCars;
    }

    public static String getWinnerList(List<Car> lastMatchResult) {
        short maxPostion = 0;
        for (Car car : lastMatchResult) {
            if (maxPostion < car.getPosition()) {
                maxPostion = car.getPosition();
            }
        }
        List<String> winnerList = new ArrayList<>();
        for (Car car : lastMatchResult) {
            if (car.getPosition() == maxPostion) {
                winnerList.add(car.carName);
            }
        }
        return String.join(", ", winnerList);
    }

    public short getPosition() {
        return position;
    }

    public void accel() {
        this.position++;
    }

    public String statusToString() {
        StringBuilder positionBar = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionBar.append("-");
        }
        return String.format(STATUS_FORMAT, carName, positionBar);
    }
}
