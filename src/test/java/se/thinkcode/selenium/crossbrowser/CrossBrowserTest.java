package se.thinkcode.selenium.crossbrowser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.drivers.WebDriverFactory;
import se.thinkcode.selenium.introduction.HelloWorldPage;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class CrossBrowserTest {
    private WebDriver browser;

    public CrossBrowserTest(WebDriver browser) {
        this.browser = browser;
    }

    @Before
    public void setUp(){
        String baseUrl = "http://selenium.thinkcode.se/";
        browser.get(baseUrl);
    }

    @After
    public void tearDown(){
        browser.quit();
    }

    @Test
    public void hello_world(){
        String expected = "Hello, world!";
        HelloWorldPage helloWorldPage = new HelloWorldPage(browser);
        String actual = helloWorldPage.getHeadLine();

        assertThat(actual, is(expected));
    }

    @Parameterized.Parameters
    public static Collection<WebDriver[]> browsers() {
        List<WebDriver[]> browsers = new LinkedList<WebDriver[]>();

        browsers.add(new WebDriver[]{new WebDriverFactory().createHtmlUnitDriver()});
        browsers.add(new WebDriver[]{new WebDriverFactory().createFirefoxDriver()});

        return browsers;
    }

}
