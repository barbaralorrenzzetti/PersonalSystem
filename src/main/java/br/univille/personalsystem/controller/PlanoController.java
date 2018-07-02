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

import br.univille.personalsystem.model.Plano;
import br.univille.personalsystem.repository.PlanoRepository;

@Controller
@RequestMapping("/plano")
public class PlanoController {
	
	
	@Autowired
    private PlanoRepository planoRepository;

	
	@GetMapping("")
	public ModelAndView index() {
		List<Plano> listaPlano = this.planoRepository.findAll();
       
        return new ModelAndView("plano/index","listapac",listaPlano);
		
	}
    @GetMapping("/novo")
    public String createForm(@ModelAttribute Plano plano) {
    	return "plano/form";
    }
    @PostMapping(params="form")
    public ModelAndView save(@Valid Plano plano, BindingResult result, RedirectAttributes redirect) {        
    	plano = this.planoRepository.save(plano);
        return new ModelAndView("redirect:/plano");
    }
    @GetMapping(value="/alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Plano plano) {
        return new ModelAndView("plano/form","plano",plano);
    }
    @GetMapping(value="remover/{id}")
    public ModelAndView remover(@PathVariable ("id") Long id, RedirectAttributes redirect) {
        this.planoRepository.deleteById(id);
        return new ModelAndView("redirect:/plano");
    }
}

