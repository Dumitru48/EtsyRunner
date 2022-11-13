@smoke @regression
Feature: Login Functionality of WebOrder Page
#Command out using "command+slash"
#  Background: Navigation to the website
#    #Given User navigates to the 'https://demo.weborder.net'
#
#  Scenario: Validation of WebOrder Login Page(Happy Path)
#   # Given User navigates to the 'https://demo.weborder.net'
#    When User provides username "guest1@microworks.com" and password 'Guest1!'
#    Then User validates the title 'ORDER DETAILS - Weborder' from homepage
#
#  Scenario: Validation of WebOrder Login Page(Correct Username Wrong password)
#   # Given User navigates to the 'https://demo.weborder.net'
#    When User provides username "guest1@microworks.com" and password 'dfgdghf'
#    Then User validates the message 'Sign in Failed' from login page
#
#  Scenario: Validation of WebOrder Login Page(Wrong Username Correct password)
#  #  Given User navigates to the 'https://demo.weborder.net'
#    When User provides username "dfgdfh@gmail.com" and password 'Guest1!'
#    Then User validates the message 'Sign in Failed' from login page
#
#  Scenario: Validation of WebOrder Login Page(Empty Username Empty password)
#  #  Given User navigates to the 'https://demo.weborder.net'
#    When User provides username '' and password ''
#    Then User validates the message 'Sign in Failed' from login page

  Scenario Outline: Validation of WebOrder Login Page(Empty Username Empty password)

    When User provides username '' and password ''
    Then User validates the message 'Sign in Failed' from login page

    Examples:
      | username                | password | message        |
      | guest1@microworks.com   |          |                |
      | guest1@microworks.com   | Guest1!  |                |
      | !@#$%^&*@microworks.com | Guest1!  | Sign in Failed |
      | GUEST1@microworks.com   | Guest1!  | Sign in Fail   |
      | guest1@microworks.com   |          | Sign in Failed |
      | guest1@microworks.com   | Guest    | Sign in Failed |
      | guest1@microworks.com   | Guest    | Sign in        |
      | guest@microworks.com    | Guest1!  | Sign in Failed |
      | guest@microworks.com    | Guest1!  | Sign in Failed |
      | guest@microworks.com    | Guest1!  |                |
      | guest@microworks.com    | Guest1   | Sign in Failed |
      | guest@microworks.com    | Guest1   |                |







    #max 11