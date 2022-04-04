package com.gamegol.ranking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamegol.ranking.repository.ResultadoCompeticoes;

@Controller
@RequestMapping("/resultadocompeticoes")
public class ResultadoCompeticaoController {
	
	private ResultadoCompeticoes resultados;
	
	@GetMapping("/novo")
	public String novo(){
		return "resultadocompeticoes/CadastrarResultado";
	}

}
