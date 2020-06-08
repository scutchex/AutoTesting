package ru.deliveryClub;

import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    @Test
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://ru.wikipedia.org/wiki/Netcracker_Technology");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Netcracker Technology — Википедия"));
        driver.findElement(By.xpath("//a[contains(.,'netcracker.com')]"));
        driver.quit();
    }
}
