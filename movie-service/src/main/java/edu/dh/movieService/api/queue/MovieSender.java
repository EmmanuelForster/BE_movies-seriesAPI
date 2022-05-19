package edu.dh.movieService.api.queue;

import edu.dh.movieService.domain.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class MovieSender {

    private final RabbitTemplate rabbitTemplate;
    private final Queue movieQueue;

    public Movie send (Movie movie){
        this.rabbitTemplate.convertAndSend(this.movieQueue.getName(), movie);
        return movie;
    }
}