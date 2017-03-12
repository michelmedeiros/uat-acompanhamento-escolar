@Clean
@FixtureLoad
@ActiveFeaturesToggle
Feature: Close cycle by provider

  Scenario: Close cycle without other existing
    Given the following existent transactions:
      | id                       | deliveryId | providerCnpj | status    | type       | commissionValue | passthroughValue | paymentDate | sendTrackingDate | sendInvoiceDate |
      | 57f54e192df6a1bc8dfcaf3a | 1          | 00887355522  | FULFILLED | COMMISSION | 20.0            | 180.0            | 01/01/2016  | 02/02/2016       | 03/03/2016      |
      | 67f54e192df6a1bc8dfcaf3b | 2          | 00887355522  | FULFILLED | COMMISSION | 10.0            | 90.0             | 02/01/2016  | 02/02/2016       | 03/03/2016      |
    And the following filter with cnpj "00887355522" and endDate 20/10/2016 11:22:00
    When I close the cycle
    Then the cycle is created for cnpj "00887355522"
    And this cycle has "numberOfOrders" as "1"
    And this cycle has "commissionValue" as "30.0"
    And this cycle has "passthroughValue" as "270.0"
    And this cycle has "status" as "CLOSED"

  Scenario: Close cycle with other paid existing
    Given the following existent transactions:
      | id                       | deliveryId | providerCnpj | status      | type       | commissionValue | passthroughValue | paymentDate | sendTrackingDate | sendInvoiceDate |
      | 57f54e192df6a1bc8dfcaf3a | 1          | 00887355522  | FULFILLED   | COMMISSION | 20.0            | 180.0            | 01/01/2016  | 02/02/2016       | 03/03/2016      |
      | 67f54e192df6a1bc8dfcaf3b | 2          | 00887355522  | FULFILLED   | COMMISSION | 50.0            | 300.0            | 02/01/2016  | 02/02/2016       | 03/03/2016      |
      | ab354e192df6a1bc8dfca123 | 3          | 00887355522  | PROVISIONED | COMMISSION | 10.0            | 120.0            | 03/01/2016  | 02/02/2016       | 03/03/2016      |
    And a "paid cycle" containing id "1a2s4e192df6a1bc8dfcag5t", providerCnpj "00887355522", passthrough value 200 and commission value 20
    And the following filter with cnpj "00887355522" and endDate 11/11/2016 09:22:00
    When I close the cycle
    Then the cycle is created for cnpj "00887355522"
    And this cycle has "numberOfOrders" as "1"
    And this cycle has "commissionValue" as "70.0"
    And this cycle has "passthroughValue" as "480.0"
    And this cycle has "status" as "CLOSED"

  Scenario: Close cycle with previous closed and return message with error
    Given the following existent transactions:
      | id                       | deliveryId | providerCnpj | status    | type       | commissionValue | passthroughValue | paymentDate | sendTrackingDate | sendInvoiceDate |
      | 57f54e192df6a1bc8dfcaf3a | 1          | 00887355520  | FULFILLED | COMMISSION | 20.0            | 180.0            | 01/01/2016  | 02/02/2016       | 03/03/2016      |
      | 67f54e192df6a1bc8dfcaf3b | 2          | 00887355520  | FULFILLED | COMMISSION | 50.0            | 300.0            | 01/01/2016  | 02/02/2016       | 03/03/2016      |
    And a "closed cycle" containing id "1a2s4e192df6a1bc8dfcag5t", providerCnpj "00887355522", passthrough value 200 and commission value 20
    And the following filter with cnpj "00887355522" and endDate 11/11/2016 09:22:00
    When I close the cycle
    Then the cycle is not created and a exception is received with status "422" and message "Existe um ciclo com faturamento pendente para esse fornecedor. Conclua o faturamento deste ciclo antes de seguir."

  Scenario: Close cycle with end date greater than the current date and return message with error
    Given the following existent transactions:
      | id                       | deliveryId | providerCnpj | status    | type       | commissionValue | passthroughValue | paymentDate | sendTrackingDate | sendInvoiceDate |
      | 57f54e192df6a1bc8dfcaf3a | 1          | 00887355520  | FULFILLED | COMMISSION | 10.0            | 170.0            | 01/01/2016  | 02/02/2016       | 03/03/2016      |
      | 67f54e192df6a1bc8dfcaf3b | 2          | 00887355522  | FULFILLED | COMMISSION | 54.0            | 290.0            | 01/01/2016  | 02/02/2016       | 03/03/2016      |
    And a "paid cycle" containing id "1a2s4e192df6a1bc8dfcag5t", providerCnpj "00887355522", passthrough value 200 and commission value 20
    And the following filter with cnpj "00887355522" and current date
    When I close the cycle
    Then the cycle is not created and a exception is received with status "422" and message "Data final do ciclo não pode ser maior que a data atual."

  Scenario: Close cycle with end date minor than the start date of the cycle and return message with error
    Given the following existent transactions:
      | id                       | deliveryId | providerCnpj | status    | type       | commissionValue | passthroughValue | paymentDate | sendTrackingDate | sendInvoiceDate |
      | 57f54e192df6a1bc8dfcaf3a | 1          | 00887355520  | FULFILLED | COMMISSION | 10.0            | 170.0            | 01/01/2016  | 02/02/2016       | 03/03/2016      |
      | 67f54e192df6a1bc8dfcaf3b | 2          | 00887355522  | FULFILLED | COMMISSION | 54.0            | 290.0            | 01/01/2016  | 02/02/2016       | 03/03/2016      |
    And a "closed cycle" containing id "87ps4e192df6a1bc8dfcag5p", providerCnpj "00887355522", passthrough value 200 and commission value 20
    And the following filter with cnpj "36649978000126" and endDate 01/01/2015 09:22:00
    When I close the cycle
    Then the cycle is not created and a exception is received with status "422" and message "Data final do ciclo não pode ser menor que a data inicial do ciclo."
