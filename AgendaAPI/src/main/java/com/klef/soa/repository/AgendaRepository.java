package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Agenda;
@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
	List<Agenda> findByName(String name);
	List<Agenda> findByType(String type);

}
