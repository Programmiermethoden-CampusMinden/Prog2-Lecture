---
type: lecture-cg
title: "Type-Object-Pattern"
menuTitle: "Type-Object"
author: "Carsten Gips (FH Bielefeld)"
weight: 8
readings:
  - key: "Nystrom2014"
    comment: "Kap. 13: Type Object"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k1: "**wuppie**"
  - k2: "*foo*"
  - k3: "fluppie"
quizzes:
  - link: "XYZ"
    name: "Quiz XXX (ILIAS)"
assignments:
  - topic: sheet01
youtube:
  - link: ""
    name: "VL "
  - link: ""
    name: "Demo "
  - link: ""
    name: "Demo "
fhmedia:
  - link: ""
    name: "VL "
---


## Motivation

Szenario: Monster-Basisklasse, davon leiten dann die Monstertypen ab und überschreiben die Methoden nach Bedarf.

Problem: Dadurch entsteht eine tiefe und verzweigte Vererbungshierarchie. Außerdem müssen für jede (noch so kleine) Änderung an den Monster-Eigenschaften viele Klassen editiert und das gesamte Projekt neu kompiliert werden.



## Folie 2

Lösung: Die Monster-Basisklasse bekommt ein Attribut, welches den Typ des Monsters bestimmt ("Type-Object"). Das könnte ein einfaches Enum sein, das in den Methoden des Monsters abgefragt wird. So kann zur Laufzeit bei der Erzeugung der Monster-Objekte durch Übergabe des Enums bestimmt werden, was genau dieses konkrete Monster genau ist bzw. wie es sich verhält.


## Folie 3

Schritt 2: Statt des Enums nimmt man eine "echte" Klasse mit Methoden. Davon legt man zur Laufzeit Objekte an und bestückt damit die instantiierten Monster. Im Monster selbst rufen die Monster-Methoden dann einfach nur die Methoden des Type-Objects auf (Delegation, also quasi Strategie-Pattern). Vorteil: Änderungen erfolgen bei der Parametrisierung der Objekte (an einer Stelle im Code, vermutlich main() oder eben eine Konfig-Datei).


## Folie 4

Schritt 3: Es wäre ganz nett, wenn man das Hantieren mit dem Type-Object außerhalb der Monsterklasse weglassen könnte. Also baut man der Klasse des Type-Objects eine Fabrikmethode ein, die ein Monster zurückliefert (mit dem passenden Type-Object).


## Folie 5

Schritt 4: Es wäre hilfreich, wenn die Type-Objects Eigenschaften untereinander teilen/weitergeben könnten. Damit man aber jetzt nicht hier eine tiefe Vererbungshierarchie aufbaut und damit wieder am Anfang des Problems wäre, baut man die Vererbung quasi selbst ein über eine Referenz auf ein Eltern-Type-Object. Damit kann man zur Laufzeit einem Type-Objekt sagen, dass es bestimmte Eigenschaften von einem anderen Type-Objekt übernehmen soll und dann damit ein Monster "bestücken".

## Folie 6

Schritt 5: Die Konfiguration dieser Parameter legt man in einer Konfig-Datei ab, die vom Programm eingelesen wird. Damit muss am Code nichts mehr geändert werden und auch das Programm nicht mehr neu kompiliert werden, wenn man mal andere Eigenschaften ausprobieren oder Werte ändern möchte.


## Wrap-Up

Ziel: Anzahl der Klassen zu minimieren, indem die Typen in unser eigenes Objekt-Modell gehoben werden
Anmerkung: Große Ähnlichkeit zum Flyweight-Pattern, aber Ziele unterschiedlich: Hier Anzahl der Klassen minimieren, dort Effizienz erhöhen durch gemeinsam genutzte Objekte.

...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
