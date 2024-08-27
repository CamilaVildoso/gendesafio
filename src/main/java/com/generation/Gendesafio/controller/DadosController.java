package com.generation.Gendesafio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.Gendesafio.model.Dados;
import com.generation.Gendesafio.repository.DadosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/dados")
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class DadosController {

	@Autowired
	private DadosRepository dadosRepository;
	
	@GetMapping
	public ResponseEntity<List<Dados>> getAll(){
		return ResponseEntity.ok(dadosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dados> getById(@PathVariable Long id){
		return dadosRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping
	public ResponseEntity<Dados> post(@Valid @RequestBody Dados dados){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(dadosRepository.save(dados));
	}
	
	@PutMapping
	public ResponseEntity<Dados> put(@Valid @RequestBody Dados dados){
		return dadosRepository.findById(dados.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(dadosRepository.save(dados)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Dados> dados = dadosRepository.findById(id);
		
		if(dados.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		dadosRepository.deleteById(id);
	}
}
