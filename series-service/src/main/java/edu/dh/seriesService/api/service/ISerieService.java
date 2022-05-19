package edu.dh.seriesService.api.service;

import edu.dh.seriesService.domain.model.Serie;

import java.util.List;

public interface ISerieService {

    List<Serie> getAllSeries();
    List<Serie> findByGenre(String genre);
    Serie saveSerie(Serie serie);
    void deleteSeriesByName(String name);

}