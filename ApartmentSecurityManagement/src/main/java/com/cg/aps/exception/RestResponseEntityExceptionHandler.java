package com.cg.aps.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler 
								extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value 
			= { NullPointerException.class,
					IllegalArgumentException.class, 
					  IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(
			RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "application-wide unchecked exception:"+ex.getMessage();
		return handleExceptionInternal(ex, bodyOfResponse, 
				new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
	
	@ExceptionHandler(value 
			= { DataIntegrityViolationException.class })
	protected ResponseEntity<Object> handleAnotherConflict(
			Exception ex, WebRequest request) {
		String bodyOfResponse = ex.getMessage();
		return this.handleExceptionInternal(ex, bodyOfResponse, 
				new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
}

