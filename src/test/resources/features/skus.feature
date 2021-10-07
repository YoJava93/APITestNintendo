Feature: API verification

  @wip
  Scenario:Create a product and verify status code
    Given I logged to SKUS api using "username" and "password" to generate Token
    When I send a post request using pojo class
    Then Status code should be 200
