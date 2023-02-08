package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class reqresAPI {

    public static final String DIR = System.getProperty("user.dir");

    private static String BASE_URL = "https://reqres.in";

    public static String GET_LIST_USER = BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = BASE_URL+"/api/users";
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
}
