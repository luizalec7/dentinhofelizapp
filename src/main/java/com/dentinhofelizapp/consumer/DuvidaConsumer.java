package com.dentinhofelizapp.consumer;

import com.dentinhofelizapp.model.Duvida;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DuvidaConsumer {

    @RabbitListener(queues = "duvidas-queue")
    public void consumirDuvida(Duvida duvida) {
        System.out.println("Mensagem recebida da fila: " + duvida.getPergunta());
    }
}