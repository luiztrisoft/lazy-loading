package com.trisoft.lazyproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.trisoft.lazyproject.entity.Jogador;
import com.trisoft.lazyproject.repository.JogadorFilter;
import com.trisoft.lazyproject.repository.JogadorRepository;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorRepository jogadorRepository;
	
	public Page<Jogador> filtrar(JogadorFilter filter, Pageable pageable){
		return jogadorRepository.filtrar(filter, pageable);
	}

}
