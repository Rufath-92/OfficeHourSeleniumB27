package com.cydeo.testes.week03_19_2022;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

   private static Properties properties = new Properties();

    // Before everything I need to put my keys and values from properties file because of that we need to use
    // static block why? because static blocks are running before everything
    static {                               // we need to provide path of properties file
        try {
            // read the file
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            // we put the data in properties object
            // at the backend we have map structure
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // I want to get value of key from properties file
    public static String getValueOf(String key){
        String value = properties.getProperty(key);
        return value;
    }
}
