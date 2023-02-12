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

public class PostRegisterStepDefinitions {
    @Steps
    reqresAPI ReqresAPI;

    @Given("Register user with valid json")
    public void registerUserWithValidParameter() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/UsersReqBodyRegister.json");
        ReqresAPI.postRegisterUser(jsonReq);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(reqresAPI.POST_REGISTER_USER);
    }

    @And("Validate register user json schema")
    public void validateRegisterUserJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA+"/RegisterUsersJSONSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("User register with empty password")
    public void userRegisterWithEmptyPassword() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/UsersReqBodyEmptyPasswordRegister.json");
        ReqresAPI.postRegisterUser(jsonReq);
    }

    @And("Validate register empty password json schema")
    public void validateRegisterEmptyPasswordJsonSchema() {
        File jsonReq = new File(Constant.JSON_SCHEMA+"/InvalidRegisterJSONSchema.json");
        ReqresAPI.postRegisterUser(jsonReq);
    }

    @Given("User register with empty email")
    public void userRegisterWithEmptyEmail() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/UsersReqBodyEmptyEmailRegister.json");
        ReqresAPI.postRegisterUser(jsonReq);
    }

    @And("Validate register empty email json schema")
    public void validateRegisterEmptyEmailJsonSchema() {
        File jsonReq = new File(Constant.JSON_SCHEMA+"/InvalidRegisterJSONSchema.json");
        ReqresAPI.postRegisterUser(jsonReq);
    }
}
