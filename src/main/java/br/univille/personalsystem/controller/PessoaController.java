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

import br.univille.personalsystem.model.Pessoa;
import br.univille.personalsystem.repository.PessoaRepository;



@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
    private PessoaRepository pessoaRepository;

	@GetMapping("")
	public ModelAndView index() {
		List<Pessoa> listaPessoa = this.pessoaRepository.findAll();
       
        return new ModelAndView("pessoa/index","listapac",listaPessoa);
		
	}
    @GetMapping("/novo")
    public String createForm(@ModelAttribute Pessoa pessoa) {
    	return "pessoa/form";
    }
    @PostMapping(params="form")
    public ModelAndView save(@Valid Pessoa pessoa, BindingResult result, RedirectAttributes redirect) {        
        pessoa = this.pessoaRepository.save(pessoa);
        return new ModelAndView("redirect:/pessoa");
    }
    @GetMapping(value="/alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Pessoa pessoa) {
        return new ModelAndView("pessoa/form","pessoa",pessoa);
    }
}




