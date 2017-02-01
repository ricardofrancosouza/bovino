package com.gerenciador.bovino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Lote;


@Repository
public interface  LoteRepository extends JpaRepository<Lote,Integer> {

}
