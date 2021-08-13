package com.loja.games.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.games.gsrepository.gamesRepository;
import com.loja.games.model.games;

@RestController
@RequestMapping("/games")
public class Controller {
	
	@Autowired
	private gamesRepository repository;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodos () {
		List<games> listgames = repository.findAll();
		
		if (listgames.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).build();
		}
	}

	
	@GetMapping("games/{titulo}")
	public ResponseEntity<List<games>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<games> post (@RequestBody games games){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(games));
		
	}
	
	@PutMapping
	public ResponseEntity<games> put (@RequestBody games games){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(games));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
}
