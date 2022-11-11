package com.springblog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springblog.payload.ResponseApi;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseApi> resourceNotFountExceptionHandler(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ResponseApi responseApi = new ResponseApi(message,false);
		return new ResponseEntity<ResponseApi>(responseApi,HttpStatus.NOT_FOUND);
		
	}
}
