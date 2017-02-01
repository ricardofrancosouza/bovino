package com.gerenciador.bovino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Entradabovino;


@Repository
public interface  EntradaBovinoRepository extends JpaRepository<Entradabovino,Integer> {

}
