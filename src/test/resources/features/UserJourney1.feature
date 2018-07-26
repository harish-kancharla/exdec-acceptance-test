@suite
@wip
Feature: User journey1

  Scenario: open login
    Given I have been authenticated as a user
    Then I should be presented with "Select Role" page
    Then I select "Exporter making declaration" "radio button"
    And  Click "Save and continue" button
    Then I should be presented with "Export Declarations" page
    And Click "Start now" button
    Then I should be presented with "Dashboard" page
    And  Click "Create a Simplified declaration" link
    Then I should be presented with "consignment" page
    Then I select "consolidation" "radio button"
    And  I enter "value" in "consignment" page
    And Click "Save and continue" button
    Then I should be presented with "own Description" page
    Then I select "No" "radio button"
    And Click "Save and continue" button
    Then I should be presented with "whose declaration" page
    Then I select "Yourself" "radio button"
    And Click "Save and continue" button
    Then I should be presented with "have Representative" page
    Then I select "Yes" "radio button"
    And Click "Save and continue" button
    Then I should be presented with "enter EORI" page
    And I enter "value" in "enter EORI" page
    Then Click "Save and continue" button
    Then I should be presented with "Full export declaration" page
    And I enter "value" in "Full export declaration" page
    Then Click "Save and continue" button
    Then I should be presented with "submit" page
    And Click "submit declaration" button
    Then I should be presented with "Dashboard" page
#    And Click "start now" button
#    Then I should be presented with "dashboard" page



    #Then I should be presented with "tech difficulties" page

#    Scenario: Consignment
#      Given I have been authenticated as a user
#      Then I should be presented with "consignment" page
