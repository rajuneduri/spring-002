package com.example.demo.Error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseBody
	public ErrorMessage studentNotFound(StudentNotFoundException studentException) {
		ErrorMessage errMsg=new ErrorMessage(studentException.getMessage(),HttpStatus.NOT_FOUND);
		return errMsg;
	}
	@ExceptionHandler(InvalidTypeErrorException.class)
	@ResponseBody
	public ErrorMessage invalidType(InvalidTypeErrorException invalidException) {
		ErrorMessage E=new ErrorMessage(invalidException.getMessage(),HttpStatus.BAD_REQUEST);
		return E;
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessage Ea=new ErrorMessage();
		return new ResponseEntity(Ea.getMessage(),HttpStatus.BAD_REQUEST);

	}
	
}
