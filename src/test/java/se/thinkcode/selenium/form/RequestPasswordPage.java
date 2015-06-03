package se.thinkcode.selenium.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RequestPasswordPage {
    private WebDriver browser;

    public RequestPasswordPage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl() + "requestPassword.html";
        browser.get(page);

        String expectedTitle = "Request new password";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public ConfirmPasswordSentPage requestNewPassword(String accountName) {
        WebElement accountField = browser.findElement(By.id("account"));
        accountField.sendKeys(accountName);

        accountField.submit();

        return new ConfirmPasswordSentPage(browser);
    }
}
