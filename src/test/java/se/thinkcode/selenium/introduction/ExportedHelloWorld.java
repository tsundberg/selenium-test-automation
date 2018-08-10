package se.thinkcode.selenium.introduction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import se.thinkcode.selenium.drivers.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ExportedHelloWorld {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new WebDriverFactory().createFirefoxDriver();
        baseUrl = "http://selenium.thinkcode.se/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @Test
    public void testExportedHelloWorld() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("helloWorld")).click();
        assertEquals("Hello, world!", driver.findElement(By.id("headline")).getText());
    }
}
