package com.gamegol.ranking.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gamegol.ranking.model.Competicao;
import com.gamegol.ranking.model.Time;
import com.gamegol.ranking.repository.Competicoes;



@Controller
@RequestMapping("/competicoes")
public class CompeticaoController {

	@Autowired
	private Competicoes competicoes;
	
	@RequestMapping("/novo")
	private ModelAndView novo(){
		ModelAndView mv = new ModelAndView("CadastroCompeticao");
		mv.addObject("competicao", new Competicao());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Competicao competicao, Errors errors, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView ("CadastroCompeticao");
		if(errors.hasErrors()){
			mv.addObject("competicao", competicao);
			return mv;
		}
		
		competicoes.save(competicao);
		ModelAndView mv1 = new ModelAndView("redirect:/competicoes/novo");
		attributes.addFlashAttribute("mensagem","Competição salva com sucesso!");
		return mv1;
	}
	
	@RequestMapping
	public ModelAndView pesquisar(){
		List <Competicao> todasCompeticoes = competicoes.findAll();
		ModelAndView mv = new ModelAndView("PesquisaCompeticoes");
		mv.addObject("competicoes", todasCompeticoes);
		return mv;
		
	}
	
	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable Long id){
		Optional<Competicao> competicao = competicoes.findById(id);
		ModelAndView mv = new ModelAndView("CadastroCompeticao");
		mv.addObject("competicao", competicao.get());
		return mv;
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id){
		competicoes.deleteById(id);
		return "redirect:/competicoes";
	}
}
