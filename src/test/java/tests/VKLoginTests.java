package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import models.TestUsers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.VKPage;
import testdata.VKCTestUsers;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@DisplayName("Auth тесты")
public class VKLoginTests extends TestBase {

    static VKPage vkPage = new VKPage();
    private final TestUsers user =  new VKCTestUsers().user2;

    @BeforeEach
    public void openVK() {
        step("Открыть главную страницу ВКонтакте", () -> open(VK_URL));
    }

    @Test
    @DisplayName("Проверка, что пользователь залогинен")
    @Feature("ВКонтакте")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Авторизация")
    void checkUserLogin() {
        vkLoginPage.checkUserLogin(user.getFirstName());
    }

    @Test
    @DisplayName("Проверка навигации для залогиненого пользователя")
    @Feature("ВКонтакте")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Базовый функционал")
    void menuNavigationTest() {
        vkPage
                .rightMenuNavigateTo("Моя страница", user.getUsername())
                .rightMenuNavigateTo("Новости", "Новости")
                .rightMenuNavigateTo("Друзья", "Поиск друзей");
    }

    @Test
    @DisplayName("Проверка ФИО залогиненого пользователя")
    @Feature("ВКонтакте")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Авторизация")
    void checkUserName() {
        vkPage
                .rightMenuNavigateTo("Моя страница", user.getUsername())
                .checkUserName(user.getUsername());
    }

}
