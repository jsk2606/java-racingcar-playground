import controller.RacingGame;
import domain.RacingCarManager;
import view.RacingBoard;

import java.util.Random;

public class GameStarter {

    public static void main(String[] args) {
        RacingGame game = new RacingGame(
                new RacingBoard(),
                new RacingCarManager(() -> {
                    Random random = new Random();
                    int maxRpm = 10;
                    return random.nextInt(maxRpm);
                })
        );
        game.managerInit();
        game.numberOfAttemptsInit();
        game.racingStart();
        game.gameOver();
    }
}
