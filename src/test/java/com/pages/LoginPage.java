package com.pages;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement inputEmail;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[span[contains(text(), 'Sign in')]]")
    private WebElement signInButton;


    public void login(String email, String password) {
        BrowserUtils.waitForVisibilityOfElement(inputEmail);
        inputEmail.sendKeys(email);
        BrowserUtils.waitForVisibilityOfElement(inputPassword);
        inputPassword.sendKeys(password);
        BrowserUtils.waitForClickAbility(signInButton);
        signInButton.click();
    }


}
