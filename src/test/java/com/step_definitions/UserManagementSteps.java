package com.step_definitions;

import com.pages.Customer;
import com.pages.HeaderPage;
import com.pages.UserOverviewPage;
import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserManagementSteps {

    UserOverviewPage userOverviewPage = new UserOverviewPage();
    LoginPage loginPage = new LoginPage();
    HeaderPage headerPage = new HeaderPage();
    Customer customer = new Customer();

    @Given("User logged into the admin panel")
    public void user_logged_into_the_admin_panel() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.login(ConfigurationReader.getProperty("email"),ConfigurationReader.getProperty("password"));
    }
    @When("User should see the welcome message {string} on the dashboard")
    public void userShouldSeeTheWelcomeMessageOnTheDashboard(String expectedWelcomeMessageText) {
        Assert.assertTrue("Welcome message text not matched!",userOverviewPage.getWelcomeMessageText().contains(expectedWelcomeMessageText));
    }
    @When("User open the user details of the first user {string}")
    public void user_open_the_user_details_of_the_first_user(String expectedFirsCustomerEmailAddress) {
        headerPage.clickOnSearchInput();
        headerPage.clickOnFirstCustomer();
        Assert.assertEquals(
                "The email address does not match the expected value. Expected: " + expectedFirsCustomerEmailAddress + ", but found: " + customer.getCustomerEmailAddress(),
                expectedFirsCustomerEmailAddress,customer.getCustomerEmailAddress());
    }
    @When("User click on the {string} button")
    public void user_click_on_the_button(String button) {
        if (button.equals("Edit")) {
            customer.clickUserDetailsEditButton();
        } else if (button.equals("Save")) {
            customer.clickUserDetailsUpdateButton();
        } else {
            throw new IllegalArgumentException("Button " + button + " is not a valid option.");
        }
    }
    @When("User change the first name to {string}")
    public void user_change_the_first_name_to(String newFirstName) {
        customer.replaceTheFirstName(newFirstName);
    }
    @Then("The user's full name should be {string}")
    public void the_user_s_full_name_should_be(String expectedCustomerName) {
        BrowserUtils.waitForTime(1);
        Assert.assertEquals("The full name displayed on the page does not match the expected value. Expected: " + expectedCustomerName + ", but found: " + customer.getUserDetailsName(),
                expectedCustomerName,customer.getUserDetailsName());
    }



}
