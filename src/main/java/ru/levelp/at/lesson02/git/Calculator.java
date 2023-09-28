package ru.levelp.at.lesson02.git;

import java.math.BigDecimal;

public interface Calculator {

    BigDecimal add(BigDecimal a, BigDecimal b);

    BigDecimal add(BigDecimal... a);

    BigDecimal subtract(BigDecimal a, BigDecimal b);

    BigDecimal multiply(BigDecimal a, BigDecimal b);

    BigDecimal multiply(BigDecimal... a);

    BigDecimal divide(BigDecimal a, BigDecimal b);

    /**
     * Divide a to b with scale.
     *
     * @param a - number 1
     * @param b - number 2
     * @param scale - amount signs after delimiter
     * @return a / b with scale
     */
    BigDecimal divide(BigDecimal a, BigDecimal b, int scale);

    BigDecimal abs(BigDecimal a);

    /**
     * Calculate value of number in power.
     *
     * @param a - value
     * @param power - power
     * @return value in power
     */
    BigDecimal power(BigDecimal a, int power);
}
