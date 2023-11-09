package ru.levelp.at.taf.trello.configuration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.aeonbits.owner.ConfigCache;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public final class ConfigurationProvider {

    public static UiConfiguration uiConfiguration() {
        return ConfigCache.getOrCreate(UiConfiguration.class);
    }

    public static ApiConfiguration apiConfiguration() {
        return ConfigCache.getOrCreate(ApiConfiguration.class);
    }
}
