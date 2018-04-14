package com.trisoft.lazyproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.trisoft.lazyproject.entity.Jogador;

public interface JogadorRepositoryQuery {

	public Page<Jogador> filtrar(JogadorFilter jogadorFilter, Pageable pageable);
}
