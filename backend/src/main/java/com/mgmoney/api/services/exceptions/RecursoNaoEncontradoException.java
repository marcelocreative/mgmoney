package com.mgmoney.api.services.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public RecursoNaoEncontradoException(String msg){
		
		super(msg);
		
	}

}
