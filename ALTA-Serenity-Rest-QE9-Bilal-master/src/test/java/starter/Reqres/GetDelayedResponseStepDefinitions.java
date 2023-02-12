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

import static org.hamcrest.Matchers.equalTo;

import net.thucydides.core.annotations.Steps;

public class GetDelayedResponseStepDefinitions {
    @Steps
    reqresAPI ReqresAPI;

    @Given("Get user with valid page {int}")
    public void getSingleUsersWithValidParameterPage(int page) {
        ReqresAPI.getDelayedResponse(page);
    }

    @When("Send request get delayed response")
    public void sendRequestGetSingleUsers() {
        SerenityRest.when().get(reqresAPI.GET_DELAYED_RESPONSE);
    }

    @And("Validate get delayed response json schema")
    public void validateGetDelayedResponseJsonSchema(){
        File jsonSchema= new File(Constant.JSON_SCHEMA+"/GetDelayedResponseJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
