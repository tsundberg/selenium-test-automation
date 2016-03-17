package se.thinkcode.selenium.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConfirmPasswordSentPage {
    private WebDriver browser;

    public ConfirmPasswordSentPage(WebDriver browser) {
        this.browser = browser;

        String expectedTitle = "Confirm new password request";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public String getConfirmationMessage() {
        WebElement confirmationMessage = browser.findElement(By.id("confirmation"));
        return confirmationMessage.getText();
    }
}
