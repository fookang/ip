package Kiwee.exception;

public class EndBeforeStartException extends KiweeException {
    public EndBeforeStartException() {
        super("Wow! You finish your task before you started!");
    }
}
