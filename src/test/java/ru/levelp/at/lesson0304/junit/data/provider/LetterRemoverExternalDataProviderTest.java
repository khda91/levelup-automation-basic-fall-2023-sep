package ru.levelp.at.lesson0304.junit.data.provider;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.levelp.at.lesson0304.LetterRemover;

@DisplayName("Sample Letter Remover program test")
class LetterRemoverExternalDataProviderTest {

    @ParameterizedTest(name = "{0}")
    @DisplayName("Letter should be removed from list ignoring case - ")
    @MethodSource("ru.levelp.at.lesson0304.junit.data.provider.ExternalDataProvider#dataProvider")
    void testShouldRemoveLetterFromList(String testCase, List<String> input, String letter, List<String> expected) {
        // Act
        var actual = new LetterRemover().remove(input, letter);

        // Assert
        assertThat(actual)
            .as(String.format("Проверка удаления буквы %s", letter))
            .isEqualTo(expected);
    }
}
