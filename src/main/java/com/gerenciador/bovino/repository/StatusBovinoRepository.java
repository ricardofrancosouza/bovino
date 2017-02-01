package com.gerenciador.bovino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Statusbovino;


@Repository
public interface  StatusBovinoRepository extends JpaRepository<Statusbovino,Integer> {

}
