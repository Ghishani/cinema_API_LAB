package com.example.cinema_API.repositories;

import com.example.cinema_API.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
