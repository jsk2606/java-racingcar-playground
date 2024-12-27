package controller;

import service.RacingGame;

public class GameStarter {

    public static void main(String[] args) {
//        게임실행
        RacingGame game = new RacingGame();
        game.start();
    }
}
