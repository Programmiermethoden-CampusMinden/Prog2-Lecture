package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

/** Code für die Slides (Motivation) */
public class DivExample {
    private static int div(int a, int b) {
        return a / b;
    }

    private static Optional<Integer> div1(int a, int b) {
        if (b == 0) return Optional.empty();
        return Optional.of(a / b);
    }

    private static int div2(int a, int b) throws ArithmeticException {
        // ArithmeticException wird automatisch geworfen, wenn sie aufkommt.
        return a / b;
    }

    private static int div3(int a, int b) throws IllegalArgumentException {
        // IllegalArgumentException muss von uns geworfen werden
        if (b == 0) throw new IllegalArgumentException("Can't divide by zero");
        return a / b;
    }

    /** Just to please Checkstyle */
    public static void main(String... args) {
        // Einfaches div ...
        div(3, 0);

        // Versuchen wir es mit Optional
        Optional<Integer> x = div1(3, 0);
        if (x.isPresent()) {
            // do something
        } else {
            // do something else
        }

        // Try/Catch
        int a = getUserInput();
        int b = getUserInput();
        int c = getUserInput();
        try {
            div2(a, b);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        try {
            div3(a, b);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        div2(5, 0);
        div3(5, 0);

        // multiple catch
        try {
            someMethod(a, b, c);
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }

        // try-with-resource
        Scanner myScanner2 = new Scanner(System.in);
        try {
            int s = 5 / myScanner2.nextInt();
        } catch (InputMismatchException ime) {
            ime.printStackTrace();
        } finally {
            // wird immer aufgerufen
            myScanner2.close();
        }
    }

    private static int getUserInput() {
        return 0;
    }

    private static void someMethod(int a, int b, int c) throws FileNotFoundException {}

    private static int tryCatchFinally() {
        Scanner myScanner = new Scanner(System.in);
        try {
            return 5 / myScanner.nextInt();
        } catch (InputMismatchException ime) {
            ime.printStackTrace();
        } finally {
            // wird immer aufgerufen
            myScanner.close();
        }
        return 0;
    }

    private static int tryWithResource() {
        try (Scanner myScanner = new Scanner(System.in)) {
            return 5 / myScanner.nextInt();
        } catch (InputMismatchException ime) {
            ime.printStackTrace();
        }
        return 0;
    }

    // try-with-resource
    private static String getFirstLine(String pathToFile) throws IOException {
        try (FileReader fileReader = new FileReader(pathToFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            return bufferedReader.readLine();
        }
    }
}
