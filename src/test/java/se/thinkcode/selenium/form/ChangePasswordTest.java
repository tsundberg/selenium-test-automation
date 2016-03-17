package se.thinkcode.selenium.form;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChangePasswordTest {

    private WebDriver browser;

    @Before
    public void setUp() {
        browser = new FirefoxDriver();
        String baseUrl = "http://selenium.thinkcode.se/requestPassword";
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void request_new_password() {
        String expected = "A new password has been sent to Bob";

        RequestPasswordPage requestPasswordPage = new RequestPasswordPage(browser);
        ConfirmPasswordSentPage confirmPasswordSentPage = requestPasswordPage.requestNewPassword("Bob");

        String actual = confirmPasswordSentPage.getConfirmationMessage();

        assertThat(actual, is(expected));
    }

}
