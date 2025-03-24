package com.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class BrowserUtils {

    /**
      This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle( String expectedTitle){
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Başlık uyuşmuyor!",expectedTitle,actualTitle);
    }

    /**
     * Waits for the provided element to be visible on the page
     *
     * @param webElement
     */
    public static WebElement waitForVisibilityOfElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Waits for the provided elements to be visible on the page
     *
     * @param webElements
     */
    public static List<WebElement> waitForVisibilityOfAllElements(List<WebElement> webElements) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @return WebElement
     */
    public static WebElement waitForClickAbility(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForTime(long timeInSeconds) {
        try {
            long timeInMillis = timeInSeconds * 1000;
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
