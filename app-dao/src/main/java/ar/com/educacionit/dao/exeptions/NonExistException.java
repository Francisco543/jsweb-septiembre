package ar.com.educacionit.dao.exeptions;

public class NonExistException extends Exception {

	private static final long serialVersionUID = 5848176307510836990L;

	public NonExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonExistException(String message) {
		super(message);
	}
	
	//ctrl+D
}
