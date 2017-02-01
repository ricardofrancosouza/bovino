package com.gerenciador.bovino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Raca;


@Repository
public interface  RacaRepository extends JpaRepository<Raca,Integer> {

}
