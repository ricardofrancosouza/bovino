package com.gerenciador.bovino.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Raca;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.RacaRepository;

@Service
public class RacaService {

	@Autowired
	private RacaRepository racaRepository;
	
	@Transactional(readOnly=true)
	public List<Raca> findAll(){
		return racaRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Raca findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("Raca com esse id não existe: " + id);
		}
		return racaRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return racaRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Raca save(Raca l) {
		
		if(l.getIdRaca() != null && exist(l.getIdRaca())) {
			throw new EntityAlreadyExistException("Raca com esse id já existe: " + l.getIdRaca());
		}
		
		return racaRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public Raca update(Raca l) {
		
		if(!exist(l.getIdRaca())) {
			throw new EntityNotFoundException("Raca com esse id não existe: " + l.getIdRaca());
		}
		
		return racaRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		racaRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Raca b) {
		racaRepository.delete(b);
	}

}

