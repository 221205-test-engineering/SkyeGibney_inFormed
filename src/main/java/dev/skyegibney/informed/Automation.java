package dev.skyegibney.informed;

import dev.skyegibney.informed.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Automation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

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

        int[] numberOfSuccesses = new int[levels.length];
        float progress = 0;
        int numRounds = 10;

        for (int i = 0; i < numRounds; i++) {
            for (int j = 0; j < levels.length; j++) {
                try {
                    if (levels[i].solve()) {
                        numberOfSuccesses[i]++;
                    }
                } catch (Exception e) {
                    System.out.println(" Exception");
                    System.out.println(e.toString().split("\n")[0]);
                }

                progress += (float)1 / (levels.length * numRounds);
                System.out.printf("%.2f\n", progress * 100);
            }
        }

        for (int i = 0; i < levels.length; i++) {
            System.out.println(levels[i].getClass().getSimpleName() + ": " + numberOfSuccesses[i] + " passed");
        }

//        Level2 level2 = new Level2();
//        if (level2.solve()) System.out.println("PASS");
//        else System.out.println("FAIL");
//
//        try {
//            Thread.sleep(10000);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.quit();
    }
}
