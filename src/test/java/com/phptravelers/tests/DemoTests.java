package com.phptravelers.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public final class DemoTests extends BaseTest{

    private DemoTests() {

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