package se.thinkcode.selenium.screenshot;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.introduction.HelloWorldPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ScreenShotOnFailureTest {
    private WebDriver browser;

    @Rule
    public ScreenShotRule screenShotRule;

    public ScreenShotOnFailureTest() {
        browser = new FirefoxDriver();
        screenShotRule = new ScreenShotRule(browser);
    }

    @Before
    public void setUp() {
        browser.get("http://selenium.thinkcode.se/");
    }

    @After
    public void tearDown() {
        browser.close();
    }

    @Test
    @Ignore
    public void hello_world_with_page_object() {
        String expected = "Hello, world";

        HelloWorldPage helloWorldPage = new HelloWorldPage(browser);

        String actual = helloWorldPage.getHeadLine();

        assertThat(actual, is(expected));
    }

}
