package com.company;

import com.company.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    void removeCharText() {
        Main main=new Main();
        String stringTest="Min Wu";
        Character c='u';
        String stringResult="Min W";
        assertEquals(main.removeChar(stringTest,c),stringResult);
    }

    @Test
    void textValueWithSpace() {
        Main main=new Main();
        String stringTest="ja ";
        Integer intResult=11;
        assertEquals(main.textValue(stringTest),intResult);
    }
    @Test
    void textValueWithoutSpaceWithUppcase() {
        Main main=new Main();
        String stringTest="Hej";
        Integer intResult=23;
        assertEquals(main.textValue(stringTest),intResult);
    }

    @Test
    void numberOfPlus() {
        Main main=new Main();
        int intInput=5;
        String output="+++++";
        assertEquals(main.numberOfPlus(intInput),output);
    }

    @Test
    void printPlus() {
        Main main=new Main();
        int intInput=5;
        assertEquals(main.printPlus(intInput).size(),intInput);
    }
}