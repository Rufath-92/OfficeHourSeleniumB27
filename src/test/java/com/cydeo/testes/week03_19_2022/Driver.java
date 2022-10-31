package com.cydeo.testes.week03_19_2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    // we want to control the object creation
    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver getDriver(){



        if(driver == null){

            String browserType = ConfigurationReader.getValueOf("browser");

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();

            }
            return driver;
        }else {
            System.out.println("We have problem with Driver class");
            return null;
        }

    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }


}
