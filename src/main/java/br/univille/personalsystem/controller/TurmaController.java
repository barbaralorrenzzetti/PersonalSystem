package br.univille.personalsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.univille.personalsystem.model.Treino;
import br.univille.personalsystem.model.Turma;
import br.univille.personalsystem.repository.TurmaRepository;

@Controller
@RequestMapping("/turma")
public class TurmaController {
	@Autowired
    private TurmaRepository turmaRepository;
		

	@GetMapping("")
	public ModelAndView index() {
		List<Turma> listaTurma = this.turmaRepository.findAll();
       
        return new ModelAndView("turma/index","listatur",listaTurma);
		
	}
    @GetMapping("/novo")
    public String createForm(@ModelAttribute Turma turma) {
    	return "turma/form";
    }
    @PostMapping(params="form")
    public ModelAndView save(@Valid Turma turma, BindingResult result, RedirectAttributes redirect) {        
    	turma = this.turmaRepository.save(turma);
        return new ModelAndView("redirect:/turma");
    }
    @GetMapping(value="/alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Turma turma) {
        return new ModelAndView("turma/form","turma",turma);
    }
    @GetMapping(value="remover/{id}")
    public ModelAndView remover(@PathVariable ("id") Long id, RedirectAttributes redirect) {
        this.turmaRepository.deleteById(id);
        return new ModelAndView("redirect:/turma");
    }
}





