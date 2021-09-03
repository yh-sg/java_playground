package exception;

public class InvalidStatementException extends Exception {
	InvalidStatementException(String message) {
		super(message);
	}
	
	//Chained Exception
	public InvalidStatementException(String message, Exception e) {
		super(message, e);
	}
}
