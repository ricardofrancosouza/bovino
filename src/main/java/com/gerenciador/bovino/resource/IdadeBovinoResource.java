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

import com.gerenciador.bovino.domain.Idadebovino;
import com.gerenciador.bovino.representation.IdadeBovinoRepresentation;
import com.gerenciador.bovino.service.IdadeBovinoService;

@CrossOrigin
@RestController
@RequestMapping("/idadebovinos")
public class IdadeBovinoResource {
	
	@Autowired
	private IdadeBovinoService idadeBovinoService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<IdadeBovinoRepresentation>> listAll() { 
		
		List<Idadebovino> idadeBovinos = idadeBovinoService.findAll();
		List<IdadeBovinoRepresentation> representation = new ArrayList<>();
		for(Idadebovino l: idadeBovinos) {
			representation.add(new IdadeBovinoRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<IdadeBovinoRepresentation> findById(@PathVariable("id") Integer id){
		
		Idadebovino idadeBovino = idadeBovinoService.findById(id);
		IdadeBovinoRepresentation representation = new IdadeBovinoRepresentation(idadeBovino);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody IdadeBovinoRepresentation representation) {
		
		Idadebovino idadeBovino = idadeBovinoService.save(IdadeBovinoRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(idadeBovino.getIdIdade()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody IdadeBovinoRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		idadeBovinoService.update(IdadeBovinoRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
	
}
