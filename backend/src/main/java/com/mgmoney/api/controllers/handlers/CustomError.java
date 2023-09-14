package com.mgmoney.api.controllers.handlers;

import java.time.Instant;

public class CustomError {
	
	private Instant instante;
	private Integer status;
	private String erro;
	private String caminho;
	private String mensagem;
	
	public CustomError() {
	
	}
	
	public CustomError(Instant instante, Integer status, String erro, String caminho, String mensagem) {
		this.instante = instante;
		this.status = status;
		this.erro = erro;
		this.caminho = caminho;
		this.mensagem = mensagem;
	}

	public Instant getInstante() {
		return instante;
	}

	public Integer getStatus() {
		return status;
	}

	public String getErro() {
		return erro;
	}

	public String getCaminho() {
		return caminho;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setInstante(Instant instante) {
		this.instante = instante;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
