package ru.levelp.at.lesson02.git;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class CalculatorImpl implements Calculator {

    private static final int DEFAULT_SCALE = 2;

    @Override
    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    @Override
    public BigDecimal add(BigDecimal... a) {
        return Arrays.stream(a).reduce(BigDecimal.ZERO, BigDecimal::add);
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
    public BigDecimal multiply(BigDecimal... a) {
        return Arrays.stream(a).reduce(BigDecimal.ONE, BigDecimal::multiply);
    }

    @Override
    public BigDecimal divide(BigDecimal a, BigDecimal b) {
        return this.divide(a, b, DEFAULT_SCALE);
    }

    @Override
    public BigDecimal divide(BigDecimal a, BigDecimal b, int scale) {
        if (b == null || b.equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("b cannot be null or ZERO");
        }
        return a.divide(b, scale, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal abs(BigDecimal a) {
        return a.abs();
    }
}
