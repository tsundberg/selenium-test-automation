package se.thinkcode.selenium.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HelloWorldPage {
    private WebDriver browser;

    public HelloWorldPage(WebDriver browser) {
        this.browser = browser;

        String page = "helloWorld";
        browser.get(browser.getCurrentUrl() + page);

        String expectedTitle = "Hello, world";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public String getHeadLine() {
        WebElement headLine = browser.findElement(By.id("headline"));

        return headLine.getText();
    }
}
