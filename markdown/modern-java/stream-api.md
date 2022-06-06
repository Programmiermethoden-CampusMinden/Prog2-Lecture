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

::: notes
Es wurden Studis, Studiengänge und Fachbereiche modelliert (aus Gründen der Übersichtlichkeit
einfach als Record-Klassen):

```java
public record Studi(String name, int credits) {}

public record Studiengang(String name, List<Studi> studis) {}

public record Fachbereich(String name, List<Studiengang> studiengaenge) {}
```

Nun soll pro Fachbereich die Anzahl der Studis ermittelt werden, die bereits 100 ECTS
oder mehr haben. Dazu könnte man über alle Studiengänge im Fachbereich iterieren, und
in der inneren Schleife über alle Studis im Studiengang. Dann filtert man alle Studis,
deren ECTS größer 100 sind und erhöht jeweils den Zähler:
:::


```java
private static long getCountFB(Fachbereich fb) {
    long count = 0;
    for (Studiengang sg : fb.studiengaenge()) {
        for (Studi s : sg.studis()) {
            if (s.credits() > 100) count += 1;
        }
    }
    return count;
}
```

::: notes
Dies ist ein Beispiel, welches klassisch in OO-Manier als Iteration über Klassen
realisiert ist. (Inhaltlich ist es vermutlich nicht sooo sinnvoll.)
:::


## Beispiel mit Streams

```java
private static long getCountSG(Studiengang sg) {
    return sg.studis().stream()
                      .map(Studi::credits)
                      .filter(c -> c > 100)
                      .count();
}

private static long getCountFB2(Fachbereich fb) {
    long count = 0;
    for (Studiengang sg : fb.studiengaenge()) {
        count += getCountSG(sg);
    }
    return count;
}
```

::::::::: notes
### Erklärung des Beispiels

Im Beispiel wurde die innere Schleife in einen Stream ausgelagert.

Mit der Methode `Collection#stream()` wird aus der Collection ein
neuer Stream erzeugt. Auf diesem wird für jedes Element durch die
Methode `map()` die Methode `Studi#credits()` angewendet, was aus
einem Strom von `Studi` einen Strom von `Integer` macht. Mit `filter`
wird auf jedes Element das Prädikat `c -> c > 100` angewendet und
alle Elemente aus dem Strom entfernt, die der Bedingung nicht
entsprechen. Am Ende wird mit `count()` gezählt, wie viele Elemente
im Strom enthalten sind.

### Was ist ein Stream?

Ein "Stream" ist ein Strom (Folge) von Daten oder Objekten. In Java wird
die Collections-API für die Speicherung von Daten (Objekten) verwendet.
Die Stream-API dient zur Iteration über diese Daten und entsprechend
zur Verarbeitung der Daten. In Java speichert ein Stream keine Daten.

Das Konzept kommt aus der funktionalen Programmierung und wurde in Java
nachträglich eingebaut (wobei dieser Prozess noch lange nicht abgeschlossen
zu sein scheint).

In der funktionalen Programmierung kennt man die Konzepte "map", "filter"
und "reduce": Die Funktion "map" erhält als Parameter eine Funktion und
wendet diese  auf alle Elemente eines Streams an. Die Funktion "filter"
bekommt ein Prädikat als Parameter und prüft jedes Element im Stream, ob
es dem Prädikat genügt (also ob das Prädikat mit dem jeweiligen Element
zu `true` evaluiert). Mit "reduce" kann man Streams zu einem einzigen
Wert zusammenfassen (denken Sie etwas an das Aufsummieren aller Elemente
eines Integer-Streams). Zusätzlich kann man in der funktionalen Programmierung
ohne Probleme unendliche Ströme darstellen: Die Auswertung erfolgt nur bei
Bedarf und auch dann nur so weit wie nötig. Dies nennt man auch "_lazy evaluation_".

Die Streams in Java versuchen, diese Konzepte aus der funktionalen Programmierung
in die objektorientierte Programmierung zu übertragen. Ein Stream in Java
hat eine Datenquelle, von wo die Daten gezogen werden - ein Stream speichert
selbst keine Daten. Es gibt "intermediäre Operationen" auf einem Stream,
die die Elemente verarbeiten. Allerdings werden diese Operationen erst durchgeführt,
wenn eine "terminale Operation" den Stream "abschließt". Ein Stream ohne ein
terminale Operation macht also tatsächlich _nichts_.

Die Operationen auf dem Stream sind üblicherweise zustandslos, können aber
durchaus auch einen Zustand haben. Dies verhindert üblicherweise die parallele
Verarbeitung der Streams. Operationen sollten aber nach Möglichkeit keine
_Seiteneffekte_ haben, d.h. keine Daten außerhalb des Streams modifizieren.
Operationen dürfen auf keinen Fall die Datenquelle des Streams modifizieren!
:::::::::


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
