package com.company;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner sc;

    Main(Scanner sc) {
        this.sc = sc;
    }

    Main() {
    }

    public static void main(String[] args) {
        Main main = new Main(new Scanner(System.in));
        while (true) {
            //ask user to choose from 1, 2 and 3
            System.out.println("Choose one from those choices: 1.New Text,2.New Number and 3.Exit");
            int choices = Integer.parseInt(getStringInput());
            switch (choices) {
                // choice 3, stop while loop
                case 3:
                    System.out.println("Now Exit!!");
                   return;
                // choice 1, ask user to choose from 1, 2, 3 and 4
                case 1:
                  while (true) {
                      System.out.println("Choose one from those choices: 1.Remove Char,2.text Value,3.Randomize and 4.Return");
                        int number = Integer.parseInt(getStringInput());
                       //choice 4 is selected, the while loop broken, otherwise call function newText.
                       if (number == 4) {
                           break;
                       } else {
                           newText(number);
                      }
                 }
                 break;
                // choice 2, ask user to choose from 1, 2, 3 and 4
                case 2:
                    while (true) {
                     System.out.println("Choose one from those choices: 1. Get random number, 2. Print plus, 3. Create Calculator and 4.Return");
                     int choice = Integer.parseInt(getStringInput());
                       //choice 4 is selected, the while loop broken, otherwise call function newText.
                       if (choice == 4) {
                         break;
                        } else {
                           newNumber(choice);
                    }
                }
                    break;
                // if user send in an invalid word, it will continue ask user to type valid choice.
                default:
                    System.out.println("The input is not valid.");
                    break;
            }
        }
    }
   // newText uses the user choice as the input
    private static void newText(int number) {
        switch (number) {
            // choice 1, remove char from a string
            case 1:
                System.out.println("Enter a string:");
                String string = getStringInput();
                System.out.println("Enter a char:");
                Character character = getStringInput().charAt(0);
                System.out.println("The removed string is " + removeChar(string, character));
                break;
             //choice 2, calculate the value of a string, a, 1; b, 2
            case 2:
                System.out.println("Enter a String:");
                string = getStringInput();
                System.out.println("The text value is " + textValue(string));
                break;
            //choice 3, return a randomly rearranged string
            case 3:
                System.out.println("Enter a String:");
                string = getStringInput();
                StringBuilder random = randomize(string);
                System.out.println("The output is " + random);
                break;
             // if user send in an invalid word, continue asking user to send in a valid choice.
            default:
                System.out.println("input is not valid.");
                break;
            }
        }


    // newNumber uses the user choice as the input
    private static void newNumber(int choices){
        switch (choices) {
            // choice 1, print a random integer
            case 1:
                System.out.println("Set an integer range: ");
                int integerRange=Integer.parseInt(getStringInput());
                int randomN=getRandomNumber(integerRange);
                System.out.println("The random number is "+randomN);
                break;
            // choice 2, ask user to choose between 1 and 2
            case 2:
                System.out.println("Enter the number of plus to print press 1 or choose a random number press 2");
                int choice = Integer.parseInt(getStringInput());
                switch (choice) {
                    /*choice 1 is to print the number of +, the number is selected by user
                    for example if user select 4, then the result is
                    +
                    ++
                    +++
                    ++++
                     */
                    case 1:
                        System.out.println("Enter the number of plus you want to print.");
                        int number = Integer.parseInt(getStringInput());
                        System.out.println(numberOfPlus(number));
                        break;
                    //choice 1 is to print the number of +, the number is generated by random number the range is set by user           for example if user select 4, then the result is
                    case 2:
                        System.out.println("Enter the integer range: ");
                        randomN = Integer.parseInt(getStringInput());
                        number = getRandomNumber(randomN);
                        System.out.println(numberOfPlus(number));
                        System.out.println("The random Number is " + number);
                        break;
                    // if user send in an invalid word, continue asking user to send in a valid choice.
                    default:
                        System.out.println("The input is not valid.");
                }
                break;
             // choice 3 refer to a calculator
            case 3:
                Calculator calculator=new Calculator();
                createCal(calculator);
                break;
            // if user send in an invalid word, continue asking user to send in a valid choice.
            default:
                System.out.println("The input is not valid.");
                break;
            }
        }


    //remove char from a string, the string and required char to be removed as input, return the string after remove char
    public static String removeChar(String string, Character character) {
        String stringReturn = "";
        int length = string.length();
        for (int i = 0; i < length; i++) {
            Character s = string.charAt(i);
            if (!s.equals(character)) {
                stringReturn += s;
            }
        }
        return stringReturn;
    }
    //calculate the value for a string, (a,1), (b,2)... space is 0, the string as input and return the value of the string as an integer
    public static Integer textValue(String string) {
        String lowCase = removeChar((string).toLowerCase(), ' ');
        int sumValue = 0;
        int length = lowCase.length();
        for (int i = 0; i < length; i++) {
            Character c = lowCase.charAt(i);
            int gap = c - 'a' + 1;
            sumValue += gap;
        }
        return sumValue;
    }
    //build a randomly rearranged string, the string is to be rearranged as input, the randomly rearranged string is output
    public static StringBuilder randomize(String string) {
        Random random = new Random();
        ArrayList<Character> characters = new ArrayList<Character>();
        for (char c : string.toCharArray()) {
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(string.length());
        while (characters.size() != 0) {
            int randPicker = random.nextInt(characters.size());
            output.append(characters.remove(randPicker));
        }
        return output;
    }
    // return a string from IO
    public static String getStringInput() {
        String string = sc.nextLine();
        return string;
    }
    // return a random integer in the range of user defined as input
    public static int getRandomNumber(int input) {
        Random random=new Random();
        return random.nextInt(input);
    }
    /*print the +, the number of + to print as input, and return the number of ++
    for example if user select 4, then the result is
    +
    ++
    +++
    ++++
    */
    public static String numberOfPlus(int number) {
        String outPut="";
        if (number == 0) {
            outPut="";
        } else {
           outPut="+".repeat(number) + "\n" + numberOfPlus(number-1);
        }
        return outPut;
    }
    // Calculator use object calculator as input
    public static void createCal(Calculator calculator) {
        while (true) {
            //ask user to choose:
            System.out.println("Choose the operations: 1. addition 2.subtraction 3.division 4.multiplication 5. Return");
            int choose =Integer.parseInt(getStringInput());
            switch (choose) {
                // choice 1 do addition;
                case 1:
                    System.out.println("Addition operation\nThe first number:");
                    int N1 = Integer.parseInt(getStringInput());
                    System.out.println("The second number: ");
                    int N2 = Integer.parseInt(getStringInput());
                    calculator.addition(N1, N2);
                    break;
                // choice 2 do subtraction;
                case 2:
                   System.out.println("Subtraction operation\nThe first number:");
                   N1 = Integer.parseInt(getStringInput());
                   System.out.println("The second number: ");
                   N2 = Integer.parseInt(getStringInput());
                   calculator.subtraction(N1, N2);
                   break;
                 // choice 3 do Division;
                case 3:
                  System.out.println("Division operation\nThe first number:");
                  N1 = Integer.parseInt(getStringInput());
                  System.out.println("The second number (not zero)");
                  N2 = Integer.parseInt(getStringInput());
                  calculator.division(N1, N2);
                  break;
                 // choice 4 do multiplication;
                case 4:
                    System.out.println("multiplication operation\nThe first number:");
                    N1 = Integer.parseInt(getStringInput());
                    System.out.println("The second number: ");
                    N2 = Integer.parseInt(getStringInput());
                    calculator.multiplication(N1, N2);
                    break;
                 //choice 5, stop while loop
                case 5:
                    System.out.println("The calculator is terminated!!");
                    return;
                // if user send in an invalid word, continue asking user to send in a valid choice.
                default:
                    System.out.println("The input is not valid.");
                    break;
            }

        }
    }
}
