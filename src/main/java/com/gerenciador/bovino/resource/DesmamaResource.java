package com.gerenciador.bovino.resource;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerenciador.bovino.domain.Desmama;
import com.gerenciador.bovino.representation.DesmamaRepresentation;
import com.gerenciador.bovino.service.DesmamaService;

//@CrossOrigin
@RestController
@RequestMapping("/desmamas")
public class DesmamaResource {
	
	@Autowired
	private DesmamaService desmamaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<DesmamaRepresentation>> listAll() { 
		
		List<Desmama> desmama = desmamaService.findAll();
		List<DesmamaRepresentation> representation = new ArrayList<>();
		for(Desmama l: desmama) {
			representation.add(new DesmamaRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<DesmamaRepresentation> findById(@PathVariable("id") Integer id){
		
		Desmama desmama = desmamaService.findById(id);
		DesmamaRepresentation representation = new DesmamaRepresentation(desmama);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody DesmamaRepresentation representation) {
		Desmama desmama = desmamaService.save(DesmamaRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(desmama.getIdDesmama()).toUri();
		return ResponseEntity.created(uri).build();
	} 
	

	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody DesmamaRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		desmamaService.update(DesmamaRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity< DesmamaRepresentation> delete(@PathVariable("id") Integer id) {
		
		 Desmama desmama = desmamaService.findById(id);
		 DesmamaRepresentation representation = new  DesmamaRepresentation(desmama);
		 desmamaService.delete(desmama);
		
		
		return ResponseEntity.ok(representation);
	} 	
	
	
}
