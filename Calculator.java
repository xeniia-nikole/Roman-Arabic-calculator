package Calculator.ProgFiles;

import java.util.InputMismatchException;
public class Calculator {

    public int calculated(int num1, int num2, char op) throws CalculatorException {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("---Exception : " + e + "---");
                    System.out.println("---Only integer non-zero parameters allowed---");

                    break;
                }
                break;
            default:
                throw new CalculatorException("---The calculator can perform only '+', '-', '*', '/' operations---");
        }
        return result;
    }

    public int stringToInteger(String roman) throws CalculatorException {
        try {
            switch (roman) {
                case "I", "1":
                    return 1;
                case "II", "2":
                    return 2;
                case "III", "3":
                    return 3;
                case "IV", "4":
                    return 4;
                case "V", "5":
                    return 5;
                case "VI", "6":
                    return 6;
                case "VII", "7":
                    return 7;
                case "VIII", "8":
                    return 8;
                case "IX", "9":
                    return 9;
                case "X", "10":
                    return 10;
            }
        } catch (InputMismatchException e) {
            throw new CalculatorException("---The calculator must accept numbers from 1 to 10 inclusive as input---");
        }
        return -1;
    }

    public boolean isRoman(String first, String second, boolean b) throws CalculatorException {
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean firstIs = false;
        boolean secondIs = false;
        for (String number : romanNumbers) {
            if (number.equals(first)) {
                firstIs = true;
                break;
            }
        }
        for (String number : romanNumbers) {
            if (number.equals(second)) {
                secondIs = true;
                break;
            }
        }
        if (!firstIs && !secondIs) return !b;
        if ((!firstIs && secondIs) || (firstIs && !secondIs))
            throw new CalculatorException
                    ("---Incorrect variable input type---");
        return b;
    }


    public String arabicToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabian];
    }
}
