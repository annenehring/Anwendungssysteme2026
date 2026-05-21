package org.example.JUnit;

/*
TODO: erstelle eine Klasse CalculatorUnitTest, die die Methoden der
 Klasse Calculator isoliert testet
 */
public class Calculator {


    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed!");
        }
        return  a / b;
    }

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

}
