package com.trisoft.lazyproject.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trisoft.lazyproject.entity.Jogador;
import com.trisoft.lazyproject.repository.JogadorFilter;

@RestController
@RequestMapping("/jogadores")
public class JogadorResource {
	
	@GetMapping
	public Page<Jogador> listarTodos(JogadorFilter filter, Pageable pageable){
		return null;
	}

}
