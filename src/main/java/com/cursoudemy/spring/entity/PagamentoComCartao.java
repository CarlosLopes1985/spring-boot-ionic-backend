package com.cursoudemy.spring.entity;

import javax.persistence.Entity;

import com.cursoudemy.spring.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numParcelas;
	
	public PagamentoComCartao(Integer numParcelas) {
		this.numParcelas = numParcelas;
	}

	public PagamentoComCartao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numParcelas) {
		super(id, estado, pedido);
		this.numParcelas = numParcelas;
		// TODO Auto-generated constructor stub
	}

	public Integer getNumParcelas() {
		return numParcelas;
	}

	public void setNumParcelas(Integer numParcelas) {
		this.numParcelas = numParcelas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
