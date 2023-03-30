# language: en

Feature: Propondo lances

  Scenario: Propondo um unico lance valido
    Given Dado um lance valido
    When Quando propoe lance
    Then O lance deve ser aceito