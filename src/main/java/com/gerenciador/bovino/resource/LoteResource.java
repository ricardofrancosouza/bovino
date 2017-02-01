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

import com.gerenciador.bovino.domain.Lote;
import com.gerenciador.bovino.representation.LoteRepresentation;
import com.gerenciador.bovino.service.LoteService;

@CrossOrigin
@RestController
@RequestMapping("/lotes")
public class LoteResource {
	
	@Autowired
	private LoteService loteService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<LoteRepresentation>> listAll() { 
		
		List<Lote> lote = loteService.findAll();
		List<LoteRepresentation> representation = new ArrayList<>();
		for(Lote l: lote) {
			representation.add(new LoteRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<LoteRepresentation> findById(@PathVariable("id") Integer id){
		
		Lote lote = loteService.findById(id);
		LoteRepresentation representation = new LoteRepresentation(lote);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody LoteRepresentation representation) {
		
		Lote lote = loteService.save(LoteRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lote.getIdLote()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody LoteRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		loteService.update(LoteRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
	
}
