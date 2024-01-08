package com.envision.testscript_runner;

import com.envision.pageobjects.LoginPage;
import com.envision.pageobjects.TimeTrackPage;
import com.envision.util.BrowserFactory;
import com.envision.util.CommonUtil;
import com.envision.util.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestRunner {

    @Test
    public void test() throws FileNotFoundException {

        //BrowserFactory.getDriver("chrome");
       //String URL= PropertyFileReader.getfile("config.properties","url");
        //BrowserFactory.openUrl(URL);
        //1. open browser
        WebDriver  driver = BrowserFactory.getDriver("chrome");

        //2. read the url test data from properties file
        String URL= PropertyFileReader.getfile("config.properties","url");

        //3. open the url
        BrowserFactory.openUrl(URL);

        //4. create object for login page.
        LoginPage lp = new LoginPage(driver);

        //5. read the username test data from properties file.
       // String un = PropertyFileReader.getfile("config.properties", "username");
            String un="admin";
        //6. enter the username
        lp.enterUserName(un);

        //7. read the password test data from properties file.
        //String pwd = PropertyFileReader.getfile("config.properties", "password");
        String pwd="maneger";
        //8. enter the password
        lp.enterPassword(pwd);

        //9. click on submit and ensure we are going to next page.

        TimeTrackPage ttp = lp.clickSubmitButton();

        BrowserFactory.closeBrowser();
        BrowserFactory.closeAllBrowser();

    }
}
