package com.gerenciador.bovino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Bovino;
import com.gerenciador.bovino.domain.Lote;
import com.gerenciador.bovino.domain.Monta;


@Repository
public interface  BovinoRepository extends JpaRepository<Bovino,Integer> {
	
	//@Query("select b from #{#Entity} b where b.lote.id_lote = :id")
	List<Bovino> findByLote( Lote lote);
	
	@Query(value = "select *"+" from bovino b where b.id_lote is null", nativeQuery = true)
	List<Bovino> findbySemLote();
	
	
	
	

}
