package edu.dh.catalogService.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonWS {

    private Integer id;
    private Integer seasonNumber;
    private List<SeriesWS> urlStream;

    public SeasonWS(Integer seasonNumber, List<SeriesWS> urlStream) {
        this.seasonNumber = seasonNumber;
        this.urlStream = urlStream;
    }

}
