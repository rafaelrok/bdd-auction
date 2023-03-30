package br.com.rafaelvieira.auction.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Auction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	private String nome;

	@NotNull
	@DecimalMin(value = "0.1")
	private BigDecimal valorInicial;

	@OneToOne
	@JoinColumn(nullable = false)
	private User user;

	@NotNull
	private LocalDate dataAbertura;

	@OneToMany(mappedBy = "auction")
	private List<Bid> lances = new ArrayList<>();

	@Deprecated
	public Auction() {
	}

	public Auction(@NotNull @NotBlank String nome) {
		this.nome = nome;
	}
	
	public Auction(@NotBlank String nome, @NotNull @DecimalMin("0.1") BigDecimal valorInicial, @NotNull LocalDate dataAbertura) {
		this.nome = nome;
		this.valorInicial = valorInicial;
		this.dataAbertura = dataAbertura;
	}
	

	public Auction(@NotNull @NotBlank String nome, @NotNull @DecimalMin("0.1") BigDecimal valorInicial,
				   @NotNull User user) {
		this.nome = nome;
		this.valorInicial = valorInicial;
		this.user = user;
		this.dataAbertura = LocalDate.now();
	}

	public Auction(@NotNull @NotBlank String nome, @NotNull @DecimalMin("0.1") BigDecimal valorInicial,
				   @NotNull LocalDate data, @NotNull User user) {
		this.nome = nome;
		this.valorInicial = valorInicial;
		this.user = user;
		this.dataAbertura = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public Date getDataAberturaDate() {
		return java.util.Date.from(this.dataAbertura.atStartOfDay()
			      .atZone(ZoneId.systemDefault())
			      .toInstant());
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setValorInicial(BigDecimal valorInicial) {
		this.valorInicial = valorInicial;
	}

	public BigDecimal getValorInicial() {
		return valorInicial;
	}

	public void setUsuario(User user) {
		this.user = user;
	}

	public User getUsuario() {
		return user;
	}

	public void setLances(List<Bid> lances) {
		this.lances = lances;
	}

	public boolean propoe(Bid lanceAtual) {
		
		if (this.estaSemLances() || ehUmLanceValido(lanceAtual)) {
			adicionarLance(lanceAtual);
			return true;
		}
		return false;
	}

	private void adicionarLance(Bid lance) {
		lances.add(lance);
		lance.setLeilao(this);
	}

	private boolean ehUmLanceValido(Bid lance) {
		return valorEhMaior(lance, ultimoLanceDado()) && 
				oUltimoUsuarioNaoEhOMesmoDo(lance) && 
				totalDeLancesDoUsuarioEhMenorIgual5(lance.getUsuario());
	}

	private boolean valorEhMaior(Bid lance, Bid ultimoLanceDado) {
		return lance.getValor().compareTo(ultimoLanceDado.getValor()) > 0;
	}


	private boolean totalDeLancesDoUsuarioEhMenorIgual5(User user) {
		int totalDeLances = qtdDeLancesDo(user);
		return totalDeLances < 5;
	}

	private boolean oUltimoUsuarioNaoEhOMesmoDo(Bid lance) {
		User ultimoUserQueDeuLance = ultimoLanceDado().getUsuario();
		return !ultimoUserQueDeuLance.equals(lance.getUsuario());
	}

	private int qtdDeLancesDo(User user) {
		int total = 0;
		for (Bid l : lances) {
			if (l.getUsuario().equals(user))
				total++;
		}
		return total;
	}
	
	private boolean estaSemLances() {
		return this.lances.isEmpty();
	}

	private Bid ultimoLanceDado() {
		return lances.get(lances.size() - 1);
	}

	public List<Bid> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public boolean temLances() {
		return !this.lances.isEmpty();
	}
}
