package se.thinkcode.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class SelectColorTest {
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
    public void select_green() {
        SelectColorPage selectColorPage = new SelectColorPage(browser);

        selectColorPage.selectGreen();
        SelectedColorPage sc = selectColorPage.submit();

        assertTrue("Green should have been selected", sc.isGreenSelected());
    }

}
