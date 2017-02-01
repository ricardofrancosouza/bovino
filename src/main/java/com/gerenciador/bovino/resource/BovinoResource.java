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

import com.gerenciador.bovino.domain.Bovino;
import com.gerenciador.bovino.domain.Statusbovino;
import com.gerenciador.bovino.representation.BovinoRepresentation;
import com.gerenciador.bovino.representation.StatusBovinoRepresentation;
import com.gerenciador.bovino.service.BovinoService;
import com.gerenciador.bovino.service.StatusBovinoService;

@CrossOrigin
@RestController
@RequestMapping("/bovinos")
public class BovinoResource {
	
	@Autowired
	private BovinoService bovinoService;
	
	//private StatusBovinoService statusBovinoservice;	
	
	
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<BovinoRepresentation>> listAll() { 
		
		List<Bovino> bovinos = bovinoService.findAll();
		List<BovinoRepresentation> representation = new ArrayList<>();
		for(Bovino b: bovinos) {
			representation.add(new BovinoRepresentation(b));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<BovinoRepresentation> findById(@PathVariable("id") Integer id){
		
		Bovino bovino = bovinoService.findById(id);
		BovinoRepresentation representation = new BovinoRepresentation(bovino);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody BovinoRepresentation representation) {
//		StatusBovinoService statusBovinoservice = new StatusBovinoService();	
//		StatusBovinoRepresentation statusRepresentation = representation.getStatusbovino();	
//		Statusbovino status = statusBovinoservice.save(StatusBovinoRepresentation.build(statusRepresentation));
//		
//		representation.setStatusbovino(statusRepresentation);
		Bovino bovino = bovinoService.save(BovinoRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bovino.getId_bovino()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody BovinoRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		bovinoService.update(BovinoRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
	
	/////////////////////////////////// 
	/////////////////////// CONSTRUÇAO DE RESOURCES
	/////////////////////////////
	@RequestMapping(value="/semlotes", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<BovinoRepresentation>> findbySemLote() { 
		
		List<Bovino> bovinos = bovinoService.findbySemLote();
		List<BovinoRepresentation> representation = new ArrayList<>();
		for(Bovino b: bovinos) {
			representation.add(new BovinoRepresentation(b));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
}
