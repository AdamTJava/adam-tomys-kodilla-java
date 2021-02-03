package com.kodilla.testing.ebay;

import com.kodilla.testing.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayTestingApp {
    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get("https://ebay.com");

        WebElement searchField = webDriver.findElement(By.id("gh-ac"));
        searchField.sendKeys("Laptop");
        searchField.submit();
    }
}
