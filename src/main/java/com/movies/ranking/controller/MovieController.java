package com.movies.ranking.controller;

import com.movies.ranking.model.Movie;
import com.movies.ranking.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {


    @Autowired
    MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> findAll(){
            return ResponseEntity.ok(movieService.listAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Optional<Movie>> findById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.findByIdOrElseThrow(id));
    }
    @GetMapping(path = "/classifica/{classifica}")
    public ResponseEntity<Optional<Movie>> findByClassifica(@PathVariable String classifica){
        return ResponseEntity.ok(movieService.findByClassificaOrElseThrow(classifica));
    }

    @PostMapping
    public ResponseEntity<Movie> save(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.save(movie), HttpStatus.CREATED);
    }

}
