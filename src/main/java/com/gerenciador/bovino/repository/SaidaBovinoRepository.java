package com.gerenciador.bovino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Saidabovino;


@Repository
public interface  SaidaBovinoRepository extends JpaRepository<Saidabovino,Integer> {

}
