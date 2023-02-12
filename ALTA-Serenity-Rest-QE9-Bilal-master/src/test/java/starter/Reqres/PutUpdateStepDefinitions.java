package starter.Reqres;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utilts.Constant;

import java.io.File;

public class PutUpdateStepDefinitions {
    @Steps
    reqresAPI ReqresAPI;

    @Given("Update user with valid json and parameter id {int}")
    public void updateUserWithValidJson(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/UsersReqBody.json");
        ReqresAPI.putUpdateUser(id,jsonReq);
    }

    @When("Send request put update users")
    public void sendRequestPutUpdateUsers() {
        SerenityRest.when().put(reqresAPI.PUT_UPDATE_USER);
    }

    @Given("Update user with invalid json and invalid parameter id {int}")
    public void updateUserWithInvalidJsonAndParameterIdId(int id) {
        File jsonReq = new File(Constant.JSON_REQ_BODY+"/UsersReqBody.json");
        ReqresAPI.putUpdateUser(id,jsonReq);
    }
}
