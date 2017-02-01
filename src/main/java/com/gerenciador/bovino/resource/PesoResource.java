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
import com.gerenciador.bovino.representation.PesoRepresentation;
import com.gerenciador.bovino.service.PesoService;

@CrossOrigin
@RestController
@RequestMapping("/pesos")
public class PesoResource {
	
	@Autowired
	private PesoService pesoService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<PesoRepresentation>> listAll() { 
		
		List<Peso> pesos = pesoService.findAll();
		List<PesoRepresentation> representation = new ArrayList<>();
		for(Peso l: pesos) {
			representation.add(new PesoRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<PesoRepresentation> findById(@PathVariable("id") Integer id){
		
		Peso peso = pesoService.findById(id);
		PesoRepresentation representation = new PesoRepresentation(peso);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody PesoRepresentation representation) {
		
		Peso peso = pesoService.save(PesoRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(peso.getIdPeso()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody PesoRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		pesoService.update(PesoRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
	
	
	////////////////////////////////////////
	//////////// CONSULTAS //////////////
	//////////////////////////////////////
	
	@RequestMapping(value="/pesosbov/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<List<PesoRepresentation>> findByPesoBovino( @PathVariable("id") Integer id) {
		
		List<Peso> pesos = pesoService.pesoByBovinoPesos(id);
		List< PesoRepresentation> representation = new ArrayList<>();
		for(Peso peso: pesos)
		{
			representation.add(new PesoRepresentation(peso));
		}
		return ResponseEntity.ok(representation);
	} 
	
	
	
}
