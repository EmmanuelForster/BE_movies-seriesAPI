package edu.dh.catalogService.repository;

import edu.dh.catalogService.consumer.CustomLoadBalancerConfiguration;
import edu.dh.catalogService.domain.model.dto.SeriesWS;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="series-service")
@LoadBalancerClient(name = "series-service", configuration= CustomLoadBalancerConfiguration.class)
public interface ISeriesRepository {

    @GetMapping("/series/{genre}")
    List<SeriesWS> getSeriesByGenre(@PathVariable String genre);

    @PostMapping("/series/save")
    SeriesWS saveSerie(@RequestBody SeriesWS serie);

    @GetMapping("/series/all")
    List<SeriesWS> getSerie();

}
