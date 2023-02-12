package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utilts.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostLoginStepDefinitions {
    @Steps
    reqresAPI ReqresAPI;

    @Given("Login user with valid json")
    public void loginUserWithValidJSON(){
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/UsersReqBodyLogin.json");
        ReqresAPI.postLoginUser(jsonReq);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(reqresAPI.POST_LOGIN_USER);
    }

    @And("Response body token should be {string}")
    public void responseBodyEmailShouldBeAndPasswordIs(String token) {
        SerenityRest.then()
                .body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Validate login user json schema")
    public void validateLoginUserJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSON_SCHEMA+"/LoginUsersJSONSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    @Given("Send login with empty password")
    public void sendLoginWithEmptyPassword() {
        File json = new File(Constant.JSON_REQ_BODY+"/UsersReqBodyEmptyPasswordLogin.json");
        reqresAPI.postInvalidLogin(json);
    }

    @And("Response body message should be {string}")
    public void responseBodyMessageShouldBe(String error) {
        SerenityRest.then()
                .body("error", equalTo(error));
    }

    @And("Validate empty password json schema")
    public void validateEmptyPasswordJsonSchema() {
        File jsonSchema= new File(Constant.JSON_SCHEMA+"/InvalidLoginJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Send login with empty email")
    public void sendLoginWithEmptyEmail() {
        File json = new File(Constant.JSON_REQ_BODY+"/UsersReqBodyEmptyEmailLogin.json");
        reqresAPI.postInvalidLogin(json);
    }

    @And("Validate empty email json schema")
    public void validateEmptyEmailJsonSchema() {
        File jsonSchema= new File(Constant.JSON_SCHEMA+"/InvalidLoginJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
