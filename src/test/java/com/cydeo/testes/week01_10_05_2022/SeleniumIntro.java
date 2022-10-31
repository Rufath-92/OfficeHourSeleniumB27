package com.cydeo.testes.week01_10_05_2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntro {
    public static void main(String[] args) throws InterruptedException {

        // Set Up browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //go to the website
        driver.get("https://www.google.com/");

        // get title
        System.out.println(driver.getTitle());

        // get current URL
        System.out.println(driver.getCurrentUrl());

        // navigate a URl
        driver.navigate().to("https://www.etsy.com/");
        Thread.sleep(3000);

        // refresh the page
        driver.navigate().refresh();
        Thread.sleep(3000);

        // go back to google
        driver.navigate().back();
        Thread.sleep(3000);

        // go to ETSY again
        driver.navigate().forward();
        Thread.sleep(3000);



        driver.close(); // close the current browser

        // Driver quit in order to close all pages (Session ID will be null).That's means we can use driver.quit(); --> after driver.close();  || but we can not use driver.quit(); before the driver.close();  because it gave us (Session ID will be null).
    }
}
