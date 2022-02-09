# JUnit 1

Eine Bank berechnet den Zinssatz für ein Konto basierend auf dem Kontostand (Guthaben) und dem Alter des Kunden:

-   Bis einschließlich 100 EUR Guthaben gibt es 1% Zinsen,
-   bis einschließlich 1000 EUR Guthaben gibt es 3% Zinsen, und
-   darüber gibt es 5% Zinsen

(jeweils für das gesamte Guthaben).

Falls der Kunde ein Kind ist (Alter kleiner als 5 Jahre), bekommt er zusätzlich einen Bonus von 0.5%.
Falls der Kunde ein Rentner ist (Alter größer/gleich 65 Jahre), bekommt er zusätzlich einen Bonus von 1%.


Implementieren Sie eine Methode, die basierend auf dem Kontostand und dem Alter des Kunden den Gesamtzinssatz
(Zinsen plus Bonus) zurückliefert. Das Guthaben und das Alter des Kunden können Sie entweder als Parameter
(beides `int`) in der Methode oder als Attribute in der Klasse implementieren, den Namen entsprechend als `String`.

Führen Sie eine Äquivalenzklassenanalyse durch und erstellen Sie daraus Testfälle. Führen Sie nun zusätzlich
eine Grenzwertanalyse durch und ergänzen Sie die Testfälle. Dokumentieren Sie die Ergebnisse der Äquivalenzklassen-
und Grenzwertanalyse nachvollziehbar.

Implementieren Sie die ermittelten Testfälle (eine Testmethode pro Testfall) mit JUnit (4.x oder 5.x).
Implementieren Sie zusätzlich *eine* Testmethode, in der alle ermittelten positiven Testfälle als ein *parametrisierter Test*
implementiert sind.

<!-- XXX
Guthaben:
*   gültige ÄK:
    -   ÄK1: 0.00 bis 99.99 EUR
    -   ÄK2: 100.00 bis 999.99 EUR
    -   ÄK3: 1000.00 und größer EUR
*   ungültige ÄK: ÄK4: negatives Guthaben
*   GW: -0.01, 0.00, 99.99, 100.00, 999.99, 1000.00 EUR

Alter:
*   gültige ÄK:
    -   ÄK5: 0 bis 4 Jahre
    -   ÄK6: 5 bis 64 Jahre
    -   ÄK7: 65 Jahre und größer
*   ungültige ÄK: ÄK8: negatives Alter
*   GW: -1, 0, 4, 5, 64, 65 Jahre

String:
*   gültige ÄK: nicht leer
*   ungültige ÄK: leer
*   GW: keine

je TF nur gültige ÄK bzw. max. eine ungültige ÄK bearbeiten
-->

[Äquivalenzklassen- und Grenzwertanalyse, Test mit JUnit]{.thema}

## JUnit 2

Der RSV Flotte Speiche hat in seiner Mitgliederverwaltung (`rsvflottespeiche.MitgliederVerwaltung`)
die Methode `beitritt` implementiert. Diese dient dazu, neue Mitglieder im Radsportverein aufzunehmen.

Details zum Verhalten der Methode entnehmen Sie bitte dem Javadoc-Kommentar an der vorgegebenen Methode.

1.  Führen Sie eine Äquivalenzklassenanalyse durch und geben Sie die gefundenen Äquivalenzklassen (*ÄK*)
    an: laufende Nummer, Definition (Wertebereiche o.ä.), kurze Beschreibung (gültige/ungültige ÄK, Bedeutung).

2.  Führen Sie zusätzlich eine Grenzwertanalyse durch und geben Sie die jeweiligen Grenzwerte (*GW*) an.

3.  Erstellen Sie aus den ÄK und GW wie in der Vorlesung diskutiert Testfälle. Geben Sie pro Testfall (*TF*)
    an, welche ÄK und/oder GW abgedeckt sind, welche Eingaben Sie vorsehen und welche Ausgabe Sie erwarten.

    [Erstellen Sie separate (zusätzliche) TF für die GW, d.h. integrieren Sie diese nicht in die ÄK-TF.]{.hinweis}

4.  Implementieren Sie die Testfälle in JUnit (JUnit 4 oder 5). Fassen Sie die Testfälle der gültigen ÄK
    in einem parametrisierten Test zusammen. Für die ungültigen ÄKs erstellen Sie jeweils eine eigene
    JUnit-Testmethode. Beachten Sie, dass Sie auch die Exceptions testen müssen.

[Geben Sie die Lösung zu den Punkten (1) bis (3) als Javadoc-Kommentar Ihrer in Punkt (4) implementierten
 JUnit-Klasse(n) ab.]{.hinweis}

[Test mit JUnit]{.thema}
