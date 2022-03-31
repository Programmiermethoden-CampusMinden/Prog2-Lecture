Ein Kunde kommt in unser Computergeschäft und möchte bei uns einen Computer
bestellen. Dabei gibt er an, wie er diesen vorwiegend nutzen möchte bzw. für
welchen Zweck er gedacht ist ("_stationär_" oder "_mobil_"). Nach reichlicher
Überlegung, ob er den neuen Rechner zu Hause stehen haben möchte oder lieber
keinen weiteren Rechner, egal ob "_mobil_" oder "_stationär_", bei sich im Weg
herumstehen haben will, teilt er Ihnen seine Entscheidung darüber mit
("_stationär_" oder "_mobil_" vs. "_nicht daheim_"). Bei diesem Gespräch merkt er
beiläufig an, dass es ein Rechner mit "_viel Wumms_" sein könnte oder vielleicht
doch besser etwas Kleines, was leise vor sich hin schnurrt ("_viel Wumms_" vs.
"_leise schnurrend_").

Je nach gewünschter Konfiguration soll ein den oben genannten Auswahlkriterien
entsprechender Rechner mit den aus der unten stehenden Konfigurationsmatrix zu
entnehmenden Eigenschaften automatisch erzeugt werden. Die Größe des installierten
`RAM`, die Anzahl der eingebauten `CPU`-Kerne mit ihrer jeweiligen Taktrate,
sowie die Art und Größe der installierten Festplatte (`HDD` oder `SSD`) sollte
dabei zu dem gewählten Paket passend gesetzt werden.

Implementieren Sie eine "Computerfabrik" (Klasse `ComputerFactory`), die Ihnen
den richtig konfigurierten Rechner zusammenbaut. Nutzen Sie dabei das
"Factory-Method-Pattern" zum Erzeugen der Objekte der einzelnen Subklassen. Dabei
soll Ihre Computerfabrik anhand der ihr übergebenen Konfiguration eigenständig
entscheiden, welche Art von Computer dabei erstellt werden soll.

Implementieren Sie dazu in Ihrer Factory die Factory-Methode `buildComputer`,
welche das jeweils passend konfigurierte Objekt zurückgibt.

```java
public class ComputerFactory {
    ...

    public static Computer buildComputer(..."stationär",..."viel Wumms") {
        ...
        return PerformanceDesktopComputer;
    }
}
```

**Konfigurationsmatrix**

|                    |    "stationär" (`DesktopComputer `)    |      "mobil" (`LaptopComputer`)      |      "nicht daheim" (`CloudComputer`)      |
|:------------------:|:--------------------------------------:|:------------------------------------:|:------------------------------------------:|
| "leise schnurrend" | 8 Cores, 1.21GHZ, 16GB RAM, 256GB HDD  | 4 Cores, 1.21GHZ, 8GB RAM, 256GB HDD |   8 Cores, 1.21GHZ, 24GB RAM, 1000GB HDD   |
|    "viel Wumms"    | 16 Cores, 4.2GHZ, 32GB RAM, 2000GB SSD | 8 Cores, 2.4GHZ, 16GB RAM, 256GB SSD | 42 Cores, 9.001GHZ, 128GB RAM, 10000GB SSD |
