package br.com.rafaelvieira.auction.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.com.rafaelvieira.auction.model.Auction;

public class NewAuctionDto {
	
	private static DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Long id;

	@NotNull
	@NotBlank
	@Size(min = 3, message = "minimo 3 caracteres")
	private String nome;

	@NotNull(message = "deve ser um valor maior de 0.1")
	@DecimalMin(value = "0.1", message = "deve ser um valor maior de 0.1")
	private BigDecimal valorInicial;

	@NotNull(message = "deve ser uma data no formato dd/MM/yyyy")
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "deve ser uma data no formato dd/MM/yyyy")
	private String dataAbertura;

	public NewAuctionDto(Auction auction) {
		this.id = auction.getId();
		this.nome = auction.getNome();
		this.valorInicial = auction.getValorInicial();
		this.dataAbertura = auction.getDataAbertura().format(ofPattern);
	}

	public NewAuctionDto() {
	}

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

	public BigDecimal getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(BigDecimal valorInicial) {
		this.valorInicial = valorInicial;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Auction toLeilao() {
		LocalDate date = LocalDate.parse(this.dataAbertura, ofPattern);
		Auction auction = new Auction(nome, valorInicial, date);
		auction.setId(id);
		return auction;
	}
}
