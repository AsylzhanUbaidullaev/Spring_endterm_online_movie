package com.asylzhan.spring.service.impl;

import com.asylzhan.spring.entity.Movie;
import com.asylzhan.spring.repo.MovieRepo;
import com.asylzhan.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public Movie create(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public Movie update(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public void delete(Long id) {
        movieRepo.delete(movieRepo.findById(id).get());
    }

    @Override
    public List<Movie> getAll() {
        return movieRepo.findAll();
    }

    @Override
    public List<Movie> findAllByNameOrDirector(String name, String director) {
        return movieRepo.findAllByNameOrDirector(name, director);
    }

    @Override
    public Movie findById(long id) {
        return movieRepo.findById(id);
    }
}
