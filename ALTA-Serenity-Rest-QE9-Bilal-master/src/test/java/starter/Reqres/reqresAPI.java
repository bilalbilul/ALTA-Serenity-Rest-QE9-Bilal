package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utilts.Constant;

import java.io.File;

public class reqresAPI {

    public static String GET_LIST_USER = Constant.BASE_URL+"/api/users?page={page}";
    public static String GET_SINGLE_USERS = Constant.BASE_URL+"/api/users/{id}";
    public static String GET_SINGLE_USERS_NOT_FOUND = Constant.BASE_URL+"/api/users/{page}";
    public static String GET_SINGLE_USERS_UNKNOWN = Constant.BASE_URL+"/api/unknown/{id}";
    public static String GET_DELAYED_RESPONSE = Constant.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    public static String POST_REGISTER_USER = Constant.BASE_URL+"/api/register";
    public static String POST_LOGIN_USER = Constant.BASE_URL+"/api/login";
    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String PATCH_UPDATE_USER = Constant.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL+"/api/users/{id}";
    @Step("Get List User")
    public void getListUser(int page) {
        SerenityRest.given()
                .pathParam(ReqresResponses.PAGE, page);
    }

    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put Update User")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete User")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id);
    }

    @Step("Get Single User")
    public void getSingleUser(int id){
        SerenityRest.given().pathParam(ReqresResponses.ID, id);
    }

    @Step("Post Register Users")
    public void postRegisterUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Login Users")
    public void postLoginUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Patch Update Users")
    public void patchUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("User invalid login")
    public static void postInvalidLogin(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Single Users Unknown")
    public void getSingleUsersUnknown(int id){
        SerenityRest.given().pathParam(ReqresResponses.ID, id);
    }

    @Step("Delayed Response")
    public void getDelayedResponse(int page){
        SerenityRest.given().pathParam(ReqresResponses.PAGE, page);
    }
}
