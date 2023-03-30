package br.com.rafaelvieira.auction.acceptance;

import br.com.rafaelvieira.auction.model.Lance;
import br.com.rafaelvieira.auction.model.Leilao;
import br.com.rafaelvieira.auction.model.Usuario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.math.BigDecimal;

public class PropondoLanceSteps {

    private Lance lance;
    private Leilao leilao;

    @Given("Dado um lance valido")
    public void dado_um_lance_valido() {
        // Write code here that turns the phrase above into concrete actions
        Usuario usuario = new Usuario("Rafael");
        lance = new Lance(usuario, BigDecimal.TEN);
    }

    @When("Quando propoe lance")
    public void quando_propoe_lance() {
        // Write code here that turns the phrase above into concrete actions
        leilao = new Leilao("Macbook Pro 15");
        leilao.propoe(lance);
    }

    @Then("O lance deve ser aceito")
    public void o_lance_deve_ser_aceito() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }

}
