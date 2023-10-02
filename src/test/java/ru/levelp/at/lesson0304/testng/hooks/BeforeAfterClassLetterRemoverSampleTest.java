package ru.levelp.at.lesson0304.testng.hooks;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.LetterRemover;

public class BeforeAfterClassLetterRemoverSampleTest {

    private LetterRemover letterRemover;
    private List<String> testDataList;

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeAfterClassLetterRemoverSampleTests.beforeClass");
        testDataList = List.of("sad", "Son", "bag", "SUN", "school", "SSSssss");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeAfterClassLetterRemoverSampleTests.setUp");
        letterRemover = new LetterRemover();
    }

    @Test(description = "Letter in lower case will be removed from the words in the list in any case")
    public void testLetterInLowerCaseShouldBeRemovedFromList() {
        System.out.println("BeforeAfterClassLetterRemoverSampleTests.testLetterInLowerCaseShouldBeRemovedFromList");
        // Arrange (Given)
        var letter = "s";

        // Act (When)
        var actualList = letterRemover.remove(testDataList, letter);

        // Assert (Then)
        var expectedList = List.of("ad", "on", "bag", "UN", "chool", "");
        assertThat(actualList)
            .as(String.format("Letter '%s' was removed from the words", letter))
            .isEqualTo(expectedList);
    }

    @Test(description = "Letter in upper case will be removed from the words in the list in any case")
    public void testLetterInUpperCaseShouldBeRemovedFromList() {
        System.out.println("BeforeAfterClassLetterRemoverSampleTests.testLetterInUpperCaseShouldBeRemovedFromList");
        // Arrange (Given)
        var letter = "S";

        // Act (When)
        var actualList = letterRemover.remove(testDataList, letter);

        // Assert (Then)
        var expectedList = List.of("ad", "on", "bag", "UN", "chool", "");
        assertThat(actualList)
            .as(String.format("Letter '%s' was removed from the words", letter))
            .isEqualTo(expectedList);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("BeforeAfterClassLetterRemoverSampleTests.tearDown");
        letterRemover = null;
    }

    @AfterClass
    public void afterClass() {
        System.out.println("BeforeAfterClassLetterRemoverSampleTests.afterClass");
        testDataList = null;
    }
}
