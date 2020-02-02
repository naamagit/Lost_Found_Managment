package lostandfound.excpetion;

public class NoDataFoundExcpetion extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoDataFoundExcpetion(String id) {
		super("User id " + id + " not found  ");
	}

	public NoDataFoundExcpetion(int id) {
		super("Item type " + id + " not found  ");
	}

}
