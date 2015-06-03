package se.thinkcode.selenium.datadriven;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.TestHelper;
import se.thinkcode.selenium.form.ConfirmPasswordSentPage;
import se.thinkcode.selenium.form.RequestPasswordPage;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class RequestNewPasswordTest {
    private WebDriver browser;
    private String account;

    public RequestNewPasswordTest(String account) {
        this.account = account;
    }

    @Before
    public void setUp() {
        browser = TestHelper.getDefaultBrowser();
    }

    @After
    public void tearDown() {
        browser.close();
    }

    @Test
    public void request_new_password() {
        String expected = "A new password has been sent to " + account;
        RequestPasswordPage page = new RequestPasswordPage(browser);

        ConfirmPasswordSentPage confirmation = page.requestNewPassword(account);
        String actual = confirmation.getConfirmationMessage();

        assertThat(actual, is(expected));
    }

    @Parameterized.Parameters
    public static Collection<String[]> accounts() {
        List<String[]> accounts = new LinkedList<>();
        accounts.add(new String[]{"Sune"});
        accounts.add(new String[]{"Gretchen"});

        return accounts;
    }
}
