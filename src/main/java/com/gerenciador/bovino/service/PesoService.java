package com.gerenciador.bovino.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Peso;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.PesoRepository;


@Service
public class PesoService {

	@Autowired
	private PesoRepository pesoRepository;
	
	@Transactional(readOnly=true)
	public List<Peso> findAll(){
		return pesoRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Peso findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("Peso com esse id não existe: " + id);
		}
		return pesoRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return pesoRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Peso save(Peso l) {
		
		if(l.getIdPeso() != null && exist(l.getIdPeso())) {
			throw new EntityAlreadyExistException("Peso com esse id já existe: " + l.getIdPeso());
		}
		
		return pesoRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public Peso update(Peso l) {
		
		if(!exist(l.getIdPeso())) {
			throw new EntityNotFoundException("Peso com esse id não existe: " + l.getIdPeso());
		}
		
		return pesoRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		pesoRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Peso b) {
		pesoRepository.delete(b);
	}
	
	/////////////////////////// servicos criados
	
	@Transactional(readOnly=true)
	public List<Peso> pesoByBovinoPesos(Integer id) {
		return pesoRepository.findByBovinoPesos(id);
	}

}

