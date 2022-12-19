package dev.skyegibney.informed;

import dev.skyegibney.informed.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.Arrays;

public class Automation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        BaseLevel.inFormedPath = "file:///" + new File(".").getAbsolutePath() + "\\src\\main\\resources";
        BaseLevel.driver = driver;

        BaseLevel[] levels = {
                new Level1(),
                new Level2(),
                new Level3(),
                new Level4(),
                new Level5(),
                new Level6(),
                new Level7(),
                new Level8(),
                new Level9(),
                new Level10()
        };

        for (int i = 0; i < levels.length; i++) {
            System.out.print(levels[i].getClass().getSimpleName());

            try {
                if (levels[i].solve()) System.out.println(" OK");
                else System.out.println(" Failed");
            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println(" Exception");
            }
        }

//        Level2 level2 = new Level2();
//        level2.solve();
//
//        try {
//            Thread.sleep(5000);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        driver.quit();
    }
}
