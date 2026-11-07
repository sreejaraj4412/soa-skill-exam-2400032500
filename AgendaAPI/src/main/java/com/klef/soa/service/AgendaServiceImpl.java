package com.klef.soa.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Agenda;
import com.klef.soa.repository.AgendaRepository;
@Service
public class AgendaServiceImpl implements AgendaService{
	@Autowired
	private AgendaRepository repository;

	@Override
	public Agenda insertAgenda(Agenda agenda) {
		agenda.setCreatedAt(LocalDateTime.now());
		agenda.setUpdatedAt(LocalDateTime.now());
		return repository.save(agenda);
		
	}

	@Override
	public Agenda updateAgenda(Long id, Agenda agenda) {
		Agenda a = repository.findById(id).orElse(null);
				if (a!= null) {
					a.setName(agenda.getName());
					a.setType(agenda.getType());
		            a.setStatus(agenda.getStatus());
		            a.setLocation(agenda.getLocation());
		            a.setUpdatedAt(LocalDateTime.now());
		            return repository.save(a);
					
				}
				return null;
	}

	@Override
	public String deleteAgenda(Long id) {
		repository.deleteById(id);
		return "Agenda deleted";
		
		
	}

	@Override
	public List<Agenda> displayAll() {
		return repository.findAll()
;	}

	@Override
	public Agenda displayById(Long id) {
		return repository.findById(id).orElse(null);
		
	}

	@Override
	public List<Agenda> findByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByName(name);
	}

	@Override
	public List<Agenda> findByType(String type) {
		// TODO Auto-generated method stub
		return repository.findByType(type);
	}
	
	

}
