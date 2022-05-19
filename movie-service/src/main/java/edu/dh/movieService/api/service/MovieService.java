package edu.dh.movieService.api.service;

import edu.dh.movieService.domain.model.Movie;

import java.util.List;

public interface MovieService {

     List<Movie> getAllMovies();

     Movie saveMovie(Movie m);

    void deleteMovie(String name);

    List<Movie> findByGenre(String genre);

}
