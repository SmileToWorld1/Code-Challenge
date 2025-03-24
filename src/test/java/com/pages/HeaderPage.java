package com.pages;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HeaderPage {
    public HeaderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[contains(@class, 'search-input search-bar__input desktop-only')]/input")
    private WebElement searchInput;

    @FindBy(xpath = "//span[contains(@class, 'search-bar__category-title') and text()='customers']/following::ul[1]//li")
    private List<WebElement> searchInputCustomerListItems;

    public void clickOnSearchInput() {
        BrowserUtils.waitForVisibilityOfElement(searchInput);
        searchInput.click();
    }
    public void clickOnFirstCustomer() {
        BrowserUtils.waitForVisibilityOfAllElements(searchInputCustomerListItems);
        if (!searchInputCustomerListItems.isEmpty()) {
            searchInputCustomerListItems.get(0).click();
        }
    }

}
