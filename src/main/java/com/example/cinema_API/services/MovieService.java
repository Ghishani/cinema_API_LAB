package com.example.cinema_API.services;

import com.example.cinema_API.models.Movie;
import com.example.cinema_API.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }

    public Movie addNewMovie(Movie newMovie){
        return movieRepository.save(newMovie);
    }

    public Movie updateMovie(Movie newMovie){
        return movieRepository.save(newMovie);
    }

    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }
}
