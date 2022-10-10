
public class QueueOverflowException extends Exception {
	/**
	 * Constructor.
	 */
	public QueueOverflowException() {
		this("This should have caused an QueueOverflowException");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public QueueOverflowException(String message) {
		super(message);
	}
}
