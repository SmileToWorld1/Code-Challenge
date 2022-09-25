package com.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

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
    public static WebElement waitForVisibility(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOf(webElement));
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

    /**
     *This method generate a random number between lowerRange to upperRange
     * @param lowerRange within limits
     * @param upperRange within limits
     * @return random integer number
     */
    public static int generateRandomIntNumWithRange(int lowerRange, int upperRange){
        Random random = new Random();
            int rand;
            while (true){
                rand = random.nextInt(upperRange+1);
                if(rand >= lowerRange) break;
            }
        return rand;
    }



}
