
public class QueueUnderflowException extends Exception {
	/**
	 * Constructor.
	 */
	public QueueUnderflowException() {
		this("This should have caused an QueueUnderflowException");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public QueueUnderflowException(String message) {
		super(message);
	}
}
