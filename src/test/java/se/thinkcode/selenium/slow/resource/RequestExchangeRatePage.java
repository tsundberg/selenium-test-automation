package se.thinkcode.selenium.slow.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Currency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RequestExchangeRatePage {
    private WebDriver browser;

    public RequestExchangeRatePage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl() + "exchangeRate.html";
        browser.get(page);

        String expectedTitle = "Exchange rate";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }


    public ExchangeRatePage getExchangeRate(Currency from, Currency to) {
        WebElement fromField = browser.findElement(By.name("from"));
        fromField.sendKeys(from.getSymbol());

        WebElement toField = browser.findElement(By.name("to"));
        toField.sendKeys(to.getSymbol());

        fromField.submit();

        return new ExchangeRatePage(browser);
    }
}
