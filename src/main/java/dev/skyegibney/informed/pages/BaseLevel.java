package dev.skyegibney.informed.pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseLevel {
    public static String inFormedPath;
    public static WebDriver driver;

    String filepath;

    public BaseLevel(String filepath) {
        this.filepath = filepath;
        PageFactory.initElements(driver, this);
    }

    public boolean solve() {
        driver.get(inFormedPath + "\\" + filepath);

        submitForm();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.alertIsPresent());

        boolean success = false;
        String className = this.getClass().getSimpleName();

        try {
            String alertText = driver.switchTo().alert().getText();

            if (alertText.contains("SUCCESS!!!")) success = true;
            else success = false;

            driver.switchTo().alert().accept();
        }
        catch (NoAlertPresentException e) {
            System.out.println("Form was not submitted in " + className);
        }

        return success;
    }

    abstract void submitForm();
}
