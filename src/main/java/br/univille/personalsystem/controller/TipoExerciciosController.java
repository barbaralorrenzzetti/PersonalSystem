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

import br.univille.personalsystem.model.TipoExercicios;
import br.univille.personalsystem.repository.TipoExerciciosRepository;

@Controller
@RequestMapping("/tipoExercicios")
public class TipoExerciciosController {
	@Autowired
    private TipoExerciciosRepository tipoExerciciosRepository;

	@GetMapping("")
	public ModelAndView index() {
		List<TipoExercicios> listaTipoExercicios = this.tipoExerciciosRepository.findAll();
       
        return new ModelAndView("tipoExercicios/index","listapac",listaTipoExercicios);
		
	}
    @GetMapping("/novo")
    public String createForm(@ModelAttribute TipoExercicios tipoExercicios) {
    	return "tipoExercicios/form";
    }
    @PostMapping(params="form")
    public ModelAndView save(@Valid TipoExercicios tipoExercicios, BindingResult result, RedirectAttributes redirect) {        
    	tipoExercicios = this.tipoExerciciosRepository.save(tipoExercicios);
        return new ModelAndView("redirect:/tipoExercicios");
    }
    @GetMapping(value="/alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") TipoExercicios tipoExercicios) {
        return new ModelAndView("tipoExercicios/form","tipoExercicios",tipoExercicios);
    }
    @GetMapping(value="remover/{id}")
    public ModelAndView remover(@PathVariable ("id") Long id, RedirectAttributes redirect) {
        this.tipoExerciciosRepository.deleteById(id);
        return new ModelAndView("redirect:/tipoExercicios");
    }
}




