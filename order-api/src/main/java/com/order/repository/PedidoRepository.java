package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	Pedido findByUuid(String uuid);
}
