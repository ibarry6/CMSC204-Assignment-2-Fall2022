
public class InvalidNotationFormatException extends Exception {
	/**
	 * Constructor.
	 */
	public InvalidNotationFormatException() {
		this("This should have thrown an InvalidNotationFormatException");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public InvalidNotationFormatException(String message) {
		super(message);
	}
}
