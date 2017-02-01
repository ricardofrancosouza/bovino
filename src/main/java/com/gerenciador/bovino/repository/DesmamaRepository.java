package com.gerenciador.bovino.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciador.bovino.domain.Desmama;


@Repository
public interface  DesmamaRepository extends JpaRepository<Desmama,Integer> {

}
