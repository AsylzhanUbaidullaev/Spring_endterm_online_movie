package com.asylzhan.spring.controller;

import com.asylzhan.spring.entity.Movie;
import com.asylzhan.spring.repo.MovieRepo;
import com.asylzhan.spring.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieRepo movieRepo;

    @GetMapping("")
    public String getAllMovies(Model model) {
        Iterable<Movie> movies = movieService.getAll();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        Optional<Movie> movie = movieRepo.findById(id);
        ArrayList<Movie> res = new ArrayList<>();
        movie.ifPresent(res::add);
        model.addAttribute("movie", res);
        return "movie-details";
    }

//    @GetMapping("/{id}")
//    public Movie getById(@PathVariable("id") Long id) {
//        return movieService.findById(id);
//    }

    @GetMapping("/find")
    public List<Movie> getMovieByNameAndDirector(@RequestParam("name") String name,
                                                 @RequestParam("director") String director) {
        return movieService.findAllByNameOrDirector(name, director);
    }

    @PostMapping("/add")
    public String createMovie(
//                                @RequestParam String name,
//                              @RequestParam String genre,
//                              @RequestParam String premiere,
//                              @RequestParam String director,
//                              @RequestParam String img
                                @RequestBody Movie movie,
                                Model model
                                ) {
//        movie = new Movie(name,genre, premiere, director, img);
        movieService.create(movie);
        model.addAttribute("movie-add", movie);
        return "redirect:/movies";
    }

//    @PostMapping("/add")
//    public Movie createMovie(@RequestBody Movie movie) {
//        return movieService.create(movie);
//    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }

    @PutMapping("/update")
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.update(movie);
    }
}
