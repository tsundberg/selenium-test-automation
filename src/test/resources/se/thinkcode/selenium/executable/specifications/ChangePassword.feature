Feature: New password

  Scenario: Request a new password from a web site
    Given Bob need a new password
    When the new password is requested
    Then should the confirmation message A new password has been sent to Bob be visible
