package se.thinkcode.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestHelper {

    public static WebDriver getDefaultBrowser() {
        WebDriver browser = new FirefoxDriver();
        browser.get(getBaseUrl());

        return browser;
    }

    public static String getBaseUrl() {
        return "http://selenium.thinkcode.se";
    }
}
