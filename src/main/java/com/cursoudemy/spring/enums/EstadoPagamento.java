package com.cursoudemy.spring.enums;

public enum EstadoPagamento {

	PENDENTE(1,"Pendente"),QUITADO(2, "Quitado"),CANCELADO(3,"Cancelado");
	
	private int cod;
	private String nome;
	
	private EstadoPagamento(int cod, String nome) {
		this.cod = cod;
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public String getNome() {
		return nome;
	}

	public static EstadoPagamento toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for (EstadoPagamento x : EstadoPagamento.values()) {
			
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("id inválido: " +cod );
	}
	
	
}