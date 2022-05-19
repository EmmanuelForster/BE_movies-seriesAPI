package edu.dh.catalogService.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieWS {

    private Long id;

    private String name;

    private String genre;

    private String urlStream;

    public MovieWS(String name, String genre, String urlStream) {
        this.name = name;
        this.genre = genre;
        this.urlStream = urlStream;
    }
}
