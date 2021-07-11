package tests;

import annotations.Layer;
import apisteps.APISteps;
import config.OwnerConfig;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import models.Root;
import models.TestUsers;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.*;
import testdata.VKCTestUsers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("API тесты VKConnect")
@Layer("api")
@Tags({@Tag("api"), @Tag("smoke"), @Tag("regress")})
@Owner("dtrofimov")
public class VKConnectAPITests {

    APISteps apiSteps = new APISteps();
    static OwnerConfig ownerConfig = ConfigFactory.create(OwnerConfig.class, System.getProperties());

    private final TestUsers user1 =  new VKCTestUsers().user1;
    private final TestUsers user2 =  new VKCTestUsers().user2;

    @BeforeAll
    static void setup() { RestAssured.baseURI = "https://api." + ownerConfig.getHost(); }

    @Test
    @DisplayName("Проверка валидации телефона")
    @Feature("Методы VKConnect")
    @Severity(SeverityLevel.CRITICAL)
    void validatePhone() {
        Root response = apiSteps.validatePhone(user1.getPhone());
        assertEquals(response.getResponse().getSid().contains("login_"), true,
                "В sid отсутствует подстрока login_");
    }

    @Test
    @DisplayName("Проверка валидации логина с телефоном")
    @Feature("Методы VKConnect")
    @Severity(SeverityLevel.CRITICAL)
    void validateLoginWithPhone() {
        Root response = apiSteps.validateLogin(user1.getLogin());
        assertEquals(response.getResponse().getSid().contains("loginvalidate_"), true,
                "В sid отсутствует подстрока loginvalidate_");
        assertThat(response.getResponse().getPhone()).isEqualTo("7********10");
        assertThat(response.getResponse().getResult()).isEqualTo("need_phone_confirm");
    }

    @Test
    @DisplayName("Проверка валидации логина с почтой")
    @Feature("Методы VKConnect")
    @Severity(SeverityLevel.CRITICAL)
    void validateLoginWithEmail() {
        Root response = apiSteps.validateLogin(user2.getLogin());
        assertEquals(response.getResponse().getSid().isEmpty(), false);
        assertThat(response.getResponse().getResult()).isEqualTo("need_password");
    }

}
