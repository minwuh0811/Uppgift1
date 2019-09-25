package com.company;

public class Calculator {

    public Calculator(){
        System.out.println(" The calculator is started.");
    }


    public double addition(double a, double b) {
        double c=a+b;
        System.out.println( a + " + " + b + " = " + c);
        return c;
    }
    public double subtraction(double a,double b){
        double c=a-b;
        System.out.println( a + " - " + b + " = " + c);
        return c;
    }
    public double multiplication (double a, double b) {
        double c=a*b;
        System.out.println( a + " * " + b + " = " + c);
        return c;
    }
    public double division(double a, double b)  {
        try {
            double c= a/b;
            System.out.println(a + " / " + b + " = " + c);
            return c;
        }  catch (Exception e) {
            System.out.println("The second number can not be zero");
            return 0;
        }
    }
}
