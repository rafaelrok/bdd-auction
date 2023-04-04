package br.com.rafaelvieira.auction.acceptance;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "br.com.rafaelvieira.auction.acceptance.steps"
)
public class AuctionCucumberRunner {

}
