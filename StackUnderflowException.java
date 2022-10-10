
public class StackUnderflowException extends Exception {
	/**
	 * Constructor.
	 */
	public StackUnderflowException() {
		this("This should have caused an StackUnderflowException");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message String message to be shown.
	 */
	public StackUnderflowException(String message) {
		super(message);
	}
}
