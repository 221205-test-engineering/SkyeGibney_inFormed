package dev.skyegibney.informed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Level8 extends BaseLevel {
    public Level8() {
        super("level-8.html");
    }

    @Override
    void submitForm() {
        try {
            File file = File.createTempFile("input", "txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Let's Go Gators");
            writer.close();

            fileInput.sendKeys(file.getAbsolutePath());

            submit.click();

            file.deleteOnExit();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FindBy(xpath="//input[@type='file']")
    WebElement fileInput;

    @FindBy(tagName="button")
    WebElement submit;
}
