package se.thinkcode.selenium.screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShotRule extends TestWatcher {
    private WebDriver browser;

    public ScreenShotRule(WebDriver browser) {
        this.browser = browser;
    }

    @Override
    protected void failed(Throwable throwable, Description description) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) browser;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File dest = getDestination(description);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void finished(Description description) {
        browser.close();
    }

    private File getDestination(Description description) {
        File destDir = new File("target/screenshots");
        destDir.mkdirs();
        String screenShotName = description.getClassName() +
                "." + description.getMethodName() + ".png";
        String absoluteFileName = destDir.getPath() + "/" + screenShotName;

        return new File(absoluteFileName);
    }
}
