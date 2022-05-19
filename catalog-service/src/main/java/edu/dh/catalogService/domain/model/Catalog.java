package edu.dh.catalogService.domain.model;

import edu.dh.catalogService.domain.model.dto.MovieWS;
import edu.dh.catalogService.domain.model.dto.SeriesWS;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Catalog {

    @Id
    private String genre;
    private List<MovieWS> movies;
    private List<SeriesWS> series;

    public Catalog(String genre, List<MovieWS> movies, List<SeriesWS> series) {
        this.genre = genre;
        this.movies = movies;
        this.series = series;
    }
}
