package com.asylzhan.spring.controller;

import com.asylzhan.spring.entity.Movie;
import com.asylzhan.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("")
    public List<Movie> getAllMovies() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable("id") Long id) {
        return movieService.findById(id);
    }

    @GetMapping("/find")
    public List<Movie> getMovieByNameAndDirector(@RequestParam("name") String name,
                                                 @RequestParam("director") String director) {
        return movieService.findAllByNameOrDirector(name, director);
    }

    @PostMapping("")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.create(movie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }

    @PutMapping("/update")
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.update(movie);
    }
}
