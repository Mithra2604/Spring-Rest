package com.example.SpringRest.repository;

import com.example.SpringRest.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Movie findByMoviename(String name);

    List<Movie> findByReviews(String review);

}
