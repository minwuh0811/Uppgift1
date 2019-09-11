package com.company;
import java.util.Random;


public class DefaultRandom implements IRandomGenerator{

    public int Generate(int max)
    {
        return (new Random()).nextInt(max);
    }


    }
