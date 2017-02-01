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

import com.gerenciador.bovino.domain.Notafiscal;
import com.gerenciador.bovino.representation.NotaFiscalRepresentation;
import com.gerenciador.bovino.service.NotaFiscalService;

@CrossOrigin
@RestController
@RequestMapping("/notaFiscals")
public class NotaFiscalResource {
	
	@Autowired
	private NotaFiscalService NotaFiscalService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<NotaFiscalRepresentation>> listAll() { 
		
		List<Notafiscal> notasfiscais = NotaFiscalService.findAll();
		List<NotaFiscalRepresentation> representation = new ArrayList<>();
		for(Notafiscal l: notasfiscais) {
			representation.add(new NotaFiscalRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<NotaFiscalRepresentation> findById(@PathVariable("id") Integer id){
		
		Notafiscal notaFiscal = NotaFiscalService.findById(id);
		NotaFiscalRepresentation representation = new NotaFiscalRepresentation(notaFiscal);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody NotaFiscalRepresentation representation) {
		
		Notafiscal notaFiscal = NotaFiscalService.save(NotaFiscalRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(notaFiscal.getIdNotafiscal()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody NotaFiscalRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		NotaFiscalService.update(NotaFiscalRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
	
}
