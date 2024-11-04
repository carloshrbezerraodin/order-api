package com.externob.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PedidoConsumer {

	@RabbitListener(queues = { "${queue.name}" })
	public void receive(@Payload String pedido) {
		System.out.println("Message " + pedido);
	}

}