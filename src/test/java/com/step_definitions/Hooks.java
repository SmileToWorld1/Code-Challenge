package com.step_definitions;


import com.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


/**
 In this class we will be able to pass pre- & post- conditions to
 each scenario and each step
 */
public class Hooks {

    @Before
    public void setup(){

    }

    @After
    public void teardownScenario(Scenario scenario){
        /**
         *scenario.isFailed --> if scenario fails, this method will return TRUE boolean value
         */
        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }

        Driver.closeDriver();
    }

}


