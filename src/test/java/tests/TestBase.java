package tests;

import com.codeborne.selenide.Configuration;
import config.CredentialConfig;
import config.OwnerConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pageobjects.VKLoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelper.*;

public class TestBase {

    static OwnerConfig ownerConfig = ConfigFactory.create(OwnerConfig.class, System.getProperties());
    static CredentialConfig credentialConfig = ConfigFactory.create(CredentialConfig.class);
    static VKLoginPage vkLoginPage = new VKLoginPage();

    static String LOGIN_PAGE_URL = "https://m." + ownerConfig.getHost();
    static String CONNECT_URL = "https://connect." + ownerConfig.getHost();
    static String VK_URL = "https://" + ownerConfig.getHost();

    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.browser = ownerConfig.getWebDriverBrowser();
        Configuration.browserVersion = ownerConfig.getWebDriverBrowserVersion();
        Configuration.startMaximized = ownerConfig.isMaximized();

        if(ownerConfig.isRemote()) {
        Configuration.remote = String.format("https://%s:%s@%s/wd/hub/",
                credentialConfig.remoteWebUser(),
                credentialConfig.remoteWebPassword(),
                credentialConfig.getSelenoidURL());
    }

        open(LOGIN_PAGE_URL);
        vkLoginPage.loginVK(credentialConfig.vkUserLogin(), credentialConfig.vkUserPassword());
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }

    @AfterEach
    void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        if(System.getProperty("video.storage") != null)
            attachVideo();
    }
}