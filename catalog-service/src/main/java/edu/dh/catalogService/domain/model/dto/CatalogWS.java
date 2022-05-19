package edu.dh.catalogService.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@JsonIgnoreProperties
@NoArgsConstructor
@Builder
public class CatalogWS {

    private String genre;
    private List<MovieWS> moviesws;
    private List<SeriesWS> serieWS;

    public CatalogWS (String genre, List<MovieWS> moviesws, List<SeriesWS> serieWS){
        this.genre = genre;
        this.moviesws = moviesws;
        this.serieWS = serieWS;
    }
}
