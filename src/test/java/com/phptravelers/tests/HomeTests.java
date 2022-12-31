package com.phptravelers.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomeTests {

    @Test
    public void test1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://phptravels.com/");
        driver.findElement(By.xpath("//ul[@class='jfHeader-menuList']/li/a[text()='Demo']")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        driver.quit();
    }

    @Test
    public void test2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://phptravels.com/");
        driver.findElement(By.xpath("//ul[@class='jfHeader-menuList']/li/a[text()='Pricing']")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(2000);

        driver.quit();
    }

}
