package se.thinkcode.selenium.select;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.TestHelper;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SelectCondimentTest {
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
    public void select_sugar() {
        SelectCondimentPage page = new SelectCondimentPage(browser);

        String initialSelection = page.getSelectedCondiment();
        assertThat(initialSelection, is("none"));

        page.selectSugar();

        String selectedCondiment = page.getSelectedCondiment();
        assertThat(selectedCondiment, is("sugar"));
    }

    @Test
    public void find_all_options(){
        SelectCondimentPage page = new SelectCondimentPage(browser);

        List<String> expected = new LinkedList<>();
        expected.add("none");
        expected.add("milk");
        expected.add("sugar");
        expected.add("milk & sugar");

        List<String> actual = page.getAvailableCondiments();

        assertThat(actual, is(expected));
    }

}
