package com.adocao.pet.services.exceptions;

// Exception personalizada que mostra causa do erro e mensagem
// Para POST e PUT no banco de dados 
public class DataIntegrityViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;	
	
	
	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityViolationException(String message) {
		super(message);
	}
}