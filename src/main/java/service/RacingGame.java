package service;

import domain.Car;
import domain.Racing;
import util.RacingGameUtil;

import java.util.List;

/**
 * 레이싱 게임 domain
 */
public class RacingGame {

    // 게임실행
    public void start() {
        // 자동차 이름 입력
        List<String> carNames = RacingGameUtil.enterCarNames();
        carNames.forEach(Car::nameCheck);
        // 시도 횟수 입력
        int numberOfAttempts = RacingGameUtil.enterNumberOfAttempts();
        // 경기 시작
        Racing racing = new Racing(carNames, numberOfAttempts);
        racing.start();
        // 경기 결과 출력
        RacingGameUtil.winnerOutput(racing.getMatchResult());

    }
}
