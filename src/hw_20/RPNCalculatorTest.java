package hw_20;

public class RPNCalculatorTest {

    public static void main(String[] args) {
        testValidRPNExpression();
        testDivisionByZero();
        testInvalidRPNExpression();
        testEmptyRPNExpression();
        testInvalidOperator();
    }

    private static void testValidRPNExpression() {
        String rpnExpression = "45 5 + 10 /";
        double result = RPNCalculator.evaluateRPN(rpnExpression);
        if (result == 5.0) {
            System.out.println("Valid RPN expression test passed.");
        } else { System.err.println("Valid RPN expression test failed."); } }

    private static void testDivisionByZero() {
        String rpnExpression = "4 0 /";
        try {
            double result = RPNCalculator.evaluateRPN(rpnExpression);
            System.err.println("Division by zero test failed.");
        } catch (ArithmeticException e) { System.out.println("Division by zero test passed."); } }
    private static void testInvalidRPNExpression() {
        String rpnExpression = "3 + 4 *";
        try { double result = RPNCalculator.evaluateRPN(rpnExpression);
            System.err.println("Invalid RPN expression test failed."); }
        catch (IllegalArgumentException e) { System.out.println("Invalid RPN expression test passed."); } }

    private static void testEmptyRPNExpression() {
        String rpnExpression = "";
        try { double result = RPNCalculator.evaluateRPN(rpnExpression);
            System.err.println("Empty RPN expression test failed.");}
        catch (IllegalArgumentException e) { System.out.println("Empty RPN expression test passed."); } }

    private static void testInvalidOperator() {
        String rpnExpression = "3 4 $"; // $ is an unsupported operator
        try {
            double result = RPNCalculator.evaluateRPN(rpnExpression);
            System.err.println("Invalid operator test failed.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid operator test passed.");
        }
    }
}
