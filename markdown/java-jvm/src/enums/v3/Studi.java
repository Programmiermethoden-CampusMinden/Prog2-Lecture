package enums.v3;

public class Studi {
    public Studi(String name, int credits, Fach studiengang) {}

    public static void main(String[] args) {
        Studi rainer = new Studi("Rainer", 10, Fach.IFM);
        Fach x = Fach.IFM;

        System.out.println("\n");
        System.out.println("Direkte Ausgabe: " + x);
        System.out.println("name(): " + x.name());
        System.out.println("ordinal(): " + x.ordinal());

        System.out.println("toString(): " + x);
        System.out.println("getBeschreibung(): " + x.getDescription());

        System.out.println("\n");
        // valueOf(String): zum String passende Konstante
        System.out.println("valueOf(): " + (Fach.valueOf("IFM") == Fach.IFM));

        System.out.println("\n");
        for (Fach m : Fach.values()) {
            // values(): Alle Konstanten der Aufzählung
            System.out.printf("Element: %s, Beschreibung: %s%n", m, m.getDescription());
        }
    }
}
