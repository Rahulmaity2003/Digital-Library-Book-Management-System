package exception;

/**
 * Exception for book not found scenarios.
 */
public class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}
