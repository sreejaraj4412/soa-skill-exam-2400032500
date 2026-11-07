
package com.klef.soa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import com.klef.soa.entity.Agenda;
import com.klef.soa.repository.AgendaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class AgendatestRepository {

    @Autowired
    private AgendaRepository repository;

    @Test
    void testFindAllAgendas()
    {
        List<Agenda> agendas = repository.findAll();
        assertNotNull(agendas);
        assertFalse(agendas.isEmpty());
        System.out.println("Total Agendas: " + agendas.size());
    }

    @Test
    void testFindAgendaById()
    {
        Optional<Agenda> agenda = repository.findById(3L);
        assertTrue(agenda.isPresent());
        assertEquals(3L, agenda.get().getAgendaId());

        Optional<Agenda> notFound = repository.findById(999L);
        assertFalse(notFound.isPresent());
    }

    @Test
    void testFindAgendaByName()
    {
        List<Agenda> agendas = repository.findByName("Workshop");

        assertNotNull(agendas);
        assertFalse(agendas.isEmpty());
        assertTrue(agendas.stream()
                .allMatch(a -> "Workshop".equals(a.getName())));
    }

    @Test
    void testTotalAgendasCount()
    {
        long count = repository.count();
        assertEquals(6L, count);
    }

    @Test
    void testAgendaDetails()
    {
        Optional<Agenda> user = repository.findById(3L);
        assertTrue(user.isPresent());

        Agenda foundAgenda = user.get();

        assertNotNull(foundAgenda.getName());
        assertNotNull(foundAgenda.getType());
        assertNotNull(foundAgenda.getLocation());
        assertNotNull(foundAgenda.getCreatedAt());
        assertNotNull(foundAgenda.getUpdatedAt());
        assertNotNull(foundAgenda.getStatus());
    }

}
