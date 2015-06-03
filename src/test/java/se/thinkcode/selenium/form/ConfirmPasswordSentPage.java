package se.thinkcode.selenium.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConfirmPasswordSentPage {
    private WebDriver browser;
    private String confirmationMessage;

    public ConfirmPasswordSentPage(WebDriver browser) {
        this.browser = browser;

        String expectedTitle = "Confirm new password request";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));

        findConfirmationMessage();
    }

    private void findConfirmationMessage() {
        WebElement resultElement = browser.findElement(By.id("confirmation"));
        confirmationMessage = resultElement.getText();
    }

    public String getConfirmationMessage() {
        return confirmationMessage;
    }
}
