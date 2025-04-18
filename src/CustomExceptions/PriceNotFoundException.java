package CustomExceptions;

public class PriceNotFoundException extends Exception {
    public PriceNotFoundException(String message) {
        super(message);
    }
}