package com.klef.soa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.soa.entity.Agenda;

public interface AgendaService {
	Agenda insertAgenda(Agenda agenda);
	 
	Agenda updateAgenda(Long id, Agenda agenda);
	
	String deleteAgenda(Long id);
	
	List<Agenda> displayAll();
	
	
	
	List<Agenda> findByType(String type);
	
	Agenda displayById(Long id);
	
	
	List<Agenda> findByName(String name);
	
	

}
