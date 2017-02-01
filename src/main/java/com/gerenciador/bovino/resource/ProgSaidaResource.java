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

import com.gerenciador.bovino.domain.Progsaida;
import com.gerenciador.bovino.representation.ProgSaidaRepresentation;
import com.gerenciador.bovino.service.ProgSaidaService;

@CrossOrigin
@RestController
@RequestMapping("/progsaidas")
public class ProgSaidaResource {
	
	@Autowired
	private ProgSaidaService ProgSaidaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<ProgSaidaRepresentation>> listAll() { 
		
		List<Progsaida> progSaidas = ProgSaidaService.findAll();
		List<ProgSaidaRepresentation> representation = new ArrayList<>();
		for(Progsaida l: progSaidas) {
			representation.add(new ProgSaidaRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<ProgSaidaRepresentation> findById(@PathVariable("id") Integer id){
		
		Progsaida progSaida = ProgSaidaService.findById(id);
		ProgSaidaRepresentation representation = new ProgSaidaRepresentation(progSaida);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody ProgSaidaRepresentation representation) {
		
		Progsaida progSaida = ProgSaidaService.save(ProgSaidaRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(progSaida.getIdProgsaida()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody ProgSaidaRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		ProgSaidaService.update(ProgSaidaRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
	
}
