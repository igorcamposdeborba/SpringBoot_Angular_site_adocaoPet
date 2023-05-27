package com.adocao.pet.controllers.exceptions;

import java.text.SimpleDateFormat;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.adocao.pet.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // controller das mensagens de exception (manipulador de exceções)
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException exception, HttpServletRequest request){
		
		// formatar data
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String instantNow = simpleDateFormat.format(Instant.now().toEpochMilli());
		
		StandardError error = new StandardError(instantNow,
												 HttpStatus.NOT_FOUND.value(),
												 "Object not found",
												 exception.getMessage(),
												 request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}