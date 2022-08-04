package Calculator.ProgFiles;

public class CalculatorException extends Exception {
    public CalculatorException(String description) {
        super(description);
        System.out.println("---Exception&dead---\n---Try again---");
    }
}
