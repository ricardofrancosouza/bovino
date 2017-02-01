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

import com.gerenciador.bovino.domain.Entradasemem;
import com.gerenciador.bovino.representation.EntradaSememRepresentation;
import com.gerenciador.bovino.service.EntradaSememService;

@CrossOrigin
@RestController
@RequestMapping("/entradassemens")
public class EntradaSememResource {
	
	@Autowired
	private EntradaSememService entradaSememService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<EntradaSememRepresentation>> listAll() { 
		
		List<Entradasemem> entradaSemem = entradaSememService.findAll();
		List<EntradaSememRepresentation> representation = new ArrayList<>();
		for(Entradasemem l: entradaSemem) {
			representation.add(new EntradaSememRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<EntradaSememRepresentation> findById(@PathVariable("id") Integer id){
		
		Entradasemem entradaSemem = entradaSememService.findById(id);
		EntradaSememRepresentation representation = new EntradaSememRepresentation(entradaSemem);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody EntradaSememRepresentation representation) {
		
		Entradasemem entradaSemem = entradaSememService.save(EntradaSememRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entradaSemem.getIdEntrada()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody EntradaSememRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		entradaSememService.update(EntradaSememRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
	
}
