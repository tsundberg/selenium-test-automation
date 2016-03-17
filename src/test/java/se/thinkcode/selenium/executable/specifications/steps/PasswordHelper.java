package se.thinkcode.selenium.executable.specifications.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.form.ConfirmPasswordSentPage;
import se.thinkcode.selenium.form.RequestPasswordPage;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class PasswordHelper {
    private String account;
    private WebDriver browser;
    private ConfirmPasswordSentPage confirmPasswordSentPage;

    public PasswordHelper(String account) {
        this.account = account;
        browser = new FirefoxDriver();
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
