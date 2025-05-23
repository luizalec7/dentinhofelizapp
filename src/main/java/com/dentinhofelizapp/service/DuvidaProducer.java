package com.dentinhofelizapp.service;

import com.dentinhofelizapp.config.RabbitConfig;
import com.dentinhofelizapp.model.Duvida;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class DuvidaProducer {

    private final RabbitTemplate rabbitTemplate;

    public DuvidaProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarDuvida(Duvida duvida) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_DUVIDAS, duvida);
        System.out.println("Mensagem enviada para a fila: " + duvida.getPergunta());
    }
}