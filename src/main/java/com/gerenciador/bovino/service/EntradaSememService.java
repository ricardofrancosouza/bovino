package com.gerenciador.bovino.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Entradasemem;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.EntradaSememRepository;

@Service
public class EntradaSememService {

	@Autowired
	private EntradaSememRepository entradaSememRepository;
	
	@Transactional(readOnly=true)
	public List<Entradasemem> findAll(){
		return entradaSememRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Entradasemem findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("EntradaSemem com esse id não existe: " + id);
		}
		return entradaSememRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return entradaSememRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Entradasemem save(Entradasemem l) {
		
		if(l.getIdEntrada() != null && exist(l.getIdEntrada())) {
			throw new EntityAlreadyExistException("EntradaSemem com esse id já existe: " + l.getIdEntrada());
		}
		
		return entradaSememRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public Entradasemem update(Entradasemem l) {
		
		if(!exist(l.getIdEntrada())) {
			throw new EntityNotFoundException("EntradaSemem com esse id não existe: " + l.getIdEntrada());
		}
		
		return entradaSememRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		entradaSememRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Entradasemem b) {
		entradaSememRepository.delete(b);
	}

}

