package edu.dh.catalogService.api.service;


import edu.dh.catalogService.domain.model.dto.SeriesWS;

import java.util.List;

public interface ISeriesService {

    List<SeriesWS> getAllSeries();

    List<SeriesWS> findSeriesByGenre(String genre);

    SeriesWS saveSeries(SeriesWS series);

}
