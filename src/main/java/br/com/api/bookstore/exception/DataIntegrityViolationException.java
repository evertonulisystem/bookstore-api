package br.com.api.bookstore.exception;

public class DataIntegrityViolationException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationException(String message, Throwable cause) { //mensagem e causa(throwable
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataIntegrityViolationException(String message) {//apenas a mensagem de erro
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
