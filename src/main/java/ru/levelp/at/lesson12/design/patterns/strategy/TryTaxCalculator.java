package ru.levelp.at.lesson12.design.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TryTaxCalculator implements TaxCalculator {

    private static final BigDecimal LOWER_TAX_RATE = new BigDecimal("0.15");
    private static final BigDecimal AVERAGE_TAX_RATE = new BigDecimal("0.20");
    private static final BigDecimal HIGH_AVERAGE_TAX_RATE = new BigDecimal("0.27");
    private static final BigDecimal MAX_TAX_RATE = new BigDecimal("0.35");
    private static final BigDecimal LOWER_INCOME = new BigDecimal("8800");
    private static final BigDecimal AVERAGE_INCOME = new BigDecimal("22000");
    private static final BigDecimal HIGH_INCOME = new BigDecimal("50000");

    @Override
    public BigDecimal calculate(BigDecimal yearlyIncome) {
        if (yearlyIncome.compareTo(LOWER_INCOME) <= 0) {
            return yearlyIncome.multiply(LOWER_TAX_RATE).setScale(2, RoundingMode.HALF_UP);
        }

        if (yearlyIncome.compareTo(LOWER_INCOME) > 0 && yearlyIncome.compareTo(AVERAGE_INCOME) <= 0) {
            return yearlyIncome.multiply(AVERAGE_TAX_RATE).setScale(2, RoundingMode.HALF_UP);
        }

        if (yearlyIncome.compareTo(AVERAGE_INCOME) > 0 && yearlyIncome.compareTo(HIGH_INCOME) <= 0) {
            return yearlyIncome.multiply(HIGH_AVERAGE_TAX_RATE).setScale(2, RoundingMode.HALF_UP);
        }

        return yearlyIncome.multiply(MAX_TAX_RATE).setScale(2, RoundingMode.HALF_UP);
    }
}
