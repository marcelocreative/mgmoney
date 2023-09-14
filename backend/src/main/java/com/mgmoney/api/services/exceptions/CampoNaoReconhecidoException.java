package com.mgmoney.api.services.exceptions;

public class CampoNaoReconhecidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CampoNaoReconhecidoException(String msg){
		
		super(msg);
		
	}

}
