package com.adocao.pet.controllers.exceptions;

import java.io.Serializable;

// Superclasse: campos do erro para a classe ValidationError implementar
public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

	public StandardError() {
		super();
	}
	
	public StandardError(String timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public Integer getStatus() {
		return status;
	}
	public String getError() {
		return error;
	}
	public String getMessage() {
		return message;
	}
	public String getPath() {
		return path;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setError(String error) {
		this.error = error;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
