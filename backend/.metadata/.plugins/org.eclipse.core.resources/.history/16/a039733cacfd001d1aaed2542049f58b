package com.adocao.pet.controllers.exceptions;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

// Subclasse ValidationError que junta os atributos do ERRO + a MENSAGEM de erro
public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new LinkedList<FieldMessage>();
	
	public ValidationError() {
		super();
	}
	
	public ValidationError(String timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path); // campo do ERRO
	}
	
	
	public List<FieldMessage> getErrors(){
		return errors;
	}
	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message)); // campos da MENSAGEM de erro
	}
	
}
