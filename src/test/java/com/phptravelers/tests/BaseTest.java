package com.phptravelers.tests;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Constants.getChromedriverpath());
        driver = new ChromeDriver();

        driver.get("https://phptravels.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}