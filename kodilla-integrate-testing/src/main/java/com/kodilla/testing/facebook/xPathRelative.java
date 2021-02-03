package com.kodilla.testing.facebook;

import com.kodilla.testing.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class xPathRelative {
    public static void main(String[] args) throws InterruptedException {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://www.facebook.com");

        webDriver.findElement(By.xpath("//button[(@title=\"Akceptuj wszystkie\")]")).click();
        webDriver.findElement(By.id("u_0_2")).click();
        TimeUnit.SECONDS.sleep(2);
        Select selectDay = new Select(webDriver.findElement(By.xpath("//span[(@data-name=\"birthday_wrapper\")]/span/select[1]")));
        selectDay.selectByValue("30");
        Select selectMonth = new Select(webDriver.findElement(By.xpath("//span[(@data-name=\"birthday_wrapper\")]/span/select[2]")));
        selectMonth.selectByIndex(3);
        Select selectYear = new Select(webDriver.findElement(By.xpath("//span[(@data-name=\"birthday_wrapper\")]/span/select[3]")));
        selectYear.selectByValue("1991");
    }
}
