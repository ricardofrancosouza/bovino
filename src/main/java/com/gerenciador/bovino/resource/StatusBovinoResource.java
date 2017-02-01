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

import com.gerenciador.bovino.domain.Statusbovino;
import com.gerenciador.bovino.representation.StatusBovinoRepresentation;
import com.gerenciador.bovino.service.StatusBovinoService;

@CrossOrigin
@RestController
@RequestMapping("/statusbovinos")
public class StatusBovinoResource {
	
	@Autowired
	private StatusBovinoService statusBovinoService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<StatusBovinoRepresentation>> listAll() { 
		
		List<Statusbovino> statusBovinos = statusBovinoService.findAll();
		List<StatusBovinoRepresentation> representation = new ArrayList<>();
		for(Statusbovino l: statusBovinos) {
			representation.add(new StatusBovinoRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<StatusBovinoRepresentation> findById(@PathVariable("id") Integer id){
		
		Statusbovino statusBovino = statusBovinoService.findById(id);
		StatusBovinoRepresentation representation = new StatusBovinoRepresentation(statusBovino);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody StatusBovinoRepresentation representation) {
		
		Statusbovino statusBovino = statusBovinoService.save(StatusBovinoRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(statusBovino.getIdStatus()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody StatusBovinoRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		statusBovinoService.update(StatusBovinoRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
	
}
