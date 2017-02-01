package com.gerenciador.bovino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Peso;



@Repository
public interface  PesoRepository extends JpaRepository<Peso,Integer> {
	
	@Query(value = "SELECT * FROM peso WHERE bovino_id_bovino = :id", nativeQuery = true)
	List<Peso> findByBovinoPesos(@Param("id") Integer id);

}
