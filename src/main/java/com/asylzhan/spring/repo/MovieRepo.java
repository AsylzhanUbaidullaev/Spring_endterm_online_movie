package com.asylzhan.spring.repo;

import com.asylzhan.spring.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

    List<Movie> findAllByNameOrDirector(String name, String director);
    Movie findById(long id);
}
