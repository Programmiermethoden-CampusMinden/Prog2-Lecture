Der RSV Flotte Speiche hat in seiner Mitgliederverwaltung (`rsvflottespeiche.MitgliederVerwaltung`) die Methode
`testBeitritt` implementiert. Mit dieser Methode wird geprüft, ob neue Mitglieder in den Radsportverein aufgenommen
werden können.

```java
package rsvflottespeiche;

public class MitgliederVerwaltung {

    /**
     * Testet, ob ein Mitglied in den Verein aufgenommen werden kann.
     *
     * @param alter       Alter in Lebensjahren, Bereich [0, 99]
     * @param motivation  Motivation auf einer Scala von 0 bis 10
     * @return <code>true</code>, wenn das Mitglied aufgenommen werden kann, sonst <code>false</code>
     */
    public boolean testBeitritt(int alter, int motivation) {
        if (alter < 0 || alter > 99 || motivation < 0 || motivation > 10) {
            throw new IllegalArgumentException("Das Alter und die Motivation müssen innerhalb der Grenzen sein.");
        }
        if (alter < 16) {
            return false;
        }
        return motivation >= 4 && motivation <= 7;
    }
}
```

1.  Führen Sie eine Äquivalenzklassenbildung durch und geben Sie die gefundenen Äquivalenzklassen (_ÄK_)
    an: laufende Nummer, Definition (Wertebereiche o.ä.), kurze Beschreibung (gültige/ungültige ÄK, Bedeutung).

2.  Führen Sie zusätzlich eine Grenzwertanalyse durch und geben Sie die jeweiligen Grenzwerte (_GW_) an.

3.  Erstellen Sie aus den ÄK und GW wie in der Vorlesung diskutiert Testfälle. Geben Sie pro Testfall (_TF_)
    an, welche ÄK und/oder GW abgedeckt sind, welche Eingaben Sie vorsehen und welche Ausgabe Sie erwarten.

    _Hinweis_: Erstellen Sie separate (zusätzliche) TF für die GW, d.h. integrieren Sie diese _nicht_ in die
    ÄK-TF.

4.  Implementieren Sie die Testfälle in JUnit (JUnit 4 oder 5). Fassen Sie die Testfälle der gültigen ÄK in
    einem parametrisierten Test zusammen. Für die ungültigen ÄKs erstellen Sie jeweils eine eigene
    JUnit-Testmethode. Beachten Sie, dass Sie auch die Exceptions testen müssen.
