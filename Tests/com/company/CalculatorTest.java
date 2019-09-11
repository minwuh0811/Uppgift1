package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addition() {
        Calculator calculator=new Calculator();
        double output=5.0;
        assertEquals(calculator.addition(2.0,3.0),output);
    }

    @Test
    void subtraction() {
        Calculator calculator=new Calculator();
        double output=5.0;
        assertEquals(calculator.subtraction(10.0,5.0),output);
    }

    @Test
    void multiplication() {
        Calculator calculator=new Calculator();
        double output=50.0;
        assertEquals(calculator.multiplication(10.0,5.0),output);
    }

    @Test
    void division() {
        Calculator calculator=new Calculator();
        double output=2.0;
        assertEquals(calculator.division(10.0,5.0),output);
    }
}