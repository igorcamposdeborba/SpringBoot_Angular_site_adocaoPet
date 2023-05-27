package com.adocao.pet.services.exceptions;

public class NullPointerException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	
	public NullPointerException(String message, Throwable cause) {
		super(message, cause);
	}

	public NullPointerException(String message) {
		super(message);
	}
}
