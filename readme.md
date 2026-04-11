---
has_license: true
no_beamer: true
title: "IFM 2.1: Programmieren 2 (Sommer 2026)"
---

# Syllabus

> ... And, lastly, there's the explosive growth in demand, which has led to many
> people doing it who aren't any good at it. Code is merely a means to an end.
> **Programming is an art and code is merely its medium.** Pointing a camera at a
> subject does not make one a proper photographer. There are a lot of self-described
> coders out there who couldn't program their way out of a paper bag.
>
> `\hfill`{=tex} -- John Gruber auf
> [daringfireball.net](https://daringfireball.net/2020/04/cobol_programming_coding)

## Kursbeschreibung

Sie haben letztes Semester in **Prog1** die *wichtigsten* Elemente und Konzepte der
Programmiersprache Java kennen gelernt.

In diesem Modul geht es darum, diese Kenntnisse sowohl auf der Java- als auch auf
der Methoden-Seite so zu erweitern, dass Sie gemeinsam größere Anwendungen erstellen
und pflegen können. Sie werden fortgeschrittene Konzepte in Java kennenlernen und
sich mit etablierten Methoden in der Softwareentwicklung wie Versionierung von Code,
Einhaltung von Coding Conventions, Grundlagen des Softwaretests, Anwendung von
Refactoring, Einsatz von Build-Tools und Logging auseinander setzen. Wenn uns dabei
ein Entwurfsmuster "über den Weg läuft", werden wir die Gelegenheit nutzen und uns
dieses genauer anschauen.

## Überblick Modulinhalte

1.  Fortgeschrittene Konzepte in Java ("Classic Java")
    -   Reguläre Ausdrücke, Annotationen, Reflection
    -   Generische Programmierung: Generics
    -   Parallele Programmierung: Threads
    -   ~~CLI~~, ~~Konfiguration~~, fremde APIs nutzen[^1]
    -   Graphische Oberflächen mit Swing[^2]
2.  Fortgeschrittene Konzepte in Java ("FP")
    -   Default-Methoden, Funktionsinterfaces, Methodenreferenzen, Lambdas,
        Optional, Stream-API
3.  Versionierung mit Git
4.  Softwarequalität
    -   Testen, Coding Conventions & Smells, Refactoring, Javadoc, Logging
5.  Entwurfsmuster
    -   ~~Strategy~~, Template-Method, ~~Factory-Method~~, ~~Singleton~~, Observer,
        Visitor, Command, ...
6.  Bauen von Software
    -   Gradle, Docker, Continuous Integration (GitHub Workflows)

(*durchgestrichene Themen nicht im Sommersemester 2026*)

## Team

-   [Carsten
    Gips](https://www.hsbi.de/minden/ueber-uns/personenverzeichnis/carsten-gips)
    (Sprechstunde nach Vereinbarung)
-   Alesia Herbertz (Tutorin)

## Kursformat

![](admin/images/fahrplan.png){width="80%"}

| Vorlesung (2 SWS)     | Praktikum (2 SWS)         |
|:----------------------|:--------------------------|
| Mo, 08:00 - 09:30 Uhr | G1: Mo, 11:30 - 13:00 Uhr |
| (*Flipped Classroom*) | G2: Mo, 14:00 - 15:30 Uhr |
|                       | G3: Mo, 09:45 - 11:15 Uhr |
|                       | G4: Mi, 08:00 - 09:30 Uhr |

Alle Sitzungen online per Zoom (**Zugangsdaten siehe
[ILIAS](https://www.hsbi.de/elearning/goto.php/crs/1634793)**).

## Fahrplan

Hier finden Sie einen abonnierbaren [Google
Kalender](https://calendar.google.com/calendar/ical/69ecbae80c817d60571a6ec968890b9b7ef0ffea5ce5dad1ef06c46eef7c530f%40group.calendar.google.com/public/basic.ics)
mit allen Terminen der Veranstaltung zum Einbinden in Ihre Kalender-App.

| Monat | Tag  | Vorlesung                                                                                                                                                                                                                        | Praktikum              |
|:------|:-----|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-----------------------|
| April | 20\. | [Orga](readme.md)                                                                                                                                                                                                                |                        |
|       | 27\. | [Git1: Basics](lecture/git/git1-basics.md); [Gradle](lecture/tooling/gradle.md), [Packages](lecture/tooling/packages.md)                                                                                                         |                        |
| Mai   | 04\. | [Git2: Branches](lecture/git/git2-branches.md), [Git4: Worktree](lecture/git/git4-worktree.md); [JUnit1: Basics](lecture/junit/junit1-basics.md); [CI](lecture/tooling/ci.md)                                                    | [B01](homework/b01.md) |
|       | 11\. | [Lambdas](lecture/java-modern/lambdas.md), [Methodenrefs](lecture/java-modern/methodreferences.md); [Observer](lecture/pattern/observer.md), [Swing Events](lecture/gui/events.md)                                               | [B02](homework/b02.md) |
|       | 18\. | [Git3: Workflows](lecture/git/git3-workflows.md); [RegExp](lecture/java-classic/regexp.md); [Template-Method](lecture/pattern/template-method.md)                                                                                | [B03](homework/b03.md) |
|       | 25\. | **Feiertag**                                                                                                                                                                                                                     | **Feiertag**           |
| Juni  | 01\. | [ANTLR](lecture/tooling/antlr.md); [Visitor](lecture/pattern/visitor.md); [Debugging](lecture/tooling/debugging.md)                                                                                                              | [B04](homework/b04.md) |
|       | 08\. | [JUnit2: Testfälle](lecture/junit/junit2-testcases.md), [JUnit3: Mocking](lecture/junit/junit3-mockito.md); [Dependency Injection](lecture/java-classic/dependency.md), [Defaultmethoden](lecture/java-modern/defaultmethods.md) | **Kein Praktikum (Parcoursprüfung BC)**                       |
|       | 15\. | [Records](lecture/java-modern/records.md), [Pattern Matching](lecture/java-modern/patternmatching.md), [Stream-API](lecture/java-modern/stream-api.md); [JUnit4: Property Testing](lecture/junit/junit4-property.md)                                                                                                                                                                                                                                 | [B05](homework/b05.md) |
|       | 22\. | [Generics1: Klassen/Methoden](lecture/java-classic/generics1-classes-methods.md), [Generics2: Bounds & Wildcards](lecture/java-classic/generics2-bounds-wildcards.md); [Command](lecture/pattern/command.md); [Logging](lecture/tooling/)                                                                                                                                                                                                                                 | [B06](homework/b06.md) |
|       | 29\. |                                                                                                                                                                                                                                  | [B07](homework/b07.md) |
| Juli  | 06\. |                                                                                                                                                                                                                                  | [B08](homework/b08.md) |
|       | 13\. | Rückblick, [Prüfungsvorbereitung](admin/exams.md)                                                                                                                                                                                |                        |

Abgabe der Übungsblätter jeweils **bis Mo, 08:00 Uhr** [im
ILIAS](https://www.hsbi.de/elearning/goto.php/exc/1664006), Vorstellung der Lösung
im zugehörigen Praktikum. Bearbeitung der Quizzes jeweils **Mi, 00:00 Uhr (Vorwoche)
bis Mo, 08:00 Uhr** [im ILIAS](https://www.hsbi.de/elearning/goto.php/fold/1663994).

## Prüfungsform, Note und Credits

**Parcoursprüfung**, 5 ECTS (PO23)

Da Sie das Programmierhandwerk erlernen und üben und vertiefen sollen, dürfen Sie im
Rahmen dieser Lehrveranstaltung noch keine KI-gestützten Assistenten benutzen.
Lösungen, die dennoch ganz oder teilweise unter Zuhilfenahme von KI-Unterstützung
erstellt wurden, werden wie nicht abgegeben behandelt.

### Prüfung im ersten Zeitraum

1.  **Quizzes**: mind. 5 der 9 Quizzes bestanden (ohne Note/Punkte)
    (Einzelbearbeitung, fristgerecht bis zur jeweiligen Vorlesung, je Quiz bis zu 3x
    wiederholbar, 60% pro Quiz zum Bestehen nötig)
2.  **Praktikum**: mind. 5 der 9 Übungsblätter bestanden (ohne Note/Punkte) (bis zu
    3er Teams, alle Aufgaben eines Blattes bearbeitet, individuelle(!) fristgerechte
    Abgabe der Lösungen im ILIAS als aussagekräftiges [*Post
    Mortem*](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/981)[^3],
    Vorstellung der Lösungen im Praktikum durch jedes Teammitglied, aktive
    Beteiligung an der Diskussion im Praktikum)
3.  **Station I**: ILIAS-Test (30 Minuten in Minden im B40)
4.  **Station II**: ILIAS-Test (30 Minuten in Minden im B40)
5.  **Station III**: ILIAS-Test (30 Minuten in Minden im B40)

Station I und II finden im Vorlesungsslot statt ([Aufteilung siehe separate
Ankündigung](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/1025)),
Station III im ersten Prüfungszeitraum (Termin lt. Bekanntgabe vom Prüfungsamt: Mi,
09.07., [Aufteilung siehe separate
Ankündigung](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/1032)).
Die Punkte der beiden besseren Stationen werden summiert bzw. es wird der Mittelwert
der beiden besten prozentualen Ergebnisse ermittelt zur die Berechnung der Note.[^4]

**Gesamtnote**: 4.0: ab 50%, alle 5% nächste Teilnote, 1.0: ab 95% (jeweils nur wenn
Quizzes bestanden und Praktikum bestanden)

Bei mind. drei über das Minimum hinaus bestandenen Quizzes und/oder Aufgabenblättern
verbessert sich die Gesamtnote um eine Teilnote.

(Hinweise zur [Prüfungsvorbereitung](admin/exams.md) für Station I bis III)

### Prüfung im zweiten Zeitraum

1.  **Station IV**: Schriftliche Prüfung (digitale Klausur) 90 Minuten in Minden im
    B40 (Termin lt. Bekanntgabe vom Prüfungsamt: voraussichtlich 24.09.)

**Gesamtnote**: 4.0: ab 50%, alle 5% nächste Teilnote, 1.0: ab 95%

(Hinweise zur [Prüfungsvorbereitung](admin/exams.md) für Station IV)

## Materialien

### Literatur

1.  ["**Java ist auch eine
    Insel**"](https://openbook.rheinwerk-verlag.de/javainsel/index.html). Ullenboom,
    C., Rheinwerk-Verlag, 2021. ISBN
    [978-3-8362-8745-6](https://fhb-bielefeld.digibib.net/openurl?isbn=978-3-8362-8745-6).
2.  ["**Pro Git** (Second Edition)"](https://git-scm.com/book/en/v2). Chacon, S. und
    Straub, B., Apress, 2014. ISBN
    [978-1-4842-0077-3](https://fhb-bielefeld.digibib.net/openurl?isbn=978-1-4842-0077-3).
3.  ["The Java Tutorials"](https://docs.oracle.com/javase/tutorial/). Oracle
    Corporation, 2024.
4.  ["Learn Java"](https://dev.java/learn/). Oracle Corporation, 2026.

### Tools

-   JDK: **Java SE 21 (LTS)**
    ([Oracle](https://www.oracle.com/java/technologies/downloads/) oder
    [Alternativen](https://code.visualstudio.com/docs/languages/java#_install-a-java-development-kit-jdk),
    bitte 64-bit Version nutzen)
-   IDE: [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/) oder
    [IntelliJ IDEA (Community Edition)](https://www.jetbrains.com/idea/) oder
    [Visual Studio Code](https://code.visualstudio.com/) oder
    [Vim](https://www.vim.org/) oder ...
-   [Git](https://git-scm.com/)

## Förderungen und Kooperationen

### Förderung durch DH.NRW (Digi Fellowships)

Die Überarbeitung dieser Lehrveranstaltung wurde vom Ministerium für Kultur und
Wissenschaft (MKW) in NRW im Einvernehmen mit der Digitalen Hochschule NRW (DH.NRW)
gefördert: ["Fellowships für Innovationen in der digitalen
Hochschulbildung"](https://www.dh.nrw/kooperationen/Digi-Fellows-2) (*Digi
Fellowships*).

### Kooperation mit dem DigikoS-Projekt

Diese Vorlesung wurde vom Projekt ["Digitalbaukasten für kompetenzorientiertes
Selbststudium"](https://www.digikos.de) (*DigikoS*) unterstützt. Ein vom
DigikoS-Projekt ausgebildeter Digital Learning Scout hat insbesondere die
Koordination der digitalen Gruppenarbeiten, des Peer-Feedbacks und der
Postersessions in ILIAS technisch und inhaltlich begleitet. DigikoS wird als
Verbundprojekt von der Stiftung Innovation in der Hochschullehre gefördert.

------------------------------------------------------------------------------------

## LICENSE

![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, [this
work](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture) by [Carsten
Gips](https://github.com/cagix) and
[contributors](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/graphs/contributors)
is licensed under [CC BY-SA
4.0](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/LICENSE.md).
See the
[credits](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/CREDITS.md)
for a detailed list of contributing projects.

[^1]: als Teilaufgabe im Praktikum

[^2]: nur als Wiederholung im Praktikum

[^3]: **Post Mortem**: Jede Person beschreibt in der ILIAS-Abgabe individuell(!) die
    Bearbeitung des jeweiligen Aufgabenblattes zurückblickend mit 200 bis 400
    Wörtern. Gehen Sie dabei aussagekräftig und nachvollziehbar auf folgende Punkte
    ein: (a) Zusammenfassung: Was wurde gemacht? (b) Implementierungsdetails: Kurze
    Beschreibung besonders interessanter Aspekte der Umsetzung. (c) Was war der
    schwierigste Teil bei der Bearbeitung? Wie haben Sie dieses Problem gelöst? (d)
    Was haben Sie gelernt oder (besser) verstanden? (e) Team: Mit wem haben Sie
    zusammengearbeitet? (f) Links zu Ihren Pull-Requests mit der Lösung (erst ab
    Blatt 04). Siehe auch
    https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/981.

[^4]: Wenn die Maximalzahl der Punkte für Station I, II und III identisch ist, wird
    einfach die Summe der Punkte der beiden besseren Stationen berechnet und für die
    Bildung der Gesamtnote genutzt. Wenn die Maximalzahl der Punkte für Station I,
    II und III voneinander abweicht, dann wird jeweils das erreichte prozentuale
    Ergebnis berechnet und die Gesamtnote über den Mittelwert der beiden besseren
    Ergebnisse berechnet.
