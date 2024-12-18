Feature: Integridad del API de Store

  Background:
    Given el API de Store está disponible


  Scenario Outline: Creación y consulta de una orden
    When se crea una orden con los siguientes detalles:
      | petId | quantity | shipDate           | status     | complete |
      | <petId> | <quantity> | <shipDate> | <status> | <complete> |
    Then el status code de la respuesta debe ser <statusCode>
    And el body de la respuesta debe contener:
      | petId   | quantity | shipDate           | status     | complete |
      | <petId> | <quantity> | <shipDate> | <status> | <complete> |

    When se consulta la orden con el ID <orderId>
    Then el status code de la respuesta debe ser <statusCodeConsulta>
    And el body de la respuesta debe contener:
      | id      | petId   | quantity | shipDate           | status     | complete |
      | <orderId> | <petId> | <quantity> | <shipDate> | <status> | <complete> |

    Examples:
      | petId | quantity | shipDate           | status     | complete | orderId |
      | 1     | 2       | 2023-10-01T00:00:00Z | placed     | true     | 101     |
      | 2     | 1       | 2023-10-02T00:00:00Z | delivered   | true     | 102     |