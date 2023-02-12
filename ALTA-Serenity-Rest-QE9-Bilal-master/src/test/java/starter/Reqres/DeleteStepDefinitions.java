package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utilts.Constant;

import java.io.File;

public class DeleteStepDefinitions {
    @Steps
    reqresAPI ReqresAPI;

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdId(int id) {
        ReqresAPI.deleteUser(id);
    }

    @When("Send request delete users")
    public void sendRequestDeleteUsers() {
        SerenityRest.when().delete(reqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} no content")
    public void statusCodeShouldBeIntOK(int delete) {
        SerenityRest.then().statusCode(delete);
    }

    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInvalidIdId(int id) {
        ReqresAPI.deleteUser(id);
    }

}
