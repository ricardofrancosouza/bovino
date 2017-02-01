package com.gerenciador.bovino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Lote;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.LoteRepository;

@Service
public class LoteService {

	@Autowired
	private LoteRepository loteRepository;
	
	@Transactional(readOnly=true)
	public List<Lote> findAll(){
		return loteRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Lote findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("Lote com esse id não existe: " + id);
		}
		return loteRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return loteRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Lote save(Lote l) {
		
		if(l.getIdLote() != null && exist(l.getIdLote())) {
			throw new EntityAlreadyExistException("Lote com esse id já existe: " + l.getIdLote());
		}
		
		return loteRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public Lote update(Lote l) {
		
		if(!exist(l.getIdLote())) {
			throw new EntityNotFoundException("Lote com esse id não existe: " + l.getIdLote());
		}
		
		return loteRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		loteRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Lote b) {
		loteRepository.delete(b);
	}

}

