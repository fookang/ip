package Kiwee.exception;

public class CorruptedLineException extends KiweeException {
    public CorruptedLineException(String message) {
        super("Kiwee cannot understand this " + message);
    }
}
