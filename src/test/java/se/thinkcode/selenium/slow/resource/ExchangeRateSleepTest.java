package se.thinkcode.selenium.slow.resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.TestHelper;

import java.util.Currency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ExchangeRateSleepTest {
    private WebDriver browser;

    @Before
    public void setUp() {
        browser = TestHelper.getDefaultBrowser();
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void wait_for_slow_exchange_server() {
        float expected = 2.07f;

        RequestExchangeRatePage page = new RequestExchangeRatePage(browser);
        Currency from = Currency.getInstance("RON");
        Currency to = Currency.getInstance("SEK");

        ExchangeRatePage exchangeRatePage = page.getExchangeRate(from, to);

        float actual = exchangeRatePage.getExchangeRate();

        assertThat(actual, is(expected));
    }
}