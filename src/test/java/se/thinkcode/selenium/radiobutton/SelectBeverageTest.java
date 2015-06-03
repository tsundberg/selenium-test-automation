package se.thinkcode.selenium.radiobutton;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.selenium.TestHelper;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SelectBeverageTest {
    private WebDriver browser;

    @Before
    public void setUp() {
        browser = TestHelper.getDefaultBrowser();
    }

    @After
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void find_all_beverages() {
        List<String> expected = new LinkedList<>();
        expected.add("coffee");
        expected.add("tea");

        SelectBeveragePage page = new SelectBeveragePage(browser);

        List<String> actual = page.getAvailableBeverages();

        assertThat(actual, is(expected));
    }

}
