package dev.skyegibney.informed.pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class Level3 extends BaseLevel {
    public Level3() {
        super("level-3.html");
    }

    @Override
    void submitForm() {
        inputs.forEach(input ->
            new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(20))
                .ignoring(ElementNotInteractableException.class)
                .until(driver -> {
                    input.sendKeys("a");
                    return input;
                })
        );
        submitButton.submit();
    }

    @FindBy(xpath="//input[@type='text']")
    List<WebElement> inputs;

    @FindBy(tagName="button")
    WebElement submitButton;
}
