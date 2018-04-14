package com.trisoft.lazyproject.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trisoft.lazyproject.entity.Jogador;
import com.trisoft.lazyproject.repository.JogadorFilter;
import com.trisoft.lazyproject.service.JogadorService;

@RestController
@RequestMapping("/jogadores")
public class JogadorResource {
	
	@Autowired
	private JogadorService jogadorService;
	
	@GetMapping
	public Page<Jogador> listarTodos(JogadorFilter filter, Pageable pageable){
		return jogadorService.filtrar(filter, pageable);
	}

}
