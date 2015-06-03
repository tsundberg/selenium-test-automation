package se.thinkcode.selenium.select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SelectCondimentPage {
    private WebDriver browser;

    public SelectCondimentPage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl() + "selectCondiment.html";
        browser.get(page);

        String expectedTitle = "Select condiment";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public String getSelectedCondiment() {
        Select select = getSelect();

        WebElement selected = select.getFirstSelectedOption();

        return selected.getAttribute("value");
    }

    public void selectSugar() {
        Select select = getSelect();

        select.selectByValue("sugar");
    }

    public List<String> getAvailableCondiments() {
        Select select = getSelect();
        List<WebElement> options = select.getOptions();

        List<String> stringOptions = new LinkedList<>();
        for (WebElement option : options) {
            String value = option.getAttribute("value");
            stringOptions.add(value);
        }

        return stringOptions;
    }

    private Select getSelect() {
        WebElement condiments = browser.findElement(By.id("condiments"));
        return new Select(condiments);
    }
}
