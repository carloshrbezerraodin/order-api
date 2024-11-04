package com.order.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.model.Pedido;
import com.order.model.Produto;
import com.order.producer.PedidoProducer;
import com.order.repository.PedidoRepository;
import com.order.repository.ProdutoRepository;

@Service
public class OrderService {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PedidoProducer pedidoProducer;

	
	public List<Pedido> listar() throws Exception {
		return pedidoRepository.findAll();
	}

	public Pedido buscar(Long id) throws Exception {
		return pedidoRepository.findById(id).get();
	}

	public Pedido saveOrder(Pedido pedido) throws Exception {
		BigDecimal valorTotalProduto = pedido.getProdutos().stream()
         .map(Produto::getValor)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
		
		Integer totalQuantidade = pedido.getProdutos().stream()
			    .map(Produto::getQuantidade)
			    .reduce(0, Integer::sum);
		
		BigDecimal valorTotalPedido = valorTotalProduto.multiply(new BigDecimal(totalQuantidade));
		String uuid = pedido.getCliente() + pedido.getData() + valorTotalPedido.toString();
		
		if (pedido.getProdutos() != null) {
	        pedido.getProdutos().forEach(produto -> produto.setPedido(pedido));
	    }

		pedido.setValorTotalProdutos(valorTotalPedido);
		pedido.setUuid(uuid);
		
		if (pedidoDuplicado(uuid)) {
			 throw new Exception("Pedido duplicado");
		}

		Pedido pedidoSave = pedidoRepository.save(pedido);
		
		String message = pedidoSave.toString();
		
		pedidoProducer.send(message);
		
		return pedidoSave;
		
	}
	
	
	/**
	 * Verificar Duplicacao de pedidos
	 */
	public boolean pedidoDuplicado(String uuid) {
		return pedidoRepository.findByUuid(uuid) != null;
	}

}
