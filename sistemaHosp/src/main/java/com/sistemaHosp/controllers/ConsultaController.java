package com.sistemaHosp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sistemaHosp.models.Consulta;
import com.sistemaHosp.repository.ConsultaRepository;

@Controller
public class ConsultaController {
	
	@Autowired
	private ConsultaRepository cr;
	
	@RequestMapping(value="/cadastrarConsulta", method=RequestMethod.GET)
	public String form() {
		return "paciiente/formConsulta";
	}
	
	@RequestMapping(value="/cadastrarConsulta", method=RequestMethod.POST)
	public String form(Consulta consulta) {
		
		cr.save(consulta);
		
		return "redirect:/cadastrarConsulta";
		
	}
	
	@RequestMapping("/consultas")
	public ModelAndView listaConsultas(){
		ModelAndView mv = new ModelAndView("paciiente/listarConsulta");
		Iterable<Consulta> consultas = cr.findAll();
		mv.addObject("consultas", consultas);
		return mv;
	}
	
	@RequestMapping(value="/{idConsulta}" , method=RequestMethod.GET)
	public ModelAndView detalhesConsulta(@PathVariable("idConsulta") long idConsulta)  {
		Consulta consulta = cr.findByIdConsulta(idConsulta);
		ModelAndView mv = new ModelAndView("paciiente/detalhesConsulta");
		mv.addObject("consulta", consulta);
		return mv;	}
}