package com.jesuitas.Proyecto.Barros.controller;

import com.jesuitas.Proyecto.Barros.domain.Cliente;
import com.jesuitas.Proyecto.Barros.domain.Evento;
import com.jesuitas.Proyecto.Barros.dto.EventoDto;
import com.jesuitas.Proyecto.Barros.service.EventoService;
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
@RequestMapping("/evento")
@CrossOrigin("*")
public class EventoController {
    @Autowired
    EventoService eventoService;

    @GetMapping("/lista")
    public ResponseEntity<Page<Evento>> list(@PageableDefault(size =100,page=0) Pageable pageable, @SearchSpec Specification<Evento> specs) {
        Page<Evento> list = eventoService.list(pageable, specs);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{idEvento}")
    public ResponseEntity<Evento> getByIdEvento(@PathVariable("idEvento") int idEvento) {
        if (!eventoService.existsByIdEvento(idEvento))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Evento evento = eventoService.getOne(idEvento).get();
        return new ResponseEntity<Evento>(evento, HttpStatus.OK);
    }

    /*@GetMapping("/detail/{nombre}")
    public ResponseEntity<Evento> getNombre(@PathVariable("nombre") int nombre) {
        if (!clienteService.existsByIdCliente(nombre))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Cliente cliente = clienteService.getOne(nombre).get();
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }*/

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EventoDto eventoDto) {
        //if (eventoService.existsByIdEvento(eventoDto.getIdEvento()))
        //    return new ResponseEntity(new Mensaje("el id ya existe"), HttpStatus.BAD_REQUEST);
        Evento evento = new Evento(

                eventoDto.getTipoEvento(),
                eventoDto.getFecha(),
                eventoDto.getHoraInicio(),
                eventoDto.getHoraFin(),
                eventoDto.getComidaCena(),
                eventoDto.getSalon(),
                eventoDto.getNumeroComensales(),
                eventoDto.getNumeroContratoAsociado(),
                eventoDto.getMenu(),
                eventoDto.getMenuInfantil(),
                eventoDto.getMenuEspecial(),
                eventoDto.getPlanos(),
                eventoDto.getDj(),
                eventoDto.getMusicaSalon(),
                eventoDto.getMusicaAperitivo(),
                eventoDto.getMusicaBaile(),
                eventoDto.getBarraLibre(),
                eventoDto.getFlores(),
                eventoDto.getCeremoniaBarros(),
                eventoDto.getAutobuses(),
                eventoDto.getBonoAutobus(),
                eventoDto.getBonoHotel(),
                eventoDto.getVinos(),
                eventoDto.getCava(),
                eventoDto.getRincones(),
                eventoDto.getDecoracion(),
                eventoDto.getNotas(),
                eventoDto.getClientes()
        );
        eventoService.save(evento);
        return new ResponseEntity(new Mensaje("evento creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{idEvento}")
    public ResponseEntity<?> update(@PathVariable("idEvento") int idEvento, @RequestBody EventoDto eventoDto) {
        if (!eventoService.existsByIdEvento(idEvento))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
       else{
            //return new ResponseEntity(new Mensaje("ese evento ya existe"), HttpStatus.BAD_REQUEST);

            Evento evento = eventoService.getOne(idEvento).get();
            evento.setTipoEvento(eventoDto.getTipoEvento());
            evento.setFecha(eventoDto.getFecha());
            evento.setHoraInicio(eventoDto.getHoraInicio());
            evento.setHoraFin(eventoDto.getHoraFin());
            evento.setComidaCena(eventoDto.getComidaCena());
            evento.setSalon(eventoDto.getSalon());
            evento.setNumeroComensales(eventoDto.getNumeroComensales());
            evento.setNumeroContratoAsociado(eventoDto.getNumeroContratoAsociado());
            evento.setMenu(eventoDto.getMenu());
            evento.setMenuInfantil(eventoDto.getMenuInfantil());
            evento.setMenuEspecial(eventoDto.getMenuEspecial());
            evento.setPlanos(eventoDto.getPlanos());
            evento.setDj(eventoDto.getDj());
            evento.setMusicaSalon(eventoDto.getMusicaSalon());
            evento.setMusicaAperitivo(eventoDto.getMusicaAperitivo());
            evento.setMusicaBaile(eventoDto.getMusicaBaile());
            evento.setBarraLibre(eventoDto.getBarraLibre());
            evento.setFlores(eventoDto.getFlores());
            evento.setCeremoniaBarros(eventoDto.getCeremoniaBarros());
            evento.setAutobuses(eventoDto.getAutobuses());
            evento.setBonoAutobus(eventoDto.getBonoAutobus());
            evento.setBonoHotel(eventoDto.getBonoHotel());
            evento.setVinos(eventoDto.getVinos());
            evento.setCava(eventoDto.getCava());
            evento.setRincones(eventoDto.getRincones());
            evento.setDecoracion(eventoDto.getDecoracion());
            evento.setNotas(eventoDto.getNotas());
            eventoService.save(evento);
            return new ResponseEntity(new Mensaje("evento actualizado"), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{idEvento}")
    public ResponseEntity<?> delete(@PathVariable("idEvento") int idEvento) {
        if (!eventoService.existsByIdEvento(idEvento))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        eventoService.delete(idEvento);
        return new ResponseEntity(new Mensaje("cliente eliminado"), HttpStatus.OK);
    }
}
