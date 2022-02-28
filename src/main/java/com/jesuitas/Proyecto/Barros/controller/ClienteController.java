package com.jesuitas.Proyecto.Barros.controller;

import com.jesuitas.Proyecto.Barros.domain.Cliente;
import com.jesuitas.Proyecto.Barros.dto.ClienteDto;
import com.jesuitas.Proyecto.Barros.service.ClienteService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/lista")
    public ResponseEntity<Page<Cliente>> list(@PageableDefault(size =5,page=0) Pageable pageable, @SearchSpec Specification<Cliente> specs) {
        Page<Cliente> list = clienteService.list(pageable, specs);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{idCliente}")
    public ResponseEntity<Cliente> getByIdCliente(@PathVariable("idCliente") int idCliente) {
        if (!clienteService.existsByIdCliente(idCliente))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Cliente cliente = clienteService.getOne(idCliente).get();
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @GetMapping("/detail/{nombre}")
    public ResponseEntity<Cliente> getNombre(@PathVariable("nombre") int nombre) {
        if (!clienteService.existsByIdCliente(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Cliente cliente = clienteService.getOne(nombre).get();
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto) {
        //if (clienteService.existsByIdCliente(clienteDto.getIdCliente()))
        //    return new ResponseEntity(new Mensaje("el id ya existe"), HttpStatus.BAD_REQUEST);
        Cliente cliente = new Cliente( clienteDto.getNombre(), clienteDto.getTelefono(), clienteDto.getEmail(), clienteDto.getOtrosDatos());
        clienteService.save(cliente);
        return new ResponseEntity(new Mensaje("cliente creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{idCliente}")
    public ResponseEntity<?> update(@PathVariable("idCliente") int idCliente, @RequestBody ClienteDto clienteDto) {
        if (!clienteService.existsByIdCliente(idCliente))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if (clienteService.existsByNombre(clienteDto.getNombre()) && clienteService.getByNombre(clienteDto.getNombre()).get().getIdCliente() != idCliente)
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        Cliente cliente = clienteService.getOne(idCliente).get();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setOtrosDatos(clienteDto.getOtrosDatos());
        cliente.setEventos(clienteDto.getEventos());
        clienteService.save(cliente);
        return new ResponseEntity(new Mensaje("cliente actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idCliente}")
    public ResponseEntity<?> delete(@PathVariable("idCliente") int idCliente) {
        if (!clienteService.existsByIdCliente(idCliente))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        clienteService.delete(idCliente);
        return new ResponseEntity(new Mensaje("cliente eliminado"), HttpStatus.OK);
    }
}
