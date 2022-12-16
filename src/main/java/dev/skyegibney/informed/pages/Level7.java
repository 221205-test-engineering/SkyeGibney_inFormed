package dev.skyegibney.informed.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Level7 extends BaseLevel {
    public Level7() {
        super("level-7.html");
    }

    @Override
    void submitForm() {
        driver.manage().window().setSize(new Dimension(700, 700));
        largerButton.click();

        driver.manage().window().setSize(new Dimension(500, 500));
        smallerButton.click();

        submitButton.click();
    }

    @FindBy(xpath="//button[1]")
    WebElement smallerButton;

    @FindBy(xpath="//button[2]")
    WebElement largerButton;

    @FindBy(xpath="//button[3]")
    WebElement submitButton;
}
