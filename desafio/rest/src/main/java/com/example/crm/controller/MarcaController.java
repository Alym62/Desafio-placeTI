package com.example.crm.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.crm.model.Marca;
import com.example.crm.repository.MarcaRepository;

import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@GetMapping
	public List<Marca> listar() {
		return marcaRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Marca adicionar(@RequestBody Marca marca) {
		return marcaRepository.save(marca);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		marcaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Marca> atualizar(@PathVariable Long id, @RequestBody Marca marca){
		if(!marcaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		marca.setId(id);
		marca = marcaRepository.save(marca);
		return ResponseEntity.ok(marca);
	}
}
