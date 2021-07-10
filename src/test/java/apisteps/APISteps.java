package apisteps;

import io.qameta.allure.Step;
import models.Root;
import specs.SpecsReqresTest;

public class APISteps {

    @Step("Вызвать метод auth.validateLogin")
    public Root validateLogin(String login) {
        Root data = SpecsReqresTest.request
                .queryParam("login", login)
                .when()
                .post("/auth.validateLogin")
                .then()
                .spec(SpecsReqresTest.responseSpec)
                .statusCode(200)
                .extract().as(Root.class);

        return data;
    }

    @Step("Вызвать метод auth.validatePhone")
    public Root validatePhone(String phone) {
        Root data = SpecsReqresTest.request
                .queryParam("phone", phone)
                .when()
                .post("/auth.validatePhone")
                .then()
                .spec(SpecsReqresTest.responseSpec)
                .statusCode(200)
                .extract().as(Root.class);

        return data;
    }

}
