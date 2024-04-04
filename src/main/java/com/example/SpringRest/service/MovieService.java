package com.example.SpringRest.service;

import com.example.SpringRest.models.Movie;
import com.example.SpringRest.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository repository;

    public Movie addmovie(@RequestBody Movie movie)
    {
        return repository.save(movie);

    }
    public List<Movie> getallmovie()
    {
        return repository.findAll();
    }
    public String updatemovie(@PathVariable int id, @RequestBody Movie movie){
        Optional<Movie> existingMovie= repository.findById(id);
        if(existingMovie.isEmpty()){
            return "No Movies Found";
        }
        else {
            existingMovie.get().setMoviename((movie.getMoviename()));
            existingMovie.get().setDirector((movie.getDirector()));
            existingMovie.get().setReviews((movie.getReviews()));
            repository.save(existingMovie.get());
            return "Movies Updated";
        }
    }

    public String deletebyid(int id)
    {
        repository.deleteById(id);
        return "Movie Deleted";
    }

    public Movie getByMovieName(String name)
    {
        return repository.findByMoviename(name);
    }

    public List<Movie> getByreview(String review) {
        return repository.findByReviews(review);
    }

}
