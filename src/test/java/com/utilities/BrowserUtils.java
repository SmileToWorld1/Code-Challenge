package com.utilities;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.Set;


public class BrowserUtils {

    /**
     * This method accepts a String "expectedInURL" and changes the window depends on expectedInURL
     * @param expectedInURL
     */
    public static void switchToWindow( String expectedInURL){
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().equals(expectedInURL)){
                break;
            }
        }
    }

    /**
      This method accepts a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle( String expectedTitle){
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Başlık uyuşmuyor!",expectedTitle,actualTitle);

    }

    /**
     * Moves the mouse to given element
     * @param element on which to hover
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
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
     * Waits for the provided list of elements to be visible on the page
     *
     * @param webElements
     */
    public static List<WebElement> waitForVisibility(List<WebElement> webElements) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        return wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
    }

    /**
     * Waits until the given number of windows has been occurred
     * @param numberOfWindow
     */
    public static void waitNumberOfWindowsToBe(int numberOfWindow){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindow));
    }

    /**
     * Highlighs an element by changing its background and border color
     * @param element
     */
    public static void highlight(WebElement element){
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
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
