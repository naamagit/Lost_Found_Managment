package lostandfound.excpetion;

public class InvalidRequest extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidRequest(String message) {

		super("Invalid data entered in " + message);
	}
}
