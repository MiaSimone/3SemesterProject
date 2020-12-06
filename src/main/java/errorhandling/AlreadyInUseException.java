package errorhandling;


public class AlreadyInUseException extends Exception {
    public AlreadyInUseException(String message) {
        super(message);
    }
}
