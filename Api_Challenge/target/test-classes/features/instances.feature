Feature: instances
  As a user
  I want to search the instances
  so that i can know the functionalities of the api

  @HappyPath
  Scenario: See the instances
    Given that I want to search the instances
    When I request the intances
    Then I can see the funcionalities of the api
    And verify instances

