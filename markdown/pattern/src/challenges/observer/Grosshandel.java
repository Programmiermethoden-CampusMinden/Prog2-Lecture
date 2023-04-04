package challenges.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Grosshandel {
    private HashMap<WarenTyp, Integer> lager;

    public Grosshandel() {
        lager = new HashMap<>();
        for (WarenTyp typ : WarenTyp.values()) {
            lager.put(typ, 0);
        }
    }

    /**
     * Ein Einzelhändler kann Waren mit einer bestimmten Anzahl bestellen. Wenn diese in
     * ausreichender Zahl verfügbar ist, liefert der Großhandel die gewünschte Ware direkt aus.
     *
     * @param kunde Der Kunde, welcher die Bestellung tätigt.
     * @param auftrag Der Auftrag, welcher abgearbeitet werden soll.
     * @return true, wenn der Auftrag ausgeführt wurde; false sonst
     */
    public boolean bestellen(Einzelhandel kunde, Auftrag auftrag) {
        if (kunde == null) {
            throw new IllegalArgumentException("Der Kunde darf nicht null sein!");
        }
        if (auftrag == null) {
            throw new IllegalArgumentException("Der Auftrag darf nicht null sein!");
        }

        if (lager.getOrDefault(auftrag.getWarenTyp(), 0) >= auftrag.getAnzahl()) {
            lager.put(
                    auftrag.getWarenTyp(), lager.get(auftrag.getWarenTyp()) - auftrag.getAnzahl());
            kunde.empfangen(auftrag);
            return true;
        }
        return false;
    }

    /** Der Grosshandel bekommt immer Ware, von der am wenigsten aktuell verfügbar ist. */
    public void loop() {
        Random random = new Random();
        Map.Entry<WarenTyp, Integer> kleinsterBestand = findeKleinstenBestand();
        int zusatzMenge = random.nextInt(1, 5);
        kleinsterBestand.setValue(kleinsterBestand.getValue() + zusatzMenge);
    }

    private Map.Entry<WarenTyp, Integer> findeKleinstenBestand() {
        Map.Entry<WarenTyp, Integer> kleinsterBestand = null;
        for (Map.Entry<WarenTyp, Integer> loop : lager.entrySet()) {
            if (kleinsterBestand == null || kleinsterBestand.getValue() > loop.getValue()) {
                kleinsterBestand = loop;
            }
        }
        return kleinsterBestand;
    }
}
