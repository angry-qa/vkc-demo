package config;

import org.aeonbits.owner.Config;
import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${driver}.properties",
        "classpath:local.properties"})
public interface OwnerConfig extends Config {

    @DefaultValue("chrome")
    @Key("browser.name")
    String getWebDriverBrowser();

    @Key("browser.version")
    String getWebDriverBrowserVersion();

    @DefaultValue("true")
    @Key("web.maximized")
    boolean isMaximized();

    @DefaultValue("false")
    @Key("webdriver.remote")
    boolean isRemote();

    @Key("base.host")
    String getHost();

}
