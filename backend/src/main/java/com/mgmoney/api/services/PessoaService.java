package com.mgmoney.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mgmoney.api.entities.Pessoa;
import com.mgmoney.api.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Transactional
	public Pessoa criar(Pessoa pessoa) {
		
		//Pessoa pessoa = new Pessoa();
		
		//dtoParaEntidade(pessoa, dto);
		
		pessoa= pessoaRepository.save(pessoa);
		
		return pessoa;
	}

	/*
	private void dtoParaEntidade(Pessoa pessoa, PessoaDTO dto) {
		
		pessoa.setAtivo(dto.isAtivo());
		pessoa.setNome(dto.getNome());
		
		
		if(dto.getEndereco() != null){
			
			pessoa.getEndereco().setBairro(dto.getEndereco().getBairro());
			pessoa.getEndereco().setCep(dto.getEndereco().getCep());
			pessoa.getEndereco().setCidade(dto.getEndereco().getCidade());
			pessoa.getEndereco().setEstado(dto.getEndereco().getEstado());
			pessoa.getEndereco().setLogradouro(dto.getEndereco().getLogradouro());
			pessoa.getEndereco().setNumero(dto.getEndereco().getNumero());
			
			if(dto.getEndereco().getComplemento() != null){
				
				pessoa.getEndereco().setComplemento(dto.getEndereco().getComplemento());
				
			}
			
			
		}
		
	}
	*/

}
