package edu.dh.catalogService.api.queue;

import edu.dh.catalogService.api.service.impl.CatalogService;
import edu.dh.catalogService.domain.model.dto.SeriesWS;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeriesListenener {

    private final CatalogService catalogService;

    @RabbitListener(queues = {"${queue.series.name}"})
    public void receive(@Payload SeriesWS serieWS){
        catalogService.saveSeries(serieWS);
    }
}
