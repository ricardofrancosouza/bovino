package com.gerenciador.bovino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Idadebovino;


@Repository
public interface  IdadeBovinoRepository extends JpaRepository<Idadebovino,Integer> {

}
