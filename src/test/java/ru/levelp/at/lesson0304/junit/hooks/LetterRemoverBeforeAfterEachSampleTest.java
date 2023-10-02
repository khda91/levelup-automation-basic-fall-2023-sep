package ru.levelp.at.lesson0304.junit.hooks;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0304.LetterRemover;

@DisplayName("Sample Letter Remover program test")
class LetterRemoverBeforeAfterEachSampleTest {

    private LetterRemover letterRemover;

    @BeforeEach
    void setUp() {
        System.out.printf("%s.setUp%n", this.getClass().getName());
        letterRemover = new LetterRemover();
    }

    @Test
    @DisplayName("Letter in lower case should be removed from list ignoring case")
    void testShouldRemoveLowerCaseLetterFromList() {
        System.out.printf("%s.testShouldRemoveLowerCaseLetterFromList%n", this.getClass().getName());
        // Arrange
        var list = List.of("sad", "bad", "small", "ssSSS", "South");
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

    @AfterEach
    void tearDown() {
        System.out.printf("%s.tearDown%n", this.getClass().getName());
        letterRemover = null;
    }
}
