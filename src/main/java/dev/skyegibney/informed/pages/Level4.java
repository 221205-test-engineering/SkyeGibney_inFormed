package dev.skyegibney.informed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Level4 extends BaseLevel {
    public Level4() {
        super("level-4.html");
    }

    @Override
    void submitForm() {
        for (int i = 0; i < 100; i++) {
            input.sendKeys("a");
            driver.switchTo().alert().accept();
        }

        input.submit();
    }

    @FindBy(tagName="input")
    WebElement input;
}
