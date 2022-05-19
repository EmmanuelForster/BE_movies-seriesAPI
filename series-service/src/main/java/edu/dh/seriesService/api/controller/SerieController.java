package edu.dh.seriesService.api.controller;

import edu.dh.seriesService.domain.model.Serie;
import edu.dh.seriesService.api.service.impl.SerieService;
import edu.dh.seriesService.api.queue.SeriesSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/series")
public class SerieController {

    private final SerieService serieService;

    private final SeriesSender seriesSender;

    @Autowired
    public SerieController(SerieService serieService, SeriesSender seriesSender) {
        this.serieService = serieService;
        this.seriesSender = seriesSender;
    }


    @GetMapping("/all")
    public ResponseEntity<?> findAllSeries(){
        log.info("Solicitando todas las series");
        return ResponseEntity.ok().body(serieService.getAllSeries());
    }

    @GetMapping("/{genre}")
    public ResponseEntity<?> findAllByGenre(@PathVariable String genre){
        log.info("Solicitando todas las series por el genero " + genre);
        return ResponseEntity.ok().body(serieService.findByGenre(genre));
    }

    @PostMapping("/saveSerie")
    public ResponseEntity<Serie> saveSerie(@RequestBody Serie serie){
        log.info("Guardando la serie " + serie.getName());
        var response = serieService.saveSerie(serie);
        seriesSender.send(response);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete/{seriesName}")
    public ResponseEntity<?> deleteSeriesByName(String name){
        log.info("Borrando la serie " + name);
        serieService.deleteSeriesByName(name);
        return ResponseEntity.ok().body("Se elimino la serie " + name);
    }
}