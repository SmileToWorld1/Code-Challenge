package com.pages;

import com.utilities.BrowserUtils;
import org.openqa.selenium.Keys;
import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customer {
    public Customer() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//form[contains(@class, 'inline-form')]//div[contains(@class, 'field-input')]//b[text()='E-Mail: ']/following-sibling::span")
    private WebElement userDetailsCustomerEmail;

    @FindBy(xpath = "//button[contains(@class, 'edit-button')]//span[text()=' Edit']")
    private WebElement userDetailsEditButton;

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//button[contains(@class, 'update-button')]")
    private WebElement userDetailsUpdateButton;

    @FindBy(xpath = "//span[@class='name']")
    private WebElement userDetailsName;

    public String getCustomerEmailAddress() {
        BrowserUtils.waitForVisibilityOfElement(userDetailsCustomerEmail);
        return userDetailsCustomerEmail.getText();
    }

    public void clickUserDetailsEditButton() {
        BrowserUtils.waitForClickAbility(userDetailsEditButton);
        userDetailsEditButton.click();
    }

    public void clickUserDetailsUpdateButton() {
        BrowserUtils.waitForClickAbility(userDetailsUpdateButton);
        userDetailsUpdateButton.click();
    }

    public void replaceTheFirstName(String newFirstName) {
        BrowserUtils.waitForVisibilityOfElement(firstNameInput);
        firstNameInput.click();
        BrowserUtils.waitForTime(1);
        firstNameInput.clear();
        BrowserUtils.waitForTime(1);
        String currentValue = firstNameInput.getAttribute("value");
        if (currentValue == null || currentValue.isEmpty()) {
            firstNameInput.sendKeys(newFirstName);
        } else {
            firstNameInput.click();
            BrowserUtils.waitForTime(1);
            firstNameInput.sendKeys(Keys.CONTROL + "a");
            firstNameInput.sendKeys(Keys.DELETE);
            BrowserUtils.waitForTime(1);
            currentValue = firstNameInput.getAttribute("value");
            if (currentValue == null || currentValue.isEmpty()) {
                firstNameInput.sendKeys(newFirstName);
            } else {
                throw new IllegalStateException("The input field is still not empty after the second clear.");
            }
        }
    }

    public String getUserDetailsName() {
        BrowserUtils.waitForVisibilityOfElement(userDetailsName);
        return userDetailsName.getText();
    }




}
