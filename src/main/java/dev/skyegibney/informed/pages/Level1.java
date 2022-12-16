package dev.skyegibney.informed.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Level1 extends BaseLevel {
    public Level1() {
        super("level-1.html");
    }

    @Override
    void submitForm() {
        String name = randomString.getAttribute("innerHTML");
        nameInput.sendKeys(name);
        nameInput.sendKeys(Keys.ENTER); // shortcut to submit
    }

    @FindBy(id="nameInput")
    public WebElement nameInput;

    @FindBy(id="randomString")
    public WebElement randomString;
}
