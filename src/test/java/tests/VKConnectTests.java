package tests;

import io.qameta.allure.*;
import models.TestUsers;
import org.junit.jupiter.api.*;
import pageobjects.ConnectPage;
import testdata.VKCTestUsers;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("UI тесты VKConnect")
@Owner("dtrofimov")
@Tags({@Tag("web"), @Tag("smoke"), @Tag("regress")})
public class VKConnectTests extends TestBase {

    static ConnectPage connectPage = new ConnectPage();
    private final TestUsers user =  new VKCTestUsers().user2;

    @BeforeEach
    public void openVKConnect() { step("Открыть главную страницу VKConnect", () -> open(CONNECT_URL));}

    @Test()
    @DisplayName("Проверка заголовка, ссылки, аватарки на главной")
    @Feature("Личный кабинет VKConnect")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Навигация")
    public void checkHeadersAndAvatars() {
        connectPage
                .checkTitle("Личные данные")
                .checkUrl("account/#/personal")
                .checkHeaderAva();
        connectPage
                .refreshPage()
                .checkUserName(user.getUsername())
                .checkHeaderAva();
    }

    @Test()
    @DisplayName("Навигация по меню")
    @Feature("Личный кабинет VKConnect")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Навигация")
    public void checkMenuNavigation() {
        connectPage
                .mainMenuNavigation("Безопасность и вход", "Безопасность")
                .checkUrl("/account/#/security")
                .mainMenuNavigation("VK Pay: карты и платежи", "VK Pay: карты и платежи")
                .checkUrl("/account/#/vkpay")
                .mainMenuNavigation("Подписки", "Подписки")
                .checkUrl("/account/#/subs")
                .mainMenuNavigation("Сервисы и сайты", "Сервисы и сайты")
                .checkUrl("/account/#/services");
    }

    @Test
    @DisplayName("Проверка ссылок конфиденциальность и условия")
    @Feature("Личный кабинет VKConnect")
    @Severity(SeverityLevel.MINOR)
    @Story("Навигация")
    public void checkPrivacyAndTermsLinks() {
        connectPage.checkPrivacyLink();
        connectPage.checkTermsLink();
    }

    @Test()
    @DisplayName("Смена пола")
    @Feature("Личный кабинет VKConnect")
    @Severity(SeverityLevel.NORMAL)
    @Story("Личные данные")
    public void checkSexChange() {
        String sexBeforeTest = connectPage.getUserSex();
        connectPage
                .changeSexProfile()
                .saveChanges()
                .checkSnackbarText("Изменения сохранены");

        String sexAfterTest = connectPage.getUserSex();

        assertThat(sexBeforeTest).isNotEqualTo(sexAfterTest);
        connectPage.refreshPage();
        assertThat(sexBeforeTest).isNotEqualTo(sexAfterTest);

        connectPage
                .changeSexProfile()
                .saveChanges()
                .checkSnackbarText("Изменения сохранены");

        assertThat(sexBeforeTest).isEqualTo(connectPage.getUserSex());
    }

}
