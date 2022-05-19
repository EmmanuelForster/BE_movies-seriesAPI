package edu.dh.catalogService.api.service.impl;

import edu.dh.catalogService.api.service.ISeriesService;
import edu.dh.catalogService.domain.model.dto.SeriesWS;
import edu.dh.catalogService.repository.ISeriesRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SeriesService implements ISeriesService {

    private final ISeriesRepository seriesRepository;

    @Autowired
    public SeriesService(ISeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<SeriesWS> getAllSeries() {
        return seriesRepository.getSerie();
    }

    @CircuitBreaker(name="series", fallbackMethod = "seriesFallbackMethod")
    @Retry(name = "series")
    @Override
    public List<SeriesWS> findSeriesByGenre(String genre) {
        return seriesRepository.getSeriesByGenre(genre);
    }

    @Override
    public SeriesWS saveSeries(SeriesWS series) {
        return seriesRepository.saveSerie(series);
    }

    private List<SeriesWS> seriesFallbackMethod(Throwable t){
        log.error("Se activo el metodo Fallback en el service de series: " + t.getMessage());
        ArrayList array = new ArrayList<>();
        return array;
    }
}
