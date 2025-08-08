---
author: Carsten Gips (HSBI)
title: Factory-Method-Pattern
---

::: tldr
Oft ist es wünschenswert, dass Nutzer nicht direkt Objekte von bestimmten Klassen anlegen (können). Hier kann eine
"Fabrik-Methode" (**Factory-Method**) helfen, der man die gewünschten Parameter übergibt und die daraus dann das
passende Objekt (der richtigen Klasse) erzeugt und zurückliefert.

Dadurch erreicht man eine höhere Entkoppelung, die Nutzer müssen nur noch das Interface oder die abstrakte Klasse, also
den Obertyp des Ergebnisses kennen. Außerdem lassen sich so leicht die konkreten Klassen austauschen.

Dieses Entwurfsmuster kommt häufig zusammen mit dem *Singleton-Pattern* vor, wo es nur eine einzige Instanz einer Klasse
geben soll. Über eine Fabrik-Methode kann man diese Instanz ggf. erzeugen und dann die Referenz darauf zurückliefern.
:::

::: youtube
-   [VL Factory-Method-Pattern](https://youtu.be/mJWe-2BS2W0)
-   [Demo Factory-Method-Pattern](https://youtu.be/14rt1YIoiME)
:::

# Motivation: Ticket-App

-   Nutzer geben Fahrtziel an (und nicht die Ticketart!)

\bigskip

-   Ticket-App bucht passendes Ticket
    -   User muss nicht die konkreten Ticketarten kennen
    -   Ticketarten lassen sich leicht austauschen

\bigskip
\bigskip

=\> **Factory-Method-Pattern**: Objekte sollen nicht direkt durch den Nutzer erzeugt werden

# Factory-Method-Pattern

![](images/factorymethod.png){width="80%"}

# Hands-On: Ticket-App

Implementieren Sie eine Ticket-App, die verschiedene Tickets mit Hilfe des Factory-Method Entwurfsmusters generiert.

[UML; Konsole: factory.FactoryBeispiel]{.ex
href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/pattern/src/factory/FactoryBeispiel.java"}

# Wrap-Up

-   Konkrete Objekte sollen nicht direkt über Konstruktor erzeugt werden
-   (Statische) Hilfsmethode, die aus Parameter das "richtige" Objekte erzeugt

\smallskip

-   Vorteil:
    -   Nutzer kennt nur das Interface
    -   Konkrete Klassen lassen sich leicht austauschen

::: readings
-   @Eilebrecht2013
-   @Gamma2011
-   @Kleuker2018
:::

::: outcomes
-   k3: Entwurfsmuster Factory-Methode anwenden
:::

::: challenges
Ein Kunde kommt in unser Computergeschäft und möchte bei uns einen Computer bestellen. Dabei gibt er an, wie er diesen
vorwiegend nutzen möchte bzw. für welchen Zweck er gedacht ist ("*stationär*" oder "*mobil*"). Nach reichlicher
Überlegung, ob er den neuen Rechner zu Hause stehen haben möchte oder lieber keinen weiteren Rechner, egal ob "*mobil*"
oder "*stationär*", bei sich im Weg herumstehen haben will, teilt er Ihnen seine Entscheidung darüber mit ("*stationär*"
oder "*mobil*" vs. "*nicht daheim*"). Bei diesem Gespräch merkt er beiläufig an, dass es ein Rechner mit "*viel Wumms*"
sein könnte oder vielleicht doch besser etwas Kleines, was leise vor sich hin schnurrt ("*viel Wumms*" vs. "*leise
schnurrend*").

Je nach gewünschter Konfiguration soll ein den oben genannten Auswahlkriterien entsprechender Rechner mit den aus der
unten stehenden Konfigurationsmatrix zu entnehmenden Eigenschaften automatisch erzeugt werden. Die Größe des
installierten `RAM`, die Anzahl der eingebauten `CPU`-Kerne mit ihrer jeweiligen Taktrate, sowie die Art und Größe der
installierten Festplatte (`HDD` oder `SSD`) sollte dabei zu dem gewählten Paket passend gesetzt werden.

Implementieren Sie eine "Computerfabrik" (Klasse `ComputerFactory`), die Ihnen den richtig konfigurierten Rechner
zusammenbaut. Nutzen Sie dabei das "Factory-Method-Pattern" zum Erzeugen der Objekte der einzelnen Subklassen. Dabei
soll Ihre Computerfabrik anhand der ihr übergebenen Konfiguration eigenständig entscheiden, welche Art von Computer
dabei erstellt werden soll.

Implementieren Sie dazu in Ihrer Factory die Factory-Methode `buildComputer`, welche das jeweils passend konfigurierte
Objekt zurückgibt.

``` java
public class ComputerFactory {
    ...

    public static Computer buildComputer(..."stationär",..."viel Wumms") {
        ...
        return myComputer;
    }
}
```

**Konfigurationsmatrix**

|  | "stationär" (`DesktopComputer`) | "mobil" (`LaptopComputer`) | "nicht daheim" (`CloudComputer`) |
|:----------------:|:--------------------------------:|:------------------------------:|:-----------------------------------:|
| "leise schnurrend" | 8 Cores, 1.21GHZ, 16GB RAM, 256GB HDD | 4 Cores, 1.21GHZ, 8GB RAM, 256GB HDD | 8 Cores, 1.21GHZ, 24GB RAM, 1000GB HDD |
| "viel Wumms" | 16 Cores, 4.2GHZ, 32GB RAM, 2000GB SSD | 8 Cores, 2.4GHZ, 16GB RAM, 256GB SSD | 42 Cores, 9.001GHZ, 128GB RAM, 10000GB SSD |
:::
