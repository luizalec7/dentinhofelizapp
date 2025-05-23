package com.dentinhofelizapp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_DUVIDAS = "duvidas-queue";

    @Bean
    public Queue duvidasQueue() {
        return new Queue(QUEUE_DUVIDAS, false);
    }
}