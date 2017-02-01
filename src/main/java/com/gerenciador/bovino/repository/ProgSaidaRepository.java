package com.gerenciador.bovino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Progsaida;


@Repository
public interface  ProgSaidaRepository extends JpaRepository<Progsaida,Integer> {

}
