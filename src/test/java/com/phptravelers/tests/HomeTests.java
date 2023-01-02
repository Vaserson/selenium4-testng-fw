package com.phptravelers.tests;

import driver.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public final class HomeTests extends BaseTest{

    private HomeTests() {

    }

    @Test
    public void test1() throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//ul[@class='jfHeader-menuList']/li/a[text()='Demo']")).click();
        System.out.println(Driver.getDriver().getTitle());
        Thread.sleep(2000);
    }

    @Test(enabled = false)
    public void test2() throws InterruptedException {
        Driver.getDriver().findElement(By.xpath("//ul[@class='jfHeader-menuList']/li/a[text()='Pricing']")).click();
        System.out.println(Driver.getDriver().getTitle());
        Thread.sleep(2000);
    }
}