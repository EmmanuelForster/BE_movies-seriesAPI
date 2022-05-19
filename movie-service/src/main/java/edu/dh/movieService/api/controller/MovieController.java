package edu.dh.movieService.api.controller;

import edu.dh.movieService.api.queue.MovieSender;
import edu.dh.movieService.api.service.impl.MovieServiceImpl;
import edu.dh.movieService.domain.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieServiceImpl movieService;
    private MovieSender movieSender;

    @Autowired
    public MovieController(MovieServiceImpl movieService, MovieSender movieSender) {
        this.movieService = movieService;
        this.movieSender = movieSender;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Movie>> findAllByGenre (@PathVariable String genre){
        return ResponseEntity.ok().body(movieService.findByGenre(genre));
    }

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        return ResponseEntity.ok().body(movieSender.send(movie));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAll (Movie movie){
        return ResponseEntity.ok().body(movieService.getAllMovies());
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteMovie (String name){
        return ResponseEntity.ok().body("Se elimino la pelicula con nombre " + name);
    }

}
