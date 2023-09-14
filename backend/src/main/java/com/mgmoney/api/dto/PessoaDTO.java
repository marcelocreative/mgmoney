package com.mgmoney.api.dto;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.mgmoney.api.entities.Endereco;
import com.mgmoney.api.entities.Pessoa;

public class PessoaDTO {
	
	private Long codigo;
	
	@NotBlank(message= "Campo requerido")
	@Size(min= 5, max= 50, message= "Nome tem que ter entre 5 e 50 caracteres")
	private String nome;
	
	@NotNull(message="Campo requerido")
	private Boolean ativo;
	
	@Embedded
	private Endereco endereco= new Endereco();

	public PessoaDTO() {
		
	}

	public PessoaDTO(Long codigo, String nome, boolean ativo) {
		this.codigo = codigo;
		this.nome = nome;
		this.ativo = ativo;
	}
	
	public PessoaDTO(Long codigo, String nome, Boolean ativo, Endereco endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.ativo = ativo;
		this.endereco = endereco;
	}
	
	
	
	public PessoaDTO(Pessoa pessoa) {
		codigo = pessoa.getCodigo();
		nome = pessoa.getNome();
		ativo = pessoa.isAtivo();
		
		if(pessoa.getEndereco() != null){
			endereco.setBairro(pessoa.getEndereco().getBairro());
			endereco.setCep(pessoa.getEndereco().getCep());
			endereco.setCidade(pessoa.getEndereco().getCidade());
			endereco.setEstado(pessoa.getEndereco().getEstado());
			endereco.setLogradouro(pessoa.getEndereco().getLogradouro());
			endereco.setNumero(pessoa.getEndereco().getNumero());
			
			if(pessoa.getEndereco().getComplemento() != null){
				endereco.setComplemento(pessoa.getEndereco().getComplemento());
			}
			
			
		}
		
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public boolean isAtivo() {
		return ativo;
	}
	
	/*
	public Endereco getEndereco() {
		return endereco;
	}
	*/
	
	public Endereco getEndereco() {
		return endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaDTO other = (PessoaDTO) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
