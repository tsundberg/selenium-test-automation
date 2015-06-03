package se.thinkcode.selenium.screenshot;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.TestHelper;
import se.thinkcode.selenium.select.SelectCondimentPage;

import static junit.framework.TestCase.fail;

public class FailingTest {
    private WebDriver browser;

    @Rule
    public ScreenShotRule screenShotRule;

    public FailingTest() {
        browser = TestHelper.getDefaultBrowser();
        screenShotRule = new ScreenShotRule(browser);
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void take_screen_shot() {
        fail();
    }
}
