package com.adocao.pet.controllers.exceptions;

import java.io.Serializable;

// Campos da mensagem de erro para a classe Validation Error para mostrar ao usuário
public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String message;
	
	public FieldMessage() {
		super();
	}
	
	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	public String getMessage() {
		return message;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public void setFieldMessage(String message) {
		this.message = message;
	}
	
}
