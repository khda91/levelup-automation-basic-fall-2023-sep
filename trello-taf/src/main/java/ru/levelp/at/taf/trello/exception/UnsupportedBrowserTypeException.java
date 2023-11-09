package ru.levelp.at.taf.trello.exception;

import java.util.Arrays;
import java.util.stream.Collectors;
import ru.levelp.at.taf.trello.dictionary.BrowserType;

public class UnsupportedBrowserTypeException extends RuntimeException {

    public UnsupportedBrowserTypeException(BrowserType type) {
        super(String.format("Тип %s браузера не поддерживается. Поддерживаемые браузеры: %s", type.getName(),
            Arrays.stream(BrowserType.values())
                  .map(BrowserType::getName)
                  .collect(Collectors.joining(","))));
    }
}
