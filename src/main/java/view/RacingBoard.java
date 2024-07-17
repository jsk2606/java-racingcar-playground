package view;

import java.util.List;

public class RacingBoard {

    final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    final String NUMBEROFATTEMPT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    final String RACING_START_MESSAGE = "실행 결과";
    final String WINNER_MESSAGE_FORMAT = "%s가 최종 우승하였습니다.";
    public void carNameInputMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void numberOfAttemptsInputMessage() {
        System.out.println(NUMBEROFATTEMPT_INPUT_MESSAGE);
    }

    public void printAdvance(List<String> messageList) {
        messageList.forEach(System.out::println);
    }

    public void printRacingStart() {
        System.out.println(RACING_START_MESSAGE);
    }

    public void printWinner(String winner) {
        System.out.println(String.format(WINNER_MESSAGE_FORMAT, winner));
    }
}
