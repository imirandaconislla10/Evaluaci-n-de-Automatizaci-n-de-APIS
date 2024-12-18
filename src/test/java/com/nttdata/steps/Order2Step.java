package com.nttdata.steps;


import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class Order2Step {
    private Response response;
    private String orderId;

    public void APIestaDisponible() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    public void createOrderDetalles(DataTable dataTable) {
        Map<String, Object> orderDetails = new HashMap<>();
        orderDetails.put("petId", dataTable.cell(0, 0));
        orderDetails.put("quantity", dataTable.cell(0, 1));
        orderDetails.put("shipDate", dataTable.cell(0, 2));
        orderDetails.put("status", dataTable.cell(0, 3));
        orderDetails.put("complete", dataTable.cell(0, 4));

        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .body(orderDetails)
                .when()
                .post("/store/order");

        orderId = response.jsonPath().getString("id"); // Guardar el ID de la orden creada
    }

    public void validarStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    public void elBodyRespuestaContener(DataTable dataTable) {
        Map<String, Object> expectedBody = new HashMap<>();
        expectedBody.put("petId", dataTable.cell(0, 0));
        expectedBody.put("quantity", dataTable.cell(0, 1));
        expectedBody.put("shipDate", dataTable.cell(0, 2));
        expectedBody.put("status", dataTable.cell(0, 3));
        expectedBody.put("complete", dataTable.cell(0, 4));

        response.then().body("petId", equalTo(expectedBody.get("petId")))
                .body("quantity", equalTo(expectedBody.get("quantity")))
                .body("shipDate", equalTo(expectedBody.get("shipDate")))
                .body("status", equalTo(expectedBody.get("status")))
                .body("complete", equalTo(expectedBody.get("complete")));
    }

    public void consultarlaOrdenID(String orderId) {
        response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .when()
                .get("/store/order/" + orderId);
    }
}
