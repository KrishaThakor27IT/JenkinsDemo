public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        boolean passed = true;

        // Testing all operations
        passed &= (calc.add(10, 5) == 15);
        passed &= (calc.subtract(10, 5) == 5);
        passed &= (calc.multiply(3, 4) == 12);

        try {
            passed &= (calc.divide(20, 4) == 5);
            try {
                calc.divide(10, 0);
                passed = false; // Should fail if no exception
            } catch (ArithmeticException e) {
                // expected
            }
        } catch (Exception e) {
            passed = false;
        }

        System.out.println(passed ? "All tests passed!" : "Some tests failed!");
    }
}
