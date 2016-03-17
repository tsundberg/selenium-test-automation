package se.thinkcode.selenium.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RequestPasswordPage {

    private WebDriver browser;

    public RequestPasswordPage(WebDriver browser) {
        this.browser = browser;

        String expectedTitle = "Request new password";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public ConfirmPasswordSentPage requestNewPassword(String account) {
        WebElement accountField = browser.findElement(By.id("account"));
        accountField.sendKeys(account);

        WebElement submitButton = browser.findElement(By.name("submit"));
        submitButton.click();

        return new ConfirmPasswordSentPage(browser);
    }
}
