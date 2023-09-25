package ru.levelp.at.lesson02.git;

import java.math.BigDecimal;

public class CalculatorApp {

    public static void main(String[] args) {
        var calc = new CalculatorImpl();
        var resDivide1 = calc.divide(BigDecimal.valueOf(1.0), BigDecimal.valueOf(7.0));
        System.out.println("1 / 7 = " + resDivide1);
    }
}
