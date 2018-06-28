@suite
  @wip
Feature: open Authority Wizard
  Scenario: open login
    Given open Authority Wizard
    Then click submit at bottom of the page
    And Take me to Select Role page
    Then select web loader arriving goods
    And Click save and continue
    Then It should take me to tech difficulties page