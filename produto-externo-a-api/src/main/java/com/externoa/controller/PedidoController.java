package com.externoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.externoa.model.Pedido;
import com.externoa.service.PedidoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/externo-a")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;

	@PostMapping("/pedido")
	public ResponseEntity<Object> pedido(@RequestBody Pedido pedido) throws Exception {
		try {
			return ResponseEntity.ok(this.pedidoService.recebimentoPedido(pedido));
		} catch (Exception e) {
			return ResponseEntity.ofNullable(e.getMessage());
		}
	}

}
