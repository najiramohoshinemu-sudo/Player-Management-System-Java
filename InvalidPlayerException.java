// Custom exception class for invalid player-related data
public class InvalidPlayerException extends Exception {

    // Constructor receives the error message
    public InvalidPlayerException(String message) {

        // Sends the message to the parent Exception class
        super(message);
    }
}