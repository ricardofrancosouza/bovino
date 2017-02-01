package com.gerenciador.bovino.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Desmama;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.DesmamaRepository;

@Service
public class DesmamaService {

	@Autowired
	private DesmamaRepository desmamaRepository;
	
	@Transactional(readOnly=true)
	public List<Desmama> findAll(){
		return desmamaRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Desmama findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("Desmama com esse id não existe: " + id);
		}
		return desmamaRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return desmamaRepository.exists(id);
	}
	
//	@Transactional(readOnly=false)
	public Desmama save(Desmama l) {
		
		if(l.getIdDesmama() != null && exist(l.getIdDesmama())) {
			throw new EntityAlreadyExistException("Desmama com esse id já existe: " + l.getIdDesmama());
		}
		
		return desmamaRepository.save(l);
	}
	
	//@Transactional(readOnly=false)
	public Desmama update(Desmama l) {
		
		if(!exist(l.getIdDesmama())) {
			throw new EntityNotFoundException("Desmama com esse id não existe: " + l.getIdDesmama());
		}
		
		return desmamaRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		desmamaRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Desmama b) {
		desmamaRepository.delete(b);
	}

}

