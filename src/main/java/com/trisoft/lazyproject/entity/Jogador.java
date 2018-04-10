package com.trisoft.lazyproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "jogador")
public class Jogador {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	private String nome;
	private Boolean integrado;
	private String posicao;
	private Double salario;
	@Column(name = "duracao_contrato")
	private Integer duracaoContrato;
	@Column(name = "valor_transferencia")
	private Double valorTransferencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getIntegrado() {
		return integrado;
	}

	public void setIntegrado(Boolean integrado) {
		this.integrado = integrado;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Integer getDuracaoContrato() {
		return duracaoContrato;
	}

	public void setDuracaoContrato(Integer duracaoContrato) {
		this.duracaoContrato = duracaoContrato;
	}

	public Double getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(Double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

}
