package com.asylzhan.spring.service;

import com.asylzhan.spring.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie create(Movie movie);
    Movie update(Movie movie);
    void delete(Long id);
    List<Movie> getAll();
    List<Movie> findAllByNameOrDirector(String name, String director);
    Movie findById(long id);

}
