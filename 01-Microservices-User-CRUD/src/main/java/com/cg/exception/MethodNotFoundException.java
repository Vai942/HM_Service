package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class MethodNotFoundException extends Exception {
	public MethodNotFoundException(String message) {
		super(message);
	}

}
