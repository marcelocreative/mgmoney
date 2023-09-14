package com.mgmoney.api.controllers.handlers;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mgmoney.api.services.exceptions.RecursoNaoEncontradoException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<CustomError> recursoNaoEncontrado(RecursoNaoEncontradoException e, HttpServletRequest request){
		
		HttpStatus status= HttpStatus.NOT_FOUND;
		CustomError erro= new CustomError(Instant.now(), status.value(), "Código inválido", request.getRequestURI(), e.getMessage());
		
		return ResponseEntity.status(status).body(erro);
	}
	
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<CustomError> campoNaoReconhecido(HttpMessageNotReadableException e, HttpServletRequest request){
		
		HttpStatus status= HttpStatus.BAD_REQUEST;
		CustomError erro= new CustomError(Instant.now(), status.value(), "Campo(s) não reconhecido(s)", request.getRequestURI(), e.getMessage());
		
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> erroDeValidacao(MethodArgumentNotValidException e, HttpServletRequest request){
		
		HttpStatus status= HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationError erro= new ValidationError();
		
		erro.setCaminho(request.getRequestURI());
		erro.setErro("Exceção de validação de campos");
		erro.setInstante(Instant.now());
		erro.setMensagem(e.getMessage());
		erro.setStatus(status.value());
		
		for(FieldError erroCampo: e.getBindingResult().getFieldErrors()){
			
			erro.adicionarErros(erroCampo.getField(), erroCampo.getDefaultMessage());
		}
		
		return ResponseEntity.status(status).body(erro);
	}

}
