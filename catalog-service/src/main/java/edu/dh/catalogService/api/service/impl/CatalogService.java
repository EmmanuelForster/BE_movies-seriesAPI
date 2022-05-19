package edu.dh.catalogService.api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.dh.catalogService.domain.model.Catalog;
import edu.dh.catalogService.domain.model.dto.CatalogWS;
import edu.dh.catalogService.domain.model.dto.MovieWS;
import edu.dh.catalogService.domain.model.dto.SeriesWS;
import edu.dh.catalogService.repository.ICatalogRepository;
import edu.dh.catalogService.api.service.ICatalogService;
import edu.dh.catalogService.api.service.IMovieService;
import edu.dh.catalogService.api.service.ISeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService implements ICatalogService {

    private final MovieService movieService;
    private final SeriesService seriesService;
    private final ICatalogRepository catalogRepository;

    private final ObjectMapper objectMapper;

    @Autowired
    public CatalogService(MovieService movieService, SeriesService seriesService, ICatalogRepository catalogRepository, ObjectMapper objectMapper) {
        this.movieService = movieService;
        this.seriesService = seriesService;
        this.catalogRepository = catalogRepository;
        this.objectMapper = objectMapper;
    }

    public List<MovieWS> getMoviesByGenre(String genre){
        return  movieService.getAllByGenre(genre);
    }

    public List<SeriesWS> getSeriesByGenre(String genre){
        return seriesService.findSeriesByGenre(genre);
    }

    @Override
    public CatalogWS getByGenre(String genre) {

        List<MovieWS> movieWSList = movieService.getAllByGenre(genre);
        List<SeriesWS> serieWSList = seriesService.findSeriesByGenre(genre);

        CatalogWS catalogWS = null;
        Catalog catalog = new Catalog(genre, movieWSList, serieWSList);
        catalogRepository.findByGenre(genre).ifPresent(oldCatalog -> catalogRepository.deleteByGenre(genre));

        catalogRepository.save(catalog);

        return objectMapper.convertValue(catalog, CatalogWS.class);

        }

    @Override
    public Catalog saveMovie(MovieWS movie) {
        Catalog catalog = catalogRepository.findByGenre(movie.getGenre()).orElse(null);
        catalog.getMovies().add(movie);
        return catalogRepository.save(catalog);
    }

    @Override
    public Catalog saveSeries(SeriesWS series) {
        Catalog catalog = catalogRepository.findByGenre(series.getGenre()).orElse(null);
        catalog.getSeries().add(series);
        return catalogRepository.save(catalog);
    }

}
