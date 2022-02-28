package com.jesuitas.Proyecto.Barros.service;

import com.jesuitas.Proyecto.Barros.domain.Usuario;
import com.jesuitas.Proyecto.Barros.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> list() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getOne(int idUsuario) {
        return usuarioRepository.findByIdUsuario(idUsuario);
    }

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void delete(int idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    public boolean existsByIdUsuario(int idUsuario) {
        return usuarioRepository.existsByIdUsuario(idUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }


}
