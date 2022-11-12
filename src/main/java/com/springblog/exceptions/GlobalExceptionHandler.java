package com.springblog.exceptions;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springblog.payload.ResponseApi;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseApi> handleResourceNotFountExceptionHandler(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ResponseApi responseApi = new ResponseApi(message, false);
		return new ResponseEntity<ResponseApi>(responseApi, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handlerMethodArgNotValidException(MethodArgumentNotValidException ex) {

		Map<String, String> resp = new HashMap<>();

		// Extract error for each field when validation fails.
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});

		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, String>> handlerConstraintViolationException(ConstraintViolationException ex) {

		Map<String, String> resp = new HashMap<>();

		// Extract error for each field when validation fails.
		ex.getConstraintViolations().forEach(error -> {
			String fieldName = (String) error.getInvalidValue();
			String message = error.getMessage();
			resp.put(fieldName, message);
		});

		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}
}
