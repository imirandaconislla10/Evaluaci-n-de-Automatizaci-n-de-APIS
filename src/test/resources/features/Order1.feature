 Feature: OrderStore  API

   @CrearMascota
    Scenario Outline: Crear Orden
      Given la url  "https://petstore.swagger.io/v2"
      When creo la petId <petId> con el ID <id>
      Then valido el codigo de respuesta sea <statusCode>
      Examples:
           | id  | petId | statusCode |
           | "1" |"35"   | 200        |
           | "2" | "3"   | 200        |




   @ConsultaOrder
   Scenario: Consulta order
     Given la url  "https://petstore.swagger.io/v2"
     When  consulto la order con ID "1"
     Then valido el codigo de respuesta sea 200
     And valido el status sea "placed"


