public class CustomMath {
    public static double calculate(double a, double b, String operation)
            throws CustomUnsupportedOperationException, ArithmeticException {
        if ("+".equals(operation)) {
            return a + b;
        } else if ("-".equals(operation)) {
            return a - b;
        } else if ("*".equals(operation)) {
            return a * b;
        } else if ("/".equals(operation)) {
            if (b == 0) {
                throw new ArithmeticException("Division by zero!");// Деление на ноль
            }
            return a / b;
        } else {
            throw new CustomUnsupportedOperationException("Operation '" + operation + "' not supported");
            // Операция не поддерживается
        }
    }

}
