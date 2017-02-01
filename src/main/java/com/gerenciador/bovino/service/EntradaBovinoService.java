package com.gerenciador.bovino.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Entradabovino;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.EntradaBovinoRepository;

@Service
public class EntradaBovinoService {

	@Autowired
	private EntradaBovinoRepository entradabovinoRepository;
	
	@Transactional(readOnly=true)
	public List<Entradabovino> findAll(){
		return entradabovinoRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Entradabovino findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("Entradabovino com esse id não existe: " + id);
		}
		return entradabovinoRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return entradabovinoRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Entradabovino save(Entradabovino l) {
		
		if(l.getIdEntradabov() != null && exist(l.getIdEntradabov())) {
			throw new EntityAlreadyExistException("Entradabovino com esse id já existe: " + l.getIdEntradabov());
		}
		
		return entradabovinoRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public Entradabovino update(Entradabovino l) {
		
		if(!exist(l.getIdEntradabov())) {
			throw new EntityNotFoundException("Entradabovino com esse id não existe: " + l.getIdEntradabov());
		}
		
		return entradabovinoRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		entradabovinoRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Entradabovino b) {
		entradabovinoRepository.delete(b);
	}

}

