package ar.com.educacionit.service.exeptions;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 5984044248138922464L;

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}
	
}
