package hsbi;

public class Studi {
    String name;
    LSF lsf;

    public Studi(String name, LSF lsf) {
        this.name = name;
        this.lsf = lsf;
    }

    /**
     * Melde den Studi zur Prüfung an.
     *
     * @param modul In diesem Modul will sich der Studi anmelden
     * @return true, wenn Anmeldung erfolgreich; sonst false
     */
    public boolean anmelden(String modul) {
        return lsf.anmelden(name, modul);
    }

    /**
     * Nehme an der Klausureinsicht teil und reagiere auf das Ergebnis.
     *
     * @param modul Für dieses Modul soll die Einsicht erfolgen
     * @return true, falls mehr als 50 Punkte (bestanden); sonst false
     */
    public boolean einsicht(String modul) {
        return lsf.ergebnis(name, modul) > 50;
    }
}
