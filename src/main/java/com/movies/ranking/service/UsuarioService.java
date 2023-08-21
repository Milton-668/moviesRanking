package com.movies.ranking.service;

import com.movies.ranking.model.Usuario;
import com.movies.ranking.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return  usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return Optional.ofNullable(usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found")));
    }

    public void deleteById(Long id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }
}
