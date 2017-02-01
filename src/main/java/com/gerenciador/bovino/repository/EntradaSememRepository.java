package com.gerenciador.bovino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Entradasemem;


@Repository
public interface  EntradaSememRepository extends JpaRepository<Entradasemem,Integer> {

}
