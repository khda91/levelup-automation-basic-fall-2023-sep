package ru.levelp.at.lesson0304.testng.hooks;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.LetterRemover;

public class BeforeAfterSuiteLetterRemoverSampleTest {

    private LetterRemover letterRemover;
    private List<String> testDataList;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeAfterSuiteLetterRemoverSampleTests.beforeSuite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeAfterSuiteLetterRemoverSampleTests.beforeClass");
        testDataList = List.of("sad", "Son", "bag", "SUN", "school", "SSSssss");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeAfterSuiteLetterRemoverSampleTests.setUp");
        letterRemover = new LetterRemover();
    }

    @Test(description = "Letter in lower case will be removed from the words in the list in any case")
    public void testLetterInLowerCaseShouldBeRemovedFromList() {
        System.out.println("BeforeAfterSuiteLetterRemoverSampleTests.testLetterInLowerCaseShouldBeRemovedFromList");
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
        System.out.println("BeforeAfterSuiteLetterRemoverSampleTests.testLetterInUpperCaseShouldBeRemovedFromList");
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
        System.out.println("BeforeAfterSuiteLetterRemoverSampleTests.tearDown");
        letterRemover = null;
    }

    @AfterClass
    public void afterClass() {
        System.out.println("BeforeAfterSuiteLetterRemoverSampleTests.afterClass");
        testDataList = null;
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("BeforeAfterSuiteLetterRemoverSampleTests.afterSuite");
    }
}
