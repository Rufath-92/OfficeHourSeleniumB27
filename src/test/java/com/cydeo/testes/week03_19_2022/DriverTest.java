package com.cydeo.testes.week03_19_2022;

import org.testng.annotations.Test;

public class DriverTest {

    @Test
    public void testDriver() throws InterruptedException {

        Driver.getDriver().get(ConfigurationReader.getValueOf("url"));
        Thread.sleep(3000);
        Driver.closeDriver();
    }

}
