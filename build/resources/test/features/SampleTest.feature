@CoreTests
Feature: This file wil test the validations on the sample json response provided

  Background: Considering there is no URI to make request to, hence the sample json will be read as a prerequisite
    Given The response is read from the JSON file for further validations

@SampleTest
Scenario: Validating if the team has only 4 foreign players and 1 wicket-keeper
  Given The user validates the team has only "4" foreign players
  Then The user tries to verify that there is at least one "Wicket-keeper" in the team