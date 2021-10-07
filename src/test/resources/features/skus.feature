Feature: API verification

  Background: Assuming user is has to login each time when sending any requests
    Given I logged to SKUs api using "username" and "password" to generate Token

  Scenario: Testing GET request
    When I send GET request
    Then Status code should be 200

  Scenario:Create a product and verify status code
    When I send a POST request using pojo class
    Then Status code should be 200

    Scenario: Checking JSON Schema validation against response body
      When I sent a GET request with id "20" and i check response against JSon Schema Validation to verify if response body if it matches with requirements
      And  Status code should be 200


    Scenario: Testing delete request
      When I  send DELETE request  with id "20"
      Then Status code should be 200
      And I send GET request to id "20"
      And Status code should be 404

      Scenario:Negative POST request test
        When I send POST request with invalid body
        Then Status code should be 400

    Scenario: Negative testing with GET request
      When I send GET request with invalid path params "435437"
      Then Status code should be 400

      Scenario: Negative testing with GET request
        When I send GET request with POST body
        Then Status code should be 400
  @wip
    Scenario: Negative POST request testing
      When I send POST request with no body
      Then Status code should be 400




