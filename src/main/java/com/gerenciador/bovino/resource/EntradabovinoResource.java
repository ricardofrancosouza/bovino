package com.gerenciador.bovino.resource;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerenciador.bovino.domain.Entradabovino;
import com.gerenciador.bovino.representation.EntradaBovinoRepresentation;
import com.gerenciador.bovino.service.EntradaBovinoService;

@CrossOrigin
@RestController
@RequestMapping("/entradasbovinos")
public class EntradabovinoResource {
	
	@Autowired
	private EntradaBovinoService entradaBovinoService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<EntradaBovinoRepresentation>> listAll() { 
		
		List<Entradabovino> entradabovino = entradaBovinoService.findAll();
		List<EntradaBovinoRepresentation> representation = new ArrayList<>();
		for(Entradabovino l: entradabovino) {
			representation.add(new EntradaBovinoRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<EntradaBovinoRepresentation> findById(@PathVariable("id") Integer id){
		
		Entradabovino entradabovino = entradaBovinoService.findById(id);
		EntradaBovinoRepresentation representation = new EntradaBovinoRepresentation(entradabovino);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody EntradaBovinoRepresentation representation) {
		
		Entradabovino entradabovino = entradaBovinoService.save(EntradaBovinoRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entradabovino.getIdEntradabov()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody EntradaBovinoRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		entradaBovinoService.update(EntradaBovinoRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
	
}
