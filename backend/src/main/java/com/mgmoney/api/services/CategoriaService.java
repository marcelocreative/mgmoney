package com.mgmoney.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mgmoney.api.dto.CategoriaDTO;
import com.mgmoney.api.entities.Categoria;
import com.mgmoney.api.repositories.CategoriaRepository;
import com.mgmoney.api.services.exceptions.RecursoNaoEncontradoException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional(readOnly= true)
	public List<CategoriaDTO> listar() {
		
		return categoriaRepository.findAll().stream().map(x -> new CategoriaDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly= true)
	public CategoriaDTO buscarPeloCodigo(Long codigo) {
		
		try{
			Categoria entity = categoriaRepository.findOne(codigo);
			return new CategoriaDTO(entity);
		}catch (NullPointerException e) {
			
			throw new RecursoNaoEncontradoException("Recurso não encontrado");
			
		}
		
	}

	@Transactional
	public CategoriaDTO criar(CategoriaDTO dto) {
			
			Categoria categoria= new Categoria();
			
			dtoParaEntidade(dto, categoria);
			
			categoria = categoriaRepository.save(categoria);
			
			return new CategoriaDTO(categoria);
	
	
	}

	private void dtoParaEntidade(CategoriaDTO dto, Categoria categoria) {
		
		categoria.setNome(dto.getNome());
		
	}


}
