package com.order.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	private String uuid;
	private String data;
	private String cliente;
	private String status;
	
	@OneToMany(mappedBy = "pedido" , cascade = CascadeType.ALL)
	@JsonManagedReference
    private List<Produto> produtos;
	
	private BigDecimal valorTotalProdutos;
	
	public String toString() {
		return "uuid:" + uuid + "data:" + data + "cliente:" + cliente + "status:" + status + "valorTotalProdutos:" + valorTotalProdutos;
	}

}

