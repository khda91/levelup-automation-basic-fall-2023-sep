package ru.levelp.at.taf.trello.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "system:properties",
    "classpath:env/${env}/api.properties"
})
@LoadPolicy(LoadType.MERGE)
public interface ApiConfiguration extends Config {

    @Key("trello.api.site.url")
    String apiSiteUrl();

    @Key("trello.api.site.api.key")
    String key();

    @Key("trello.api.site.api.token")
    String token();
}
