package com.mgmoney.api.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mgmoney.api.entities.Pessoa;
import com.mgmoney.api.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa){
		
		pessoa = pessoaService.criar(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("codigo").buildAndExpand(pessoa.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(pessoa);
	}

}
