package dev.skyegibney.informed.pages;

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

    public void solve() {
        System.out.println("Solving " + this.getClass().getSimpleName() + "...");
        driver.get(inFormedPath + "\\" + filepath);

        submitForm();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.alertIsPresent());

        if (driver.switchTo().alert().getText().contains("SUCCESS!!!")) {
            System.out.println(this.getClass().getSimpleName() + " success!");
        }
        else {
            System.out.println(this.getClass().getSimpleName() + " failed :(");
        }

        driver.switchTo().alert().accept();
    }

    abstract void submitForm();
}
