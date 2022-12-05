package helper;

public class HelperException extends Exception{
	
	
	private static final long serialVersionUID = 1L;

	public HelperException(String message) {
		super(message);
	}
	
	public HelperException(Throwable ex) {
		super(ex);
	}
	
	public HelperException(String message,Throwable ex) {
		super(message,ex);
	}
	
}
