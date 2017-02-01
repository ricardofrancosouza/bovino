package com.gerenciador.bovino.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gerenciador.bovino.exception.BovinoAlreadyExistException;
import com.gerenciador.bovino.exception.BovinoNotFoundException;

@Controller
@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(BovinoNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerPessoaNotFoundException(BovinoNotFoundException e,HttpServletRequest request) 
	{

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(404l);
		error.setTitle("Bovino not found.");
		error.setMessage(e.getMessage());
		error.setUrl("http://erros.teste.com/404");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(BovinoAlreadyExistException.class)
	public ResponseEntity<ErrorDetails> handlerPessoaAlreadyExistException(BovinoAlreadyExistException e,
			HttpServletRequest request) {

		e.printStackTrace();

		ErrorDetails error = new ErrorDetails();
		error.setStatus(409l);
		error.setTitle("Pessoa already exist.");
		error.setUrl("http://erros.teste.com/409");
		error.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
}
