package com.envision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {
    @Test

    public static void getLocators() {
        //System.setProperty("webdriver.chrome.driver", "C:/Users/rohit/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

    }
}
