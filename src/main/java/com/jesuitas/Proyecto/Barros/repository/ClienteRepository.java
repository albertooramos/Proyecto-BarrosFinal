package com.jesuitas.Proyecto.Barros.repository;

import com.jesuitas.Proyecto.Barros.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {
    Optional<Cliente> findByIdCliente(Integer idCliente);

    boolean existsByIdCliente(Integer idCliente);

    Optional<Cliente> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
