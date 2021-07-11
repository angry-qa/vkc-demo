package tests;

import annotations.Layer;
import annotations.Manual;
import io.qameta.allure.*;
import models.TestUsers;
import org.junit.jupiter.api.*;
import pageobjects.VKPage;
import testdata.VKCTestUsers;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@DisplayName("Auth тесты")
@Layer("ui")
@Tag("web")
@Owner("dtrofimov")
public class VKLoginTests extends TestBase {

    static VKPage vkPage = new VKPage();
    private final TestUsers user =  new VKCTestUsers().user2;

    @BeforeEach
    public void openVK() {
        step("Открыть главную страницу ВКонтакте", () -> open(VK_URL));
    }

    @Test
    @DisplayName("Проверка, что пользователь залогинен")
    @Feature("Авторизация ВКонтакте")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Авторизация")
    void checkUserLogin() {
        vkLoginPage.checkUserLogin(user.getFirstName());
    }

    @Test
    @DisplayName("Проверка навигации по разделам залогиненого пользователя")
    @Feature("Авторизация ВКонтакте")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Базовый функционал авторизированного")
    void menuNavigationTest() {
        vkPage
                .rightMenuNavigateTo("Моя страница", user.getUsername())
                .rightMenuNavigateTo("Новости", "Новости")
                .rightMenuNavigateTo("Друзья", "Поиск друзей");
    }

    @Test
    @DisplayName("Проверка ФИО залогиненого пользователя")
    @Feature("Авторизация ВКонтакте")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Авторизация")
    void checkUserName() {
        vkPage
                .rightMenuNavigateTo("Моя страница", user.getUsername())
                .checkUserName(user.getUsername());
    }

    @Test
    @Manual
    @Issue("YYY-1")
    @DisplayName("Разлогин")
    @Feature("Авторизация ВКонтакте")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Авторизация")
    void checkSignOut() {
        step("Залогиниться");
        step("Разлогиниться");
    }

}
