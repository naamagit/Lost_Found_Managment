package lostandfound.exception;

public class NoDataFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoDataFoundException(String id) {
		super("User id " + id + " not found  ");
	}

	public NoDataFoundException(int id) {
		super("Item type " + id + " not found  ");
	}

}
