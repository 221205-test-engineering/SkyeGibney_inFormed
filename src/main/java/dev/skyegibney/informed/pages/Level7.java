package dev.skyegibney.informed.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Level7 extends BaseLevel {
    public Level7() {
        super("level-7.html");
    }

    @Override
    void submitForm() {
        driver.manage().window().setSize(new Dimension(1000, 1000));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(largerButton)).click();

        driver.manage().window().setSize(new Dimension(500, 500));
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(smallerButton)).click();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    @FindBy(xpath="//button[1]")
    WebElement smallerButton;

    @FindBy(xpath="//button[2]")
    WebElement largerButton;

    @FindBy(xpath="//button[3]")
    WebElement submitButton;
}
