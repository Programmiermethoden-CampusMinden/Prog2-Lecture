package enums.v2;

enum Fach {
    IFM, ELM, ARC
}

public class Studi {
    public Studi(String name, int credits, Fach studiengang) {
        // Typsicherheit für studiengang :-)
    }

    public static void main(String[] args) {
        Studi rainer = new Studi("Rainer", 10, Fach.IFM);
//        Studi holger = new Studi("Holger", 3, 4);   // Syntax-Fehler!

        // Enum Fach hat eine Methode values()
        // Jede Enum-Konstante hat eine Methode toString()
        for (Fach m : Fach.values()) {
            System.out.printf("Element: %s%n", m);
        }
    }

    public void demonstrateSomeEnumProperties() {
        // Referenzen auf Enum-Objekte können null sein
        Fach f = null;
        f = Fach.IFM;

        // Vergleich mit == möglich
        // equals() unnötig, da Vergleich mit Referenz auf statische Variable
        if (f == Fach.IFM) {
            System.out.println("Richtiges Fach :-)");
        }

        // switch/case
        switch (f) {
            case IFM:   // Achtung: *NICHT* Fach.IFM
                System.out.println("Richtiges Fach :-)");
                break;
            default:
                throw new IllegalArgumentException("FALSCHES FACH: " + f);
        }
    }
}
