package se.thinkcode.selenium.checkbox;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.TestHelper;

import static junit.framework.TestCase.assertTrue;

public class SelectColorTest {
    private WebDriver browser;

    @Before
    public void setUp() {
        browser = TestHelper.getDefaultBrowser();
    }

    @After
    public void tearDown() {
        browser.close();
    }

    @Test
    public void select_green() {
        SelectColorPage selectColorPage = new SelectColorPage(browser);

        selectColorPage.selectGreen();
        SelectedColorPage sc = selectColorPage.submit();

        assertTrue("Green should have been selected", sc.isGreenSelected());
    }
}
