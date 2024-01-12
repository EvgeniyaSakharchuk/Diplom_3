package user;
import static config.Config.*;

import config.Config;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class CreateUserRequest extends Client {
    @Step("Create new user in system")
    public ValidatableResponse createUser(User user) {
        return given().log().all()
                .spec(getSpec())
                .body(user)
                .when()
                .post(Config.CREATE_NEW_USER)
                .then();
    }

    @Step("Login user in system with email and password")
    public ValidatableResponse loginUser(AuthData authData) {
        return given().log().all()
                .spec(getSpec())
                .body(authData)
                .when()
                .post(Config.LOGIN_USER)
                .then();
    }

    @Step("Delete user by token")
    public void deleteUser(String accessToken) {
        given().log().all()
                .spec(getSpec())
                .auth().oauth2(accessToken)
                .when()
                .delete(USER_AUTH)
                .then();
    }
}
