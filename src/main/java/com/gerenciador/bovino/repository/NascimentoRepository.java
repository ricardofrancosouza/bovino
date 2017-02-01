package com.gerenciador.bovino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Nascimento;


@Repository
public interface  NascimentoRepository extends JpaRepository<Nascimento,Integer> {

}
