package com.example.SpringRest.controller;

import com.example.SpringRest.models.Movie;
import com.example.SpringRest.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService service;

    @PostMapping("/addmovie")
    public Movie addmovie(@RequestBody Movie movie) {
        return service.addmovie(movie);

    }

    @GetMapping("/getallMovie")
    public List<Movie> getallmovie() {
        return service.getallmovie();
    }


    @PutMapping("/update/{id}")
    public String updatemovie(@PathVariable int id, @RequestBody Movie movie)
    {
        return service.updatemovie(id, movie);
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deletebyid(@PathVariable int id)
    {
        return service.deletebyid(id);
    }

    @GetMapping("/getbyMovieName/{name}")
    public Movie getByName(@PathVariable String name) {
        return service.getByMovieName(name);
    }

    @GetMapping("/getbyreview/{review}")
    public List<Movie> getbyreview(@PathVariable String review) {
        return service.getByreview(review);
    }

}
