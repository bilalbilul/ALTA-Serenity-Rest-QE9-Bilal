package starter.Reqres;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class TugasStepDefinition {

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

    @Given("Register user with valid json")
    public void registerUserWithValidParameter() {
        File jsonReq = new File(reqresAPI.DIR+"/src/test/resources/JSON/ReqBody/UsersReqBody2.json");
        ReqresAPI.postRegisterUser(jsonReq);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(reqresAPI.POST_REGISTER_USER);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.then()
                .body("id", equalTo(id));
    }

    @Given("Login user with valid json")
    public void loginUserWithValidJSON(){
        File jsonReq = new File(reqresAPI.DIR+"/src/test/resources/JSON/ReqBody/UsersReqBody3.json");
        ReqresAPI.postLoginUser(jsonReq);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(reqresAPI.POST_LOGIN_USER);
    }

    @And("Response body token should be {string}")
    public void responseBodyEmailShouldBeAndPasswordIs(String token) {
        SerenityRest.then()
                .body("token", equalTo(token));
    }

    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInvalidIdId(int id) {
        ReqresAPI.deleteUser(id);
    }

    @Given("Get list users with invalid parameter page {int}")
    public void getListUsersWithInvalidParameterPagePage(int page) {
        ReqresAPI.getListUser(page);
    }

    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeNotFound(int not) {
        SerenityRest.then().statusCode(not);
    }

    @Given("Create new user with invalid json")
    public void createNewUserWithInvalidJson() {
        File jsonReq = new File(reqresAPI.DIR+"/src/test/resources/JSON/ReqBody/UsersReqBody.json");
        ReqresAPI.postCreateUser(jsonReq);
    }

    @Then("Status code should be {int} bad request")
    public void statusCodeShouldBeBadRequest(int bad) {
        SerenityRest.then().statusCode(bad);
    }

    @Given("Update user with invalid json and parameter id {int}")
    public void updateUserWithInvalidJsonAndParameterIdId(int id) {
        File jsonReq = new File(reqresAPI.DIR+"/src/test/resources/JSON/ReqBody/UsersReqBody.json");
        ReqresAPI.putUpdateUser(id,jsonReq);
    }


    @Given("Patch Update user with valid json and parameter id {int}")
    public void patchUpdateUserWithValidJsonAndParameterId(int id) {
        File jsonReq = new File(reqresAPI.DIR+"/src/test/resources/JSON/ReqBody/UsersReqBody.json");
        ReqresAPI.patchUpdateUser(id,jsonReq);
    }

    @When("Send request patch update users")
    public void sendRequestPatchUpdateUsers() {
        SerenityRest.when().patch(reqresAPI.PATCH_UPDATE_USER);
    }
}
