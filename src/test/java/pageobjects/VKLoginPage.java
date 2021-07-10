package pageobjects;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.step;

public class VKLoginPage extends TestBase {

    @Step("Залогиниться через десктопную версию сайта")
    public void loginVKDesktop(String login, String pass) {
        step("Login", () -> {
            $x("//*[@id='index_email']").shouldBe(Condition.visible).setValue(login);
            $x("//*[@id='index_pass']").shouldBe(Condition.visible).setValue(pass);
            $x("//*[@id='index_login_button']").shouldBe(Condition.visible).click();
        });
    }

    @Step("Залогиниться")
    public void loginVK(String login, String pass) {
            $x("//*[@name='email']").shouldBe(Condition.visible).setValue(login);
            $x("//*[@name='pass']").shouldBe(Condition.visible).setValue(pass);
            $x("//*[@id='mcont']/div[1]/div[2]/div/div/form/div[1]/input").shouldBe(Condition.visible).click();
    }

    @Step("В шапке имя пользователя: {name}")
    public void checkUserLogin(String name) {
            $(".TopNavBtn__profileName").shouldBe(Condition.visible).shouldHave(text(name));
    }

}
