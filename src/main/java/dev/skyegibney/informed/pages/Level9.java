package dev.skyegibney.informed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Level9 extends BaseLevel {
    public Level9() {
        super("level-9.html");
    }

    @Override
    void submitForm() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(textInput))
                .sendKeys("a");

        submitButton.click();
    }

    @FindBy(xpath="//input")
    WebElement textInput;

    @FindBy(id="submitBtn")
    WebElement submitButton;
}
