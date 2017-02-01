package com.gerenciador.bovino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Monta;



@Repository
public interface  MontaRepository extends JpaRepository<Monta,Integer> {
	@Query(value = "SELECT * FROM monta WHERE id_matriz = :id", nativeQuery = true)
	List<Monta> findByMontaMatriz(@Param("id") Integer id);
	
	
	@Query(value = "select m.dt_monta, m.dt_prev_parto, m.dt_prev_resultado,m.dt_resultado, m.id_matriz, m.id_monta, m.id_semem,  m.status_monta "+" from monta m, semem s where m.id_semem = s.id_semem and s.id_reprodutor = :id", nativeQuery = true)
	List<Monta> findByMontaReprodutor(@Param("id") Integer id);



}
