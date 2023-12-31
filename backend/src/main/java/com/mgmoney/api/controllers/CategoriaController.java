package com.mgmoney.api.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mgmoney.api.dto.CategoriaDTO;
import com.mgmoney.api.services.CategoriaService;


@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> listar(){
		
		List<CategoriaDTO> lista = categoriaService.listar();
		
		return ResponseEntity.ok(lista);
		
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<CategoriaDTO> buscarPeloCodigo(@PathVariable Long codigo){
		
		CategoriaDTO dto = categoriaService.buscarPeloCodigo(codigo);
		
		return ResponseEntity.ok(dto);
				
	}
	
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> criar(@Valid @RequestBody CategoriaDTO dto) {
	
		dto = categoriaService.criar(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{codigo}").buildAndExpand(dto.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
		
	
}
