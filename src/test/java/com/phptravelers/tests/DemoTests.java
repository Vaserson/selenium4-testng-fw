package com.phptravelers.tests;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTests {
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

    @Test
    public void demoTest1() throws InterruptedException {
        driver.findElement(By.xpath("//ul[@class='jfHeader-menuList']/li/a[text()='Demo']")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
    }

    @Test
    public void demoTest2() throws InterruptedException {
        driver.findElement(By.xpath("//ul[@class='jfHeader-menuList']/li/a[text()='Pricing']")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
    }

}
