package br.com.rafaelvieira.auction.acceptance.steps;

import br.com.rafaelvieira.auction.model.Auction;
import br.com.rafaelvieira.auction.model.Bid;
import br.com.rafaelvieira.auction.model.User;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.math.BigDecimal;
import java.util.ArrayList;

public class ProposeBidSteps {

    private Auction auction;
    private ArrayList<Bid> list;


    @Before
    public void setUp() {
        this.list = new ArrayList<Bid>();
        auction = new Auction("Macbook Pro 15");
    }

    @After
    public void tearDown() {
    }

    @Given("a valid bid with {string}")
    public void validBid(String userName) {
        User user = new User(userName);
        this.list.add(new Bid(user, BigDecimal.TEN));
    }

    @When("propose to auction")
    public void proposeBid() {
        this.list.forEach(bid -> auction.propoe(bid));
    }

    @Then("bid must be accepted")
    public void bidMustBeAccepted() {
        Assert.assertEquals(this.list.size(), auction.getLances().size());
        Assert.assertEquals(this.list.get(0).getValor(), auction.getLances().get(0).getValor());
    }

//    @Given("several valid bids")
//    public void several_valid_bids() {
//        try{
//            User user = new User("Rafael");
//            bid1 = new Bid(user, BigDecimal.TEN);
//            User user2 = new User("Mayara");
//            bid2 = new Bid(user2, new BigDecimal("20.00"));
//            auction = new Auction("Intel Pro 15");
//        } catch (PendingException e) {
//            e.printStackTrace();
//        }
//    }

    /*
    *
    * Teste com implementação de um passo com parâmetros
    * @Given("user {String} bid of {double}")
    *
    */

    @Given("a bid of {double} real from the user {string}")
    public void severalValidBids(double bidValue, String userName) {
        try{
            Bid bid = new Bid(new User(userName), new BigDecimal(bidValue));
            this.list.add(bid);
        } catch (PendingException e) {
            e.printStackTrace();
        }
    }

    @When("propose multiple bids in the auction")
    public void proposeMultipleBidsInTheAuction() {
        try{
            this.list.forEach(bid -> auction.propoe(bid));
        } catch (PendingException e) {
            e.printStackTrace();
        }
    }

    @Then("Bids are accepted")
    public void bidsAreAccepted() {
        try{
            Assert.assertEquals(this.list.size(), auction.getLances().size());
            Assert.assertEquals(this.list.get(0).getValor(), auction.getLances().get(0).getValor());
            Assert.assertEquals(this.list.get(1).getValor(), auction.getLances().get(1).getValor());
        } catch (PendingException e) {
            e.printStackTrace();
        }
    }

}
