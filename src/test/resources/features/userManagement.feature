@smoke @regression
Feature: User Management on Dashboard
  @wip
  Scenario: Edit user details and update the first name
    Given User logged into the admin panel
    When User should see the welcome message "Welcome to your dashboard." on the dashboard
    And User open the user details of the first user "max.mustermann@helloagain.at"
    And User click on the "Edit" button
    And User change the first name to "Maximilian"
    And User click on the "Save" button
    Then The user's full name should be "Maximilian Mustermann"




