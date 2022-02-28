package com.jesuitas.Proyecto.Barros.service;


import com.jesuitas.Proyecto.Barros.domain.Cliente;
import com.jesuitas.Proyecto.Barros.domain.Evento;
import com.jesuitas.Proyecto.Barros.repository.EventoRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventoService {

    @Autowired
    EventoRepository eventoRepository;

    public Page<Evento> list(Pageable pageable, @SearchSpec Specification<Evento> specs) {
        return eventoRepository.findAll(specs, pageable);
    }

    public Optional<Evento> getOne(int idEvento) {
        return eventoRepository.findByIdEvento(idEvento);
    }

    /*public Optional<Evento> getByTipoEvento(String tipoEvento) {
        return eventoRepository.findByTipoEvento(tipoEvento);
    }*/

    public void save(Evento evento) {
        eventoRepository.save(evento);
    }

    public void delete(int idEvento) {
        eventoRepository.deleteById(idEvento);
    }

    public boolean existsByIdEvento(int idEvento) {
        return eventoRepository.existsByIdEvento(idEvento);
    }

    /*public boolean existsByNombre(String nombre) {
        return clienteRepository.existsByNombre(nombre);
    }*/
}
