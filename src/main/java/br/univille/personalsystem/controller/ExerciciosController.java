package br.univille.personalsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.univille.personalsystem.model.Equipamentos;
import br.univille.personalsystem.model.Exercicios;
import br.univille.personalsystem.model.TipoExercicios;
import br.univille.personalsystem.repository.EquipamentosRepository;
import br.univille.personalsystem.repository.ExerciciosRepository;
import br.univille.personalsystem.repository.TipoExerciciosRepository;

@Controller
@RequestMapping("/exercicios")
public class ExerciciosController {
	@Autowired
	private ExerciciosRepository exerciciosRepository;
	@Autowired
	private EquipamentosRepository equipamentosRepository;
	@Autowired
	private TipoExerciciosRepository tipoExerciciosRepository;

	@GetMapping("")
	public ModelAndView index() {
		List<Exercicios> listaExercicios = this.exerciciosRepository.findAll();

		return new ModelAndView("exercicios/index","listaexer",listaExercicios);

	}
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Exercicios exercicios) {
		List<Equipamentos> listaEquipamentos = equipamentosRepository.findAll();
		List<TipoExercicios> listaTipoExercicios = tipoExerciciosRepository.findAll();
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("listaEquipamentos", listaEquipamentos);
		dados.put("listaTipoExercicios", listaTipoExercicios);
		dados.put("exercicios", exercicios);
		dados.put("novoequiutilizado", new Equipamentos());
		

		return new ModelAndView("exercicios/form",dados);
	}
	@PostMapping(params= {"save"})
	public ModelAndView save(@Valid Exercicios exercicios, long novoequiutilizado, BindingResult result, RedirectAttributes redirect) {
		exercicios = this.exerciciosRepository.save(exercicios);
		return new ModelAndView("redirect:/exercicios");
	}
	@PostMapping(params= {"insertEquip"})
	public ModelAndView insertproc(Exercicios exercicios, long novoequiutilizado, BindingResult result, RedirectAttributes redirect) {
		List<Equipamentos> listaEquipamentos = equipamentosRepository.findAll();
		List<TipoExercicios> listaTipoExercicios = tipoExerciciosRepository.findAll();

		Optional<Equipamentos> novoequiutilizadoobj = this.equipamentosRepository.findById(novoequiutilizado);
		if (novoequiutilizadoobj.isPresent())
			exercicios.getListaEquipamentos().add(novoequiutilizadoobj.get());

		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("listaEquipamentos", listaEquipamentos);
		dados.put("listaTipoExercicios", listaTipoExercicios);
		dados.put("exercicios", exercicios);
		dados.put("novoequiutilizado", novoequiutilizado);

		return new ModelAndView("exercicios/form",dados);
	}

	@PostMapping(params= {"removeequip"})
	public ModelAndView removeequip(@RequestParam (name = "removeequip") int index, Exercicios exercicios, Equipamentos equipamentos, BindingResult result, RedirectAttributes redirect) {
		List<Equipamentos> listaEquipamentos = equipamentosRepository.findAll();
		List<TipoExercicios> listaTipoExercicios = tipoExerciciosRepository.findAll();

		exercicios.getListaEquipamentos().remove(index);

		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("listaEquipamentos", listaEquipamentos);
		dados.put("listaTipoExercicios", listaTipoExercicios);
		dados.put("exercicios", exercicios);


		return new ModelAndView("exercicios/form",dados);
	}
	@GetMapping(value="/alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Exercicios exercicios) {
		List<Equipamentos> listaEquipamentos = equipamentosRepository.findAll();
		List<TipoExercicios> listaTipoExercicios = tipoExerciciosRepository.findAll();

		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("listaEquipamentos", listaEquipamentos);
		dados.put("listaTipoExercicios", listaTipoExercicios);
		dados.put("exercicios", exercicios);

		return new ModelAndView("exercicios/form",dados);
	}




	@GetMapping(value="remover/{id}")
	public ModelAndView remover(@PathVariable ("id") Long id, RedirectAttributes redirect) {
		this.exerciciosRepository.deleteById(id);
		return new ModelAndView("redirect:/exercicios");
	}


}

