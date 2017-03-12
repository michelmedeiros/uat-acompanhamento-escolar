@Clean
@FixtureLoad
@ActiveFeaturesToggle
Feature: Find students by filter

  Scenario: Find students existing
    Given the following existent students:
      | id                       | deliveryId | providerCnpj | status    | type       | commissionValue | passthroughValue | paymentDate | sendTrackingDate | sendInvoiceDate |
      | 57f54e192df6a1bc8dfcaf3a | 1          | 00887355522  | FULFILLED | COMMISSION | 20.0            | 180.0            | 01/01/2016  | 02/02/2016       | 03/03/2016      |
      | 67f54e192df6a1bc8dfcaf3b | 2          | 00887355522  | FULFILLED | COMMISSION | 10.0            | 90.0             | 02/01/2016  | 02/02/2016       | 03/03/2016      |
    And the following filter with cnpj "00887355522" and endDate 20/10/2016 11:22:00
    When I find students
    Then the students is returned