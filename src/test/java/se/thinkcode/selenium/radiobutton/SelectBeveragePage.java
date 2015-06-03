package se.thinkcode.selenium.radiobutton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SelectBeveragePage {
    private WebDriver browser;

    public SelectBeveragePage(WebDriver browser) {
        this.browser = browser;

        String page = browser.getCurrentUrl() + "selectBeverage.html";
        browser.get(page);

        String expectedTitle = "Select beverage";
        String actualTitle = browser.getTitle();

        assertThat(actualTitle, is(expectedTitle));
    }

    public List<String> getAvailableBeverages() {
        List<WebElement> beverages = browser.findElements(By.name("beverage"));
        List<String> availableBeverages = new LinkedList<>();

        for (WebElement radioButton : beverages) {
            String beverage = radioButton.getAttribute("value");
            availableBeverages.add(beverage);
        }

        return availableBeverages;
    }
}
