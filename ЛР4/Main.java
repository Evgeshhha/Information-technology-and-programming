public class Main {
    public static void main(String[] args) {
        double a = 1.0;
        double b = 2.0;
        try {
            System.out.println(CustomMath.calculate(a, b, "+"));
            System.out.println(CustomMath.calculate(a, b, "-"));
            System.out.println(CustomMath.calculate(a, b, "*"));
            System.out.println(CustomMath.calculate(a, b, "/"));
            System.out.println(CustomMath.calculate(a, b, "^"));
        } catch (CustomUnsupportedOperationException e) {
            System.out.println(e.getMessage());
            ExceptionLogger.log(e);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            ExceptionLogger.log(e);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            ExceptionLogger.log(e);
        }

    }
}
