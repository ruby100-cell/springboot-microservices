package net.javaguides.departmentservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, 
			WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 
				exception.getMessage(), request.getDescription(false), 
				"DEPARTMENT_NOT_FOUND");
				return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(DepartmentAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handleDepartmentAlreadyExistException(DepartmentAlreadyExistException exception, 
			WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 
				exception.getMessage(), request.getDescription(false), 
				"DEPARTMENT_ALREADY_EXISTS");
				return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, 
			WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), 
				exception.getMessage(), request.getDescription(false), 
				"INTERNAL_SERVER_ERROR");
				return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);	
	}

}
