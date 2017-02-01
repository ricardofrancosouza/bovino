package com.gerenciador.bovino.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Progsaida;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.ProgSaidaRepository;

@Service
public class ProgSaidaService {

	@Autowired
	private ProgSaidaRepository progSaidaRepository;
	
	@Transactional(readOnly=true)
	public List<Progsaida> findAll(){
		return progSaidaRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Progsaida findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("ProgSaida com esse id não existe: " + id);
		}
		return progSaidaRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return progSaidaRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Progsaida save(Progsaida l) {
		
		if(l.getIdProgsaida()!= null && exist(l.getIdProgsaida())) {
			throw new EntityAlreadyExistException("ProgSaida com esse id já existe: " + l.getIdProgsaida());
		}
		
		return progSaidaRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public Progsaida update(Progsaida l) {
		
		if(!exist(l.getIdProgsaida())) {
			throw new EntityNotFoundException("ProgSaida com esse id não existe: " + l.getIdProgsaida());
		}
		
		return progSaidaRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		progSaidaRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Progsaida b) {
		progSaidaRepository.delete(b);
	}

}

