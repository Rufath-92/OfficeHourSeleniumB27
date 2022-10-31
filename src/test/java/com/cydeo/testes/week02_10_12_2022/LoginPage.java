package com.cydeo.testes.week02_10_12_2022;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage {

   WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //  setup browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://vytrack.com");

    }

//    * TC003 As a user I should be able to see the login page
//
//            1- Setup the "browser driver"
//            2- Go to "https://vytrack.com"



    @Test
    public void verify_login_button(){
        //            3- Click Login label
        WebElement loginLabel = driver.findElement(By.xpath("//ul[@id='top-menu']/li[.='LOGIN']"));
        loginLabel.click();

        //            3- Verify the title contains "Login"
       verifyTitle("Login");
    }

    // positive test
    @Test
    public void verify_title_contains_dashboard(){
//        ** TC004 As a user I should be able to login with valid credentials
//
//        1- Setup the "browser driver"
//        2- Go to "https://vytrack.com"

//        3- Click Login label
        WebElement loginLabel = driver.findElement(By.xpath("//ul[@id='top-menu']/li[.='LOGIN']"));
        loginLabel.click();

//        4- Login to application with username as "User1" and password as "UserUser123"
       login("User1","UserUser123");

        wait(3);

//        5- Verify the title contains "Dashboard"
       String actual = driver.getTitle();
       String expected = "Dashboard";
      Assert.assertTrue(actual.contains(expected));

    }

  // negative test
    @Test
    public void verify_title_contains_Login(){

//          ** TC005 As a user I should not be able to login with invalid credentials
//
//            1- Setup the "browser driver"
//            2- Go to "https://vytrack.com"
//            3- Click Login label
        WebElement loginLabel = driver.findElement(By.xpath("//ul[@id='top-menu']/li[.='LOGIN']"));
        loginLabel.click();


//            4- Login to application with username as "invalid" and password as "invalid"
        login("invalid","invalid");


//            5- Verify the title contains "Login"
        Assert.assertTrue(driver.getTitle().contains("Login"));
    }




    public void login(String username,String password){
        WebElement usernameBox = driver.findElement(By.id("prependedInput"));
        usernameBox.sendKeys(username);
        WebElement passwordBox = driver.findElement(By.id("prependedInput2"));
        passwordBox.sendKeys(password);
        WebElement loginBtn = driver.findElement(By.id("_submit"));
        loginBtn.click();

    }

    public void verifyTitle(String title){
        Assert.assertEquals(driver.getTitle(),title);
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
