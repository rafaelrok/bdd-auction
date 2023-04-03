# language: en

Feature: proposing bids

  Scenario: Proposing a single valid bid
    Given Given a valid bid
    When propose to auction
    Then the bid must be accepted

  Scenario: Proposing multiple valid bids
    Given several valid bids
    When propose multiple bids in the auction
    Then Bids are accepted