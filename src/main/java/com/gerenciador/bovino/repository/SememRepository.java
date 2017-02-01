package com.gerenciador.bovino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Peso;
import com.gerenciador.bovino.domain.Semem;


@Repository
public interface  SememRepository extends JpaRepository<Semem,Integer> {
	@Query(value = "SELECT * FROM semem WHERE id_semem = :id", nativeQuery = true)
	List<Semem> findBySememBovino(@Param("id") Integer id);


}
