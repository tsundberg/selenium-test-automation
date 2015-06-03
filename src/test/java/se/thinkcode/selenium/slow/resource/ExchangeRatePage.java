package se.thinkcode.selenium.slow.resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ExchangeRatePage {
    private WebDriver browser;
    private float exchangeRate;

    public ExchangeRatePage(WebDriver browser) {
        this.browser = browser;

        String expectedTitle = "Exchange rate result";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));

        // String exchangeRateMessage = waitElevenSeconds();
        // String exchangeRateMessage = getExchangeRateWebDriverWait();
        String exchangeRateMessage = getExchangeRateFluentWait();
        exchangeRate = parseResult(exchangeRateMessage);
    }

    private String waitElevenSeconds() {
        try {
            Thread.sleep(11 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        WebElement resultElement = browser.findElement(By.id("exchangeRate"));
        return resultElement.getText();
    }

    private String getExchangeRateWebDriverWait() {
        WebDriverWait wait = new WebDriverWait(browser, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exchangeRate")));

        WebElement resultElement = browser.findElement(By.id("exchangeRate"));
        return resultElement.getText();
    }

    private String getExchangeRateFluentWait() {
        WebElement resultElement = new FluentWait<>(browser)
                .withTimeout(30, SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("exchangeRate")));

        return resultElement.getText();
    }

    float parseResult(String result) {
        Pattern p = Pattern.compile(".* is (.*)");
        Matcher m = p.matcher(result);
        if (m.matches()) {
            String value = m.group(1);
            return Float.parseFloat(value);
        } else {
            throw new ExchangeResultPageException("Unable to parse " + result);
        }
    }

    public float getExchangeRate() {
        return exchangeRate;
    }
}
