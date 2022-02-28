package com.jesuitas.Proyecto.Barros.service;

import com.jesuitas.Proyecto.Barros.domain.Cliente;
import com.jesuitas.Proyecto.Barros.repository.ClienteRepository;
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
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Page<Cliente> list(Pageable pageable, @SearchSpec Specification <Cliente> specs) {
        return clienteRepository.findAll(specs, pageable);
    }

    public Optional<Cliente> getOne(int idCliente) {
        return clienteRepository.findByIdCliente(idCliente);
    }

    public Optional<Cliente> getByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void delete(int idCliente) {
        clienteRepository.deleteById(idCliente);
    }

    public boolean existsByIdCliente(int idCliente) {
        return clienteRepository.existsByIdCliente(idCliente);
    }

    public boolean existsByNombre(String nombre) {
        return clienteRepository.existsByNombre(nombre);
    }


}