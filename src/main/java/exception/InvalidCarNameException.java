package exception;

public class InvalidCarNameException extends IllegalArgumentException {
    public InvalidCarNameException(){
        super("자동차 이름이 다섯글자를 초과했습니다.");
    }
}
