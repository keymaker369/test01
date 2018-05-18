package com.example.test01.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.*;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {
	
	public ForbiddenException(String message) {
		super(message);
	}
}
