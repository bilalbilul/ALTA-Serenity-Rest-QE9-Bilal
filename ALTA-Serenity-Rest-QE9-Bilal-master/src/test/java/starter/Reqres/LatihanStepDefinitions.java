package starter.Reqres;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class LatihanStepDefinitions {
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

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body("page", equalTo(page));
    }

    //scenario 2
    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(reqresAPI.DIR+"/src/test/resources/JSON/ReqBody/UsersReqBody.json");
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
                .body("name",equalTo(name))
                .body("job",equalTo(job));
    }

    @Given("Update user with valid json and parameter id {int}")
    public void updateUserWithValidJson(int id) {
        File jsonReq = new File(reqresAPI.DIR+"/src/test/resources/JSON/ReqBody/UsersReqBody.json");
        ReqresAPI.putUpdateUser(id,jsonReq);
    }

    @When("Send request put update users")
    public void sendRequestPutUpdateUsers() {
            SerenityRest.when().put(reqresAPI.PUT_UPDATE_USER);
    }


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

}
