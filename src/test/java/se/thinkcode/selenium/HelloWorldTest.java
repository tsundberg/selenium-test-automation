package se.thinkcode.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class HelloWorldTest {
    private WebDriver browser;

    @Before
    public void setUp() {
        browser = new FirefoxDriver();
        browser.get("http://selenium.thinkcode.se/");
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void hello_world_no_page_object() {
        String expected = "Hello, world!";

        String page = "helloWorld";
        browser.get(browser.getCurrentUrl() + page);

        WebElement headLine = browser.findElement(By.id("headline"));

        String actual = headLine.getText();

        assertThat(actual, is(expected));
    }

    @Test
    public void hello_world_with_page_object(){
        String expected = "Hello, world!";

        HelloWorldPage helloWorldPage = new HelloWorldPage(browser);

        String actual = helloWorldPage.getHeadLine();

        assertThat(actual, is(expected));
    }
}
