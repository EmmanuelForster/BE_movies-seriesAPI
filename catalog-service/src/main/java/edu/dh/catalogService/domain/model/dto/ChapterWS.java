package edu.dh.catalogService.domain.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChapterWS {

    private Integer id;
    private String name;
    private Integer number;
    private String urlStream;

    public ChapterWS(String name, Integer number, String urlStream) {
        this.name = name;
        this.number = number;
        this.urlStream = urlStream;
    }

}
