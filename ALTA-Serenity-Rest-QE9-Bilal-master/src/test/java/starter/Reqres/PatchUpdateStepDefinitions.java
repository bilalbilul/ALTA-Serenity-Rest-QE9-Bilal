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

public class PatchUpdateStepDefinitions {
    @Steps
    reqresAPI ReqresAPI;

    @Given("Patch Update user with valid json and parameter id {int}")
    public void patchUpdateUserWithValidJsonAndParameterId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/UsersReqBody.json");
        ReqresAPI.patchUpdateUser(id,jsonReq);
    }

    @When("Send request patch update users")
    public void sendRequestPatchUpdateUsers() {
        SerenityRest.when().patch(reqresAPI.PATCH_UPDATE_USER);
    }

    @And("Response body id should be {int} and token is {string}")
    public void responseBodyIdShouldBeAndTokenIs(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID, equalTo(id))
                .body(ReqresResponses.TOKEN, equalTo(token));
    }
}
