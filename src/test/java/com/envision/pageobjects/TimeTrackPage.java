package com.envision.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TimeTrackPage {
    protected WebDriver driver;

    public TimeTrackPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }
}
