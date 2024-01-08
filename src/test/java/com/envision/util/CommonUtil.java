package com.envision.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CommonUtil {
    public static void takeScreenShot(WebDriver driver) {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src= ts.getScreenshotAs(OutputType.FILE);

        File dest = new File("screenshots//"  + ".png");
        try {
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
