Feature: API verification


  Scenario:Create a product and verify status code
    Given I logged to SKUS api using "username" and "password" to generate Token
    When I send a post request using pojo class
    Then Status code should be 200

  @wip
    Scenario: Checking JSON Schema validation against response body
      Given I logged to SKUS api using "username" and "password" to generate Token
      When I sent a get request with id "20" and i check response against JSon Schema Validation to verify if response body if it matches with requirements
      And  Status code should be 200

