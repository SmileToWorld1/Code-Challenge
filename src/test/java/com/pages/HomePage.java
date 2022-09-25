package com.pages;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public final String homePageTitle = "Beymen.com – Türkiye’nin Tek Dijital Lüks Platformu";

    @FindBy(xpath = "//input[@placeholder='Ürün, Marka Arayın']")
    private WebElement searchBox;

    public WebElement getSearchBox() {
        return searchBox;
    }

    @FindBy(xpath = "//div[@data-page='1']")
    private List<WebElement> page1Products;

    public void clickRandomProduct1Page() {
        int randomNumber = BrowserUtils.generateRandomIntNumWithRange(0, 47);
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                page1Products.get(randomNumber).click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
                e.printStackTrace();
            }
            attempts++;
        }
    }

    @FindBy(xpath = "//span[@class='o-productDetail__description']")
    private WebElement productInformation;

    public WebElement getProductInformation() {
        return productInformation;
    }

    @FindBy(xpath = "//ins[@id='priceNew']")
    private WebElement priceNew;

    public WebElement getPriceNew() {
        return priceNew;
    }

    @FindBy(xpath = "//div[@class=\"m-variation\"]/span")
    private List<WebElement> productVariations;

    public void clickFirstEnableProductVariation(){
        for (WebElement productVariation : productVariations) {
            if (productVariation.getAttribute("class").contains("disabled")){
                continue;
            }
            productVariation.click();
            break;
        }
    }

    @FindBy(id = "addBasket")
    private WebElement addBasketButton;

    public void clickAddBasketButton() {
        BrowserUtils.waitForClickAbility(addBasketButton).click();
    }

    @FindBy(xpath = "//button[contains(text(),'Sepete Git')]")
    private WebElement goToBasketButton;

    public void clickGoToBasketButton(){
        BrowserUtils.waitForClickAbility(goToBasketButton).click();
    }





}
