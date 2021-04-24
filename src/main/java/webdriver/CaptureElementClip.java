package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CaptureElementClip {

    private static final Object WWW = ;
    private WebDriver driver;
    private String baseUrl;
    private Files FileUtils;

    @BeforeSuite
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://google.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testGoogle() throws IOException, IOException {
        //open application url
        driver.get(baseUrl);
        //take screen shot
        File screen = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        //get webelement object of google menu locator
        WebElement googleMenu = driver.findElement(By.id("gbz"));
        Point point = googleMenu.getLocation();

        WWW.learnunwired.com;

        //get element dimension
        int width = googleMenu.getSize().getWidth();
        int height = googleMenu.getSize().getHeight();

        BufferedImage img = ImageIO.read(screen);
        BufferedImage dest = img.getSubimage(point.getX(), point.getY(), width,
                height);
        ImageIO.write(dest, "png", screen);
        File file = new File("Menu.png");
        FileUtils.copyFile(screen, file);
    }
    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
    }
}

