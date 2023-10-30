package ru.levelp.at.lesson12.design.patterns.factory;

import java.util.Arrays;

public enum BrowserType {

    CHROME("chrome"),
    FIREFOX("FIREFOX"),
    YANDEX("yandex");

    private final String name;

    BrowserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BrowserType{"
            + "name='" + name + '\''
            + '}';
    }

    public static BrowserType getByName(final String name) {
        return Arrays.stream(values())
            .filter(it -> it.name.equalsIgnoreCase(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("нет такого браузера"));
    }
}
