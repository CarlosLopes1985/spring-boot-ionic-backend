package com.cursoudemy.spring.resource.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Long timeStamp;
	
	public StandardError(Integer id, String nome, Long timeStamp) {
		super();
		this.id = id;
		this.nome = nome;
		this.timeStamp = timeStamp;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
