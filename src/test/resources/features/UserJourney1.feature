@suite
@wip
Feature: User journey1

  Scenario: open login
    Given I have been authenticated as a user
    Then I should be presented with "Select Role" page
    Then I select "Exporter making declaration" "radio button"
    And  Click "save and continue" button
    Then I should be presented with "Dashboard" page
    And  Click "Create a Simplified declaration" link
    Then I should be presented with "consignment" page
    Then I select "consolidation" "radio button"
    And  I enter "value" in "consignment" page
    And Click "save and continue" button
    Then I should be presented with "consignment declaration" page
    Then I select "No" "radio button"
    And Click "save and continue" button
    Then I should be presented with "consignment confirmation" page
    Then I select "Yourself" "radio button"
    And Click "save and continue" button
    Then I should be presented with "Consignment representative" page
    Then I select "NO" "radio button"
    And Click "save and continue" button
    Then I should be presented with "enter EORI" page
    And I enter "value" in "enter EORI" page
    Then Click "save and continue" button
    Then I should be presented with "name and address" page
    And I enter "value" in "name and address" page
    Then Click "save and continue" button
    Then I should be presented with "submit" page
    And Click "submit declaration" button
    Then I should be presented with "Dashboard" page
#    And Click "start now" button
#    Then I should be presented with "dashboard" page



    #Then I should be presented with "tech difficulties" page

#    Scenario: Consignment
#      Given I have been authenticated as a user
#      Then I should be presented with "consignment" page
