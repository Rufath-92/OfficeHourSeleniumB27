package com.cydeo.testes.week02_10_12_2022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTests {
    WebDriver driver;


    @BeforeMethod
    public void setUp() {
        //  setup browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://vytrack.com");

    }

    @Test(priority = 1)
    public void verify_login_label_is_displayed() {

        // verify LOGIN label is displayed
        WebElement loginLabel = driver.findElement(By.xpath("//ul[@id='top-menu']/li[.='LOGIN']"));
        Assert.assertTrue(loginLabel.isDisplayed());

    }

    @Test(priority = 2)
    public void verify_home_label_is_displayed() {

        // verify LOGIN label is displayed
        String locator = "//ul[@id='top-menu']/li[.='Home']";
        WebElement homeLabel = driver.findElement(By.xpath(locator));
        Assert.assertTrue(homeLabel.isDisplayed());

    }

    @Test(priority = 3)
    public void verify_about_us_label_is_displayed() {

        // verify LOGIN label is displayed
        String locator = "//ul[@id='top-menu']/li[.='About us']";
        WebElement aboutUsLabel = driver.findElement(By.xpath(locator));
        Assert.assertTrue(aboutUsLabel.isDisplayed());
    }

    @AfterMethod
    public void tearMethod(){
        wait(3);
        driver.close();
  }

  public void wait(int sec){
      try {
          Thread.sleep(sec*1000);
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
  }
}
