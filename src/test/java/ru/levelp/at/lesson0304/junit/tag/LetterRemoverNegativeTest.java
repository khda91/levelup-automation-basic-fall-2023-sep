package ru.levelp.at.lesson0304.junit.tag;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0304.junit.tag.annotations.EmptyCheckTag;
import ru.levelp.at.lesson0304.junit.tag.annotations.NullCheckTag;

@DisplayName("Sample Letter Remover program test")
@Tags({@Tag(MethodTagType.LETTER_REMOVER_STREAM_TAG), @Tag(GroupTagType.NEGATIVE_TAG)})
class LetterRemoverNegativeTest extends LetterRemoverBaseTest {

    @Test
    @DisplayName("Illegal argument exception should be thrown when list is null")
    @NullCheckTag
    void testIllegalArgumentExceptionShouldBeThrownWhenListIsNull() {
        System.out.printf("%s.testIllegalArgumentExceptionShouldBeThrownWhenListInNull%n", this.getClass().getName());
        // Act
        assertThatThrownBy(() -> letterRemover.remove(null, "s"))
            .as("Проверка ошибки")
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("List cannot be null or empty");
    }

    @Test
    @DisplayName("Illegal argument exception should be thrown when list is empty")
    @EmptyCheckTag
    void testIllegalArgumentExceptionShouldBeThrownWhenListIsEmpty() {
        System.out.printf("%s.testIllegalArgumentExceptionShouldBeThrownWhenListIsEmpty%n", this.getClass().getName());
        // Act
        assertThatThrownBy(() -> letterRemover.remove(Collections.emptyList(), "s"))
            .as("Проверка ошибки")
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("List cannot be null or empty");
    }

    @Test
    @DisplayName("Illegal argument exception should be thrown when letter is null")
    @NullCheckTag
    void testIllegalArgumentExceptionShouldBeThrownWhenLetterIsNull() {
        System.out.printf("%s.testIllegalArgumentExceptionShouldBeThrownWhenLetterIsNull%n", this.getClass().getName());
        // Act
        assertThatThrownBy(() -> letterRemover.remove(list, null))
            .as("Проверка ошибки")
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("letter cannot be null or empty");
    }

    @Test
    @DisplayName("Illegal argument exception should be thrown when letter is empty")
    @EmptyCheckTag
    void testIllegalArgumentExceptionShouldBeThrownWhenLetterIsEmpty() {
        System.out.printf("%s.testIllegalArgumentExceptionShouldBeThrownWhenLetterIsEmpty%n",
            this.getClass().getName());
        // Act
        assertThatThrownBy(() -> letterRemover.remove(list, ""))
            .as("Проверка ошибки")
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("letter cannot be null or empty");
    }

    @Test
    @DisplayName("Illegal argument exception should be thrown when letter is blank")
    @EmptyCheckTag
    void testIllegalArgumentExceptionShouldBeThrownWhenLetterIsBlank() {
        System.out.printf("%s.testIllegalArgumentExceptionShouldBeThrownWhenLetterIsBlank%n",
            this.getClass().getName());
        // Act
        assertThatThrownBy(() -> letterRemover.remove(list, "     "))
            .as("Проверка ошибки")
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("letter cannot be null or empty");
    }
}
