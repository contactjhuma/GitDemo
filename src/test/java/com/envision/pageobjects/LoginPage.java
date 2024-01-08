package com.envision.pageobjects;

import com.envision.util.ObjectRepoHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;
    public LoginPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }
    public LoginPage enterUserName(String userNameInputValue) {
        System.out.println(userNameInputValue);
        //the below 2 lines helps to take the element from the "objectrepository.properties" key inputs

        ObjectRepoHandler.getElement("id","username").sendKeys(userNameInputValue);

//        WebElement userNameElement = ObjectRepoHandler.getElement("id","username");
//        System.out.println(userNameElement);
//        userNameElement.sendKeys(userNameInputValue);
        //or
        //the below code helps to take the element from the above @FindBy annotation and PageFactory.initElements(driver, this) in constructor.
        //this.userNameElement.sendKeys(userNameInputValue);
        return this;
    }

    //USER_NAME_TEXT_BOX: name_username
    //PASSWORD_TEXT_BOX: xpath_//input[@name='pwd']
    //LOGIN_BUTTON:   css_a[id='loginButton']
    public LoginPage enterPassword(String password) {
        WebElement passwordElement = ObjectRepoHandler.getElement("xpath","//input[@name='pwd']");
        passwordElement.sendKeys(password);
        return this;
    }

    public TimeTrackPage clickSubmitButton() {
        WebElement submitButton = ObjectRepoHandler.getElement("css","a[id='loginButton']");
        submitButton.click();
        return PageFactory.initElements(this.driver, TimeTrackPage.class);
        //        return new TimeTrackPage(driver);
    }



}
