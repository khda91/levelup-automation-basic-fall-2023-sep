package ru.levelp.at.taf.trello.dictionary;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public enum BrowserType {

    CHROME("chrome"),
    FIREFOX("FIREFOX"),
    YANDEX("yandex");

    private final String name;

    public static BrowserType getByName(final String name) {
        return Arrays.stream(values())
                     .filter(it -> it.name.equalsIgnoreCase(name))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("нет такого браузера"));
    }
}
