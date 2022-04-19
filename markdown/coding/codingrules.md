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
  TODO

  Code entsteht nicht zum Selbstzweck => Regeln nötig!

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
  - k2: "Erklären der Metriken NCSS, McCabe, BEC, DAC"
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
---


## Bad Smells: Nichtbeachtung von Coding Conventions

*   Richtlinien für einheitliches Aussehen
    => Andere Programmierer sollen Code schnell lesen können
    *   Namen, Schreibweisen
    *   Kommentare (Ort, Form, Inhalt)
    *   Einrückungen und Spaces vs. Tabs
    *   Zeilenlängen, Leerzeilen
    *   Klammern

\smallskip

*   Beispiele: [Sun Code Conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf),
    [Google Java Style](https://google.github.io/styleguide/javaguide.html)

\bigskip

*   *Hinweis*: Betrifft vor allem die (äußere) Form!

[Beispiel: Google Java Style; Hinweis auf Formatter]{.bsp}


## Metriken: Kennzahlen für verschiedene Aspekte zum Code

*   Einhaltung der Coding Rules
*   Beachtung der Regeln des objektorientierten Entwurfs


## Beispiele für wichtige Metriken (jeweils max-Werte)

*   **NCSS** (*Non Commenting Source Statements*)
    *   Zeilen pro Methode: 50; pro Klasse: 500; pro Datei: 600 \newline
        *Annahme*: Eine Anweisung je Zeile ...
*   **Anzahl der Methoden** pro Klasse: 10
*   **Parameter** pro Methode: 3
*   **BEC** (*Boolean Expression Complexity*) \newline
    Anzahl boolescher Ausdrücke in `if` etc.: 3
*   **McCabe** (Cyclomatic Complexity)
    *   Anzahl der möglichen Verzweigungen (Pfade) pro Methode
    *   1-4 gut, 5-7 noch OK
*   **DAC** (*Class Data Abstraction Coupling*)
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

    *   Prinzipien des objektorientierten Design

        ::: notes
        *   Jede Klasse ist für genau **einen** Aspekt des Systems verantwortlich.
            (*Single Responsibility*)
        *   Keine Code-Duplizierung! (*DRY* - Don't repeat yourself)
        *   Klassen und Methoden sollten sich erwartungsgemäß verhalten.
        *   Kapselung: Möglichst wenig öffentlich zugänglich machen.
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
