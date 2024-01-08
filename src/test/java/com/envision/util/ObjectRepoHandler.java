package com.envision.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectRepoHandler {

      public static   WebDriver driver;
    public static WebElement getElement( String locatorType, String locatorValue) {
        System.out.println(locatorValue+locatorType);
        WebElement element = null;

        if (locatorType.equalsIgnoreCase("id")) {
            element = driver.findElement(By.id(locatorValue));
        } else if (locatorType.equalsIgnoreCase("name")) {
            element = driver.findElement(By.name(locatorValue));
        } else if (locatorType.contains("linkText")) {
            element = driver.findElement(By.partialLinkText(locatorValue));
        } else if (locatorType.equalsIgnoreCase("tagname")) {
            element = driver.findElement(By.tagName(locatorValue));
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            element = driver.findElement(By.xpath(locatorValue));
        } else if (locatorType.equalsIgnoreCase("css")) {
            element = driver.findElement(By.cssSelector(locatorValue));
        }

        return element;
    }
}
