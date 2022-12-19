package dev.skyegibney.informed;

import dev.skyegibney.informed.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

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

        for (var level: levels) {
            System.out.print(level.getClass().getSimpleName());

            try {
                if (level.solve()) System.out.println(" OK");
                else System.out.println(" Failed");
            }
            catch (Exception e) {
                System.out.println(" Exception");
                System.out.println(e.toString().split("\n")[0]);
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
