package ru.levelp.at.lesson12.design.patterns.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StrategyExampleTest {

    static Stream<Arguments> rurDataProvider() {
        return Stream.of(
            Arguments.of(new BigDecimal("1000000"), new BigDecimal("130000.00")),
            Arguments.of(new BigDecimal("6000000"), new BigDecimal("900000.00"))
        );
    }

    static Stream<Arguments> tryDataProvider() {
        return Stream.of(
            Arguments.of(new BigDecimal("8000"), new BigDecimal("1200.00")),
            Arguments.of(new BigDecimal("10000"), new BigDecimal("2000.00")),
            Arguments.of(new BigDecimal("30000"), new BigDecimal("8100.00")),
            Arguments.of(new BigDecimal("60000"), new BigDecimal("21000.00"))
        );
    }

    @ParameterizedTest
    @MethodSource("rurDataProvider")
    void rurTaxTest(BigDecimal income, BigDecimal expected) {
        var calculator = new TaxCalculatorProviderImpl(new RurTaxCalculator());
        var actual = calculator.calculate(income);

        assertThat(actual)
            .as("Проверка налоговых расчётов")
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("tryDataProvider")
    void tryTaxTest(BigDecimal income, BigDecimal expected) {
        var calculator = new TaxCalculatorProviderImpl(new TryTaxCalculator());
        var actual = calculator.calculate(income);

        assertThat(actual)
            .as("Проверка налоговых расчётов")
            .isEqualTo(expected);
    }
}
