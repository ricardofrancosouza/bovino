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

import com.gerenciador.bovino.domain.Saidabovino;
import com.gerenciador.bovino.representation.SaidaBovinoRepresentation;
import com.gerenciador.bovino.service.SaidaBovinoService;

@CrossOrigin
@RestController
@RequestMapping("/saidasbovinos")
public class SaidaBovinoResource {
	
	@Autowired
	private SaidaBovinoService SaidaBovinoService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<SaidaBovinoRepresentation>> listAll() { 
		
		List<Saidabovino> saidasBovinos = SaidaBovinoService.findAll();
		List<SaidaBovinoRepresentation> representation = new ArrayList<>();
		for(Saidabovino l: saidasBovinos) {
			representation.add(new SaidaBovinoRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<SaidaBovinoRepresentation> findById(@PathVariable("id") Integer id){
		
		Saidabovino saidaBovino = SaidaBovinoService.findById(id);
		SaidaBovinoRepresentation representation = new SaidaBovinoRepresentation(saidaBovino);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody SaidaBovinoRepresentation representation) {
		
		Saidabovino saidaBovino = SaidaBovinoService.save(SaidaBovinoRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saidaBovino.getIdSaida()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody SaidaBovinoRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		SaidaBovinoService.update(SaidaBovinoRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
	
}
