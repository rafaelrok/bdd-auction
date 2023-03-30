package br.com.rafaelvieira.auction.acceptance;

import br.com.rafaelvieira.auction.model.Auction;
import br.com.rafaelvieira.auction.model.Bid;
import br.com.rafaelvieira.auction.model.User;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.math.BigDecimal;

public class ProposeBidSteps {

    private Bid bid;
    private Auction auction;

    @Given("Given a valid bid")
    public void whenValidBid() {
        // Write code here that turns the phrase above into concrete actions
        User user = new User("Rafael");
        bid = new Bid(user, BigDecimal.TEN);
    }

    @When("When propose bid")
    public void whenProposeBid() {
        // Write code here that turns the phrase above into concrete actions
        auction = new Auction("Macbook Pro 15");
        auction.propoe(bid);
    }

    @Then("the bid must be accepted")
    public void bidMustBeAccepted() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(1, auction.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, auction.getLances().get(0).getValor());
    }

}
