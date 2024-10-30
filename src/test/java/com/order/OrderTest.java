package com.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.model.Pedido;
import com.order.model.Produto;
import com.order.service.OrderService;

@SpringBootTest
public class OrderTest {
	
	
	@Autowired
	OrderService orderService;
	

	@Test
	public void testSalvarProduto() throws Exception {

		Produto produto = Produto.builder().nome("Teste produto").quantidade(12).build();
		Produto produtoDB = orderService.salvarOrAtualizar(produto);
		assertEquals(produto.getNome(), produtoDB.getNome());
	}

	@Test
	public void testListarPedido() throws Exception {
		
		List<Pedido> listarProduto = orderService.listar();
		
		assertTrue(listarProduto.size() > 0);

	}
	
}
