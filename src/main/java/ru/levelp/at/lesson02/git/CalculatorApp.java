package ru.levelp.at.lesson02.git;

import java.math.BigDecimal;

public class CalculatorApp {

    public static void main(String[] args) {
        var calc = new CalculatorImpl();
        var resDivide1 = calc.divide(BigDecimal.valueOf(1.0), BigDecimal.valueOf(7.0));
        System.out.println("1 / 7 = " + resDivide1);

        var resDivide2 = calc.divide(BigDecimal.valueOf(1), BigDecimal.valueOf(6), 5);
        System.out.println("1 / 6 = " + resDivide2);

        var resAdd1 = calc.add(BigDecimal.valueOf(1), BigDecimal.valueOf(2));
        System.out.println("1 + 2  = " + resAdd1);

        var resSubtract1 = calc.subtract(BigDecimal.valueOf(1), BigDecimal.valueOf(2));
        System.out.println("1 - 2  = " + resSubtract1);
    }
}
