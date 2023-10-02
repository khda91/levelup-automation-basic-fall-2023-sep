package ru.levelp.at.lesson0304.junit.data.provider;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.levelp.at.lesson0304.junit.hooks.non.statics.LetterRemoverBaseTest;

@DisplayName("Sample Letter Remover program test")
class LetterRemoverNegativeTest extends LetterRemoverBaseTest {

    @ParameterizedTest(name = "{0}")
    @DisplayName("Illegal argument exception should be thrown when list is ")
    @NullAndEmptySource
    void testIllegalArgumentExceptionShouldBeThrownWhenListIs(List<String> input) {
        System.out.printf("%s.testIllegalArgumentExceptionShouldBeThrownWhenListInNull%n", this.getClass().getName());
        // Act
        assertThatThrownBy(() -> letterRemover.remove(input, "s"))
            .as("Проверка ошибки")
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("List cannot be null or empty");
    }

    @ParameterizedTest
    @DisplayName("Illegal argument exception should be thrown when letter is ")
    @NullAndEmptySource
    @ValueSource(strings = {"    ", "\t", "\n", " "})
    void testIllegalArgumentExceptionShouldBeThrownWhenLetterIs(String letter) {
        System.out.printf("%s.testIllegalArgumentExceptionShouldBeThrownWhenLetterIsNull%n", this.getClass().getName());
        // Act
        assertThatThrownBy(() -> letterRemover.remove(list, letter))
            .as("Проверка ошибки")
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("letter cannot be null or empty");
    }
}
