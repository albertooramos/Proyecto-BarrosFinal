package com.jesuitas.Proyecto.Barros.controller;

import com.jesuitas.Proyecto.Barros.domain.Usuario;
import com.jesuitas.Proyecto.Barros.dto.UsuarioDto;
import com.jesuitas.Proyecto.Barros.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> list() {
        List<Usuario> list = usuarioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{idUsuario}")
    public ResponseEntity<Usuario> getByIdUsuario(@PathVariable("idUsuario") int idUsuario) {
        if (!usuarioService.existsByIdUsuario(idUsuario))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Usuario usuario = usuarioService.getOne(idUsuario).get();
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @GetMapping("/detail/{nombreUsuario}")
    public ResponseEntity<Usuario> getNombreUsuario(@PathVariable("nombreUsuario") int nombreUsuario) {
        if (!usuarioService.existsByIdUsuario(nombreUsuario))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Usuario usuario = usuarioService.getOne(nombreUsuario).get();
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UsuarioDto usuarioDto) {
        if (usuarioService.existsByIdUsuario(usuarioDto.getIdUsuario()))
            return new ResponseEntity(new Mensaje("el id ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario = new Usuario(usuarioDto.getIdUsuario(), usuarioDto.getNombreUsuario(), usuarioDto.getContrasenia());
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{idUsuario}")
    public ResponseEntity<?> update(@PathVariable("idUsuario") int idUsuario, @RequestBody UsuarioDto usuarioDto) {
        if (!usuarioService.existsByIdUsuario(idUsuario))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if (usuarioService.existsByNombreUsuario(usuarioDto.getNombreUsuario()) && usuarioService.getByNombreUsuario(usuarioDto.getNombreUsuario()).get().getIdUsuario() != idUsuario)
            return new ResponseEntity(new Mensaje("ese usuario ya existe"), HttpStatus.BAD_REQUEST);

        Usuario usuario = usuarioService.getOne(idUsuario).get();
        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuario.setContrasenia(usuarioDto.getContrasenia());
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("usuario actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idUsuario}")
    public ResponseEntity<?> delete(@PathVariable("idUsuario") int idUsuario) {
        if (!usuarioService.existsByIdUsuario(idUsuario))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        usuarioService.delete(idUsuario);
        return new ResponseEntity(new Mensaje("usuario eliminado"), HttpStatus.OK);
    }
}
