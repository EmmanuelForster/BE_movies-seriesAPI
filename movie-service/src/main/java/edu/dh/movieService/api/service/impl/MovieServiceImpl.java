package edu.dh.movieService.api.service.impl;

import edu.dh.movieService.api.service.MovieService;
import edu.dh.movieService.domain.model.Movie;
import edu.dh.movieService.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie saveMovie(Movie m) {
        return movieRepository.insert(m);
    }

    @Override
    public void deleteMovie(String name) {
        movieRepository.deleteByName(name);
    }

    @Override
    public List<Movie> findByGenre(String genre){
        return movieRepository.findAllByGenre(genre);
    }

}
