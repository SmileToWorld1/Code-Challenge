package com.pages;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserOverviewPage {

    public UserOverviewPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[contains(text(), 'Welcome to your dashboard.')]")
    private WebElement welcomeMessage;

    public String getWelcomeMessageText() {
        BrowserUtils.waitForVisibilityOfElement(welcomeMessage);
        return welcomeMessage.getText();
    }




}
