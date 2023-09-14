package com.mgmoney.api.controllers.handlers;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError {

	private List<FieldMessage> erros= new ArrayList<>();

	public List<FieldMessage> getErros() {
		return erros;
	}
	
	public void adicionarErros(String nomeCampo, String mensagem){
		
		erros.add(new FieldMessage(nomeCampo, mensagem));
		
	}

}
