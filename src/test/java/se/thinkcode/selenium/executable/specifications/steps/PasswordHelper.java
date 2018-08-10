package se.thinkcode.selenium.executable.specifications.steps;

import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.drivers.WebDriverFactory;
import se.thinkcode.selenium.form.ConfirmPasswordSentPage;
import se.thinkcode.selenium.form.RequestPasswordPage;

public class PasswordHelper {
    private String account;
    private WebDriver browser;
    private ConfirmPasswordSentPage confirmPasswordSentPage;

    public PasswordHelper(String account) {
        this.account = account;
        browser = new WebDriverFactory().createFirefoxDriver();
        browser.get("http://selenium.thinkcode.se/requestPassword");
    }

    public void sendRequest() {
        RequestPasswordPage requestPasswordPage = new RequestPasswordPage(browser);
        confirmPasswordSentPage = requestPasswordPage.requestNewPassword(account);
    }

    public String getConfirmationMessage() {
        return confirmPasswordSentPage.getConfirmationMessage();
    }

    public void quitBrowser() {
        browser.quit();
    }
}
