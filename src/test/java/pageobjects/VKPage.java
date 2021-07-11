package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class VKPage {

    @Step("Перейти в раздел {item}")
    public VKPage rightMenuNavigateTo(String item, String pageTtitle) {
        step("В правом меню выбрать раздел " + item, () -> {
            $x("//*[@id='side_bar_inner']//span[contains(text(), '" + item + "')]")
                    .shouldBe(Condition.visible).click();
            sleep(2000);
        });
        step("Заголовок страницы: {pageTtitle}", () -> {
            assertThat(Selenide.title()).isEqualTo(pageTtitle);
        });
        return this;
    }

    @Step("Имя и фамилия пользователя: {username}")
    public VKPage checkUserName(String username) {
            $x("//*[@id='page_info_wrap']//h1[contains(@class, 'page_name')]")
                    .shouldBe(Condition.visible)
                    .shouldHave(text(username));
        return this;
    }

}
