package bounds;

public class Cps<E extends Number> {
    // Obere Schranke: E muss Number oder Subklasse sein
    // => Zugriff auf Methoden aus Number moeglich

    public static void main(String[] args) {
        Cps<Double> a;
        Cps<Number> b;
        // Cps<String> c; // Fehler!!!
    }

}
