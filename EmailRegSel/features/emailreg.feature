@EmailRegisteration
Feature: EmailRegisteration

Background: user wants to login so is navigated to the login page

Scenario: check the title of the page
Given user is on the registeration page
Then check the title of the page

Scenario: Successful registeration with valid details
Given user is on the registeration page
When user enters correct details
Then display alert message

Scenario: Failure in registeration due to wrong details
Given user is on the registeration page
When user enters wrong details
Then display alert message