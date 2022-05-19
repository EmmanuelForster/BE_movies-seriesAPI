package edu.dh.catalogService.repository;

import edu.dh.catalogService.consumer.CustomLoadBalancerConfiguration;
import edu.dh.catalogService.domain.model.dto.MovieWS;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="movie-service")
@LoadBalancerClient(name = "movie-service", configuration= CustomLoadBalancerConfiguration.class)
public interface IMovieRepository {

    @GetMapping("/movies/{genre}")
    List<MovieWS> getMoviesByGenre(@PathVariable String genre);

    @PostMapping("/movies/save")
    MovieWS saveMovie(@RequestBody MovieWS movie);

    @GetMapping("/movies/all")
    List<MovieWS> getAll();

}
