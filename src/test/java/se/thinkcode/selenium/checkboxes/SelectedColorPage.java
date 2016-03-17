package se.thinkcode.selenium.checkboxes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectedColorPage {
    private WebDriver browser;

    public SelectedColorPage(WebDriver browser) {
        this.browser = browser;
    }

    public boolean isGreenSelected() {
        List<WebElement> selectedColors = browser.findElements(By.name("color"));
        for (WebElement element : selectedColors) {
            String text = element.getText();
            if (text.equalsIgnoreCase("green")) {
                return true;
            }
        }

        return false;
    }
}
