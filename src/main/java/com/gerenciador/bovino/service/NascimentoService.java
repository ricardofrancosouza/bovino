package com.gerenciador.bovino.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Nascimento;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.NascimentoRepository;

@Service
public class NascimentoService {

	@Autowired
	private NascimentoRepository nascimentoRepository;
	
	@Transactional(readOnly=true)
	public List<Nascimento> findAll(){
		return nascimentoRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Nascimento findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("Nascimento com esse id não existe: " + id);
		}
		return nascimentoRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return nascimentoRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Nascimento save(Nascimento l) {
		
		if(l.getIdNascimento() != null && exist(l.getIdNascimento())) {
			throw new EntityAlreadyExistException("Nascimento com esse id já existe: " + l.getIdNascimento());
		}
		
		return nascimentoRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public Nascimento update(Nascimento l) {
		
		if(!exist(l.getIdNascimento())) {
			throw new EntityNotFoundException("Nascimento com esse id não existe: " + l.getIdNascimento());
		}
		
		return nascimentoRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		nascimentoRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Nascimento b) {
		nascimentoRepository.delete(b);
	}

}

