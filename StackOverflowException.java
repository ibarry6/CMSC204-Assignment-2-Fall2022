
public class StackOverflowException extends Exception {
	/**
	 * Constructor.
	 */
	public StackOverflowException() {
		this("This should have caused an StackOvverflowException");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public StackOverflowException(String message) {
		super(message);
	}
}
