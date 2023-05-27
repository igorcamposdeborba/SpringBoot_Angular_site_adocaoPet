package com.adocao.pet.services.exceptions;

// Exception personalizada que mostra causa do erro e mensagem
//Para validação de valor dos campos de formulário
public class IllegalFormatException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	
	public IllegalFormatException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public IllegalFormatException(String message) {
        super(message);
    }

}
