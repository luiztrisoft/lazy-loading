package com.trisoft.lazyproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trisoft.lazyproject.entity.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long>, JogadorRepositoryQuery{

}
