package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private Scanner sc;
    Main(){}

    Main(Scanner sc) {
        this.sc = sc;
    }

    public static void main(String[] args) {
        Main main = new Main(new Scanner(System.in));
        while (true) {
            System.out.println("Choose New Text, New Number or Exit");
            String string = main.sc.nextLine();
            if (string.equals("Exit")) {
                System.out.println("Now Exit!!");
                break;
            } else if (string.equals("New Text")) {
                main.newText();
            }
            }
            // write your code here
        }

    private void newText() {
        while (true) {
            System.out.println("Remove Char, text Value, Randomize and Return");
            String string = sc.nextLine();
            if (string.equals("Return")) {
                break;
            }

        }

    }

    public String removeChar(String string, Character Char) {
        String stringReturn="";
        int length=string.length();
        for (int i=0; i<length;  i++) {
            Character s=string.charAt(i);
            if (!s.equals(Char)) {
                stringReturn+=s;
            }
        }
        return stringReturn;
    }

    public Integer textValue(String string) {
        String lowCase=removeChar((string).toLowerCase(), ' ');
        int sumValue=0;
        int length=string.length();
        for (int i=0; i<length; i++){
            Character c=lowCase.charAt(i);
            int gap =c-'a'+1;
            sumValue+=gap;
        }
        return sumValue;
    }

    public String randomize (String string){
        Random random=new Random();
        int length=string.length();
        int index=random.nextInt(length);
        Character c=string.charAt(index);
        String outPut=removeChar(string,c);
        return outPut;
    }
}
