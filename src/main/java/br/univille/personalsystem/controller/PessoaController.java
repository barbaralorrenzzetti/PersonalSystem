package br.univille.personalsystem.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.univille.personalsystem.model.Pessoa;
import br.univille.personalsystem.repository.PessoaRepository;

@Controller
@RequestMapping("/Pessoa")
public class PessoaController {
	
	@Autowired
    private PessoaRepository pessoaRepository;

	@GetMapping("")
	public ModelAndView index() {
		List<Pessoa> listaPessoa = new this.pessoaRepository.findAll();;
        
        Pessoa p1 = new Pessoa();
        p1.setNome("Joao");
        p1.setCPF("000.000.000-00");
        p1.setRG("0.000.000");
        p1.setSexo("Masculino");
        p1.setEndereco("aaaaaaaaaa aaa");
        p1.setNascimento(new Date(0,0,0));
        
        listaPessoa.add(p1);
        
        return new ModelAndView("pessoa/index","listapac",listaPessoa);
		
	}
}




