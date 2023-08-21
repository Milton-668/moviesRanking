package com.movies.ranking.service;

import com.movies.ranking.model.Movie;
import com.movies.ranking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> findByIdOrElseThrow(Long id) {
        return Optional.ofNullable(movieRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie not found")));
    }

    public Optional<Movie> findByClassificaOrElseThrow(String classifica) {
        return Optional.ofNullable(movieRepository.findByClassifica(classifica))
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Classificação não encontrada"));
    }
}
