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

import com.gerenciador.bovino.domain.Nascimento;
import com.gerenciador.bovino.representation.NascimentoRepresentation;
import com.gerenciador.bovino.service.NascimentoService;

@CrossOrigin
@RestController
@RequestMapping("/nascimentos")
public class NascimentoResource {
	
	@Autowired
	private NascimentoService nascimentoService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<NascimentoRepresentation>> listAll() { 
		
		List<Nascimento> nascimentos = nascimentoService.findAll();
		List<NascimentoRepresentation> representation = new ArrayList<>();
		for(Nascimento l: nascimentos) {
			representation.add(new NascimentoRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<NascimentoRepresentation> findById(@PathVariable("id") Integer id){
		
		Nascimento nascimento = nascimentoService.findById(id);
		NascimentoRepresentation representation = new NascimentoRepresentation(nascimento);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody NascimentoRepresentation representation) {
		
		Nascimento nascimento = nascimentoService.save(NascimentoRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nascimento.getIdNascimento()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody NascimentoRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		nascimentoService.update(NascimentoRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
	
}
