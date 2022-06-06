---
type: lecture-cg
title: "Stream-API"
menuTitle: "Stream-API"
author: "Carsten Gips (FH Bielefeld)"
weight: 4
readings:
  - key: "LernJava"
    comment: "Tutorials > The Stream API"
  - key: "Ullenboom2021"
    comment: "Kap. 17.3 - 17.6: Java Stream-API"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k2: ""
  - k3: ""
quizzes:
  - link: ""
    name: "Quiz XXX (ILIAS)"
assignments:
  - topic: sheet09
youtube:
  - link: ""
    name: "VL Stream-API"
  - link: ""
    name: "Demo Stream-API"
  - link: ""
    name: "Demo Stream-API"
fhmedia:
  - link: ""
    name: "VL Stream-API"
---


## Motivation

Beispiel klassisch: Iteration über Datenstruktur ...


## Beispiel mit Streams

Beispiel mit Streams

Was ist ein Stream? A stream is an object that does not store any data.
FP: map/filter/reduce + lazy evaluation;
Interne vs. externe Iteration, intermediäre vs. terminale Operationen
Zustand ja/nein
Was macht ein Stream ohne terminale Operation? NICHTS ...


## Erzeugen von Streams

Erzeugen von Streams: Collection#stream(), Stream.of(1,2,3), Stream.generate( random::nextGaussian )

parallel vs. sequentiell: Collection#parallelStream(): nur nutzen, wenn tatsächlich Vorteile durch Parallelisierung zu erwarten (Parallele Streams nutzen intern das Fork-&-Join-Framework)


## Intermediäre Operationen auf Streams

Methoden auf Streams: map, filter, sorted, peek

Status vs. Status-frei: sorted und skip kann ordentlich in Speicher und Zeit zuschlagen, da es einen Zustand speichern muss und u.U. nicht/nur schlecht parallelisierbar ist!
stream.parallel().sorted().skip(42) => erst alles sortieren, danach die ersten 42 überspringen ...


## Was tun, wenn eine Methode Streams zurückliefert

flatMap


## Streams abschließen: Terminale Operationen

Streams abschließen: terminale Operationen: count(), forEach(), findFirst, allMatch/anyMatch/noneMatch, sum, min/max, collect, (reduce)


## Anti-Pattern

-   Operationen dürfen nicht die Stream-Quelle modifizieren
-   Operationen können die Werte im Stream ändern (map) oder filtern (filter)
-   Operationen können zustandslos sein (map, filter), oder zustandsbehaftet sein (sorted)
-   Keine Streams in Attributen/Variablen speichern oder als Argumente übergeben: Sie könnten bereits "gebraucht" sein!
    => Ein Stream sollte immer sofort nach der Erzeugung benutzt werden
-   Operationen auf einem Stream sollten keine Seiteneffekte (Veränderungen von Variablen/Attributen außerhalb des Streams) haben


## Wrap-Up
...

::: notes
Schöne Doku: ["The Stream API"](https://dev.java/learn/the-stream-api/).
:::







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
