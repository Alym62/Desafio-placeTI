package com.example.crm.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.crm.model.Modelo;
import com.example.crm.repository.ModeloRepository;


@RestController
@RequestMapping("/modelos")
public class ModeloController {
	
	@Autowired
	private ModeloRepository modeloRepository;
	
	@GetMapping
	public List<Modelo> listar(){
		return modeloRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Modelo> adicionar(@RequestBody Modelo modelo) {
		Modelo novoModelo = modeloRepository.save(modelo);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoModelo);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		modeloRepository.deleteById(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Modelo> atualizar(@PathVariable Long id, @RequestBody Modelo modelo){
		if(!modeloRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		modelo.setId(id);
		modelo = modeloRepository.save(modelo);
		return ResponseEntity.ok(modelo);
	}
	
}
