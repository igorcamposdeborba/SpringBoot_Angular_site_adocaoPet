package com.adocao.pet.services.exceptions;

// Exception personalizada que mostra causa do erro e mensagem
// Para GET no banco de dados
public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;	
	
	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}
}
