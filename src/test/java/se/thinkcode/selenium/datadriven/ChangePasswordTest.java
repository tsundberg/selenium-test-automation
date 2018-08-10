package se.thinkcode.selenium.datadriven;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.drivers.WebDriverFactory;
import se.thinkcode.selenium.form.ConfirmPasswordSentPage;
import se.thinkcode.selenium.form.RequestPasswordPage;

import java.util.Collection;
import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class ChangePasswordTest {
    private WebDriver browser;

    private String account;

    public ChangePasswordTest(String account) {
        this.account = account;
    }

    @Before
    public void setUp() {
        browser = new WebDriverFactory().createFirefoxDriver();
        String baseUrl = "http://selenium.thinkcode.se/requestPassword";
        browser.get(baseUrl);
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void request_new_password(){
        String expected = "A new password has been sent to " + account;

        RequestPasswordPage requestPasswordPage = new RequestPasswordPage(browser);
        ConfirmPasswordSentPage confirmPasswordSentPage = requestPasswordPage.requestNewPassword(account);

        String actual = confirmPasswordSentPage.getConfirmationMessage();

        assertThat(actual, is(expected));
    }

    @Parameterized.Parameters
    public static Collection<String[]> accounts() {
        Collection<String[]> accounts = new LinkedList<String[]>();

        accounts.add(new String[]{"Sune"});
        accounts.add(new String[]{"Gretchen"});

        return accounts;
    }
}
