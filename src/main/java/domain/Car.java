package domain;

import exception.CarNameExceedsCharacterLimitException;

public class Car {

    private final static int NAME_MAX_SIZE = 5;
    private final String carName;
    private final String STATUS_FORMAT = "%s : %s";
    private short position = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public static void nameCheck(String carName) {
        if (carName.length() > NAME_MAX_SIZE) {
            throw new CarNameExceedsCharacterLimitException();
        }
    }

    public void accel() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.carName;
    }

    public String statusToString() {
        StringBuilder positionBar = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionBar.append("-");
        }
        return String.format(STATUS_FORMAT, carName, positionBar.toString());
    }
}
