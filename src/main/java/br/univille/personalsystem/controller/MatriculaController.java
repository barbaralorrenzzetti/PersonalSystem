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
import br.univille.personalsystem.model.Pessoa;
import br.univille.personalsystem.repository.MatriculaRepository;
import br.univille.personalsystem.repository.PessoaRepository;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {
	@Autowired
    private MatriculaRepository matriculaRepository;
	@Autowired
    private PessoaRepository pessoaRepository;
	
	@GetMapping("")
	public ModelAndView index() {
		List<Matricula> listaMatricula = this.matriculaRepository.findAll();
       
        return new ModelAndView("matricula/index","listamat",listaMatricula);
		
	}
    @GetMapping("/novo")
    public ModelAndView createForm(@ModelAttribute Matricula matricula) {
    	List<Pessoa> listaPessoa = pessoaRepository.findByTipo("Aluno");
    	
        return new ModelAndView("matricula/form","listaPessoa",listaPessoa);
    }
    @PostMapping(params="form")
    public ModelAndView save(@Valid Matricula matricula, BindingResult result, RedirectAttributes redirect) {        
    	matricula = this.matriculaRepository.save(matricula);
        return new ModelAndView("redirect:/matricula");
    }
    @GetMapping(value="/alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Matricula matricula) {
    	List<Pessoa> listaPessoa = pessoaRepository.findAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("matricula", matricula);
        dados.put("listapessoa",listaPessoa);
        
        return new ModelAndView("matricula/form",dados);
    }
    @GetMapping(value="remover/{id}")
    public ModelAndView remover(@PathVariable ("id") Long id, RedirectAttributes redirect) {
        this.matriculaRepository.deleteById(id);
        return new ModelAndView("redirect:/matricula");
    }
}





