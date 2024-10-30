package com.order.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.model.Pedido;

@Component
public class PedidoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(String pedido) {
        rabbitTemplate.convertAndSend(this.queue.getName(), pedido);
    }
}
