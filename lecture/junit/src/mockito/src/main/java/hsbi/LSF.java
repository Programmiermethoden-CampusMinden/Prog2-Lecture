package hsbi;

public class LSF {
    /**
     * Melde einen Studi in einem Modul zur Prüfung an.
     *
     * @param name  Name des anzumeldenden Studis
     * @param modul Modul, in dem der Studi angemeldet wird
     * @return true, wenn die Anmeldung erfolgreich war; sonst false
     */
    public boolean anmelden(String name, String modul) {
        throw new UnsupportedOperationException();
    }

    /**
     * Finde die Punkte heraus, die ein Studi in einer Modulprüfung erreicht hat
     *
     * <p>Um den Profs das Leben leichter zu machen, werden die Prüfungen automatisch mit einer
     * zufälligen Zahl von Punkten zwischen 0 und 100 bewertet.
     *
     * @param name  Name des Studis
     * @param modul Modul, für das die Ergebnisse abgefragt werden
     * @return Anzahl der Punkte: [0,100]
     */
    public int ergebnis(String name, String modul) {
        throw new UnsupportedOperationException();
    }
}
