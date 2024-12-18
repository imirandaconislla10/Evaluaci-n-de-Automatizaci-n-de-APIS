package com.nttdata.glue;

import com.nttdata.steps.Order1Step;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class Order1Stepdefs {

    @Steps
    Order1Step order;



    @Given("la url  {string}")
    public void laUrl(String url) {
        order.definirURL(url);
    }

    @When("consulto la order con ID {string}")
    public void consultoLaOrderConID(String idOrder) {
        order.consultarOrder(idOrder);
    }

    @Then("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSea(int statusCode) {
        order.validacionRespuesta(statusCode);
    }

    @And("valido el status sea {string}")
    public void validoElStatusSea(String status) {
        order.validarStatus(status);
    }



    @When("creo la petId {string} con el ID {string}")
    public void creoLaPetIdConElID(String  petId, String ID) {
        order.crearOrder(petId,ID);
    }
}
