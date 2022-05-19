package edu.dh.seriesService.api.queue;

import edu.dh.seriesService.domain.model.Serie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeriesSender {

    private final RabbitTemplate rabbitTemplate;

    private final Queue seriesQueue;

    public void send(Serie series){
        this.rabbitTemplate.convertAndSend(this.seriesQueue.getName(), series);
    }

}
