/**
 * @author AMBARISH DATAR
 *
 */
package com.cg.aps.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = DatabaseException.class)
	public ResponseEntity<Object> handleDatabaseException(DatabaseException exception,WebRequest webRequest) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());

		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(RecordNotFoundException exception,WebRequest webRequest) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(404);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());

		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = DuplicateRecordException.class)
	public ResponseEntity<Object> handleDuplicateRecordException(DuplicateRecordException exception,WebRequest webRequest) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setStatus(406);
		exceptionResponse.setTime(LocalDateTime.now());
		exceptionResponse.setMessage(exception.getMessage());

		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}
}