package se.thinkcode.selenium.form;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.TestHelper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RequestNewPasswordTest {
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
    public void request_new_password() {
        String expected = "A new password has been sent to Gretchen";
        RequestPasswordPage rp = new RequestPasswordPage(browser);

        ConfirmPasswordSentPage cp = rp.requestNewPassword("Gretchen");

        String actual = cp.getConfirmationMessage();

        assertThat(actual, is(expected));
    }

}
