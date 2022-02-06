package br.com.api.bookstore.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ErrorMessage> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
		//ErrorMessage error = new ErrorMessage(System.currentTimeMillis(),HttpStatus.NOT_FOUND.value(), e.getMessage());
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
