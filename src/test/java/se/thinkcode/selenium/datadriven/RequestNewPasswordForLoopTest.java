package se.thinkcode.selenium.datadriven;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.TestHelper;
import se.thinkcode.selenium.form.ConfirmPasswordSentPage;
import se.thinkcode.selenium.form.RequestPasswordPage;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RequestNewPasswordForLoopTest {
    private WebDriver browser;

    @Before
    public void setUp(){
        browser = TestHelper.getDefaultBrowser();
    }

    @After
    public void tearDown() {
        browser.close();
    }

    @Test
    public void request_new_password() {
        for (String account : accounts()) {
            String expected = "A new password has been sent to " + account;

            browser.get(TestHelper.getBaseUrl());
            RequestPasswordPage page = new RequestPasswordPage(browser);
            ConfirmPasswordSentPage confirmation = page.requestNewPassword(account);

            String actual = confirmation.getConfirmationMessage();

            assertThat(actual, is(expected));
        }
    }

    private Collection<String> accounts() {
        List<String> accounts = new LinkedList<>();
        accounts.add("Sune");
        accounts.add("Gretchen");

        return accounts;
    }
}
