package com.example.cinema_API.components;

import com.example.cinema_API.models.Movie;
import com.example.cinema_API.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieService movieService;

    @Override
    public void run(ApplicationArguments args) throws Exception{

        Movie moana = new Movie("Moana", "12A", 120);
        Movie cinderella = new Movie("Cinderella", "12A", 180);
        Movie spiderman = new Movie("Spiderman", "15", 115);
        Movie godzilla = new Movie("Godzilla", "15", 180);
        Movie shrek =new Movie("Shrek", "12A", 130);

        movieService.addNewMovie(moana);
        movieService.addNewMovie(cinderella);
        movieService.addNewMovie(spiderman);
        movieService.addNewMovie(godzilla);
        movieService.addNewMovie(shrek);

    }
}