package ru.levelp.at.lesson0304.junit.data.provider;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class ExternalDataProvider {

    public static Stream<Arguments> dataProvider() {
        return Stream.of(
            Arguments.of("letter in lower case", List.of("sad", "dad", "ds", "SSssS"), "s",
                List.of("ad", "dad", "d", "")),
            Arguments.of("letter in upper case", List.of("sad", "dad", "ds", "SSssS"), "S",
                List.of("ad", "dad", "d", ""))
        );
    }
}
