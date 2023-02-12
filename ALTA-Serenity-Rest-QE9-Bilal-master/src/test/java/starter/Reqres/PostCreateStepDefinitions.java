package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utilts.Constant;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostCreateStepDefinitions {
    @Steps
    reqresAPI ReqresAPI;

    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"UsersReqBody.json");
        ReqresAPI.postCreateUser(jsonReq);
    }

    @When("Send request post create users")
    public void sendRequestPostCreateUsers() {
        SerenityRest.when().post(reqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @Given("Create new user with invalid json")
    public void createNewUserWithInvalidJson() {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/UsersReqBody.json");
        ReqresAPI.postCreateUser(jsonReq);
    }

    @Then("Status code should be {int} bad request")
    public void statusCodeShouldBeBadRequest(int bad) {
        SerenityRest.then().statusCode(bad);
    }
}
