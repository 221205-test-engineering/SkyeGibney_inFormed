package dev.skyegibney.informed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Level3 extends BaseLevel {
    public Level3() {
        super("level-3.html");
    }

    @Override
    void submitForm() {
        inputs.forEach(input -> new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(input))
                .sendKeys("a"));
        submitButton.submit();
    }

    @FindBy(xpath="//input[@type='text']")
    List<WebElement> inputs;

    @FindBy(tagName="button")
    WebElement submitButton;
}
