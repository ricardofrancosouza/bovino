package com.gerenciador.bovino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Notafiscal;


@Repository
public interface  NotaFiscalRepository extends JpaRepository<Notafiscal,Integer> {

}
