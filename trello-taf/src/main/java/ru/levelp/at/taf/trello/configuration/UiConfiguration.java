package ru.levelp.at.taf.trello.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "system:properties",
    "classpath:env/${env}/ui.properties"
})
@LoadPolicy(LoadType.MERGE)
public interface UiConfiguration extends Config {

    @Key("trello.site.url")
    String siteUrl();

    @Key("trello.site.username")
    String username();

    @Key("trello.site.password")
    String password();

    @Key("wed.driver.timeout.millis")
    long timeoutMillis();
}
