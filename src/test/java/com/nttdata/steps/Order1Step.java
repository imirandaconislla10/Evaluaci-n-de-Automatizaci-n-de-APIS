package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

public class Order1Step {
    Response response;
    private String URL_BASE;

    public void definirURL(String url) {
        URL_BASE = url;
    }

    public void consultarOrder(String idOrder) {
        response = RestAssured
                .given()
                .header("Host", "google.com")
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                .log().all()
                .get("store/order/" + idOrder)
                .then()
                .log().all()
                .extract().response()
        ;
    }

    public void validacionRespuesta(int statusCode) {
        Assert.assertEquals("Validacion de Respuesta ", statusCode , response.statusCode());
    }

    public void validarStatus(String status) {
        //
    }

    public void crearOrder(String petId, String ID) {
        String body = "{\n" +
                "  \"id\": "+ ID + ",\n" +
                "  \"petId\":"+ petId + ",\n" +
                "  \"status\": \"placed\"\n" +
                "}";
        response = RestAssured
                .given()
                .baseUri(URL_BASE)
                .header("Content-Type", "application/json")
                .relaxedHTTPSValidation()
                .body(body)
                .log().all()
                .post("/store/order")
                .then()
                .extract().response();


    }
}
