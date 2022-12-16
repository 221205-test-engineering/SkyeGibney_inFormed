package dev.skyegibney.informed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Level2 extends BaseLevel {
    public Level2() {
        super("level-2.html");
    }

    @Override
    void submitForm() {
        Select dropdownSelect = new Select(dropdownInput);
        dropdownSelect.selectByVisibleText(dropdown.getAttribute("innerHTML"));

        checkboxInputs.forEach(WebElement::click);

        String radioValue = radio.getAttribute("innerHTML");

        radioInputs.forEach(input -> {
            if (radioValue.equals(input.getAttribute("value"))) input.click();
        });

        String dateValue = date.getAttribute("innerHTML");
        dateInput.sendKeys(dateValue);

        dateInput.submit(); // shortcut to submit
    }

    @FindBy(xpath="//dl/dd[1]")
    public WebElement dropdown;

    @FindBy(xpath="//dl/dd[3]")
    public WebElement radio;

    @FindBy(xpath="//dl/dd[4]")
    public WebElement date;

    @FindBy(name="input1")
    public WebElement dropdownInput;

    @FindBy(xpath="//*[@type='checkbox']")
    public List<WebElement> checkboxInputs;

    @FindBy(name="radio")
    public List<WebElement> radioInputs;

    @FindBy(name="dateInput")
    public WebElement dateInput;
}
