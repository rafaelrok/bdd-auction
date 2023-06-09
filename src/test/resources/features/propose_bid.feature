# language: en

Feature: proposing bids

  Scenario: Proposing a single valid bid
    Given a valid bid with "name"
    When propose to auction
    Then bid must be accepted

  Scenario: Proposing multiple valid bids
    Given a bid of 10.0 real from the user "username"
    And a bid of 15.0 real from the user "username2"
    When propose multiple bids in the auction
    Then Bids are accepted

  Scenario Outline: Proposing bid invalid
    Given a bid invalid of <value> real
    When propose to auction
    Then bid is not accepted

    Examples:
      | value |
      | 0     |
      | -1    |
      | 0.0   |
      | -1.0  |
      | -1000 |