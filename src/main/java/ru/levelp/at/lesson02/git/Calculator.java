package ru.levelp.at.lesson02.git;

import java.math.BigDecimal;

public interface Calculator {

    BigDecimal add(BigDecimal a, BigDecimal b);

    BigDecimal add(BigDecimal... a);

    BigDecimal subtract(BigDecimal a, BigDecimal b);

    BigDecimal multiply(BigDecimal a, BigDecimal b);

    BigDecimal multiply(BigDecimal... a);

    BigDecimal divide(BigDecimal a, BigDecimal b);

    BigDecimal divide(BigDecimal a, BigDecimal b, int scale);

    BigDecimal abs(BigDecimal a);

    BigDecimal power(BigDecimal a, int power);
}
