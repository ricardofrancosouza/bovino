package com.gerenciador.bovino.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Idadebovino;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.IdadeBovinoRepository;

@Service
public class IdadeBovinoService {

	@Autowired
	private IdadeBovinoRepository idadeBovinoRepository;
	
	@Transactional(readOnly=true)
	public List<Idadebovino> findAll(){
		return idadeBovinoRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Idadebovino findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("IdadeBovino com esse id não existe: " + id);
		}
		return idadeBovinoRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return idadeBovinoRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Idadebovino save(Idadebovino l) {
		
		if(l.getIdIdade() != null && exist(l.getIdIdade())) {
			throw new EntityAlreadyExistException("IdadeBovino com esse id já existe: " + l.getIdIdade());
		}
		
		return idadeBovinoRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public Idadebovino update(Idadebovino l) {
		
		if(!exist(l.getIdIdade())) {
			throw new EntityNotFoundException("IdadeBovino com esse id não existe: " + l.getIdIdade());
		}
		
		return idadeBovinoRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		idadeBovinoRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Idadebovino b) {
		idadeBovinoRepository.delete(b);
	}

}

