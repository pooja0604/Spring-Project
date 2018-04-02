package com.app.test.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlingAdvice {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public @ResponseBody ResponseEntity<List<String>> handleMethodArgumentNotValidExceptoin(
			MethodArgumentNotValidException me) {
		List<ObjectError> errors = me.getBindingResult().getAllErrors();
		List<String> messages = new ArrayList<>();
		for (ObjectError objectError : errors) {
			messages.add(objectError.getDefaultMessage());
		}
		return new ResponseEntity<List<String>>(messages, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public @ResponseBody ResponseEntity<List<String>> handleExceptoin(Exception e) {
		List<String> messages = new ArrayList<>();
		messages.add(e.getMessage());
		return new ResponseEntity<List<String>>(messages, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
