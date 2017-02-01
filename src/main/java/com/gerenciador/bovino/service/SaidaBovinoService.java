package com.gerenciador.bovino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Saidabovino;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.SaidaBovinoRepository;

@Service
public class SaidaBovinoService {

	@Autowired
	private SaidaBovinoRepository SaidaBovinoRepository;
	
	@Transactional(readOnly=true)
	public List<Saidabovino> findAll(){
		return SaidaBovinoRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Saidabovino findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("SaidaBovino com esse id não existe: " + id);
		}
		return SaidaBovinoRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return SaidaBovinoRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Saidabovino save(Saidabovino l) {
		
		if(l.getIdSaida() != null && exist(l.getIdSaida())) {
			throw new EntityAlreadyExistException("SaidaBovino com esse id já existe: " + l.getIdSaida());
		}
		
		return SaidaBovinoRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public Saidabovino update(Saidabovino l) {
		
		if(!exist(l.getIdSaida())) {
			throw new EntityNotFoundException("SaidaBovino com esse id não existe: " + l.getIdSaida());
		}
		
		return SaidaBovinoRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		SaidaBovinoRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Saidabovino b) {
		SaidaBovinoRepository.delete(b);
	}

}

