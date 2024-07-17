package domain;

import exception.InvalidCarNameException;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private String carName;
    private int advance = 0;
    private final int ADVANCE_CUT = 3;
    private final int NAME_MAX_SIZE = 5;

    public Car(String carName) {
        nameCheck(carName);
    }

    private void nameCheck(String carName) {
        if(null == carName){
            // 흐음
        }
        if(carName.length() > NAME_MAX_SIZE){
            throw new InvalidCarNameException();
        }
        this.carName = carName;
    }

    public void accel(int rpm) {
        if(rpm > ADVANCE_CUT){
            this.advance++;
        }
    }

    public int getAdvance() {
        return this.advance;
    }

    public String getCarName() {
        return this.carName;
    }
}
