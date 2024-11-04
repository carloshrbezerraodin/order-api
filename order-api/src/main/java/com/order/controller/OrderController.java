package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.Pedido;
import com.order.model.Produto;
import com.order.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/save-order")
	public ResponseEntity<Object> save_order(@RequestBody Pedido pedido) throws Exception {
		try {
			return ResponseEntity.ok(this.orderService.saveOrder(pedido));
		} catch (Exception e) {
			return ResponseEntity.ofNullable(e.getMessage());
		}
	}

	@GetMapping("/listar")
	public List<Pedido> listar() throws Exception {
		try {
			return this.orderService.listar();
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@GetMapping("/buscar/{id}")
	public Pedido buscar(@PathVariable Long id) throws Exception {
		try {
			return this.orderService.buscar(id);
		} catch (Exception e) {
			throw new Exception();
		}
	}


}
