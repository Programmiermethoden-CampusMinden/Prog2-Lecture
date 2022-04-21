---
type: lecture-cg
title: "Coding Conventions und Metriken"
menuTitle: "Coding Conventions"
author: "Carsten Gips (FH Bielefeld)"
weight: 5
readings:
  - key: "Martin2009"
  - key: "Inden2013"
    comment: "Kapitel 13: Programmierstil und Coding Conventions"
  - key: "googlestyleguide"
tldr: |
  Code entsteht nicht zum Selbstzweck, er muss von anderen Menschen leicht verstanden und
  gewartet werden können: Entwickler verbringen einen wesentlichen Teil ihrer Zeit mit dem
  **Lesen** von (fremdem) Code. Dabei helfen "Coding Conventions", die eine gewisse einheitliche
  äußerliche Erscheinung des Codes vorgeben (Namen, Einrückungen, ...). Die Beachtung von
  grundlegenden Programmierprinzipien hilft ebenso, die Lesbarkeit und Verständlichkeit zu
  verbessern.

  Metriken zur Überwachung der Einhaltung

  *   Coding Conventions
    *   Regeln zu Schreibweisen und Layout
    *   Leerzeichen, Einrückung, Klammern
    *   Zeilenlänge, Umbrüche
    *   Kommentare

  *   Metriken: Einhaltung von Regeln in Zahlen ausdrücken
  *   Prüfung manuell durch Code Reviews oder durch Tools, zB. Checkstyle

outcomes:
  - k2: "Erklären verschiedener Coding Conventions"
  - k2: "Erklären wichtiger Grundregeln des objektorientierten Designs"
  - k2: "Erklären der Metriken NCSS, McCabe, BEC, DAC"
  - k3: "Einhalten der wichtigsten Grundregeln des objektorientierten Designs"
  - k3: "Nutzung des Tools Checkstyle (Standalone, Eclipse-Plugin, Konfiguration)"
quizzes:
  - link: "XYZ"
    name: "Quiz XXX (ILIAS)"
assignments:
  - topic: sheet05
youtube:
  - link: ""
    name: "VL Coding Conventions"
  - link: ""
    name: "Demo "
  - link: ""
    name: "Demo "
fhmedia:
  - link: ""
    name: "VL Coding Conventions"
sketch: true
---


## Coding Conventions

=> Andere Programmierer sollen Code schnell lesen können

\smallskip

*   Richtlinien für einheitliches Aussehen
    *   Namen, Schreibweisen
    *   Kommentare (Ort, Form, Inhalt)
    *   Einrückungen und Spaces vs. Tabs
    *   Zeilenlängen, Leerzeilen
    *   Klammern

\bigskip

*   Beispiele: [Sun Code Conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf),
    [Google Java Style](https://google.github.io/styleguide/javaguide.html)

[Beispiel: Google Java Style; Hinweis auf Formatter]{.bsp}


## Programmierprinzip "Prinzip der minimalen Verwunderung"

*   Klassen und Methoden sollten sich erwartungsgemäß verhalten
*   Gute Namen ersparen das Lesen der Dokumentation

\bigskip

```java
// Schlechtes Beispiel
public class Studi extends Person {
    public String n;
    public int c;

    public void prtIf() { ... }
}
```


## Programmierprinzip "Kapselung/Information Hiding"

*   Möglichst schlanke öffentliche Schnittstelle \newline
    => "Vertrag" mit Nutzern der Klasse!

\bigskip

```java
// Schlechtes Beispiel
public class Studi extends Person {
    public String n;
    public int c;

    public void prtIf() { ... }
}
```


## Programmierprinzip "DRY": "Don't repeat yourself!"

*   Kein duplizierter Code!

\bigskip

```java
// Schlechtes Beispiel
public class Studi {
    public String getName() { return name; }
    public String getAddress() {
        return strasse+", "+plz+" "+stadt;
    }

    public String getStudiAsString() {
        return name+" ("+strasse+", "+plz+" "+stadt+")";
    }
}
```


## Programmierprinzip "Single Responsibility"

Jede Klasse ist für genau [einen Aspekt]{.alert} des Gesamtsystems verantwortlich

\bigskip

```java
public class Student {
    private String name;
    private String phoneAreaCode;
    private String phoneNumber;

    public void printStudentInfo() {
        System.out.println("name:    " + name);
        System.out.println("contact: " + phoneAreaCode + "/" + phoneNumber);
    }
}
```

::: notes
Warum sollte sich die Klasse `Student` um die Einzelheiten des Aufbaus einer
Telefonnummer kümmern? Das Prinzip der "_Single Responsibility_" wird hier
verletzt!
:::


## Metriken: Kennzahlen für verschiedene Aspekte zum Code

*   Einhaltung der Coding Rules
*   Beachtung der Regeln des objektorientierten Entwurfs


## Beispiele für wichtige Metriken (jeweils max-Werte)

*   **NCSS** (_Non Commenting Source Statements_)
    *   Zeilen pro Methode: 50; pro Klasse: 500; pro Datei: 600 \newline
        _Annahme_: Eine Anweisung je Zeile ...
*   **Anzahl der Methoden** pro Klasse: 10
*   **Parameter** pro Methode: 3
*   **BEC** (_Boolean Expression Complexity_) \newline
    Anzahl boolescher Ausdrücke in `if` etc.: 3
*   **McCabe** (_Cyclomatic Complexity_)
    *   Anzahl der möglichen Verzweigungen (Pfade) pro Methode
    *   1-4 gut, 5-7 noch OK
*   **DAC** (_Class Data Abstraction Coupling_)
    *   Anzahl der genutzten (instantiierten) "Fremdklassen"
    *   Werte kleiner 7 werden i.A. als normal betrachtet

::: notes
Die obigen Grenzwerte sind vorgeschlagene Standardwerte, die sich in der Praxis
allgemein bewährt haben (u.a. nach [@Martin2009]). Dennoch sind das keine absoluten
Werte an sich, sondern müssen an das konkrete Projekt angepasst werden. Ein
Übertreten der Grenzen ist ein **Hinweis** darauf, das **höchstwahrscheinlich**
etwas nicht stimmt, muss aber im konkreten Fall hinterfragt und diskutiert werden!
:::

\bigskip

=> Verweis auf LV Softwareengineering


## Tool-Support

Metriken werden sinnvollerweise durch diverse Tools erfasst.

*   **Checkstyle** [([Standalone via Ant](https://github.com/checkstyle/checkstyle) und Plugin für
    [Eclipse](https://github.com/checkstyle/eclipse-cs) oder [IntelliJ](https://github.com/jshiell/checkstyle-idea))]{.notes}
*   Alternativen/Ergänzungen: [Metrics](http://metrics.sourceforge.net/),
    [MetricsReloaded](https://github.com/BasLeijdekkers/MetricsReloaded),
    [FindBugs/SpotBugs](https://github.com/spotbugs/spotbugs), ...

[Beispiel: Konfiguration Eclipse-Checkstyle, Hinweis auf Formatter]{.bsp}


## Wrap-Up


*   Code entsteht nicht zum Selbstzweck => Regeln nötig!
    *   Coding Conventions

        ::: notes
        *   Regeln zu Schreibweisen und Layout
        *   Leerzeichen, Einrückung, Klammern
        *   Zeilenlänge, Umbrüche
        *   Kommentare
        :::

    *   Prinzipien des objektorientierten Programmierens

        ::: notes
        *   Jede Klasse ist für genau **einen** Aspekt des Systems verantwortlich.
            (_Single Responsibility_)
        *   Keine Code-Duplizierung! (_DRY_ - Don't repeat yourself)
        *   Klassen und Methoden sollten sich erwartungsgemäß verhalten
        *   Kapselung: Möglichst wenig öffentlich zugänglich machen
        :::

\bigskip

*   Metriken: Einhaltung von Regeln in Zahlen ausdrücken
*   Prüfung manuell durch Code Reviews oder durch Tools, zB. Checkstyle







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

\bigskip

### Exceptions
*   TODO
:::
