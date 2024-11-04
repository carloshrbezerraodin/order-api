package com.externoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.externoa.model.Pedido;
import com.externoa.model.ResponseObject;

@Service
public class PedidoService {

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public ResponseObject recebimentoPedido(Pedido pedido) throws Exception {

		ResponseObject postPedido = restTemplate.postForObject("http://localhost:8085/order/save-order", pedido,
				ResponseObject.class);

		return postPedido;
	}

}