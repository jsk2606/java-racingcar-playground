package controller;

import domain.RacingCarManager;
import view.RacingBoard;

import java.util.List;
import java.util.Scanner;

public class RacingGame {

    private final RacingBoard board;
    private final RacingCarManager manager;
    private int numberOfAttempts;

    public RacingGame(RacingBoard board, RacingCarManager manager){
        this.board = board;
        this.manager = manager;
    }

    public void gameOver() {
        String winner = manager.getWinner();
        board.printWinner(winner);
    }

    public void racingStart() {
        board.printRacingStart();

        for (int i=0 ; i<numberOfAttempts; i++){
            List<String> accelResult = manager.accelSignal();
            board.printAdvance(accelResult);
            System.out.println();
        }
    }

    public void numberOfAttemptsInit() {
        board.numberOfAttemptsInputMessage();
        String numberOfAttempts = inputSystemIn();
        this.numberOfAttempts = Integer.parseInt(numberOfAttempts);
    }

    public void managerInit() {
        while (true){
            try {
                board.carNameInputMessage();
                String carNames = inputSystemIn();
                manager.createCarListWithCarNames(carNames);
            }catch (IllegalArgumentException e){
                System.out.println(e);
                continue;
            }
            break;
        }
    }

    public String inputSystemIn() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }
}
