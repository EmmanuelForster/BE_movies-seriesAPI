package edu.dh.movieService.repository;

import edu.dh.movieService.domain.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    List<Movie> findAllByGenre(String genre);

    void deleteByName(String name);

}
