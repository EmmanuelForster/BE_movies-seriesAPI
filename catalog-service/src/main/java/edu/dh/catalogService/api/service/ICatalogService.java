package edu.dh.catalogService.api.service;

import edu.dh.catalogService.domain.model.Catalog;
import edu.dh.catalogService.domain.model.dto.CatalogWS;
import edu.dh.catalogService.domain.model.dto.MovieWS;
import edu.dh.catalogService.domain.model.dto.SeriesWS;

public interface ICatalogService {

    CatalogWS getByGenre(String genre);
    Catalog saveMovie(MovieWS movieWS);
    Catalog saveSeries(SeriesWS serieWS);

}