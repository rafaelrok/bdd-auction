package br.com.rafaelvieira.auction.acceptance;

import br.com.rafaelvieira.auction.model.Auction;
import br.com.rafaelvieira.auction.model.Bid;
import br.com.rafaelvieira.auction.model.User;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.math.BigDecimal;

public class ProposeBidSteps {

    private Bid bid1;
    private Bid bid2;
    private Auction auction;

    @Given("Given a valid bid")
    public void whenValidBid() {
        User user = new User("Rafael");
        bid1 = new Bid(user, BigDecimal.TEN);
    }

    @When("propose to auction")
    public void whenProposeBid() {
        auction = new Auction("Macbook Pro 15");
        auction.propoe(bid1);
    }

    @Then("the bid must be accepted")
    public void bidMustBeAccepted() {
        Assert.assertEquals(1, auction.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, auction.getLances().get(0).getValor());
    }

    @Given("several valid bids")
    public void several_valid_bids() {
        try{
            User user = new User("Rafael");
            bid1 = new Bid(user, BigDecimal.TEN);
            User user2 = new User("Mayara");
            bid2 = new Bid(user2, new BigDecimal("20.00"));
            auction = new Auction("Intel Pro 15");
        } catch (PendingException e) {
            e.printStackTrace();
        }
    }

    @When("propose multiple bids in the auction")
    public void propose_multiple_bids_in_the_auction() {
        try{
            auction.propoe(bid1);
            auction.propoe(bid2);
        } catch (PendingException e) {
            e.printStackTrace();
        }
    }

    @Then("Bids are accepted")
    public void bids_are_accepted() {
        try{
            Assert.assertEquals(2, auction.getLances().size());
            Assert.assertEquals(BigDecimal.TEN, auction.getLances().get(0).getValor());
            Assert.assertEquals(new BigDecimal("20.00"), auction.getLances().get(1).getValor());
        } catch (PendingException e) {
            e.printStackTrace();
        }
    }

}
