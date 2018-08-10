package se.thinkcode.selenium.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import se.thinkcode.lib.PropertiesReader;

public class WebDriverFactory {

    public WebDriver createFirefoxDriver() {

        String propertiesPath = System.getProperty("user.dir")
                + "/out/test/resources/se/thinkcode/selenium/config/config.properties";

        System.setProperty("webdriver.gecko.driver"
                , new PropertiesReader(propertiesPath)
                        .read("geckodriver.path"));

        return new FirefoxDriver();
    }

    public WebDriver createHtmlUnitDriver() {
        return new HtmlUnitDriver(true);
    }
}
