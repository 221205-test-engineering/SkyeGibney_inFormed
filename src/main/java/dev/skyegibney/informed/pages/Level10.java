package dev.skyegibney.informed.pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Level10 extends BaseLevel {
    public Level10() {
        super("level-10.html");
    }

    @Override
    void submitForm() {
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

        fileInput.sendKeys(screenshotFile.getAbsolutePath());

        reviewButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.alertIsPresent());
        screenshotFile.delete();
    }

    @FindBy(xpath="//input[@type='file']")
    WebElement fileInput;

    @FindBy(tagName = "button")
    WebElement reviewButton;
}
