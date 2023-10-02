package ru.levelp.at.lesson0304.testng.data.providers.internal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.LetterRemover;

public class LetterRemoverTest {

    private LetterRemover letterRemover;

    @BeforeMethod
    public void setUp() {
        System.out.println("LetterRemoverTest.setUp");
        letterRemover = new LetterRemover();
    }

    @DataProvider
    public Object[][] positiveDataProvider() {
        return new Object[][] {
            {List.of("sad", "Son", "bag", "SUN", "school", "SSSssss"), "s",
                List.of("ad", "on", "bag", "UN", "chool", "")},
            {List.of("sad", "Son", "bag", "SUN", "school", "SSSssss"), "S",
                List.of("ad", "on", "bag", "UN", "chool", "")}
        };
    }

    @Test(dataProvider = "positiveDataProvider")
    public void testPositive(List<String> input, String letter, List<String> expected) {
        System.out.printf("%s.testPositive letter %s%n", this.getClass().getName(), letter);
        List<String> actual = letterRemover.remove(input, letter);

        assertThat(actual)
            .as("Проверка списка после удаления буквы")
            .isEqualTo(expected);
    }

    @DataProvider(name = "Negative Letter Remover Test Data")
    public Object[][] negativeDataProvider() {
        return new Object[][] {
            {null},
            {Collections.emptyList()}
        };
    }

    @Test(dataProvider = "Negative Letter Remover Test Data")
    public void testNegative(List<String> input) {
        System.out.printf("%s.testNegative with list %s%n", this.getClass().getName(), input);
        assertThatThrownBy(() -> letterRemover.remove(Collections.emptyList(), "s"))
            .as("Проверка выброса исключения")
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("List cannot be null or empty");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("LetterRemoverTest.tearDown");
        letterRemover = null;
    }
}
