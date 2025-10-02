import java.util.Scanner;

public class Calculator {

    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Interactive Calculator!");
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.println("Choose operation: 1-Add, 2-Subtract, 3-Multiply, 4-Divide");
        int choice = sc.nextInt();

        try {
            int result = switch(choice) {
                case 1 -> calc.add(num1, num2);
                case 2 -> calc.subtract(num1, num2);
                case 3 -> calc.multiply(num1, num2);
                case 4 -> calc.divide(num1, num2);
                default -> throw new IllegalArgumentException("Invalid choice");
            };
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
