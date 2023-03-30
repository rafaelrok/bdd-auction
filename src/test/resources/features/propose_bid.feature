# language: en

Feature: proposing bids

  Scenario: Proposing a single valid bid
    Given Given a valid bid
    When When propose bid
    Then the bid must be accepted