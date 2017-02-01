package com.gerenciador.bovino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Statusbovino;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.StatusBovinoRepository;

@Service
public class StatusBovinoService {

	@Autowired
	private StatusBovinoRepository statusBovinoRepository;
	
	@Transactional(readOnly=true)
	public List<Statusbovino> findAll(){
		return statusBovinoRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Statusbovino findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("StatusBovino com esse id não existe: " + id);
		}
		return statusBovinoRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return statusBovinoRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Statusbovino save(Statusbovino l) {
		
		if(l.getIdStatus() != null && exist(l.getIdStatus())) {
			throw new EntityAlreadyExistException("StatusBovino com esse id já existe: " + l.getIdStatus());
		}
		
		return statusBovinoRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public Statusbovino update(Statusbovino l) {
		
		if(!exist(l.getIdStatus())) {
			throw new EntityNotFoundException("StatusBovino com esse id não existe: " + l.getIdStatus());
		}
		
		return statusBovinoRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		statusBovinoRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Statusbovino b) {
		statusBovinoRepository.delete(b);
	}

}

