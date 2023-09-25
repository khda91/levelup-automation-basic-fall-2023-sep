package ru.levelp.at.lesson02.git;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorImpl implements Calculator {
    @Override
    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    @Override
    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    @Override
    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    @Override
    public BigDecimal divide(BigDecimal a, BigDecimal b) {
        if (b == null || b.equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("b cannot be null or ZERO");
        }
        return a.divide(b, RoundingMode.HALF_UP);
    }
}
