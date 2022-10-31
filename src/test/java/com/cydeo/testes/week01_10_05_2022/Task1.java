package com.cydeo.testes.week01_10_05_2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 {

    @Test
    public void task1() {


        // 1- Setup the "browser driver"
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to "https://www.selenium.dev"
        driver.get("https://www.selenium.dev");

        // 3- Verify the URL is "https://www.selenium.dev/"
        String actualResult = driver.getCurrentUrl(); // coming from browser
        String expectedResult = "https://www.selenium.dev/"; // coming from the User (PO)
        Assert.assertEquals(actualResult,expectedResult,"Verifying current URL");


        driver.close();
        driver.quit();
    }
}
