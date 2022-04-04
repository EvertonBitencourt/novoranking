package com.gamegol.ranking.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gamegol.ranking.model.Time;
import com.gamegol.ranking.repository.Times;

@Controller
@RequestMapping("/times")
public class TimeController {
	
	@Autowired
	private Times times;
	
	@RequestMapping("/novo")
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView ("CadastroTime");
		mv.addObject("time",new Time());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Time time, Errors errors, RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView ("CadastroTime");
		if(errors.hasErrors()){
			mv.addObject("time", time);
			return mv;
		}
		
		times.save(time);
		ModelAndView mv1 = new ModelAndView("redirect:/times/novo");
		attributes.addFlashAttribute("mensagem","Time salvo com sucesso!");
		return mv1;
	}
	
	@RequestMapping
	public ModelAndView pesquisar(){
		List<Time> todosTimes = times.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTimes");
		mv.addObject("times",todosTimes);
	
		return mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable Long id){
		Optional<Time> time = times.findById(id);
		ModelAndView mv = new ModelAndView("CadastroTime");
		mv.addObject("time", time.get());
		return mv;
	}
	

	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id){
		times.deleteById(id);
		return "redirect:/times";
	}
}