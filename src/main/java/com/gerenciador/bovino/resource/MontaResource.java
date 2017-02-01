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

import com.gerenciador.bovino.domain.Monta;
import com.gerenciador.bovino.domain.Semem;
import com.gerenciador.bovino.representation.MontaRepresentation;
import com.gerenciador.bovino.representation.SememRepresentation;
import com.gerenciador.bovino.service.MontaService;

@CrossOrigin
@RestController
@RequestMapping("/montas")
public class MontaResource {
	
	@Autowired
	private MontaService montaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<List<MontaRepresentation>> listAll() { 
		
		List<Monta> montas = montaService.findAll();
		List<MontaRepresentation> representation = new ArrayList<>();
		for(Monta l: montas) {
			representation.add(new MontaRepresentation(l));
		}
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<MontaRepresentation> findById(@PathVariable("id") Integer id){
		
		Monta monta = montaService.findById(id);
		MontaRepresentation representation = new MontaRepresentation(monta);
		
		return ResponseEntity.ok(representation);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> save(@Valid @RequestBody MontaRepresentation representation) {
		
		Monta monta = montaService.save(MontaRepresentation.build(representation));	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(monta.getIdMonta()).toUri();
		
		return ResponseEntity.created(uri).build();
	} 
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody HttpEntity<Void> update(@RequestBody MontaRepresentation representation, @PathVariable("id") Integer id) {
		
		representation.setIdentifier(id);
		montaService.update(MontaRepresentation.build(representation));	
		
		return ResponseEntity.noContent().build();
	} 
	
///////////////////////////////////////////////
/////////////////// Consultas
/////////////////


@RequestMapping(value="/montasmatriz/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody HttpEntity<List<MontaRepresentation>> findByMontasBovino( @PathVariable("id") Integer id) {

List<Monta> montas = montaService.findByMontasMatriz(id);
List< MontaRepresentation> representation = new ArrayList<>();
for(Monta monta: montas)
{
representation.add(new MontaRepresentation(monta));
}
return ResponseEntity.ok(representation);
} 

@RequestMapping(value="/montasreprodutor/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
public @ResponseBody HttpEntity<List<MontaRepresentation>> findByMontasReprodutor( @PathVariable("id") Integer id) {

	List<Monta> montas = montaService.findByMontasReprodutor(id);
	List< MontaRepresentation> representation = new ArrayList<>();
	for(Monta monta: montas)
		{
		representation.add(new MontaRepresentation(monta));
		}
	return ResponseEntity.ok(representation);
} 
	
	
	
}
