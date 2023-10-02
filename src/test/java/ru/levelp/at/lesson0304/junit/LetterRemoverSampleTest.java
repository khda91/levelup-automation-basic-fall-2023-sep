package ru.levelp.at.lesson0304.junit;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0304.LetterRemover;

@DisplayName("Sample Letter Remover program test")
class LetterRemoverSampleTest {

    @Test
    @DisplayName("Letter in lower case should be removed from list ignoring case")
    void testShouldRemoveLowerCaseLetterFromList() {
        // Arrange
        // List<String> list = List.of("sad", "bad", "small", "ssSSS", "South"); ==
        var list = List.of("sad", "bad", "small", "ssSSS", "South");
        var letter = "s"; // == String letter = "s";

        // Act
        var actual = new LetterRemover().remove(list, letter);

        // Assert
        var expected = List.of("1ad", "bad", "mall", "", "outh");
        assertThat(actual)
            .as(String.format("Проверка удаления буквы %s", letter))
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Letter in upper case should be removed from list ignoring case")
    void testShouldRemoveUpperCaseLetterFromList() {
        // Arrange
        var list = List.of("sad", "bad", "small", "ssSSS", "South");
        var letter = "S";

        // Act
        var actual = new LetterRemover().remove(list, letter);

        // Assert
        var expected = List.of("ad", "bad", "mall", "", "outh");
        assertThat(actual)
            .as(String.format("Проверка удаления буквы %s", letter))
            .isEqualTo(expected);
    }
}
