package se.thinkcode.selenium.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import se.thinkcode.lib.PropertiesReader;

public class WebDriverFactory {

    private static final String propertiesPath = System.getProperty("user.dir")
            + "/out/test/resources/se/thinkcode/selenium/config/config.properties";

    public WebDriver createFor(String browserName) {
        if (Browsers.valueOf(browserName.toUpperCase()).equals(Browsers.FIREFOX))
            return createFirefoxDriver();
        else if (Browsers.valueOf(browserName.toUpperCase()).equals(Browsers.CHROME))
            return createChromeDriver();
        else
            return createHtmlUnitDriver();
    }

    public WebDriver createFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver"
                , new PropertiesReader(propertiesPath)
                        .read("geckodriver.path"));

        return new FirefoxDriver();
    }

    public WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver"
                , new PropertiesReader(propertiesPath)
                .read("chromedriver.path"));

        return new ChromeDriver();
    }

    public WebDriver createHtmlUnitDriver() {
        return new HtmlUnitDriver(true);
    }
}
