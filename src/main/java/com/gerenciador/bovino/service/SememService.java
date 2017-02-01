package com.gerenciador.bovino.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Peso;
import com.gerenciador.bovino.domain.Semem;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.SememRepository;

@Service
public class SememService {

	@Autowired
	private SememRepository sememRepository;
	
	@Transactional(readOnly=true)
	public List<Semem> findAll(){
		return sememRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Semem findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("Semem com esse id não existe: " + id);
		}
		return sememRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return sememRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Semem save(Semem l) {
		
		if(l.getIdSemem() != null && exist(l.getIdSemem())) {
			throw new EntityAlreadyExistException("Semem com esse id já existe: " + l.getIdSemem());
		}
		
		return sememRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public Semem update(Semem l) {
		
		if(!exist(l.getIdSemem())) {
			throw new EntityNotFoundException("Semem com esse id não existe: " + l.getIdSemem());
		}
		
		return sememRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		sememRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Semem b) {
		sememRepository.delete(b);
	}
	
	
/////////////////////////// servicos criados
	
@Transactional(readOnly=true)
public List<Semem> findBySemensBovino(Integer id) {
return sememRepository.findBySememBovino(id);
}
	

}

