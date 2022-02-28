package com.jesuitas.Proyecto.Barros.repository;

import com.jesuitas.Proyecto.Barros.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento,Integer>, JpaSpecificationExecutor<Evento> {
    Optional<Evento> findByIdEvento(Integer idEvento);
    boolean existsByIdEvento(Integer idEvento);
}
