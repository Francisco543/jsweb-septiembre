package ar.com.educacionit.dao.exeptions;

public class DuplicatedException extends Exception {

	private static final long serialVersionUID = -6849007456104279863L;

	public DuplicatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicatedException(String message) {
		super(message);
	}
	
}
