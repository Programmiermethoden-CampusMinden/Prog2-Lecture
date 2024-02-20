package challenges;

import java.util.*;

public class Kunde {
    private Konto konto;
    private Queue<Rechnung> offeneRechnungen;

    /** Erstelle einen neune Kunden, der sich ein Konto bei der Bank erstellt. */
    public Kunde() {
        konto = new Konto();
        offeneRechnungen = new LinkedList<>();
    }

    /**
     * Empfange eine Rechnung zum bezahlen.
     *
     * @param rechnung Die Rechnung.
     */
    public void empfangeRechnung(Rechnung rechnung) {
        offeneRechnungen.add(rechnung);
    }

    public Konto getKonto() {
        return konto;
    }
}
