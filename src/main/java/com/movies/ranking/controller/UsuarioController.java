package com.movies.ranking.controller;

import com.movies.ranking.model.Usuario;
import com.movies.ranking.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Usuario>> finById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

   @PostMapping
   public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {

       Usuario usuario1 = usuarioService.salvar(usuario);

       URI uri = ServletUriComponentsBuilder
               .fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(usuario1.getId())
               .toUri();

       return ResponseEntity.created(uri).body(usuario1);
   }
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete( @PathVariable Long id){
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
   }

}
