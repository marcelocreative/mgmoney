package com.mgmoney.api.dto;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.mgmoney.api.entities.Categoria;

public class CategoriaDTO {
	
	private Long codigo;
	
	@Size(min= 5, max=50, message= "Nome tem que ter entre 5 e 50 caracteres")
	@NotBlank(message= "Campo quererido")
	private String nome;
	
	public CategoriaDTO() {
		
	}
	
	public CategoriaDTO(Long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public CategoriaDTO(Categoria entidade) {
		codigo = entidade.getCodigo();
		nome = entidade.getNome();
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}
	
	

}
