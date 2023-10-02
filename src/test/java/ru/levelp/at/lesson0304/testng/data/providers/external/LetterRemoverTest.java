package ru.levelp.at.lesson0304.testng.data.providers.external;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.LetterRemover;

public class LetterRemoverTest {

    private LetterRemover letterRemover;

    @BeforeMethod
    public void setUp() {
        System.out.println("LetterRemoverTest.setUp");
        letterRemover = new LetterRemover();
    }

    @Test(dataProvider = "positiveDataProvider", dataProviderClass = ExternalDataProvider.class)
    public void testPositive(List<String> input, String letter, List<String> expected) {
        System.out.printf("%s.testPositive letter %s%n", this.getClass().getName(), letter);
        List<String> actual = letterRemover.remove(input, letter);

        assertThat(actual)
            .as("Проверка списка после удаления буквы")
            .isEqualTo(expected);
    }

    @Test(dataProvider = "Negative Letter Remover Test Data", dataProviderClass = ExternalDataProvider.class)
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
