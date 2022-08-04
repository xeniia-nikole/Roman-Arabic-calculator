package Calculator.ProgFiles;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Calculator calculator = new Calculator();

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
            String result = calc(userInput);
            System.out.println(result + "\n");
        }
    }

    public static String calc(String userInput) throws CalculatorException {
        char[] inputData = new char[10];
        int resultArabic;
        String resultRoman;
        boolean isRoman = true;
        char operation = 0;
        int number1;
        int number2;
        int result;


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
        if (blacks.length>2)
            throw new CalculatorException("---The calculator is performing only with two numbers---");
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
            if (result<1) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    throw new CalculatorException("---Result for Roman numerals can not be 0---");
                }
            } else {
                resultRoman = calculator.arabicToRoman(result);
                return "---Result for Roman numerals---\n" + resultRoman;
            }
        } else {
            resultArabic = calculator.calculated(number1, number2, operation);
        }
        return "---Result for Arabic numerals---\n" + resultArabic;
    }
}

