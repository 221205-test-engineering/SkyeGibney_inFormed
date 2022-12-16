package dev.skyegibney.informed;

import dev.skyegibney.informed.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.Arrays;

public class Automation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        BaseLevel.inFormedPath = "file:///" + new File(".").getAbsolutePath() + "\\src\\main\\resources";
        BaseLevel.driver = driver;

        BaseLevel[] levels = {
                new Level1(),
                new Level2(),
                new Level3(),
                new Level4(),
                new Level5(),
                new Level7(),
                new Level8(),
                new Level10()
        };

        Arrays.stream(levels).forEach(level -> {
            try {
                level.solve();
            }
            catch (Exception e) {
                System.out.println("Exception while running " + level.getClass().getSimpleName());
                e.printStackTrace();
            }
        });

        driver.quit();
    }
}
