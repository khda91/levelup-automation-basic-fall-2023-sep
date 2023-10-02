package ru.levelp.at.lesson0304.junit.tag;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0304.LetterRemover;

@DisplayName("Sample Letter Remover program test")
// @Tag("letter_remover_stream") ТАК ДЕЛАТЬ НЕ НАДО
@Tag(MethodTagType.LETTER_REMOVER_STREAM_TAG)
class LetterRemoverPositiveTest extends LetterRemoverBaseTest {

    @Test
    @DisplayName("Letter in lower case should be removed from list ignoring case")
    // @Tag("positive")
    @Tag(GroupTagType.POSITIVE_TAG)
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
    @Tag(GroupTagType.POSITIVE_TAG)
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
