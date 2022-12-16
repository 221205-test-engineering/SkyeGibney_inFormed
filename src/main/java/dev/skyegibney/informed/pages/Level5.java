package dev.skyegibney.informed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Level5 extends BaseLevel {
    public Level5() {
        super("level-5.html");
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
