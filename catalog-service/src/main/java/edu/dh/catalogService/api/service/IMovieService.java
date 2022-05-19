package edu.dh.catalogService.api.service;

import edu.dh.catalogService.domain.model.dto.MovieWS;

import java.util.List;

public interface IMovieService {

    List<MovieWS> getAllMovies();

    List<MovieWS> getAllByGenre(String genre);

    MovieWS saveMovie(MovieWS movieWS);
}
