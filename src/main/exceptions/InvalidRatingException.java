package exceptions;

public class InvalidRatingException extends Exception {
    public InvalidRatingException(String msg) {
        super(msg);
    }
}
