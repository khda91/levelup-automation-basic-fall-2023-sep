package ru.levelp.at.lesson12.design.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RurTaxCalculator implements TaxCalculator {

    private static final BigDecimal STANDARD_TAX_RATE = new BigDecimal("0.13");
    private static final BigDecimal INCREASED_TAX_RATE = new BigDecimal("0.15");
    private static final BigDecimal INCREASED_INCOME = new BigDecimal("5000000");

    @Override
    public BigDecimal calculate(BigDecimal yearlyIncome) {
        if (yearlyIncome.compareTo(INCREASED_INCOME) >= 0) {
            return yearlyIncome.multiply(INCREASED_TAX_RATE).setScale(2, RoundingMode.HALF_UP);
        }

        return yearlyIncome.multiply(STANDARD_TAX_RATE).setScale(2, RoundingMode.HALF_UP);
    }
}
