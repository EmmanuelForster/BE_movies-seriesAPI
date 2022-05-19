package edu.dh.catalogService.rabbitConfig;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {


    @Value("${queue.movie.name}")
    private String movieQueue;

    @Bean
    public Queue movieQueue() {
        return new Queue(this.movieQueue, true);
    }

    @Value("${queue.series.name}")
    private String seriesQueue;

    @Bean
    public Queue seriesQueue() {
        return new Queue(this.seriesQueue, true);
    }
}
