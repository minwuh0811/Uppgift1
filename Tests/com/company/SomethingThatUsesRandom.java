package com.company;

import java.util.Random;

public class SomethingThatUsesRandom  {

    private  IRandomGenerator generator;

    public SomethingThatUsesRandom(IRandomGenerator generator)
    {
        this.generator = generator;
    }

    public double MethodThatUsesRandom()
    {
        return generator.Generate(40);
    }

}