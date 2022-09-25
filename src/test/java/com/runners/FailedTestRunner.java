package com.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "com/step_definitions"
)
/**
 * This class used for rerun just failing test scenarios again
 */
public class FailedTestRunner {

}
