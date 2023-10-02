package ru.levelp.at.lesson0304.testng.hooks;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.LetterRemover;

public class BeforeAfterTestLetterRemoverSampleTest {

    private LetterRemover letterRemover;
    private List<String> testDataList;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeAfterTestLetterRemoverSampleTests.beforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeAfterTestLetterRemoverSampleTests.beforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeAfterTestLetterRemoverSampleTests.beforeClass");
        testDataList = List.of("sad", "Son", "bag", "SUN", "school", "SSSssss");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("BeforeAfterTestLetterRemoverSampleTests.setUp");
        letterRemover = new LetterRemover();
    }

    @Test(description = "Letter in lower case will be removed from the words in the list in any case")
    public void testLetterInLowerCaseShouldBeRemovedFromList() {
        System.out.println("BeforeAfterTestLetterRemoverSampleTests.testLetterInLowerCaseShouldBeRemovedFromList");
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
        System.out.println("BeforeAfterTestLetterRemoverSampleTests.testLetterInUpperCaseShouldBeRemovedFromList");
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
        System.out.println("BeforeAfterTestLetterRemoverSampleTests.tearDown");
        letterRemover = null;
    }

    @AfterClass
    public void afterClass() {
        System.out.println("BeforeAfterTestLetterRemoverSampleTests.afterClass");
        testDataList = null;
    }

    @AfterTest
    public void afterTest() {
        System.out.println("BeforeAfterTestLetterRemoverSampleTests.afterTest");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("BeforeAfterTestLetterRemoverSampleTests.afterSuite");
    }
}
