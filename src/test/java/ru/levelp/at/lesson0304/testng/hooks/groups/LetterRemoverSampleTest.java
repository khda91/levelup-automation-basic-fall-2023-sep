package ru.levelp.at.lesson0304.testng.hooks.groups;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.LetterRemover;

public class LetterRemoverSampleTest {

    private LetterRemover letterRemover;

    @BeforeGroups(groups = TestGroupName.POSITIVE_GROUP)
    public void beforeNegativeGroup() {
        System.out.println("LetterRemoverSampleTest.beforeNegativeGroup");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println("LetterRemoverSampleTest.setUp");
        letterRemover = new LetterRemover();
    }

    @Test(description = "Letter in lower case will be removed from the words in the list in any case",
          groups = TestGroupName.POSITIVE_GROUP)
    public void testLetterInLowerCaseShouldBeRemovedFromList() {
        System.out.println("LetterRemoverSampleTest.testLetterInLowerCaseShouldBeRemovedFromList");
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

    // ОБЪЯВЛЯТЬ ГРУППЫ КАК ЛИТЕРАЛЫ ОЧЕНЬ И ОЧЕНЬ ПЛОХО
    //    @Test(description = "Letter in upper case will be removed from the words in the list in any case",
    //          groups = "positive")
    // -------
    // ТАК ПРАВИЛЬНО ОБЪЯВЛЯТЬ ГРУППЫ
    @Test(description = "Letter in upper case will be removed from the words in the list in any case",
          groups = TestGroupName.POSITIVE_GROUP)
    public void testLetterInUpperCaseShouldBeRemovedFromList() {
        System.out.println("LetterRemoverSampleTest.testLetterInUpperCaseShouldBeRemovedFromList");
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

    @AfterMethod(groups = TestGroupName.POSITIVE_GROUP)
    public void tearDown() {
        System.out.println("LetterRemoverSampleTest.tearDown");
        letterRemover = null;
    }

    @AfterGroups(TestGroupName.POSITIVE_GROUP)
    public void afterNegativeGroup() {
        System.out.println("LetterRemoverSampleTest.afterNegativeGroup");
    }
}
