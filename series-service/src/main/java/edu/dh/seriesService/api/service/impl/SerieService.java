package edu.dh.seriesService.api.service.impl;

import edu.dh.seriesService.api.service.ISerieService;
import edu.dh.seriesService.domain.model.Serie;
import edu.dh.seriesService.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService {

    public final SerieRepository serieRepository;

    @Autowired
    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }


    @Override
    public List<Serie> getAllSeries() {
        return serieRepository.findAll();
    }

    @Override
    public List<Serie> findByGenre(String genre) {
        return serieRepository.findAllByGenre(genre);
    }

    @Override
    public Serie saveSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    @Override
    public void deleteSeriesByName(String name) {
        serieRepository.deleteSerieByName(name);
    }
}