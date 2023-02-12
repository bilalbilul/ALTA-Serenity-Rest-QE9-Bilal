package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utilts.Constant;

import java.io.File;

public class GetSingleUsersStepDefinitions {
    @Steps
    reqresAPI ReqresAPI;

    @Given("Get single users with valid parameter id {int}")
    public void getSingleUsersWithValidParameterPage(int id) {
        ReqresAPI.getSingleUser(id);
    }

    @When("Send request get single users")
    public void sendRequestGetSingleUsers() {
        SerenityRest.when().get(reqresAPI.GET_SINGLE_USERS);
    }

    @Given("Get single users with string parameter {string}")
    public void getListUsersWithBlankParameter(String xxx) {
        ReqresAPI.getSingleUser(Integer.parseInt(xxx));
    }

    @Given("Get single users with blank parameter id {}")
    public void getSingleUsersWithBlankParameterIdId(Integer id) {
        ReqresAPI.getSingleUser(id);
    }

    @Given("Get single users with not found parameter id {}")
    public void getSingleUsersWithNotFoundParameterIdInt(int id) {
        ReqresAPI.getSingleUser(id);
    }

    @When("Send request get single users not found")
    public void sendRequestGetSingleUsersNotFound() {
        SerenityRest.when().get(reqresAPI.GET_SINGLE_USERS_NOT_FOUND);
    }

    @And("Validate get list user not found json schema")
    public void validateGetListUserNotFoundJsonSchema() {
        File jsonSchema= new File(Constant.JSON_SCHEMA+"/GetSingleUsersNotFound.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get single users unknown with parameter {int}")
    public void getSingleUsersUnknownWithParameterId(int id) {
        ReqresAPI.getSingleUsersUnknown(id);
    }

    @When("Send request get single users unknown")
    public void sendRequestGetSingleUsersUnknown() {
        SerenityRest.when().patch(reqresAPI.GET_SINGLE_USERS_UNKNOWN);
    }

    @And("Validate get single user unknown json schema")
    public void validateGetSingleUserUnknownJsonSchema() {
        File jsonSchema= new File(Constant.JSON_SCHEMA+"/GetSingleUsersUnknownJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Validate get single user json schema")
    public void validateSingleUserJsonSchema(){
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA+"/SingleUserJSONSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

}
