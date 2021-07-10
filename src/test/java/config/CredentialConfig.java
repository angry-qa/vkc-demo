package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/Users/dm.trofimov/credential.properties",
        "classpath:credential.properties"})
public interface CredentialConfig extends Config {

    @Key("selenoid.domain")
    String getSelenoidURL();

    @Key("selenoid.user")
    String remoteWebUser();

    @Key("selenoid.password")
    String remoteWebPassword();

    @Key("vk.user.login")
    String vkUserLogin();

    @Key("vk.user.password")
    String vkUserPassword();

}
