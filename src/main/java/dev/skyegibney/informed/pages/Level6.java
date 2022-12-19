package dev.skyegibney.informed.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Level6 extends BaseLevel {
    public Level6() {
        super("level-6a.html");
    }

    @Override
    void submitForm() {
        links.forEach(link ->
                link.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER)));

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        GatePage gatePage1 = new GatePage(driver);
        gatePage1.gateButton.click();

        driver.switchTo().window(tabs.get(2));
        GatePage gatePage2 = new GatePage(driver);
        gatePage2.gateButton.click();

        driver.switchTo().window(tabs.get(0));

        submitButton.click();
    }

    @FindBy(xpath="//a")
    List<WebElement> links;

    @FindBy(xpath="//button")
    WebElement submitButton;
}
