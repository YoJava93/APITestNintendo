Feature: API verification


  Scenario:Create a product and verify status code
    Given I logged to SKUs api using "username" and "password" to generate Token
    When I send a post request using pojo class
    Then Status code should be 200


    Scenario: Checking JSON Schema validation against response body
      Given I logged to SKUs api using "username" and "password" to generate Token
      When I sent a get request with id "20" and i check response against JSon Schema Validation to verify if response body if it matches with requirements
      And  Status code should be 200

  @wip
    Scenario: Testing delete request
      Given I logged to SKUs api using "username" and "password" to generate Token
      When I  send DELETE request  with id "20"
      Then Status code should be 200
      And I send GET request to "20"
      And Status code should be 200

