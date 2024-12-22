package RMI;

import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Calculator Operations: add, subtract, multiply, divide");
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter operation (+, -, *, /): ");
            String operation = scanner.next();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result = 0;
            switch (operation) {
                case "+":
                    result = calculator.add(num1, num2);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    break;
                case "/":
                    result = calculator.divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid operation.");
                    return;
            }

            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

