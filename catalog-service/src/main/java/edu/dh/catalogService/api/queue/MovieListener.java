package edu.dh.catalogService.api.queue;

import edu.dh.catalogService.api.service.impl.CatalogService;
import edu.dh.catalogService.domain.model.dto.MovieWS;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieListener {

    private final CatalogService catalogService;

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receive(@Payload MovieWS movieWS){
        catalogService.saveMovie(movieWS);
    }


}
