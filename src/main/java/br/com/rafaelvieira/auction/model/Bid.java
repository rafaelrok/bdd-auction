package br.com.rafaelvieira.auction.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private BigDecimal valor;

	@NotNull
	private LocalDate data;

	@OneToOne(fetch = FetchType.EAGER)
	private User user;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Auction auction;

	@Deprecated
	public Bid() {}
	
	public Bid(User user, BigDecimal valor) {
		if (valor.doubleValue() <= 0) {
			throw new IllegalArgumentException();
		}
		this.user = user;
		this.valor = valor;
		this.data = LocalDate.now();
	}

	public Bid(@NotNull @DecimalMin("0.1") BigDecimal valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public User getUsuario() {
		return user;
	}

	public void setUsuario(User user) {
		this.user = user;
	}

	public Auction getLeilao() {
		return auction;
	}

	public void setLeilao(Auction auction) {
		this.auction = auction;
	}

}
