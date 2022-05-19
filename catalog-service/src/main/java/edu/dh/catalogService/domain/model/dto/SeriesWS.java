package edu.dh.catalogService.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeriesWS {

    private String id;
    private String name;
    private String genre;
    private List<SeasonWS> seasons;

    public SeriesWS(String name, String genre, List<SeasonWS> seasons) {
        this.name = name;
        this.genre = genre;
        this.seasons = seasons;
    }
}
