package exceptions;

/** Checked-Exceptions leiten von Exception ab */
public class MyCheckedException extends Exception {
    /** Erzeuge neue checked Exception */
    public MyCheckedException(String errorMessage) {
        super(errorMessage);
    }

    private static void myMethod(int x) throws MyCheckedException {
        if (x > 5 || x < 10) {
            throw new MyCheckedException("Ich finde x doof.");
        }
    }

    /** Just to please Checkstyle */
    public static void main(String... args) {
        // Checked-Exceptions müssen gefangen werden.
        try {
            myMethod(12);
        } catch (MyCheckedException e) {
            throw new RuntimeException(e);
        }
    }
}
