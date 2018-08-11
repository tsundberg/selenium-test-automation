Feature: New password

  Scenario Outline: Request a new password from a web site
    Given <browser_name> browser is used
    And Bob need a new password
    When the new password is requested
    Then should the confirmation message A new password has been sent to Bob be visible

    Examples:
      | browser_name |
      | Chrome       |
      | Html_Unit    |
      | Firefox      |
