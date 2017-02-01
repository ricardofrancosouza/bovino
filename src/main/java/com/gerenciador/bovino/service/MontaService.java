package com.gerenciador.bovino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciador.bovino.domain.Monta;
import com.gerenciador.bovino.domain.Semem;
import com.gerenciador.bovino.exception.EntityAlreadyExistException;
import com.gerenciador.bovino.exception.EntityNotFoundException;
import com.gerenciador.bovino.repository.MontaRepository;

@Service
public class MontaService {

	@Autowired
	private MontaRepository montaRepository;
	
	@Transactional(readOnly=true)
	public List<Monta> findAll(){
		return montaRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Monta findById(Integer id) {
		if(!exist(id)) {
			throw new EntityNotFoundException("Monta com esse id não existe: " + id);
		}
		return montaRepository.findOne(id);
	}
	
	@Transactional(readOnly=true)
	public boolean exist(Integer id) {
		return montaRepository.exists(id);
	}
	
	@Transactional(readOnly=false)
	public Monta save(Monta l) {
		
		if(l.getIdMonta() != null && exist(l.getIdMonta())) {
			throw new EntityAlreadyExistException("Monta com esse id já existe: " + l.getIdMonta());
		}
		
		return montaRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public Monta update(Monta l) {
		
		if(!exist(l.getIdMonta())) {
			throw new EntityNotFoundException("Monta com esse id não existe: " + l.getIdMonta());
		}
		
		return montaRepository.save(l);
	}
	
	@Transactional(readOnly=false)
	public void delete(Integer id) {
		montaRepository.delete(id);
	}
	
	@Transactional(readOnly=false)
	public void delete(Monta b) {
		montaRepository.delete(b);
	}
	
	
/////////////////////////// servicos criados
	
@Transactional(readOnly=true)
public List<Monta> findByMontasMatriz(Integer id) {
return montaRepository.findByMontaMatriz(id);
}
@Transactional(readOnly=true)
public List<Monta> findByMontasReprodutor(Integer id) {
return montaRepository.findByMontaReprodutor(id);
}



}
	



