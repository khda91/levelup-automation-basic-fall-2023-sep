package ru.levelp.at.lesson0304.testng;

import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.LetterRemover;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LetterRemoverSampleTests {

    @Test(description = "Letter in lower case will be removed from the words in the list in any case")
    public void testLetterInLowerCaseShouldBeRemovedFromList() {
        // Arrange (Given)
        var list = List.of("sad", "Son", "bag", "SUN", "school", "SSSssss");
        var letter = "s";

        // Act (When)
        var actualList = new LetterRemover().remove(list, letter);

        // Assert (Then)
        var expectedList = List.of("ad", "on", "bag", "UN", "chool", "");
        assertThat(actualList)
                .as(String.format("Letter '%s' was removed from the words", letter))
                .isEqualTo(expectedList);
    }

    @Test(description = "Letter in upper case will be removed from the words in the list in any case")
    public void testLetterInUpperCaseShouldBeRemovedFromList() {
        // Arrange (Given)
        var list = List.of("sad", "Son", "bag", "SUN", "school", "SSSssss");
        var letter = "S";

        // Act (When)
        var actualList = new LetterRemover().remove(list, letter);

        // Assert (Then)
        var expectedList = List.of("ad", "on", "bag", "UN", "chool", "");
        assertThat(actualList)
                .as(String.format("Letter '%s' was removed from the words", letter))
                .isEqualTo(expectedList);
    }
}
