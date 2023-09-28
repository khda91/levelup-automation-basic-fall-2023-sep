package ru.levelp.at.lesson0304.testng.hooks.inheritance;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LetterRemoverVanillaTests extends BaseTest {

    @Test(description = "Letter in lower case will be removed from the words in the list in any case")
    public void testLetterInLowerCaseShouldBeRemovedFromList() {
        System.out.println(this.getClass().getSimpleName() + ".testLetterInLowerCaseShouldBeRemovedFromList");
        // Arrange (Given)
        var letter = "s";

        // Act (When)
        var actualList = letterRemover.removeVanilla(testDataList, letter);

        // Assert (Then)
        var expectedList = List.of("ad", "on", "bag", "UN", "chool", "");
        assertThat(actualList)
                .as(String.format("Letter '%s' was removed from the words", letter))
                .isEqualTo(expectedList);
    }

    @Test(description = "Letter in upper case will be removed from the words in the list in any case")
    public void testLetterInUpperCaseShouldBeRemovedFromList() {
        System.out.println(this.getClass().getSimpleName() + ".testLetterInUpperCaseShouldBeRemovedFromList");
        // Arrange (Given)
        var letter = "S";

        // Act (When)
        var actualList = letterRemover.removeVanilla(testDataList, letter);

        // Assert (Then)
        var expectedList = List.of("ad", "on", "bag", "UN", "chool", "");
        assertThat(actualList)
                .as(String.format("Letter '%s' was removed from the words", letter))
                .isEqualTo(expectedList);
    }
}
