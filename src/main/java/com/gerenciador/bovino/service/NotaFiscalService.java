package com.gerenciador.bovino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Notafiscal;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.NotaFiscalRepository;

@Service
public class NotaFiscalService {

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;
	
	@Transactional(readOnly=true)
	public List<Notafiscal> findAll(){
		return notaFiscalRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Notafiscal findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("NotaFiscal com esse id não existe: " + id);
		}
		return notaFiscalRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return notaFiscalRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Notafiscal save(Notafiscal l) {
		
		if(l.getIdNotafiscal() != null && exist(l.getIdNotafiscal())) {
			throw new EntityAlreadyExistException("NotaFiscal com esse id já existe: " + l.getIdNotafiscal());
		}
		
		return notaFiscalRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public Notafiscal update(Notafiscal l) {
		
		if(!exist(l.getIdNotafiscal())) {
			throw new EntityNotFoundException("NotaFiscal com esse id não existe: " + l.getIdNotafiscal());
		}
		
		return notaFiscalRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		notaFiscalRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Notafiscal b) {
		notaFiscalRepository.delete(b);
	}

}

