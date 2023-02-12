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

public class GetListUsersStepDefinitions {
    @Steps
    reqresAPI ReqresAPI;

    @Given("get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {
        ReqresAPI.getListUser(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(reqresAPI.GET_LIST_USER);
    }

    @When("Send request get list users not found")
    public void sendRequestGetListUsersNotFound() {
        SerenityRest.when().get(reqresAPI.GET_SINGLE_USERS_NOT_FOUND);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @Given("Get list users with invalid parameter page {int}")
    public void getListUsersWithInvalidParameterPagePage(int page) {
        ReqresAPI.getListUser(page);
    }

    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeNotFound(int not) {
        SerenityRest.then().statusCode(not);
    }

    @And("Validate get list user json schema")
    public void validateJsonSchema(){
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA+"/ListUserJSONSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }
}
