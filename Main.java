package Calculator;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Calculator calculator = new Calculator();
    static char operation;
    static boolean isRoman = true;
    static int number1;
    static int number2;
    static int result;

    public static void main(String[] args) throws CalculatorException {
        System.out.println("""
                ---Welcome to the calculator app---
                Rules of use:
                1. The calculator can perform addition, subtraction, multiplication and division operations with two numbers: a + b, a - b, a * b, a / b.
                2. The calculator can work with both Arabic (1,2,3,4,5...) and Roman (I,II,III,IV,V...) numbers.
                3. The calculator must accept numbers from 1 to 10 inclusive as input.
                4. The calculator can only work with integers.
                5. The calculator does not know how to work with Arabic and Roman numerals at the same time.
                6. The result of the calculator with Arabic numbers can be negative numbers and zero.
                7. The result of the calculator with Roman numbers can only be positive numbers.
                
                """);

        while (true) {
            System.out.println("---Enter the operation---");
            String userInput = scanner.nextLine();
            char[] inputData = new char[10];

            for (int i = 0; i < userInput.length(); i++) {
                inputData[i] = userInput.charAt(i);
                if (inputData[i] == '+') {
                    operation = '+';
                } else if (inputData[i] == '-') {
                    operation = '-';
                } else if (inputData[i] == '*') {
                    operation = '*';
                } else if (inputData[i] == '/') {
                    operation = '/';
                }
            }

            String under_charString = String.valueOf(inputData);
            String[] blacks = under_charString.split("[+-/*]");
            try {
                String firstVariable = blacks[0];
                String secondVariable = blacks[1];
                firstVariable = firstVariable.trim();
                secondVariable = secondVariable.trim();

                isRoman = calculator.isRoman(firstVariable, secondVariable, isRoman);

                number1 = calculator.stringToInteger(firstVariable);
                number2 = calculator.stringToInteger(secondVariable);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new CalculatorException("---Invalid operation sign---");
            }


            if (number1 < 0 || number2 < 0) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    throw new CalculatorException("---Invalid data format---");
                }
            } else if (isRoman){
                result = calculator.calculated(number1, number2, operation);
                System.out.println("---Result for Roman numerals---");
                String resultRoman = calculator.arabicToRoman(result);
                System.out.println(resultRoman);
            } else {
                result = calculator.calculated(number1, number2, operation);
                System.out.println("--Result for Arabic numerals---");
                System.out.println(result);
            }
        }
    }
}

