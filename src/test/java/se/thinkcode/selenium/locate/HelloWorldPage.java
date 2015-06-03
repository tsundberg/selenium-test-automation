package se.thinkcode.selenium.locate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HelloWorldPage {
    private WebDriver browser;

    public HelloWorldPage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl() + "helloWorld.html";
        browser.get(page);

        String expectedTitle = "Hello world";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public String getHeadline() {
        WebElement headLine = browser.findElement(By.id("headline"));

        return headLine.getText();
    }
}
