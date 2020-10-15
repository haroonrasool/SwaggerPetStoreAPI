Feature: To get the JSON response payload and validate:
  how many pets have the status “available” and name “doggie”.

  URL: https://petstore.swagger.io/v2/pet/findByStatus

  @smoke
  Scenario: Check pets count
    Given user hits the endpoint "/findByStatus"
    And   user sets the accept header to "application/json"
    When  user registers with the following details
      | Status    | Pet Name |
      | available | doggie   |
    Then  the response code should be 200
    And   the count of matching pets should be 71

  @wireMock
  Scenario: Check pet count in WireMock
    Given I run this API test in WireMock
    And   I hit the endpoint "/findByStatus"
    And   I set accept header to "application/json"
    When  I register with the following details
      | Status    | Pet Name |
      | available | doggie   |
    Then the response code should be 200
    And  the count of matching pets should be 71
