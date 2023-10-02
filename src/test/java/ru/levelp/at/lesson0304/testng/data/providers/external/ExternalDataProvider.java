package ru.levelp.at.lesson0304.testng.data.providers.external;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.DataProvider;

public class ExternalDataProvider {

    @DataProvider
    public Object[][] positiveDataProvider() {
        return new Object[][] {
            {List.of("sad", "Son", "bag", "SUN", "school", "SSSssss"), "s",
                List.of("ad", "on", "bag", "UN", "chool", "")},
            {List.of("sad", "Son", "bag", "SUN", "school", "SSSssss"), "S",
                List.of("ad", "on", "bag", "UN", "chool", "")}
        };
    }

    @DataProvider(name = "Negative Letter Remover Test Data")
    public Object[][] negativeDataProvider() {
        return new Object[][] {
            {null},
            {Collections.emptyList()}
        };
    }
}
