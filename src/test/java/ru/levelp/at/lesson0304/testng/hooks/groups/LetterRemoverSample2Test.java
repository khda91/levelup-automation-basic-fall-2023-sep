package ru.levelp.at.lesson0304.testng.hooks.groups;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.LetterRemover;

public class LetterRemoverSample2Test {

    private LetterRemover letterRemover;
    private List<String> list = List.of("sad", "Son", "bag", "SUN", "school", "SSSssss");

    @BeforeGroups(groups = TestGroupName.NEGATIVE_GROUP)
    public void beforeNegativeGroup() {
        System.out.println("LetterRemoverSample2Test.beforeNegativeGroup");
    }

    @BeforeMethod(groups = TestGroupName.NEGATIVE_GROUP)
    public void setUp() {
        System.out.println("LetterRemoverSample2Test.setUp");
        letterRemover = new LetterRemover();
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
          expectedExceptionsMessageRegExp = "List cannot be null or empty",
          groups = TestGroupName.NEGATIVE_GROUP)
    public void testShouldThrowExceptionWhenListIsNull() {
        System.out.println("LetterRemoverSample2Test.testShouldThrowExceptionWhenListIsNull");
        letterRemover.remove(null, "s");
    }

    @Test(groups = TestGroupName.NEGATIVE_GROUP)
    public void testShouldThrowExceptionWhenListIsEmpty() {
        System.out.println("LetterRemoverSample2Test.testShouldThrowExceptionWhenListIsEmpty");
        assertThatThrownBy(() -> letterRemover.remove(Collections.emptyList(), "s"))
            .as("Проверка выброса исключения")
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("List cannot be null or empty");
    }

    @Test(groups = TestGroupName.NEGATIVE_GROUP)
    public void testShouldThrowExceptionWhenLetterIsNull() {
        System.out.println("LetterRemoverSample2Test.testShouldThrowExceptionWhenLetterIsNull");
        assertThatThrownBy(() -> letterRemover.remove(list, null))
            .as("Проверка выброса исключения")
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("letter cannot be null or empty");
    }

    @Test(groups = TestGroupName.NEGATIVE_GROUP)
    public void testShouldThrowExceptionWhenLetterIsEmpty() {
        System.out.println("LetterRemoverSample2Test.testShouldThrowExceptionWhenLetterIsEmpty");
        assertThatThrownBy(() -> letterRemover.remove(list, ""))
            .as("Проверка выброса исключения")
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("letter cannot be null or empty");
    }

    @Test(groups = TestGroupName.NEGATIVE_GROUP)
    public void testShouldThrowExceptionWhenLetterIsBlank() {
        System.out.println("LetterRemoverSample2Test.testShouldThrowExceptionWhenLetterIsBlank");
        assertThatThrownBy(() -> letterRemover.remove(list, "    "))
            .as("Проверка выброса исключения")
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("letter cannot be null or empty");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("LetterRemoverSample2Test.tearDown");
        letterRemover = null;
    }

    @AfterGroups(TestGroupName.NEGATIVE_GROUP)
    public void afterNegativeGroup() {
        System.out.println("LetterRemoverSample2Test.afterNegativeGroup");
    }
}
