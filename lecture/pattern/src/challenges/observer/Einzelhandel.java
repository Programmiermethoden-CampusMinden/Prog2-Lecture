package challenges.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Einzelhandel {
    private HashMap<WarenTyp, Integer> lager;
    private Grosshandel grosshandel;
    private List<Auftrag> auftraege;

    public Einzelhandel(Grosshandel grosshandel) {
        lager = new HashMap<>();
        auftraege = new ArrayList<>();
        this.grosshandel = grosshandel;
    }

    /**
     * Kunde bestellt Ware: Speichere den Auftrag ab und versuche später in <code>loop()</code>, den
     * Auftrag beim Großhandel zu bestellen.
     *
     * @param auftrag der Auftrag, der aufgenommen werden soll.
     */
    public void bestellen(Auftrag auftrag) {
        if(auftrag == null){
            throw new IllegalArgumentException("Der Auftrag darf nicht null sein.");
        }
        auftraege.add(auftrag);
    }

    /**
     * Empfange Ware vom Großhandel, füge die Ware dem Lager hinzu und entferne den offenen Auftrag.
     *
     * @param auftrag der Auftrag, der abgearbeitet werden soll.
     */
    public void empfangen(Auftrag auftrag) {
        if(auftrag == null){
            throw new IllegalArgumentException("Der Auftrag darf nicht null sein.");
        }
        if(!auftraege.contains(auftrag)){
            throw new IllegalArgumentException("Der Auftrag existiert nicht von diesen Einzelhändler.");
        }
        lager.put(
                auftrag.getWarenTyp(),
                lager.getOrDefault(auftrag.getWarenTyp(), 0) + auftrag.getAnzahl());
        auftraege.remove(auftrag);
    }

    /** Versuche alle Aufträge durch Bestellung beim Großhandel abzuschließen. */
    public void loop() {
        for (int i = auftraege.size(); i > 0; i--) {
            Auftrag auftrag = auftraege.get(i - 1);
            grosshandel.bestellen(this, auftrag);
        }
    }

    /**
     * Existieren beim Einzelhändler noch offene Aufträge?
     *
     * @return true wenn mehr als 1 Auftrag offen ist, sonst false
     */
    public boolean hatAuftraege() {
        return auftraege.size() > 0;
    }

    public List<Auftrag> getAuftraege() {
        return auftraege;
    }
}
