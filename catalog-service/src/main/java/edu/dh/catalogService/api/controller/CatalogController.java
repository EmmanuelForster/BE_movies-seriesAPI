package edu.dh.catalogService.api.controller;

import edu.dh.catalogService.domain.model.Catalog;
import edu.dh.catalogService.domain.model.dto.CatalogWS;
import edu.dh.catalogService.api.service.impl.CatalogService;
import edu.dh.catalogService.domain.model.dto.MovieWS;
import edu.dh.catalogService.domain.model.dto.SeriesWS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("catalog/")
public class CatalogController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/{genre}")
    ResponseEntity<CatalogWS> getCatalogByGenre(@PathVariable String genre) {
        log.info("Buscando el catalogo de peliculas y series con el genero "+ genre);
        return ResponseEntity.ok().body(catalogService.getByGenre(genre));
    }

    @PostMapping("/saveMovie")
    ResponseEntity<Catalog> saveMovie(@RequestParam MovieWS movie) {
        log.info("Guardando la pelicula " + movie.getName());
        return ResponseEntity.ok().body(catalogService.saveMovie(movie));
    }

    @PostMapping("/saveSeries")
    ResponseEntity<Catalog> saveSeries(@RequestParam SeriesWS series) {
        log.info("Guardando la serie " + series.getName());
        return ResponseEntity.ok().body(catalogService.saveSeries(series));
    }

}
