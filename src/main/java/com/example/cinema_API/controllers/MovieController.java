package com.example.cinema_API.controllers;



import com.example.cinema_API.models.Movie;
import com.example.cinema_API.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")

public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getMovieDatabase() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Optional<Movie> movie = movieService.getMovieById(id);

        if (movie.isPresent()) {
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie newMovie) {

        Movie savedMovie = movieService.addNewMovie(newMovie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED); // 200 - OK, 201 - CREATED
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie){
        movie.setId(id);
        movieService.updateMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

}

