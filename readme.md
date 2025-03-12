---
archetype: "home"
title: "IFM 2.1: Programmieren 2 (PO23, Sommer 2024)"
---


> ... And, lastly, there's the explosive growth in demand, which has led to many
> people doing it who aren't any good at it. Code is merely a means to an end.
> **Programming is an art and code is merely its medium.**
> Pointing a camera at a subject does not make one a proper photographer. There are
> a lot of self-described coders out there who couldn't program their way out of a
> paper bag.
>
> \hfill -- John Gruber auf [daringfireball.net](https://daringfireball.net/2020/04/cobol_programming_coding)


## Kursbeschreibung

Sie haben letztes Semester in **Prog1** die _wichtigsten_ Elemente und Konzepte der
Programmiersprache Java kennen gelernt.

In diesem Modul geht es darum, diese Kenntnisse sowohl auf der Java- als auch auf der
Methoden-Seite so zu erweitern, dass Sie gemeinsam größere Anwendungen erstellen und
pflegen können. Sie werden fortgeschrittene Konzepte in Java kennenlernen und sich mit
etablierten Methoden in der Softwareentwicklung wie Versionierung von Code, Einhaltung
von Coding Conventions, Grundlagen des Softwaretests, Anwendung von Refactoring, Einsatz
von Build-Tools und Logging auseinander setzen. Wenn uns dabei ein Entwurfsmuster "über
den Weg läuft", werden wir die Gelegenheit nutzen und uns dieses genauer anschauen.


## Überblick Modulinhalte

1.  Fortgeschrittene Konzepte in Java
    *   Funktionale Programmierung: Default-Methoden, Funktionsinterfaces, Methodenreferenzen, Lambdas, Stream-API
    *   Generische Programmierung: Generics
    *   Parallele Programmierung: Threads
    *   Reguläre Ausdrücke, ~~Annotationen~~, ~~Reflection~~
    *   CLI, Konfiguration, fremde APIs nutzen
    *   ~~Graphische Oberflächen mit Swing~~
2.  Fortgeschrittenes OO-Design
    *   Entwurfsmuster: ~~Strategy~~, Template-Method, ~~Factory-Method~~, ~~Singleton~~, Observer, Visitor, Command, ...
3.  Programmiermethoden
    *   Versionskontrolle: Git
    *   Testen, Coding Conventions, Refactoring
    *   Logging, Build-Tools, CI

(_durchgestrichene Themen nicht im Sommersemester 2024_)


## Team

*   [Carsten Gips](https://www.hsbi.de/minden/ueber-uns/personenverzeichnis/carsten-gips) (Sprechstunde nach Vereinbarung)
*   Tutoren (siehe ILIAS-Mitgliederliste)


## Kursformat

![](admin/images/fahrplan.png){width="80%"}

:::::: {.tabs groupid="vl-pr"}
::: {.tab title="Vorlesung"}

**Vorlesung (2 SWS)**

Mi, 08:00 - 09:30 Uhr (online)

Durchführung als **Flipped Classroom**.

:::
::: {.tab title="Praktikum"}

**Praktikum (2 SWS)**

| Praktikumsgruppe | Zeit                  | Raum   |
|:-----------------|:----------------------|:-------|
| Gruppe 1         | Mi, 11:30 - 13:00 Uhr | online |
| Gruppe 2         | Mi, 09:45 - 11:15 Uhr | D320   |
| Gruppe 3         | Mi, 09:45 - 11:15 Uhr | online |
| Gruppe 4         | Mi, 11:30 - 13:00 Uhr | D320   |

Praktika Gruppen 2 und 4 in **Präsenz**.

:::
::::::

Online-Sitzungen per Zoom (**Zugangsdaten siehe [ILIAS]**).
Sie _können_ hierzu den Raum J104 nutzen.

[ILIAS]: https://www.hsbi.de/elearning/goto.php?target=crs_1337540&client_id=FH-Bielefeld


## Fahrplan

`{{% notice style="note" title="News" %}}`{=markdown}
Die nächste Klausur für "Programmieren 2" (IFM 2.1, PO23) wird am **Mittwoch, 02. Oktober 2024**
angeboten. Die Klausur wird als digitale Klausur auf dem Prüfungs-ILIAS der HSBI in Präsenz vor Ort
in **Minden im Raum B40** durchgeführt. Die Prüfung beginnt um **08:00 Uhr und dauert 90 Minuten**.
Ein DIN-A4-Zettel ist als Hilfsmittel zugelassen. Der geprüfte Stoff bezieht sich auf den zuletzt
durchgeführten Kurs (Sommer 2024). Weitere Informationen siehe [Prüfungsvorbereitung].
`{{% /notice %}}`{=markdown}

Hier finden Sie einen abonnierbaren [Google Kalender] mit allen Terminen der Veranstaltung zum Einbinden in Ihre Kalender-App.

[**Bitte geben Sie uns Feedback: Nehmen Sie bitte an der [anonymen Umfrage zu "Programmieren 2"](https://www.hsbi.de/elearning/goto.php?target=svy_1394428&client_id=FH-Bielefeld) teil.**]{.alert}

| Monat | Tag   | Vorlesung                                                                                         | Praktikum        |
|:------|:------|:--------------------------------------------------------------------------------------------------|:-----------------|
| April | 17.   | Orga (**Zoom**), [FAQ]                                                                            |                  |
|       | 24.   | Generics: [Klassen und Methoden], [Bounds und Wildcards], [Type Erasure], [Polymorphie]; [Gradle] | [B01]            |
| Mai   | 01.   | **Mai-Feiertag**                                                                                  | **Mai-Feiertag** |
|       | 08.   | [Einführung Versionierung], [Git Basics]; [Lambda-Ausdrücke]; [Javadoc]                           | [B02]            |
|       | 15.   | **Dienstbesprechung**                                                                             | [B03]            |
|       | 22.   | [Git-Branches], [Branching-Strategien]; [Methodenreferenzen]; [Logging]                           | [B04]            |
|       | 29.   | [Git-Remotes], [Git-Workflows]; [Stream-API]; [Record-Klassen]; [Intro Dungeon]                   | [B05]            |
| Juni  | 05.   | [Einführung Testen], [JUnit-Basics]; [Optional]; [Visitor-Pattern]                                | [B06]            |
|       | 12.   | [Testfallermittlung], [Mocking]; [Default-Methoden]; [Observer-Pattern]; [Serialisierung]         | [B07]            |
|       | 19.   | [Code-Smells], [Coding-Rules], [Refactoring]; [Continuous Integration (CI)]                       | [B08]            |
|       | 26.   | [RegExp]; [Template-Method-Pattern], [Command-Pattern]; [Enumerationen]                           | [B09]            |
| Juli  | 03.   | [Intro Threads], [Synchronisierung], [Highlevel Threadkonzepte]; [Konfiguration]                  | [B10]            |
|       | 10.   | Rückblick (**Zoom**), [Prüfungsvorbereitung]                                                      |                  |
|       | _tbd_ | Klausur (Campus Minden, B40)                                                                      |                  |

Abgabe der Übungsblätter jeweils **bis 08:00 Uhr** [im ILIAS](https://www.hsbi.de/elearning/goto.php?target=exc_1356670&client_id=FH-Bielefeld).


[Google Kalender]: https://calendar.google.com/calendar/ical/5121604486803dcdb5cfaa8602b8b09ce76743d8b9216795606617cac807e595%40group.calendar.google.com/public/basic.ics

[Prüfungsvorbereitung]: admin/exams.md
[FAQ]: https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/categories/q-a

[Gradle]: lecture/building/gradle.md
<!-- [ANT]: lecture/building/ant.md -->
<!-- [Maven]: lecture/building/maven.md -->
[Continuous Integration (CI)]: lecture/building/ci.md
<!-- [Docker]: lecture/building/docker.md -->

[Javadoc]: lecture/coding/javadoc.md
[Logging]: lecture/coding/logging.md
[Code-Smells]: lecture/coding/smells.md
[Coding-Rules]: lecture/coding/codingrules.md
[Refactoring]: lecture/coding/refactoring.md

<!-- [Intro Frameworks]: lecture/frameworks/intro-frameworks.md -->
[Intro Dungeon]: lecture/frameworks/dungeon.md

[Klassen und Methoden]: lecture/generics/classes-methods.md
[Bounds und Wildcards]: lecture/generics/bounds-wildcards.md
[Type Erasure]: lecture/generics/type-erasure.md
[Polymorphie]: lecture/generics/generics-polymorphism.md

[Einführung Versionierung]: lecture/git/git-intro.md
[Git Basics]: lecture/git/git-basics.md
[Git-Branches]: lecture/git/branches.md
[Branching-Strategien]: lecture/git/branching-strategies.md
[Git-Remotes]: lecture/git/remotes.md
[Git-Workflows]: lecture/git/workflows.md
<!-- [Git-Worktree]: lecture/git/worktree.md -->
<!-- [Git-Bisect]: lecture/git/bisect.md -->

<!-- [Swing Basics]: lecture/gui/swing-basics.md -->
<!-- [Swing Widgets]: lecture/gui/widgets.md -->
<!-- [Layout Manager]: lecture/gui/layouts.md -->
<!-- [Swing Events]: lecture/gui/events.md -->
<!-- [Swing: Tabellen]: lecture/gui/tables.md -->
<!-- [Java2D]: lecture/gui/java2d.md -->

[Serialisierung]: lecture/java-jvm/serialisation.md
<!-- [Collections]: lecture/java-jvm/collections.md -->
[RegExp]: lecture/java-jvm/regexp.md
<!-- [Annotationen]: lecture/java-jvm/annotations.md -->
<!-- [Reflection]: lecture/java-jvm/reflection.md -->
<!-- [Exception-Handling]: lecture/java-jvm/exceptions.md -->
[Enumerationen]: lecture/java-jvm/enums.md
[Konfiguration]: lecture/java-jvm/configuration.md

[Lambda-Ausdrücke]: lecture/modern-java/lambdas.md
[Methodenreferenzen]: lecture/modern-java/methodreferences.md
[Stream-API]: lecture/modern-java/stream-api.md
[Optional]: lecture/modern-java/optional.md
[Record-Klassen]: lecture/modern-java/records.md
[Default-Methoden]: lecture/modern-java/defaultmethods.md

<!-- [Strategy-Pattern]: lecture/pattern/strategy.md -->
[Visitor-Pattern]: lecture/pattern/visitor.md
[Observer-Pattern]: lecture/pattern/observer.md
[Command-Pattern]: lecture/pattern/command.md
<!-- [Singleton-Pattern]: lecture/pattern/singleton.md -->
[Template-Method-Pattern]: lecture/pattern/template-method.md
<!-- [Factory-Method-Pattern]: lecture/pattern/factory-method.md -->
<!-- [Type-Object-Pattern]: lecture/pattern/type-object.md -->
<!-- [Flyweight-Pattern]: lecture/pattern/flyweight.md -->

[Einführung Testen]: lecture/testing/testing-intro.md
[JUnit-Basics]: lecture/testing/junit-basics.md
[Testfallermittlung]: lecture/testing/testcases.md
[Mocking]: lecture/testing/mockito.md

[Intro Threads]: lecture/threads/threads-intro.md
[Synchronisierung]: lecture/threads/threads-synchronisation.md
[Highlevel Threadkonzepte]: lecture/threads/threads-highlevel.md

[B01]: homework/b01.md
[B02]: homework/b02.md
[B03]: homework/b03.md
[B04]: homework/b04.md
[B05]: homework/b05.md
[B06]: homework/b06.md
[B07]: homework/b07.md
[B08]: homework/b08.md
[B09]: homework/b09.md
[B10]: homework/b10.md


## Prüfungsform, Note und Credits

**Parcoursprüfung**, 5 ECTS (PO23)

:::::: {.tabs groupid="exams"}
::: {.tab title="Prüfung im ersten Zeitraum"}

*   **Stationen**:
    *   Praktikum: 10x Übungsblätter mit jeweils 1P
        (Einzelbearbeitung, mindestens 60% bearbeitet,
        fristgerechte Abgabe der Lösungen im ILIAS,
        Vorstellung der Lösungen im Praktikum => Punkte)
    *   Schriftliche Prüfung (digitale Klausur) mit 100P;
        [Prüfungsvorbereitung]
*   **Gesamtnote**: 4.0: ab 50P, alle 5P nächste Teilnote, 1.0: ab 95P

:::
::: {.tab title="Prüfung im zweiten Zeitraum"}

*   **Stationen**:
    *   Schriftliche Prüfung (digitale Klausur) mit 100P;
        [Prüfungsvorbereitung]
*   **Gesamtnote**: 4.0: ab 50P, alle 5P nächste Teilnote, 1.0: ab 95P

:::
::::::


## Materialien

### Literatur

1.  ["**Java ist auch eine Insel**"](https://openbook.rheinwerk-verlag.de/javainsel/index.html).
    Ullenboom, C., Rheinwerk-Verlag, 2021.
    ISBN [978-3-8362-8745-6](https://fhb-bielefeld.digibib.net/openurl?isbn=978-3-8362-8745-6).
2.  ["**Pro Git** (Second Edition)"](https://git-scm.com/book/en/v2).
    Chacon, S. und Straub, B., Apress, 2014.
    ISBN [978-1-4842-0077-3](https://fhb-bielefeld.digibib.net/openurl?isbn=978-1-4842-0077-3).
3.  ["The Java Tutorials"](https://docs.oracle.com/javase/tutorial/).
    Oracle Corporation, 2023.
4.  ["Learn Java"](https://dev.java/learn/).
    Oracle Corporation, 2023.

### Tools

*   JDK: Java SE 21 (LTS) ([Oracle](https://www.oracle.com/java/technologies/downloads/) oder
    [Alternativen](https://code.visualstudio.com/docs/languages/java#_install-a-java-development-kit-jdk),
    bitte 64-bit Version nutzen)
*   IDE: [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/) oder
    [IntelliJ IDEA (Community Edition)](https://www.jetbrains.com/idea/) oder
    [Visual Studio Code](https://code.visualstudio.com/) oder [Vim](https://www.vim.org/) oder ...
*   [Git](https://git-scm.com/)


## Förderungen und Kooperationen

### Förderung durch DH.NRW (Digi Fellowships)

Die Überarbeitung dieser Lehrveranstaltung wurde vom Ministerium für Kultur und Wissenschaft
(MKW) in NRW im Einvernehmen mit der Digitalen Hochschule NRW (DH.NRW) gefördert:
["Fellowships für Innovationen in der digitalen Hochschulbildung"] (_Digi Fellowships_).

["Fellowships für Innovationen in der digitalen Hochschulbildung"]: https://www.dh.nrw/kooperationen/Digi-Fellows-2

### Kooperation mit dem DigikoS-Projekt

Diese Vorlesung wird zudem vom Projekt ["Digitalbaukasten für kompetenzorientiertes Selbststudium"]
(_DigikoS_) unterstützt. Ein vom DigikoS-Projekt ausgebildeter Digital Learning Scout hat
insbesondere die Koordination der digitalen Gruppenarbeiten, des Peer-Feedbacks und der
Postersessions in ILIAS technisch und inhaltlich begleitet. DigikoS wird als Verbundprojekt
von der Stiftung Innovation in der Hochschullehre gefördert.

["Digitalbaukasten für kompetenzorientiertes Selbststudium"]: https://www.digikos.de







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::

