package exception;

public class CarNameExceedsCharacterLimitException extends IllegalArgumentException {
    public CarNameExceedsCharacterLimitException(){
        super("자동차 이름이 다섯글자를 초과했습니다.");
    }
}
