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
        Main main=new Main(new Scanner(System.in));
        while (true) {
            System.out.println("Choose one from those choices: 1.New Text,2.New Number and 3.Exit");
            int choices = Integer.parseInt(getStringInput());
            if (choices == 3) {
                System.out.println("Now Exit!!");
                break;
            } else if (choices == 1) {
                newText();
            } else if (choices==2) {
                newNumber();
            }
        }
        // write your code here
    }

    private static void newText() {
        while (true) {
            System.out.println("Choose one from those choices: 1.Remove Char,2.text Value,3.Randomize and 4.Return");
            int number = Integer.parseInt(getStringInput());
            if (number == 4) {
                break;
            } else if (number == 1) {
                System.out.println("Enter a string:");
                String string = getStringInput();
                System.out.println("Enter a char:");
                Character character = getStringInput().charAt(0);
                System.out.println("The removed string is " + removeChar(string, character));
            } else if (number == 2) {
                System.out.println("Enter a String:");
                String string = getStringInput();
                System.out.println("The text value is " + textValue(string));
            } else if (number == 3) {
                System.out.println("Enter a String:");
                String string = getStringInput();
                StringBuilder random = randomize(string);
                System.out.println("The output is " + random);
            }
        }

    }

    private static void newNumber(){
        while (true) {
            System.out.println("Choose one from those choices: 1. Get random number, 2. Print plus, 3. Create Calculator and 4.Return");
            int choices=Integer.parseInt(getStringInput());
            if (choices==4) {
                break;
            } else if (choices==1) {
                System.out.println("Set an integer range: ");
                int integerRange=Integer.parseInt(getStringInput());
                int randomN=getRandomNumber(integerRange);
                System.out.println("The random number is "+randomN);
            } else if (choices==2) {
                System.out.println("Enter the number of plus to print press 1 or choose a random number press 2");
                int choice = Integer.parseInt(getStringInput());
                if (choice == 1) {
                    System.out.println("Enter the number of plus you want to print.");
                    int number = Integer.parseInt(getStringInput());
                    printPlus(number);
                } else if (choice == 2) {
                    System.out.println("Enter the integer range: ");
                    int randomN = Integer.parseInt(getStringInput());
                    int number = getRandomNumber(randomN);
                    System.out.println("The random Number is "+number);
                    printPlus(number);
                }
            } else if (choices==3) {
                Calculator calculator=new Calculator();
                createCal(calculator);
            }
        }
    }


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

    public static String getStringInput() {
        String string = sc.nextLine();
        return string;
    }
    public static int getRandomNumber(int input) {
        Random random=new Random();
        return random.nextInt(input);
    }
    public static String numberOfPlus(int number) {
        String outPut="+";
        for(int i=0; i<number; i++) {
            outPut+="+";
        }
        return outPut;
    }
    public static void printPlus(int number) {
        String outPut="";
        for (int i=0; i<number; i++){
            System.out.println(numberOfPlus(i));
        }
    }
    public static void createCal(Calculator calculator) {
        while (true) {
            System.out.println("Choose the operations: 1. addition 2.subtraction 3.division 4.multiplication 5. Return");
            int choose =Integer.parseInt(getStringInput());
            if (choose == 1) {
                System.out.println("Addition operation\nThe first number:");
                int N1 = Integer.parseInt(getStringInput());
                System.out.printf("The second number:");
                int N2 = Integer.parseInt(getStringInput());
                calculator.addition(N1, N2);
            } else if (choose == 2) {
                System.out.println("Subtraction operation\nThe first number:");
                int N1 = Integer.parseInt(getStringInput());
                System.out.printf("The second number:");
                int N2 = Integer.parseInt(getStringInput());
                calculator.subtraction(N1, N2);
            } else if (choose == 3) {
                System.out.println("Division operation\nThe first number:");
                int N1 = Integer.parseInt(getStringInput());
                System.out.println("The second number (not zero)");
                int N2 = Integer.parseInt(getStringInput());
                calculator.division(N1, N2);
            } else if (choose == 4) {
                System.out.println("multiplication operation\nThe first number:");
                int N1 = Integer.parseInt(getStringInput());
                System.out.println("The second number: ");
                int N2 = Integer.parseInt(getStringInput());
                calculator.multiplication(N1, N2);
            } else if (choose == 5) {
                System.out.println("The calculator is terminated!!");
                break;
            }

        }
    }
}
