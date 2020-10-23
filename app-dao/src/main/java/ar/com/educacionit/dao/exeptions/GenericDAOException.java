package ar.com.educacionit.dao.exeptions;

public class GenericDAOException extends Exception {

	private static final long serialVersionUID = 711347888192073386L;

	public GenericDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericDAOException(String message) {
		super(message);
	}
}
