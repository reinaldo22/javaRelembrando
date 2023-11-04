package com.crud.postgres.reinaldo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OverFlowHandle {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorObject> handleException(CustomException c) {

		ErrorObject errorObject = new ErrorObject(c.getMessage(), c.getHttpStatus().value());
		return ResponseEntity.status(c.getHttpStatus()).body(errorObject);
	}

}
