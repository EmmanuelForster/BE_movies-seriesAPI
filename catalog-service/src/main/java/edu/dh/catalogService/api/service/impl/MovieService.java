package edu.dh.catalogService.api.service.impl;

import edu.dh.catalogService.api.service.IMovieService;
import edu.dh.catalogService.domain.model.dto.MovieWS;
import edu.dh.catalogService.repository.IMovieRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MovieService implements IMovieService {

    private final IMovieRepository movieRepository;

    @Autowired
    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieWS> getAllMovies() {
        return movieRepository.getAll();
    }

    @CircuitBreaker(name = "movie",fallbackMethod = "moviesFallbackMethod")
    @Retry(name = "movie")
    @Override
    public List<MovieWS> getAllByGenre(String genre) {
        return movieRepository.getMoviesByGenre(genre);
    }

    @Override
    public MovieWS saveMovie(MovieWS movieWS) {
        return movieRepository.saveMovie(movieWS);
    }

    public List<MovieWS> moviesFallbackMethod(Throwable t){
        log.error("Se activo el metodo Fallback en el service de peliculas: " + t.getMessage());
        ArrayList array = new ArrayList<>();
        return array;
    }
    
}
