Feature: Sign in via email

  Scenario: Existing user logs in
    Given Lemuel opens the SurveyMonkey app
    When he logs in using valid username "HIDDEN" and password "HIDDEN"
    Then he is redirected to the home screen

  Scenario: Existing user logs out
    Given Lemuel opens the SurveyMonkey app
    When he logs in using valid username "HIDDEN" and password "HIDDEN"
    Then he is redirected to the home screen
    When he logs out
    Then he is redirected to the landing screen