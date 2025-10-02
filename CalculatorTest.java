// CalculatorTest.java
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        boolean allPassed = true;

        if (calc.add(2, 3) != 5) allPassed = false;
        if (calc.subtract(5, 2) != 3) allPassed = false;
        if (calc.multiply(2, 3) != 6) allPassed = false;
        try {
            if (calc.divide(6, 2) != 3) allPassed = false;
            try {
                calc.divide(5, 0);
                // If no exception thrown, test fails
                allPassed = false;
            } catch (Exception e) {
                // expected
            }
        } catch (Exception e) {
            allPassed = false;
        }

        if (allPassed) System.out.println("All tests passed!");
        else System.out.println("Some tests failed!");
    }
}
