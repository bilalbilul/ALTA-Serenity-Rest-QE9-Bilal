package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class reqresAPI {

    public static final String DIR = System.getProperty("user.dir");

    private static String BASE_URL = "https://reqres.in";

    public static String GET_LIST_USER = BASE_URL+"/api/users?page={page}";
    public static String GET_SINGLE_USERS = BASE_URL+"/api/users/{id}";
    public static String POST_CREATE_USER = BASE_URL+"/api/users";
    public static String POST_REGISTER_USER = BASE_URL+"/api/register";
    public static String POST_LOGIN_USER = BASE_URL+"/api/login";
    public static String PUT_UPDATE_USER = BASE_URL+"/api/users/{id}";
    public static String PATCH_UPDATE_USER = BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = BASE_URL+"/api/users/{id}";
    @Step("Get List User")
    public void getListUser(int page) {
        SerenityRest.given()
                .pathParam("page", page);
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
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete User")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get Single User")
    public void getSingleUser(int id){
        SerenityRest.given().pathParam("id", id);
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
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}
