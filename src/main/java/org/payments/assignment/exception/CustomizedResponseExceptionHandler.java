package org.payments.assignment.exception;

import java.util.Date;
import org.payments.assignment.entity.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * @author SHUBHAM
 *  This class handles all the exceptions and organize the response that needs to be communicated to the user for every exception.
 *
 */
@ControllerAdvice
@RestController
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InsufficientFundsException.class)
	public final ResponseEntity<ErrorDetails> handleInsufficientFundsException(Exception ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleAccountNotFoundException(Exception ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AccountAlreadyExistException.class)
	public final ResponseEntity<ErrorDetails> handleAccountAlreadyExistException(Exception ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ValidationException.class)
		public final ResponseEntity<ErrorDetails> handleValidationException(Exception ex, WebRequest request){
			ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));
			return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
}
