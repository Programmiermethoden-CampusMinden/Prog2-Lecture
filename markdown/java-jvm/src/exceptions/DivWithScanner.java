package exceptions;

import java.util.Scanner;

public class DivWithScanner {

    public static double div(int a, int b) throws IllegalArgumentException {
        if (b == 0) throw new IllegalArgumentException("Can't divide by zero");
        return a / b;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Bitte Nenner eingeben.");
        try {
            // code der eine Exception verursachen kann
            double s = 5 / myScanner.nextInt();
        } catch (IllegalArgumentException e) {
            // wird im Fehlerfall aufgerufen
            e.printStackTrace();
        } finally {
            // wird immer aufgerufen
            myScanner.close();
        }
    }
}
