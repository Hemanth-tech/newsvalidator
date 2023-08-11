Feature: News Validation

  Scenario: Validate a news article from The Guardian
    Given I am on The Guardian news article page
    And I get the first news article
    When I search for similar article using Google
    Then I should see at least "2" similar articles