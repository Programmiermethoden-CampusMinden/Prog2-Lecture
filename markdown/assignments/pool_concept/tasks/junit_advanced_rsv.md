Der RSV Flotte Speiche hat in seiner Mitgliederverwaltung (`rsvflottespeiche.MitgliederVerwaltung`)
die Methode `beitritt` implementiert. Diese dient dazu, neue Mitglieder im Radsportverein aufzunehmen.

Details zum Verhalten der Methode entnehmen Sie bitte dem Javadoc-Kommentar an der vorgegebenen Methode.

1. Führen Sie eine Äquivalenzklassenanalyse durch und geben Sie die gefundenen Äquivalenzklassen (*ÄK*)
   an: laufende Nummer, Definition (Wertebereiche o.ä.), kurze Beschreibung (gültige/ungültige ÄK, Bedeutung).

2. Führen Sie zusätzlich eine Grenzwertanalyse durch und geben Sie die jeweiligen Grenzwerte (*GW*) an.

3. Erstellen Sie aus den ÄK und GW wie in der Vorlesung diskutiert Testfälle. Geben Sie pro Testfall (*TF*)
   an, welche ÄK und/oder GW abgedeckt sind, welche Eingaben Sie vorsehen und welche Ausgabe Sie erwarten.

   [Erstellen Sie separate (zusätzliche) TF für die GW, d.h. integrieren Sie diese nicht in die ÄK-TF.]{.hinweis}

4. Implementieren Sie die Testfälle in JUnit (JUnit 4 oder 5). Fassen Sie die Testfälle der gültigen ÄK
   in einem parametrisierten Test zusammen. Für die ungültigen ÄKs erstellen Sie jeweils eine eigene
   JUnit-Testmethode. Beachten Sie, dass Sie auch die Exceptions testen müssen.

```java
package rsvflottespeiche;

public class MitgliederVerwaltung {
    /**
     * Testet, ob ein Mitglied mit den folgenden Parametern aufgenommen werden kann.
     *
     * @param alter zwischen 0 und 99 (inklusive)
     * @param motivation zwischen 0 und 10 (inklusive)
     * @return <code>true</code>, wenn das Mitglied aufgenommen werden kann, andernfalls <code>false
     *     </code>.
     */
    public boolean beitritt(int alter, int motivation) {
        if (alter < 0 || alter > 99 || motivation < 0 || motivation > 10) {
            throw new IllegalArgumentException(
                    "Das Alter und die Motivation müssen innerhalb der Grenzen sein.");
        }
        if (alter < 16) {
            return false;
        }
        return motivation >= 4 && motivation <= 7;
    }

    public static void main(String[] args) {
        MitgliederVerwaltung flotteSpeiche = new MitgliederVerwaltung();
        System.out.println(flotteSpeiche.beitritt(20, 5));
    }
}
```
