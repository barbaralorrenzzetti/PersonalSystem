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

import br.univille.personalsystem.model.Equipamentos;
import br.univille.personalsystem.repository.EquipamentosRepository;


@Controller
@RequestMapping("/equipamentos")
public class EquipamentosController {
	@Autowired
    private EquipamentosRepository equipamentosRepository;

	@GetMapping("")
	public ModelAndView index() {
		List<Equipamentos> listaEquipamentos = this.equipamentosRepository.findAll();
       
        return new ModelAndView("equipamentos/index","listaequi",listaEquipamentos);
		
	}
    @GetMapping("/novo")
    public String createForm(@ModelAttribute Equipamentos equipamentos) {
    	return "equipamentos/form";
    }
    @PostMapping(params="form")
    public ModelAndView save(@Valid Equipamentos equipamentos, BindingResult result, RedirectAttributes redirect) {        
        equipamentos = this.equipamentosRepository.save(equipamentos);
        return new ModelAndView("redirect:/equipamentos");
    }
    @GetMapping(value="/alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Equipamentos equipamentos) {
        return new ModelAndView("equipamentos/form","equipamentos",equipamentos);
    }
    @GetMapping(value="remover/{id}")
    public ModelAndView remover(@PathVariable ("id") Long id, RedirectAttributes redirect) {
        this.equipamentosRepository.deleteById(id);
        return new ModelAndView("redirect:/equipamentos");
    }
}


