package exceptions;

/** Unchecked-Exceptions leiten von RuntimeException ab */
public class MyUncheckedException extends RuntimeException {
    /** Erzeuge neue unchecked Exception */
    public MyUncheckedException(String errorMessage) {
        super(errorMessage);
    }

    private static void myMethod(int x) throws MyUncheckedException {
        if (x > 5 || x < 10) {
            throw new MyUncheckedException("Ich finde x doof.");
        }
    }

    /** Just to please Checkstyle */
    public static void main(String... args) {
        // Unchecked-Exceptions müssen nicht gefangen werden.
        myMethod(12);
    }
}
