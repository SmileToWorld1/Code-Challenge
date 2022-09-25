package com.pages;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasketPage {

    public BasketPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class=\"m-productPrice__salePrice\"]")
    private WebElement salePrice;

    public WebElement getSalePrice() {
        return salePrice;
    }

    @FindBy(id = "quantitySelect0-key-0")
    private WebElement selectControl;

    public void selectQuantityByValue(String value){
        Select select = new Select(selectControl);
        select.selectByValue(value);
    }

    @FindBy(xpath = "//div[@class=\"m-basket__quantity\"]")
    private WebElement basketQuantity;

    public WebElement getBasketQuantity() {
        return basketQuantity;
    }

    @FindBy(id = "notifyTitle")
    private WebElement notifyTitle;

    public WebElement getNotifyTitle() {
        return notifyTitle;
    }

    @FindBy(id = "removeCartItemBtn0-key-0")
    private WebElement deleteButton;

    public void clickDeleteButton(){
        BrowserUtils.waitForClickAbility(deleteButton).click();
    }

    @FindBy(xpath = "//strong[.='Sepetinizde Ürün Bulunmamaktadır']")
    private WebElement emptyMessageTitle;

    public WebElement getEmptyMessageTitle() {
        return emptyMessageTitle;
    }

    public final String expectedEmptyBasketBoxMessage = "SEPETINIZDE ÜRÜN BULUNMAMAKTADIR";

}
