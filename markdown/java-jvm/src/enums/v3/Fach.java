package enums.v3;

public enum Fach {
    IFM,
    ELM("Elektrotechnik Praxisintegriert", 1, 30),
    ARC("Architektur", 4, 40),
    PHY("Physik", 3, 10);

    private final String description;
    private final int number;
    private final int capacity;

    Fach() {
        // implizit private und kein super()-Aufruf!
        this("Informatik Bachelor", 0, 60);
        System.out.println("Basiskonstruktor");
    }

    Fach(String descr, int number, int capacity) {
        // implizit private und kein super()-Aufruf!
        this.description = descr;
        this.number = number;
        this.capacity = capacity;
        System.out.println("Erweiterter Konstruktur: " + descr);
    }

    public String getDescription() {
        // eigene Methoden sind möglich ...
        // name(): Name der Konstanten (final)
        // ordinal(): Interne Nummer (Reihenfolge des Anlegens)
        return "Konstante: " + name() + " (Beschreibung: " + description + ", Kapazitaet: " + capacity + ", Nummer: " + number + ", Ordinal: " + ordinal() + ")";
    }

    @Override
    public String toString() {
        // wird geerbt, ruft normalerweise name() auf ...
        return "toString-Methode von " + name();
    }
}
