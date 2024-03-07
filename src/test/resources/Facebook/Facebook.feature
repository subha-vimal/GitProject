Feature: To Validate the Login Functionality Of FaceBook Application

  Background: 
    Given user Launch the Browser and Launch Url

  Scenario: To validate Valid username and InValid Password
    When user have enter the Valid username and Invalid password
    And user click the Login button
    Then user reach the Invalid Warning page

  Scenario: To Validate Valid username and Valid Password
    When user have enter the Valid username and Valid password
    And user click the Login button
    Then user reach the Invalid Warning page

  Scenario Outline: To Validate the username and password
    When user have enter the "<username>" and  "<password>"
    And user click the Login button
    Then user reach the Invalid Warning page

    Examples: 
      | username               | password   |
      | vimal                  |     987655 |
      | subhashini23@ymail.com | Subha@23   |
      | subhashini23@ymail.com | Subha@2309 |
