package ru.levelp.at.lesson0304.testng.hooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.LetterRemover;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BeforeAfterMethodLetterRemoverSampleTests {

    private LetterRemover letterRemover;

    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeAfterMethodLetterRemoverSampleTests.setUp");
        letterRemover = new LetterRemover();
    }

    @Test(description = "Letter in lower case will be removed from the words in the list in any case")
    public void testLetterInLowerCaseShouldBeRemovedFromList() {
        System.out.println("BeforeAfterMethodLetterRemoverSampleTests.testLetterInLowerCaseShouldBeRemovedFromList");
        // Arrange (Given)
        var list = List.of("sad", "Son", "bag", "SUN", "school", "SSSssss");
        var letter = "s";

        // Act (When)
        var actualList = letterRemover.remove(list, letter);

        // Assert (Then)
        var expectedList = List.of("ad", "on", "bag", "UN", "chool", "");
        assertThat(actualList)
                .as(String.format("Letter '%s' was removed from the words", letter))
                .isEqualTo(expectedList);
    }

    @Test(description = "Letter in upper case will be removed from the words in the list in any case")
    public void testLetterInUpperCaseShouldBeRemovedFromList() {
        System.out.println("BeforeAfterMethodLetterRemoverSampleTests.testLetterInUpperCaseShouldBeRemovedFromList");
        // Arrange (Given)
        var list = List.of("sad", "Son", "bag", "SUN", "school", "SSSssss");
        var letter = "S";

        // Act (When)
        var actualList = letterRemover.remove(list, letter);

        // Assert (Then)
        var expectedList = List.of("ad", "on", "bag", "UN", "chool", "");
        assertThat(actualList)
                .as(String.format("Letter '%s' was removed from the words", letter))
                .isEqualTo(expectedList);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("BeforeAfterMethodLetterRemoverSampleTests.tearDown");
        letterRemover = null;
    }
}
