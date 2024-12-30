package controller;

import domain.Racing;
import util.RacingGameUtil;

public class GameStarter {

    public static void main(String[] args) {
        // 자동차 이름 입력
        String carNames = RacingGameUtil.enterCarNames();
        // 시도 횟수 입력
        int numberOfAttempts = RacingGameUtil.enterNumberOfAttempts();
        // 게임실행
        Racing game = new Racing();
        String winnersMessage = game.start(carNames, numberOfAttempts);
        // 우승자 출력
        System.out.println(winnersMessage);
    }
}
