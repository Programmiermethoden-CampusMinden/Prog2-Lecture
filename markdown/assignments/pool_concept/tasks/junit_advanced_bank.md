Eine Bank berechnet den Zinssatz für ein Konto basierend auf dem Kontostand (Guthaben)
und dem Alter des Kunden:

-   Bis einschließlich 100 EUR Guthaben gibt es 1% Zinsen,
-   bis einschließlich 1000 EUR Guthaben gibt es 3% Zinsen, und
-   darüber gibt es 5% Zinsen

(jeweils für das gesamte Guthaben).

Falls der Kunde ein Kind ist (Alter kleiner als 5 Jahre), bekommt er zusätzlich einen
Bonus von 0.5%. Falls der Kunde ein Rentner ist (Alter größer/gleich 65 Jahre), bekommt
er zusätzlich einen Bonus von 1%.

Implementieren Sie eine Methode, die basierend auf dem Kontostand und dem Alter des
Kunden den Gesamtzinssatz (Zinsen plus Bonus) zurückliefert. Das Guthaben und das Alter
des Kunden können Sie entweder als Parameter (beides `int`) in der Methode oder als
Attribute in der Klasse implementieren, den Namen entsprechend als `String`.

Führen Sie eine Äquivalenzklassen-Bildung durch und erstellen Sie daraus Testfälle.
Führen Sie zusätzlich eine Grenzwert-Analyse durch und ergänzen Sie die Testfälle.
Dokumentieren Sie die Ergebnisse der ÄK-Bildung und GW-Analyse nachvollziehbar.

Implementieren Sie die ermittelten Testfälle (eine Testmethode pro Testfall) mit JUnit
(4.x oder 5.x). Implementieren Sie zusätzlich _eine_ Testmethode, in der alle ermittelten
"positiven" Testfälle (also TF, die nur aus den gültigen ÄK stammen) als ein
_parametrisierter Test_ implementiert sind.
