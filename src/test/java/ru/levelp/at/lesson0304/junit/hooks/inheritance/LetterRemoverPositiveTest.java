package ru.levelp.at.lesson0304.junit.hooks.inheritance;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0304.LetterRemover;

@DisplayName("Sample Letter Remover program test")
class LetterRemoverPositiveTest extends LetterRemoverBaseTest {

    @Test
    @DisplayName("Letter in lower case should be removed from list ignoring case")
    void testShouldRemoveLowerCaseLetterFromList() {
        System.out.printf("%s.testShouldRemoveLowerCaseLetterFromList%n", this.getClass().getName());
        // Arrange
        var letter = "s";

        // Act
        var actual = letterRemover.remove(list, letter);

        // Assert
        var expected = List.of("ad", "bad", "mall", "", "outh");
        assertThat(actual)
            .as(String.format("Проверка удаления буквы %s", letter))
            .isEqualTo(expected);
    }

    @Test
    @DisplayName("Letter in upper case should be removed from list ignoring case")
    void testShouldRemoveUpperCaseLetterFromList() {
        System.out.printf("%s.testShouldRemoveUpperCaseLetterFromList%n", this.getClass().getName());
        // Arrange
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
