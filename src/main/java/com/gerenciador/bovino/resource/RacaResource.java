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

import com.gerenciador.bovino.domain.Raca;
import com.gerenciador.bovino.representation.RacaRepresentation;
import com.gerenciador.bovino.service.RacaService;

@CrossOrigin
@RestController
@RequestMapping("/racas")
public class RacaResource {
	
	@Autowired
	private RacaService racaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<RacaRepresentation>> listAll() { 
		
		List<Raca> racas = racaService.findAll();
		List<RacaRepresentation> representation = new ArrayList<>();
		for(Raca l: racas) {
			representation.add(new RacaRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<RacaRepresentation> findById(@PathVariable("id") Integer id){
		
		Raca raca = racaService.findById(id);
		RacaRepresentation representation = new RacaRepresentation(raca);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody RacaRepresentation representation) {
		
		Raca raca = racaService.save(RacaRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(raca.getIdRaca()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody RacaRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		racaService.update(RacaRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
	
}
