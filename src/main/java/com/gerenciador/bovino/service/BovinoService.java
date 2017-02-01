package com.gerenciador.bovino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Bovino;
import com.gerenciador.bovino.domain.Statusbovino;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.BovinoRepository;
import com.gerenciador.bovino.repository.StatusBovinoRepository;
import com.gerenciador.bovino.representation.StatusBovinoRepresentation;

@Service
public class BovinoService {

	@Autowired
	private BovinoRepository bovinoRepository;
	
	

	@Transactional(readOnly=true)
	public List<Bovino> findAll(){
		return bovinoRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Bovino findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("Pessoa com esse id não existe: " + id);
		}
		return bovinoRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return bovinoRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Bovino save(Bovino b) {
	    
		if(b.getId_bovino() != null && exist(b.getId_bovino())) {
			throw new EntityAlreadyExistException("Bovino com esse id já existe: " + b.getId_bovino());
		}
	
		return bovinoRepository.save(b);
	}
	
	@Transactional(readOnly=false)
	public Bovino update(Bovino b) {
		
		if(!exist(b.getId_bovino())) {
			throw new EntityNotFoundException("Pessoa com esse id não existe: " + b.getId_bovino());
		}
		
		
		
		return bovinoRepository.save(b);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		bovinoRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Bovino b) {
		bovinoRepository.delete(b);
	}
	
	
	///////// consulta
	@Transactional(readOnly=true)
	public List<Bovino> findbySemLote(){
		return bovinoRepository.findbySemLote();
	}

}

