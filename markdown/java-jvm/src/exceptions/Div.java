package exceptions;

public class Div {

    public static double div(int a, int b) throws ArithmeticException {
        // ArithmeticException wird eigenständig geworfen, wenn sie aufkommt.
        return a / b;
    }

    public static double div2(int a, int b) throws IllegalArgumentException {
        // IllegalArgumentException muss eigenständig geworfen werden
        if (b == 0) throw new IllegalArgumentException("Can't divide by zero");
        return a / b;
    }

    public static void main(String[] args) {
        try {
            div(5, 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        try {
            div2(5, 0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
