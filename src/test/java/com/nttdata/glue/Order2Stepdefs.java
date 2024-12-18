package com.nttdata.glue;

import com.nttdata.steps.Order2Step;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class Order2Stepdefs {

    @Steps
    Order2Step order2;

    @Given("el API de Store está disponible")
    public void elAPIDeStoreEstáDisponible() {
        order2.APIestaDisponible();

    }

    @When("se crea una orden con los siguientes detalles:")
    public void seCreaUnaOrdenConLosSiguientesDetalles(io.cucumber.datatable.DataTable dataTable) {
        order2.createOrderDetalles(dataTable);
    }

    @Then("el status code de la respuesta debe ser <statusCode>")
    public void elStatusCodeDeLaRespuestaDebeSerStatusCode(int statusCode) {
        order2.validarStatusCode(statusCode);
    }

    @And("el body de la respuesta debe contener:")
    public void elBodyDeLaRespuestaDebeContener(io.cucumber.datatable.DataTable dataTable) {
        order2.elBodyRespuestaContener(dataTable);
    }

    @When("se consulta la orden con el ID <orderId>")
    public void seConsultaLaOrdenConElIDOrderId(String orderId) {
        order2.consultarlaOrdenID(orderId);
    }


}
