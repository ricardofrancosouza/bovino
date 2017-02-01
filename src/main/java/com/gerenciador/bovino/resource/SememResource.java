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

import com.gerenciador.bovino.domain.Peso;
import com.gerenciador.bovino.domain.Semem;
import com.gerenciador.bovino.representation.PesoRepresentation;
import com.gerenciador.bovino.representation.SememRepresentation;
import com.gerenciador.bovino.service.SememService;

@CrossOrigin
@RestController
@RequestMapping("/semens")
public class SememResource {
	
	@Autowired
	private SememService sememService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<SememRepresentation>> listAll() { 
		
		List<Semem> semens = sememService.findAll();
		List<SememRepresentation> representation = new ArrayList<>();
		for(Semem l: semens) {
			representation.add(new SememRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<SememRepresentation> findById(@PathVariable("id") Integer id){
		
		Semem semem = sememService.findById(id);
		SememRepresentation representation = new SememRepresentation(semem);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody SememRepresentation representation) {
		
		Semem semem = sememService.save(SememRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(semem.getIdSemem()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody SememRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		sememService.update(SememRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
///////////////////////////////////////////////
	/////////////////// Consultas
	/////////////////
	
	
	@RequestMapping(value="/semensbovino/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<List<SememRepresentation>> findBySemensBovino( @PathVariable("id") Integer id) {
		
		List<Semem> semens = sememService.findBySemensBovino(id);
		List< SememRepresentation> representation = new ArrayList<>();
		for(Semem semem: semens)
		{
			representation.add(new SememRepresentation(semem));
		}
		return ResponseEntity.ok(representation);
	} 
	
	
}
