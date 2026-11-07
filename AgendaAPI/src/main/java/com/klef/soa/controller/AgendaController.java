package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Agenda;
import com.klef.soa.service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
	@Autowired
	private AgendaService service;
	
	@GetMapping("/")
	public String home () {
		return "agenda Service Project";
	}
		
	@GetMapping("/displayall")
	public List<Agenda> displayAll(){
		return service.displayAll();
	}
	@GetMapping("/id/{id}")
	public Agenda displayById(@PathVariable Long id){
		return service.displayById(id);
	}
	@GetMapping("/name/{name}")
	public List<Agenda> findByName(@PathVariable String name){
		return service.findByName(name);
	}
	@GetMapping("/type/{type}")
	public List<Agenda> findByType(@PathVariable String type){
		return service.findByType(type);
	}
	@PostMapping("/insert")
	public Agenda insertAgenda(@RequestBody Agenda agenda) {
		return service.insertAgenda(agenda);
		
	}
	@PutMapping("/update/{id}")
	public Agenda updateAgenda(@PathVariable Long id,@RequestBody Agenda agenda) {
		
	return service.updateAgenda(id, agenda);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteAgenda(@PathVariable Long id) {
		return service.deleteAgenda(id);
	}
	
	
	
	
	

}
