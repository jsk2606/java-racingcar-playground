package controller;

import domain.Car;
import exception.InvalidCarNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.RacingBoard;

public class RacingGameTest {

    RacingBoard board;

    @BeforeEach
    public void 보드생성(){
        board = new RacingBoard();
    }

    @Test
    void 자동차이름입력_메세지(){
        board.carNameInputMessage();
    }
    @Test
    void 시도횟수입력_메세지(){
        board.numberOfAttemptsInputMessage();
    }

    @Test
    void 자동차_이름_입력_다섯글자제한(){
        Assertions.assertThrows(InvalidCarNameException.class, () -> new Car("abcdef"));
    }

    @Test
    void 자동차_전진(){
        Car car =new Car("카이엔");
        int rpm = 4;
        car.accel(rpm);

        Assertions.assertEquals(1, car.getAdvance());
    }

    @Test
    void 자동차_전진실패(){
        Car car =new Car("카이엔");
        int rpm = 3;
        car.accel(rpm);

        Assertions.assertEquals(0, car.getAdvance());
    }
}
