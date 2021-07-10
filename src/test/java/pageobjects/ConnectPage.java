package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import models.TestUsers;
import testdata.VKCTestUsers;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static io.qameta.allure.Allure.step;

public class ConnectPage {

    private final TestUsers user =  new VKCTestUsers().user2;

    @Step("Проверить ссылку Конфиденциальность")
    public void checkPrivacyLink() {
            $x("//a[contains(text(),'Конфиденциальность')]")
                    .shouldBe(Condition.visible);
            $x("//a[contains(text(),'Конфиденциальность')]")
                    .shouldHave(href("https://connect.vk.com/privacy"));
            $x("//a[contains(text(),'Конфиденциальность')]")
                    .shouldHave(attribute("target", "_blank"));
    }

    @Step("Проверить ссылку Условия")
    public void checkTermsLink() {
            $x("//a[contains(text(),'Условия')]")
                    .shouldBe(Condition.visible);
            $x("//a[contains(text(),'Условия')]")
                    .shouldHave(href("https://connect.vk.com/terms"));
            $x("//a[contains(text(),'Условия')]")
                    .shouldHave(attribute("target", "_blank"));
    }

    @Step("Заголовок страницы: {title}")
    public ConnectPage checkTitle(String title) {
            $x("//div[contains(@class,'PanelHeader__content')]/span")
                    .shouldBe(Condition.visible)
                    .shouldHave(text(title));
        return this;
    }

    @Step("Проверить текущий URL")
    public ConnectPage checkUrl(String url) {
            url().contains(url);
        return this;
    }

    @Step("Проверить наличие аватарки")
    public ConnectPage checkHeaderAva() {
            $x("//img[contains(@class, 'Avatar__img')]")
                    .shouldBe(Condition.visible)
                    .getAttribute("src")
                    .matches("https://.*?ava=1");
        return this;
    }

    @Step("Имя и фамилия пользователя: {username}")
    public ConnectPage checkUserName(String username) {
            $x("//h3[contains(@class,'Headline')]")
                    .shouldBe(Condition.visible)
                    .shouldHave(text(username));
        return this;
    }

    @Step("Проверка раздела меню: {item}")
    public ConnectPage mainMenuNavigation(String item, String pageTtitle) {
        step("В меню выбрать пункт: " + item, () -> {
            $x("//*[@id='main']//span[contains(text(), '" + item + "')]")
                    .shouldBe(Condition.visible).click();
        });

        sleep(1000);

        step("Заголовок страницы: " + pageTtitle, () -> {
            $x("//div[contains(@class, 'PanelHeader__content')]//span[contains(text(), '" + pageTtitle + "')]")
                    .shouldBe(Condition.visible);
        });
        return this;
    }

    @Step("Проверить пол")
    public String getUserSex() {
        return $x("//h4[contains(text(), 'Пол')]/..//div[contains(@class,'Select__title')]").getText();
    }

    @Step("Изменить пол в профиле")
    public ConnectPage changeSexProfile() {
            $x("//h4[contains(text(), 'Пол')]/..//div[contains(@class,'Select__title')]").click();

            if (getUserSex().equals("Женский")) {
                $x("//div[contains(@title,'Мужской') and contains(@class,'CustomSelectOption')]")
                        .shouldBe(Condition.visible)
                        .click();
            } else {
                $x("//div[contains(@title,'Женский') and contains(@class,'CustomSelectOption')]")
                        .shouldBe(Condition.visible)
                        .click();
            }
        return this;
    }

    @Step("Нажать кнопку Сохранить")
    public ConnectPage saveChanges() {
            $x("//div[contains(@class,'Button__in')]")
                    .shouldBe(Condition.visible)
                    .click();
        return this;
    }

    @Step("Текст снэкбара: {snackbarText}")
    public ConnectPage checkSnackbarText(String snackbarText) {
            $x("//div[contains(@class, 'Snackbar--desktop')]")
                    .shouldBe(Condition.visible);
            $x("//div[contains(@class, 'Snackbar__content-text')]")
                    .shouldBe(Condition.visible)
                    .getText()
                    .contains(snackbarText);
        return this;
    }

    @Step("Обновить страницу")
    public ConnectPage refreshPage() {
        Selenide.refresh();
        return this;
    }

    @Step("Переключиться на окно: {window}")
    public ConnectPage switchPage(int window) {
        Selenide.switchTo().window(window);
        return this;
    }

    @Step("Закрыть окно VKConnect")
    public ConnectPage closePage() {
        Selenide.closeWindow();
        return this;
    }

    @Step("Проверить доступность быстрой авторизации через VKConnect")
    public ConnectPage chekQuickAuth() {
        step("Иия под аватаркой: " + user.getAbbrname(), () -> {
                    $x("//div[contains(text(), '" + user.getAbbrname() + "')]")
                            .shouldBe(Condition.visible);
        });

        step("Иия на кнопке: Продолжить как " + user.getFirstName(), () -> {
        $x("//button//span[contains(text(), '" + user.getFirstName() + "')]")
                    .shouldBe(Condition.visible);
            $x("//button//span[contains(text(), 'Продолжить как')]")
                    .shouldBe(Condition.visible);
        });
        return this;
    }
}
