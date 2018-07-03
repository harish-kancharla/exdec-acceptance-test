@suite
@wip
Feature: User journey1

  Scenario: open login
    Given I have been authenticated as a user
    Then I should be presented with "Select Role" page
    Then I select "web loader arriving goods" "radio button"
    And  Click "save and continue" button
    Then I should be presented with "tech difficulties" page