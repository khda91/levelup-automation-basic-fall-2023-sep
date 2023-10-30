package ru.levelp.at.lesson12.design.patterns.factory.exceptions;

import java.util.Arrays;
import java.util.stream.Collectors;
import ru.levelp.at.lesson12.design.patterns.factory.BrowserType;

public class UnsupportedBrowserTypeException extends RuntimeException {

    public UnsupportedBrowserTypeException(BrowserType type) {
        super(String.format("Тип %s браузера не поддерживается. Поддерживаемые браузеры: %s", type.getName(),
            Arrays.stream(BrowserType.values())
                  .map(BrowserType::getName)
                  .collect(Collectors.joining(","))));
    }
}
