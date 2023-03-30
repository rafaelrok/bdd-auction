package br.com.rafaelvieira.auction.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewAuctionPage {

    private WebDriver driver;

    public NewAuctionPage(WebDriver driver) {
        this.driver = driver;
    }

    public AuctionPage preencheForm(String nome, String valor, String data) {
    	
//    	WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("dataAbertura")));

        WebElement txtNome = driver.findElement(By.id("nome"));
        txtNome.clear();
        txtNome.sendKeys(nome);
        
        WebElement txtValor = driver.findElement(By.id("valorInicial"));
        txtValor.clear();
        txtValor.sendKeys(valor);
        
        WebElement txtData = driver.findElement(By.id("dataAbertura"));
        txtData.clear();
        txtData.sendKeys(data);

        WebElement button = driver.findElement(By.id("button-submit"));							
        button.submit();
        
        return new AuctionPage(driver);
    }

}