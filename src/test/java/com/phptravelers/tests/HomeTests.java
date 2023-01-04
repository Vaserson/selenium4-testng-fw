package com.phptravelers.tests;

import driver.DriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public final class HomeTests extends BaseTest {

    private HomeTests() {
    }

    @Test
    public void test1() throws InterruptedException {
        Thread.sleep(2000);
        DriverManager.getDriver().findElement(By.xpath("//ul[@class='jfHeader-menuList']/li/a[text()='Demo']")).click();
        String title = DriverManager.getDriver().getTitle();
        Thread.sleep(2000);

        Assertions.assertThat(title)
                .as("Title is null").isNotNull()
                .as("Doesn't contain expected text").containsIgnoringCase("demo")
                .matches("\\w.*" + "Phptravels")
                .hasSizeBetween(15, 100);
/*        Assert.assertTrue(Objects.nonNull(title));
        Assert.assertTrue(title.toLowerCase().contains("demo"));
//        Assert.assertTrue(title.toLowerCase().matches("\\w.*" + "demo"));
        Assert.assertTrue(title.length() > 15 && title.length() < 100);*/

        List<WebElement> fields = DriverManager.getDriver().findElements(By.xpath("//input"));
        Assertions.assertThat(fields)
                .hasSize(5)
                .extracting(WebElement::getText)
//                .extracting(e -> e.getText())
                .contains("result");
        Assert.assertEquals(fields.size(), 5);

/*        boolean isResultEnabled = false;
        for (WebElement field : fields) {
            if (field.getAttribute("placeholder").equalsIgnoreCase("result")) {
                isResultEnabled = true;
                break;
            }
        }
        Assert.assertTrue(isResultEnabled);*/
    }

    @Test(enabled = false)
    public void test2() throws InterruptedException {
        Thread.sleep(2000);
        DriverManager.getDriver().findElement(By.xpath("//ul[@class='jfHeader-menuList']/li/a[text()='Pricing']")).click();
        System.out.println(DriverManager.getDriver().getTitle());
        Thread.sleep(2000);
    }
}