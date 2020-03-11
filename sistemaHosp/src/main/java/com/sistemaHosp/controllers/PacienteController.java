package com.sistemaHosp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sistemaHosp.models.Consulta;
import com.sistemaHosp.models.Paciente;
import com.sistemaHosp.repository.PacienteRepository;


@Controller
public class PacienteController {
	
	@Autowired
	private PacienteRepository pr;
	
	@RequestMapping(value="/cadastrarPaciente", method=RequestMethod.GET)
	public String form() {
		return "paciiente/formPaciente";
	}
	
	@RequestMapping(value="/cadastrarPaciente", method=RequestMethod.POST)
	public String form(Paciente paciente) {
		
		pr.save(paciente);
		return "redirect:/cadastrarPaciente";
	}
	
	@RequestMapping("/pacientes")
	public ModelAndView listaPacientes(){
		ModelAndView mv = new ModelAndView("paciiente/index");
		Iterable<Paciente> pacientes = pr.findAll();
		mv.addObject("pacientes", pacientes);
		return mv;
	}
	
	@RequestMapping(value="/{idPaciente}" , method=RequestMethod.GET)
	public ModelAndView detalhesPaciente(@PathVariable("idPaciente") long idPaciente)  {
		Paciente paciente = pr.findByIdPaciente(idPaciente);
		ModelAndView mv = new ModelAndView("paciiente/detalhesPaciente");
		mv.addObject("paciente", paciente);
		return mv;
	}
}