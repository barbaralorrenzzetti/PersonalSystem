package br.univille.personalsystem.controller;

import java.util.HashMap;
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

import br.univille.personalsystem.model.Matricula;
import br.univille.personalsystem.model.Treino;
import br.univille.personalsystem.repository.MatriculaRepository;
import br.univille.personalsystem.repository.TreinoRepository;

@Controller
@RequestMapping("/treino")
public class TreinoController {
	@Autowired
    private TreinoRepository treinoRepository;
	@Autowired
    private MatriculaRepository matriculaRepository;
	
	@GetMapping("")
	public ModelAndView index() {
		List<Treino> listaTreino = this.treinoRepository.findAll();
       
        return new ModelAndView("treino/index","listatre",listaTreino);
		
	}
	@GetMapping("/novo")
    public ModelAndView createForm(@ModelAttribute Treino treino) {
        List<Matricula> listaMatricula = matriculaRepository.findAll();
        return new ModelAndView("treino/form","listaMatricula",listaMatricula);
    }
    @PostMapping(params="form")
    public ModelAndView save(@Valid Treino treino, BindingResult result, RedirectAttributes redirect) {        
    	treino = this.treinoRepository.save(treino);
        return new ModelAndView("redirect:/treino");
    }
    @GetMapping(value="/alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Treino treino) {
        List<Matricula> listaMatricula = matriculaRepository.findAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("treino",treino);
        dados.put("listamatricula",listaMatricula);
        
        return new ModelAndView("treino/form",dados);
    }
    @GetMapping(value="remover/{id}")
    public ModelAndView remover(@PathVariable ("id") Long id, RedirectAttributes redirect) {
        this.treinoRepository.deleteById(id);
        return new ModelAndView("redirect:/treino");
    }
}



