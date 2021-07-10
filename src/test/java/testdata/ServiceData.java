package testdata;

import models.Service;

public class ServiceData {

    public final Service VKCOMBO = Service.builder()
            .url("vkcombo.ru")
            .xpath("//div[contains(@class, 'header__desktopMenu')]//span[contains(text(), 'Войти')]")
            .build();

    public final Service VKRABOTA = Service.builder()
            .url("vkrabota.ru")
            .xpath("//button[@data-test-id='LoginButton']")
            .build();

    public final Service MAILRU = Service.builder()
            .url("mail.ru")
            .xpath("//*[@id='mailbox']//button[contains(@class, 'resplash-btn_vk-connect')]")
            .build();

    public final Service OK = Service.builder()
            .url("ok.ru")
            .xpath("//*[@id='vk_connect_button']")
            .build();

}

