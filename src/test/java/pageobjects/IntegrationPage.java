package pageobjects;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class IntegrationPage {

    @Step("Перейти на: {url}")
    public IntegrationPage openIntegrationServicePage(String url) {
        open("https://" + url);
        return this;
    }

    @Step("Нажать кнопку логина VKConnect")
    public IntegrationPage clickVKCButton(String xpath) {
        $x(xpath)
                .shouldBe(Condition.visible)
                .click();
        sleep(2000);
        return this;
    }

}
