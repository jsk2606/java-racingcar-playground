package domain;

import exception.CarNameExceedsCharacterLimitException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @DisplayName("자동차 이름 다섯글자 초과 예외")
    @Test
    void createCarThrowsCarNameExceedsCharacterLimitException() {
        // given
        // when
        // then
        Assertions.assertThrows(CarNameExceedsCharacterLimitException.class, () -> new Car("carName"));
    }

    @DisplayName("우승자 가져오기 성공")
    @Test
    void getWinnerList() {
        // given
        List<Car> carList = new ArrayList<>();
        Car carA = new Car("NameA");
        Car carB = new Car("NameB");
        Car carC = new Car("NameC");
        carA.accel();
        carA.accel();
        carC.accel();
        carC.accel();
        carList.add(carA);
        carList.add(carB);
        carList.add(carC);

        // when
        String winnerList = Car.getWinnerList(carList);

        // then
        assertEquals("NameA, NameC", winnerList);
    }

    @DisplayName("자동차 상태 출력 성공")
    @Test
    void statusToStringThenCorrect() {
        // given
        Car car = new Car("NameA");
        int accelCount = 2;

        // when
        for (int i = 0; i < accelCount; i++) {
            car.accel();
        }

        // then
        assertEquals("NameA : --", car.statusToString());
    }

    @DisplayName("자동차 전진 성공")
    @Test
    void accelThenCorrect() {
        // given
        Car car = new Car("NameA");
        int accelCount = 2;

        // when
        for (int i = 0; i < accelCount; i++) {
            car.accel();
        }

        // then
        assertEquals(2, car.getPosition());
    }
}