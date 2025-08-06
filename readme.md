# IFM 2.1: Programmieren 2 (Sommer 2025)

> … And, lastly, there’s the explosive growth in demand, which has led
> to many people doing it who aren’t any good at it. Code is merely a
> means to an end. **Programming is an art and code is merely its
> medium.** Pointing a camera at a subject does not make one a proper
> photographer. There are a lot of self-described coders out there who
> couldn’t program their way out of a paper bag.
>
> – John Gruber auf
> [daringfireball.net](https://daringfireball.net/2020/04/cobol_programming_coding)

## Kursbeschreibung

Sie haben letztes Semester in **Prog1** die *wichtigsten* Elemente und
Konzepte der Programmiersprache Java kennen gelernt.

In diesem Modul geht es darum, diese Kenntnisse sowohl auf der Java- als
auch auf der Methoden-Seite so zu erweitern, dass Sie gemeinsam größere
Anwendungen erstellen und pflegen können. Sie werden fortgeschrittene
Konzepte in Java kennenlernen und sich mit etablierten Methoden in der
Softwareentwicklung wie Versionierung von Code, Einhaltung von Coding
Conventions, Grundlagen des Softwaretests, Anwendung von Refactoring,
Einsatz von Build-Tools und Logging auseinander setzen. Wenn uns dabei
ein Entwurfsmuster “über den Weg läuft”, werden wir die Gelegenheit
nutzen und uns dieses genauer anschauen.

## Überblick Modulinhalte

1.  Fortgeschrittene Konzepte in Java (“Classic Java”)
    - Reguläre Ausdrücke, Annotationen, Reflection
    - Generische Programmierung: Generics
    - Parallele Programmierung: Threads
    - ~~CLI~~, ~~Konfiguration~~, fremde APIs nutzen[^1]
    - Graphische Oberflächen mit Swing[^2]
2.  Fortgeschrittene Konzepte in Java (“FP”)
    - Default-Methoden, Funktionsinterfaces, Methodenreferenzen,
      Lambdas, Optional, Stream-API
3.  Versionierung mit Git
4.  Softwarequalität
    - Testen, Coding Conventions & Smells, Refactoring, Javadoc, Logging
5.  Entwurfsmuster
    - ~~Strategy~~, Template-Method, ~~Factory-Method~~, ~~Singleton~~,
      Observer, Visitor, Command, …
6.  Bauen von Software
    - Gradle, Docker, Continuous Integration (GitHub Workflows)

(*durchgestrichene Themen nicht im Sommersemester 2025*)

## Team

- [Carsten
  Gips](https://www.hsbi.de/minden/ueber-uns/personenverzeichnis/carsten-gips)
  (Sprechstunde nach Vereinbarung)
- [BC
  George](https://www.hsbi.de/minden/ueber-uns/personenverzeichnis/birgit-christina-george)
  (Sprechstunde nach Vereinbarung)
- Tutoren (siehe ILIAS-Mitgliederliste)

## Kursformat

<img src="admin/images/fahrplan.png" width="80%">

| Vorlesung (2 SWS) | Praktikum (2 SWS) |
|:---|:---|
| Fr, 08:00 - 09:30 Uhr (online) | G1: Fr, 09:45 - 11:15 Uhr (online, Carsten) |
| (Carsten: *Flipped Classroom*) | G2: Fr, 11:30 - 13:00 Uhr (online, Carsten) |
|  | G3: Fr, 09:45 - 11:15 Uhr (online, BC) |
|  | G4: Fr, 11:30 - 13:00 Uhr (online, BC) |

Online-Sitzungen per Zoom (**Zugangsdaten siehe
[ILIAS](https://www.hsbi.de/elearning/goto.php?target=crs_1486054&client_id=FH-Bielefeld)**).
Sie *können* hierzu den Raum J101 bzw. J104 (vgl. Stundenplan) nutzen.

## Fahrplan

Hier finden Sie einen abonnierbaren [Google
Kalender](https://calendar.google.com/calendar/ical/69ecbae80c817d60571a6ec968890b9b7ef0ffea5ce5dad1ef06c46eef7c530f%40group.calendar.google.com/public/basic.ics)
mit allen Terminen der Veranstaltung zum Einbinden in Ihre Kalender-App.

| Monat | Tag | Vorlesung | VL-Quiz | Praktikum |
|:---|:---|:---|:---|:---|
| April | 11\. | Orga (**Zoom**), [FAQ](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/categories/q-a) |  |  |
|  | 18\. | **Feiertag** | **Feiertag** | **Feiertag** |
|  | 25\. | [Einführung Versionierung](lecture/git/git-intro.md), [Git Basics](lecture/git/git-basics.md); [Lambda-Ausdrücke](lecture/java-modern/lambdas.md); [Gradle](lecture/building/gradle.md) | [Q01](https://www.hsbi.de/elearning/goto.php?target=tst_1527333&client_id=FH-Bielefeld) | [B01](homework/b01.md) |
| Mai | 02\. | [Git-Branches](lecture/git/branches.md), [Branching-Strategien](lecture/git/branching-strategies.md); [Methodenreferenzen](lecture/java-modern/methodreferences.md); [Logging](lecture/quality/logging.md) | [Q02](https://www.hsbi.de/elearning/goto.php?target=tst_1527338&client_id=FH-Bielefeld) | [B02](homework/b02.md) |
|  | 09\. | [Git-Remotes](lecture/git/remotes.md), [Git-Workflows](lecture/git/workflows.md); [Stream-API](lecture/java-modern/stream-api.md); [Record-Klassen](lecture/java-modern/records.md) | [Q03](https://www.hsbi.de/elearning/goto.php?target=tst_1527339&client_id=FH-Bielefeld) | [B03](homework/b03.md) |
|  | 16\. | **Station I** 09:00-11:00 Uhr, B40 (Aufteilung siehe [Ankündigung \#997](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/997)) |  |  |
|  | 23\. | [Einführung Testen](lecture/quality/testing-intro.md), [JUnit-Basics](lecture/quality/junit-basics.md); [Optional](lecture/java-modern/optional.md); [Visitor-Pattern](lecture/pattern/visitor.md) | [Q04](https://www.hsbi.de/elearning/goto.php?target=tst_1527340&client_id=FH-Bielefeld) | [B04](homework/b04.md) |
|  | 30\. | [Testfallermittlung](lecture/quality/testcases.md), [Mocking](lecture/quality/mockito.md); [Default-Methoden](lecture/java-modern/defaultmethods.md); [Observer-Pattern](lecture/pattern/observer.md); [Continuous Integration (CI)](lecture/building/ci.md) | [Q05](https://www.hsbi.de/elearning/goto.php?target=tst_1527341&client_id=FH-Bielefeld) | [B05](homework/b05.md) |
| Juni | 06\. | [Code-Smells](lecture/quality/smells.md), [Coding-Rules](lecture/quality/codingrules.md), [Refactoring](lecture/quality/refactoring.md); [Javadoc](lecture/quality/javadoc.md) | [Q06](https://www.hsbi.de/elearning/goto.php?target=tst_1527342&client_id=FH-Bielefeld) | [B06](homework/b06.md) |
|  | 13\. | **Station II** 09:00-10:30 Uhr, B40 (Aufteilung siehe [Ankündigung \#1025](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/1025)) |  |  |
|  | 20\. | [RegExp](lecture/java-classic/regexp.md); [Template-Method-Pattern](lecture/pattern/template-method.md), [Command-Pattern](lecture/pattern/command.md); [Annotationen](lecture/java-classic/annotations.md) | [Q07](https://www.hsbi.de/elearning/goto.php?target=tst_1527343&client_id=FH-Bielefeld) | [B07](homework/b07.md) |
|  | 27\. | Generics: [Klassen und Methoden](lecture/java-classic/generics-classes-methods.md), [Bounds und Wildcards](lecture/java-classic/generics-bounds-wildcards.md), [Type Erasure](lecture/java-classic/generics-type-erasure.md), [Polymorphie](lecture/java-classic/generics-polymorphism.md); [Docker](lecture/building/docker.md) | [Q08](https://www.hsbi.de/elearning/goto.php?target=tst_1527344&client_id=FH-Bielefeld) | [B08](homework/b08.md) |
| Juli | 04\. | [Intro Threads](lecture/java-classic/threads-intro.md), [Synchronisierung](lecture/java-classic/threads-synchronisation.md), [Highlevel Threadkonzepte](lecture/java-classic/threads-highlevel.md); [Reflection](lecture/java-classic/reflection.md) | [Q09](https://www.hsbi.de/elearning/goto.php?target=tst_1527345&client_id=FH-Bielefeld) | [B09](homework/b09.md) |
| *Prüfungsphase I* | 09.07. | **Station III** 09:00-10:30 Uhr, B40 (Aufteilung siehe [Ankündigung \#1032](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/1032)) |  |  |
| *Prüfungsphase II* | 24.09.(?) | **Station IV**, B40 (Aufteilung siehe Ankündigung) |  |  |

Abgabe der Übungsblätter jeweils **bis Fr, 08:00 Uhr** [im
ILIAS](https://www.hsbi.de/elearning/goto.php?target=exc_1514856&client_id=FH-Bielefeld),
Vorstellung der Lösung im zugehörigen Praktikum. Bearbeitung der Quizzes
jeweils **Sa, 00:00 Uhr (Vorwoche) bis Fr, 08:00 Uhr** [im
ILIAS](https://www.hsbi.de/elearning/goto.php?target=fold_1514843&client_id=FH-Bielefeld).

## Prüfungsform, Note und Credits

**Parcoursprüfung**, 5 ECTS (PO23)

Da Sie das Programmierhandwerk erlernen und üben und vertiefen sollen,
dürfen Sie im Rahmen dieser Lehrveranstaltung noch keine KI-gestützten
Assistenten benutzen. Lösungen, die dennoch ganz oder teilweise unter
Zuhilfenahme von KI-Unterstützung erstellt wurden, werden wie nicht
abgegeben behandelt.

### Prüfung im ersten Zeitraum

1.  **Quizzes**: mind. 5 der 9 Quizzes bestanden (ohne Note/Punkte)
    (Einzelbearbeitung, fristgerecht bis zur jeweiligen Vorlesung, je
    Quiz bis zu 3x wiederholbar, 60% pro Quiz zum Bestehen nötig)
2.  **Praktikum**: mind. 5 der 9 Übungsblätter bestanden (ohne
    Note/Punkte) (bis zu 3er Teams, alle Aufgaben eines Blattes
    bearbeitet, individuelle(!) fristgerechte Abgabe der Lösungen im
    ILIAS als aussagekräftiges [*Post
    Mortem*](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/981)[^3],
    Vorstellung der Lösungen im Praktikum durch jedes Teammitglied,
    aktive Beteiligung an der Diskussion im Praktikum)
3.  **Station I**: ILIAS-Test (30 Minuten in Minden im B40)
4.  **Station II**: ILIAS-Test (30 Minuten in Minden im B40)
5.  **Station III**: ILIAS-Test (30 Minuten in Minden im B40)

Station I und II finden im Vorlesungsslot statt ([Aufteilung siehe
separate
Ankündigung](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/1025)),
Station III im ersten Prüfungszeitraum (Termin lt. Bekanntgabe vom
Prüfungsamt: Mi, 09.07., [Aufteilung siehe separate
Ankündigung](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/1032)).
Die Punkte der beiden besseren Stationen werden summiert bzw. es wird
der Mittelwert der beiden besten prozentualen Ergebnisse ermittelt zur
die Berechnung der Note.[^4]

**Gesamtnote**: 4.0: ab 50%, alle 5% nächste Teilnote, 1.0: ab 95%
(jeweils nur wenn Quizzes bestanden und Praktikum bestanden)

Bei mind. drei über das Minimum hinaus bestandenen Quizzes und/oder
Aufgabenblättern verbessert sich die Gesamtnote um eine Teilnote.

(Hinweise zur [Prüfungsvorbereitung](admin/exams.md) für Station I bis
III)

### Prüfung im zweiten Zeitraum

1.  **Station IV**: Schriftliche Prüfung (digitale Klausur) 90 Minuten
    in Minden im B40 (Termin lt. Bekanntgabe vom Prüfungsamt:
    voraussichtlich 24.09.)

**Gesamtnote**: 4.0: ab 50%, alle 5% nächste Teilnote, 1.0: ab 95%

(Hinweise zur [Prüfungsvorbereitung](admin/exams.md) für Station IV)

## Materialien

### Literatur

1.  [“**Java ist auch eine
    Insel**”](https://openbook.rheinwerk-verlag.de/javainsel/index.html).
    Ullenboom, C., Rheinwerk-Verlag, 2021. ISBN
    [978-3-8362-8745-6](https://fhb-bielefeld.digibib.net/openurl?isbn=978-3-8362-8745-6).
2.  [“**Pro Git** (Second Edition)”](https://git-scm.com/book/en/v2).
    Chacon, S. und Straub, B., Apress, 2014. ISBN
    [978-1-4842-0077-3](https://fhb-bielefeld.digibib.net/openurl?isbn=978-1-4842-0077-3).
3.  [“The Java Tutorials”](https://docs.oracle.com/javase/tutorial/).
    Oracle Corporation, 2024.
4.  [“Learn Java”](https://dev.java/learn/). Oracle Corporation, 2025.

### Tools

- JDK: **Java SE 21 (LTS)**
  ([Oracle](https://www.oracle.com/java/technologies/downloads/) oder
  [Alternativen](https://code.visualstudio.com/docs/languages/java#_install-a-java-development-kit-jdk),
  bitte 64-bit Version nutzen)
- IDE: [Eclipse IDE for Java
  Developers](https://www.eclipse.org/downloads/) oder [IntelliJ IDEA
  (Community Edition)](https://www.jetbrains.com/idea/) oder [Visual
  Studio Code](https://code.visualstudio.com/) oder
  [Vim](https://www.vim.org/) oder …
- [Git](https://git-scm.com/)

## Förderungen und Kooperationen

### Förderung durch DH.NRW (Digi Fellowships)

Die Überarbeitung dieser Lehrveranstaltung wurde vom Ministerium für
Kultur und Wissenschaft (MKW) in NRW im Einvernehmen mit der Digitalen
Hochschule NRW (DH.NRW) gefördert: [“Fellowships für Innovationen in der
digitalen
Hochschulbildung”](https://www.dh.nrw/kooperationen/Digi-Fellows-2)
(*Digi Fellowships*).

### Kooperation mit dem DigikoS-Projekt

Diese Vorlesung wurde vom Projekt [“Digitalbaukasten für
kompetenzorientiertes Selbststudium”](https://www.digikos.de)
(*DigikoS*) unterstützt. Ein vom DigikoS-Projekt ausgebildeter Digital
Learning Scout hat insbesondere die Koordination der digitalen
Gruppenarbeiten, des Peer-Feedbacks und der Postersessions in ILIAS
technisch und inhaltlich begleitet. DigikoS wird als Verbundprojekt von
der Stiftung Innovation in der Hochschullehre gefördert.

------------------------------------------------------------------------

## LICENSE

<img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png">

Unless otherwise noted, [this
work](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture)
by [Carsten Gips](https://github.com/cagix) and
[contributors](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/graphs/contributors)
is licensed under [CC BY-SA
4.0](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/LICENSE.md).
See the [credits](CREDITS.md) for a detailed list of contributing
projects.

<blockquote><p><sup><sub><strong>Last modified:</strong> ff6effe (readme: use simple markdown image (license), 2025-07-24)<br></sub></sup></p></blockquote>

[^1]: als Teilaufgabe im Praktikum

[^2]: nur als Wiederholung im Praktikum

[^3]: **Post Mortem**: Jede Person beschreibt in der ILIAS-Abgabe
    individuell(!) die Bearbeitung des jeweiligen Aufgabenblattes
    zurückblickend mit 200 bis 400 Wörtern. Gehen Sie dabei
    aussagekräftig und nachvollziehbar auf folgende Punkte ein: (a)
    Zusammenfassung: Was wurde gemacht? (b) Implementierungsdetails:
    Kurze Beschreibung besonders interessanter Aspekte der Umsetzung.
    (c) Was war der schwierigste Teil bei der Bearbeitung? Wie haben Sie
    dieses Problem gelöst? (d) Was haben Sie gelernt oder (besser)
    verstanden? (e) Team: Mit wem haben Sie zusammengearbeitet? (f)
    Links zu Ihren Pull-Requests mit der Lösung (erst ab Blatt 04).
    Siehe auch
    https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/981.

[^4]: Wenn die Maximalzahl der Punkte für Station I, II und III
    identisch ist, wird einfach die Summe der Punkte der beiden besseren
    Stationen berechnet und für die Bildung der Gesamtnote genutzt. Wenn
    die Maximalzahl der Punkte für Station I, II und III voneinander
    abweicht, dann wird jeweils das erreichte prozentuale Ergebnis
    berechnet und die Gesamtnote über den Mittelwert der beiden besseren
    Ergebnisse berechnet.
