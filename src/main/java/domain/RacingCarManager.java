package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class RacingCarManager {
    private List<Car> racingCarList = new ArrayList<>();
    private final String ADVANCE_RESULT_FORMAT = "%s : %s";
    private final String ADVANCE_CHARACTER = "-";
    private final Supplier<Integer> getRpm;

    public RacingCarManager(Supplier<Integer> getRpm){
        this.getRpm = getRpm;
    }

    public void createCarListWithCarNames(String carNames) {
        String[] carNameArray = carNames.split(",");
        for (int i=0; i<carNameArray.length; i++){
            this.racingCarList.add(new Car(carNameArray[i]));
        }
    }




    public List<String> accelSignal() {
        List<String> messageList = new ArrayList<>();
        racingCarList.forEach(car ->{
            car.accel(getRpm.get());
            messageList.add(String.format(ADVANCE_RESULT_FORMAT,
                    car.getCarName(),
                    advanceToString(car.getAdvance()))
            );
        });
        return messageList;
    }

    private String advanceToString(int advance) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<advance; i++){
            sb.append(ADVANCE_CHARACTER);
        }
        return sb.toString();
    }

    public String getWinner() {
        List<String > winnerArray = new ArrayList<>();
        int bestAdvance = 0;
        for(int i=0; i<racingCarList.size(); i++){
            Car car = racingCarList.get(i);
            if(car.getAdvance() < bestAdvance){
                continue;
            }
            if(bestAdvance < car.getAdvance()){
                winnerArray.clear();
                bestAdvance = car.getAdvance();
            }
            winnerArray.add(car.getCarName());

        }
        return winnerArray.toString()
                .replace("[","")
                .replace("]","");
    }
}
