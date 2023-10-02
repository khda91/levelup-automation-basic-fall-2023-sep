package ru.levelp.at.lesson0304.junit.hooks.non.statics;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Sample Letter Remover program test")
class LetterRemoverNegativeTest extends LetterRemoverBaseTest {

    @Test
    @DisplayName("Illegal argument exception should be thrown when list is null")
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
