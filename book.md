# IFM 2.1: Programmieren 2 (Sommer 2026)

<a id="id-da39a3ee5e6b4b0d3255bfef95601890afd80709"></a>

## Syllabus

### Syllabus

> ... And, lastly, there's the explosive growth in demand, which has led
> to many people doing it who aren't any good at it. Code is merely a
> means to an end. **Programming is an art and code is merely its
> medium.** Pointing a camera at a subject does not make one a proper
> photographer. There are a lot of self-described coders out there who
> couldn't program their way out of a paper bag.
>
> -- John Gruber auf
> [daringfireball.net](https://daringfireball.net/2020/04/cobol_programming_coding)

#### Kursbeschreibung

Sie haben letztes Semester in **Prog1** die *wichtigsten* Elemente und
Konzepte der Programmiersprache Java kennen gelernt.

In diesem Modul geht es darum, diese Kenntnisse sowohl auf der Java- als
auch auf der Methoden-Seite so zu erweitern, dass Sie gemeinsam größere
Anwendungen erstellen und pflegen können. Sie werden fortgeschrittene
Konzepte in Java kennenlernen und sich mit etablierten Methoden in der
Softwareentwicklung wie Versionierung von Code, Einhaltung von Coding
Conventions, Grundlagen des Softwaretests, Anwendung von Refactoring,
Einsatz von Build-Tools und Logging auseinander setzen. Wenn uns dabei
ein Entwurfsmuster "über den Weg läuft", werden wir die Gelegenheit
nutzen und uns dieses genauer anschauen.

#### Überblick Modulinhalte

1.  Fortgeschrittene Konzepte in Java ("Classic Java")
    -   Reguläre Ausdrücke, Annotationen, Reflection
    -   Generische Programmierung: Generics
    -   Parallele Programmierung: Threads
    -   ~~CLI~~, ~~Konfiguration~~, fremde APIs nutzen[^1]
    -   Graphische Oberflächen mit Swing[^2]
2.  Fortgeschrittene Konzepte in Java ("FP")
    -   Default-Methoden, Funktionsinterfaces, Methodenreferenzen,
        Lambdas, Optional, Stream-API
3.  Versionierung mit Git
4.  Softwarequalität
    -   Testen, Coding Conventions & Smells, Refactoring, Javadoc,
        Logging
5.  Entwurfsmuster
    -   ~~Strategy~~, Template-Method, ~~Factory-Method~~,
        ~~Singleton~~, Observer, Visitor, Command, ...
6.  Bauen von Software
    -   Gradle, Docker, Continuous Integration (GitHub Workflows)

(*durchgestrichene Themen nicht im Sommersemester 2026*)

#### Team

-   [Carsten
    Gips](https://www.hsbi.de/minden/ueber-uns/personenverzeichnis/carsten-gips)
    (Sprechstunde nach Vereinbarung)
-   Alesia Herbertz (Tutorin)

#### Kursformat

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/admin/images/fahrplan.png" width="80%" /></p>

| Vorlesung (2 SWS)     | Praktikum (2 SWS)         |
|:----------------------|:--------------------------|
| Mo, 08:00 - 09:30 Uhr | G1: Mo, 11:30 - 13:00 Uhr |
| (*Flipped Classroom*) | G2: Mo, 14:00 - 15:30 Uhr |
|                       | G3: Mo, 09:45 - 11:15 Uhr |
|                       | G4: Mi, 08:00 - 09:30 Uhr |

Alle Sitzungen online per Zoom (**Zugangsdaten siehe
[ILIAS](https://www.hsbi.de/elearning/goto.php/crs/1634793)**).

#### Fahrplan

Hier finden Sie einen abonnierbaren [Google
Kalender](https://calendar.google.com/calendar/ical/69ecbae80c817d60571a6ec968890b9b7ef0ffea5ce5dad1ef06c46eef7c530f%40group.calendar.google.com/public/basic.ics)
mit allen Terminen der Veranstaltung zum Einbinden in Ihre Kalender-App.

| Monat | Tag | Vorlesung | VL-Quiz | Praktikum |
|:------|:-----|:--------------------------------------|:-------------|:-------|
| April | 20\. | [Orga](#id-275d783e298228506068436512433d343feb52aa), [FAQ](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/discussions/categories/q-a) |  |  |
|  | 27\. | [Einführung Versionierung](#id-ca5676bbc33258233014505568775a92741eb46d), [Git Basics](#id-668acfcb7f83e0ab677a1cc897ff2b61dc9a8577); [Lambda-Ausdrücke](#id-01cc534b930a4f8fcff3f34238f9b902b2aa94dd); [Gradle](#id-879896721406ac776eca71435136f613a3f6c9d9) | [Q01](https://www.hsbi.de/elearning/goto.php?target=tst_1527333&client_id=FH-Bielefeld) | [B01](#id-989147f48baba6a594eb9665934ae2623dc84964) |
| Mai | 04\. | [Git-Branches](#id-097aec8f1fbaaecb9f5c7cce8f7adb057ecedd6f), [Branching-Strategien](#id-4d6861ad376a0b2e0387b1a92bfe1dde822ccb7f); [Methodenreferenzen](#id-7aa5254265b8c6ada30b38ba3de8870e51d66c9e); [Logging](#id-d34a1123257baba72f157fdf29caa69090e90127) | [Q02](https://www.hsbi.de/elearning/goto.php?target=tst_1527338&client_id=FH-Bielefeld) | [B02](#id-61b291653cdae0b4da99c50e5ab714c878aede10) |
|  | 11\. | [Git-Remotes](#id-891ec209f76a247e09e9c1cd306bd531b6ebe897), [Git-Workflows](#id-fde0fd70583957b6ab46f130656a605feb110e95); [Stream-API](#id-b16a41dd6bcae74097deb0d66f9b50762b8c0f40); [Record-Klassen](#id-152ec8405b8a75f125fcbd1f4f3125262de1b614) | [Q03](https://www.hsbi.de/elearning/goto.php?target=tst_1527339&client_id=FH-Bielefeld) | [B03](#id-6c99b0278590e1866d400dbbb6fc3eeafad60e55) |
|  | 18\. | [Einführung Testen](#id-034f87112a6be7c5c927ef1775d293b8b6d7774c), [JUnit-Basics](#id-fdac50744187e0bbb0d93a110ad70910667d5eed); [Optional](#id-bb5095c5a37b38bd48ac37be51964fb543342407); [Visitor-Pattern](#id-ff6c3f74c23480f2273b18c9777709c80ff62a7e) | [Q04](https://www.hsbi.de/elearning/goto.php?target=tst_1527340&client_id=FH-Bielefeld) | [B04](#id-d392f8d0f4dd93faa938c9737b2317ba03f5aa12) |
|  | 25\. | **Feiertag** | **Feiertag** | **Feiertag** |
| Juni | 01\. | [Testfallermittlung](#id-5faf7bc2998ca41cbb5f5b342c1b46d28f6d1b85), [Mocking](#id-ca381288eacf7fbdad309dee947ebee25635af6d); [Default-Methoden](#id-83d9242997f09b086df2b42d7c636f083f0ab02e); [Observer-Pattern](#id-c50f087222495d1cb378b27fc952f32b2ccb2054); [Continuous Integration (CI)](#id-4db9ebc86d71df5cc33864e90b54d42c472fdaec) | [Q05](https://www.hsbi.de/elearning/goto.php?target=tst_1527341&client_id=FH-Bielefeld) | [B05](#id-96a6e702ef5bbea0815334b0b819b91864e526c7) |
|  | 08\. | [Code-Smells](#id-41be9b68119185a3c165c600670ba548b3bf2cfd), [Coding-Rules](#id-89d3bbb734edbc0c4d593538c63ca0f4828e222b), [Refactoring](#id-d5584aa5535595f1fb5da2daccb6110c719a3c59); [Javadoc](#id-1a29f4d878c0dfd2692190d1ba8be56516408629) | [Q06](https://www.hsbi.de/elearning/goto.php?target=tst_1527342&client_id=FH-Bielefeld) | [B06](#id-f80f5e162e1aaa7ad98f24b776c109c056062b7c) |
|  | 15\. | [RegExp](#id-cfd21c65be03a9536ad286c40c0f52ec3d376712); [Template-Method-Pattern](#id-d65790dd2d165c56e13ec1cea6619359f6def01b), [Command-Pattern](#id-fa18d796f1346e2d468abc3703e53374e2005b7f); [Annotationen](#id-b7dfad1ad3e9e01252e54933152728b9552b3735) | [Q07](https://www.hsbi.de/elearning/goto.php?target=tst_1527343&client_id=FH-Bielefeld) | [B07](#id-83476d78577cf7ca1cbc9b26afe056c03f1836fc) |
|  | 22\. | Generics: [Klassen und Methoden](#id-359cf00c9c9fee1016f00310e99654e8f237b413), [Bounds und Wildcards](#id-b5a72bc0878f8a0c3efaa1126dc28bfb1261adfb), [Type Erasure](#id-74a1e4a0fe24c2ac4e4d580db16b6f832fb2d888), [Polymorphie](#id-4c89bee19163dac6a373bfc5c5b362e8ebe61ae3); [Docker](#id-6cb84000fb9df777e413acabff7c4f83fd52fa7a) | [Q08](https://www.hsbi.de/elearning/goto.php?target=tst_1527344&client_id=FH-Bielefeld) | [B08](#id-f446a81e524a27594ec457a16742d232a92912c6) |
|  | 29\. |  |  |  |
| Juli | 06\. | [Intro Threads](#id-f6029a94ea1cbcba66e37c103b162b90e62bea1d), [Synchronisierung](#id-fd5317305f8c0a4a45cfacf12f8feac51a2ed5df), [Highlevel Threadkonzepte](#id-658174d5a85775f31f62a05f3f7d486f9391ba11); [Reflection](#id-cd1f3b4bd043849ddb3a3d41c9c280e6f0547ce4) | [Q09](https://www.hsbi.de/elearning/goto.php?target=tst_1527345&client_id=FH-Bielefeld) | [B09](#id-31c5e287bbe09bf1d8bf14a0cb61f2cfc1f85986) |
|  | 13\. | Rückblick, [Prüfungsvorbereitung](#id-5020900ace8eaeeefbf1af116d61d159ae6dba2b) |  |  |

Abgabe der Übungsblätter jeweils **bis Mo, 08:00 Uhr** [im
ILIAS](https://www.hsbi.de/elearning/goto.php/exc/1664006), Vorstellung
der Lösung im zugehörigen Praktikum. Bearbeitung der Quizzes jeweils
**Mi, 00:00 Uhr (Vorwoche) bis Mo, 08:00 Uhr** [im
ILIAS](https://www.hsbi.de/elearning/goto.php/fold/1663994).

#### Prüfungsform, Note und Credits

**Parcoursprüfung**, 5 ECTS (PO23)

Da Sie das Programmierhandwerk erlernen und üben und vertiefen sollen,
dürfen Sie im Rahmen dieser Lehrveranstaltung noch keine KI-gestützten
Assistenten benutzen. Lösungen, die dennoch ganz oder teilweise unter
Zuhilfenahme von KI-Unterstützung erstellt wurden, werden wie nicht
abgegeben behandelt.

##### Prüfung im ersten Zeitraum

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

(Hinweise zur
[Prüfungsvorbereitung](#id-5020900ace8eaeeefbf1af116d61d159ae6dba2b) für
Station I bis III)

##### Prüfung im zweiten Zeitraum

1.  **Station IV**: Schriftliche Prüfung (digitale Klausur) 90 Minuten
    in Minden im B40 (Termin lt. Bekanntgabe vom Prüfungsamt:
    voraussichtlich 24.09.)

**Gesamtnote**: 4.0: ab 50%, alle 5% nächste Teilnote, 1.0: ab 95%

(Hinweise zur
[Prüfungsvorbereitung](#id-5020900ace8eaeeefbf1af116d61d159ae6dba2b) für
Station IV)

#### Materialien

##### Literatur

1.  ["**Java ist auch eine
    Insel**"](https://openbook.rheinwerk-verlag.de/javainsel/index.html).
    Ullenboom, C., Rheinwerk-Verlag, 2021. ISBN
    [978-3-8362-8745-6](https://fhb-bielefeld.digibib.net/openurl?isbn=978-3-8362-8745-6).
2.  ["**Pro Git** (Second Edition)"](https://git-scm.com/book/en/v2).
    Chacon, S. und Straub, B., Apress, 2014. ISBN
    [978-1-4842-0077-3](https://fhb-bielefeld.digibib.net/openurl?isbn=978-1-4842-0077-3).
3.  ["The Java Tutorials"](https://docs.oracle.com/javase/tutorial/).
    Oracle Corporation, 2024.
4.  ["Learn Java"](https://dev.java/learn/). Oracle Corporation, 2026.

##### Tools

-   JDK: **Java SE 21 (LTS)**
    ([Oracle](https://www.oracle.com/java/technologies/downloads/) oder
    [Alternativen](https://code.visualstudio.com/docs/languages/java#_install-a-java-development-kit-jdk),
    bitte 64-bit Version nutzen)
-   IDE: [Eclipse IDE for Java
    Developers](https://www.eclipse.org/downloads/) oder [IntelliJ IDEA
    (Community Edition)](https://www.jetbrains.com/idea/) oder [Visual
    Studio Code](https://code.visualstudio.com/) oder
    [Vim](https://www.vim.org/) oder ...
-   [Git](https://git-scm.com/)

#### Förderungen und Kooperationen

##### Förderung durch DH.NRW (Digi Fellowships)

Die Überarbeitung dieser Lehrveranstaltung wurde vom Ministerium für
Kultur und Wissenschaft (MKW) in NRW im Einvernehmen mit der Digitalen
Hochschule NRW (DH.NRW) gefördert: ["Fellowships für Innovationen in der
digitalen
Hochschulbildung"](https://www.dh.nrw/kooperationen/Digi-Fellows-2)
(*Digi Fellowships*).

##### Kooperation mit dem DigikoS-Projekt

Diese Vorlesung wurde vom Projekt ["Digitalbaukasten für
kompetenzorientiertes Selbststudium"](https://www.digikos.de)
(*DigikoS*) unterstützt. Ein vom DigikoS-Projekt ausgebildeter Digital
Learning Scout hat insbesondere die Koordination der digitalen
Gruppenarbeiten, des Peer-Feedbacks und der Postersessions in ILIAS
technisch und inhaltlich begleitet. DigikoS wird als Verbundprojekt von
der Stiftung Innovation in der Hochschullehre gefördert.

------------------------------------------------------------------------

#### LICENSE

<p align="center"><img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png"  /></p>

Unless otherwise noted, [this
work](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture)
by [Carsten Gips](https://github.com/cagix) and
[contributors](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/graphs/contributors)
is licensed under [CC BY-SA
4.0](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/LICENSE.md).
See the
[credits](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/CREDITS.md)
for a detailed list of contributing projects.

<a id="id-af09e2fcaf4589921086150d991647b7b52abd03"></a>

## Vorlesungsunterlagen

<a id="id-8f7ee7464d08864f364826622f4c85f2260fa27c"></a>

### Versionierung mit Git

<a id="id-ca5676bbc33258233014505568775a92741eb46d"></a>

#### Intro: Versionskontrolle in der Softwareentwicklung

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> In der Softwareentwicklung wird häufig ein Versionsmanagementsystem
> (VCS) eingesetzt, welches die Verwaltung von Versionsständen und
> Änderungen ermöglicht. Ein Repository sammelt dabei die verschiedenen
> Änderungen (quasi wie eine Datenbank der Software-Versionsstände). Die
> Software *Git* ist verbreiteter Vertreter und arbeitet mit dezentralen
> Repositories.
>
> Ein neues lokales Repository kann man mit `git init` anlegen. Der
> Befehl legt den Unterordner `.git/` im aktuellen Ordner an, darin
> befindet sich das lokale Repository und weitere von Git benötigte
> Dateien (FINGER WEG!). Die Dateien und anderen Unterordner im
> aktuellen Ordner können nun der Versionskontrolle hinzugefügt werden.
>
> Den lokal vorliegenden (Versions-) Stand der Dateien im aktuellen
> Ordner nennt man auch "Workingcopy".
>
> Ein bereits existierendes Repo kann mit `git clone <url>` geklont
> werden.
>
> [GitHub](https://github.com) ist nicht Git, sondern ein kommerzieller
> Anbieter, der das Hosten von Git-Repositories und weitere Features
> anbietet.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Git Intro](https://youtu.be/Ac3-pZhVf_c)
> -   [Demo Config](https://youtu.be/0noYvZvQhic)
> -   [Demo Repo](https://youtu.be/ZaWEwIpER-U)
>
> </details>

##### Typische Probleme bei SW-Entwicklung

-   Was hat wer wann (und wo) geändert? Und warum?
-   Ich brauche den Stand von gestern/letzter Woche/...
-   Ich will schnell mal eine neue Idee ausprobieren ...
-   Ich arbeite an mehreren Rechnern (Synchronisation)
-   Wir müssen gemeinsam an der gleichen Codebasis arbeiten.
-   Wir arbeiten am Release v42, aber Kunde braucht schnell einen Fix
    für v40

##### Folgen SW-Entwicklung ohne Versionsverwaltung

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/screenshot_zusammenarbeit_ohne_vcs.png" width="60%" /></p>

-   Filesystem müllt voll mit manuell versionierten Dateien/Sicherungen
    ala `file_20120507_version2_cagi.txt`
-   Ordner/Projekte müssen dupliziert werden für neue Ideen
-   Code müllt voll mit auskommentierten Zeilen ("Könnte ja noch
    gebraucht werden")
-   Unklar, wann welche Änderung von wem warum eingeführt wurde
-   Unbeabsichtigtes Überschreiben mit älteren Versionen beim Upload in
    gemeinsamen Filesharing-Bereich

##### Prinzip Versionsverwaltung

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/local.png" width="40%" /></p>

-   **Repository:** **Datenbank** mit verschiedenen Versionsständen,
    Kommentaren, Tags etc.

<!-- -->

-   **Workingcopy:** **Arbeitskopie** eines bestimmten Versionsstandes

##### Varianten: Zentrale Versionsverwaltung (Beispiel SVN)

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/centralised.png" width="40%" /></p>

Es gibt ein zentrales Repository (typischerweise auf einem Server), von
dem die Developer einen bestimmten Versionsstand "auschecken" (sich
lokal kopieren) und in welches sie Änderungen wieder zurück "pushen".

Zur Abfrage der Historie und zum Veröffentlichen von Änderungen benötigt
man entsprechend immer eine Verbindung zum Server.

##### Varianten: Verteilte Versionsverwaltung (Beispiel Git)

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/distributed.png" width="60%" /></p>

In diesem Szenario hat jeder Developer nicht nur die Workingcopy,
sondern auch noch eine Kopie des Repositories. Zusätzlich kann es einen
oder mehrere Server geben, auf denen dann nur das Repository vorgehalten
wird, d.h. dort gibt es normalerweise keine Workingcopy. Damit kann
unabhängig voneinander gearbeitet werden.

Allerdings besteht nun die Herausforderung, die geänderten Repositories
miteinander abzugleichen. Das kann zwischen dem lokalen Rechner und dem
Server passieren, aber auch zwischen zwei "normalen" Rechnern (also
zwischen den Developern).

**Hinweis**: *GitHub ain't no Git!* Git ist eine Technologie zur
Versionsverwaltung. Es gibt verschiedene Implementierungen und Plugins
für IDEs und Editoren. [GitHub](https://github.com) ist dagegen *ein*
Dienstleister, wo man Git-Repositories ablegen kann und auf diese mit
Git (von der Konsole oder aus der IDE) zugreifen kann. Darüber hinaus
bietet der Service aber zusätzliche Features an, beispielsweise ein
Issue-Management oder sogenannte *Pull-Requests*. Dies hat aber zunächst
mit Git nichts zu tun. Weitere populäre Anbieter sind beispielsweise
[Bitbucket](https://bitbucket.org/) oder [Gitlab](https://gitlab.com)
oder [Gitea](https://gitea.io/en-us/), wobei einige auch selbst gehostet
werden können.

##### Versionsverwaltung mit Git: Typische Arbeitsschritte

1.  Repository anlegen (oder clonen)

<!-- -->

2.  Dateien neu erstellen (und löschen, umbenennen, verschieben)
3.  Änderungen einpflegen ("committen")
4.  Änderungen und Logs betrachten
5.  Änderungen rückgängig machen
6.  Projektstand markieren ("taggen")

<!-- -->

7.  Entwicklungszweige anlegen ("branchen")
8.  Entwicklungszweige zusammenführen ("mergen")

<!-- -->

9.  Änderungen verteilen (verteiltes Arbeiten, Workflows)

##### (Globale) Konfiguration

**Minimum**:

-   `git config --global user.name <name>`
-   `git config --global user.email <email>`

Diese Konfiguration muss man nur einmal machen.

Wenn man den Schalter `--global` weglässt, gelten die Einstellungen nur
für das aktuelle Projekt/Repo.

Zumindest Namen und EMail-Adresse **muss** man setzen, da Git diese
Information beim Anlegen der Commits speichert (== benötigt!).

**Aliase**:

-   `git config --global alias.ci commit`
-   `git config --global alias.co checkout`
-   `git config --global alias.br branch`
-   `git config --global alias.st status`
-   `git config --global alias.ll 'log --all --graph --decorate --oneline'`

Zusätzlich kann man weitere Einstellungen vornehmen, etwa auf bunte
Ausgabe umschalten: `git config --global color.ui auto` oder Abkürzungen
(Aliase) für Befehle definieren:
`git config --global alias.ll 'log --all --oneline --graph --decorate'`
...

Git (und auch GitHub) hat kürzlich den Namen des Default-Branches von
`master` auf `main` geändert. Dies kann man in Git ebenfalls selbst
einstellen: `git config --global init.defaultBranch <name>`.

Anschauen kann man sich die Einstellungen in der Textdatei
`~/.gitconfig` oder per Befehl `git config --global -l`.

##### Neues Repo anlegen

-   `git init`

    =\> Erzeugt neues Repository im akt. Verzeichnis

<!-- -->

-   `git clone <url>`

    =\> Erzeugt (verlinkte) Kopie des Repos unter `<url>`

##### Wrap-Up

-   Git: Versionsmanagement mit dezentralen Repositories
-   Anlegen eines lokalen Repos mit `git init`
-   Clonen eines existierenden Repos mit `git clone <url>`

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Chacon und Straub ([2014, Kap. 1](#ref-Chacon2014) und 2)
> -   Atlassian Pty Ltd ([2022](#ref-AtlassianGit))
> -   Github Inc. ([2022](#ref-GitCheatSheet))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k1: Ich kenne verschiedene Varianten der Versionierung
> -   k1: Ich kann die Begriffe 'Workingcopy' und 'Repository'
>     definieren
> -   k2: Ich kann zwischen 'Github' und 'Git' unterscheiden
> -   k2: Ich kann auf meinem Rechner lokale Git-Repositories anlegen
> -   k3: Ich kann mit den Git-Befehlen zum Anlegen von lokalen Repos
>     auf der Konsole umgehen
>
> </details>

<a id="id-668acfcb7f83e0ab677a1cc897ff2b61dc9a8577"></a>

#### Basics der Versionsverwaltung mit Git (lokale Repos)

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Änderungen an Dateien (in der Workingcopy) werden mit `git add` zum
> "Staging" (Index) hinzugefügt. Dies ist eine Art Sammelbereich für
> Änderungen, die mit dem nächsten Commit in das Repository überführt
> werden. Neue (bisher nicht versionierte Dateien) müssen ebenfalls
> zunächst mit `git add` zum Staging hinzugefügt werden.
>
> Änderungen kann man mit `git log` betrachten, dabei erhält man u.a.
> eine Liste der Commits und der jeweiligen Commmit-Messages.
>
> Mit `git diff` kann man gezielt Änderungen zwischen Commits oder
> Branches betrachten.
>
> Mit `git tag` kann man bestimmte Commits mit einem "Stempel"
> (zusätzlicher Name) versehen, um diese leichter finden zu können.
>
> Wichtig sind die Commit-Messages: Diese sollten eine kurze
> Zusammenfassung haben, die **aktiv** formuliert wird (was ändert
> dieser Commit: "Formatiere den Java-Code entsprechend Style"; nicht
> aber "Java-Code nach Style formatiert"). Falls der Kommentar länger
> sein soll, folgt eine Leerzeile auf die erste Zeile (Zusammenfassung)
> und danach ein Block mit der längeren Erklärung.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Git Basics](https://youtu.be/GxJI8nmZVE8)
> -   [Demo New Files](https://youtu.be/ITF8wj8GluM)
> -   [Demo Arbeitsablauf: Datei ändern - stagen -
>     committen](https://youtu.be/SFIVudlVUhg)
> -   [Demo Amend](https://youtu.be/0uczjI7wsrQ)
> -   [Demo Log](https://youtu.be/vmb-PZ1Efkg)
> -   [Demo Diff](https://youtu.be/XB8lfGuU6ZI)
> -   [Demo Tag](https://youtu.be/F1W0RqrxCho)
>
> </details>

##### Versionsverwaltung mit Git: Typische Arbeitsschritte

1.  Repository anlegen (oder clonen)

<!-- -->

2.  Dateien neu erstellen (und löschen, umbenennen, verschieben)
3.  Änderungen einpflegen ("committen")
4.  Änderungen und Logs betrachten
5.  Änderungen rückgängig machen
6.  Projektstand markieren ("taggen")

<!-- -->

7.  Entwicklungszweige anlegen ("branchen")
8.  Entwicklungszweige zusammenführen ("mergen")

<!-- -->

9.  Änderungen verteilen (verteiltes Arbeiten, Workflows)

##### Dateien unter Versionskontrolle stellen

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/workflow.png" width="60%" /></p>

1.  `git add .` (oder `git add <file>`)

    =\> Stellt alle Dateien (bzw. die Datei `<file>`) im aktuellen
    Verzeichnis unter Versionskontrolle

2.  `git commit`

    =\> Fügt die Dateien dem Repository hinzu

**Abfrage mit `git status`**

##### Änderungen einpflegen

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/lifecycle.png" width="50%" /></p>

-   Abfrage mit: `git status`
-   "Staging" von modifizierten Dateien: `git add <file>`
-   Committen der Änderungen im Stage: `git commit`

*Anmerkung*: Alternativ auch mit `git commit -m "Kommentar"`, um das
Öffnen des Editors zu vermeiden ... geht einfach schneller ;)

Das "staging area" stellt eine Art Zwischenebene zwischen Working Copy
und Repository dar: Die Änderungen sind temporär "gesichert", aber noch
nicht endgültig im Repository eingepflegt ("committed").

Man kann den Stage dazu nutzen, um Änderungen an einzelnen Dateien zu
sammeln und diese dann (in einem Commit) gemeinsam einzuchecken.

Man kann den Stage in der Wirkung umgehen, indem man alle in der Working
Copy vorliegenden Änderungen per `git commit -a -m "Kommentar"`
eincheckt. Der Schalter "`-a`" nimmt alle vorliegenden Änderungen an
**bereits versionierten** Dateien, fügt diese dem Stage hinzu und führt
dann den Commit durch. Das ist das von SVN bekannte Verhalten. Achtung:
Nicht versionierte Dateien bleiben dabei außen vor!

##### Letzten Commit ergänzen

-   `git commit --amend -m "Eigentlich wollte ich das so sagen"`

    Wenn keine Änderungen im Stage sind, wird so die letzte
    Commit-Message geändert.

<!-- -->

-   `git add <file>; git commit --amend`

    Damit können vergessene Änderungen an der Datei `<file>` zusätzlich
    im letzten Commit aufgezeichnet werden.

    **In beiden Fällen ändert sich die Commit-ID!**

##### Weitere Datei-Operationen: hinzufügen, umbenennen, löschen

-   Neue (unversionierte) Dateien und Änderungen an versionierten
    Dateien zum Staging hinzufügen: `git add <file>`
-   Löschen von Dateien (Repo+Workingcopy): `git rm <file>`
-   Löschen von Dateien (nur Repo): `git rm --cached <file>`
-   Verschieben/Umbenennen: `git mv <fileAlt> <fileNeu>`

Aus Sicht von Git sind zunächst alle Dateien "untracked", d.h. stehen
nicht unter Versionskontrolle.

Mit `git add <file>` (und `git commit`) werden Dateien in den Index (den
Staging-Bereich, d.h. nach dem Commit letztlich in das Repository)
aufgenommen. Danach stehen sie unter "Beobachtung" (Versionskontrolle).
So lange, wie eine Datei identisch zur Version im Repository ist, gilt
sie als unverändert ("unmodified"). Eine Änderung führt entsprechend zum
Zustand "modified", und ein `git add <file>` speichert die Änderungen im
Stage. Ein Commit überführt die im Stage vorgemerkte Änderung in das
Repo, d.h. die Datei gilt wieder als "unmodified".

Wenn eine Datei nicht weiter versioniert werden soll, kann sie aus dem
Repo entfernt werden. Dies kann mit `git rm <file>` geschehen, wobei die
Datei auch aus der Workingcopy gelöscht wird. Wenn die Datei erhalten
bleiben soll, aber nicht versioniert werden soll (also als "untracked"
markiert werden soll), dann muss sie mit `git rm --cached <file>` aus
der Versionskontrolle gelöscht werden. Achtung: Die Datei ist dann nur
ab dem aktuellen Commit gelöscht, d.h. frühere Revisionen enthalten die
Datei noch!

Wenn eine Datei umbenannt werden soll, geht das mit
`git mv <fileAlt> <fileNeu>`. Letztlich ist dies nur eine Abkürzung für
die Folge `git rm --cached <fileAlt>`, manuelles Umbenennen der Datei in
der Workingcopy und `git add <fileNeu>`.

##### Commits betrachten

-   Liste aller Commits: `git log`
    -   `git log -<n>` oder `git log --since="3 days ago"` Meldungen
        eingrenzen ...
    -   `git log --stat` Statistik ...
    -   `git log --author="pattern"` Commits eines Autors
    -   `git log <file>` Änderungen einer Datei

<!-- -->

-   Inhalt eines Commits: `git show`

##### Änderungen und Logs betrachten

-   `git diff [<file>]`

    Änderungen zwischen Workingcopy und letztem Commit (ohne Stage)

    Das "staging area" wird beim Diff von Git behandelt, als wären die
    dort hinzugefügten Änderungen bereits eingecheckt (genauer: als
    letzter Commit im aktuellen Branch im Repo vorhanden). D.h. wenn
    Änderungen in einer Datei mittels `git add <datei>` dem Stage
    hinzugefügt wurden, zeigt `git diff <datei>` keine Änderungen an!

<!-- -->

-   `git diff commitA commitB`

    Änderungen zwischen Commits

<!-- -->

-   Blame: `git blame <file>`

    Wer hat was wann gemacht?

##### Dateien ignorieren: *.gitignore*

-   Nicht alle Dateien gehören ins Repo:
    -   generierte Dateien: `.class`
    -   temporäre Dateien
-   Datei `.gitignore` anlegen und committen
    -   Wirkt auch für Unterordner
    -   Inhalt: Reguläre Ausdrücke für zu ignorierende Dateien und
        Ordner

``` gitignore
    # Compiled source #
    *.class
    *.o
    *.so

    # Packages #
    *.zip

    # All directories and files in a directory #
    bin/**/*
```

<p align="right"><a href="https://linux.die.net/man/5/gitignore">man 5 gitignore</a></p>

##### Zeitmaschine

-   Änderungen in Workingcopy rückgängig machen
    -   Änderungen nicht in Stage: `git checkout <file>` oder
        `git restore <file>`
    -   Änderungen in Stage: `git reset HEAD <file>` oder
        `git restore --staged <file>`

    =\> Hinweise von `git status` beachten!

<!-- -->

-   Datei aus altem Stand holen:
    -   `git checkout <commit> <file>`, oder
    -   `git restore --source <commit> <file>`
-   Commit verwerfen, Geschichte neu: `git revert <commit>`

*Hinweis*: In den neueren Versionen von Git ist der Befehl `git restore`
hinzugekommen, mit dem Änderungen rückgängig gemacht werden können. Der
bisherige Befehl `git checkout` steht immer noch zur Verfügung und
bietet über `git restore` hinaus weitere Anwendungsmöglichkeiten.

-   Stempel (Tag) vergeben: `git tag <tagname> <commit>`
-   Tags anzeigen: `git tag` und `git show <tagname>`

##### Wann und wie committen?

<div align="center">

**Jeder Commit stellt einen Rücksetzpunkt dar!**

</div>

Typische Regeln:

-   Kleinere "Häppchen" einchecken: ein Feature oder Task (das nennt man
    auch *atomic commit*: das kleinste Set an Änderungen, die gemeinsam
    Sinn machen und die ggf. gemeinsam zurückgesetzt werden können)
-   Logisch zusammenhängende Änderungen gemeinsam einchecken
-   Projekt muss nach Commit compilierbar sein
-   Projekt sollte nach Commit lauffähig sein

Ein Commit sollte in sich geschlossen sein, d.h. die kleinste Menge an
Änderungen enthalten, die gemeinsam einen Sinn ergeben und die (bei
Bedarf) gemeinsam zurückgesetzt oder verschoben werden können. Das nennt
man auch **atomic commit**.

Wenn Sie versuchen, die Änderungen in Ihrem Commit zu beschreiben (siehe
nächste Folie "Commit-Messages"), dann werden Sie einen *atomic commit*
mit einem kurzen Satz (natürlich im Imperativ!) beschreiben können. Wenn
Sie mehr Text brauchen, haben Sie wahrscheinlich keinen *atomic commit*
mehr vor sich.

**Lesen Sie dazu auch [How atomic Git commits dramatically increased my
productivity - and will increase yours
too](https://dev.to/samuelfaure/how-atomic-git-commits-dramatically-increased-my-productivity-and-will-increase-yours-too-4a84).**

##### Schreiben von Commit-Messages: WARUM?!

Schauen Sie sich einmal einen Screenshot eines
`git log --oneline 61e48f0..e2c8076` im
[Dungeon-CampusMinden/Dungeon](https://github.com/Dungeon-CampusMinden/Dungeon)
an:

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/screenshot_git_log.png" width="60%" /></p>

Nun stellen Sie sich vor, Sie sind auf der Suche nach Informationen,
suchen einen bestimmten Commit oder wollen eine bestimmte Änderung
finden ...

Wenn man das genauer analysiert, dann stören bestimmte Dinge:

-   Mischung aus Deutsch und Englisch
-   "Vor-sich-hin-Murmeln": "Layer system 5"
-   Teileweise werden Tags genutzt wie `[BUG]`, aber nicht durchgängig
-   Mischung zwischen verschiedenen Formen: "Repo umbenennen", "Benenne
    Repo um", "Repo umbenannt"
-   Unterschiedliche Groß- und Kleinschreibung
-   Sehr unterschiedlich lange Zeilen/Kommentare

**Das Beachten einheitlicher Regeln ist enorm wichtig!**

Leider sagt sich das so leicht - in der Praxis macht man es dann doch
schnell wieder unsauber. Dennoch, auch im Dungeon-Repo gibt es einen
positiven Trend (`git log --oneline 8039d6c..7f49e89`):

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/screenshot_git_log_recent.png" width="80%" /></p>

Typische Regeln und Konventionen tauchen überall auf, beispielsweise in
Chacon und Straub ([2014](#ref-Chacon2014)) oder bei Tim Pope (siehe
nächstes Beispiel) oder bei ["How to Write a Git Commit
Message"](https://cbea.ms/git-commit/).

``` markdown
Short (50 chars or less) summary of changes

More detailed explanatory text, if necessary.  Wrap it to about
72 characters or so.  In some contexts, the first line is treated
as the subject of an email and the rest of the text as the body.
The blank line separating the summary from the body is critical
(unless you omit the body entirely); tools like rebase can get
confused if you run the two together.

Further paragraphs come after blank lines.

 - Bullet points are okay, too
 - Typically a hyphen or asterisk is used for the bullet, preceded
   by a single space, with blank lines in between, but conventions
   vary here
```

Quelle: ["A Note About Git Commit
Messages"](https://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html)
by [Tim Pope](https://tpo.pe/) on tbaggery.com

Denken Sie sich die Commit-Message als E-Mail an einen zukünftigen
Entwickler, der das in fünf Jahren liest!

Vom Aufbau her hat eine E-Mail auch eine Summary und dann den
eigentlichen Inhalt ... Erklären Sie das **"WARUM"** der Änderung! (Das
"WER", "WAS", "WANN" wird bereits automatisch von Git aufgezeichnet ...)

<div align="center">

**Lesen (und beachten) Sie unbedingt auch ["How to Write a Git Commit
Message"](https://cbea.ms/git-commit/)!**

</div>

##### Ausflug "Conventional Commits"

Die Commit-Messages dienen vor allem der Dokumentation und werden von
Entwicklern gelesen.

Wenn man die Messages ein wenig stärker formalisieren würde, dann könnte
man diese aber auch mit Tools verarbeiten und beispielsweise
automatisiert Changelogs oder Release-Texte verfassen!

Betrachten Sie einmal das Projekt
[ConventionalCommits.org](https://github.com/conventional-commits/conventionalcommits.org).
Dies ist ein solcher Versuch, die Commit-Messages (a) einheitlicher und
lesbarer zu gestalten und (b) auch eine Tool-gestützte Auswertung zu
erlauben.

Das Projekt schlägt als Erweitung der üblichen Regeln zum Formatieren
von Commit-Messages vor, dass in der ersten Zeile der *Summary* noch
eine Abkürzung für die in diesem Commit erfolgte Änderung (Bug-Fix,
neues Feature, ...) vorangestellt wird. Dieser Abkürzung kann in
Klammern noch der Scope der Änderung hinzugefügt werden, beispielsweise
den Bereich im Projekt, der von diesem Commit berührt wird. Wenn es eine
*breaking change* ist, also alter Code nach dieser Änderung sich anders
verhält oder vielleicht sogar nicht mehr kompiliert, wird noch ein "!"
hinter dem Typ der Änderung ergänzt.

**Beispiel**: Stellen Sie sich vor, im Dungeon-Projekt wurde ein neues
Verhalten hinzugefügt.

1.  Normalerweise hätten Sie vielleicht diese Message geschrieben
    (angepasste Version aus
    [Dungeon-CampusMinden/Dungeon/pull/469](https://github.com/Dungeon-CampusMinden/Dungeon/pull/469)):

        add fight skill

        -   `DamageProjectileSkill` creates a new entity which causes `HealthDamage` when hitting another entity
        -   `FireballSkill` is a more concrete implementation of this
        -   Melee skills can be created with `DamageProjectileSkill` using a customised range
            -   Example: the `FireballSkill` has a range of 10, a melee would have a considerably smaller range

        fixes #24
        fixes #126
        fixes #224

2.  Mit
    [ConventionalCommits.org](https://www.conventionalcommits.org/en/v1.0.0/#examples)
    könnte das dann so aussehen:

        feat: add fight skill

        -   `DamageProjectileSkill` creates a new entity which causes `HealthDamage` when hitting another entity
        -   `FireballSkill` is a more concrete implementation of this
        -   Melee skills can be created with `DamageProjectileSkill` using a customised range
            -   Example: the `FireballSkill` has a range of 10, a melee would have a considerably smaller range

        fixes #24
        fixes #126
        fixes #224

    Da es sich um ein neues Feature handelt, wurde der Summary in der
    ersten Zeile ein `feat:` vorangestellt.

    Die zu verwendenden Typen/Abkürzungen sind im Prinzip frei
    definierbar. Das Projekt
    [ConventionalCommits.org](https://github.com/conventional-commits/conventionalcommits.org)
    schlägt eine Reihe von Abkürzungen vor. Auf diese Weise sollen in
    möglichst allen Projekten, die Conventional Commits nutzen, die
    selben Abkürzungen/Typen eingesetzt werden und so eine
    Tool-gestützte Auswertung möglich werden.

3.  Oder zusätzlich mit dem Scope der Änderung:

        feat(game): add fight skill

        -   `DamageProjectileSkill` creates a new entity which causes `HealthDamage` when hitting another entity
        -   `FireballSkill` is a more concrete implementation of this
        -   Melee skills can be created with `DamageProjectileSkill` using a customised range
            -   Example: the `FireballSkill` has a range of 10, a melee would have a considerably smaller range

        fixes #24
        fixes #126
        fixes #224

    Der Typ `feat` wurde hier noch ergänzt um einen frei definierbaren
    Identifier für den Projektbereich. Dieser wird in Klammern direkt
    hinter den Typ notiert (hier `feat(game):`).

    Im Beispiel habe ich als Bereich "game" genommen, weil die Änderung
    sich auf den Game-Aspekt des Projekts bezieht. Im konkreten Projekt
    wären andere Bereiche eventuell "dsl" (für die im Projekt
    entwickelte Programmiersprache plus Interpreter) und "blockly" (für
    die Integration von Google Blockly zur Programmierung des Dungeons
    mit LowCode-Ansätzen). Das ist aber letztlich vom Projekt abhängig
    und weitestgehend Geschmackssache.

4.  Oder zusätzlich noch als Auszeichnung "breaking change" (hier mit
    *scope*, geht aber auch ohne *scope*):

        feat(game)!: add fight skill

        -   `DamageProjectileSkill` creates a new entity which causes `HealthDamage` when hitting another entity
        -   `FireballSkill` is a more concrete implementation of this
        -   Melee skills can be created with `DamageProjectileSkill` using a customised range
            -   Example: the `FireballSkill` has a range of 10, a melee would have a considerably smaller range

        fixes #24
        fixes #126
        fixes #224

    Angenommen, das neue Feature muss in der API etwas ändern, so dass
    existierender Code nun nicht mehr funktionieren würde. Dies wird mit
    dem extra Ausrufezeichen hinter dem Typ/Scope kenntlich gemacht
    (hier `feat(game)!:`).

    Zusätzlich kann man einen "Footer" in die Message einbauen, also
    eine extra Zeile am Ende, die mit dem String "BREAKING CHANGE:"
    eingeleitet wird. (vgl. [Conventional Commits \>
    Examples](https://www.conventionalcommits.org/en/v1.0.0/#examples))

Es gibt noch viele weitere Initiativen, Commit-Messages lesbarer zu
gestalten und zu vereinheitlichen. Schauen Sie sich beispielsweise
einmal [gitmoji.dev](https://github.com/carloscuesta/gitmoji) an. (*Mit
einem Einsatz in einem professionellen Umfeld wäre ich hier aber sehr
... vorsichtig.*)

##### Wrap-Up

-   Änderungen einpflegen zweistufig (`add`, `commit`)
-   Status der Workingcopy mit `status` ansehen
-   Logmeldungen mit `log` ansehen
-   Änderungen auf einem File mit `diff` bzw. `blame` ansehen
-   Projektstand markieren mit `tag`
-   Ignorieren von Dateien/Ordnern: Datei `.gitignore`

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Chacon und Straub ([2014, Kap. 2](#ref-Chacon2014))
> -   Atlassian Pty Ltd ([2022](#ref-AtlassianGit))
> -   Github Inc. ([2022](#ref-GitCheatSheet))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k3: Ich kann Dateien zur Versionskontrolle hinzufügen bzw. aus der
>     Versionierung löschen
> -   k3: Ich kann Änderungen (geänderte Dateien) zum Staging hinzufügen
>     und committen
> -   k3: Ich kann Unterschiede zwischen Commits herausfinden und mir
>     die Historie des Repos anschauen
> -   k3: Ich kann gezielt Dateien und Ordner von der Versionierung
>     ausnehmen (ignorieren)
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Versionierung 101**
>
> 1.  Legen Sie ein Repository an.
> 2.  Fügen Sie Dateien dem Verzeichnis hinzu und stellen Sie *einige*
>     davon unter Versionskontrolle.
> 3.  Ändern Sie eine Datei und versionieren Sie die Änderung.
> 4.  Was ist der Unterschied zwischen "`git add .; git commit`" und
>     "`git commit -a`"?
> 5.  Wie finden Sie heraus, welche Dateien geändert wurden?
> 6.  Entfernen Sie eine Datei aus der Versionskontrolle, aber nicht aus
>     dem Verzeichnis!
> 7.  Entfernen Sie eine Datei komplett (Versionskontrolle und
>     Verzeichnis).
> 8.  Ändern Sie eine Datei und betrachten die Unterschiede zum letzten
>     Commit.
> 9.  Fügen Sie eine geänderte Datei zum Index hinzu. Was erhalten Sie
>     bei `git diff <datei>`?
> 10. Wie können Sie einen früheren Stand einer Datei wiederherstellen?
>     Wie finden Sie überhaupt den Stand?
> 11. Legen Sie sich ein Java-Projekt in Ihrer IDE an an. Stellen Sie
>     dieses Projekt unter Git-Versionskontrolle. Führen Sie die vorigen
>     Schritte mit Ihrer IDE durch.
>
> </details>

<a id="id-097aec8f1fbaaecb9f5c7cce8f7adb057ecedd6f"></a>

#### Git Branches: Features unabhängig entwickeln und mit Git verwalten

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Die Commits in Git bauen aufeinander auf und bilden dabei eine
> verkettete "Liste". Diese "Liste" nennt man auch *Branch*
> (Entwicklungszweig). Beim Initialisieren eines Repositories wird
> automatisch ein Default-Branch angelegt, auf dem die Commits dann
> eingefügt werden.
>
> Weitere Branches kann man mit `git branch` anlegen, und die
> Workingcopy kann mit `git switch` oder `git checkout` auf einen
> anderen Branch umgeschaltet werden. Auf diese Weise kann man an
> mehreren Features parallel arbeiten, ohne dass die Arbeiten sich
> gegenseitig stören.
>
> Zum Mergen (Vereinigen) von Branches gibt es `git merge`. Dabei werden
> die Änderungen im angegebenen Branch in den aktuell in der Workingcopy
> ausgecheckten Branch integriert und hier ggf. ein neuer Merge-Commit
> erzeugt. Falls es in beiden Branches inkompatible Änderungen an der
> selben Stelle gab, entsteht beim Mergen ein Merge-Konflikt. Dabei
> zeigt Git in den betroffenen Dateien jeweils an, welche Änderung aus
> welchem Branch stammt und man muss diesen Konflikt durch Editieren der
> Stellen manuell beheben.
>
> Mit `git rebase` kann die Wurzel eines Branches an eine andere Stelle
> verschoben werden. Dies wird später bei Workflows eine Rolle spielen.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Git Branches](https://youtu.be/WXPJOsgeR10)
> -   [Demo Anlegen und Mergen von
>     Branches](https://youtu.be/B8sesK1GyiE)
> -   [Demo Auflösen von Merge-Konflikten](https://youtu.be/iEr9i8auF7c)
> -   [Demo HEAD](https://youtu.be/U4gd0FBBqZQ)
>
> </details>

##### Neues Feature entwickeln/ausprobieren

    A---B---C  master

-   Bisher nur lineare Entwicklung: Commits bauen aufeinander auf
    (lineare Folge von Commits)
-   `master` ist der (Default-) Hauptentwicklungszweig
    -   Pointer auf letzten Commit
    -   Default-Name: "`master`" (muss aber nicht so sein bzw. kann
        geändert werden)

*Anmerkung*: Git und auch Github haben den Namen für den Default-Branch
von `master` auf `main`geändert. Der Name an sich ist aber für Git
bedeutungslos und kann mittels
`git config --global init.defaultBranch <name>` geändert werden. In
Github hat der Default-Branch eine gewisse Bedeutung, beispielsweise ist
der Default-Branch das automatische Ziel beim Anlegen von Pull-Requests.
In Github kann man den Default-Namen global in den User-Einstellungen
(Abschnitt "Repositories") und für jedes einzelne Repository in den
Repo-Einstellungen (Abschnitt "Branches") ändern.

Entwicklung des neuen Features soll stabilen `master`-Branch nicht
beeinflussen =\> Eigenen Entwicklungszweig für die Entwicklung des
Features anlegen:

1.  Neuen Branch erstellen: `git branch wuppie`
2.  Neuen Branch auschecken: `git checkout wuppie` oder
    `git switch wuppie`

Alternativ: `git checkout -b wuppie` oder `git switch -c wuppie` (neuer
Branch und auschecken in einem Schritt)

    A---B---C  master, wuppie

Startpunkt: prinzipiell beliebig (jeder Commit in der Historie möglich).

Die gezeigten Beispiel zweigen den neuen Branch direkt vom aktuell
ausgecheckten Commit/Branch ab. Also aufpassen, was gerade in der
Workingcopy los ist!

Alternativ nutzen Sie die Langform: `git branch wuppie master` (mit
`master` als Startpunkt; hier kann jeder beliebige Branch, Tag oder
Commit genutzt werden).

Nach Anlegen des neuen Branches zeigen beide Pointer auf den selben
Commit.

*Anmerkung*: In neueren Git-Versionen wurde der Befehl "`switch`"
eingeführt, mit dem Sie in der Workingcopy auf einen anderen Branch
wechseln können. Der bisherige Befehl "`checkout`" funktioniert aber
weiterhin.

##### Arbeiten im Entwicklungszweig ...

              D  wuppie
             /
    A---B---C  master

-   Entwicklung des neuen Features erfolgt im eigenen Branch:
    beeinflusst den stabilen `master`-Branch nicht
-   Wenn in der Workingcopy der Feature-Branch ausgecheckt ist, gehen
    die Commits in den Feature-Branch; der `master` bleibt auf dem alten
    Stand
-   Wenn der `master` ausgecheckt wäre, würden die Änderungen in den
    `master` gehen, d.h. der `master` würde sich ab Commit `C` parallel
    zu `wuppie` entwickeln

##### Problem: Fehler im ausgelieferten Produkt

              D  wuppie
             /
    A---B---C  master

Fix für `master` nötig:

1.  `git checkout master`
2.  `git checkout -b fix`
3.  Änderungen in `fix` vornehmen ...

Das führt zu dieser Situation:

              D  wuppie
             /
    A---B---C  master
             \
              E  fix

`git checkout <branchname>` holt den aktuellen Stand des jeweiligen
Branches in die Workingcopy. (Das geht in neueren Git-Versionen auch mit
`git switch <branchname>`.)

Man kann weitere Branches anlegen, d.h. hier im Beispiel ein neuer
Feature-Branch `fix`, der auf dem `master` basiert. Analog könnte man
auch Branches auf der Basis von `wuppie` anlegen ...

##### Fix ist stabil: Integration in *master*

              D  wuppie
             /
    A---B---C  master
             \
              E  fix

1.  `git checkout master`
2.  `git merge fix` =\> **fast forward** von `master`
3.  `git branch -d fix`

Der letzte Schritt entfernt den Branch `fix`.

              D  wuppie
             /
    A---B---C---E  master

-   Allgemein: `git merge <branchname>` führt die Änderungen im
    angegebenen Branch `<branchname>` in den aktuell in der Workingcopy
    ausgecheckten Branch ein. Daraus resultiert für den aktuell
    ausgecheckten Branch ein neuer Commit, der Branch `<branchname>`
    bleibt dagegen auf seinem bisherigen Stand.

    Beispiel:

    -   Die Workingcopy ist auf `A`
    -   `git merge B` führt `A` und `B` zusammen: `B` wird **in** `A`
        gemergt
    -   Wichtig: Der Merge-Commit (sofern nötig) findet hierbei in `A`
        statt!

    In der Abbildung ist `A` der `master` und `B` der `fix`.

-   Nach dem Merge existieren beide Branches weiter (sofern sie nicht
    explizit gelöscht werden)

-   Hier im Beispiel findet ein sogenannter "Fast forward" statt.

    "Fast forward" ist ein günstiger Spezialfall beim Merge: Beide
    Branches liegen in einer direkten Kette, d.h. der Zielbranch kann
    einfach "weitergeschaltet" werden. Ein Merge-Commit ist in diesem
    Fall nicht notwendig und wird auch nicht angelegt.

##### Feature weiter entwickeln ...

              D---F  wuppie
             /
    A---B---C---E  master

1.  `git switch wuppie`
2.  Weitere Änderungen im Branch `wuppie` ...

`git switch <branchname>` holt den aktuellen Stand des jeweiligen
Branches in die Workingcopy. Man kann also jederzeit in der Workingcopy
die Branches wechseln und entsprechend weiterarbeiten.

*Hinweis*: Während der neue `git switch`-Befehl nur Branches umschalten
kann, funktioniert `git checkout` sowohl mit Branchnamen und
Dateinamen - damit kann man also auch eine andere Version einer Datei in
der Workingcopy "auschecken". Falls gleiche Branch- und Dateinamen
existieren, muss man für das Auschecken einer Datei noch "`--`" nutzen:
`git checkout -- <dateiname>`.

##### Feature ist stabil: Integration in *master*

              D---F  wuppie                            D---F  wuppie
             /                     =>                 /     \
    A---B---C---E  master                    A---B---C---E---G  master

1.  `git checkout master`
2.  `git merge wuppie` =\> Kein *fast forward* möglich: Git sucht nach
    gemeinsamen Vorgänger

Hier im Beispiel ist der Standardfall beim Mergen dargestellt: Die
beiden Branches liegen nicht in einer direkten Kette von Commits, d.h.
hier wurde parallel weitergearbeitet.

Git sucht in diesem Fall nach dem gemeinsamen Vorgänger beider Branches
und führt die jeweiligen Änderungen (Differenzen) seit diesem Vorgänger
in einem Merge-Commit zusammen.

Im `master` entsteht ein neuer Commit, da kein *fast forward* beim
Zusammenführen der Branches möglich!

*Anmerkung*: `git checkout wuppie; git merge master` würde den `master`
in den `wuppie` mergen, d.h. der Merge-Commit wäre dann in `wuppie`.

Beachten Sie dabei die "Merge-Richtung":

-   Die Workingcopy ist auf `A`
-   `git merge B` führt `A` und `B` zusammen: `B` wird **in** `A`
    gemergt
-   Wichtig: Der Merge-Commit (sofern nötig) findet hierbei in `A`
    statt!

In der Abbildung ist `A` der `master` und `B` der `wuppie`.

**Achtung**: Richtung beachten! `git checkout A; git merge B` führt
beide Branches zusammen, genauer: führt die Änderungen von `B` in `A`
ein, d.h. der entsprechende Merge-Commit ist in `A`!

##### Konflikte beim Mergen

(Parallele) Änderungen an selber Stelle =\> Merge-Konflikte

    $ git merge wuppie
    Auto-merging hero.java
    CONFLICT (content): Merge conflict in hero.java
    Automatic merge failed; fix conflicts and then commit the result.

Git fügt Konflikt-Marker in die Datei ein:

    <<<<<<< HEAD:hero.java
    public void getActiveAnimation() {
        return null;
    =======
    public Animation getActiveAnimation() {
        return this.idleAnimation;
    >>>>>>> wuppie:hero.java

-   Der Teil mit `HEAD` ist aus dem aktuellen Branch in der Workingcopy
-   Der Teil aus dem zu mergenden Branch ist unter `wuppie` notiert
-   Das `=======` trennt beide Bereiche

##### Merge-Konflikte auflösen

Manuelles Editieren nötig (Auflösung des Konflikts):

1)  Entfernen der Marker
2)  Hinzufügen der Datei zum Index
3)  Analog für restliche Dateien mit Konflikt
4)  Commit zum Abschließen des Merge-Vorgangs

Alternativ: Nutzung graphischer Oberflächen mittels `git mergetool`

<p align="right"><a href="https://youtu.be/B8sesK1GyiE">Konsole: Branchen und Mergen</a></p>

##### Rebasen: Verschieben von Branches

              D---F  wuppie                            D---F  wuppie
             /                     =>                 /     \
    A---B---C---E  master                    A---B---C---E---G  master

Bisher haben wir Branches durch Mergen zusammengeführt. Dabei entsteht
in der Regel ein extra Merge-Commit (im Beispiel `G`), außer es handelt
sich um ein *fast forward*. Außerdem erkennt man in der Historie sehr
gut, dass hier in einem separaten Branch gearbeitet wurde, der
irgendwann in den `master` gemergt wurde.

Leider wird dieses Vorgehen in großen Projekten recht schnell sehr
unübersichtlich. Außerdem werden Merges in der Regeln nur von besonders
berechtigten Personen (Manager) durchgeführt, die im Falle von
Merge-Konflikten diese dann selbst auflösen müssten (ohne aber die
fachliche Befähigung zu haben). Hier greift man dann häufig zur
Alternative *Rebase*. Dabei wird der Ursprung eines Branches auf einen
bestimmten Commit verschoben. Im Anschluss ist dann ein Merge mit *fast
forward*, also ohne die typischen rautenförmigen Ketten in der Historie
und ohne extra Merge-Commit möglich. Dies kann aber auch als Nachteil
gesehen werden, da man in der Historie den früheren Branch nicht mehr
erkennt! Ein weiterer schwerwiegender Nachteil ist, dass alle Commits im
verschobenen Branch umgeschrieben werden und damit neue Commit-IDs
bekommen. Das verursacht bei der Zusammenarbeit in Projekten massive
Probleme! Als Vorteil gilt, dass man mögliche Merge-Konflikte bereits
beim Rebasen auflösen muss, d.h. hier muss derjenige, der den Merge
"beantragt", durch einen vorherigen Rebase den konfliktfreien Merge
sicherstellen. Mehr dazu in
["Branching-Strategien"](#id-4d6861ad376a0b2e0387b1a92bfe1dde822ccb7f)
und ["Workflows"](#id-fde0fd70583957b6ab46f130656a605feb110e95).

    git rebase master wuppie

führt zu

                  D'---F'  wuppie
                 /
    A---B---C---E  master

Nach dem Rebase von `wuppie` auf `master` sieht es so aus, als ob der
Branch `wuppie` eben erst vom `master` abgezweigt wurde. Damit ist dann
ein *fast forward* Merge von `wuppie` in den `master` möglich, d.h. es
gibt keine Raute und auch keinen extra Merge-Commit (hier nicht
gezeigt).

Man beachte aber die Änderung der Commit-IDs von `wuppie`: Aus `D` wird
`D'`! (Datum, Ersteller und Message bleiben aber erhalten.)

##### Don't lose your HEAD

-   Branches sind wie Zeiger auf letzten Stand (Commit) eines Zweiges

-   `HEAD`: Spezieller Pointer

    -   Zeigt auf den aktuellen Branch der Workingcopy

<!-- -->

-   Früheren Commit auschecken (ohne Branch): "headless state"
    -   Workingcopy ist auf früherem Commit

    -   Kein Branch =\> Änderungen gehen verloren!

        Eventuelle Änderungen würden ganz normal als Commits auf dem
        `HEAD`-Branch aufgezeichnet. Sobald man aber einen anderen
        Branch auscheckt, wird der `HEAD` auf diesen anderen Branch
        gesetzt, so dass die eben gemachten Commits "in der Luft
        hängen". Sofern man die SHA's kennt, kommt man noch auf die
        Commits zurück. Allerdings laufen von Zeit zu Zeit interne
        Aufräum-Aktionen, so dass die Chance gut steht, dass die
        "kopflosen" Commits irgendwann tatsächlich verschwinden.

##### Wrap-Up

-   Anlegen von Branches mit `git branch`
-   Umschalten der Workingcopy auf anderen Branch: `git checkout` oder
    `git switch`
-   Mergen von Branches und Auflösen von Konflikten: `git merge`
-   Verschieben von Branches mit `git rebase`

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Chacon und Straub ([2014, Kap. 3](#ref-Chacon2014))
> -   Atlassian Pty Ltd ([2022](#ref-AtlassianGit))
> -   Github Inc. ([2022](#ref-GitCheatSheet))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k3: Ich kann neue Branches anlegen
> -   k3: Ich kann Branches mergen und mögliche Konflikte auflösen
> -   k3: Ich kann Branches rebasen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Branches und Merges**
>
> 1.  Legen Sie in Ihrem Projekt einen Branch an. Ändern Sie einige
>     Dateien und committen Sie die Änderungen. Checken Sie den
>     Master-Branch aus und mergen Sie die Änderungen. Was beobachten
>     Sie?
>
> 2.  Legen Sie einen weiteren Branch an. Ändern Sie einige Dateien und
>     committen Sie die Änderungen. Checken Sie den Master-Branch aus
>     und ändern Sie dort ebenfalls:
>
>     -   Ändern Sie eine Datei an einer Stelle, die nicht bereits im
>         Branch modifiziert wurde.
>     -   Ändern Sie eine Datei an einer Stelle, die bereits im Branch
>         manipuliert wurde.
>
>     Committen Sie die Änderungen.
>
>     Mergen Sie den Branch jetzt in den Master-Branch. Was beobachten
>     Sie? Wie lösen Sie Konflikte auf?
>
> **Mergen am Beispiel**
>
> Sie verwalten Ihr Projekt mit Git. Es existieren zwei Branches:
> `master` (zeigt auf Commit $C$) und `feature` (zeigt auf Version $F$).
> In Ihrer Workingcopy haben Sie den Branch `feature` ausgecheckt:
>
> <p align="center"><img src="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/git/images/before.png?raw=true" width="35%" /></p>
>
> (1) Mit welcher Befehlsfolge können Sie den Branch `feature` in den
>     Branch `master` mergen, so dass nach dem Merge die im folgenden
>     Bild dargestellte Situation entsteht?
>
> <p align="center"><img src="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/git/images/after.png?raw=true" width="35%" /></p>
>
> (Der Merge läuft ohne Konflikte ab. Es ist irrelevant, welcher Branch
> am Ende in der Workingcopy ausgecheckt ist.)
>
> (2) Wie können Sie erreichen, dass es keinen Merge-Commit gibt,
>     sondern dass die Änderungen in $D$ und $F$ im `master` als eine
>     lineare Folge von Commits erscheinen?
>
> **Interaktive Git-Tutorials**: Schaffen Sie die Rätsel?
>
> -   [Learn Git Branching](https://learngitbranching.js.org/)
> -   [Oh My Git!](https://ohmygit.org/)
> -   [Git Time](https://git.bradwoods.io/)
> -   [Tutorial: A Visual Git
>     Reference](https://marklodato.github.io/visual-git-guide/index-en.html)
>
> </details>

<a id="id-4d6861ad376a0b2e0387b1a92bfe1dde822ccb7f"></a>

#### Branching-Strategien mit Git

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Das Erstellen und Mergen von Branches ist in Git besonders einfach.
> Dies kann man sich in der Entwicklung zunutze machen und die einzelnen
> Features unabhängig voneinander in eigenen Hilfs-Branches ausarbeiten.
>
> Es haben sich zwei grundlegende Modelle etabliert: "Git-Flow" und
> "GitHub Flow".
>
> In **Git-Flow** gibt es ein umfangreiches Konzept mit verschiedenen
> Branches für feste Aufgaben, welches sich besonders gut für
> Entwicklungmodelle mit festen Releases eignet. Es gibt zwei
> langlaufende Branches: `master` enthält den stabilen veröffentlichten
> Stand, in `develop` werden die Ergebnisse der Entwicklung gesammelt.
> Features werden in kleinen Feature-Branches entwickelt, die von
> `develop` abzweigen und dort wieder hineinmünden. Für Releases wird
> von `develop` ein eigener Release-Branch angelegt und nach
> Finalisierung in den `master` und in `develop` gemergt. Fixes werden
> vom `master` abgezweigt, und wieder in den `master` und auch nach
> `develop` integriert. Dadurch stehen auf dem `master` immer die
> stabilen Release-Stände zur Verfügung, und im `develop` sammeln sich
> die Entwicklungsergebnisse.
>
> Der **GitHub Flow** basiert auf einem deutlich schlankeren Konzept und
> passt gut für die kontinuierliche Entwicklung ohne echte Releases.
> Hier hat man auch wieder einen `master` als langlaufenden Branch, der
> die stabilen Release-Stände enthält. Vom `master` zweigen direkt die
> kleinen Feature-Branches ab und werden auch wieder direkt in den
> `master` integriert.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Git Branching-Strategien](https://youtu.be/v1WHIPdoA0k)
>
> </details>

##### Nutzung von Git in Projekten: Verteiltes Git (und Workflows)

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/distributed.png" width="60%" /></p>

Git ermöglicht ein einfaches und schnelles Branchen. Dies kann man mit
entsprechenden Branching-Strategien sinnvoll für die SW-Entwicklung
einsetzen.

Im Folgenden sollen also die Frage betrachtet werden: **Wie setze ich
Branches sinnvoll ein?**

##### Umgang mit Branches: Themen-Branches

                    I---J---K  wuppieV1
                   /
              D---F  wuppie
             /
    A---B---C---E  master
                 \
                  G---H  test

Branchen ist in Git sehr einfach und schnell. Deshalb wird (gerade auch
im Vergleich mit SVN) gern und viel gebrancht.

Ein häufiges anzutreffendes Modell ist dabei die Nutzung von
**Themen-Branches**: Man hat einen Hauptzweig (`master`). Wann immer
eine neue Idee oder ein Baustein unabhängig entwickelt werden soll/kann,
wird ein entsprechender Themen-Branch aufgemacht. Dabei handelt es sich
normalerweise um **kleine Einheiten**!

Themenbranches haben in der Regel eine **kurze Lebensdauer**: Wenn die
Entwicklung abgeschlossen ist, wird die Idee bzw. der Baustein in den
Hauptzweig integriert und der Themenbranch gelöscht.

-   Vorteil: Die Entwicklung im Themenbranch ist in sich gekapselt und
    stört nicht die Entwicklung in anderen Branches (und diese stören
    umgekehrt nicht die Entwicklung im Themenbranch).

-   Nachteil:

    -   Mangelnder Überblick durch viele Branches
    -   Ursprung der Themenbranches muss überlegt gewählt werden, d.h.
        alle dort benötigten Features müssen zu dem Zeitpunkt im
        Hauptzweig vorhanden sein

##### Umgang mit Branches: Langlaufende Branches

    A---B---D  master
         \
          C---E---I  develop
               \
                F---G---H  topic

Häufig findet man in (größeren) Projekten Branches, die über die gesamte
Lebensdauer des Projekts existieren, sogenannte "langlaufende Branches".

Normalerweise gibt es einen Branch, in dem stets der stabile Stand des
Projekts enthalten ist. Dies ist häufig der `master`. In diesem Branch
gibt es nur sehr wenige Commits: normalerweise nur Merges aus dem
`develop`-Branch (etwa bei Fertigstellung einer Release-Version) und
ggf. Fehlerbehebungen.

Die aktive Entwicklung findet in einem separaten Branch statt:
`develop`. Hier nutzt man zusätzlich Themen-Branches für die Entwicklung
einzelner Features, die nach Fertigstellung in den `develop` gemergt
werden.

Kleinere Projekte kommen meist mit den zwei langlaufenden Branches in
der obigen Darstellung aus. Bei größeren Projekten finden sich häufig
noch etliche weitere langlaufende Branches, beispielsweise "Proposed
Updates" etc. beim Linux-Kernel.

-   Vorteile:
    -   Mehr Struktur im Projekt durch in ihrer Semantik wohldefinierte
        Branches
    -   Durch weniger Commits pro Branch lässt sich die Historie
        leichter verfolgen (u.a. auch aus bestimmter Rollen-Perspektive:
        Entwickler, Manager, ...)
-   Nachteile: Bestimmte "ausgezeichnete" Branches; zusätzliche Regeln
    zum Umgang mit diesen beachten

##### Komplexe Branching-Strategie: Git-Flow

    A---B---------------------G---J1  master
         \                   / \ /
          \                 /   X  fix
           \               /     \
            C-------------F----I--J2  develop
             \           / \  /
              \         /   H1  featureB
               \       /
                D1----D2  featureA
                 \
                  E1---E2---E3---E4---E5  featureC

Das Git-Flow-Modell von Vincent Driessen
([nvie.com/posts/a-successful-git-branching-model](http://nvie.com/posts/a-successful-git-branching-model/))
zeigt einen in der Praxis überaus bewährten Umgang mit Branches. Lesen
Sie an der angegebenen Stelle nach, besser kann man die Nutzung dieses
eleganten Modells eigentlich nicht erklären :-)

##### Git-Flow: Hauptzweige *master* und *develop*

    A---B-------E---------------J  master
         \     /               /
          C---D---F---G---H---I---K  develop

Bei Git-Flow gibt es zwei langlaufende Branches: Den `master`, der immer
den stabilen Stand enthält und in den *nie* ein direkter Commit gemacht
wird, sowie den `develop`, wo letztlich (ggf. über Themenbranches) die
eigentliche Entwicklung stattfindet.

Änderungen werden zunächst im `develop` erstellt und getestet. Wenn die
Features stabil sind, erfolgt ein Merge von `develop` in den `master`.
Hier kann noch der Umweg über einen `release`-Branch genommen werden:
Als "Feature-Freeze" wird vom `develop` ein `release`-Branch abgezweigt.
Darin wird das Release dann aufpoliert, d.h. es erfolgen nur noch
kleinere Korrekturen und Änderungen, aber keine echte Entwicklungsarbeit
mehr. Nach Fertigstellung wird der `release` dann sowohl in den `master`
als auch `develop` gemergt.

##### Git-Flow: Weitere Branches als Themen-Branches

    A---B---------------------I-------------K  master
         \                   /             /
          C------------F----H-------------J---L  develop
           \          / \  /             /
            \        /   G1  featureB   /
             \      /                  /
              D1---D2  featureA       /
               \                     /
                E1---E2---E3---E4---E5  featureC

Für die Entwicklung eigenständiger Features bietet es sich auch im
Git-Flow an, vom `develop` entsprechende Themenbranches abzuzweigen und
darin jeweils isoliert die Features zu entwickeln. Wenn diese Arbeiten
eine gewisse Reife haben, werden die Featurebranches in den `develop`
integriert.

##### Git-Flow: Merging-Detail

    ---C--------E  develop
        \      /                 git merge --no-ff
         D1---D2  featureA

vs.

    ---C---D1---D2  develop      git merge

Wenn beim Mergen ein "*fast forward*" möglich ist, würde Git beim Mergen
eines (Feature-) Branches in den `develop` (oder allgemein in einen
anderen Branch) *keinen* separaten Commit erzeugen (Situation rechts in
der Abbildung).

Damit erscheint der `develop`-Branch wie eine lineare Folge von Commits.
In manchen Projekten wird dies bevorzugt, weil die Historie sehr
übersichtlich aussieht.

Allerdings verliert man die Information, dass hier ein Feature
entwickelt wurde und wann es in den `develop` integriert wurde (linke
Seite in obiger Abbildung). Häufig wird deshalb ein extra Merge-Commit
mit `git merge --no-ff <branch>` (extra Schalter "`--no-ff`") erzwungen,
obwohl ein "*fast forward*" möglich wäre.

Anmerkung: Man kann natürlich auch über Konventionen in den
Commit-Kommentaren eine gewisse Übersichtlichkeit erzwingen.
Beispielsweise könnte man vereinbaren, dass alle Commit-Kommentare zu
einem Feature "A" mit "`feature a:`" starten müssen.

##### Git-Flow: Umgang mit Fehlerbehebung

    A---B---D--------F1  master
         \   \      /
          \   E1---E2  fix
           \        \
            C1-------F2  develop

Wenn im stabilen Branch (also dem `master`) ein Problem bekannt wird,
darf man es nicht einfach im `master` fixen. Stattdessen wird ein extra
Branch vom `master` abgezweigt, in dem der Fix entwickelt wird. Nach
Fertigstellung wird dieser Branch sowohl in den `master` als auch den
`develop` gemergt, damit auch im Entwicklungszweig der Fehler behoben
ist.

Dadurch entspricht jeder Commit im `master` einem Release.

##### Vereinfachte Braching-Strategie: GitHub Flow

    A---B---C----D-----------E  master
         \   \  /           /
          \   ta1  topicA  /
           \              /
            tb1---tb2---tb3  topicB

Github verfolgt eine deutlich vereinfachte Strategie: "GitHub Flow"
(vgl. ["GitHub Flow" (S. Chacon)](https://githubflow.github.io/) bzw.
["GitHub flow" (GitHub,
Inc.)](https://docs.github.com/en/get-started/quickstart/github-flow)).

Hier ist der stabile Stand ebenfalls immer im `master`. Features werden
ebenso wie im Git-Flow-Modell in eigenen Feature-Branches entwickelt.

Allerdings zweigen Feature-Branches *immer direkt* vom `master` ab und
werden nach dem Test auch immer dort wieder direkt integriert (es gibt
also keine weiteren langlaufenden Branches wie `develop` oder
`release`).

In der obigen Abbildung ist zu sehen, dass für die Entwicklung eines
Features ein entsprechender Themenbranch vom `master` abgezweigt wird.
Darin erfolgt dann die Entwicklung des Features, d.h. mehrere Commits.
Das Mergen des Features in den `master` erfolgt dann aber nicht lokal,
sondern mit einem "Pull-Request" auf dem Server: Sobald man im
Feature-Branch einen "diskussionswürdigen" Stand hat, wird ein
**Pull-Request** (*PR*) über die Weboberfläche aufgemacht (streng
genommen gehört dies in die Kategorie ["Zusammenarbeit" bzw.
"Workflows"](#id-fde0fd70583957b6ab46f130656a605feb110e95); außerdem
gehört ein PR nicht zu Git selbst, sondern zum Tooling von Github). In
einem PR können andere Entwickler den Code kommentieren und ergänzen.
Jeder weitere Commit auf dem Themenbranch wird ebenfalls Bestandteil des
Pull-Requests. Parallel laufen ggf. automatisierte Tests etc. und durch
das Akzeptieren des PR in der Weboberfläche erfolgt schließlich der
Merge des Feature-Branches in den `master`.

##### Diskussion: Git-Flow vs. GitHub Flow

In der Praxis zeigt sich, dass das Git-Flow-Modell besonders gut
geeignet ist, wenn man tatsächlich so etwas wie "Releases" hat, die
zudem nicht zu häufig auftreten.

Das GitHub-Flow-Vorgehen bietet sich an, wenn man entweder keine
Releases hat oder diese sehr häufig erfolgen (typisch bei agiler
Vorgehensweise). Zudem vermeidet man so, dass die Feature-Branches zu
lange laufen, womit normalerweise die Wahrscheinlichkeit von
Merge-Konflikten stark steigt. **Achtung**: Da die Feature-Branches
direkt in den `master`, also den stabilen Produktionscode gemergt
werden, ist es hier besonders wichtig, *vor* dem Merge entsprechende
Tests durchzuführen und den Merge erst zu machen, wenn alle Tests "grün"
sind.

Hier ein paar Einstiegsseiten für die Diskussion, die teilweise sehr
erbittert (und mit ideologischen Zügen) geführt wird (erinnert an die
Diskussionen, welche Linux-Distribution die bessere sei):

-   [Git-Flow-Modell von Vincent
    Driessen](https://nvie.com/posts/a-successful-git-branching-model/)
-   [Kurzer Überblick über das
    GitHub-Flow-Modell](https://guides.github.com/introduction/flow/)
-   [Diskussion des GitHub-Flow-Modells
    (Github)](https://githubflow.github.io/)
-   [Luca Mezzalira: "Git-Flow vs Github
    Flow"](https://lucamezzalira.com/2014/03/10/git-flow-vs-github-flow/)
-   [Scott Schacon, Autor des
    Pro-Git-Buchs](https://scottchacon.com/2011/08/31/github-flow.html)
-   [Noch eine (längere) Betrachtung (Robin
    Daugherty)](https://hackernoon.com/a-branching-and-releasing-strategy-that-fits-github-flow-be1b6c48eca2)

##### Wrap-Up

-   Einsatz von Themenbranches für die Entwicklung
-   Unterschiedliche Modelle:
    -   Git-Flow: umfangreiches Konzept, gut für Entwicklung mit festen
        Releases
    -   GitHub Flow: deutlich schlankeres Konzept, passend für
        kontinuierliche Entwicklung ohne echte Releases

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Chacon und Straub ([2014, Kap. 3](#ref-Chacon2014))
> -   Driessen ([2010](#ref-GitFlow))
> -   Chacon ([2013](#ref-GitHubFlow))
> -   GitHub Inc. ([2022b](#ref-GitHubFlowGH))
> -   Atlassian Pty Ltd ([2022](#ref-AtlassianGit))
> -   Github Inc. ([2022](#ref-GitCheatSheet))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k3: Ich kann mit Themenbranches in der Entwicklung arbeiten
> -   k3: Ich kann das 'Git-Flow'-Modell anwenden
> -   k3: Ich kann das 'GitHub Flow'-Modell anwenden
>
> </details>

<a id="id-891ec209f76a247e09e9c1cd306bd531b6ebe897"></a>

#### Arbeiten mit Git Remotes (dezentrale Repos)

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Eine der Stärken von Git ist das Arbeiten mit verteilten Repositories.
> Zu jeder Workingcopy gehört eine Kopie des Repositories, wodurch
> jederzeit alle Informationen einsehbar sind und auch offline
> gearbeitet werden kann. Allerdings muss man für die Zusammenarbeit mit
> anderen Entwicklern die lokalen Repos mit den "entfernten" Repos (auf
> dem Server oder anderen Entwicklungsrechnern) synchronisieren.
>
> Beim Klonen eines Repositories mit `git clone <url>` wird das fremde
> Repo mit dem Namen `origin` im lokalen Repo festgehalten. Dieser Name
> wird auch als Präfix für die Branches in diesem Repo genutzt, d.h. die
> Branches im Remote-Repo tauchen als `origin/<branch>` im lokalen Repo
> auf. Diese Remote-Branches kann man nicht direkt bearbeiten, sondern
> man muss diese Remote-Branches in einem lokalen Branch auschecken und
> dann darin weiterarbeiten. Es können beliebig viele weitere Remotes
> dem eigenen Repository hinzugefügt werden.
>
> Änderungen aus einem Remote-Repo können mit `git fetch <remote>` in
> das lokale Repo geholt werden. Dies aktualisiert **nur** die
> Remote-Branches `<remote>/<branch>`! Die Änderungen können
> anschließend mit `git merge <remote>/<branch>` in den aktuell in der
> Workingcopy ausgecheckten Branch gemergt werden. (*Anmerkung*: Wenn
> mehrere Personen an einem Branch arbeiten, will man die eigenen
> Arbeiten in dem Branch vermutlich eher auf den aktuellen Stand des
> Remote **rebasen** statt mergen!) Eigene Änderungen können mit
> `git push <remote> <branch>` in das Remote-Repo geschoben werden.
>
> Um den Umgang mit den Remote-Branches und den davon abgeleiteten
> lokalen Branches zu vereinfachen, gibt es das Konzept der "Tracking
> Branches". Dabei "folgt" ein lokaler Branch einem Remote-Branch. Ein
> einfaches `git pull` oder `git push` holt dann Änderungen aus dem
> Remote-Branch in den ausgecheckten lokalen Branch bzw. schiebt
> Änderungen im lokalen Branch in den Remote-Branch.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Git Remotes](https://youtu.be/_uhEseblDYU)
> -   [Demo Fetch, Pull und Push](https://youtu.be/moqywsxtEy8)
> -   [Demo Tracking-Branches](https://youtu.be/0RoqM5Wmxfc)
> -   [Demo Verknüpfen weiterer Remotes](https://youtu.be/jL4AvSsjjKg)
>
> </details>

##### Nutzung von Git in Projekten: Verteiltes Git (und Workflows)

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/distributed.png" width="65%" /></p>

Git ermöglicht eine einfaches Zusammenarbeit in verteilten Teams.
Nachdem wir die verschiedenen Branching-Strategien betrachtet haben,
soll im Folgenden die Frage betrachtet werden: **Wie arbeite ich
sinnvoll über Git mit anderen Kollegen und Teams zusammen? Welche
Modelle haben sich etabliert?**

##### Clonen kann sich lohnen ...

    https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture

    ---C---D---E  master

=\>
`git clone https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture`

    ./Prog2-Lecture/  (lokaler Rechner)

    ---C---D---E  master
               ^origin/master

Git-Repository mit der URL `<URL-Repo>` in lokalen Ordner `<directory>`
auschecken:

-   `git clone <URL-Repo> [<directory>]`
-   Workingcopy ist automatisch über den Namen `origin` mit dem remote
    Repo auf dem Server verbunden
-   Lokaler Branch `master` ist mit dem remote Branch `origin/master`
    verbunden ("Tracking Branch", s.u.), der den Stand des
    `master`-Branches auf dem Server spiegelt

Für die URL sind verschiedene Protokolle möglich, beispielsweise:

-   "`file://`" für über das Dateisystem erreichbare Repositories (ohne
    Server)
-   "`https://`" für Repo auf einem Server: Authentifikation mit
    Username und Passwort (!)
-   "`git@`" für Repo auf einem Server: Authentifikation mit **SSH-Key**
    (diese Variante wird im Praktikum im Zusammenspiel mit dem
    Gitlab-Server im SW-Labor verwendet)

##### Eigener und entfernter *master* entwickeln sich weiter ...

    https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture

    ---C---D---E---F---G  master

    ./Prog2-Lecture/  (lokaler Rechner)

    ---C---D---E---H  master
               ^origin/master

Nach dem Auschecken liegen (in diesem Beispiel) drei `master`-Branches
vor:

1.  Der `master` auf dem Server,
2.  der lokale `master`, und
3.  die lokale Referenz auf den `master`-Branch auf dem Server:
    `origin/master`.

Der lokale `master` ist ein normaler Branch und kann durch Commits
verändert werden.

Der `master` auf dem Server kann sich ebenfalls ändern, beispielsweise
weil jemand anderes seine lokalen Änderungen mit dem Server abgeglichen
hat (`git push`, s.u.).

Der Branch `origin/master` lässt sich nicht direkt verändern! Das ist
lediglich eine lokale Referenz auf den `master`-Branch auf dem Server
und zeigt an, welchen Stand man bei der letzten Synchronisierung hatte.
D.h. erst mit dem nächsten Abgleich wird sich dieser Branch ändern
(sofern sich der entsprechende Branch auf dem Server verändert hat).

*Anmerkung*: Dies gilt analog für alle anderen Branches. Allerdings wird
nur der `origin/master` beim Clonen automatisch als lokaler Branch
ausgecheckt.

Zur Abbildung: Während man lokal arbeitet (Commit `H` auf dem lokalen
`master`), kann es passieren, dass sich auch das remote Repo ändert. Im
Beispiel wurden dort die beiden Commits `F` und `G` angelegt (durch
`git push`, s.u.).

Wichtig: Da in der Zwischenzeit das lokale Repo nicht mit dem Server
abgeglichen wurde, zeigt der remote Branch `origin/master` immer noch
auf den Commit `E`!

##### Änderungen im Remote holen und Branches zusammenführen

    https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture

    ---C---D---E---F---G  master

=\> `git fetch origin`

    ./Prog2-Lecture/  (lokaler Rechner)

    ---C---D---E---H  master
                \
                 F---G  origin/master

###### Änderungen auf dem Server mit dem eigenen Repo abgleichen

Mit `git fetch origin` alle Änderungen holen

-   Alle remote Branches werden aktualisiert und entsprechen den
    jeweiligen Branches auf dem Server: Im Beispiel zeigt jetzt
    `origin/master` ebenso wie der `master` auf dem Server auf den
    Commit `G`.
-   Neue Branches auf dem Server werden ebenfalls "geholt", d.h. sie
    liegen nach dem Fetch als entsprechende remote Branches vor
-   Auf dem Server gelöschte Branches werden nicht automatisch lokal
    gelöscht; dies kann man mit `git fetch --prune origin` automatisch
    erreichen

*Wichtig*: Es werden nur die remote Branches aktualisiert, nicht die
lokalen Branches!

###### *master*-Branch nach "git fetch origin" zusammenführen

1.  Mit `git checkout master` Workingcopy auf eigenen `master` umstellen
2.  Mit `git merge origin/master` Änderungen am `origin/master` in
    eigenen `master` mergen
3.  Mit `git push origin master` eigene Änderungen ins remote Repo
    pushen

    https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture

    ---C---D---E---H---I  master
                \     /
                 F---G

    ./Prog2-Lecture/  (lokaler Rechner)

    ---C---D---E---H---I  master
                \     /^origin/master
                 F---G

*Anmerkung*: Schritt (2) kann man auch per `git pull origin master`
erledigen ... Ein `pull` fasst `fetch` und `merge` zusammen (s.u.).

*Anmerkung* Statt dem `merge` in Schritt (2) kann man auch den lokalen
`master` auf den aktualisierten `origin/master` rebasen und vermeidet
damit die "Raute". Der `pull` kann mit der Option "`--rebase`" auf
"rebase" umgestellt werden (per Default wird bei `pull` ein "merge"
ausgeführt).

###### Auf dem Server ist nur ein *fast forward merge* möglich

Sie können Ihre Änderungen in Ihrem lokalen `master` auch direkt in das
remote Repo pushen, solange auf dem Server ein **fast forward merge**
möglich ist.

Wenn aber (wie in der Abbildung) der lokale und der remote `master`
divergieren, müssen Sie den Merge wie beschrieben lokal durchführen
(`fetch`/`merge` oder `pull`) und das Ergebnis wieder in das remote Repo
pushen (dann ist ja wieder ein *fast forward merge* möglich, es sei
denn, jemand hat den remote `master` in der Zwischenzeit weiter
geschoben - dann muss die Aktualisierung erneut durchgeführt werden).

<p align="right"><a href="https://youtu.be/moqywsxtEy8">Beispiel für Zusammenführen (merge und push), Anmerkung zu fast forward merge</a></p>

##### Branches und Remotes

-   Eigenen (neuen) lokalen Branch ins remote Repo schicken
    -   `git push <remote> <branch>`

<!-- -->

-   Neuer Branch im remote Repo
    -   `git fetch <remote>` holt (auch) alle neuen Branches
    -   Lokale Änderungen an remote Branches nicht möglich! =\> **Remote
        Branch in lokalen Branch mergen** (oder auschecken)

##### Zusammenfassung: Arbeiten mit Remotes

1.  Änderungen vom Server holen: `git fetch <remote>` =\> Holt alle
    Änderungen vom Repo `<remote>` ins eigene Repo (Workingcopy bleibt
    unangetastet!)

<!-- -->

2.  Aktuellen lokalen Branch auffrischen: `git merge <remote>/<branch>`
    (oder alternativ `git pull <remote> <branch>`)

<!-- -->

3.  Eigene Änderungen hochladen: `git push <remote> <branch>`

###### Anmerkung: *push* geht nur, wenn

1.  Ziel ein "bare"-Repository ist, **und**
2.  keine Konflikte entstehen

=\> im remote Repo **nur** "fast forward"-Merge möglich

=\> bei Konflikten erst `fetch` und `merge`, danach `push`

**Anmerkung**: Ein "bare"-Repository enthält keine Workingcopy, sondern
nur das Repo an sich. Die ist bei Repos, die Sie auf einem Server wie
Gitlab oder Github anlegen, automatisch der Fall. Sie können aber auch
lokal ein solches "bare"-Repo anlegen, indem Sie beim Initialisieren den
Schalter `--bare` mitgeben: `git init --bare` ...

###### Beispiel

    git fetch origin           # alle Änderungen vom Server holen
    git checkout master        # auf lokalen Master umschalten
    git merge origin/master    # lokalen Master aktualisieren

    ... # Herumspielen am lokalen Master

    git push origin master     # lokalen Master auf Server schicken

##### Vereinfachung: Tracking Branches

-   **Tracking Branch**: lokaler Branch, der remote Branch "verfolgt"
    -   Beispiel: lokaler `master`-Branch folgt `origin/master` per
        Default

<!-- -->

-   **Vereinfachung im Workflow**:
    -   `git pull` entspricht
        1.  `git fetch <remote>` **plus**
        2.  `git merge <remote>/<branch>`
    -   `git push` entspricht `git push <remote> <branch>`

Vorsicht: `pull` und `push` beziehen sich nur auf ausgecheckten Tracking
Branch

##### Einrichten von Tracking Branches

-   `git clone`: lokaler `master` trackt automatisch `origin/master`

<!-- -->

-   Remote Branch als Tracking Branch einrichten:
    1.  Änderungen aus remote Repo holen: `git fetch <remote>`
    2.  Tracking Branch anlegen: `git checkout -t <remote>/<branch>`
        (=\> Option `-t` richtet den remote Branch als Tracking Branch
        ein)

<!-- -->

-   Lokalen neuen Branch ins remote Repo schicken und als Tracking
    Branch einrichten:
    1.  Lokalen Branch erzeugen: `git checkout -b <branch>`
    2.  Lokalen Branch ins Repo schicken:
        `git push -u <remote> <branch>` (=\> Option `-u` richtet den
        lokalen Branch als Tracking Branch ein)

##### Hinzufügen eines (weiteren) Remote Repository

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/screenshot_branches.png" width="65%" /></p>

Sie können einem Repo beliebig viele Remotes hinzufügen:

`git remote add <name> <url>`

**Beispiel**: `git remote add  andi  git@github.com:andi/repo.git`

-   Remote `origin` wird bei `clone` automatisch angelegt
-   Ansehen der Remotes mit `git remote -v`
-   `fetch`, `push` und `pull` jeweils über den vergebenen Namen

Beispiel: `git fetch andi` oder `git push origin master`

##### Wrap-Up

-   Synchronisierung des lokalen Repos mit anderen Repos
    -   Repo kopieren: `git clone <url>`
    -   Interner Name fürs fremde Repo: `origin`
    -   Änderungen vom fremden Repo holen: `git fetch <remote>`
    -   Änderungen in lokalen Branch einpflegen:
        `git merge <remote>/<branch>`
    -   Eigene Änderungen ins fremde Repo schieben:
        `git push <remote> <branch>`

<!-- -->

-   Tracking Branches (Konzept, Anwendung)
    -   Remote Branches können lokal nicht verändert werden:
        -   In lokale Branches mergen, oder
        -   Tracking Branches anlegen =\> einfaches `pull` und `push`
            nutzen
    -   Tracking Branches sind lokale Branches, die remote Branches
        verfolgen ("tracken")

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Chacon und Straub ([2014, Kap. 3](#ref-Chacon2014))
> -   Atlassian Pty Ltd ([2022](#ref-AtlassianGit))
> -   Github Inc. ([2022](#ref-GitCheatSheet))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k3: Ich kann Clones von fremden Git-Repositories erzeugen
> -   k3: Ich kann Änderungen vom fremden Repo holen
> -   k3: Ich kann meine lokale Branches aktualisieren
> -   k3: Ich kann lokale Änderungen ins fremde Repo pushen
> -   k2: Ich kann den Unterschied zwischen lokalen Branches und
>     entfernten Branches erklären
> -   k3: Ich kann sowohl lokale Branches als auch entfernte Branches
>     anlegen und damit arbeiten
> -   k3: Ich kann Tracking Branches zum Vereinfachen der Arbeit anlegen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Synchronisierung mit Remote-Repos**
>
> Sie haben ein Repo von github.com geklont. Beide Repos, das Original
> auf dem Server als auch Ihre lokale Kopie, haben sich danach
> unabhängig voneinander weiter entwickelt (siehe Skizze).
>
> <p align="center"><img src="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/git/images/remote-branches-2.png?raw=true" width="60%" /></p>
>
> Wie können Sie Ihre Änderung im lokalen Repo auf den Server pushen?
> Analysieren Sie die Situation und erklären Sie zwei verschiedene
> Lösungsansätze und geben Sie jeweils die entsprechenden Git-Befehle
> an.
>
> **Interaktive Git-Tutorials**: Schaffen Sie die Rätsel?
>
> -   [Learn Git Branching](https://learngitbranching.js.org/)
> -   [Oh My Git!](https://ohmygit.org/)
> -   [Git Time](https://git.bradwoods.io/)
>
> </details>

<a id="id-fde0fd70583957b6ab46f130656a605feb110e95"></a>

#### Zusammenarbeit: Git-Workflows und Merge-/Pull-Requests

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Git erlaubt unterschiedliche Formen der Zusammenarbeit.
>
> Bei kleinen Teams kann man einen einfachen zentralen Ansatz einsetzen.
> Dabei gibt es ein zentrales Repo auf dem Server, und alle
> Team-Mitglieder dürfen direkt in dieses Repo pushen. Hier muss man
> sich gut absprechen und ein vernünftiges Branching-Schema ist
> besonders wichtig.
>
> In größeren Projekten gibt es oft ein zentrales öffentliches Repo, wo
> aber nur wenige Personen Schreibrechte haben. Hier forkt man sich
> dieses Repo, erstellt also eine öffentliche Kopie auf dem Server.
> Diese Kopie klont man lokal und arbeitet hier und pusht die Änderungen
> in den eigenen öffentlich sichtbaren Fork. Um die Änderungen ins
> Projekt-Repo integrieren zu lassen, wird auf dem Server ein
> sogenannter Merge-Request (Gitlab) bzw. Pull-Request (GitHub)
> erstellt. Dies erlaubt zusätzlich ein Review und eine Diskussion
> direkt am Code. Damit man die Änderungen im Hauptprojekt in den
> eigenen Fork bekommt, trägt man das Hauptprojekt als weiteres Remote
> in die Workingcopy ein und aktualisiert regelmäßig die Hauptbranches,
> von denen dann auch die eigenen Feature-Branches ausgehen sollten.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Git Workflows](https://youtu.be/3xqmNGN39wE)
> -   [Demo Anlegen eines Forks, Erstellen eines Pull-Requests
>     (PR)](https://youtu.be/-8NOia7k0WI)
> -   [Demo Arbeiten mit einem PR, Review eines
>     PR](https://youtu.be/4LaZc080Ajo)
>
> </details>

##### Nutzung von Git in Projekten: Verteiltes Git (und Workflows)

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/distributed.png" width="65%" /></p>

Git ermöglicht ein einfaches und schnelles Branchen. Dies kann man mit
entsprechenden Branching-Strategien sinnvoll für die SW-Entwicklung
einsetzen.

Auf der anderen Seite ermöglicht Git ein sehr einfaches verteiltes
Arbeiten. Auch hier ergeben sich verschiedene Workflows, wie man mit
anderen Entwicklern an einem Projekt arbeiten will/kann.

Im Folgenden sollen also die Frage betrachtet werden: **Wie gestalte ich
die Zusammenarbeit?** Antwort: Workflows mit Git ...

##### Zusammenarbeit: Zentraler Workflow mit Git (analog zu SVN)

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/centralised.png" width="55%" /></p>

In kleinen Projektgruppen wie beispielsweise Ihrer Arbeitsgruppe wird
häufig ein einfacher zentralisierter Workflow bei der Versionsverwaltung
genutzt. Im Mittelpunkt steht dabei ein zentrales Repository, auf dem
alle Teammitglieder gleichberechtigt und direkt pushen dürfen.

-   Vorteile:
    -   Einfachstes denkbares Modell
    -   Ein gemeinsames Repo (wie bei SVN)
    -   Alle haben Schreibzugriff auf ein gemeinsames Repo

<!-- -->

-   Nachteile:
    -   Definition und Umsetzung von Rollen mit bestimmten Rechten
        ("Manager", "Entwickler", "Gast-Entwickler", ...) schwierig bis
        unmöglich (das ist kein Git-Thema, sondern hängt von der
        Unterstützung durch den Anbieter des Servers ab)
    -   Jeder darf überall pushen: Enge und direkte Abstimmung nötig
    -   Modell funktioniert meist nur in sehr kleinen Teams (2..3
        Personen)

##### Zusammenarbeit: Einfacher verteilter Workflow mit Git

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/workflow_remote.png" width="65%" /></p>

In großen und/oder öffentlichen Projekten wird üblicherweise ein
Workflow eingesetzt, der auf den Möglichkeiten von verteilten
Git-Repositories basiert.

Dabei wird zwischen verschiedenen Rollen ("Integrationsmanager",
"Entwickler") unterschieden.

Sie finden dieses Vorgehen beispielsweise beim Linux-Kernel und auch
häufig bei Projekten auf Github.

-   Es existiert ein geschütztes ("blessed") Master-Repo
    -   Stellt die Referenz für das Projekt dar
    -   Push-Zugriff nur für ausgewählte Personen
        ("Integrationsmanager")

<!-- -->

-   Entwickler
    -   Forken das Master-Repo auf dem Server und klonen ihren Fork
        lokal
    -   Arbeiten auf lokalem Klon: Unabhängige Entwicklung eines
        Features
    -   Pushen ihren Stand in ihren Fork (ihr eigenes öffentliches
        Repo): Veröffentlichung des Beitrags zum Projekt (sobald fertig
        bzw. diskutierbar)
    -   Lösen Pull- bzw. Merge-Request gegen das Master-Repo aus:
        Beitrag soll geprüft und ins Projekt aufgenommen werden (Merge
        ins Master-Repo durch den Integrationsmanager)

<!-- -->

-   Integrationsmanager
    -   Prüft die Änderungen im Pull- bzw. Merge-Request und fordert
        ggf. Nacharbeiten an bzw. lehnt Integration ab (technische oder
        politische Gründe)
    -   Führt Merge der Entwickler-Zweige mit den Hauptzweigen durch
        Akzeptieren der Pull- bzw. Merge-Requests durch: Beitrag der
        Entwickler ist im Projekt angekommen und ist beim nächsten Pull
        in deren lokalen Repos vorhanden

Den hier gezeigten Zusammenhang kann man auf weitere Ebenen verteilen,
vgl. den im Linux-Kernel gelebten "Dictator and Lieutenants Workflow"
(siehe Literatur).

*Hinweis*: Hier wird nur die Zusammenarbeit im verteilten Team
dargestellt. Dazu kommt noch das Arbeiten mit verschiedenen Branches!

*Anmerkung*: In der Workingcopy wird das eigene (öffentliche) Repo oft
als `origin` und das geschützte ("blessed") Master-Repo als `upstream`
referenziert.

###### Anmerkungen zum Forken

Sie könnten auch das Original-Repo direkt clonen. Allerdings würden dann
die `push` dort aufschlagen, was in der Regel nicht erwünscht ist (und
auch nicht erlaubt ist).

Deshalb forkt man das Original-Repo auf dem Server, d.h. auf dem Server
wird eine Kopie des Original-Repos im eigenen Namespace angelegt. Auf
diese Kopie hat man dann uneingeschränkten Zugriff.

Zusätzliche kurze Video-Anleitungen von GitHub: [Working with
forks](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks)

###### Anmerkungen zu den Namen für die Remotes: `origin` und `upstream`

Üblicherweise checkt man die *Kopie* lokal aus (d.h. erzeugt einen
Clone). In der Workingcopy verweist dann `origin` auf die Kopie. Um
Änderungen am Original-Repo zu erhalten, fügt man dieses unter dem Namen
`upstream` als weiteres Remote-Repo hinzu. Dies ist eine nützliche
*Konvention*.

Um Änderungen aus dem Original-Repo in den eigenen Fork (und die
Workingcopy) zu bringen, führt man dann einfach folgendes aus (im
Beispiel für den `master`):

    $ git checkout master         # Workingcopy auf master
    $ git pull upstream master    # Aktualisiere lokalen master mit master aus Original-Repo
    $ git push origin master      # Pushe lokalen master in den Fork

##### Feature-Branches aktualisieren: Mergen mit *master* vs. Rebase auf *master*

Im Netz finden sich häufig Anleitungen, wonach man Änderungen im
`master` mit einem Merge in den Feature-Branch holt, also sinngemäß:

    $ git checkout master         # Workingcopy auf master
    $ git pull upstream master    # Aktualisiere lokalen master mit master aus Vorgabe-Repo
    $ git checkout feature        # Workingcopy auf feature
    $ git merge master            # Aktualisiere feature: Merge master in feature
    $ git push origin feature     # Push aktuellen feature ins Team-Repo

Das funktioniert rein technisch betrachtet.

Allerdings spielt in den meisten Git-Projekten der `master` (bzw.
`main`) üblicherweise eine besondere Rolle (vgl.
[Branching-Strategien](#id-4d6861ad376a0b2e0387b1a92bfe1dde822ccb7f))
und ist üblicherweise stets das **Ziel** eines Merge, aber nie die
*Quelle*! D.h. per Konvention geht der Fluß von Änderungen stets **in**
den `master` (und nicht heraus).

Wenn man sich nicht an diese Konvention hält, hat man später
möglicherweise Probleme, die Merge-Historie zu verstehen (welche
Änderung kam von woher)!

Um die Änderungen im `master` in einen Feature-Branch zu bekommen,
sollte deshalb ein **Rebase** des Feature-Branches auf den aktuellen
`master` bevorzugt werden.

**Merk-Regel**: Merge niemals nie den `master` in Feature-Branches!

**Achtung**: Ein Rebase bei veröffentlichten Branches ist problematisch,
sobald Dritte auf diesem Branch arbeiten oder den Branch als Basis für
ihre eigenen Arbeiten nutzen und dadurch entsprechend auf die Commit-IDs
angewiesen sind. Nach einem Rebase stimmen diese Commit-IDs nicht mehr,
was normalerweise mindestens zu Verärgerung führt ... Die Dritten
müssten ihre Arbeit dann auf den neuen Feature-Branch (d.h. den
Feature-Branch nach dessen Rebase) rebasen ... vgl. auch "The Perils of
Rebasing" in Abschnitt "3.6 Rebasing" in ([Chacon und Straub
2014](#ref-Chacon2014)).

###### Mögliches Szenario im Praktikum

Im Praktikum haben Sie das Vorgabe-Repo. Dieses könnten Sie als
`upstream` in Ihre lokale Workingcopy einbinden.

Mit Ihrem Team leben Sie vermutlich einen zentralen Workflow, d.h. Sie
binden Ihr gemeinsames Repo als `origin` in Ihre lokale Workingcopy ein.

Dann müssen Sie den lokalen `master` aus *beiden* Remotes aktualisieren.
Zusätzlich wollen Sie Ihren aktuellen Themenbranch auf den aktuellen
`master` rebasen.

    $ git checkout master         # Workingcopy auf master
    $ git pull upstream master    # Aktualisiere lokalen master mit master aus Vorgabe-Repo
    $ git pull origin master      # Aktualisiere lokalen master mit master aus Team-Repo
    $ git push origin master      # Pushe lokalen master in das Team-Repo zurück
    $ git rebase master feature   # Rebase feature auf den aktuellen lokalen master
    $ git push -f origin feature  # Push aktuellen feature ins Team-Repo ("-f" wg. geänderter IDs durch rebase)

**Anmerkung**: Dabei können in Ihrem `master` die unschönen "Rauten"
entstehen. Wenn Sie das vermeiden wollen, tauschen Sie den zweiten und
den dritten Schritt und führen den Pull gegen den Upstream-`master` als
`pull --rebase` durch. Dann müssen Sie Ihren lokalen `master` allerdings
auch force-pushen in Ihr Team-Repo und die anderen Team-Mitglieder
sollten darüber informiert werden, dass sich der `master` auf
inkompatible Weise geändert hat ...

##### Kommunikation: Merge- bzw. Pull-Requests

Mergen kann man auf der Konsole (oder in der IDE) und anschließend die
(neuen) Branches auf den Server pushen.

Die verschiedenen Git-Server erlauben ebenfalls ein GUI-gestütztes
Mergen von Branches: "Merge-Requests" (*MR*, Gitlab) bzw.
"Pull-Requests" (*PR*, Github). Das hat gegenüber dem lokalen Mergen
wichtige Vorteile: Andere Entwickler sehen den beabsichtigten Merge
(frühzeitig) und können direkt den Code kommentieren und die
vorgeschlagenen Änderungen diskutieren, aber auch allgemeine Kommentare
abgeben.

Falls möglich, sollte man einen MR/PR immer dem Entwickler zuweisen, der
sich weiter um diesen MR/PR kümmern wird (also zunächst ist man das
erstmal selbst). Zusätzlich kann man einen Reviewer bestimmen, d.h. wer
soll sich den Code ansehen.

Hier ein Screenshot der Änderungsansicht unseres Gitlab-Servers
(SW-Labor):

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/screenshot_merge-request_code.png" width="80%" /></p>

Nachfolgend für den selben MR aus der letzten Abbildung noch die reine
Diskussionsansicht:

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/git/images/screenshot_merge-request_discussion.png" width="80%" /></p>

Zusätzliche kurze Video-Anleitungen von GitHub:

-   [How to create a pull
    request](https://www.youtube.com/watch?v=nCKdihvneS0)
-   [How to merge a pull
    request](https://www.youtube.com/watch?v=FDXSgyDGmho)

##### Best Practices bei Merge-/Pull-Requests

1.  MR/PR so zeitig wie möglich aufmachen
    -   Am besten sofort, wenn ein neuer Branch auf den Server gepusht
        wird!
    -   Ggf. mit dem Präfix "WIP" im Titel gegen unbeabsichtigtes
        vorzeitiges Mergen sperren ... (bei GitHub als "Draft"-PR
        öffnen)
2.  Auswahl Start- und Ziel-Branch (und ggf. Ziel-Repo)
    -   Es gibt verschiedene Stellen, um einen MR/PR zu erstellen.
        Manchmal kann man nur noch den Ziel-Branch einstellen, manchmal
        beides.
    -   Bitte auch darauf achten, welches Ziel-Repo eingestellt ist! Bei
        Forks wird hier immer das Original-Repo voreingestellt!
    -   Den Ziel-Branch kann man ggf. auch nachträglich durch Editieren
        des MR/PR anpassen (Start-Branch und Ziel-Repo leider nicht,
        also beim Erstellen aufpassen!).
3.  Titel (*Summary*): Das ist das, was man in der Übersicht sieht!
    -   Per Default wird die letzte Commit-Message eingesetzt.
    -   Analog zur Commit-Message: Bitte hier unbedingt einen sinnvollen
        Titel einsetzen: Was macht der MR/PR (kurz)?
4.  Beschreibung: Was passiert, wenn man diesen MR/PR akzeptiert
    (ausführlicher)?
    -   Analog zur Commit-Message sollte hier bei Bedarf die Summary
        ausformuliert werden und beschreiben, was der MR/PR ändert.
5.  Assignee: Wer soll sich drum kümmern?
    -   Ein MR/PR sollte immer jemanden zugewiesen sein, d.h. nicht
        "unassigned" sein. Ansonsten ist nicht klar, wer den Request
        durchführen/akzeptieren soll.
    -   Außerdem taucht ein nicht zugewiesener MR/PR nicht in der
        Übersicht "meiner" MR/PR auf, d.h. diese MR/PR haben die
        Tendenz, vergessen zu werden!
6.  Diskussion am (und neben) dem Code
    -   Nur die vorgeschlagenen Code-Änderungen diskutieren!
    -   Weitergehende Diskussionen (etwa über Konzepte o.ä.) besser in
        separaten Issues erledigen, da sonst die Anzeige des MR/PR
        langsam wird (ist beispielsweise ein Problem bei Gitlab).
7.  Weitere Commits auf dem zu mergenden Branch gehen automatisch mit in
    den Request
8.  Weitere Entwickler kann man mit "`@username`" in einem Kommentar auf
    "CC" setzen und in die Diskussion einbinden

*Anmerkung*: Bei Gitlab (d.h. auch bei dem Gitlab-Server im SW-Labor)
gibt es "*Merge-Requests*" (MR). Bei Github gibt es "*Pull-Requests*"
(PR) ...

##### Wrap-Up

-   Git-Workflows für die Zusammenarbeit:
    -   einfacher zentraler Ansatz für kleine Arbeitsgruppen vs.
    -   einfacher verteilter Ansatz mit einem "blessed" Repo (häufig in
        Open-Source-Projekten zu finden)

<!-- -->

-   Aktualisieren Ihres Clones und Ihres Forks mit Änderungen aus dem
    "blessed" Repo
-   Unterschied zwischen einem Pull/Merge und einem Pull/Rebase
-   Erstellen von Beiträgen zu einem Projekt über Merge-Requests
    -   Welche Commits werden Bestandteil eines Merge-Requests (und
        warum)
    -   Diskussion über den Code in Merge-Requests

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Chacon und Straub ([2014, 5, 4.8, 6](#ref-Chacon2014))
> -   Atlassian Pty Ltd ([2022](#ref-AtlassianGit))
> -   Github Inc. ([2022](#ref-GitCheatSheet))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kenne verschiedene Git-Workflows für die Zusammenarbeit
>     und kann den Ablauf erklären
> -   k2: Ich kann den Unterschied zwischen einem Pull/Merge und einem
>     Pull/Rebase erklären
> -   k2: Ich verstehe, welche Commits zu einem Bestandteil eines
>     Merge-/Pull-Requests werden (und warum)
> -   k3: Ich kann den zentralisierten Workflow einsetzen
> -   k3: Ich kann den einfachen verteilten Workflow mit
>     unterschiedlichen Repos einsetzen
> -   k3: Ich kann meinen Clone und meinen Fork bei/mit Änderungen
>     im/aus dem 'blessed Repo' aktualisieren
> -   k3: Ich kann meine Beiträge zu einem Projekt als
>     Merge-/Pull-Requests einreichen
> -   k3: Ich kann meine Merge-/Pull-Requests aktualisieren
> -   k3: Ich kann in Merge-/Pull-Requests Anmerkungen am Code
>     hinterlegen und an den Feedback-Diskussionen teilnehmen
>
> </details>

<a id="id-ac062467754992e9039c8577556fef8750ab42ca"></a>

### Modern Java: Funktionaler Stil und Stream-API

<a id="id-01cc534b930a4f8fcff3f34238f9b902b2aa94dd"></a>

#### Lambda-Ausdrücke und funktionale Interfaces

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Mit einer anonymen inneren Klasse erstellt man gewissermaßen ein
> Objekt einer "Wegwerf"-Klasse: Man leitet *on-the-fly* von einem
> Interface ab oder erweitert eine Klasse und implementiert die
> benötigten Methoden und erzeugt von dieser Klasse sofort eine Instanz
> (Objekt). Diese neue Klasse ist im restlichen Code nicht sichtbar.
>
> Anonyme innere Klassen sind beispielsweise in Swing recht nützlich,
> wenn man einer Komponente einen Listener mitgeben will: Hier erzeugt
> man eine anonyme innere Klasse basierend auf dem passenden
> Listener-Interface, implementiert die entsprechenden Methoden und
> übergibt das mit dieser Klasse erzeugte Objekt als neuen Listener der
> Swing-Komponente.
>
> Mit Java 8 können unter gewissen Bedingungen diese anonymen inneren
> Klassen zu Lambda-Ausdrücken (und Methoden-Referenzen) vereinfacht
> werden. Dazu muss die anonyme innere Klasse ein sogenanntes
> **funktionales Interface** implementieren.
>
> Funktionale Interfaces sind Interfaces mit *genau einer abstrakten
> Methode*. Es können beliebig viele Default-Methoden im Interface
> enthalten sein, und es können `public` sichtbare abstrakte Methoden
> von `java.lang.Object` geerbt/überschrieben werden.
>
> Die Lambda-Ausdrücke entsprechen einer anonymen Methode: Die Parameter
> werden aufgelistet (in Klammern), und hinter einem Pfeil kommt
> entweder *ein* Ausdruck (Wert - gleichzeitig Rückgabewert des
> Lambda-Ausdrucks) oder beliebig viele Anweisungen (in geschweiften
> Klammern, mit Semikolon):
>
> -   Form 1: `(parameters)  ->  expression`
> -   Form 2: `(parameters)  ->  { statements; }`
>
> Der Lambda-Ausdruck muss von der Signatur her genau der einen
> abstrakten Methode im unterliegenden funktionalen Interface
> entsprechen.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Lambda-Ausdrücke und funktionale
>     Interfaces](https://youtu.be/Wd8KG7xtp4c)
> -   [Demo Anonyme innere Klasse](https://youtu.be/QEXpQwRYoYc)
> -   [Demo Lambda-Ausdruck](https://youtu.be/2LJIxsVw4pM)
> -   [Demo Funktionale Interfaces selbst
>     definiert](https://youtu.be/93O1oDL5_5c)
> -   [Demo Vordefinierte funktionale Interfaces im
>     JDK](https://youtu.be/jzEw8IH8Mfc)
>
> </details>

##### Problem: Sortieren einer Studi-Liste

``` java
List<Studi> sl = new ArrayList<>();

// Liste sortieren?
sl.sort(???);  // Parameter: java.util.Comparator<Studi>
```

``` java
public class MyCompare implements Comparator<Studi> {
    @Override  public int compare(Studi o1, Studi o2) {
        return o1.getCredits() - o2.getCredits();
    }
}
```

``` java
// Liste sortieren?
MyCompare mc = new MyCompare();
sl.sort(mc);
```

Da `Comparator<T>` ein Interface ist, muss man eine extra Klasse
anlegen, die die abstrakte Methode aus dem Interface implementiert und
ein Objekt von dieser Klasse erzeugen und dieses dann der
`sort()`-Methode übergeben.

Die Klasse bekommt wie in Java üblich eine eigene Datei und ist damit in
der Package-Struktur offen sichtbar und "verstopft" mir damit die
Strukturen: Diese Klasse ist doch nur eine Hilfsklasse ... Noch
schlimmer: Ich brauche einen Namen für diese Klasse!

Den ersten Punkt könnte man über verschachtelte Klassen lösen: Die
Hilfsklasse wird innerhalb der Klasse definiert, die das Objekt
benötigt. Für den zweiten Punkt brauchen wir mehr Anlauf ...

##### Erinnerung: Verschachtelte Klassen ("*Nested Classes*")

Man kann Klassen innerhalb von Klassen definieren: Verschachtelte
Klassen.

-   Implizite Referenz auf Instanz der äußeren Klasse, Zugriff auf
    **alle** Elemente
-   **Begriffe**:
    -   "normale" innere Klassen: "*inner classes*"
    -   statische innere Klassen: "*static nested classes*"
-   Einsatzzweck:
    -   Hilfsklassen: Zusätzliche Funktionalität kapseln; Nutzung
        **nur** in äußerer Klasse
    -   Kapselung von Rückgabewerten

Sichtbarkeit: Wird u.U. von äußerer Klasse "überstimmt"

###### Innere Klassen ("*Inner Classes*")

-   Objekt der äußeren Klasse muss existieren
-   Innere Klasse ist normales Member der äußeren Klasse
-   Implizite Referenz auf Instanz äußerer Klasse
-   Zugriff auf **alle** Elemente der äußeren Klasse
-   Sonderfall: Definition innerhalb von Methoden ("local classes")
    -   Nur innerhalb der Methode sichtbar
    -   Kennt zusätzlich `final` Attribute der Methode

Beispiel:

``` java
public class Outer {
    ...
    private class Inner {
        ...
    }

    Outer.Inner inner = new Outer().new Inner();
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/nested/StudiListNested.java">Beispiel mit Iterator als innere Klasse: nested.StudiListNested</a></p>

###### Statische innere Klassen ("*Static Nested Classes*")

-   Keine implizite Referenz auf Objekt
-   Nur Zugriff auf Klassenmethoden und -attribute

Beispiel:

``` java
class Outer {
    ...
    static class StaticNested {
        ...
    }
}

Outer.StaticNested nested = new Outer.StaticNested();
```

##### Lösung: Comparator als anonyme innere Klasse

``` java
List<Studi> sl = new ArrayList<>();

// Parametrisierung mit anonymer Klasse
sl.sort(
        new Comparator<Studi>() {
            @Override
            public int compare(Studi o1, Studi o2) {
                return o1.getCredits() - o2.getCredits();
            }
        });  // Semikolon nicht vergessen!!!
```

=\> Instanz einer anonymen inneren Klasse, die das Interface
`Comparator<Studi>` implementiert

-   Für spezielle, einmalige Aufgabe: nur eine Instanz möglich
-   Kein Name, kein Konstruktor, oft nur eine Methode
-   Müssen Interface implementieren oder andere Klasse erweitern
    -   Achtung Schreibweise: ohne `implements` oder `extends`!
-   Konstruktor kann auch Parameter aufweisen
-   Zugriff auf alle Attribute der äußeren Klasse plus alle `final`
    lokalen Variablen
-   Nutzung typischerweise bei GUIs: Event-Handler etc.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/nested/DemoAnonymousInnerClass.java">Demo: nested.DemoAnonymousInnerClass</a></p>

##### Vereinfachung mit Lambda-Ausdruck

``` java
List<Studi> sl = new ArrayList<>();

// Parametrisierung mit anonymer Klasse
sl.sort(
        new Comparator<Studi>() {
            @Override
            public int compare(Studi o1, Studi o2) {
                return o1.getCredits() - o2.getCredits();
            }
        });  // Semikolon nicht vergessen!!!


// Parametrisierung mit Lambda-Ausdruck
sl.sort( (Studi o1, Studi o2) -> o1.getCredits() - o2.getCredits() );
```

**Anmerkung**: Damit für den Parameter alternativ auch ein
Lambda-Ausdruck verwendet werden kann, muss der erwartete Parameter vom
Typ her ein "**funktionales Interface**" (s.u.) sein!

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/nested/DemoLambda.java">Demo: nested.DemoLambda</a></p>

##### Syntax für Lambdas

``` java
(Studi o1, Studi o2)  ->  o1.getCredits() - o2.getCredits()
```

Ein Lambda-Ausdruck ist eine Funktion ohne Namen und besteht aus drei
Teilen:

1.  Parameterliste (in runden Klammern),
2.  Pfeil
3.  Funktionskörper (rechte Seite)

Falls es *genau einen* Parameter gibt, *können* die runden Klammern um
den Parameter entfallen.

Dabei kann der Funktionskörper aus *einem Ausdruck* ("*expression*")
bestehen oder einer *Menge von Anweisungen* ("*statements"*), die dann
in geschweifte Klammern eingeschlossen werden müssen (Block mit
Anweisungen).

Der Wert des Ausdrucks ist zugleich der Rückgabewert des
Lambda-Ausdrucks.

Varianten:

-   **`(parameters)  ->  expression`**

<!-- -->

-   **`(parameters)  ->  { statements; }`**

##### Quiz: Welches sind keine gültigen Lambda-Ausdrücke?

1.  `() -> {}`
2.  `() -> "wuppie"`
3.  `() -> { return "fluppie"; }`
4.  `(Integer i) -> return i + 42;`
5.  `(String s) -> { "foo"; }`
6.  `(String s) -> s.length()`
7.  `(Studi s) -> s.getCredits() > 300`
8.  `(List<Studi> sl) -> sl.isEmpty()`
9.  `(int x, int y) -> { System.out.println("Erg: "); System.out.println(x+y); }`
10. `() -> new Studi()`
11. `s -> s.getCps() > 100 && s.getCps() < 300`
12. `s -> { return s.getCps() > 100 && s.getCps() < 300; }`

<details>

Auflösung: (4) und (5)

`return` ist eine Anweisung, d.h. bei (4) fehlen die geschweiften
Klammern. `"foo"` ist ein String und als solcher ein Ausdruck, d.h. hier
sind die geschweiften Klammern zu viel (oder man ergänze den String mit
einem `return`, also `return "foo";` ...).
</details>

##### Definition "Funktionales Interface" ("*functional interfaces*")

``` java
@FunctionalInterface
public interface Wuppie<T> {
    int wuppie(T obj);
    boolean equals(Object obj);
    default int fluppie() { return 42; }
}
```

`Wuppie<T>` ist ein **funktionales Interface** ("*functional
interface*") (seit Java 8)

-   Hat **genau *eine* abstrakte Methode**
-   Hat evtl. weitere Default-Methoden
-   Hat evtl. weitere abstrakte Methoden, die `public` Methoden von
    `java.lang.Object` überschreiben

Die Annotation `@FunctionalInterface` selbst ist nur für den Compiler:
Falls das Interface *kein* funktionales Interface ist, würde er beim
Vorhandensein dieser Annotation einen Fehler werfen. Oder anders herum:
Allein durch das Annotieren mit `@FunctionalInterface` wird aus einem
Interface noch kein funktionales Interface! Vergleichbar mit `@Override`
...

**Während man für eine anonyme Klasse lediglich ein "normales" Interface
(oder eine Klasse) benötigt, braucht man für Lambda-Ausdrücke zwingend
ein passendes funktionales Interface!**

*Anmerkung*: Es scheint keine einheitliche deutsche Übersetzung für den
Begriff *functional interface* zu geben. Es wird häufig mit
"funktionales Interface", manchmal aber auch mit "Funktionsinterface"
übersetzt.

Das in den obigen Beispielen eingesetzte Interface
`java.util.Comparator<T>` ist also ein funktionales Interface: Es hat
nur *eine* eigene abstrakte Methode `int compare(T o1, T o2);`.

Im Package
[java.util.function](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/package-summary.html)
sind einige wichtige funktionale Interfaces bereits vordefiniert,
beispielsweise `Predicate` (Test, ob eine Bedingung erfüllt ist) und
`Function` (verarbeite einen Wert und liefere einen passenden
Ergebniswert). Diese kann man auch in eigenen Projekten nutzen!

##### Quiz: Welches ist kein funktionales Interface?

``` java
public interface Wuppie {
    int wuppie(int a);
}

public interface Fluppie extends Wuppie {
    int wuppie(double a);
}

public interface Foo {
}

public interface Bar extends Wuppie {
    default int bar() { return 42; }
}
```

<details>

Auflösung:

-   `Wuppie` hat *genau eine* abstrakte Methode =\> funktionales
    Interface
-   `Fluppie` hat zwei abstrakte Methoden =\> **kein** funktionales
    Interface
-   `Foo` hat gar keine abstrakte Methode =\> **kein** funktionales
    Interface
-   `Bar` hat *genau eine* abstrakte Methode (und eine Default-Methode)
    =\> funktionales Interface

</details>

##### Lambdas und funktionale Interfaces: Typprüfung

``` java
interface java.util.Comparator<T> {
    int compare(T o1, T o2);    // abstrakte Methode
}
```

``` java
// Verwendung ohne weitere Typinferenz
Comparator<Studi> c1 = (Studi o1, Studi o2) -> o1.getCredits() - o2.getCredits();

// Verwendung mit Typinferenz
Comparator<Studi> c2 = (o1, o2) -> o1.getCredits() - o2.getCredits();
```

Der Compiler prüft in etwa folgende Schritte, wenn er über einen
Lambda-Ausdruck stolpert:

1.  In welchem Kontext habe ich den Lambda-Ausdruck gesehen?
2.  OK, der Zieltyp ist hier `Comparator<Studi>`.
3.  Wie lautet die **eine** abstrakte Methode im
    `Comparator<T>`-Interface?
4.  OK, das ist `int compare(T o1, T o2);`
5.  Da `T` hier an `Studi` gebunden ist, muss der Lambda-Ausdruck der
    Methode `int compare(Studi o1, Studi o2);` entsprechen: 2x `Studi`
    als Parameter und als Ergebnis ein `int`
6.  Ergebnis:
    a)  Cool, passt zum Lambda-Ausdruck `c1`. Fertig.
    b)  D.h. in `c2` müssen `o1` und `o2` vom Typ `Studi` sein. Cool,
        passt zum Lambda-Ausdruck `c2`. Fertig.

##### Wrap-Up

-   Anonyme Klassen: "Wegwerf"-Innere Klassen
    -   Müssen Interface implementieren oder Klasse erweitern

<!-- -->

-   Java8: **Lambda-Ausdrücke** statt anonymer Klassen (**funktionales
    Interface nötig**)
    -   Zwei mögliche Formen:
        -   Form 1: `(parameters)  ->  expression`
        -   Form 2: `(parameters)  ->  { statements; }`
    -   Im jeweiligen Kontext muss ein **funktionales Interface**
        verwendet werden, d.h. ein Interface mit **genau** einer
        abstrakten Methode
    -   Der Lambda-Ausdruck muss von der Signatur her dieser einen
        abstrakten Methode entsprechen

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
> -   Urma u. a. ([2014, Kap. 3](#ref-Urma2014))
> -   Ullenboom ([2021, Kap. 12](#ref-Ullenboom2021))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kenne die Definition 'Funktionales Interface'
> -   k3: Ich kann innere und anonyme Klassen praktisch einsetzen
> -   k3: Ich kann eigene funktionale Interfaces erstellen
> -   k3: Ich kann Lambda-Ausdrücke formulieren und einsetzen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Beispiel aus einem Code-Review im
> [Dungeon-CampusMinden/Dungeon](https://github.com/Dungeon-CampusMinden/Dungeon)**
>
> Erklären Sie folgenden Code:
>
> ``` java
> public interface IFightAI {
>     void fight(Entity entity);
> }
>
> public class AIComponent extends Component {
>     private final IFightAI fightAI;
>
>     fightAI =
>                 entity1 -> {
>                     System.out.println("TIME TO FIGHT!");
>                     // todo replace with melee skill
>                 };
> }
> ```
>
> **Spielen mit Lambdas**
>
> Sie finden in einem Spiel folgenden Code:
>
> ``` java
> public class Main {
>     public static void main(String[] args) {
>         DoorTile door = new DoorTile();
>         Entity lever1 = new Entity(), lever2 = new Entity(), lever3 = new Entity();
>
>         // ganz viel Code
>
>         if (!door.isOpen() && (lever1.isOn() && (lever2.isOn() || lever3.isOn()))) door.open();
>
>         // ganz viel Code
>     }
> }
>
> class DoorTile {
>     public boolean isOpen() { return false; }
>     public void open() { }
> }
> class Entity {
>     public boolean isOn() { return false; }
> }
> ```
>
> Dabei stört, dass die Verknüpfung der konkreten Objekte und Zustände
> zum Öffnen der konkreten Tür fest (und zudem mitten) im Programm
> hinterlegt ist.
>
> Schreiben Sie diesen Code um: Definieren Sie eine statische
> Hilfsmethode, die ein Door-Tile und drei Entitäten als Argument
> entgegen nimmt und dafür einen Lambda-Ausdruck zurückliefert, mit dem
> (a) die gezeigte Bedingung überprüft werden kann, und mit dem (falls
> die Bedingung erfüllt ist) (b) die Aktion (`door.open()`) ausgeführt
> werden kann. Statt der gezeigten fest codierten `if`-Abfrage soll
> dieser Lambda-Ausdruck ausgewertet werden:
> `doorhandle.test().accept();`.
>
> Damit haben Sie sich eine "Factory-Method" geschrieben
> (Entwurfsmuster), mit der diese Bedingung dynamisch erzeugt werden
> kann (auch für andere Objekte).
>
> Hinweis: Der Lambda-Ausdruck wird "zweistufig" sein müssen ...
>
> **Sortieren mit Lambdas und funktionalen Interfaces**
>
> Betrachten Sie die Klasse
> [Student](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/challenges/lambda/Student.java).
>
> 1.  Definieren Sie eine Methode, die das Sortieren einer
>     `Student`-Liste erlaubt. Übergeben Sie die Liste als Parameter.
> 2.  Schaffen Sie es, das Sortierkriterium ebenfalls als Parameter zu
>     übergeben (als Lambda-Ausdruck)?
> 3.  Definieren Sie eine weitere Methode, die wieder eine
>     `Student`-Liste als Parameter bekommt und liefern sie das erste
>     `Student`-Objekt zurück, welches einer als Lambda-Ausdruck
>     übergebenen Bedingung genügt.
> 4.  Definieren Sie noch eine Methode, die wieder eine `Student`-Liste
>     als Parameter bekommt sowie einen Lambda-Ausdruck, welcher aus
>     einem `Student`-Objekt ein Objekt eines anderen Typen `T`
>     berechnet. Wenden Sie in der Methode den Lambda-Ausdruck auf jedes
>     Objekt der Liste an und geben sie die resultierende neue Liste als
>     Ergebnis zurück.
>
> Verwenden Sie in dieser Aufgabe jeweils Lambda-Ausdrücke. Rufen Sie
> alle drei/vier Methoden an einem kleinen Beispiel auf.
>
> </details>

<a id="id-7aa5254265b8c6ada30b38ba3de8870e51d66c9e"></a>

#### Methoden-Referenzen

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Seit Java8 können **Referenzen auf Methoden** statt anonymer Klassen
> eingesetzt werden (**funktionales Interface nötig**).
>
> Dabei gibt es drei mögliche Formen:
>
> -   Form 1: Referenz auf eine statische Methode:
>     `ClassName::staticMethodName` (wird verwendet wie
>     `(args) -> ClassName.staticMethodName(args)`)
> -   Form 2: Referenz auf eine Instanz-Methode eines Objekts:
>     `objectref::instanceMethodName` (wird verwendet wie
>     `(args) -> objectref.instanceMethodName(args)`)
> -   Form 3: Referenz auf eine Instanz-Methode eines Typs:
>     `ClassName::instanceMethodName` (wird verwendet wie
>     `(o1, args) -> o1.instanceMethodName(args)`)
>
> Im jeweiligen Kontext muss ein passendes funktionales Interface
> verwendet werden, d.h. ein Interface mit **genau** einer abstrakten
> Methode. Die Methoden-Referenz muss von der Syntax her dieser einen
> abstrakten Methode entsprechen (bei der dritten Form wird die Methode
> auf dem ersten Parameter aufgerufen).
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Methoden-Referenzen](https://youtu.be/z0mfvvrsRzc)
> -   [Demo Referenz auf statische
>     Methode](https://youtu.be/YFdPcxE_1Eo)
> -   [Demo Referenz auf Instanz-Methode
>     (Objekt)](https://youtu.be/ImJTywhXrJo)
> -   [Demo Referenz auf Instanz-Methode
>     (Typ)](https://youtu.be/DVz2x27WHU8)
>
> </details>

##### Beispiel: Sortierung einer Liste

``` java
List<Studi> sl = new ArrayList<Studi>();

// Anonyme innere Klasse
Collections.sort(sl, new Comparator<Studi>() {
    @Override public int compare(Studi o1, Studi o2) {
        return Studi.cmpCpsClass(o1, o2);
    }
});


// Lambda-Ausdruck
Collections.sort(sl, (o1, o2) -> Studi.cmpCpsClass(o1, o2));

// Methoden-Referenz
Collections.sort(sl, Studi::cmpCpsClass);
```

###### Anmerkung

Für das obige Beispiel wird davon ausgegangen, dass in der Klasse
`Studi` eine statische Methode `cmpCpsClass()` existiert:

``` java
public static int cmpCpsClass(Studi s1, Studi s2) {
    return s1.getCps() - s2.getCps();
}
```

Wenn man im Lambda-Ausdruck nur Methoden der eigenen Klasse aufruft,
kann man das auch direkt per *Methoden-Referenz* abkürzen!

-   Erinnerung: `Comparator<T>` ist ein funktionales Interface
-   Instanzen können wie üblich durch Ableiten bzw. anonyme Klassen
    erzeugt werden
-   Alternativ kann seit Java8 auch ein passender Lambda-Ausdruck
    verwendet werden
-   Ab Java8: Referenzen auf passende Methoden (Signatur!) können ein
    funktionales Interface "implementieren"
    -   Die statische Methode
        `static int cmpCpsClass(Studi s1, Studi s2)` hat die selbe
        Signatur wie `int compare(Studi s1, Studi s2)` aus
        `Comparator<Studi>`
    -   Kann deshalb wie eine Instanz von `Comparator<Studi>` genutzt
        werden
    -   Name der Methode spielt dabei keine Rolle

##### Überblick: Arten von Methoden-Referenzen

1.  Referenz auf eine statische Methode
    -   Form: `ClassName::staticMethodName`
    -   Wirkung: Aufruf mit `(args) -> ClassName.staticMethodName(args)`

<!-- -->

2.  Referenz auf Instanz-Methode eines bestimmten Objekts
    -   Form: `objectref::instanceMethodName`
    -   Wirkung: Aufruf mit
        `(args) -> objectref.instanceMethodName(args)`

<!-- -->

3.  Referenz auf Instanz-Methode eines bestimmten Typs
    -   Form: `ClassName::instanceMethodName`
    -   Wirkung: Aufruf mit
        `(arg0, rest) -> arg0.instanceMethodName(rest)` (`arg0` ist vom
        Typ `ClassName`)

*Anmerkung*: Analog zur Referenz auf eine statische Methode gibt es noch
die Form der Referenz auf einen Konstruktor: `ClassName::new`. Für
Referenzen auf Konstruktoren mit mehr als 2 Parametern muss ein eigenes
passendes funktionales Interface mit entsprechend vielen Parametern
definiert werden ...

##### Methoden-Referenz 1: Referenz auf statische Methode

``` java
public class Studi {
    public static int cmpCpsClass(Studi s1, Studi s2) {
        return s1.getCredits() - s2.getCredits();
    }

    public static void main(String... args) {
        List<Studi> sl = new ArrayList<Studi>();

        // Referenz auf statische Methode
        Collections.sort(sl, Studi::cmpCpsClass);

        // Entsprechender Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> Studi.cmpCpsClass(o1, o2));
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/methodreferences/DemoStaticMethodReference.java">Demo: methodreferences.DemoStaticMethodReference</a></p>

`Collections.sort()` erwartet in diesem Szenario als zweiten Parameter
eine Instanz von `Comparator<Studi>` mit einer Methode
`int compare(Studi o1, Studi o2)`.

Die übergebene Referenz auf die **statische Methode `cmpCpsClass` der
Klasse `Studi`** hat die **selbe Signatur** und wird deshalb von
`Collections.sort()` genauso genutzt wie die eigentlich erwartete
Methode `Comparator<Studi>#compare(Studi o1, Studi o2)`, d.h. statt
`compare(o1, o2)` wird nun für jeden Vergleich
**`Studi.cmpCpsClass(o1, o2)`** aufgerufen.

##### Methoden-Referenz 2: Referenz auf Instanz-Methode (Objekt)

``` java
public class Studi {
    public int cmpCpsInstance(Studi s1, Studi s2) {
        return s1.getCredits() - s2.getCredits();
    }

    public static void main(String... args) {
        List<Studi> sl = new ArrayList<Studi>();
        Studi holger = new Studi("Holger", 42);

        // Referenz auf Instanz-Methode eines Objekts
        Collections.sort(sl, holger::cmpCpsInstance);

        // Entsprechender Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> holger.cmpCpsInstance(o1, o2));
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/methodreferences/DemoInstanceMethodReferenceObject.java">Demo: methodreferences.DemoInstanceMethodReferenceObject</a></p>

`Collections.sort()` erwartet in diesem Szenario als zweites Argument
wieder eine Instanz von `Comparator<Studi>` mit einer Methode
`int compare(Studi o1, Studi o2)`.

Die übergebene Referenz auf die **Instanz-Methode `cmpCpsInstance` des
Objekts `holger`** hat die selbe Signatur und wird entsprechend von
`Collections.sort()` genauso genutzt wie die eigentlich erwartete
Methode `Comparator<Studi>#compare(Studi o1, Studi o2)`, d.h. statt
`compare(o1, o2)` wird nun für jeden Vergleich
**`holger.cmpCpsInstance(o1, o2)`** aufgerufen.

##### Methoden-Referenz 3: Referenz auf Instanz-Methode (Typ)

``` java
public class Studi {
    public int cmpCpsInstance(Studi studi) {
        return this.getCredits() - studi.getCredits();
    }

    public static void main(String... args) {
        List<Studi> sl = new ArrayList<Studi>();

        // Referenz auf Instanz-Methode eines Typs
        Collections.sort(sl, Studi::cmpCpsInstance);

        // Entsprechender Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> o1.cmpCpsInstance(o2));
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/methodreferences/DemoInstanceMethodReferenceType.java">Demo: methodreferences.DemoInstanceMethodReferenceType</a></p>

`Collections.sort()` erwartet in diesem Szenario als zweites Argument
wieder eine Instanz von `Comparator<Studi>` mit einer Methode
`int compare(Studi o1, Studi o2)`.

Die übergebene Referenz auf die **Instanz-Methode `cmpCpsInstance` des
Typs `Studi`** hat die Signatur `int cmpCpsInstance(Studi studi)` und
wird von `Collections.sort()` so genutzt: Statt `compare(o1, o2)` wird
nun für jeden Vergleich **`o1.cmpCpsInstance(o2)`** aufgerufen.

##### Ausblick: Threads

Erinnerung an bzw. Vorgriff auf ["Threads:
Intro"](#id-f6029a94ea1cbcba66e37c103b162b90e62bea1d):

``` java
public interface Runnable {
    void run();
}
```

Damit lassen sich Threads auf verschiedene Arten erzeugen:

``` java
public class ThreadStarter {
    public static void wuppie() { System.out.println("wuppie(): wuppie"); }
}


Thread t1 = new Thread(new Runnable() {
    public void run() {
        System.out.println("t1: wuppie");
    }
});

Thread t2 = new Thread(() -> System.out.println("t2: wuppie"));

Thread t3 = new Thread(ThreadStarter::wuppie);
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/methodreferences/ThreadStarter.java">Beispiel: methodreferences.ThreadStarter</a></p>

##### Ausblick: Datenstrukturen als Streams

Erinnerung an bzw. Vorgriff auf
["Stream-API"](#id-b16a41dd6bcae74097deb0d66f9b50762b8c0f40):

``` java
class X {
    public static boolean gtFour(int x) { return (x > 4) ? true : false; }
}

List<String> words = Arrays.asList("Java8", "Lambdas", "PM",
        "Dungeon", "libGDX", "Hello", "World", "Wuppie");

List<Integer> wordLengths = words.stream()
        .map(String::length)
        .filter(X::gtFour)
        .sorted()
        .collect(toList());
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/methodreferences/CollectionStreams.java">Beispiel: methodreferences.CollectionStreams</a></p>

-   Collections können als Datenstrom betrachtet werden: `stream()`
    -   Iteration über die Collection, analog zu externer Iteration mit
        `foreach`
-   Daten aus dem Strom filtern: `filter`, braucht Prädikat
-   Auf alle Daten eine Funktion anwenden: `map`
-   Daten im Strom sortieren: `sort` (auch mit Comparator)
-   Daten wieder einsammeln mit `collect`

=\> Typische Elemente **funktionaler Programmierung**

=\> Verweis auf Wahlfach "Spezielle Methoden der Programmierung"

##### Wrap-Up

Seit Java8: **Methoden-Referenzen** statt anonymer Klassen
(**funktionales Interface nötig**)

-   Drei mögliche Formen:
    -   Form 1: Referenz auf statische Methode:
        `ClassName::staticMethodName` (verwendet wie
        `(args) -> ClassName.staticMethodName(args)`)
    -   Form 2: Referenz auf Instanz-Methode eines Objekts:
        `objectref::instanceMethodName` (verwendet wie
        `(args) -> objectref.instanceMethodName(args)`)
    -   Form 3: Referenz auf Instanz-Methode eines Typs:
        `ClassName::instanceMethodName` (verwendet wie
        `(o1, args) -> o1.instanceMethodName(args)`)

<!-- -->

-   Im jeweiligen Kontext muss ein passendes funktionales Interface
    verwendet werden (d.h. ein Interface mit **genau** einer abstrakten
    Methode)

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
> -   Urma u. a. ([2014, Kap. 3](#ref-Urma2014))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich verstehe die Definition von 'Funktionalen Interfaces' und
>     kann sie erklären
> -   k3: Ich kann Methoden-Referenzen lesen und selbst formulieren
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Betrachten Sie den folgenden Java-Code:
>
> ``` java
> public class Cat {
>     int gewicht;
>     public Cat(int gewicht) { this.gewicht = gewicht; }
>
>     public static void main(String... args) {
>         List<Cat> clouder = new ArrayList<>();
>         clouder.add(new Cat(100));  clouder.add(new Cat(1));  clouder.add(new Cat(10));
>
>         clouder.sort(...);
>     }
> }
> ```
>
> 1.  Ergänzen Sie den Methodenaufruf `clouder.sort(...);` mit einer
>     geeigneten anonymen Klasse, daß der `clouder` aufsteigend nach
>     Gewicht sortiert wird.
> 2.  Statt einer anonymen Klasse kann man auch Lambda-Ausdrücke
>     einsetzen. Geben Sie eine konkrete Form an.
> 3.  Statt einer anonymen Klasse kann man auch Methodenreferenzen
>     einsetzen. Dafür gibt es mehrere Formen. Geben Sie für zwei Formen
>     der Methodenreferenz sowohl den Aufruf als auch die
>     Implementierung der entsprechenden Methoden in der Klasse `Cat`
>     an.
>
> </details>

<a id="id-b16a41dd6bcae74097deb0d66f9b50762b8c0f40"></a>

#### Stream-API

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Mit der Collection-API existiert in Java die Möglichkeit, Daten auf
> verschiedenste Weisen zu speichern (`Collection<T>`). Mit der
> Stream-API gibt es die Möglichkeit, diese Daten in einer Art Pipeline
> zu verarbeiten. Ein `Stream<T>` ist eine Folge von Objekten vom Typ
> `T`. Die Verarbeitung der Daten ist "lazy", d.h. sie erfolgt erst auf
> Anforderung (durch die terminale Operation).
>
> Ein Stream hat eine Datenquelle und kann beispielsweise über
> `Collection#stream()` oder `Stream.of()` angelegt werden. Streams
> speichern keine Daten. Die Daten werden aus der verbundenen
> Datenquelle geholt.
>
> Auf einem Stream kann man eine Folge von intermediären Operationen wie
> `peek()`, `map()`, `flatMap()`, `filter()`, `sorted()` ...
> durchführen. Alle diese Operationen arbeiten auf dem Stream und
> erzeugen einen neuen Stream als Ergebnis. Dadurch kann die typische
> Pipeline-artige Verkettung der Operationen ermöglicht werden. Die
> intermediären Operationen werden erst ausgeführt, wenn der Stream
> durch eine terminale Operation geschlossen wird.
>
> Terminale Operationen wie `count()`, `forEach()`, `allMatch()` oder
> `collect()`
>
> -   `collect(Collectors.toList())` (bzw. direkt mit `stream.toList()`
>     (ab Java16))
> -   `collect(Collectors.toSet())`
> -   `collect(Collectors.toCollection(LinkedList::new))` (als
>     `Supplier<T>`)
>
> stoßen die Verarbeitung des Streams an und schließen den Stream damit
> ab.
>
> Wir können hier nur die absoluten Grundlagen betrachten. Die
> Stream-API ist sehr groß und mächtig und lohnt die weitere
> selbstständige Auseinandersetzung :-)
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Stream-API](https://youtu.be/zZMyk0u5hJk)
> -   [Demo Stream-API](https://youtu.be/KBP72tCkBt8)
> -   [Demo Vordefinierte funktionale Interfaces im
>     JDK](https://youtu.be/jzEw8IH8Mfc)
>
> </details>

##### Motivation

Es wurden Studis, Studiengänge und Fachbereiche modelliert (aus Gründen
der Übersichtlichkeit einfach als Record-Klassen).

Nun soll pro Fachbereich die Anzahl der Studis ermittelt werden, die
bereits 100 ECTS oder mehr haben. Dazu könnte man über alle Studiengänge
im Fachbereich iterieren, und in der inneren Schleife über alle Studis
im Studiengang. Dann filtert man alle Studis, deren ECTS größer 100 sind
und erhöht jeweils den Zähler:

``` java
public record Studi(String name, int credits) {}
public record Studiengang(String name, List<Studi> studis) {}
public record Fachbereich(String name, List<Studiengang> studiengaenge) {}

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

Dies ist ein Beispiel, welches klassisch in OO-Manier als Iteration über
Klassen realisiert ist. (Inhaltlich ist es vermutlich nicht sooo
sinnvoll.)

##### Innere Schleife mit Streams umgeschrieben

``` java
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

###### Erklärung des Beispiels

Im Beispiel wurde die innere Schleife in einen Stream ausgelagert.

Mit der Methode `Collection#stream()` wird aus der Collection ein neuer
Stream erzeugt. Auf diesem wird für jedes Element durch die Methode
`map()` die Methode `Studi#credits()` angewendet, was aus einem Strom
von `Studi` einen Strom von `Integer` macht. Mit `filter()` wird auf
jedes Element das Prädikat `c -> c > 100` angewendet und alle Elemente
aus dem Strom entfernt, die der Bedingung nicht entsprechen. Am Ende
wird mit `count()` gezählt, wie viele Elemente im Strom enthalten sind.

###### Was ist ein Stream?

Ein "Stream" ist ein Strom (Folge) von Daten oder Objekten. In Java wird
die Collections-API für die Speicherung von Daten (Objekten) verwendet.
Die Stream-API dient zur Iteration über diese Daten und entsprechend zur
Verarbeitung der Daten. In Java speichert ein Stream keine Daten.

Das Konzept kommt aus der funktionalen Programmierung und wurde in Java
nachträglich eingebaut (wobei dieser Prozess noch lange nicht
abgeschlossen zu sein scheint).

In der funktionalen Programmierung kennt man die Konzepte "map",
"filter" und "reduce": Die Funktion "map()" erhält als Parameter eine
Funktion und wendet diese auf alle Elemente eines Streams an. Die
Funktion "filter()" bekommt ein Prädikat als Parameter und prüft jedes
Element im Stream, ob es dem Prädikat genügt (also ob das Prädikat mit
dem jeweiligen Element zu `true` evaluiert - die anderen Objekte werden
entfernt). Mit "reduce()" kann man Streams zu einem einzigen Wert
zusammenfassen (denken Sie etwa an das Aufsummieren aller Elemente eines
Integer-Streams). Zusätzlich kann man in der funktionalen Programmierung
ohne Probleme unendliche Ströme darstellen: Die Auswertung erfolgt nur
bei Bedarf und auch dann auch nur so weit wie nötig. Dies nennt man auch
"*lazy evaluation*".

Die Streams in Java versuchen, diese Konzepte aus der funktionalen
Programmierung in die objektorientierte Programmierung zu übertragen.
Ein Stream in Java hat eine Datenquelle, von wo die Daten gezogen
werden - ein Stream speichert selbst keine Daten. Es gibt "intermediäre
Operationen" auf einem Stream, die die Elemente verarbeiten und das
Ergebnis als Stream zurückliefern. Daraus ergibt sich typische
Pipeline-artige Verkettung der Operationen. Allerdings werden diese
Operationen erst durchgeführt, wenn eine "terminale Operation" den
Stream "abschließt". Ein Stream ohne eine terminale Operation macht also
tatsächlich *nichts*.

Die Operationen auf dem Stream sind üblicherweise zustandslos, können
aber durchaus auch einen Zustand haben. Dies verhindert üblicherweise
die parallele Verarbeitung der Streams. Operationen sollten aber nach
Möglichkeit keine *Seiteneffekte* haben, d.h. keine Daten außerhalb des
Streams modifizieren. Operationen dürfen auf keinen Fall die Datenquelle
des Streams modifizieren!

##### Erzeugen von Streams

``` java
List<String> l1 = List.of("Hello", "World", "foo", "bar", "wuppie");
Stream<String> s1 = l1.stream();

Stream<String> s2 = Stream.of("Hello", "World", "foo", "bar", "wuppie");

Random random = new Random();
Stream<Integer> s3 = Stream.generate(random::nextInt);

Pattern pattern = Pattern.compile(" ");
Stream<String> s4 = pattern.splitAsStream("Hello world! foo bar wuppie!");
```

Dies sind möglicherweise die wichtigsten Möglichkeiten, in Java einen
Stream zu erzeugen.

Ausgehend von einer Klasse aus der Collection-API kann man die Methode
`Collection#stream()` aufrufen und bekommt einen seriellen Stream.

Alternativ bietet das Interface `Stream` verschiedene statische Methoden
wie `Stream.of()` an, mit deren Hilfe Streams angelegt werden können.
Dies funktioniert auch mit Arrays ...

Und schließlich kann man per `Stream.generate()` einen Stream anlegen,
wobei als Argument ein "Supplier" (Interface
`java.util.function.Supplier<T>`) übergeben werden muss. Dieses Argument
wird dann benutzt, um die Daten für den Stream zu generieren.

Wenn man aufmerksam hinschaut, findet man an verschiedensten Stellen die
Möglichkeit, die Daten per Stream zu verarbeiten, u.a. bei regulären
Ausdrücken.

Man kann per `Collection#parallelStream()` auch parallele Streams
erzeugen, die intern das "Fork&Join-Framework" nutzen. Allerdings sollte
man nur dann parallele Streams anlegen, wenn dadurch tatsächlich
Vorteile durch die Parallelisierung zu erwarten sind (Overhead!).

##### Intermediäre Operationen auf Streams

``` java
private static void dummy(Studiengang sg) {
    sg.studis().stream()
            .peek(s -> System.out.println("Looking at: " + s.name()))
            .map(Studi::credits)
            .peek(c -> System.out.println("This one has: " + c + " ECTS"))
            .filter(c -> c > 5)
            .peek(c -> System.out.println("Filtered: " + c))
            .sorted()
            .forEach(System.out::println);
}
```

An diesem (weitestgehend sinnfreien) Beispiel werden einige intermediäre
Operationen demonstriert.

Die Methode `peek()` liefert einen Stream zurück, die aus den Elementen
des Eingabestroms bestehen. Auf jedes Element wird die Methode
`void accept(T)` des `Consumer<T>` angewendet (Argument der Methode),
was aber nicht zu einer Änderung der Daten führt. **Hinweis**: Diese
Methode dient vor allem zu Debug-Zwecken! Durch den Seiteneffekt kann
die Methode eine schlechtere Laufzeit zur Folge haben oder sogar eine
sonst mögliche parallele Verarbeitung verhindern oder durch eine
parallele Verarbeitung verwirrende Ergebnisse zeigen!

Die Methode `map()` liefert ebenfalls einen Stream zurück, der durch die
Anwendung der Methode `R apply(T)` der als Argument übergebenen
`Function<T,R>` auf jedes Element des Eingabestroms entsteht. Damit
lassen sich die Elemente des ursprünglichen Streams verändern; für jedes
Element gibt es im Ergebnis-Stream ebenfalls ein Element (der Typ ändert
sich, aber nicht die Anzahl der Elemente).

Mit der Methode `filter()` wird ein Stream erzeugt, der alle Objekte des
Eingabe-Streams enthält, auf denen die Anwendung der Methode
`boolean test(T)` des Arguments `Predicate<T>` zu `true` evaluiert (der
Typ und Inhalt der Elemente ändert sich nicht, aber die Anzahl der
Elemente).

Mit `sorted()` wird ein Stream erzeugt, der die Elemente des
Eingabe-Streams sortiert (existiert auch mit einem `Comparator<T>` als
Parameter).

Diese Methoden sind alles **intermediäre** Operationen. Diese arbeiten
auf einem Stream und erzeugen einen neuen Stream und werden erst dann
ausgeführt, wenn eine terminale Operation den Stream abschließt.

Dabei sind die gezeigten intermediären Methoden bis auf `sorted()` ohne
inneren Zustand. `sorted()` ist eine Operation mit innerem Zustand (wird
für das Sortieren benötigt). Dies kann ordentlich in Speicher und Zeit
zuschlagen und u.U. nicht/nur schlecht parallelisierbar sein. Betrachten
Sie den fiktiven parallelen Stream
`stream.parallel().sorted().skip(42)`: Hier müssen erst *alle* Elemente
sortiert werden, bevor mit `skip(42)` die ersten 42 Elemente entfernt
werden. Dies kann auch nicht mehr parallel durchgeführt werden.

Die Methode `forEach()` schließlich ist eine **terminale** Operation,
die auf jedes Element des Eingabe-Streams die Methode `void accept(T)`
des übergebenen `Consumer<T>` anwendet. Diese Methode ist eine
**terminale Operation**, d.h. sie führt zur Auswertung der anderen
*intermediären* Operationen und schließt den Stream ab.

##### Was tun, wenn eine Methode Streams zurückliefert

Wir konnten vorhin nur die innere Schleife in eine Stream-basierte
Verarbeitung umbauen. Das Problem ist: Die äußere Schleife würde einen
Stream liefern (Stream von Studiengängen), auf dem wir die
`map`-Funktion anwenden müssten und darin dann für jeden Studiengang
einen (inneren) Stream mit den Studis eines Studiengangs verarbeiten
müssten.

``` java
private static long getCountSG(Studiengang sg) {
    return sg.studis().stream().map(Studi::credits).filter(c -> c > 100).count();
}

private static long getCountFB2(Fachbereich fb) {
    long count = 0;
    for (Studiengang sg : fb.studiengaenge()) {
        count += getCountSG(sg);
    }
    return count;
}
```

Dafür ist die Methode `flatMap()` die Lösung. Diese Methode bekommt als
Argument ein Objekt vom Typ
`Function<? super T, ? extends Stream<? extends R>>` mit einer Methode
`Stream<? extends R> apply(T)`. Die Methode `flatMap()` verarbeitet den
Stream in zwei Schritten:

1.  Mappe über alle Elemente des Eingabe-Streams mit der Funktion. Im
    Beispiel würde also aus einem `Stream<Studiengang>` jeweils ein
    `Stream<Stream<Studi>>`, also alle `Studiengang`-Objekte werden
    durch je ein `Stream<Studi>`-Objekt ersetzt. Wir haben jetzt also
    einen Stream von `Stream<Studi>`-Objekten, also einen
    `Stream<Stream<Studi>>`.

2.  "Klopfe den verschachtelten Stream wieder flach", d.h. nimm die
    einzelnen `Studi`-Objekte aus den `Stream<Studi>`-Objekten und setze
    diese stattdessen in den Stream. Das Ergebnis ist dann wie gewünscht
    ein `Stream<Studi>` (Stream mit `Studi`-Objekten).

``` java
private static long getCountFB3(Fachbereich fb) {
    return fb.studiengaenge().stream()
            .flatMap(sg -> sg.studis().stream())
            .map(Studi::credits)
            .filter(c -> c > 100)
            .count();
}
```

Zum direkten Vergleich hier noch einmal der ursprüngliche Code mit zwei
verschachtelten Schleifen und entsprechenden Hilfsvariablen:

``` java
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

Während `map` also eine Funktion $f: T \mapsto R$ auf alle Elemente des
Streams anwendet und so aus einem `stream<T>` einen `stream<R>` erzeugt,
wendet `flatMap` eine Funktion
$f: T \mapsto \mathop{\text{stream}}\text{<}R\text{>}$ auf alle Elemente
des Streams an und packt die Ergebnis-Streams `stream<R>` wieder aus,
weshalb man im Ergebnis wie bei `map` aus einem `stream<T>` einen
`stream<R>` erhält.

##### Streams abschließen: Terminale Operationen

``` java
Stream<String> s = Stream.of("Hello", "World", "foo", "bar", "wuppie");

long count = s.count();
s.forEach(System.out::println);
String first = s.findFirst().get();
Boolean b = s.anyMatch(e -> e.length() > 3);

List<String> s1 = s.collect(Collectors.toList());
List<String> s2 = s.toList();   // ab Java16
Set<String> s3 = s.collect(Collectors.toSet());
List<String> s4 = s.collect(Collectors.toCollection(LinkedList::new));
```

Streams müssen mit ***einer* terminalen Operation** abgeschlossen
werden, damit die Verarbeitung tatsächlich angestoßen wird (*lazy
evaluation*).[^5]

Es gibt viele verschiedene terminale Operationen. Wir haben bereits
`count()` und `forEach()` gesehen. In der Sitzung zu
["Optionals"](#id-bb5095c5a37b38bd48ac37be51964fb543342407) werden wir
noch `findFirst()` näher kennenlernen.

Daneben gibt es beispielsweise noch `allMatch()`, `anyMatch()` und
`noneMatch()`, die jeweils ein Prädikat testen und einen Boolean
zurückliefern (matchen alle, mind. eines oder keines der Objekte im
Stream).

Mit `min()` und `max()` kann man sich das kleinste und das größte
Element des Streams liefern lassen. Beide Methoden benötigen dazu einen
`Comparator<T>` als Parameter.

Mit der Methode `collect()` kann man eine der drei Methoden aus
`Collectors` über den Stream laufen lassen und eine `Collection`
erzeugen lassen:

1.  `toList()` sammelt die Elemente in ein `List`-Objekt (bzw. direkt
    mit `stream.toList()` (ab Java16))
2.  `toSet()` sammelt die Elemente in ein `Set`-Objekt
3.  `toCollection()` sammelt die Elemente durch Anwendung der Methode
    `T get()` des übergebenen `Supplier<T>`-Objekts auf

Die ist nur die sprichwörtliche "Spitze des Eisbergs"! Es gibt viele
weitere Möglichkeiten, sowohl bei den intermediären als auch den
terminalen Operationen. Schauen Sie in die Dokumentation!

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/streams/Demo.java">Demo: streams.Demo</a></p>

##### Spielregeln

-   Operationen dürfen nicht die Stream-Quelle modifizieren

-   Operationen können die Werte im Stream ändern (`map`) oder die
    Anzahl (`filter`)

-   Keine Streams in Attributen/Variablen speichern oder als Argumente
    übergeben: Sie könnten bereits "gebraucht" sein!

    =\> Ein Stream sollte immer sofort nach der Erzeugung benutzt werden

-   Operationen auf einem Stream sollten keine Seiteneffekte
    (Veränderungen von Variablen/Attributen außerhalb des Streams) haben
    (dies verhindert u.U. die parallele Verarbeitung)

##### Wrap-Up

`Stream<T>`: Folge von Objekten vom Typ `T`, Verarbeitung "lazy"
(Gegenstück zu `Collection<T>`: Dort werden Daten **gespeichert**, hier
werden Daten **verarbeitet**)

> [!TIP]
>
> **Fließband-Metapher**
>
> Einen Stream kann man sich vielleicht wie ein Fließband in einer
> Fabrik vorstellen: Die Daten werden auf dem Fließband in eine Richtung
> transportiert und durchlaufen verschiedene Stationen, wo auf den Daten
> gearbeitet wird. In manchen Stationen werden Objekte vom Fließband
> geschubst (Daten herausgefiltert), in manchen Stationen werden die
> Objekte bearbeitet (Daten verändert), in manchen Stationen werden aus
> mehreren Teilen neue Objekte gebaut ...
>
> Es ist nur eine Metapher! Sie endet spätestens damit, dass die Streams
> *lazy* sind und dass sämtliche Operationen erst dann ausgeführt
> werden, wenn eine terminale Operation den Stream abschließt.

-   Neuen Stream anlegen: `Collection#stream()` oder `Stream.of()` ...
-   Intermediäre Operationen: `peek()`, `map()`, `flatMap()`,
    `filter()`, `sorted()` ...
-   Terminale Operationen: `count()`, `forEach()`, `allMatch()`,
    `collect()` ...
    -   `collect(Collectors.toList())`
    -   `collect(Collectors.toSet())`
    -   `collect(Collectors.toCollection())` (mit `Supplier<T>`)

<!-- -->

-   Streams speichern keine Daten
-   Intermediäre Operationen laufen erst bei Abschluss des Streams los
-   Terminale Operation führt zur Verarbeitung und Abschluss des Streams

Schöne Doku: ["The Stream API"](https://dev.java/learn/api/streams/),
und auch ["Package
java.util.stream"](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/package-summary.html).

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Oracle Corporation ([2026](#ref-LernJava))
> -   Ullenboom ([2021, 17.3--17.6](#ref-Ullenboom2021))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich verstehe, dass Streams die Daten nicht sofort verarbeiten
>     ('lazy' Verarbeitung)
> -   k2: Ich verstehe, dass ich mit map() den Typ (und Inhalt) von
>     Objekten im Stream, aber nicht die Anzahl verändere
> -   k2: Ich verstehe, dass ich mit filter() die Anzahl der Objekte im
>     Stream, aber nicht deren Typ (und Inhalt) verändere
> -   k2: Ich verstehe, warum Streams nicht in Attributen gehalten oder
>     als Parameter herumgereicht werden sollten
> -   k3: Ich kann einen Stream erzeugen
> -   k3: Ich kann verschiedene intermediäre Operationen verketten
> -   k3: Ich kann mit einer terminalen Operation einen Stream
>     abschließen und damit die Berechnung durchführen
> -   k3: Ich kann flatMap() einsetzen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Betrachten Sie den folgenden Java-Code:
>
> ``` java
> record Cat(int weight){};
>
> public class Main {
>     public static void main(String... args) {
>         List<Cat> clouder = new ArrayList<>();
>         clouder.add(new Cat(100));  clouder.add(new Cat(1));  clouder.add(new Cat(10));
>
>         sumOverWeight(8, clouder);
>     }
>
>     private static int sumOverWeight(int threshold, List<Cat> cats) {
>         int result = 0;
>         for (Cat c : cats) {
>             int weight = c.weight();
>             if (weight > threshold) {
>                 result += weight;
>             }
>         }
>         return result;
>     }
> }
> ```
>
> Schreiben Sie die Methode `sumOverWeight` unter Beibehaltung der
> Funktionalität so um, dass statt der `for`-Schleife und der
> `if`-Abfrage Streams und Stream-Operationen eingesetzt werden. Nutzen
> Sie passende Lambda-Ausdrücke und nach Möglichkeit Methodenreferenzen.
>
> Betrachten Sie den folgenden Java-Code:
>
> ``` java
> public class Main {
>     public static String getParameterNamesJson(String[] parameterNames) {
>         if (parameterNames.length == 0) {
>             return "[]";
>         }
>
>         StringBuilder sb = new StringBuilder();
>         sb.append("[");
>         for (int i = 0; i < parameterNames.length; i++) {
>             if (i > 0) {
>                 sb.append(", ");
>             }
>             sb.append("\"").append(escapeJson(parameterNames[i])).append("\"");
>         }
>         sb.append("]");
>         return sb.toString();
>     }
>
>     private static String escapeJson(String parameterName) {
>         // does something or another ...
>     }
> }
> ```
>
> Schreiben Sie die Methode `getParameterNamesJson` unter Beibehaltung
> der Funktionalität so um, dass statt der `for`-Schleife und der
> `if`-Abfrage Streams und Stream-Operationen eingesetzt werden. Nutzen
> Sie passende Lambda-Ausdrücke und nach Möglichkeit auch
> Methodenreferenzen.
>
> </details>

<a id="id-152ec8405b8a75f125fcbd1f4f3125262de1b614"></a>

#### Record-Klassen

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Häufig schreibt man relativ viel *Boiler Plate Code*, um einfach ein
> paar Daten plus den Konstruktor und die Zugriffsmethoden zu kapseln.
> Und selbst wenn die IDE dies zum Teil abnehmen kann - lesen muss man
> diesen Overhead trotzdem noch.
>
> Für den Fall von Klassen mit `final` Attributen wurden in Java14 die
> **Record-Klassen** eingeführt. Statt dem Schlüsselwort `class` wird
> das neue Schlüsselwort `record` verwendet. Nach dem Klassennamen
> kommen in runden Klammern die "Komponenten" - eine Auflistung der
> Parameter für den Standardkonstruktor (Typ, Name). Daraus wird
> automatisch ein "kanonischer Konstruktor" mit exakt diesen Parametern
> generiert. Es werden zusätzlich `private final` Attribute generiert
> für jede Komponente, und diese werden durch den kanonischen
> Konstruktor gesetzt. Außerdem wird für jedes Attribut automatisch ein
> Getter mit dem Namen des Attributs generiert (also ohne den Präfix
> "get").
>
> Beispiel:
>
> ``` java
> public record StudiR(String name, int credits) {}
> ```
>
> Der Konstruktor und die Getter können überschrieben werden, es können
> auch eigene Methoden definiert werden (eigene Konstruktoren *müssen*
> den kanonischen Konstruktor aufrufen). Es gibt außer den über die
> Komponenten definierten Attribute keine weiteren Attribute. Da eine
> Record-Klasse intern von `java.lang.Record` ableitet, kann eine
> Record-Klasse nicht von weiteren Klassen ableiten (erben). Man kann
> aber beliebig viele Interfaces implementieren. Record-Klassen sind
> implizit final, d.h. man nicht von Record-Klassen erben.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Record-Klassen](https://youtu.be/5RMhdCsZL6Y)
> -   [Demo Record-Klassen](https://youtu.be/jWBAXWH0MUc)
>
> </details>

##### Motivation; Klasse Studi

``` java
public class Studi {
    private final String name;
    private final int credits;

    public Studi(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }
}
```

##### Klasse Studi als Record

``` java
public record StudiR(String name, int credits) {}
```

-   Immutable Klasse mit Feldern `String name` und `int credits` =\>
    "`(String name, int credits)`" werden "Komponenten" des Records
    genannt

-   Standardkonstruktor setzt diese Felder ("Kanonischer Konstruktor")

-   Getter für beide Felder:

    ``` java
    public String name() { return this.name; }
    public int credits() { return this.credits; }
    ```

Record-Klassen wurden in Java14 eingeführt und werden immer wieder in
neuen Releases erweitert/ergänzt.

Der kanonische Konstruktor hat das Aussehen wie die Record-Deklaration,
im Beispiel also `public StudiR(String name, int credits)`. Dabei werden
die Komponenten über eine Kopie der Werte initialisiert.

Für die Komponenten werden automatisch private Attribute mit dem selben
Namen angelegt.

Für die Komponenten werden automatisch Getter angelegt. Achtung: Die
Namen entsprechen denen der Komponenten, es fehlt also der übliche
"get"-Präfix!

##### Eigenschaften und Einschränkungen von Record-Klassen

-   Records erweitern implizit die Klasse `java.lang.Record`: Keine
    andere Klassen mehr erweiterbar! (Interfaces kein Problem)

-   Record-Klassen sind implizit final

-   Keine weiteren (Instanz-) Attribute definierbar (nur die
    Komponenten)

-   Keine Setter definierbar für die Komponenten: Attribute sind final

-   Statische Attribute mit Initialisierung erlaubt

##### Records: Prüfungen im Konstruktor

Der Konstruktor ist erweiterbar:

``` java
public record StudiS(String name, int credits) {
    public StudiS(String name, int credits) {
        if (name == null) { throw new IllegalArgumentException("Name cannot be null!"); }
        else { this.name = name; }

        if (credits < 0) { this.credits = 0; }
        else { this.credits = credits; }
    }
}
```

In dieser Form muss man die Attribute selbst setzen.

Alternativ kann man die "kompakte" Form nutzen:

``` java
public record StudiT(String name, int credits) {
    public StudiT {
        if (name == null) { throw new IllegalArgumentException("Name cannot be null!"); }

        if (credits < 0) { credits = 0; }
    }
}
```

In der kompakten Form kann man nur die Werte der Parameter des
Konstruktors ändern. Das Setzen der Attribute ergänzt der Compiler nach
dem eigenen Code.

Es sind weitere Konstruktoren definierbar, diese *müssen* den
kanonischen Konstruktor aufrufen:

``` java
public StudiT() {
    this("", 42);
}
```

##### Getter und Methoden

Getter werden vom Compiler automatisch generiert. Dabei entsprechen die
Methoden-Namen den Namen der Attribute:

``` java
public record StudiR(String name, int credits) {}

public static void main(String... args) {
    StudiR r = new StudiR("Sabine", 75);

    int x = r.credits();
    String y = r.name();
}
```

Getter überschreibbar und man kann weitere Methoden definieren:

``` java
public record StudiT(String name, int credits) {
    public int credits() { return credits + 42; }
    public void wuppie() { System.out.println("WUPPIE"); }
}
```

Die Komponenten/Attribute sind aber `final` und können nicht über
Methoden geändert werden!

##### Beispiel aus den Challenges

In den Challenges zum Thema Optional gibt es die Klasse `Katze` in den
[Vorgaben](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/challenges/optional/Katze.java).

Die Katze wurde zunächst "klassisch" modelliert: Es gibt drei
Eigenschaften `name`, `gewicht`und `lieblingsBox`. Ein Konstruktor setzt
diese Felder und es gibt drei Getter für die einzelnen Eigenschaften.
Das braucht 18 Zeilen Code (ohne Kommentare Leerzeilen). Zudem erzeugt
der Boilerplate-Code relativ viel "visual noise", so dass der
eigentliche Kern der Klasse schwerer zu erkennen ist.

In einem Refactoring wurde diese Klasse durch eine äquivalente
Record-Klasse ersetzt, die nur noch 2 Zeilen Code (je nach Code-Style
auch nur 1 Zeile) benötigt. Gleichzeitig wurde die Les- und Wartbarkeit
deutlich verbessert.

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/java-modern/images/screenshot_katze.png"  /></p>

##### Wrap-Up

-   Records sind immutable Klassen:
    -   `final` Attribute (entsprechend den Komponenten)
    -   Kanonischer Konstruktor
    -   Automatische Getter (Namen wie Komponenten)
-   Konstruktoren und Methoden können ergänzt/überschrieben werden
-   Keine Vererbung von Klassen möglich (kein `extends`)

Schöne Doku: ["Using Record to Model Immutable
Data"](https://dev.java/learn/using-record-to-model-immutable-data/).

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Oracle Corporation ([2026](#ref-LernJava))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich verstehe, dass Record-Klassen implizit final sind
> -   k2: Ich weiss, dass Record-Klassen einen kanonischen Konstruktor
>     haben
> -   k2: Ich verstehe, dass die Attribute in Record-Klassen implizit
>     final sind und automatisch angelegt und über den Konstruktor
>     gesetzt werden
> -   k2: Ich weiss, dass die Getter in Record-Klassen so benannt sind
>     wie die Namen der Komponenten, also keinen Präfix 'get' haben
> -   k2: Ich weiss, dass der kanonische Konstruktor ergänzt werden kann
> -   k2: Ich weiss, dass weitere Methoden definiert werden können
> -   k2: Ich verstehe, dass Record-Klassen nicht von anderen Klassen
>     erben können, aber Interfaces implementieren können
> -   k3: Ich kann Record-Klassen praktisch einsetzen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Betrachen Sie den folgenden Code:
>
> ``` java
> public interface Person {
>     String getName();
>     Date getBirthday();
> }
>
> public class Student implements Person {
>     private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
>
>     private final String name;
>     private final Date birthday;
>
>     public Student(String name, String birthday) throws ParseException {
>         this.name = name;
>         this.birthday = DATE_FORMAT.parse(birthday);
>     }
>
>     public String getName() { return name; }
>     public Date getBirthday() { return birthday; }
> }
> ```
>
> Schreiben Sie die Klasse `Student` in eine Record-Klasse um. Was
> müssen Sie zusätzlich noch tun, damit die aktuelle API erhalten
> bleibt?
>
> </details>

<a id="id-bb5095c5a37b38bd48ac37be51964fb543342407"></a>

#### Optional

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Häufig hat man in Methoden den Fall, dass es keinen Wert gibt, und man
> liefert dann `null` als "kein Wert vorhanden" zurück. Dies führt dazu,
> dass die Aufrufer eine entsprechende `null`-Prüfung für die
> Rückgabewerte durchführen müssen, bevor sie das Ergebnis nutzen
> können.
>
> `Optional` schließt elegant den Fall "kein Wert vorhanden" ein: Es
> kann mit der Methode `Optional.ofNullable()` das Argument in ein
> Optional verpacken (Argument != `null`) oder ein `Optional.empty()`
> zurückliefern ("leeres" Optional, wenn Argument == `null`).
>
> Man kann Optionals prüfen mit `isEmpty()` und `ifPresent()` und dann
> direkt mit `ifPresent()`, `orElse()` und `orElseThrow()` auf den
> verpackten Wert zugreifen. Besser ist aber der Zugriff über die
> Stream-API von `Optional`: `map()`, `filter`, `flatMap()`, ... Dabei
> gibt es keine terminalen Operationen - es handelt sich ja auch nicht
> um einen Stream, nur die Optik erinnert daran.
>
> `Optional` ist vor allem für Rückgabewerte gedacht, die den Fall "kein
> Wert vorhanden" einschließen sollen. Attribute, Parameter und
> Sammlungen sollten nicht `Optional`-Referenzen speichern, sondern
> "richtige" (unverpackte) Werte (und eben zur Not `null`). `Optional`
> ist kein Ersatz für `null`-Prüfung von Methoden-Parametern (nutzen Sie
> hier beispielsweise passende Annotationen). `Optional` ist auch kein
> Ersatz für vernünftiges Exception-Handling im Fall, dass etwas
> Unerwartetes passiert ist. Liefern Sie **niemals** `null` zurück, wenn
> der Rückgabetyp der Methode ein `Optional` ist!
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Optional](https://youtu.be/JDG_hUSBfSA)
> -   [Demo Optional](https://youtu.be/vL2c0iB4uSk)
> -   [Demo Optional: Beispiel aus der Praxis im
>     PM-Dungeon](https://youtu.be/vyN-vOV9_CU)
>
> </details>

##### Motivation

``` java
public class LSF {
    private Set<Studi> sl;

    public Studi getBestStudi() {
        if (sl == null) return null;  // Fehler: Es gibt noch keine Sammlung

        Studi best = null;
        for (Studi s : sl) {
            if (best == null) best = s;
            if (best.credits() < s.credits()) best = s;
        }
        return best;
    }
}

public static void main(String... args) {
    LSF lsf = new LSF();

    Studi best = lsf.getBestStudi();
    if (best != null) {
        String name = best.name();
        if (name != null) {
            // mach was mit dem Namen ...
        }
    }
}
```

###### Problem: `null` wird an (zu) vielen Stellen genutzt

-   Es gibt keinen Wert ("not found")
-   Felder wurden (noch) nicht initialisiert
-   Es ist ein Problem oder etwas Unerwartetes aufgetreten

=\> Parameter und Rückgabewerte müssen stets auf `null` geprüft werden
(oder Annotationen wie `@NotNull` eingesetzt werden ...)

###### Lösung

-   `Optional<T>` für Rückgabewerte, die "kein Wert vorhanden" mit
    einschließen (statt `null` bei Abwesenheit von Werten)
-   `@NotNull`/`@Nullable` für Parameter einsetzen (oder separate
    Prüfung)
-   Exceptions werfen in Fällen, wo ein Problem aufgetreten ist

###### Anmerkungen

-   Verwendung von `null` auf Attribut-Ebene (Klassen-interne
    Verwendung) ist okay!
-   `Optional<T>` ist **kein** Ersatz für `null`-Checks!
-   `null` ist **kein** Ersatz für vernünftiges Error-Handling! Das
    häufig zu beobachtende "Irgendwas Unerwartetes ist passiert, hier
    ist `null`" ist ein **Anti-Pattern**!

###### Beispiel aus der Praxis im PM-Dungeon

Schauen Sie sich einmal das Review zu den `ecs.components.ai.AITools` in
https://github.com/Dungeon-CampusMinden/Dungeon/pull/128#pullrequestreview-1254025874
an.

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/java-modern/images/screenshot_review1.png" width="80%" /></p>

Die Methode `AITools#calculateNewPath` soll in der Umgebung einer als
Parameter übergebenen Entität nach einem Feld (`Tile`) suchen, welches
für die Entität betretbar ist und einen Pfad von der Position der
Entität zu diesem Feld an den Aufrufer zurückliefern.

Zunächst wird in der Entität nach einer `PositionComponent` und einer
`VelocityComponent` gesucht. Wenn es (eine) diese(r) Components nicht in
der Entität gibt, wird der Wert `null` an den Aufrufer von
`AITools#calculateNewPath` zurückgeliefert. (*Anmerkung*:
Interessanterweise wird in der Methode nicht mit der `VelocityComponent`
gearbeitet.)

Dann wird in der `PositionComponent` die Position der Entität im
aktuellen Level abgerufen. In einer Schleife werden alle Felder im
gegebenen Radius in eine Liste gespeichert. (*Anmerkung*: Da dies über
die `float`-Werte passiert und nicht über die Feld-Indizes wird ein
`Tile` u.U. recht oft in der Liste abgelegt. Können Sie sich hier
einfache Verbesserungen überlegen?)

Da `level.getTileAt()` offenbar als Antwort auch `null` zurückliefern
kann, werden nun zunächst per `tiles.removeIf(Objects::isNull);` all
diese `null`-Werte wieder aus der Liste entfernt. Danach erfolgt die
Prüfung, ob die verbleibenden Felder betretbar sind und nicht-betretbare
Felder werden entfernt.

Aus den verbleibenden (betretbaren) Feldern in der Liste wird nun eines
zufällig ausgewählt und per `level.findPath()` ein Pfad von der Position
der Entität zu diesem Feld berechnet und zurückgeliefert. (*Anmerkung*:
Hier wird ein zufälliges Tile in der Liste der umgebenden Felder
gewählt, von diesem die Koordinaten bestimmt, und dann noch einmal aus
dem Level das dazugehörige Feld geholt - dabei hatte man die Referenz
auf das Feld bereits in der Liste. Können Sie sich hier eine einfache
Verbesserung überlegen?)

Zusammengefasst:

-   Die als Parameter `entity` übergebene Referenz darf offenbar *nicht*
    `null` sein. Die ersten beiden Statements in der Methode rufen auf
    dieser Referenz Methoden auf, was bei einer `null`-Referenz zu einer
    `NullPointer`-Exception führen würde. Hier wäre `null` ein
    Fehlerzustand.
-   `entity.getComponent()` kann offenbar `null` zurückliefern, wenn die
    gesuchte Component nicht vorhanden ist. Hier wird `null` als "kein
    Wert vorhanden" genutzt, was dann nachfolgende `null`-Checks
    notwendig macht.
-   Wenn es die gewünschten Components nicht gibt, wird dem Aufrufer der
    Methode `null` zurückgeliefert. Hier ist nicht ganz klar, ob das
    einfach nur "kein Wert vorhanden" ist oder eigentlich ein
    Fehlerzustand?
-   `level.getTileAt()` kann offenbar `null` zurückliefern, wenn kein
    Feld an der Position vorhanden ist. Hier wird `null` wieder als
    "kein Wert vorhanden" genutzt, was dann nachfolgende `null`-Checks
    notwendig macht (Entfernen aller `null`-Referenzen aus der Liste).
-   `level.findPath()` kann auch wieder `null` zurückliefern, wenn kein
    Pfad berechnet werden konnte. Hier ist wieder nicht ganz klar, ob
    das einfach nur "kein Wert vorhanden" ist oder eigentlich ein
    Fehlerzustand? Man könnte beispielsweise in diesem Fall ein anderes
    Feld probieren?

Der Aufrufer bekommt also eine `NullPointer`-Exception, wenn der
übergebene Parameter `entity` nicht vorhanden ist oder den Wert `null`,
wenn in der Methode etwas schief lief oder schlicht kein Pfad berechnet
werden konnte oder tatsächlich einen Pfad. Damit wird der Aufrufer
gezwungen, den Rückgabewert vor der Verwendung zu untersuchen.

**Allein in dieser einen kurzen Methode macht `null` so viele extra
Prüfungen notwendig und den Code dadurch schwerer lesbar und
fehleranfälliger! `null` wird als (unvollständige) Initialisierung und
als Rückgabewert und für den Fehlerfall genutzt, zusätzlich ist die
Semantik von `null` nicht immer klar.** (*Anmerkung*: Der Gebrauch von
`null` hat nicht wirklich etwas mit "der Natur eines ECS" zu tun. Die
Methode wurde mittlerweile komplett überarbeitet und ist in der hier
gezeigten Form glücklicherweise nicht mehr zu finden.)

Entsprechend hat sich in diesem
[Review](https://github.com/Dungeon-CampusMinden/Dungeon/pull/128#pullrequestreview-1254025874)
die nachfolgende Diskussion ergeben:

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/java-modern/images/screenshot_review2.png" width="80%" /></p>

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/java-modern/images/screenshot_review3.png" width="80%" /></p>

##### Erzeugen von *Optional*-Objekten

Konstruktor ist `private` ...

-   "Kein Wert": `Optional.empty()`
-   Verpacken eines non-`null` Elements: `Optional.of()`
    (`NullPointerException` wenn Argument `null`!)

<!-- -->

-   Verpacken eines "unsicheren"/beliebigen Elements:
    `Optional.ofNullable()`
    -   Liefert verpacktes Element, oder
    -   `Optional.empty()`, falls Element `null` war

Es sollte in der Praxis eigentlich nur wenige Fälle geben, wo ein Aufruf
von `Optional.of()` sinnvoll ist. Ebenso ist `Optional.empty()` nur
selten sinnvoll.

Stattdessen sollte stets `Optional.ofNullable()` verwendet werden.

**`null` kann nicht nicht in `Optional<T>` verpackt werden!** (Das wäre
dann eben `Optional.empty()`.)

##### LSF liefert jetzt *Optional* zurück

``` java
public class LSF {
    private Set<Studi> sl;

    public Optional<Studi> getBestStudi() throws NullPointerException {
        // Fehler: Es gibt noch keine Sammlung
        if (sl == null) throw new NullPointerException("There ain't any collection");

        Studi best = null;
        for (Studi s : sl) {
            if (best == null) best = s;
            if (best.credits() < s.credits()) best = s;
        }

        // Entweder Optional.empty() (wenn best==null) oder Optional.of(best) sonst
        return Optional.ofNullable(best);
    }
}
```

Das Beispiel soll verdeutlichen, dass man im Fehlerfall nicht einfach
`null` oder `Optional.empty()` zurückliefern soll, sondern eine passende
Exception werfen soll.

Wenn die Liste aber leer ist, stellt dies keinen Fehler dar! Es handelt
sich um den Fall "kein Wert vorhanden". In diesem Fall wird statt `null`
nun ein `Optional.empty()` zurückgeliefert, also ein Objekt, auf dem der
Aufrufer die üblichen Methoden aufrufen kann.

##### Zugriff auf *Optional*-Objekte

In der funktionalen Programmierung gibt es schon lange das Konzept von
`Optional`, in Haskell ist dies beispielsweise die Monade `Maybe`.
Allerdings ist die Einbettung in die Sprache von vornherein mit
berücksichtigt worden, insbesondere kann man hier sehr gut mit *Pattern
Matching* in der Funktionsdefinition auf den verpackten Inhalt
reagieren.

In Java gibt es die Methode `Optional#isEmpty()`, die einen Boolean
zurückliefert und prüft, ob es sich um ein leeres `Optional` handelt
oder ob hier ein Wert "verpackt" ist.

Für den direkten Zugriff auf die Werte gibt es die Methoden
`Optional#orElseThrow()` und `Optional#orElse()`. Damit kann man auf den
verpackten Wert zugreifen, oder es wird eine Exception geworfen bzw. ein
Ersatzwert geliefert.

Zusätzlich gibt es `Optional#isPresent()`, die als Parameter ein
`java.util.function.Consumer` erwartet, also ein funktionales Interface
mit einer Methode `void accept(T)`, die das Objekt verarbeitet.

``` java
Studi best;

// Testen und dann verwenden
if (!lsf.getBestStudi().isEmpty()) {
    best = lsf.getBestStudi().get();
    // mach was mit dem Studi ...
}

// Arbeite mit Consumer
lsf.getBestStudi().ifPresent(studi -> {
    // mach was mit dem Studi ...
});

// Studi oder Alternative (wenn Optional.empty())
best = lsf.getBestStudi().orElse(anne);

// Studi oder NoSuchElementException (wenn Optional.empty())
best = lsf.getBestStudi().orElseThrow();
```

Es gibt noch eine Methode `get()`, die so verhält wie `orElseThrow()`.
Da man diese Methode vom Namen her schnell mit einem Getter verwechselt,
ist sie mittlerweile *deprecated*.

*Anmerkung*: Da `getBestStudi()` eine `NullPointerException` werfen
kann, sollte der Aufruf möglicherweise in ein `try/catch` verpackt
werden. Dito für `orElseThrow()`.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/optional/traditional/Demo.java">Beispiel: optional.traditional.Demo</a></p>

##### Einsatz mit Stream-API

``` java
public class LSF {
    ...
    public Optional<Studi> getBestStudi() throws NullPointerException {
        if (sl == null) throw new NullPointerException("There ain't any collection");
        return sl.stream()
                 .sorted((s1, s2) -> s2.credits() - s1.credits())
                 .findFirst();
    }
}


public static void main(String... args) {
    ...
    String name = lsf.getBestStudi()
                     .map(Studi::name)
                     .orElseThrow();
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/optional/streams/Demo.java">Beispiel: optional.streams.Demo</a></p>

Im Beispiel wird in `getBestStudi()` die Sammlung als Stream betrachtet,
über die Methode `sorted()` und den Lamda-Ausdruck für den `Comparator`
sortiert ("falsch" herum: absteigend in den Credits der Studis in der
Sammlung), und `findFirst()` ist die terminale Operation auf dem Stream,
die ein `Optional<Studi>` zurückliefert: entweder den Studi mit den
meisten Credits (verpackt in `Optional<Studi>`) oder `Optional.empty()`,
wenn es überhaupt keine Studis in der Sammlung gab.

In `main()` wird dieses `Optional<Studi>` mit den Stream-Methoden von
`Optional<T>` bearbeitet, zunächst mit `Optional#map()`. Man braucht
nicht selbst prüfen, ob das von `getBestStudi()` erhaltene Objekt leer
ist oder nicht, da dies von `Optional#map()` erledigt wird: Es wendet
die Methodenreferenz auf den verpackten Wert an (sofern dieser vorhanden
ist) und liefert damit den Namen des Studis als `Optional<String>`
verpackt zurück. Wenn es keinen Wert, also nur `Optional.empty()` von
`getBestStudi()` gab, dann ist der Rückgabewert von `Optional#map()` ein
`Optional.empty()`. Wenn der Name, also der Rückgabewert von
`Studi::name`, `null` war, dann wird ebenfalls ein `Optional.empty()`
zurückgeliefert. Dadurch wirft `orElseThrow()` dann eine
`NoSuchElementException`. Man kann also direkt mit dem String `name`
weiterarbeiten ohne extra `null`-Prüfung - allerdings will man noch ein
Exception-Handling einbauen (dies fehlt im obigen Beispiel aus Gründen
der Übersicht) ...

##### Weitere *Optionals*

Für die drei primitiven Datentypen `int`, `long` und `double` gibt es
passende Wrapper-Klassen von `Optional<T>`: `OptionalInt`,
`OptionalLong` und `OptionalDouble`.

Diese verhalten sich analog zu `Optional<T>`, haben aber keine Methode
`ofNullable()`, da dies hier keinen Sinn ergeben würde: Die drei
primitiven Datentypen repräsentieren Werte - diese können nicht `null`
sein.

##### Regeln für *Optional*

1.  Nutze `Optional` nur als Rückgabe für "kein Wert vorhanden"

    `Optional` ist nicht als Ersatz für eine `null`-Prüfung o.ä.
    gedacht, sondern als Repräsentation, um auch ein "kein Wert
    vorhanden" zurückliefern zu können.

<!-- -->

2.  Nutze nie `null` für eine `Optional`-Variable oder einen
    `Optional`-Rückgabewert

    Wenn man ein `Optional` als Rückgabe bekommt, sollte das niemals
    selbst eine `null`-Referenz sein. Das macht das gesamte Konzept
    kaputt!

    Nutzen Sie stattdessen `Optional.empty()`.

3.  Nutze `Optional.ofNullable()` zum Erzeugen eines `Optional`

    Diese Methode verhält sich "freundlich" und erzeugt automatisch ein
    `Optional.empty()`, wenn das Argument `null` ist. Es gibt also
    keinen Grund, dies mit einer Fallunterscheidung selbst erledigen zu
    wollen.

    Bevorzugen Sie `Optional.ofNullable()` vor einer manuellen
    Fallunterscheidung und dem entsprechenden Einsatz von
    `Optional.of()` und `Optional.empty()`.

4.  Erzeuge keine `Optional` als Ersatz für die Prüfung auf `null`

    Wenn Sie auf `null` prüfen müssen, müssen Sie auf `null` prüfen. Der
    ersatzweise Einsatz von `Optional` macht es nur komplexer - prüfen
    müssen Sie hinterher ja immer noch.

5.  Nutze `Optional` nicht in Attributen, Methoden-Parametern und
    Sammlungen

    Nutzen Sie `Optional` vor allem für Rückgabewerte.

    Attribute sollten immer direkt einen Wert haben oder `null`, analog
    Parameter von Methoden o.ä. ... Hier hilft `Optional` nicht, Sie
    müssten ja trotzdem eine `null`-Prüfung machen, nur eben dann über
    den `Optional`, wodurch dies komplexer und schlechter lesbar wird.

    Aus einem ähnlichen Grund sollten Sie auch in Sammlungen keine
    `Optional` speichern!

6.  Vermeide den direkten Zugriff (`ifPresent()`, `orElseThrow()` ...)

    Der direkte Zugriff auf ein `Optional` entspricht dem Prüfen auf
    `null` und dann dem Auspacken. Dies ist nicht nur Overhead, sondern
    auch schlechter lesbar.

    Vermeiden Sie den direkten Zugriff und nutzen Sie `Optional` mit den
    Stream-Methoden. So ist dies von den Designern gedacht.

##### Interessante Links

-   ["Using Optionals"](https://dev.java/learn/api/streams/optionals/)
-   ["What You Might Not Know About
    Optional"](https://medium.com/javarevisited/what-you-might-not-know-about-optional-7238e3c05f63)
-   ["Experienced Developers Use These 7 Java Optional Tips to Remove
    Code
    Clutter"](https://medium.com/javarevisited/experienced-developers-use-these-7-java-optional-tips-to-remove-code-clutter-6e8b1a639861)
-   ["Code Smells:
    Null"](https://blog.jetbrains.com/idea/2017/08/code-smells-null/)
-   ["Class
    Optional"](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Optional.html)

##### Wrap-Up

`Optional` als Rückgabe für "kein Wert vorhanden"

-   `Optional.ofNullable()`: Erzeugen eines `Optional`
    -   Entweder Objekt "verpackt" (Argument != `null`)
    -   Oder `Optional.empty()` (Argument == `null`)
-   Prüfen mit `isEmpty()` und `ifPresent()`
-   Direkter Zugriff mit `ifPresent()`, `orElse()` und `orElseThrow()`
-   Stream-API: `map()`, `filter()`, `flatMap()`, ...

<!-- -->

-   Attribute, Parameter und Sammlungen: nicht `Optional` nutzen
-   Kein Ersatz für `null`-Prüfung!

Schöne Doku: ["Using
Optionals"](https://dev.java/learn/api/streams/optionals/).

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Oracle Corporation ([2026](#ref-LernJava))
> -   Ullenboom ([2021, 12.6](#ref-Ullenboom2021))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kann erklären, warum Optionals vor allem für Rückgabewerte
>     gedacht sind
> -   k2: Ich kann erklären, warum kein null zurückgeliefert werden
>     darf, wenn der Rückgabetyp ein Optional\<T\> ist
> -   k3: Ich kann (ggf. leere) Optionals mit Optional.ofNullable()
>     erzeugen
> -   k3: Ich kann auf Optionals klassisch über die direkten
>     Hilfsmethoden der Klasse zugreifen
> -   k3: Ich kann auf Optionals elegant per Stream-API zugreifen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Optional und Stream-API**
>
> 1.  Erklären Sie den folgenden Code-Schnipsel aus dem
>     [Dungeon](https://github.com/Dungeon-CampusMinden/Dungeon/pull/1831):
>
>     ``` java
>     Skill fireball =
>         new Skill(
>             new FireballSkill(
>                 () ->
>                     hero.fetch(CollideComponent.class)
>                         .map(cc -> cc
>                                     .center(hero)
>                                     .add(viewDirection.toPoint()))
>                         .orElseThrow(
>                             () -> MissingComponentException.build(
>                                     hero,
>                                     CollideComponent.class)),
>                 FIREBALL_RANGE,
>                 FIREBALL_SPEED,
>                 FIREBALL_DMG),
>             1);
>     ```
>
>     Hinweise:
>
>     -   `Entity#fetch`:
>         `<T extends Component> Optional<T> fetch(final Class<T> klass)`
>     -   `CollideComponent#center`: `Point center(final Entity entity)`
>     -   `Point#add`: `Point add(final Point other)`
>
> 2.  Was würde sich ändern, wenn statt `map` ein `flatMap` verwendet
>     würde? Wie ist das bei richtigen Streams?
>
> 3.  Was passiert im folgenden Beispiel? Warum funktioniert das auch
>     ohne terminale Stream-Operation?
>
>     ``` java
>     Game.hero()
>         .flatMap(e -> e.fetch(AmmunitionComponent.class))
>         .map(AmmunitionComponent::resetCurrentAmmunition);
>     ```
>
>     Hinweis: `Game.hero()`: `static Optional<Entity> hero()`.
>
> 4.  Können Sie die beiden obigen Beispiele in "klassischer"
>     Schreibweise umformulieren?
>
> **String-Handling**
>
> Können Sie den folgenden Code so umschreiben, dass Sie statt der
> `if`-Abfragen und der einzelnen direkten Methodenaufrufe die
> Stream-API und `Optional<T>` nutzen?
>
> ``` java
> String format(final String text, String replacement) {
>     if (text.isEmpty()) {
>         return "";
>     }
>
>     final String trimmed = text.trim();
>     final String withSpacesReplaced = trimmed.replaceAll(" +", replacement);
>
>     return replacement + withSpacesReplaced + replacement;
> }
> ```
>
> Ein Aufruf `format(" Hello World ... ", "_");` liefert den String
> "`_Hello_World_..._`".
>
> </details>

<a id="id-83d9242997f09b086df2b42d7c636f083f0ab02e"></a>

#### Interfaces: Default-Methoden

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Seit Java8 können Methoden in Interfaces auch fertig implementiert
> sein: Sogenannte **Default-Methoden**.
>
> Dazu werden die Methoden mit dem neuen Schlüsselwort `default`
> gekennzeichnet. Die Implementierung wird an die das Interface
> implementierenden Klassen (oder Interfaces) vererbt und kann bei
> Bedarf überschrieben werden.
>
> Da eine Klasse von einer anderen Klasse erben darf, aber mehrere
> Interfaces implementieren kann, könnte es zu einer Mehrfachvererbung
> einer Methode kommen: Eine Methode könnte beispielsweise in
> verschiedenen Interfaces als Default-Methode angeboten werden, und
> wenn eine Klasse diese Interfaces implementiert, steht eine Methode
> mit der selben Signatur auf einmal mehrfach zur Verfügung. Dies muss
> (u.U. manuell) aufgelöst werden.
>
> Auflösung von Mehrfachvererbung:
>
> -   Regel 1: Klassen gewinnen
> -   Regel 2: Sub-Interfaces gewinnen
> -   Regel 3: Methode explizit auswählen
>
> Aktuell ist der Unterschied zu abstrakten Klassen: Interfaces können
> **keinen Zustand** haben, d.h. keine Attribute/Felder.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Default-Methoden](https://youtu.be/qQ8BPkL9X5o)
> -   [Demo Regel 1](https://youtu.be/gm6ttKlAEJc)
> -   [Demo Regel 2](https://youtu.be/3j9i7iMVmMM)
> -   [Demo Regel 3](https://youtu.be/J3gJnwz8Rf0)
>
> </details>

##### Problem: Etablierte API (Interfaces) erweitern

``` java
interface Klausur {
    void anmelden(Studi s);
    void abmelden(Studi s);
}
```

=\> Nachträglich noch `void schreiben(Studi s);` ergänzen?

Wenn ein Interface nachträglich erweitert wird, müssen alle Kunden (also
alle Klassen, die das Interface implementieren) auf die neuen Signaturen
angepasst werden. Dies kann viel Aufwand verursachen und API-Änderungen
damit unmöglich machen.

##### Default-Methoden: Interfaces mit Implementierung

Seit Java8 können Interfaces auch Methoden implementieren. Es gibt zwei
Varianten: Default-Methoden und statische Methoden.

``` java
interface Klausur {
    void anmelden(Studi s);
    void abmelden(Studi s);

    default void schreiben(Studi s) {
        ...     // Default-Implementierung
    }

    default void wuppie() {
        throw new java.lang.UnsupportedOperationException();
    }
}
```

Methoden können in Interfaces seit Java8 implementiert werden. Für
Default-Methoden muss das Schlüsselwort `default` vor die Signatur
gesetzt werden. Klassen, die das Interface implementieren, können diese
Default-Implementierung erben oder selbst neu implementieren
(überschreiben). Alternativ kann die Klasse eine Default-Methode neu
*deklarieren* und wird damit zur abstrakten Klasse.

Dies ähnelt abstrakten Klassen. Allerdings kann in abstrakten Klassen
neben dem Verhalten (implementierten Methoden) auch Zustand über die
Attribute gespeichert werden.

##### Problem: Mehrfachvererbung

Drei Regeln zum Auflösen bei Konflikten:

1.  **Klassen gewinnen**: Methoden aus Klasse oder Superklasse haben
    höhere Priorität als Default-Methoden
2.  **Sub-Interfaces gewinnen**: Methode aus am meisten spezialisiertem
    Interface mit Default-Methode wird gewählt Beispiel: Wenn
    `B extends A` dann ist `B` spezialisierter als `A`
3.  Sonst: Klasse muss **Methode explizit auswählen**: Methode
    überschreiben und gewünschte (geerbte) Variante aufrufen:
    `X.super.m(...)` (`X` ist das gewünschte Interface)

Auf den folgenden Folien wird dies anhand kleiner Beispiele
verdeutlicht.

##### Auflösung Mehrfachvererbung: 1. Klassen gewinnen

``` java
interface A {
    default String hello() { return "A"; }
}
class C {
    public String hello() { return "C"; }
}
class E extends C implements A {}


/** Mehrfachvererbung: 1. Klassen gewinnen */
public class DefaultTest1 {
    public static void main(String... args) {
        String e = new E().hello();
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/defaultmethods/rule1/DefaultTest1.java">Demo: defaultmethods.rule1.DefaultTest1</a></p>

Die Klasse `E` erbt sowohl von Klasse `C` als auch vom Interface `A` die
Methode `hello()` (Mehrfachvererbung). In diesem Fall "gewinnt" die
Implementierung aus Klasse `C`.

**1. Regel**: Klassen gewinnen immer. Deklarationen einer Methode in
einer Klasse oder einer Oberklasse haben Vorrang von allen
Default-Methoden.

##### Auflösung Mehrfachvererbung: 2. Sub-Interfaces gewinnen

``` java
interface A {
    default String hello() { return "A"; }
}
interface B extends A {
    @Override default String hello() { return "B"; }
}
class D implements A, B {}


/** Mehrfachvererbung: 2. Sub-Interfaces gewinnen */
public class DefaultTest2 {
    public static void main(String... args) {
        String e = new D().hello();
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/defaultmethods/rule2/DefaultTest2.java">Demo: defaultmethods.rule2.DefaultTest2</a></p>

Die Klasse `D` erbt sowohl vom Interface `A` als auch vom Interface `B`
die Methode `hello()` (Mehrfachvererbung). In diesem Fall "gewinnt" die
Implementierung aus Klasse `B`: Interface `B` ist spezialisierter als
`A`.

**2. Regel**: Falls Regel 1 nicht zutrifft, gewinnt die Default-Methode,
die am meisten spezialisiert ist.

##### Auflösung Mehrfachvererbung: 3. Methode explizit auswählen

``` java
interface A {
    default String hello() { return "A"; }
}
interface B {
    default String hello() { return "B"; }
}
class D implements A, B {
    @Override public String hello() { return A.super.hello(); }
}


/** Mehrfachvererbung: 3. Methode explizit auswählen */
public class DefaultTest3 {
    public static void main(String... args) {
        String e = new D().hello();
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/defaultmethods/rule3/DefaultTest3.java">Demo: defaultmethods.rule3.DefaultTest3</a></p>

Die Klasse `D` erbt sowohl vom Interface `A` als auch vom Interface `B`
die Methode `hello()` (Mehrfachvererbung). In diesem Fall *muss* zur
Auflösung die Methode in `D` neu implementiert werden und die gewünschte
geerbte Methode explizit aufgerufen werden. (Wenn dies unterlassen wird,
führt das selbst bei Nicht-Nutzung der Methode `hello()` zu einem
Compiler-Fehler!)

*Achtung*: Der Aufruf der Default-Methode aus Interface `A` erfolgt mit
`A.super.hello();` (nicht einfach durch `A.hello();`)!

**3. Regel**: Falls weder Regel 1 noch 2 zutreffen bzw. die Auflösung
noch uneindeutig ist, muss man manuell durch die explizite Angabe der
gewünschten Methode auflösen.

##### Quiz: Was kommt hier raus?

``` java
interface A {
    default String hello() { return "A"; }
}
interface B extends A {
    @Override default String hello() { return "B"; }
}
class C implements B {
    @Override public String hello() { return "C"; }
}
class D extends C implements A, B {}


/** Quiz Mehrfachvererbung */
public class DefaultTest {
    public static void main(String... args) {
        String e = new D().hello(); // ???
    }
}
```

Die Klasse `D` erbt sowohl von Klasse `C` als auch von den Interfaces
`A` und `B` die Methode `hello()` (Mehrfachvererbung). In diesem Fall
"gewinnt" die Implementierung aus Klasse `C`: Klassen gewinnen immer
(Regel 1).

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-modern/src/defaultmethods/quiz/DefaultTest.java">Beispiel: defaultmethods.quiz.DefaultTest</a></p>

##### Statische Methoden in Interfaces

``` java
public interface Collection<E> extends Iterable<E> {
    boolean add(E e);
    ...
}
public class Collections {
    private Collections() { }
    public static <T> boolean addAll(Collection<? super T> c, T... elements) {...}
    ...
}
```

Typisches Pattern in Java: Interface plus Utility-Klasse
(Companion-Klasse) mit statischen Hilfsmethoden zum einfacheren Umgang
mit Instanzen des Interfaces (mit Objekten, deren Klasse das Interface
implementiert). Beispiel: `Collections` ist eine Hilfs-Klasse zum Umgang
mit `Collection`-Objekten.

Seit Java8 können in Interfaces neben Default-Methoden auch statische
Methoden implementiert werden.

Die Hilfsmethoden können jetzt ins Interface wandern =\> Utility-Klassen
werden obsolet ... Aus Kompatibilitätsgründen würde man die bisherige
Companion-Klasse weiterhin anbieten, wobei die Implementierungen auf die
statischen Methoden im Interface verweisen (*SKIZZE, nicht real!*):

``` java
public interface CollectionX<E> extends Iterable<E> {
    boolean add(E e);
    static <T> boolean addAll(CollectionX<? super T> c, T... elements) { ... }
    ...
}
public class CollectionsX {
    public static <T> boolean addAll(CollectionX<? super T> c, T... elements) {
        return CollectionX.addAll(c, elements);  // Verweis auf Interface
    }
    ...
}
```

##### Interfaces vs. Abstrakte Klassen

-   **Abstrakte Klassen**: Schnittstelle und Verhalten und Zustand

-   **Interfaces**:

    -   vor Java 8 nur Schnittstelle
    -   ab Java 8 Schnittstelle und Verhalten

    Unterschied zu abstrakten Klassen: Kein Zustand, d.h. keine
    Attribute

<!-- -->

-   Design:
    -   Interfaces sind beinahe wie abstrakte Klassen, nur ohne Zustand
    -   Klassen können nur von **einer** (abstrakten) Klasse erben, aber
        **viele** Interfaces implementieren

##### Wrap-Up

Seit Java8: Interfaces mit Implementierung: **Default-Methoden**

-   Methoden mit dem Schlüsselwort `default` können Implementierung im
    Interface haben
-   Die Implementierung wird vererbt und kann bei Bedarf überschrieben
    werden
-   Auflösung von Mehrfachvererbung:
    -   Regel 1: Klassen gewinnen
    -   Regel 2: Sub-Interfaces gewinnen
    -   Regel 3: Methode explizit auswählen
-   Unterschied zu abstrakten Klassen: **Kein Zustand**

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
> -   Urma u. a. ([2014, Kap. 9](#ref-Urma2014))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich weiss, dass in Interfaces Default-Methoden erstellt werden
>     können
> -   k2: Ich kann den Unterschied zwischen Interfaces mit
>     Default-Methoden und abstrakten Klassen erklären
> -   k2: Ich verstehe das Problem der Mehrfachvererbung bei Interfaces
>     mit Default-Methoden
> -   k3: Ich kann Interfaces mit Default-Methoden erstellen und
>     einsetzen
> -   k3: Ich habe die Regeln zum Auflösen der Mehrfachvererbung
>     verstanden und kann sie in der Praxis nutzen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Erklären Sie die Code-Schnipsel in der
> [Vorgabe](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/java-modern/src/challenges/defaults)
> und die jeweils entstehenden Ausgaben.
>
> </details>

<a id="id-9fcb175dfd46abc9a760964ebebed64408b716a5"></a>

### Bauen von Programmen, Automatisierung, Continuous Integration

<a id="id-879896721406ac776eca71435136f613a3f6c9d9"></a>

#### Build-Systeme: Gradle

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Um beim Übersetzen und Testen von Software von den spezifischen
> Gegebenheiten auf einem Entwicklerrechner unabhängig zu werden, werden
> häufig sogenannte Build-Tools eingesetzt. Mit diesen konfiguriert man
> sein Projekt abseits einer IDE und übersetzt, testet und baut seine
> Applikation damit entsprechend unabhängig. In der Java-Welt sind
> aktuell die Build-Tools Ant, Maven und Gradle weit verbreitet.
>
> In Gradle ist ein Java-Entwicklungsmodell quasi eingebaut. Über die
> Konfigurationsskripte müssen nur noch bestimmte Details wie benötigte
> externe Bibliotheken oder die Hauptklasse und sonstige
> Projektbesonderheiten konfiguriert werden. Über "Tasks" wie `build`,
> `test` oder `run` können Java-Projekte übersetzt, getestet und
> ausgeführt werden. Dabei werden die externen Abhängigkeiten
> (Bibliotheken) aufgelöst (soweit konfiguriert) und auch abhängige
> Tasks mit erledigt, etwa muss zum Testen vorher der Source-Code
> übersetzt werden.
>
> Gradle bietet eine Fülle an Plugins für bestimmte Aufgaben an, die
> jeweils mit neuen Tasks einher kommen. Beispiele sind das Plugin
> `java`, welches weitere Java-spezifische Tasks wie `classes`
> mitbringt, oder das Plugin `checkstyle` zum Überprüfen von
> Coding-Style-Richtlinien.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Build-Systeme: Gradle](https://youtu.be/aVtDkFpwd_E)
> -   [Demo Gradle](https://youtu.be/OhQRGaNO4iA)
>
> </details>

##### Automatisieren von Arbeitsabläufen

<div align="center">

Works on my machine ...

</div>

Einen häufigen Ausspruch, den man bei der Zusammenarbeit in Teams zu
hören bekommt, ist "Also, bei mir läuft der Code." ...

Das Problem dabei ist, dass jeder Entwickler eine andere Maschine hat,
oft ein anderes Betriebssystem oder eine andere OS-Version. Dazu kommen
noch eine andere IDE und/oder andere Einstellungen und so weiter.

Wie bekommt man es hin, dass Code zuverlässig auch auf anderen Rechnern
baut? Ein wichtiger Baustein dafür sind sogenannte "Build-Systeme", also
Tools, die unabhängig von der IDE (und den IDE-Einstellungen) für das
Übersetzen der Software eingesetzt werden und deren Konfiguration dann
mit im Repo eingecheckt wird. Damit kann die Software dann auf allen
Rechnern und insbesondere dann auch auf dem Server (Stichwort
"Continuous Integration") unabhängig von der IDE o.ä. automatisiert
gebaut und getestet werden.

-   Build-Tools:
    -   Apache Ant
    -   Apache Maven
    -   **Gradle**

Das sind die drei am häufigsten anzutreffenden Build-Tools in der
Java-Welt.

Ant ist von den drei genannten Tools das älteste und setzt wie Maven auf
XML als Beschreibungssprache. In Ant müssen dabei alle Regeln stets
explizit formuliert werden, die man benutzen möchte.

In Maven wird dagegen von einem bestimmten Entwicklungsmodell
ausgegangen, hier müssen nur noch die Abweichungen zu diesem Modell
konfiguriert werden.

In Gradle wird eine DSL basierend auf der Skriptsprache Groovy (läuft
auf der JVM) eingesetzt, und es gibt hier wie in Maven ein bestimmtes
eingebautes Entwicklungsmodell. Gradle bringt zusätzlich noch einen
Wrapper mit, d.h. es wird eine Art Gradle-Starter im Repo konfiguriert,
der sich quasi genauso verhält wie ein fest installiertes Gradle (s.u.).

**Achtung**: Während Ant und Maven relativ stabil in der API sind,
verändert sich Gradle teilweise deutlich zwischen den Versionen.
Zusätzlich sind bestimmte Gradle-Versionen oft noch von bestimmten
JDK-Versionen abhängig. In der Praxis bedeutet dies, dass man
Gradle-Skripte im Laufe der Zeit relativ oft überarbeiten muss (einfach
nur, damit das Skript wieder läuft - ohne dass man dabei irgendwelche
neuen Features oder sonstige Vorteile erzielen würde). Ein großer
Vorteil ist aber der Gradle-Wrapper (s.u.).

##### Gradle: Eine DSL in Groovy

DSL: *Domain Specific Language*

``` groovy
// build.gradle
plugins {
    id 'java'
    id 'application'
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'junit:junit:4.13.2'
}

application {
    mainClass = 'fluppie.App'
}
```

Dies ist mit die einfachste Build-Datei für Gradle.

Über Plugins wird die Unterstützung für Java und das Bauen von
Applikationen aktiviert, d.h. es stehen darüber entsprechende
spezifische Tasks zur Verfügung.

Abhängigkeiten sollen hier aus dem Maven-Repository
[MavenCentral](https://mvnrepository.com/repos/central) geladen werden.
Zusätzlich wird hier als Abhängigkeit für den Test
(`testImplementation`) die JUnit-Bibliothek in einer Maven-artigen
Notation angegeben (vgl.
[mvnrepository.com](https://mvnrepository.com/)). (Für nur zur
Übersetzung der Applikation benötigte Bibliotheken verwendet man
stattdessen das Schlüsselwort `implementation`.)

Bei der Initialisierung wurde als Package `fluppie` angegeben. Gradle
legt darunter per Default die Klasse `App` mit einer `main()`-Methode
an. Entsprechend kann man über den Eintrag `application` den
Einsprungpunkt in die Applikation konfigurieren.

##### Gradle-DSL

Ein Gradle-Skript ist letztlich ein in Groovy geschriebenes Skript.
[Groovy](https://groovy-lang.org/) ist eine auf Java basierende und auf
der JVM ausgeführte Skriptsprache. Seit einigen Versionen kann man die
Gradle-Build-Skripte auch in der Sprache Kotlin schreiben.

##### Dateien

Für das Bauen mit Gradle benötigt man drei Dateien im Projektordner:

-   `build.gradle`: Die auf der Gradle-DSL beruhende Definition des
    Builds mit den Tasks (und ggf. Abhängigkeiten) eines Projekts.

    Ein Multiprojekt hat pro Projekt eine solche Build-Datei. Dabei
    können die Unterprojekte Eigenschaften der Eltern-Buildskripte
    "erben" und so relativ kurz ausfallen.

-   `settings.gradle`: Eine optionale Datei, in der man beispielsweise
    den Projektnamen oder bei einem Multiprojekt die relevanten
    Unterprojekte festlegt.

-   `gradle.properties`: Eine weitere optionale Datei, in der
    projektspezifische Properties für den Gradle-Build spezifizieren
    kann.

##### Gradle Init

Um eine neue Gradle-Konfiguration anlegen zu lassen, geht man in einen
Ordner und führt darin `gradle init` aus. Gradle fragt der Reihe nach
einige Einstellungen ab:

    $ gradle init

    Select type of project to generate:
      1: basic
      2: application
      3: library
      4: Gradle plugin
    Enter selection (default: basic) [1..4] 2

    Select implementation language:
      1: C++
      2: Groovy
      3: Java
      4: Kotlin
      5: Scala
      6: Swift
    Enter selection (default: Java) [1..6] 3

    Split functionality across multiple subprojects?:
      1: no - only one application project
      2: yes - application and library projects
    Enter selection (default: no - only one application project) [1..2] 1

    Select build script DSL:
      1: Groovy
      2: Kotlin
    Enter selection (default: Groovy) [1..2] 1

    Select test framework:
      1: JUnit 4
      2: TestNG
      3: Spock
      4: JUnit Jupiter
    Enter selection (default: JUnit Jupiter) [1..4] 1

    Project name (default: tmp): wuppie
    Source package (default: tmp): fluppie

Typischerweise möchte man eine Applikation bauen (Auswahl 2 bei der
ersten Frage). Als nächstes wird nach der Sprache des Projekts gefragt
sowie nach der Sprache für das Gradle-Build-Skript (Default ist Groovy)
sowie nach dem Testframework, welches verwendet werden soll.

Damit wird die eingangs gezeigte Konfiguration angelegt.

##### Ordner

Durch `gradle init` wird ein neuer Ordner `wuppie/` mit folgender
Ordnerstruktur angelegt:

    drwxr-xr-x 4 cagix cagix 4096 Apr  8 11:43 ./
    drwxrwxrwt 1 cagix cagix 4096 Apr  8 11:43 ../
    -rw-r--r-- 1 cagix cagix  154 Apr  8 11:43 .gitattributes
    -rw-r--r-- 1 cagix cagix  103 Apr  8 11:43 .gitignore
    drwxr-xr-x 3 cagix cagix 4096 Apr  8 11:43 app/
    drwxr-xr-x 3 cagix cagix 4096 Apr  8 11:42 gradle/
    -rwxr-xr-x 1 cagix cagix 8070 Apr  8 11:42 gradlew*
    -rw-r--r-- 1 cagix cagix 2763 Apr  8 11:42 gradlew.bat
    -rw-r--r-- 1 cagix cagix  370 Apr  8 11:43 settings.gradle

Es werden Einstellungen für Git erzeugt (`.gitattributes` und
`.gitignore`).

Im Ordner `gradle/` wird der Gradle-Wrapper abgelegt (s.u.). Dieser
Ordner wird normalerweise mit ins Repo eingecheckt. Die Skripte
`gradlew` und `gradlew.bat` sind die Startskripte für den Gradle-Wrapper
(s.u.) und werden normalerweise ebenfalls ins Repo mit eingecheckt.

Der Ordner `.gradle/` (erscheint ggf. nach dem ersten Lauf von Gradle
auf dem neuen Projekt) ist nur ein Hilfsordner ("Cache") von Gradle.
Hier werden heruntergeladene Dateien etc. abgelegt. Dieser Order sollte
**nicht** ins Repo eingecheckt werden und ist deshalb auch per Default
im generierten `.gitignore` enthalten. (Zusätzlich gibt es im
User-Verzeichnis auch noch einen Ordner `.gradle/` mit einem globalen
Cache.)

In `settings.gradle` finden sich weitere Einstellungen. Die eigentliche
Gradle-Konfiguration befindet sich zusammen mit dem eigentlichen Projekt
im Unterordner `app/`:

    drwxr-xr-x 4 root root 4096 Apr  8 11:50 ./
    drwxr-xr-x 5 root root 4096 Apr  8 11:49 ../
    drwxr-xr-x 5 root root 4096 Apr  8 11:50 build/
    -rw-r--r-- 1 root root  852 Apr  8 11:43 build.gradle
    drwxr-xr-x 4 root root 4096 Apr  8 11:43 src/

Die Datei `build.gradle` ist die durch `gradle init` erzeugte (und
eingangs gezeigte) Konfigurationsdatei, vergleichbar mit `build.xml` für
Ant oder `pom.xml` für Maven. Im Unterordner `build/` werden die
generierten `.class`-Dateien etc. beim Build-Prozess abgelegt.

Unter `src/` findet sich dann eine Maven-typische Ordnerstruktur für die
Sourcen:

    $ tree src/
    src/
    |-- main
    |   |-- java
    |   |   `-- fluppie
    |   |       `-- App.java
    |   `-- resources
    `-- test
        |-- java
        |   `-- fluppie
        |       `-- AppTest.java
        `-- resources

Unterhalb von `src/` ist ein Ordner `main/` für die Quellen der
Applikation (Sourcen und Ressourcen). Für jede Sprache gibt es einen
eigenen Unterordner, hier entsprechend `java/`. Unterhalb diesem folgt
dann die bei der Initialisierung angelegte Package-Struktur (hier
`fluppie` mit der Default-Main-Klasse `App` mit einer `main()`-Methode).
Diese Strukturen wiederholen sich für die Tests unterhalb von
`src/test/`.

Wer die herkömmlichen, deutlich flacheren Strukturen bevorzugt, also
unterhalb von `src/` direkt die Java-Package-Strukturen für die Sourcen
der Applikation und unterhalb von `test/` entsprechend die Strukturen
für die JUnit-Test, der kann dies im Build-Skript einstellen:

``` groovy
sourceSets {
    main {
        java {
            srcDirs = ['src']
        }
        resources {
            srcDirs = ['res']
        }
    test {
        java {
            srcDirs = ['test']
        }
    }
}
```

##### Ablauf eines Gradle-Builds

Ein Gradle-Build hat zwei Hauptphasen: Konfiguration und Ausführung.

Während der Konfiguration wird das gesamte Skript durchlaufen (vgl.
Ausführung der direkten Anweisungen eines Tasks). Dabei wird ein Graph
erzeugt: welche Tasks hängen von welchen anderen ab etc.

Anschließend wird der gewünschte Task ausgeführt. Dabei werden zuerst
alle Tasks ausgeführt, die im Graphen auf dem Weg zu dem gewünschten
Task liegen.

Mit `gradle tasks` kann man sich die zur Verfügung stehenden Tasks
ansehen. Diese sind der Übersicht halber noch nach "Themen" sortiert.

Für eine Java-Applikation sind die typischen Tasks `gradle build` zum
Bauen der Applikation (inkl. Ausführen der Tests) sowie `gradle run` zum
Starten der Anwendung. Wer nur die Java-Sourcen compilieren will, würde
den Task `gradle compileJava` nutzen. Mit `gradle check` würde man
compilieren und die Tests ausführen sowie weitere Checks durchführen
(`gradle test` würde nur compilieren und die Tests ausführen), mit
`gradle jar` die Anwendung in ein `.jar`-File packen und mit
`gradle javadoc` die Javadoc-Dokumentation erzeugen und mit
`gradle clean` die generierten Hilfsdateien aufräumen (löschen).

##### Plugin-Architektur

Für bestimmte Projekttypen gibt es immer wieder die gleichen Aufgaben.
Um hier Schreibaufwand zu sparen, existieren verschiedene Plugins für
verschiedene Projekttypen. In diesen Plugins sind die entsprechenden
Tasks bereits mit den jeweiligen Abhängigkeiten formuliert. Diese Idee
stammt aus Maven, wo dies für Java-basierte Projekte umgesetzt ist.

Beispielsweise erhält man über das Plugin `java` den Task `clean` zum
Löschen aller generierten Build-Artefakte, den Task `classes`, der die
Sourcen zu `.class`-Dateien kompiliert oder den Task `test`, der die
JUnit-Tests ausführt ...

Sie können sich Plugins und weitere Tasks relativ leicht auch selbst
definieren.

##### Auflösen von Abhängigkeiten

Analog zu Maven kann man Abhängigkeiten (etwa in einer bestimmten
Version benötigte Bibliotheken) im Gradle-Skript angeben. Diese werden
(transparent für den User) von einer ebenfalls angegeben Quelle, etwa
einem Maven-Repository, heruntergeladen und für den Build genutzt. Man
muss also nicht mehr die benötigten `.jar`-Dateien der Bibliotheken mit
ins Projekt einchecken. Analog zu Maven können erzeugte Artefakte
automatisch publiziert werden, etwa in einem Maven-Repository.

Für das Projekt benötigte Abhängigkeiten kann man über den Eintrag
`dependencies` spezifizieren. Dabei unterscheidet man u.a. zwischen
Applikation und Tests: `implementation` und `testImplementation` für das
Compilieren und Ausführen von Applikation bzw. Tests. Diese
Abhängigkeiten werden durch Gradle über die im Abschnitt `repositories`
konfigurierten Repositories aufgelöst und die entsprechenden
`.jar`-Files geladen (in den `.gradle/`-Ordner).

Typische Repos sind das Maven-Repo selbst (`mavenCentral()`) oder das
Google-Maven-Repo (`google()`).

Die Einträge in `dependencies` erfolgen dabei in einer Maven-Notation,
die Sie auch im Maven-Repo
[mvnrepository.com](https://mvnrepository.com/) finden.

##### Beispiel mit weiteren Konfigurationen (u.a. Checkstyle und Javadoc)

``` groovy
plugins {
    id 'java'
    id 'application'
    id 'checkstyle'
}


repositories {
    mavenCentral()
}

application {
    mainClass = 'hangman.Main'
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

run {
    standardInput = System.in
}

sourceSets {
    main {
        java {
            srcDirs = ['src']
        }
        resources {
            srcDirs = ['res']
        }
    }
}

checkstyle {
    configFile = file(“${rootDir}/google_checks.xml”)
    toolVersion = '10.19.0'
}

dependencies {
    implementation group: 'org.apache.poi', name: 'poi', version: '4.1.2'
}

javadoc {
    options.showAll()
}
```

Hier sehen Sie übrigens noch eine weitere mögliche Schreibweise für das
Notieren von Abhängigkeiten:
`implementation group: 'org.apache.poi', name: 'poi', version: '4.1.2'`
und `implementation 'org.apache.poi:poi:4.1.2'` sind gleichwertig, wobei
die letztere Schreibweise sowohl in den generierten Builds-Skripten und
in der offiziellen Dokumentation bevorzugt wird.

##### Gradle und Ant (und Maven)

Vorhandene Ant-Buildskripte kann man nach Gradle importieren und
ausführen lassen. Über die DSL kann man auch direkt Ant-Tasks aufrufen.
Siehe auch ["Using Ant from
Gradle"](https://docs.gradle.org/current/userguide/ant.html).

##### Gradle-Wrapper

    project
    |-- app/
    |-- build.gradle
    |-- gradlew
    |-- gradlew.bat
    `-- gradle/
        `-- wrapper/
            |-- gradle-wrapper.jar
            `-- gradle-wrapper.properties

Zur Ausführung von Gradle-Skripten benötigt man eine lokale
Gradle-Installation. Diese sollte für i.d.R. alle User, die das Projekt
bauen wollen, identisch sein. Leider ist dies oft nicht gegeben bzw.
nicht einfach lösbar.

Zur Vereinfachung gibt es den Gradle-Wrapper `gradlew` (bzw.
`gradlew.bat` für Windows). Dies ist ein kleines Shellskript, welches
zusammen mit einigen kleinen `.jar`-Dateien im Unterordner `gradle/` mit
ins Repo eingecheckt wird und welches direkt die Rolle des
`gradle`-Befehls einer Gradle-Installation übernehmen kann. Man kann
also in Konfigurationskripten, beispielsweise für Gitlab CI, alle
Aufrufe von `gradle` durch Aufrufe von `gradlew` ersetzen.

Beim ersten Aufruf lädt `gradlew` dann die spezifizierte Gradle-Version
herunter und speichert diese in einem lokalen Ordner `.gradle/`. Ab dann
greift `gradlew` auf diese lokale (nicht "installierte")
`gradle`-Version zurück.

`gradle init` erzeugt den Wrapper automatisch in der verwendeten
Gradle-Version mit. Alternativ kann man den Wrapper nachträglich über
`gradle wrapper --gradle-version 6.5` in einer bestimmten (gewünschten)
Version anlegen lassen.

Da der Gradle-Wrapper im Repository eingecheckt ist, benutzen alle
Entwickler damit automatisch die selbe Version, ohne diese auf ihrem
System zuvor installieren zu müssen. Deshalb ist der Einsatz des
Wrappers einem fest installierten Gradle vorzuziehen!

##### Wrap-Up

-   Automatisieren von Arbeitsabläufen mit Build-Tools/-Skripten

<!-- -->

-   Einstieg in **Gradle** (DSL zur Konfiguration)
    -   Typisches Java-Entwicklungsmodell eingebaut
    -   Konfiguration der Abweichungen (Abhängigkeiten, Namen, ...)
    -   Gradle-Wrapper: Ersetzt eine feste Installation

##### Link-Sammlung Gradle

-   ["Getting
    Started"](https://docs.gradle.org/current/userguide/getting_started.html)
-   ["Building Java Applications
    Sample"](https://docs.gradle.org/current/samples/sample_building_java_applications.html)
-   ["Building Java Applications with libraries
    Sample"](https://docs.gradle.org/current/samples/sample_building_java_applications_multi_project.html)
-   ["Building Java Libraries
    Sample"](https://docs.gradle.org/current/samples/sample_building_java_libraries.html)
-   ["Building Java & JVM
    projects"](https://docs.gradle.org/current/userguide/building_java_projects.html)

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Gradle Inc. ([2022](#ref-Gradle))
> -   Ullenboom ([2021](#ref-Ullenboom2021))
> -   Inden ([2013](#ref-Inden2013))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k3: Ich kann einfache Gradle-Skripte schreiben und verstehen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Betrachten Sie das Buildskript `gradle.build` aus
> [Dungeon-CampusMinden/Dungeon](https://github.com/Dungeon-CampusMinden/Dungeon/blob/master/build.gradle).
>
> Erklären Sie, in welche Abschnitte das Buildskript unterteilt ist und
> welche Aufgaben diese Abschnitte jeweils erfüllen. Gehen Sie dabei im
> *Detail* auf das Plugin `java` und die dort bereitgestellten Tasks und
> deren Abhängigkeiten untereinander ein.
> </details>

<a id="id-4db9ebc86d71df5cc33864e90b54d42c472fdaec"></a>

#### Continuous Integration (CI)

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> In größeren Projekten mit mehreren Teams werden die Beteiligten i.d.R.
> nur noch "ihre" Codestellen compilieren und testen. Dennoch ist es
> wichtig, das gesamte Projekt regelmäßig zu "bauen" und auch
> umfangreichere Testsuiten regelmäßig laufen zu lassen. Außerdem ist es
> wichtig, das in einer definierten Umgebung zu tun und nicht auf einem
> oder mehreren Entwicklerrechnern, die i.d.R. (leicht) unterschiedlich
> konfiguriert sind, um zuverlässige und nachvollziehbare Ergebnisse zu
> bekommen. Weiterhin möchte man auf bestimmte Ereignisse reagieren, wie
> etwa neue Commits im Git-Server, oder bei Pull-Requests möchte man vor
> dem Merge automatisiert sicherstellen, dass damit die vorhandenen
> Tests alle "grün" sind und auch die Formatierung etc. stimmt.
>
> Dafür hat sich "Continuous Integration" etabliert. Hier werden die
> angesprochenen Prozesse regelmäßig auf einem dafür eingerichteten
> System durchgeführt. Aktivitäten wie Übersetzen, Testen, Style-Checks
> etc. werden in sogenannten "Pipelines" oder "Workflows"
> zusammengefasst und automatisiert durch Commits, Pull-Requests oder
> Merges auf dem Git-Server ausgelöst. Die Aktionen können dabei je nach
> Trigger und Branch unterschiedlich sein, d.h. man könnte etwa bei PR
> gegen den Master umfangreichere Tests laufen lassen als bei einem PR
> gegen einen Develop-Branch. In einem Workflow oder einer Pipeline
> können einzelne Aktionen wiederum von anderen Aktionen abhängen. Das
> Ergebnis kann man dann auf dem Server einsehen oder bekommt man
> komfortabel als Report per Mail zugeschickt.
>
> Wir schauen uns hier exemplarisch GitHub Actions und GitLab CI/CD an.
> Um CI sinnvoll einsetzen zu können, benötigt man Kenntnisse über
> Build-Tools. "CI" tritt üblicherweise zusammen mit "CD" (Continuous
> Delivery) auf, also als "CI/CD". Der "CD"-Teil ist nicht Gegenstand
> der Betrachtung in dieser Lehrveranstaltung.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Continuous Integration](https://youtu.be/NCWxo-PN4gs)
> -   [Demo GitHub Actions](https://youtu.be/rpkZvuiyvTU)
> -   [Demo Demo GitLab CI/CD](https://youtu.be/2ydDA4WY1wA)
>
> </details>

##### Motivation: Zusammenarbeit in Teams

###### Szenario

-   Projekt besteht aus diversen Teilprojekten
-   Verschiedene Entwicklungs-Teams arbeiten (getrennt) an verschiedenen
    Projekten
-   Tester entwickeln Testsuiten für die Teilprojekte
-   Tester entwickeln Testsuiten für das Gesamtprojekt

###### Manuelle Ausführung der Testsuiten reicht nicht

-   Belastet den Entwicklungsprozess
-   Keine (einheitliche) Veröffentlichung der Ergebnisse
-   Keine (einheitliche) Eskalation bei Fehlern
-   Keine regelmäßige Integration in Gesamtprojekt

###### Continuous Integration

-   Regelmäßige, automatische Ausführung: Build und Tests
-   Reporting
-   Weiterführung der Idee: Regelmäßiges Deployment (*Continuous
    Deployment*)

##### Continuous Integration (CI)

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/building/images/ci.png" width="60%" /></p>

###### Vorgehen

-   Entwickler und Tester committen ihre Änderungen regelmäßig (Git,
    SVN, ...)
-   CI-Server arbeitet Build-Skripte ab, getriggert durch Events:
    Push-Events, Zeit/Datum, ...
    -   Typischerweise wird dabei:
        -   Das Gesamtprojekt übersetzt ("gebaut")
        -   Die Unit- und die Integrationstests abgearbeitet
        -   Zu festen Zeiten werden zusätzlich Systemtests gefahren
    -   Typische weitere Builds: "Nightly Build", Release-Build, ...
    -   Ergebnisse jeweils auf der Weboberfläche einsehbar (und per
        E-Mail)

###### Einige Vorteile

-   Tests werden regelmäßig durchgeführt (auch wenn sie lange dauern
    oder die Maschine stark belasten)
-   Es wird regelmäßig ein Gesamt-Build durchgeführt
-   Alle Teilnehmer sind über aktuellen Projekt(-zu-)stand informiert

###### Beispiele für verbreitete CI-Umgebungen

-   [Jenkins](https://www.jenkins.io/)
-   [GitLab CI/CD](https://docs.gitlab.com/ee/ci/)
-   [GitHub Actions](https://github.com/features/actions) und [GitHub
    CI/CD](https://resources.github.com/ci-cd/)
-   [Bamboo](https://www.atlassian.com/software/bamboo)
-   [Travis CI](https://www.travis-ci.com/)

##### GitLab CI/CD

Siehe auch ["Get started with Gitlab
CI/CD"](http://git03-ifm-min.ad.hsbi.de/help/ci/quick_start/index.md).
(Für den Zugriff wird VPN benötigt!)

###### Übersicht über Pipelines

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/building/images/screenshot-gitlabci-pipelines.png" width="70%" /></p>

-   In Spalte "Status" sieht man das Ergebnis der einzelnen Pipelines:
    "pending" (die Pipeline läuft gerade), "cancelled" (Pipeline wurde
    manuell abgebrochen), "passed" (alle Jobs der Pipeline sind sauber
    durchgelaufen), "failed" (ein Job ist fehlgeschlagen, Pipeline wurde
    deshalb abgebrochen)
-   In Spalte "Pipeline" sind die Pipelines eindeutig benannt
    aufgeführt, inkl. Trigger (Commit und Branch)
-   In Spalte "Stages" sieht man den Zustand der einzelnen Stages

Wenn man mit der Maus auf den Status oder die Stages geht, erfährt man
mehr bzw. kann auf eine Seite mit mehr Informationen kommen.

###### Detailansicht einer Pipeline

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/building/images/screenshot-gitlabci-triggeredpipeline.png" width="70%" /></p>

Wenn man in eine Pipeline in der Übersicht klickt, werden die einzelnen
Stages dieser Pipeline genauer dargestellt.

###### Detailansicht eines Jobs

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/building/images/screenshot-gitlabci-job.png" width="70%" /></p>

Wenn man in einen Job einer Stage klickt, bekommt man quasi die
Konsolenausgabe dieses Jobs. Hier kann man ggf. Fehler beim Ausführen
der einzelnen Skripte oder die Ergebnisse beispielsweise der JUnit-Läufe
anschauen.

###### GitLab CI/CD: Konfiguration mit YAML-Datei

Datei `.gitlab-ci.yml` im Projekt-Ordner:

``` yaml
stages:
    - my.compile
    - my.test

job1:
    script:
        - echo "Hello"
        - ./gradlew compileJava
        - echo "wuppie!"
    stage: my.compile
    only:
        - wuppie

job2:
    script: "./gradlew test"
    stage: my.test

job3:
    script:
        - echo "Job 3"
    stage: my.compile
```

####### Stages

Unter `stages` werden die einzelnen Stages einer Pipeline definiert.
Diese werden in der hier spezifizierten Reihenfolge durchgeführt, d.h.
zuerst würde `my.compile` ausgeführt, und erst wenn alle Jobs in
`my.compile` erfolgreich ausgeführt wurden, würde anschließend `my.test`
ausgeführt.

Dabei gilt: Die Jobs einer Stage werden (potentiell) parallel zueinander
ausgeführt, und die Jobs der nächsten Stage werden erst dann gestartet,
wenn alle Jobs der aktuellen Stage erfolgreich beendet wurden.

Wenn keine eigenen `stages` definiert werden, kann man ([lt.
Doku](http://git03-ifm-min.ad.hsbi.de/help/ci/yaml/index.md#stages)) auf
die Default-Stages `build`, `test` und `deploy` zurückgreifen.
**Achtung**: Sobald man eigene Stages definiert, stehen diese
Default-Stages *nicht* mehr zur Verfügung!

####### Jobs

`job1`, `job2` und `job3` definieren jeweils einen Job.

-   `job1` besteht aus mehreren Befehlen (unter `script`). Alternativ
    kann man die bei `job2` gezeigte Syntax nutzen, wenn nur ein Befehl
    zu bearbeiten ist.

    Die Befehle werden von GitLab CI/CD in einer Shell ausgeführt.

-   Die Jobs `job1` und `job2` sind der Stage `my.compile` zugeordnet
    (Abschnitt `stage`). Einer Stage können mehrere Jobs zugeordnet
    sein, die dann parallel ausgeführt werden.

    Wenn ein Job nicht explizit einer Stage zugeordnet ist, wird er
    ([lt.
    Doku](http://git03-ifm-min.ad.hsbi.de/help/ci/yaml/index.md#stages))
    zur Default-Stage `test` zugewiesen. (Das geht nur, wenn es diese
    Stage auch gibt!)

-   Mit `only` und `except` kann man u.a. Branches oder Tags angeben,
    für die dieser Job ausgeführt (bzw. nicht ausgeführt) werden soll.

Durch die Kombination von Jobs mit der Zuordnung zu Stages und Events
lassen sich unterschiedliche Pipelines für verschiedene Zwecke
definieren.

###### Hinweise zur Konfiguration von GitLab CI/CD

Im Browser in den Repo-Einstellungen arbeiten:

1.  Unter
    `Settings > General > Visibility, project features, permissions` das
    `CI/CD` aktivieren
2.  Prüfen unter `Settings > CI/CD > Runners`, dass unter
    `Available shared Runners` mind. ein shared Runner verfügbar ist
    (mit grün markiert ist)
3.  Unter `Settings > CI/CD > General pipelines` einstellen:
    -   `Git strategy`: `git clone`
    -   `Timeout`: `10m`
    -   `Public pipelines`: `false` (nicht angehakt)
4.  YAML-File (`.gitlab-ci.yml`) in Projektwurzel anlegen, Aufbau siehe
    oben
5.  Build-Skript erstellen, **lokal** lauffähig bekommen, dann in Jobs
    nutzen
6.  Im `.gitlab-ci.yml` die relevanten Branches einstellen (s.o.)
7.  Pushen, und unter `CI/CD > Pipelines` das Builden beobachten
    -   in Status reinklicken und schauen, ob und wo es hakt
8.  `README.md` anlegen in Projektwurzel (neben `.gitlab-ci.yml`),
    Markdown-Schnipsel aus
    `Settings > CI/CD > General pipelines > Pipeline status` auswählen
    und einfügen ....

*Optional*:

9.  Ggf. Schedules unter `CI/CD > Schedules` anlegen
10. Ggf. extra Mails einrichten:
    `Settings > Integrations > Pipeline status emails`

##### GitHub Actions

Siehe ["GitHub Actions: Automate your workflow from idea to
production"](https://github.com/features/actions) und auch ["GitHub:
CI/CD explained"](https://resources.github.com/ci-cd/).

###### Übersicht über Workflows

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/building/images/screenshot-githubci-workflows.png" width="70%" /></p>

Hier sieht man das Ergebnis der letzten Workflows. Dazu sieht man den
Commit und den Branch, auf dem der Workflow gelaufen ist sowie wann er
gelaufen ist. Über die Spalten kann man beispielsweise nach Status oder
Event filtern.

In der Abbildung ist ein Workflow mit dem Namen "GitHub CI" zu sehen,
der aktuell noch läuft.

###### Detailansicht eines Workflows

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/building/images/screenshot-githubci-triggeredworkflow.png" width="70%" /></p>

Wenn man in einen Workflow in der Übersicht anklickt, werden die
einzelnen Jobs dieses Workflows genauer dargestellt. "job3" ist
erfolgreich gelaufen, "job1" läuft gerade, und "job2" hängt von "job1"
ab, d.h. kann erst nach dem erfolgreichen Lauf von "job2" starten.

###### Detailansicht eines Jobs

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/building/images/screenshot-githubci-job.png" width="70%" /></p>

Wenn man in einen Job anklickt, bekommt man quasi die Konsolenausgabe
dieses Jobs. Hier kann man ggf. Fehler beim Ausführen der einzelnen
Skripte oder die Ergebnisse beispielsweise der JUnit-Läufe anschauen.

###### GitHub Actions: Konfiguration mit YAML-Datei

Workflows werden als YAML-Dateien im Ordner `.github/workflows/`
angelegt.

``` yaml
name: GitHub CI

on:
  # push on master branch
  push:
    branches: [master]
  # manually triggered
  workflow_dispatch:

jobs:

  job1:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v6
      - uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'
      - uses: gradle/wrapper-validation-action@v1
      - run: echo "Hello"
      - run: ./gradlew compileJava
      - run: echo "wuppie!"

  job2:
    needs: job1
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v6
      - uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'
      - uses: gradle/wrapper-validation-action@v1
      - run: ./gradlew test

  job3:
    runs-on: ubuntu-latest
    steps:
      - run: echo "Job 3"
```

####### Workflowname und Trigger-Events

Der Name des Workflows wird mit dem Eintrag `name` spezifiziert und
sollte sich im Dateinamen widerspiegeln, also im Beispiel
`.github/workflows/github_ci.yml`.

Im Eintrag `on` können die Events definiert werden, die den Workflow
triggern. Im Beispiel ist ein Push-Event auf dem `master`-Branch
definiert sowie mit `workflow_dispatch:` das manuelle Triggern (auf
einem beliebigen Branch) freigeschaltet.

####### Jobs

Die Jobs werden unter dem Eintrag `jobs` definiert: `job1`, `job2` und
`job3` definieren jeweils einen Job.

-   `job1` besteht aus mehreren Befehlen (unter `steps`), die auf einem
    aktuellen virtualisierten Ubuntu-Runner ausgeführt werden.

    Es wird zunächst das Repo mit Hilfe der Checkout-Action ausgecheckt
    (`uses: actions/checkout@v6`), das JDK eingerichtet/installiert
    (`uses: actions/setup-java@v3`) und der im Repo enthaltene
    Gradle-Wrapper auf Unversehrtheit geprüft
    (`uses: gradle/wrapper-validation-action@v1`).

    Die Actions sind vordefinierte Actions und im Github unter
    `github.com/` + Action zu finden, d.h.
    [`actions/checkout`](https://github.com/actions/checkout) oder
    [`actions/setup-java`](https://github.com/actions/setup-java).
    Actions können von jedermann definiert und bereitgestellt werden, in
    diesem Fall handelt es sich um von GitHub selbst im Namespace
    "actions" bereit gestellte direkt nutzbare Actions. Man kann Actions
    auch selbst im Ordner `.github/actions/` für das Repo definieren
    (Beispiel:
    [plfa.github.io](https://github.com/plfa/plfa.github.io/blob/dev/.github/actions/setup-haskell/action.yml)).

    Mit `run` werden Befehle in der Shell auf dem genutzten Runner (hier
    Ubuntu) ausgeführt.

-   Die Jobs `job2` ist von `job1` abhängig und wird erst gestartet,
    wenn `job1` erfolgreich abgearbeitet ist.

    Ansonsten können die Jobs prinzipiell parallel ausgeführt werden.

Durch die Kombination von Workflows mit verschiedenen Jobs und
Abhängigkeiten zwischen Jobs lassen sich unterschiedliche Pipelines
("Workflows") für verschiedene Zwecke definieren.

Es lassen sich auch andere Runner benutzen, etwa ein virtualisiertes
Windows oder macOS. Man kann auch über einen "Matrix-Build" den Workflow
auf mehreren Betriebssystemen gleichzeitig laufen lassen.

Man kann auch einen Docker-Container benutzen. Dabei muss man beachten,
dass dieser am besten aus einer Registry (etwa von Docker-Hub oder aus
der GitHub-Registry) "gezogen" wird, weil das Bauen des
Docker-Containers aus einem Docker-File in der Action u.U. relativ lange
dauert.

###### Hinweise zur Konfiguration von GitHub Actions

Im Browser in den Repo-Einstellungen arbeiten:

1.  Unter `Settings > Actions > General > Actions permissions` die
    Actions aktivieren (Auswahl, welche Actions erlaubt sind)

    <p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/building/images/screenshot_github_settings_actions.png" width="70%" /></p>

2.  Unter `Settings > Actions > General > Workflow permissions` ggf.
    bestimmen, ob die Actions das Repo nur lesen dürfen oder auch
    zusätzlich schreiben dürfen

    <p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/building/images/screenshot_github_settings_permissions.png" width="70%" /></p>

3.  Unter `Actions > <WORKFLOW>` den Workflow ggf. deaktivieren:

    <p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/building/images/screenshot_github_actions.png" width="70%" /></p>

##### Wrap-Up

Überblick über Continuous Integration:

-   Konfigurierbare Aktionen, die auf dem Gitlab-/GitHub-Server
    ausgeführt werden
-   Unterschiedliche Trigger: Commit, Merge, ...
-   Aktionen können Branch-spezifisch sein
-   Aktionen können von anderen Aktionen abhängen

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   „Documentation Gitlab CI" ([o. J.](#ref-GitlabCI))
> -   GitHub Inc. ([2022a](#ref-GitHubCI))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kann Arbeitsweise von/mit CI (GitHub, GitLab) erklären
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Betrachten Sie erneut das Projekt [Theatrical Players Refactoring
> Kata](https://github.com/emilybache/Theatrical-Players-Refactoring-Kata).
> Erstellen Sie für dieses Projekt einen GitHub-Workflow, der das
> Projekt kompiliert und die Testsuite ausführt (nur für den Java-Teil,
> den restlichen Code können Sie ignorieren).
>
> Dabei soll das Ausführen der JUnit-Tests nur dann erfolgen, wenn das
> Kompilieren erfolgreich durchgeführt wurde.
>
> Der Workflow soll automatisch für Commits in den Hauptbranch sowie für
> Pull-Requests loslaufen. Es soll zusätzlich auch manuell aktivierbar
> sein.
>
> </details>

<a id="id-6cb84000fb9df777e413acabff7c4f83fd52fa7a"></a>

#### Einführung in Docker

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Container sind im Gegensatz zu herkömmlichen VMs eine schlanke
> Virtualisierungslösung. Dabei laufen die Prozesse direkt im Kernel des
> Host-Betriebssystems, aber abgeschottet von den anderen Prozessen
> durch Linux-Techniken wie `cgroups` und `namespaces` (unter Windows
> kommt dafür der WSL2 zum Einsatz, unter macOS wird eine kleine
> Virtualisierung genutzt).
>
> Container sind sehr nützlich, wenn man an mehreren Stellen eine
> identische Arbeitsumgebung benötigt. Man kann dabei entweder die
> Images (fertige Dateien) oder die Dockerfiles (Anweisungen zum
> Erzeugen eines Images) im Projekt verteilen. Tatsächlich ist es nicht
> unüblich, ein Dockerfile in das Projekt-Repo mit einzuchecken.
>
> Durch Container hat man allerdings im Gegensatz zu herkömmlichen VMs
> keinen Sicherheitsgewinn, da die im Container laufende Software ja
> direkt auf dem Host-Betriebssystem ausgeführt wird.
>
> Es gibt auf DockerHub fertige Images, die man sich ziehen und starten
> kann. Ein solches gestartetes Image nennt sich dann Container und
> enthält beispielsweise Dateien, die in den Container gemountet oder
> kopiert werden. Man kann auch eigene Images bauen, indem man eine
> entsprechende Konfiguration (Dockerfile) schreibt. Jeder Befehl bei
> der Erstellung eines Images erzeugt einen neuen Layer, die sich
> dadurch mehrere Images teilen können.
>
> In der Konfiguration einer Gitlab-CI-Pipeline kann man mit `image` ein
> Docker-Image angeben, welches dann in der Pipeline genutzt wird.
>
> VSCode kann über das Remote-Plugin sich (u.a.) mit Containern
> verbinden und dann im Container arbeiten (editieren, compilieren,
> debuggen, testen, ...).
>
> In dieser kurzen Einheit kann ich Ihnen nur einen ersten Einstieg in
> das Thema geben. Wir haben uns beispielsweise nicht Docker Compose
> oder Kubernetes angeschaut, und auch die Themen Netzwerk (zwischen
> Containern oder zwischen Containern und anderen Rechnern) und Volumes
> habe ich außen vor gelassen. Dennoch kommt man in der Praxis bereits
> mit den hier vermittelten Basiskenntnissen erstaunlich weit ...
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Einführung in Docker](https://youtu.be/yERVMfUAano)
> -   [Demo Container in der Konsole](https://youtu.be/LE_QcHqUg9Y)
> -   [Demo GitLab CI/CD und Docker](https://youtu.be/3Tj3lhcoKro)
> -   [Demo GitHub Actions und Docker](https://youtu.be/jrxoax2fPRI)
> -   [Demo VSCode und Docker](https://youtu.be/Rs1W_rXkoNM)
>
> </details>

##### Motivation CI/CD: WFM (*Works For Me*)

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/building/images/ci.png" width="60%" /></p>

Auf dem CI-Server muss man eine Arbeitsumgebung konfigurieren und
bereitstellen, für Java-basierte Projekte muss beispielsweise ein JDK
existieren und man benötigt Tools wie Maven oder Gradle, um die
Buildskripte auszuführen. Je nach Projekt braucht man dann noch weitere
Tools und Bibliotheken. Diese Konfigurationen sind unabhängig vom
CI-Server und werden üblicherweise nicht direkt installiert, sondern
über eine Virtualisierung bereitgestellt.

Selbst wenn man keine CI-Pipelines einsetzt, hat man in Projekten mit
mehreren beteiligten Personen häufig das Problem "*WFM*" ("works for
me"). Jeder Entwickler hat sich auf ihrem Rechner eine
Entwicklungsumgebung aufgesetzt und nutzt in der Regel seine bevorzugte
IDE oder sogar unterschiedliche JDK-Versionen ... Dadurch kann es
schnell passieren, dass Probleme oder Fehler auftreten, die sich nicht
von allen Beteiligten immer nachvollziehen lassen. Hier wäre eine
einheitliche Entwicklungsumgebung sinnvoll, die in einer "schlanken"
Virtualisierung bereitgestellt wird.

Als Entwickler kann man zeitgleich in verschiedenen Projekten beteiligt
sein, die unterschiedliche Anforderungen an die Entwicklungstools mit
sich bringen. Es könnte beispielsweise passieren, dass man zeitgleich
drei bestimmte Python-Versionen benötigt. In den meisten Fällen schafft
man es (mit ein wenig Aufwand), diese Tools nebeneinander zu
installieren. Oft ist das in der Praxis aber schwierig und
fehleranfällig.

In diesen Fällen kann eine Virtualisierung helfen.

##### Virtualisierung: Container vs. VM

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/building/images/virtualisierung.png" width="50%" /></p>

Wenn man über Virtualisierung auf dem Desktop spricht, kann man grob
zwei Varianten unterscheiden. In beiden Fällen ist die Basis die
Hardware (Laptop, Desktop-Rechner) und das darauf laufende (Host-)
Betriebssystem (Linux, FreeBSD, macOS, Windows, ...). Darauf läuft dann
wiederum die Virtualisierung.

Im rechten Bild wird eine herkömmliche Virtualisierung mit virtuellen
Maschinen (*VM*) dargestellt. Dabei wird in der VM ein komplettes
Betriebssystem (das "Gast-Betriebssystem") installiert und darin läuft
dann die gewünschte Anwendung. Die Virtualisierung (VirtualBox, VMware,
...) läuft dabei als Anwendung auf dem Host-Betriebssystem und stellt
dem Gast-Betriebssystem in der VM einen Rechner mit CPU, RAM, ... zur
Verfügung und übersetzt die Systemaufrufe in der VM in die
entsprechenden Aufrufe im Host-Betriebssystem. Dies benötigt in der
Regel entsprechende Ressourcen: Durch das komplette Betriebssystem in
der VM ist eine VM (die als Datei im Filesystem des Host-Betriebssystems
liegt) oft mehrere 10GB groß. Für die Übersetzung werden zusätzlich
Hardwareressourcen benötigt, d.h. hier gehen CPU-Zyklen und RAM
"verloren" ... Das Starten einer VM dauert entsprechend lange, da hier
ein komplettes Betriebssystem hochgefahren werden muss. Dafür sind die
Prozesse in einer VM relativ stark vom Host-Betriebssystem abgekapselt,
so dass man hier von einer "Sandbox" sprechen kann: Viren o.ä. können
nicht so leicht aus einer VM "ausbrechen" und auf das
Host-Betriebssystem zugreifen (quasi nur über Lücken im
Gast-Betriebssystem kombiniert mit Lücken in der
Virtualisierungssoftware).

Im linken Bild ist eine schlanke Virtualisierung auf Containerbasis
dargestellt. Die Anwendungen laufen direkt als Prozesse im
Host-Betriebssystem, ein Gast-Betriebssystem ist nicht notwendig. Durch
den geschickten Einsatz von `namespaces` und `cgroups` und anderen in
Linux und FreeBSD verfügbaren Techniken werden die Prozesse
abgeschottet, d.h. der im Container laufende Prozess "sieht" die anderen
Prozesse des Hosts nicht. Die Erstellung und Steuerung der Container
übernimmt hier beispielsweise Docker. Die Container sind dabei auch
wieder Dateien im Host-Filesystem. Dadurch benötigen Container
wesentlich weniger Platz als herkömmliche VMs, der Start einer Anwendung
geht deutlich schneller und die Hardwareressourcen (CPU, RAM, ...)
werden effizient genutzt. Nachteilig ist, dass hier in der Regel ein
Linux-Host benötigt wird (für Windows wird mittlerweile der Linux-Layer
(*WSL*) genutzt; für macOS wurde bisher eine Linux-VM im Hintergrund
hochgefahren, mittlerweile wird aber eine eigene schlanke
Virtualisierung eingesetzt). Außerdem steht im Container üblicherweise
kein graphisches Benutzerinterface zur Verfügung. Da die Prozesse direkt
im Host-Betriebssystem laufen, stellen Container keine
Sicherheitsschicht ("Sandboxen") dar!

In allen Fällen muss die Hardwarearchitektur beachtet werden: Auf einer
Intel-Maschine können normalerweise keine VMs/Container basierend auf
ARM-Architektur ausgeführt werden und umgekehrt.

##### Getting started

-   DockerHub: fertige Images =\>
    [hub.docker.com/search](https://hub.docker.com/search?q=&type=image)

<!-- -->

-   Image downloaden: `docker pull <IMAGE>`
-   Image starten: `docker run <IMAGE>`

###### Begriffe

-   **Docker-File**: Beschreibungsdatei, wie Docker ein Image erzeugen
    soll.
-   **Image**: Enthält die Dinge, die lt. dem Docker-File in das Image
    gepackt werden sollen. Kann gestartet werden und erzeugt damit einen
    Container.
-   **Container**: Ein laufendes Images (genauer: eine laufende Instanz
    eines Images). Kann dann auch zusätzliche Daten enthalten.

###### Beispiele

    docker pull debian:stable-slim
    docker run  --rm -it  debian:stable-slim  /bin/sh

`debian` ist ein fertiges Images, welches über DockerHub bereit gestellt
wird. Mit dem Postfix `stable-slim` wird eine bestimmte Version
angesprochen.

Mit `docker run debian:stable-slim` startet man das Image, es wird ein
Container erzeugt. Dieser enthält den aktuellen Datenstand, d.h. wenn
man im Image eine Datei anlegt, wäre diese dann im Container enthalten.

Mit der Option `--rm` wird der Container nach Beendigung automatisch
wieder gelöscht. Da jeder Aufruf von `docker run <IMAGE>` einen neuen
Container erzeugt, würden sich sonst recht schnell viele Container auf
dem Dateisystem des Hosts ansammeln, die man dann manuell aufräumen
müsste. Man kann aber einen beendeten Container auch erneut laufen
lassen ... (vgl. Dokumentation von `docker`). Mit der Option `--rm` sind
aber auch im Container angelegte Daten wieder weg! Mit der Option `-it`
wird der Container interaktiv gestartet und man landet in einer Shell.

Bei der Definition eines Images kann ein "*Entry Point*" definiert
werden, d.h. ein Programm, welches automatisch beim Start des Container
ausgeführt wird. Häufig erlauben Images aber auch, beim Start ein
bestimmtes auszuführendes Programm anzugeben. Im obigen Beispiel ist das
`/bin/sh`, also eine Shell ...

    docker pull openjdk:latest
    docker run  --rm  -v "$PWD":/data -w /data  openjdk:latest  javac Hello.java
    docker run  --rm  -v "$PWD":/data -w /data  openjdk:latest  java Hello

Auch für Java gibt es vordefinierte Images mit einem JDK. Das Tag
"`latest`" zeigt dabei auf die letzte stabile Version des
`openjdk`-Images. Üblicherweise wird "`latest`" von den Entwicklern
immer wieder weiter geschoben, d.h. auch bei anderen Images gibt es ein
"`latest`"-Tag. Gleichzeitig ist es die Default-Einstellung für die
Docker-Befehle, d.h. es kann auch weggelassen werden:
`docker run openjdk:latest` und `docker run openjdk` sind gleichwertig.
Alternativ kann man hier auch hier wieder eine konkrete Version angeben.

Über die Option `-v` wird ein Ordner auf dem Host (hier durch `"$PWD"`
dynamisch ermittelt) in den Container eingebunden ("gemountet"), hier
auf den Ordner `/data`. Dort sind dann die Dateien sichtbar, die im
Ordner `"$PWD"` enthalten sind. Über die Option `-w` kann ein
Arbeitsverzeichnis definiert werden.

Mit `javac Hello.java` wird `javac` im Container aufgerufen auf der
Datei `/data/Hello.java` im Container, d.h. die Datei `Hello.java`, die
im aktuellen Ordner des Hosts liegt (und in den Container gemountet
wurde). Das Ergebnis (`Hello.class`) wird ebenfalls in den Ordner
`/data/` im Container geschrieben und erscheint dann im
Arbeitsverzeichnis auf dem Host ... Analog kann dann mit `java Hello`
die Klasse ausgeführt werden.

<p align="right"><a href="https://youtu.be/LE_QcHqUg9Y">Demo: Container in der Konsole</a></p>

##### Images selbst definieren

``` docker
FROM debian:stable-slim

ARG USERNAME=pandoc
ARG USER_UID=1000
ARG USER_GID=1000

RUN apt-get update && apt-get install -y --no-install-recommends            \
        apt-utils bash wget make graphviz biber                             \
        texlive-base texlive-plain-generic texlive-latex-base               \
    #
    && groupadd --gid $USER_GID $USERNAME                                   \
    && useradd -s /bin/bash --uid $USER_UID --gid $USER_GID -m $USERNAME    \
    #
    && apt-get autoremove -y && apt-get clean -y && rm -rf /var/lib/apt/lists/*

WORKDIR /pandoc
USER $USERNAME
```

`docker build -t <NAME> -f <DOCKERFILE> .`

`FROM` gibt die Basis an, d.h. hier ein Image von Debian in der Variante
`stable-slim`, d.h. das ist der Basis-Layer für das zu bauende
Docker-Image.

Über `ARG` werden hier Variablen gesetzt.

`RUN` ist der Befehl, der im Image (hier Debian) ausgeführt wird und
einen neuen Layer hinzufügt. In diesen Layer werden alle Dateien
eingefügt, die bei der Ausführung des Befehls erzeugt oder angelegt
werden. Hier im Beispiel wird das Debian-Tool `apt-get` gestartet und
weitere Debian-Pakete installiert.

Da jeder `RUN`-Befehl einen neuen Layer anlegt, werden die restlichen
Konfigurationen ebenfalls in diesem Lauf durchgeführt. Insbesondere wird
ein nicht-Root-User angelegt, der von der UID und GID dem Default-User
in Linux entspricht. Die gemounteten Dateien haben die selben Rechte wie
auf dem Host, und durch die Übereinstimmung von UID/GID sind die Dateien
problemlos zugreifbar und man muss nicht mit dem Root-User arbeiten
(dies wird aus offensichtlichen Gründen als Anti-Pattern angesehen).
Bevor der `RUN`-Lauf abgeschlossen wird, werden alle temporären und
später nicht benötigten Dateien von `apt-get` entfernt, damit diese
nicht Bestandteil des Layers werden.

Mit `WORKDIR` und `USER` wird das Arbeitsverzeichnis gesetzt und auf den
angegebenen User umgeschaltet. Damit muss der User nicht mehr beim
Aufruf von außen gesetzt werden.

Über `docker build -t <NAME> -f <DOCKERFILE> .` wird aus dem angegebenen
Dockerfile und dem Inhalt des aktuellen Ordners ("`.`") ein neues Image
erzeugt und mit dem angegebenen Namen benannt.

**Hinweis zum Umgang mit Containern und Updates**: Bei der Erstellung
eines Images sind bestimmte Softwareversionen Teil des Images geworden.
Man kann prinzipiell in einem Container die Software aktualisieren, aber
dies geht in dem Moment wieder verloren, wo der Container beendet und
gelöscht wird. Außerdem widerspricht dies dem Gedanken, dass mehrere
Personen mit dem selben Image/Container arbeiten und damit auch die
selben Versionsstände haben. In der Praxis löscht man deshalb das alte
Image einfach und erstellt ein neues, welches dann die aktualisierte
Software enthält.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/building/src/docker/debian-latex.df">Beispiel: debian-latex.df</a></p>

##### CI-Pipeline (GitLab)

``` yaml
default:
    image: openjdk:17

job1:
    stage: build
    script:
        - java -version
        - javac Hello.java
        - java Hello
        - ls -lags
```

In den Gitlab-CI-Pipelines (analog wie in den GitHub-Actions) kann man
Docker-Container für die Ausführung der Pipeline nutzen.

Mit `image: openjdk:17` wird das Docker-Image `openjdk:17` vom DockerHub
geladen und durch den Runner für die Stages als Container ausgeführt.
Die Aktionen im `script`-Teil, wie beispielsweise `javac Hello.java`
werden vom Runner an die Standard-Eingabe der Shell des Containers
gesendet. Im Prinzip entspricht das dem Aufruf auf dem lokalen Rechner:
`docker run openjdk:17 javac Hello.java`.

<p align="right"><a href="https://youtu.be/3Tj3lhcoKro">Demo: GitLab CI/CD und Docker</a></p>

##### CI-Pipeline (GitHub)

``` yaml
name: demo
on:
    push:
        branches: [master]
    workflow_dispatch:

jobs:
    job1:
        runs-on: ubuntu-latest
        container: docker://openjdk:17
        steps:
            - uses: actions/checkout@v6
            - run: java -version
            - run: javac Hello.java
            - run: java Hello
            - run: ls -lags
```

https://stackoverflow.com/questions/71283311/run-github-workflow-on-docker-image-with-a-dockerfile
https://docs.github.com/en/actions/using-jobs/running-jobs-in-a-container

In den GitHub-Actions kann man Docker-Container für die Ausführung der
Pipeline nutzen.

Mit `docker://openjdk:17` wird das Docker-Image `openjdk:17` vom
DockerHub geladen und auf dem Ubuntu-Runner als Container ausgeführt.
Die Aktionen im `steps`-Teil, wie beispielsweise `javac Hello.java`
werden vom Runner an die Standard-Eingabe der Shell des Containers
gesendet. Im Prinzip entspricht das dem Aufruf auf dem lokalen Rechner:
`docker run openjdk:17 javac Hello.java`.

<p align="right"><a href="https://youtu.be/jrxoax2fPRI">Demo: GitHub Actions und Docker</a></p>

##### VSCode und das Plugin "Remote - Containers"

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/building/images/vscode-remote.png" width="80%" /></p>

1.  VSCode (Host): Plugin "Remote - Containers" installieren
2.  Docker (Host): Container starten mit Workspace gemountet
3.  VSCode (Host): Attach to Container =\> neues Fenster (Container)
4.  VSCode (Container): Plugin "Java Extension Pack" installieren
5.  VSCode (Container): Dateien editieren, kompilieren, debuggen, ...

Mit Visual Studio Code (VSC) kann man über SSH oder in einem Container
arbeiten. Dazu installiert man sich VSC lokal auf dem Host und
installiert dort das Plugin "Remote - Containers". VSC kann darüber
vordefinierte Docker-Images herunterladen und darin arbeiten oder man
kann alternativ einen Container selbst starten und diesen mit VSC
verbinden ("attachen").

Beim Verbinden öffnet VSC ein neues Fenster, welches mit dem Container
verbunden ist. Nun kann man in diesem neuen Fenster ganz normal
arbeiten, allerdings werden alle Dinge in dem Container erledigt. Man
öffnet also Dateien in diesem Container, editiert sie im Container,
übersetzt und testet im Container und nutzt dabei die im Container
installierten Tools. Sogar die entsprechenden VSC-Plugins kann man im
Container installieren.

Damit benötigt man auf einem Host eigentlich nur noch VSC und Docker,
aber keine Java-Tools o.ä. und kann diese über einen im Projekt
definierten Container (über ein mit versioniertes Dockerfile) nutzen.

*Anmerkung*: IntelliJ kann remote nur debuggen, d.h. das Editieren,
Übersetzen, Testen läuft lokal auf dem Host (und benötigt dort den
entsprechenden Tool-Stack). Für das Debuggen kann Idea das übersetzte
Projekt auf ein Remote (SSH, Docker) schieben und dort debuggen.

Noch einen Schritt weiter geht das Projekt
[code-server](https://github.com/coder/code-server): Dieses stellt u.a.
ein Docker-Image
[codercom/code-server](https://hub.docker.com/r/codercom/code-server)
bereit, welches einen Webserver startet und über diesen kann man ein im
Container laufendes (angepasstes) VSC erreichen. Man braucht also nur
noch Docker und das Image und kann dann über den Webbrowser
programmieren. Der Projektordner wird dabei in den Container gemountet,
so dass die Dateien entsprechend zur Verfügung stehen:

``` sh
docker run -it --name code-server -p 127.0.0.1:8080:8080 -v "$HOME/.config:/home/coder/.config" -v "$PWD:/home/coder/project" codercom/code-server:latest
```

Auf diesem Konzept setzt auch der kommerzielle Service [GitHub
Codespaces](https://github.com/features/codespaces) von GitHub auf.

<p align="right"><a href="https://youtu.be/Rs1W_rXkoNM">Demo: VSCode und Docker</a></p>

##### Link-Sammlung

-   [Wikipedia: Docker](https://en.wikipedia.org/wiki/Docker_(software))
-   [Wikipedia: Virtuelle
    Maschinen](https://en.wikipedia.org/wiki/Virtual_machine)
-   [Docker: Überblick,
    Container](https://www.docker.com/resources/what-container)
-   [Docker: HowTo](https://docs.docker.com/get-started/)
-   [DockerHub: Suche nach fertigen
    Images](https://hub.docker.com/search?q=&type=image)
-   [Docker und Java](https://docs.docker.com/language/java/)
-   [Dockerfiles: Best
    Practices](https://docs.docker.com/develop/develop-images/dockerfile_best-practices/)
-   [Gitlab,
    Docker](http://git03-ifm-min.ad.hsbi.de/help/ci/docker/using_docker_images.md#overriding-the-entrypoint-of-an-image)
-   [VSCode: Entwickeln in
    Docker-Containern](https://code.visualstudio.com/docs/remote/containers)
-   Nickoloff ([2019](#ref-DockerInAction)) und Miell und Sayers
    ([2019](#ref-DockerInPractice))

##### Wrap-Up

-   Schlanke Virtualisierung mit Containern (kein eigenes OS)
-   *Kein* Sandbox-Effekt

<!-- -->

-   Begriffe: Docker-File vs. Image vs. Container
-   Ziehen von vordefinierten Images
-   Definition eines eigenen Images
-   Arbeiten mit Containern: lokal, CI/CD, VSCode ...

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Ullenboom ([2021](#ref-Ullenboom2021))
> -   Inden ([2013](#ref-Inden2013))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kann zwischen Containern und VMs unterscheiden
> -   k1: Ich kenne typische Einsatzgebiete für Container
> -   k2: Ich verstehe, dass Container als abgeschottete Prozesse auf
>     dem Host laufen - kein Sandbox-Effekt
> -   k3: Ich kann Container von DockerHub ziehen
> -   k3: Ich kann Container starten
> -   k3: Ich kann eigene Container definieren und bauen
> -   k3: Ich kann Container in GitLab CI/CD und/oder GitHub Actions
>     einsetzen
> -   k3: Ich kann VSCode mit Containern einsetzen
>
> </details>

<a id="id-19400266e5430e8e00eb11d78e73c4723fefbc3b"></a>

### Softwarequalität und Testen mit JUnit und Mockito

<a id="id-d34a1123257baba72f157fdf29caa69090e90127"></a>

#### Logging

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Im Paket `java.util.logging` findet sich eine einfache Logging-API.
>
> Über die Methode `getLogger()` der Klasse `Logger`
> (*Factory-Method-Pattern*) kann ein (neuer) Logger erzeugt werden,
> dabei wird über den String-Parameter eine Logger-Hierarchie aufgebaut
> analog zu den Java-Package-Strukturen. Der oberste Logger (der
> "Root-Logger") hat den leeren Namen.
>
> Jeder Logger kann mit einem Log-Level (Klasse `Level`) eingestellt
> werden; Log-Meldungen unterhalb des eingestellten Levels werden
> verworfen.
>
> Vom Logger nicht verworfene Log-Meldungen werden an den bzw. die
> Handler des Loggers und (per Default) an den Eltern-Logger weiter
> gereicht. Die Handler haben ebenfalls ein einstellbares Log-Level und
> verwerfen alle Nachrichten unterhalb der eingestellten Schwelle. Zur
> tatsächlichen Ausgabe gibt man einem Handler noch einen Formatter mit.
> Defaultmäßig hat nur der Root-Logger einen Handler.
>
> Der Root-Logger (leerer String als Name) hat als Default-Level (wie
> auch sein Console-Handler) "`Info`" eingestellt.
>
> Nachrichten, die durch Weiterleitung nach oben empfangen wurden,
> werden nicht am Log-Level des empfangenden Loggers gemessen, sondern
> akzeptiert und an die Handler des Loggers und (sofern nicht
> deaktiviert) an den Elternlogger weitergereicht.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Logging](https://youtu.be/_jYWJzr1rkA)
> -   [Demo Logging (Überblick)](https://youtu.be/fWSc5A_CPL8)
> -   [Demo Log-Level](https://youtu.be/0UUVQCVYNHo)
> -   [Demo Logging: Handler und
>     Formatter](https://youtu.be/dYOYA99EfrY)
> -   [Demo Weiterleitung an den
>     Elternlogger](https://youtu.be/19Bki4IglWQ)
>
> </details>

##### Wie prüfen Sie die Werte von Variablen/Objekten?

1.  Debugging
    -   Beeinflusst Code nicht
    -   Kann schnell komplex und umständlich werden
    -   Sitzung transient - nicht wiederholbar

<!-- -->

2.  "Poor-man's-debugging" (Ausgaben mit `System.out.println`)
    -   Müssen irgendwann entfernt werden
    -   Ausgabe nur auf einem Kanal (Konsole)
    -   Keine Filterung nach Problemgrad - keine Unterscheidung zwischen
        Warnungen, einfachen Informationen, ...

<!-- -->

3.  **Logging**
    -   Verschiedene (Java-) Frameworks: `java.util.logging` (JDK),
        *log4j* (Apache), *SLF4J*, *Logback*, ...

##### Java Logging API - Überblick

Paket `java.util.logging`

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/quality/images/logging.png" width="65%" /></p>

Eine Applikation kann verschiedene Logger instanziieren. Die Logger
bauen per Namenskonvention hierarchisch aufeinander auf. Jeder Logger
kann selbst mehrere Handler haben, die eine Log-Nachricht letztlich auf
eine bestimmte Art und Weise an die Außenwelt weitergeben.

Log-Meldungen werden einem Level zugeordnet. Jeder Logger und Handler
hat ein Mindest-Level eingestellt, d.h. Nachrichten mit einem kleineren
Level werden verworfen.

Zusätzlich gibt es noch Filter, mit denen man Nachrichten (zusätzlich
zum Log-Level) nach weiteren Kriterien filtern kann.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/quality/src/logging/LoggingDemo.java">Konsole: logging.LoggingDemo</a></p>

##### Erzeugen neuer Logger

``` java
import java.util.logging.Logger;
Logger l = Logger.getLogger(MyClass.class.getName());
```

-   **Factory-Methode** der Klasse `java.util.logging.Logger`

    ``` java
    public static Logger getLogger(String name);
    ```

    =\> Methode liefert bereits **vorhandenen Logger** mit diesem Namen
    (sonst neuen Logger)

-   **Best Practice**: Nutzung des voll-qualifizierten Klassennamen:
    `MyClass.class.getName()`

    -   Leicht zu implementieren
    -   Leicht zu erklären
    -   Spiegelt modulares Design
    -   Ausgaben enthalten automatisch Hinweis auf Herkunft (Lokalität)
        der Meldung
    -   **Alternativen**: Funktionale Namen wie "XML", "DB", "Security"

##### Ausgabe von Logmeldungen

``` java
public void log(Level level, String msg);
```

-   Diverse Convenience-Methoden (Auswahl):

    ``` java
    public void warning(String msg)
    public void info(String msg)
    public void entering(String srcClass, String srcMethod)
    public void exiting(String srcClass, String srcMethod)
    ```

<!-- -->

-   Beispiel

    ``` java
    import java.util.logging.Logger;
    Logger l = Logger.getLogger(MyClass.class.getName());
    l.info("Hello World :-)");
    ```

##### Wichtigkeit von Logmeldungen: Stufen

-   `java.util.logger.Level` definiert 7 Stufen:
    -   `SEVERE`, `WARNING`, `INFO`, `CONFIG`, `FINE`, `FINER`, `FINEST`
        (von höchster zu niedrigster Prio)
    -   Zusätzlich `ALL` und `OFF`

<!-- -->

-   Nutzung der Log-Level:
    -   Logger hat Log-Level: Meldungen mit kleinerem Level werden
        verworfen
    -   Prüfung mit `public boolean isLoggable(Level)`
    -   Setzen mit `public void setLevel(Level)`

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/quality/src/logging/LoggingLevel.java">Konsole: logging.LoggingLevel</a></p>

=\> Warum wird im Beispiel nach `log.setLevel(Level.ALL);` trotzdem nur
ab `INFO` geloggt? Wer erzeugt eigentlich die Ausgaben?!

##### Jemand muss die Arbeit machen ...

-   Pro Logger **mehrere** Handler möglich
    -   Logger übergibt nicht verworfene Nachrichten an Handler
    -   Handler haben selbst ein Log-Level (analog zum Logger)
    -   Handler verarbeiten die Nachrichten, wenn Level ausreichend

<!-- -->

-   Standard-Handler: `StreamHandler`, `ConsoleHandler`, `FileHandler`

<!-- -->

-   Handler nutzen zur Formatierung der Ausgabe einen `Formatter`
-   Standard-Formatter: `SimpleFormatter` und `XMLFormatter`

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/quality/src/logging/LoggingHandler.java">Konsole: logging.LoggingHandler</a></p>

=\> Warum wird im Beispiel nach dem Auskommentieren von
`log.setUseParentHandlers(false);` immer noch eine zusätzliche Ausgabe
angezeigt (ab `INFO` aufwärts)?!

##### Ich ... bin ... Dein ... Vater ...

-   Logger bilden **Hierarchie** über Namen
    -   Trenner für Namenshierarchie: "`.`" (analog zu Packages) =\> mit
        jedem "`.`" wird eine weitere Ebene der Hierarchie aufgemacht
        ...
    -   Jeder Logger kennt seinen Eltern-Logger: `Logger#getParent()`
    -   Basis-Logger: leerer Name (`""`)
        -   Voreingestelltes Level des Basis-Loggers: `Level.INFO` (!)

<!-- -->

-   Weiterleiten von Nachrichten
    -   Nicht verworfene Log-Aufrufe werden an Eltern-Logger
        weitergeleitet (Default)
        -   Abschalten mit `Logger#setUseParentHandlers(false);`
    -   Diese leiten an ihre Handler sowie an ihren Eltern-Logger weiter
        (unabhängig von Log-Level!)

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/quality/src/logging/LoggingParent.java">Konsole: logging.LoggingParent; Tafel: Skizze Logger-Baum</a></p>

##### Wrap-Up

-   Java Logging API im Paket `java.util.logging`

<!-- -->

-   Neuer Logger über **Factory-Methode** der Klasse `Logger`
    -   Einstellbares Log-Level (Klasse `Level`)
    -   Handler kümmern sich um die Ausgabe, nutzen dazu Formatter
    -   Mehrere Handler je Logger registrierbar
    -   Log-Level auch für Handler einstellbar (!)
    -   Logger (und Handler) "interessieren" sich nur für Meldungen ab
        bestimmter Wichtigkeit
    -   Logger reichen nicht verworfene Meldungen defaultmäßig an
        Eltern-Logger weiter (rekursiv)

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Oracle Corporation ([2022, Kap. 8](#ref-JDK-Doc))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k3: Ich kann die Java Logging API im Paket java.util.logging aktiv
>     einsetzen
> -   k3: Ich kann eigene Handler und Formatter schreiben
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Logger-Konfiguration**
>
> Betrachten Sie den folgenden Java-Code:
>
> ``` java
> import java.util.logging.*;
>
> public class Logging {
>     public static void main(String... args) {
>         Logger l = Logger.getLogger("Logging");
>         l.setLevel(Level.FINE);
>
>         ConsoleHandler myHandler = new ConsoleHandler();
>         myHandler.setFormatter(new SimpleFormatter() {
>             public String format(LogRecord record) {
>                 return "WUPPIE\n";
>             }
>         });
>         l.addHandler(myHandler);
>
>         l.info("A");
>         l.fine("B");
>         l.finer("C");
>         l.finest("D");
>         l.severe("E");
>     }
> }
> ```
>
> Welche Ausgaben entstehen durch den obigen Code? Erklären Sie, welche
> der Logger-Aufrufe zu einer Ausgabe führen und wieso und wie diese
> Ausgaben zustande kommen bzw. es keine Ausgabe bei einem Logger-Aufruf
> gibt. Gehen Sie dabei auf jeden der fünf Aufrufe ein.
>
> **Analyse eines Live-Beispiels aus dem Dungeon**
>
> Analysieren Sie die Konfiguration des Loggers im Dungeon-Projekt:
> [Dungeon-CampusMinden/Dungeon:
> core/utils/logging/LoggerConfig.java](https://github.com/Dungeon-CampusMinden/Dungeon/blob/master/game/src/core/utils/logging/LoggerConfig.java).
>
> </details>

<a id="id-034f87112a6be7c5c927ef1775d293b8b6d7774c"></a>

#### Einführung Softwaretest

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Fehler schleichen sich durch Zeitdruck und hohe Komplexität schnell in
> ein Softwareprodukt ein. Die Folgen können von "ärgerlich" über
> "teuer" bis hin zu (potentiell) "tödlich" reichen. Richtiges Testen
> ist also ein wichtiger Aspekt bei der Softwareentwicklung!
>
> JUnit ist ein Java-Framework, mit dem Unit-Tests (aber auch andere
> Teststufen) implementiert werden können. In JUnit 4 und 5 zeichnet man
> eine Testmethode mit Hilfe der Annotation `@Test` an der
> entsprechenden Methode aus. Dadurch kann man Produktiv- und Test-Code
> prinzipiell mischen; Best Practice ist aber das Anlegen eines weiteren
> Ordners `test/` und das Spiegeln der Package-Strukturen. Für die zu
> testende Klasse wird eine korrespondierende Testklasse mit dem Suffix
> "Test" (Konvention) angelegt und dort die Testmethoden implementiert.
> Der IDE muss der neue `test/`-Ordner noch als Ordner für Sourcen bzw.
> Tests bekannt gemacht werden. In den Testmethoden baut man den Test
> auf, führt schließlich den Testschritt durch (beispielsweise konkreter
> Aufruf der zu testenden Methode) und prüft anschließend mit einem
> `assert*()`, ob das erzielte Ergebnis dem erwarteten Ergebnis
> entspricht. Ist alles OK, ist der Test "grün", sonst "rot".
>
> Da ein fehlschlagendes `assert*()` den Test abbricht, werden eventuell
> danach folgende Prüfungen **nicht** mehr durchgeführt und damit ggf.
> weitere Fehler maskiert. Deshalb ist es gute Praxis, in einer
> Testmethode nur einen Testfall zu implementieren und i.d.R. auch nur
> ein (oder wenige) Aufrufe von `assert*()` pro Testmethode zu haben.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Einführung Softwaretest](https://youtu.be/WGd83crqu4I)
> -   [Demo Anlegen von Testfällen mit
>     JUnit](https://youtu.be/xcogVwHUo5o)
>
> </details>

##### Software-Fehler und ihre Folgen

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/quality/images/swfehler.png" width="70%" /></p>

##### (Einige) Ursachen für Fehler

-   Zeit- und Kostendruck
-   Mangelhafte Anforderungsanalyse
-   Hohe Komplexität
-   Mangelhafte Kommunikation
-   Keine/schlechte Teststrategie
-   Mangelhafte Beherrschung der Technologie
-   ...

##### Irgendjemand muss mit Deinen Bugs leben!

Leider gibt es im Allgemeinen keinen Weg zu zeigen, dass eine Software
korrekt ist. Man kann (neben formalen Beweisansätzen) eine Software nur
unter möglichst vielen Bedingungen ausprobieren, um zu schauen, wie sie
sich verhält, und um die dabei zu Tage tretenden Bugs zu fixen.

Mal abgesehen von der verbesserten *User-Experience* führt weniger
fehlerbehaftete Software auch dazu, dass man seltener mitten in der
Nacht geweckt wird, weil irgendwo wieder ein Server gecrasht ist ...
Weniger fehlerbehaftete Software ist auch leichter zu ändern und zu
pflegen! In realen Projekten macht Maintenance den größten Teil an der
Softwareentwicklung aus ... Während Ihre Praktikumsprojekte vermutlich
nach der Abgabe nie wieder angeschaut werden, können echte Projekte
viele Jahre bis Jahrzehnte leben! D.h. irgendwer muss sich dann mit
Ihren Bugs herumärgern - vermutlich sogar Sie selbst ;)

> Always code as if the guy who ends up maintaining your code will be a
> violent psychopath who knows where you live. Code for readability.
>
> -- [John F.
> Woods](https://groups.google.com/g/comp.lang.c++/c/rYCO5yn4lXw/m/oITtSkZOtoUJ)

Dieses Zitat taucht immer mal wieder auf, beispielsweise auf der [OSCON
2014](https://twitter.com/andypiper/status/490952891058757632) ... Es
scheint aber tatsächlich, dass [John F.
Woods](https://groups.google.com/g/comp.lang.c++/c/rYCO5yn4lXw/m/oITtSkZOtoUJ)
die ursprüngliche Quelle war (vgl. [Stackoverflow:
876089](https://stackoverflow.com/questions/876089/who-wrote-this-programing-saying-always-code-as-if-the-guy-who-ends-up-maintai#878436)).

Da wir nur wenig Zeit haben und zudem vergesslich sind und obendrein die
Komplexität eines Projekts mit der Anzahl der Code-Zeilen i.d.R.
nicht-linear ansteigt, müssen wir das Testen automatisieren. Und hier
kommt JUnit ins Spiel :)

##### Was wann testen? Wichtigste Teststufen

-   **Modultest**
    -   Testen einer Klasse und ihrer Methoden
    -   Test auf gewünschtes Verhalten (Parameter, Schleifen, ...)

<!-- -->

-   **Integrationstest**
    -   Test des korrekten Zusammenspiels mehrerer Komponenten
    -   Konzentration auf Schnittstellentests

<!-- -->

-   **Systemtest**
    -   Test des kompletten Systems unter produktiven Bedingungen
    -   Orientiert sich an den aufgestellten Use Cases
    -   Funktionale und nichtfunktionale Anforderungen testen

=\> Verweis auf Wahlfach "Softwarequalität"

##### JUnit: Test-Framework für Java

**JUnit** --- Open Source Java Test-Framework zur Erstellung und
Durchführung wiederholbarer Tests

-   JUnit 3
    -   Tests müssen in eigenen Testklassen stehen
    -   Testklassen müssen von Klasse `TestCase` erben
    -   Testmethoden müssen mit dem Präfix "`test`" beginnen

<!-- -->

-   **JUnit 4**
    -   Annotation `@Test` für Testmethoden
    -   Kein Zwang zu spezialisierten Testklassen (insbesondere kein
        Zwang mehr zur Ableitung von `TestCase`)
    -   Freie Namenswahl für Testmethoden (benötigen nicht mehr Präfix
        "`test`")

    Damit können prinzipiell auch direkt im Source-Code Methoden als
    JUnit-Testmethoden ausgezeichnet werden ... (das empfiehlt sich in
    der Regel aber nicht)

<!-- -->

-   *JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage*
    -   Erweiterung um mächtigere Annotationen
    -   Aufteilung in spezialisierte Teilprojekte

    Das Teilprojekt "JUnit Platform" ist die Grundlage für das
    JUnit-Framework. Es bietet u.a. einen Console-Launcher, um
    Testsuiten manuell in der Konsole zu starten oder über Builder wie
    Ant oder Gradle.

    Das Teilprojekt "JUnit Jupiter" ist das neue Programmiermodell zum
    Schreiben von Tests in JUnit 5. Es beinhaltet eine TestEngine zum
    Ausführen der in Jupiter geschriebenen Tests.

    Das Teilprojekt "JUnit Vintage" beinhaltet eine TestEngine zum
    Ausführen von Tests, die in JUnit 3 oder JUnit 4 geschrieben sind.

*Anmerkung*: Wie der Name schon sagt, ist das Framework für Modultests
("Unit-Tests") gedacht. Man kann damit aber auch auf anderen Teststufen
arbeiten!

*Anmerkung*: Im Folgenden besprechen wir JUnit am Beispiel **JUnit 4**,
da diese Version des Frameworks besonders stark verbreitet ist und JUnit
5 (trotz offiziellem Release) immer noch stellenweise unfertig wirkt.
Auf Unterschiede zu JUnit 5 wird an geeigneter Stelle hingewiesen
(abgesehen von Import-Statements). Mit JUnit 3 sollte nicht mehr aktiv
gearbeitet werden, d.h. insbesondere keine neuen Tests mehr erstellt
werden, da diese Version nicht mehr weiterentwickelt wird.

##### Anlegen und Organisation der Tests mit JUnit

-   Anlegen neuer Tests: Klasse auswählen, Kontextmenü
    `New > JUnit Test Case` (IJ: Kontextmenü `Generate > Test`)

<!-- -->

-   **Best Practice**:  Spiegeln der Paket-Hierarchie
    -   Toplevel-Ordner `test` (statt `src`)
    -   Package-Strukturen spiegeln
    -   Testklassen mit Suffix "`Test`"

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/quality/images/newJUnit.png" width="40%" /></p>

Vorteile dieses Vorgehens:

-   Die Testklassen sind aus Java-Sicht im selben Package wie die
    Source-Klassen, d.h. Zugriff auf Package-sichtbare Methoden etc. ist
    gewährleistet
-   Durch die Spiegelung der Packages in einem separaten Testordner
    erhält man eine gute getrennte Übersicht über jeweils die Tests und
    die Sourcen
-   Die Wiederverwendung des Klassennamens mit dem Anhang "Test" erlaubt
    die schnelle Erkennung, welche Tests hier vorliegen

In der Paketansicht liegen dann die Source- und die Testklassen immer
direkt hintereinander (da sie im selben Paket sind und mit dem selben
Namen anfangen) =\> besserer Überblick!

##### Anmerkung: Die (richtige) JUnit-Bibliothek muss im Classpath liegen!

Eclipse bringt für JUnit 4 und JUnit 5 die nötigen Jar-Dateien mit und
fragt beim erstmaligen Anlegen einer neuen Testklasse, ob die für die
ausgewählte Version **passenden JUnit-Jars zum Build-Path hinzugefügt**
werden sollen.

IntelliJ bringt ebenfalls eine JUnit 4 Bibliothek mit, die zum Projekt
als Abhängigkeit hinzugefügt werden muss. Für JUnit 5 bietet IntelliJ
an, die Jar-Dateien herunterzuladen und in einem passenden Ordner
abzulegen.

Alternativ lädt man die Bibliotheken entsprechend der Anleitung unter
[junit.org](https://junit.org/) herunter und bindet sie in das Projekt
ein.

##### JUnit 4+5: Definition von Tests

Annotation `@Test` vor Testmethode schreiben

``` java
import org.junit.Test;
import static org.junit.Assert.*;

public class FactoryBeispielTest4 {
    @Test
    public void testGetTicket() {
        fail("not implemented");
    }
}
```

Für JUnit 5 muss statt `org.junit.Test` entsprechend
`org.junit.jupiter.api.Test` importiert werden.

Während in JUnit 4 die Testmethoden mit der Sichtbarkeit `public`
versehen sein müssen und keine Parameter haben (dürfen), spielt die
Sichtbarkeit in JUnit 5 keine Rolle (und die Testmethoden dürfen
Parameter aufweisen =\> vgl. Abschnitt "Dependency Injection for
Constructors and Methods" in der JUnit-Doku).

##### JUnit 4: Ergebnis prüfen

Klasse **`org.junit.Assert`** enthält diverse **statische** Methoden zum
Prüfen:

``` java
// Argument muss true bzw. false sein
void assertTrue(boolean);
void assertFalse(boolean);

// Gleichheit im Sinne von equals()
void assertEquals(Object, Object);

// Test sofort fehlschlagen lassen
void fail();

...
```

Für JUnit 5 finden sich die Assert-Methoden im Package
`org.junit.jupiter.api.Assertions`.

##### Anmerkung zum statischen Import

Bei normalem Import der Klasse `Assert` muss man jeweils den voll
qualifizierten Namen einer statischen Methode nutzen: `Assert.fail()`.

Alternative statischer Import: `import static org.junit.Assert.fail;`
=\> *Statische Member* der importierten Klasse (oder Interface) werden
über ihre *unqualifizierten Namen* zugreifbar. **Achtung**:
Namenskollisionen möglich!

``` java
// nur bestimmtes Member importieren
import static packageName.className.staticMemberName;
// alle statischen Member importieren
import static packageName.className.*;
```

-   Beispiel normaler Import:

    ``` java
    import org.junit.Assert;
    Assert.fail("message");
    ```

<!-- -->

-   Beispiel statischer Import:

    ``` java
    import static org.junit.Assert.fail;
    fail("message");
    ```

##### Mögliche Testausgänge bei JUnit

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/quality/images/junitErgebnis.png" width="40%" /></p>

1.  **Error**: Fehler im Programm (Test)
    -   Unbehandelte Exception
    -   Abbruch (Timeout)

<!-- -->

2.  **Failure**: Testausgang negativ
    -   Assert fehlgeschlagen
    -   `Assert.fail()` aufgerufen

<!-- -->

3.  **OK**

##### Anmerkungen zu Assert

-   Pro Testmethode möglichst nur **ein** Assert verwenden!
-   Anderenfalls: Schlägt ein Assert fehl, wird der Rest nicht mehr
    überprüft ...

##### Wrap-Up

-   Testen ist genauso wichtig wie Coden
-   Richtiges Testen spart Geld, Zeit, ...
-   Tests auf verschiedenen Abstraktionsstufen

<!-- -->

-   JUnit als Framework für (Unit-) Tests; hier JUnit 4 (mit Ausblick
    auf JUnit 5)
    -   Testmethoden mit Annotation `@Test`
    -   Testergebnis mit `assert*` prüfen

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   <span class="nocase">vogella GmbH</span>
>     ([2021](#ref-vogellaJUnit))
> -   The JUnit Team ([2022](#ref-junit4))
> -   Kleuker ([2019](#ref-Kleuker2019))
> -   Osherove ([2014](#ref-Osherove2014))
> -   Spillner und Linz ([2012](#ref-Spillner2012))
> -   Thies u. a. ([o. J.](#ref-fernunihagenJunit))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kenne verschiedene Ursachen von Softwarefehlern
> -   k3: Ich kann Tests mit JUnit 4 und 5 unter Nutzung der Annotation
>     `@Test` erstellen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Einfache JUnit-Tests I**
>
> Betrachten Sie die folgende einfache (und nicht besonders sinnvolle)
> Klasse `MyList<T>`:
>
> ``` java
> public class MyList<T> {
>     protected final List<T> list = new ArrayList<>();
>
>     public boolean add(T element) { return list.add(element); }
>     public int size() { return list.size(); }
> }
> ```
>
> Schreiben Sie mit Hilfe von JUnit (4.x oder 5.x) einige Unit-Tests für
> die beiden Methoden `MyList<T>#add` und `MyList<T>#size`.
>
> **Einfache JUnit-Tests II**
>
> Betrachten Sie die Methode `String concat(String str)` der Klasse
> `String` aus dem JDK.
>
> Implementieren Sie drei verschiedenartige Unit-Testfälle (inklusive
> der Eingabe- und Rückgabewerte) für diese Methode mit Hilfe von JUnit
> (Version 4.x oder 5.x).
> </details>

<a id="id-fdac50744187e0bbb0d93a110ad70910667d5eed"></a>

#### Testen mit JUnit (JUnit-Basics)

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> In JUnit 4 und 5 werden Testmethoden mit Hilfe der Annotation `@Test`
> ausgezeichnet. Über die verschiedenen `assert*()`-Methoden kann das
> Testergebnis mit dem erwarteten Ergebnis verglichen werden und
> entsprechend ist der Test "grün" oder "rot". Mit den verschiedenen
> `assume*()`-Methoden kann dagegen geprüft werden, ob eventuelle
> Vorbedingungen für das Ausführen eines Testfalls erfüllt sind -
> anderenfalls wird der Testfall dann übersprungen.
>
> Mit Hilfe von `@Before` und `@After` können Methoden gekennzeichnet
> werden, die jeweils vor jeder Testmethode und nach jeder Testmethode
> aufgerufen werden. Damit kann man seine Testumgebung auf- und auch
> wieder abbauen (JUnit 4).
>
> Erwartete Exceptions lassen sich in JUnit 4 mit einem Parameter
> `expected` in der Annotation `@Test` automatisch prüfen:
> `@Test(expected=package.Exception.class)`. In JUnit 4 besteht die
> Möglichkeit, Testklassen zu Testsuiten zusammenzufassen und gemeinsam
> laufen zu lassen.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL JUnit Basics](https://youtu.be/2SC40rO0ZOE)
> -   [Demo assume() vs. assert()](https://youtu.be/j3FK9iTHuDk)
> -   [Demo Parametrisierte Tests mit
>     JUnit4](https://youtu.be/KsFydUSBDTc)
> -   [Demo Parametrisierte Tests mit
>     JUnit5](https://youtu.be/0H-OCICktS0)
>
> </details>

##### JUnit: Ergebnis prüfen

Klasse **`org.junit.Assert`** enthält diverse **statische** Methoden zum
Prüfen:

``` java
// Argument muss true bzw. false sein
void assertTrue(boolean);
void assertFalse(boolean);

// Gleichheit im Sinne von equals()
void assertEquals(Object, Object);

// Test sofort fehlschlagen lassen
void fail();

...
```

##### To "assert" or to "assume"?

-   Mit `assert*` werden Testergebnisse geprüft
    -   Test wird ausgeführt
    -   Ergebnis: OK, Failure, Error

<!-- -->

-   Mit `assume*` werden Annahmen über den Zustand geprüft
    -   Test wird abgebrochen, wenn Annahme nicht erfüllt (Ergebnis:
        "Ignored")
    -   Prüfen von Vorbedingungen: Ist der Test hier
        ausführbar/anwendbar?

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/quality/src/junit4/TestAssume.java">Beispiel: junit4.TestAssume</a></p>

Im JUnit-Kontext nutzen wir `assume*` für das **Überprüfen von
*Annahmen*** (im Sinne von **Vorbedingungen**): Wenn ein `assume*`
fehlschlägt, wird der Testfall abgebrochen bzw. als "ignoriert"
gewertet.

Dagegen setzen wir `assert*` für das **Überprüfen der *Testergebnisse***
ein, d.h. ein fehlschlagendes `assert*` lässt den Testfall "rot" werden.

##### Java: "assert"-Keyword

Neben den wohlbekannten `assert*`-Methoden aus JUnit gibt es auch direkt
von Java ein etwas verstecktes `assert`-Keyword, mit dem man Annahmen
über Zustände und Werte explizit ausdrücken kann:

``` java
public void foo() {
    String bar = wuppie();
    assert bar != null : "result of wuppie() must not be null";
}
```

Das `assert` besteht aus einer zu prüfenden Bedingung und einem String.
Wenn die Bedingung erfüllt ist, läuft der Code einfach normal weiter.
Anderenfalls wird ein `AssertionError` geworfen mit dem angegebenen
String als Message.

Allerdings sind diese JVM-Assertions per Default **deaktiviert**. Man
muss sie beim Aufruf manuell über die Option `-enableassertions` bzw.
`-ea` (Kurzschreibweise) aktivieren (`java -ea main`)! Dies gilt auch
beim Start über die IDE oder Gradle ...

> [!WARNING]
>
> Wichtig: Die Assertions sind per Default deaktiviert und müssen erst
> manuell aktiviert werden. Außerdem wird bei Verletzung der Bedingung
> eine *unchecked exception* (ein Error) geworfen, der auf einen nicht
> korrigierbaren Programmzustand hindeutet.
>
> 1.  Nutzen Sie das Java-`assert` deshalb nicht als Ersatz für das
>     normale Prüfen von Parametern von `public` Methoden (also Methoden
>     der Schnittstelle, die Ihre Kunden aufrufen).
>
> 2.  Während der Entwicklungszeit kann das Java-`assert` aber ganz
>     nützlich sein, weil Sie so interne Annahmen sichtbar und prüfbar
>     machen (vorausgesetzt, Sie haben `-ea` aktiviert).
>
>     Analog könnte ein Java-`assert` an Stellen eingebaut werden, die
>     eigentlich nicht erreichbar sein sollten (etwa nach einer
>     Dauerschleife oder in einem nicht erreichbaren `default`-Zweig in
>     einem `switch`).
>
> 3.  Bitte das Java-`assert` **nie** in einer JUnit-Testmethode statt
>     der "richtigen" JUnit-`assert*` verwenden!
>
> 4.  Das Java-`assert` ist in einer JUnit-Testmethode **kein** Ersatz
>     für die JUnit-`assume*`-Methoden!

##### Setup und Teardown: Testübergreifende Konfiguration

``` java
private Studi x;

@Before
public void setUp() { x = new Studi(); }

@Test
public void testToString() {
    // Studi x = new Studi();
    assertEquals(x.toString(), "Heinz (15cps)");
}
```

**`@Before`**
:   wird **vor jeder** Testmethode aufgerufen

**`@BeforeClass`**
:   wird **einmalig** vor allen Tests aufgerufen (`static`!)

**`@After`**
:   wird **nach jeder** Testmethode aufgerufen

**`@AfterClass`**
:   wird **einmalig** nach allen Tests aufgerufen (`static`!)

In JUnit 5 wurden die Namen dieser Annotationen leicht geändert:

| JUnit 4        | JUnit 5       |
|:---------------|:--------------|
| `@Before`      | `@BeforeEach` |
| `@After`       | `@AfterEach`  |
| `@BeforeClass` | `@BeforeAll`  |
| `@AfterClass`  | `@AfterAll`   |

##### Beispiel für den Einsatz von `@Before`

Annahme: **alle/viele** Testmethoden brauchen **neues** Objekt `x` vom
Typ `Studi`

``` java
private Studi x;

@Before
public void setUp() {
    x = new Studi("Heinz", 15);
}

@Test
public void testToString() {
    // Studi x = new Studi("Heinz", 15);
    assertEquals(x.toString(), "Name: Heinz, credits: 15");
}

@Test
public void testGetName() {
    // Studi x = new Studi("Heinz", 15);
    assertEquals(x.getName(), "Heinz");
}
```

##### Ignorieren von Tests

-   Hinzufügen der Annotation `@Ignore`
-   Alternativ mit Kommentar: `@Ignore("Erst im nächsten Release")`

``` java
@Ignore("Warum ignoriert")
@Test
public void testBsp() {
    Bsp x = new Bsp();
    assertTrue(x.isTrue());
}
```

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/quality/images/junitIgnore.png" width="40%" /></p>

In JUnit 5 wird statt der Annotation `@Ignore` die Annotation
`@Disabled` mit der selben Bedeutung verwendet. Auch hier lässt sich als
Parameter ein String mit dem Grund für das Ignorieren des Tests
hinterlegen.

##### Vermeidung von Endlosschleifen: Timeout

-   Testfälle werden nacheinander ausgeführt
-   Test mit Endlosschleife würde restliche Tests blockieren
-   Erweitern der `@Test`-Annotation mit Parameter "`timeout`": =\>
    `@Test(timeout=2000)` (Zeitangabe in Millisekunden)

``` java
@Test(timeout = 2000)
void testTestDauerlaeufer() {
    while (true) { ; }
}
```

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/quality/images/junitIgnore.png" width="40%" /></p>

In JUnit 5 hat die Annotation `@Test` keinen `timeout`-Parameter mehr.
Als Alternative bietet sich der Einsatz von
`org.junit.jupiter.api.Assertions.assertTimeout` an. Dabei benötigt man
allerdings *Lambda-Ausdrücke* (Verweis auf spätere VL):

``` java
@Test
void testTestDauerlaeufer() {
    assertTimeout(ofMillis(2000), () -> {
        while (true) { ; }
    });
}
```

(Beispiel von oben mit Hilfe von JUnit 5 formuliert)

##### Test von Exceptions: Expected

Traditionelles Testen von Exceptions mit `try` und `catch`:

``` java
@Test
public void testExceptTradit() {
    try {
        int i = 0 / 0;
        fail("keine ArithmeticException ausgeloest");
    } catch (ArithmeticException aex) {
        assertNotNull(aex.getMessage());
    } catch (Exception e) {
        fail("falsche Exception geworfen");
    }
}
```

Der `expected`-Parameter für die `@Test`-Annotation in JUnit 4 macht
dies deutlich einfacher: `@Test(expected = MyException.class)` =\> Test
scheitert, wenn diese Exception **nicht** geworfen wird

``` java
@Test(expected = java.lang.ArithmeticException.class)
public void testExceptAnnot() {
    int i = 0 / 0;
}
```

In JUnit 5 hat die Annotation `@Test` keinen `expected`-Parameter mehr.
Als Alternative bietet sich der Einsatz von
`org.junit.jupiter.api.Assertions.assertThrows` an. Dabei benötigt man
allerdings *Lambda-Ausdrücke* (Verweis auf spätere VL):

``` java
@Test
public void testExceptAnnot() {
    assertThrows(java.lang.ArithmeticException.class, () -> {
        int i = 0 / 0;
    });
}
```

(Beispiel von oben mit Hilfe von JUnit 5 formuliert)

##### "Given - When - Then"-Mantra

Aus dem [Behavior-driven
development](https://en.wikipedia.org/wiki/Behavior-driven_development)
stammt die Strukturierung nach den Punkten "given - when - then" (oft
auch als *"given - when - then"-Mantra* bezeichnet).

Betrachten Sie noch einmal die Schnittstelle der Studi-Klasse:

``` java
public class Studi {
    public String getName();
    public void setName(String name);
    public int getCredits();
    public void addToCredits(int credits);
}
```

Dafür wurde ein Test geschrieben:

``` java
class StudiTest {
    @Test
    public void testStudi() {
        Studi s = new Studi();
        int cps = 2;
        s.addToCredits(cps);
        assertEquals(cps, s.getCredits());
    }
}
```

Dieser Code ist in seiner Absicht nicht sofort verständlich. Es fällt
auf, dass

1.  am Anfang eine Art Setup des Tests vorgenommen wird und das
    Testobjekt initialisiert wird ("**given**").
2.  Dann wird die zu untersuchende Aktion ausgeführt ("**when**"),
    gefolgt von
3.  einem Vergleich des tatsächlichen mit dem erwarteten Ergebnis
    ("**then**").

Diese gedachte Struktur kann (und sollte!) man mit entsprechenden
Kommentaren auch sichtbar machen:

``` java
class StudiTest {
    @Test
    public void testStudi() {
        // given
        Studi s = new Studi();
        int cps = 2;

        // when
        s.addToCredits(cps);

        // then
        assertEquals(cps, s.getCredits());
    }
}
```

In Testframeworks wie [Spock](https://spockframework.org/) oder
[Cucumber](https://cucumber.io/) ist dies sogar bereits in die Sprache
(eine DSL zum Testen) eingebaut! Einen schönen Blog zum Thema finden Sie
hier: [Spock testing framework versus
JUnit](https://blog.codepipes.com/testing/spock-vs-junit.html).

Weiterhin könnte (und sollte) man die implizit getroffenen Annahmen über
das SUT für alle sichtbar machen:

``` java
class StudiTest {
    @Test
    public void testStudi() {
        // given
        Studi s = new Studi();
        int cps = 2;
        assumeTrue(s.getCredits() == 0, "initial credits should be 0");

        // when
        s.addToCredits(cps);

        // then
        assertEquals(cps, s.getCredits());
    }
}
```

Der Test würde ohnehin fehlschlagen, wenn ein neues `Studi`-Objekt mit
einem anderen Wert für die Credits initialisiert würde. Aber so zeigt
das `assume` direkt unsere (bisher) implizite Annahme sichtbar an, und
bei einer Verletzung dieser Annahme würde der Testfall mit einer
entsprechenden Mitteilung nicht ausgeführt.

Oft wird noch das "given - when - then"-Mantra auch auf die
Methodennamen der Testmethoden übertragen:[^6]

``` java
class StudiTest {
    @Test
    public void GivenNewStudi_WhenAddingCredits_ThenCreditsCountChangesAccordingly() {
        // given
        Studi s = new Studi();
        int cps = 2;
        assumeTrue(s.getCredits() == 0, "initial credits should be 0");

        // when
        s.addToCredits(cps);

        // then
        assertEquals(cps, s.getCredits());
    }
}
```

Eine schöne Erklärung finden Sie im Blog [The subtle Art of Java Test
Method
Naming](https://jonasg.io/posts/subtle-art-of-java-test-method-naming/).

... Und nun könnte man sich fragen, warum man das Erhöhen von Credits
nur für ein *neues* `Studi`-Objekt testet und nicht auch für andere
Zustände des `Studi`-Objekts? ... =\> Parametrisierte Tests!

##### Parametrisierte Tests

Manchmal möchte man den selben Testfall mehrfach mit anderen Werten
(Parametern) durchführen.

``` java
class Sum {
    public static int sum(int i, int j) {
        return i + j;
    }
}

class SumTest {
    @Test
    public void testSum() {
        Sum s = new Sum();
        assertEquals(s.sum(1, 1), 2);
    }
    // und mit (2,2, 4), (2,2, 5), ...????
}
```

Prinzipiell könnte man dafür entweder in einem Testfall eine Schleife
schreiben, die über die verschiedenen Parameter iteriert. In der
Schleife würde dann jeweils der Aufruf der zu testenden Methode und das
gewünschte Assert passieren. Alternativ könnte man den Testfall
entsprechend oft duplizieren mit jeweils den gewünschten Werten.

Beide Vorgehensweisen haben Probleme: Im ersten Fall würde die Schleife
bei einem Fehler oder unerwarteten Ergebnis abbrechen, ohne dass die
restlichen Tests (Werte) noch durchgeführt würden. Im zweiten Fall
bekommt man eine unnötig große Anzahl an Testmethoden, die bis auf die
jeweiligen Werte identisch sind (Code-Duplizierung).

###### Parametrisierte Tests mit JUnit 4

JUnit 4 bietet für dieses Problem sogenannte "parametrisierte Tests" an.
Dafür muss eine Testklasse in JUnit 4 folgende Bedingungen erfüllen:

1.  Die Testklasse wird mit der Annotation
    `@RunWith(Parameterized.class)` ausgezeichnet.
2.  Es muss eine öffentliche statische Methode geben mit der Annotation
    `@Parameters`. Diese Methode liefert eine Collection zurück, wobei
    jedes Element dieser Collection ein Array mit den Parametern für
    einen Durchlauf der Testmethoden ist.
3.  Die Parameter müssen gesetzt werden. Dafür gibt es zwei Varianten:
    -   (A) Für jeden Parameter gibt es ein öffentliches Attribut. Diese
            Attribute müssen mit der Annotation `@Parameter` markiert
            sein und können in den Testmethoden normal genutzt werden.
            JUnit sorgt dafür, dass für jeden Eintrag in der Collection
            aus der statischen `@Parameters`-Methode diese Felder
            gesetzt werden und die Testmethoden aufgerufen werden.
    -   (B) Alternativ gibt es einen Konstruktor, der diese Werte setzt.
            Die Anzahl der Parameter im Konstruktor muss dabei exakt der
            Anzahl (und Reihenfolge) der Werte in jedem Array in der von
            der statischen `@Parameters`-Methode gelieferten Collection
            entsprechen. Der Konstruktor wird für jeden Parametersatz
            einmal aufgerufen und die Testmethoden einmal durchgeführt.

Letztlich wird damit das Kreuzprodukt aus Testmethoden und Testdaten
durchgeführt.

####### (A) Parametrisierte Tests: Konstruktor (JUnit 4)

``` java
@RunWith(Parameterized.class)
public class SumTestConstructor {
    private final int s1;
    private final int s2;
    private final int erg;

    public SumTestConstructor(int p1, int p2, int p3) { s1 = p1;  s2 = p2;  erg = p3; }

    @Parameters
    public static Collection<Object[]> values() {
        return Arrays.asList(new Object[][] { { 1, 1, 2 }, { 2, 2, 4 }, { 2, 2, 5 } });
    }

    @Test
    public void testSum() {
        assertEquals(Sum.sum(s1, s2), erg);
    }
}
```

####### (B) Parametrisierte Tests: Parameter (JUnit 4)

``` java
@RunWith(Parameterized.class)
public class SumTestParameters {

    @Parameter(0)  public int s1;
    @Parameter(1)  public int s2;
    @Parameter(2)  public int erg;

    @Parameters
    public static Collection<Object[]> values() {
        return Arrays.asList(new Object[][] { { 1, 1, 2 }, { 2, 2, 4 }, { 2, 2, 5 } });
    }

    @Test
    public void testSum() {
        assertEquals(Sum.sum(s1, s2), erg);
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/junit4/">Beispiel: junit4.SumTestConstructor, junit4.SumTestParameters</a></p>

###### Parametrisierte Tests mit JUnit 5

In JUnit 5 werden [parametrisierte
Tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests)
mit der Annotation
[`@ParameterizedTest`](https://junit.org/junit5/docs/current/api/org.junit.jupiter.params/org/junit/jupiter/params/ParameterizedTest.html)
gekennzeichnet (statt mit `@Test`).

Mit Hilfe von
[`@ValueSource`](https://junit.org/junit5/docs/current/api/org.junit.jupiter.params/org/junit/jupiter/params/provider/ValueSource.html)
kann man ein einfaches Array von Werten (Strings oder primitive
Datentypen) angeben, mit denen der Test ausgeführt wird. Dazu bekommt
die Testmethode einen entsprechenden passenden Parameter:

``` java
@ParameterizedTest
@ValueSource(strings = {"wuppie", "fluppie", "foo"})
void testWuppie(String candidate) {
    assertTrue(candidate.equals("wuppie"));
}
```

Alternativ lassen sich als Parameterquelle u.a. Aufzählungen
([`@EnumSource`](https://junit.org/junit5/docs/current/api/org.junit.jupiter.params/org/junit/jupiter/params/provider/EnumSource.html))
oder Methoden
([`@MethodSource`](https://junit.org/junit5/docs/current/api/org.junit.jupiter.params/org/junit/jupiter/params/provider/MethodSource.html))
oder auch Komma-separierte Daten
([`@CsvSource`](https://junit.org/junit5/docs/current/api/org.junit.jupiter.params/org/junit/jupiter/params/provider/CsvSource.html))
angeben.

Das obige Beispiel aus JUnit 4.x könnte mit Hilfe von `@CsvSource` so in
JUnit 5.x umgesetzt werden:

``` java
public class SumTest {
    @ParameterizedTest
    @CsvSource(textBlock = """
            # s1,  s2,  s1+s2
            0,     0,   0
            10,    0,   10
            0,     11,  11
            -2,    10,  8
            """)
    public void testSum(int s1, int s2, int erg) {
        assertEquals(Sum.sum(s1, s2), erg);
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/junit5/">Beispiel: junit5.TestValueSource, junit5.TestMethodSource</a></p>

##### Testsuiten: Tests gemeinsam ausführen (JUnit 4)

Eclipse: `New > Other > Java > JUnit > JUnit Test Suite`

``` java
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    // Hier kommen alle Testklassen rein
    PersonTest.class,
    StudiTest.class
})

public class MyTestSuite {
    // bleibt leer!!!
}
```

##### Testsuiten mit JUnit 5

In JUnit 5 gibt es zwei Möglichkeiten, Testsuiten zu erstellen:

-   `@SelectPackages`: Angabe der Packages, die für die Testsuite
    zusammengefasst werden sollen
-   `@SelectClasses`: Angabe der Klassen, die für die Testsuite
    zusammengefasst werden sollen

``` java
@RunWith(JUnitPlatform.class)
@SelectClasses({StudiTest5.class, WuppieTest5.class})
public class MyTestSuite5 {
    // bleibt leer!!!
}
```

Zusätzlich kann man beispielsweise mit `@IncludeTags` oder
`@ExcludeTags` Testmethoden mit bestimmten Tags einbinden oder
ausschließen. Beispiel: Schließe alle Tests mit Tag "develop" aus:
`@ExcludeTags("develop")`. Dabei wird an den Testmethoden zusätzlich das
Tag `@Tag` verwendet, etwas `@Tag("develop")`.

**Achtung**: Laut der offiziellen Dokumentation [(Abschnitt "4.4.4. Test
Suite")](https://junit.org/junit5/docs/current/user-guide/#running-tests-junit-platform-runner-test-suite)
gilt zumindest bei der Selection über `@SelectPackages` der Zwang zu
einer Namenskonvention: Es werden dabei nur Klassen gefunden, deren Name
mit `Test` beginnt oder endet! Weiterhin werden Testsuites mit der
Annotation `@RunWith(JUnitPlatform.class)` **nicht** auf der "JUnit
5"-Plattform ausgeführt, sondern mit der JUnit 4-Infrastuktur!

##### Best Practices

1.  Eine Testmethode behandelt exakt eine Idee/ein Szenario (einen
    Testfall). Das bedeutet auch, dass man in der Regel nur ein bis
    wenige `assert*` pro Testmethode benutzt.

    (Wenn man verschiedene Ideen in eine Testmethode kombiniert, wird
    der Testfall unübersichtlicher und auch auch schwerer zu warten.

    Außerdem können so leichter versteckte Fehler auftreten: Das erste
    oder zweite oder dritte `assert*` schlägt fehl - und alle dahinter
    kommenden `assert*` werden nicht mehr ausgewertet!)

2.  Wenn die selbe Testidee mehrfach wiederholt wird, sollte man diese
    Tests zu einem parametrisierten Test zusammenfassen.

    (Das erhöht die Lesbarkeit drastisch - und man läuft auch nicht in
    das Problem der Benennung der Testmethoden.)

3.  Es wird nur das Verhalten der öffentlichen Schnittstelle getestet,
    nicht die inneren Strukturen einer Klasse oder Methode.

    (Es ist verlockend, auch private Methoden zu testen und in den Tests
    auch die Datenstrukturen o.ä. im Blick zu behalten und zu testen.
    Das führt aber zu sehr "zerbrechlichen" (*brittle*) Tests: Sobald
    sich etwas an der inneren Struktur ändert, ohne dass sich das von
    außen beobachtbare Verhalten ändert und also die Klasse/Methode
    immer noch ordnungsgemäß funktioniert, gehen all diese "internen"
    Tests kaputt. Nicht ohne Grund wird in der objektorientierten
    Programmierung mit Kapselung (Klassen, Methoden, ...) gearbeitet.)

4.  Von Setup- und Teardown-Methoden sollte eher sparsam Gebrauch
    gemacht werden.

    (Normalerweise folgen wir in der objektorientierten Programmierung
    dem DRY-Prinzip ([Don't repeat
    yourself](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself)).
    Entsprechend liegt es nahe, häufig benötigte Elemente in einer
    Setup-Methode zentral zu initialisieren und ggf. in einer
    Teardown-Methode wieder freizugeben.

    Das führt aber speziell bei Unit-Tests dazu, dass die einzelnen
    Testmethoden schwerer lesbar werden: Sie hängen von einer
    gemeinsamen, zentralen Konfiguration ab, die man üblicherweise nicht
    gleichzeitig mit dem Code der Testmethode sehen kann (begrenzter
    Platz auf der Bildschirmseite).

    Wenn nun in einem oder vielleicht mehreren Testfällen der Wunsch
    nach einer leicht anderen Konfiguration auftaucht, muss man die
    gemeinsame Konfiguration entsprechend anpassen bzw. erweitern. Dabei
    muss man dann aber *alle* anderen Testmethoden mit bedenken, die ja
    ebenfalls von dieser Konfiguration abhängen! Das führt in der Praxis
    dann häufig dazu, dass die gemeinsame Konfiguration sehr schnell
    sehr groß und verschachtelt und entsprechend unübersichtlich wird.

    Jede Änderung an dieser Konfiguration kann leicht einen oder mehrere
    Testfälle kaputt machen (man hat ja i.d.R. nie alle Testfälle
    gleichzeitig im Blick), weshalb man hier unbedingt mit passenden
    `assume*` arbeiten muss - aber dann kann man eigentlich auch
    stattdessen die Konfiguration direkt passend für den jeweiligen
    Testfall in der jeweiligen Testmethode erledigen!)

5.  Wie immer sollten auch die Namen der Testmethoden klar über ihren
    Zweck Auskunft geben.

    (Da Tests oft auch als "ausführbare Dokumentation" betrachtet
    werden, ist eine sinnvolle Benamung besonders wichtig. Oft werden
    hier deshalb Ausnahmen von den üblichen Java-Konventionen erlaubt.
    Man findet häufig das aus dem [Behavior-driven
    development](https://en.wikipedia.org/wiki/Behavior-driven_development)
    bekannte "given - when - then"-Mantra. Siehe auch [The subtle Art of
    Java Test Method
    Naming](https://jonasg.io/posts/subtle-art-of-java-test-method-naming/)
    und auch [Spock testing framework versus
    JUnit](https://blog.codepipes.com/testing/spock-vs-junit.html).

    Der Präfix "test" für Testmethoden wird seit JUnit 4.x nicht mehr
    benötigt, aber dennoch ist es in vielen Projekten Praxis, diesen
    Präfix beizubehalten - damit kann man in der Package-Ansicht in der
    IDE leichter zwischen den "normalen" und den Testmethoden
    unterscheiden. Das ist analog zum Suffix "Test" für die Klassennamen
    der Testklassen ...)

Diese Erfahrungen werden ausführlich in ([Winters u. a.
2020](#ref-SWEGoogle), pp. 231-256) diskutiert.

Eine lesenswerte Diskussion von "Anti-Pattern" beim Testen finden Sie im
Blog [Software Testing
Anti-patterns](https://blog.codepipes.com/testing/software-testing-antipatterns.html).

##### Wrap-Up

JUnit als Framework für (Unit-) Tests; hier JUnit 4 (mit Ausblick auf
JUnit 5)

-   Testmethoden mit Annotation `@Test`
-   `assert` (Testergebnis) vs. `assume` (Testvorbedingung)
-   Aufbau der Testumgebung `@Before`
-   Abbau der Testumgebung `@After`
-   Steuern von Tests mit `@Ignore` oder `@Test(timout=XXX)`
-   Exceptions einfordern mit `@Test(expected=package.Exception.class)`
-   Tests zusammenfassen zu Testsuiten

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   <span class="nocase">vogella GmbH</span>
>     ([2021](#ref-vogellaJUnit))
> -   The JUnit Team ([2022](#ref-junit4))
> -   Kleuker ([2019](#ref-Kleuker2019))
> -   Osherove ([2014](#ref-Osherove2014))
> -   Spillner und Linz ([2012](#ref-Spillner2012))
> -   Thies u. a. ([o. J.](#ref-fernunihagenJunit))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k3: Ich kann Testergebnisse prüfen
> -   k2: Ich kenne den Unterschied zwischen `assert` und `assume`
> -   k3: Ich kann vor/nach jedem Test bestimmten Code ausführen
> -   k2: Ich habe verstanden, warum `@Before` und `@After` sparsam
>     einzusetzen sind
> -   k3: Ich kann die Ausführung von Tests steuern, beispielsweise
>     Tests ignorieren oder mit zeitlicher Begrenzung ausführen
> -   k3: Ich kann das Auftreten von Exceptions prüfen
> -   k3: Ich kann Tests zu Testsuiten zusammenfassen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Setup und Teardown**
>
> Sie haben in den Challenges in "Intro SW-Test" erste JUnit-Tests für
> die Klasse `MyList<T>` implementiert.
>
> Wie müssten Sie Ihre JUnit-Tests anpassen, wenn Sie im obigen Szenario
> Setup- und Teardown-Methoden einsetzen würden?
>
> **Testmethoden**
>
> Betrachten Sie den folgenden Code. Was fällt Ihnen auf?
>
> ``` java
> public class Studi {
>     public int getCredits();
>     public void addToCredits(int credits);
>
>     @Test
>     public void testStudi() {
>         Studi s = new Studi();
>         s.addToCredits(2);
>         assertEquals(2, s.getCredits());
>     }
> }
> ```
>
> **Parametrisierte Tests**
>
> Betrachten Sie die folgende einfache Klasse `MyMath`:
>
> ``` java
> public class MyMath {
>     public static String add(String s, int c) {
>         return s.repeat(c);
>     }
> }
> ```
>
> Beim Testen der Methode `MyMath#add` fällt auf, dass man hier immer
> wieder den selben Testfall mit lediglich anderen Werten ausführt - ein
> Fall für parametrisierte Tests.
>
> Schreiben Sie mit Hilfe von JUnit (4.x oder 5.x) einige
> parametrisierte Unit-Tests für die Methode `MyMath#add`.
>
> </details>

<a id="id-5faf7bc2998ca41cbb5f5b342c1b46d28f6d1b85"></a>

#### Testfallermittlung: Wie viel und was muss man testen?

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Mit Hilfe der Äquivalenzklassenbildung kann man Testfälle bestimmen.
> Dabei wird der Eingabebereich für jeden Parameter einer Methode in
> Bereiche mit gleichem Verhalten der Methode eingeteilt (die
> sogenannten "Äquivalenzklassen"). Dabei können einige
> Äquivalenzklassen (ÄK) gültigen Eingabebereichen entsprechen ("gültige
> ÄK"), also erlaubten/erwarteten Eingaben (die zum gewünschten
> Verhalten führen), und die restlichen ÄK entsprechen dann ungültigen
> Eingabebereichen ("ungültige ÄK"), also nicht erlaubten Eingaben, die
> von der Methode zurückgewiesen werden sollten. Jede dieser ÄK muss in
> mindestens einem Testfall vorkommen, d.h. man bestimmt einen oder
> mehrere zufällige Werte in den ÄK. Dabei können über mehrere Parameter
> hinweg verschiedene gültige ÄK in einem Testfall kombiniert werden.
> Bei den ungültigen ÄK kann dagegen immer nur ein Parameter eine
> ungültige ÄK haben, für die restlichen Parameter müssen gültige ÄK
> genutzt werden, und diese werden dabei als durch diesen Testfall
> "nicht getestet" betrachtet.
>
> Zusätzlich entstehen häufig Fehler bei den Grenzen der Bereiche, etwa
> in Schleifen. Deshalb führt man zusätzlich noch eine Grenzwertanalyse
> durch und bestimmt für jede ÄK den unteren und den oberen Grenzwert
> und erzeugt aus diesen Werten zusätzliche Testfälle.
>
> Wenn in der getesteten Methode der Zustand des Objekts eine Rolle
> spielt, wird dieser wie ein weiterer Eingabeparameter für die Methode
> betrachtet und entsprechend in die ÄK-Bildung bzw. GW-Analyse
> einbezogen.
>
> Wenn ein Testfall sich aus den gültigen ÄK/GW speist, spricht man auch
> von einem "Positiv-Test"; wenn ungültige ÄK/GW genutzt werden, spricht
> man auch von einem "Negativ-Test".
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Testfallermittlung](https://youtu.be/AR1WWt4AFqI)
>
> </details>

##### Hands-On (10 Minuten): Wieviel und was muss man testen?

``` java
public class Studi {
    private int credits = 0;

    public void addToCredits(int credits) {
        if (credits < 0) {
            throw new IllegalArgumentException("Negative Credits!");
        }
        if (this.credits + credits > 210) {
            throw new IllegalArgumentException("Mehr als 210 Credits!");
        }
        this.credits += credits;
    }
}
```

###### *JEDE* Methode mindestens testen mit/auf:

-   Positive Tests: Gutfall (Normalfall) =\> "gültige ÄK/GW"
-   Negativ-Tests (Fehlbedienung, ungültige Werte) =\> "ungültige ÄK/GW"
-   Rand- bzw. Extremwerte =\> GW
-   Exceptions

=\> Anforderungen abgedeckt (Black-Box)?

=\> Wichtige Pfade im Code abgedeckt (White-Box)?

###### Praxis

-   Je kritischer eine Klasse/Methode/Artefakt ist, um so intensiver
    testen!
-   Suche nach Kompromissen: Testkosten vs. Kosten von Folgefehlern;
    beispielsweise kein Test generierter Methoden

=\> "Erzeugen" der Testfälle über die Äquivalenzklassenbildung und
Grenzwertanalyse (siehe nächste Folien). Mehr dann später im Wahlfach
"Softwarequalität" ...

##### Äquivalenzklassenbildung

Beispiel: Zu testende Methode mit Eingabewert *x*, der zw. 10 und 100
liegen soll

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/quality/images/aequivalenzklassen.png" width="30%" /></p>

-   Zerlegung der Definitionsbereiche in Äquivalenzklassen (ÄK):

    -   Disjunkte Teilmengen, wobei
    -   Werte *einer* ÄK führen zu *gleichartigem* Verhalten

-   Annahme: Eingabeparameter sind untereinander unabhängig

-   Unterscheidung gültige und ungültige ÄK

###### Bemerkungen

Hintergrund: Da die Werte einer ÄK zu gleichartigem Verhalten führen,
ist es egal, *welchen* Wert man aus einer ÄK für den Test nimmt.

Formal hat man *eine* ungültige ÄK (d.h. die Menge aller ungültigen
Werte). In der Programmierpraxis macht es aber einen Unterschied, ob es
sich um Werte unterhalb oder oberhalb des erlaubten Wertebereichs
handelt (Fallunterscheidung). Beispiel: Eine Funktion soll Werte
zwischen 10 und 100 verarbeiten. Dann sind alle Werte kleiner 10 oder
größer 100 mathematisch gesehen in der selben ÄK "ungültig". Praktisch
macht es aber Sinn, eine ungültige ÄK für "kleiner 10" und eine weitere
ungültige ÄK für "größer 100" zu betrachten ...

Traditionell betrachtet man nur die Eingabeparameter. Es kann aber Sinn
machen, auch die Ausgabeseite zu berücksichtigen (ist aber u.U. nur
schwierig zu realisieren).

###### Faustregeln bei der Bildung von ÄK

-   Falls eine Beschränkung einen Wertebereich spezifiziert: Aufteilung
    in eine gültige und zwei ungültige ÄK

    Beispiel: Eingabewert *x* soll zw. 10 und 100 liegen

    -   Gültige ÄK: $[10, 100]$
    -   Ungültige ÄKs: $x < 10$ und $100 < x$

-   Falls eine Beschränkung eine minimale und maximale Anzahl von Werten
    spezifiziert: Aufteilung in eine gültige und zwei ungültige ÄK

    Beispiel: Jeder Studi muss pro Semester an mindestens einer LV
    teilnehmen, maximal sind 5 LVs erlaubt.

    -   Gültige ÄK: $1 \le x \le 5$
    -   Ungültige ÄKs: $x = 0$ (keine Teilnahme) und $5 < x$ (mehr als 5
        Kurse)

-   Falls eine Beschränkung eine Menge von Werten spezifiziert, die
    möglicherweise unterschiedlich behandelt werden: Für jeden Wert
    dieser Menge eine eigene gültige ÄK erstellen und zusätzlich
    insgesamt eine ungültige ÄK

    Beispiel: Das Hotel am Urlaubsort ermöglicht verschiedene
    Freizeitaktivitäten: Segway-fahren, Tauchen, Tennis, Golf

    -   Gültige ÄKs:
        -   Segway-fahren
        -   Tauchen
        -   Tennis
        -   Golf
    -   Ungültige ÄK: "alles andere"

-   Falls eine Beschränkung eine Situation spezifiziert, die zwingend
    erfüllt sein muss: Aufteilung in eine gültige und eine ungültige ÄK

*Hinweis*: Werden Werte einer ÄK vermutlich nicht gleichwertig
behandelt, dann erfolgt die Aufspaltung der ÄK in kleinere ÄKs. Das ist
im Grunde die analoge Überlegung zu mehreren ungültigen ÄKs.

ÄKs sollten für die weitere Arbeit einheitlich und eindeutig benannt
werden. Typisches Namensschema: "gÄKn" und "uÄKn" für gültige bzw.
ungültige ÄKs mit der laufenden Nummer $n$.

##### ÄK: Erstellung der Testfälle

-   Jede ÄK durch *mindestens* **einen TF** abdecken

<!-- -->

-   Dabei pro Testfall
    -   *mehrere gültige ÄKs* kombinieren, oder
    -   genau *eine ungültige ÄK* untersuchen (restl. Werte aus gültigen
        ÄK auffüllen; diese gelten dann aber nicht als getestet!)

Im Prinzip muss man zur Erstellung der Testfälle (TF) eine paarweise
vollständige Kombination über die ÄK bilden, d.h. jede ÄK kommt mit
jeder anderen ÄK in einem TF zur Ausführung.

*Erinnerung*: Annahme: Eingabeparameter sind untereinander unabhängig!
=\> Es reicht, wenn *jede* gültige ÄK *einmal* in einem TF zur
Ausführung kommt. =\> Kombination verschiedener gültiger ÄK in *einem
TF*.

**Achtung**: Dies gilt nur für die **gültigen** ÄK! Bei den ungültigen
ÄKs dürfen diese nicht miteinander in einem TF kombiniert werden! Bei
gleichzeitiger Behandlung verschiedener ungültiger ÄK bleiben u.U.
Fehler unentdeckt, da sich die Wirkungen der ungültigen ÄK überlagern!

**Für jeden Testfall (TF) wird aus den zu kombinierenden ÄK ein
zufälliger Repräsentant ausgewählt.**

##### ÄK: Beispiel: Eingabewert *x* soll zw. 10 und 100 liegen

###### Äquivalenzklassen

| Eingabe | gültige ÄK        | ungültige ÄK    |
|:--------|:------------------|:----------------|
| *x*     | gÄK1: $[10, 100]$ | uÄK2: $x < 10$  |
|         |                   | uÄK3: $100 < x$ |

###### Tests

| Testnummer          | 1    | 2         | 3         |
|:--------------------|:-----|:----------|:----------|
| geprüfte ÄK         | gÄK1 | uÄK2      | uÄK3      |
| *x*                 | 42   | 7         | 120       |
| Erwartetes Ergebnis | OK   | Exception | Exception |

##### Grenzwertanalyse

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/quality/images/grenzwerte.png" width="30%" /></p>

Beobachtung: Grenzen in Verzweigungen/Schleifen kritisch

-   Grenzen der ÄK (kleinste und größte Werte) **zusätzlich** testen
    -   "gültige Grenzwerte" (*gGW*): Grenzwerte von gültigen ÄK
    -   "ungültige Grenzwerte" (*uGW*): Grenzwerte von ungültigen ÄK

Zusätzlich sinnvoll: Weitere grenznahe Werte, d.h. weitere Werte
"rechts" und "links" der Grenze nutzen.

Bildung der Testfälle:

-   Jeder GW muss in mind. einem TF vorkommen

**Pro TF darf ein GW (gültig oder ungültig) verwendet werden, die
restlichen Parameter werden (mit zufälligen Werten) aus gültigen ÄK
aufgefüllt, um mögliche Grenzwertprobleme nicht zu überlagern.**

##### GW: Beispiel: Eingabewert *x* soll zw. 10 und 100 liegen

###### Äquivalenzklassen

| Eingabe | gültige ÄK        | ungültige ÄK    |
|:--------|:------------------|:----------------|
| *x*     | gÄK1: $[10, 100]$ | uÄK2: $x < 10$  |
|         |                   | uÄK3: $100 < x$ |

###### Grenzwertanalyse

Zusätzliche Testdaten: 9 (uÄK2o) und 10 (gÄK1u) sowie 100 (gÄK1o) und
101 (uÄK3u)

###### Tests

| Testnummer          | 4     | 5     | 6         | 7         |
|:--------------------|:------|:------|:----------|:----------|
| geprüfter GW        | gÄK1u | gÄK1o | uÄK2o     | uÄK3u     |
| *x*                 | 10    | 100   | 9         | 101       |
| Erwartetes Ergebnis | OK    | OK    | Exception | Exception |

**Hinweis**: Die Ergebnisse der GW-Analyse werden **zusätzlich** zu den
Werten aus der ÄK-Analyse eingesetzt. Für das obige Beispiel würde man
also folgende Tests aus der kombinierten ÄK- und GW-Analyse erhalten:

| Testnummer          | 1    | 2         | 3         | 4     | 5     | 6         | 7         |
|:--------------|:-----|:---------|:---------|:------|:------|:---------|:---------|
| geprüfte(r) ÄK/GW   | gÄK1 | uÄK2      | uÄK3      | gÄK1u | gÄK1o | uÄK2o     | uÄK3u     |
| *x*                 | 42   | 7         | 120       | 10    | 100   | 9         | 101       |
| Erwartetes Ergebnis | OK   | Exception | Exception | OK    | OK    | Exception | Exception |

##### Anmerkung: Analyse abhängiger Parameter

Wenn das Ergebnis von der Kombination der Eingabewerte abhängt, dann
sollte man dies bei der Äquivalenzklassenbildung berücksichtigen: Die ÄK
sind in diesem Fall in Bezug auf die Kombinationen zu bilden!

Schauen Sie sich dazu das Beispiel im Kleuker
([2019](#ref-Kleuker2019)), Abschnitt "4.3 Analyse abhängiger Parameter"
an.

Die einfache ÄK-Bildung würde in diesem Fall versagen, da die
Eingabewerte nicht unabhängig sind. Leider ist die Betrachtung der
möglichen Kombinationen u.U. eine sehr komplexe Aufgabe ...

Analoge Überlegungen gelten auch für die ÄK-Bildung im Zusammenhang mit
objektorientierter Programmierung. Die Eingabewerte und der
Objektzustand müssen dann *gemeinsam* bei der ÄK-Bildung betrachtet
werden!

Vergleiche Kleuker ([2019](#ref-Kleuker2019)), Abschnitt "4.4
Äquivalenzklassen und Objektorientierung".

##### Wrap-Up

-   Gründliches Testen ist ebenso viel Aufwand wie Coden
-   Äquivalenzklassenbildung und Grenzwertanalyse

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   <span class="nocase">vogella GmbH</span>
>     ([2021](#ref-vogellaJUnit))
> -   The JUnit Team ([2022](#ref-junit4))
> -   Kleuker ([2019](#ref-Kleuker2019))
> -   Osherove ([2014](#ref-Osherove2014))
> -   Spillner und Linz ([2012](#ref-Spillner2012))
> -   Thies u. a. ([o. J.](#ref-fernunihagenJunit))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kann Merkmale schlecht testbaren Codes erklären
> -   k2: Ich kann Merkmale guter Unit-Tests erklären
> -   k3: Ich kann Testfällen mittels Äquivalenzklassenbildung und
>     Grenzwertanalyse erstellen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **ÄK/GW: RSV Flotte Speiche**
>
> Der RSV Flotte Speiche hat in seiner Mitgliederverwaltung
> (`MitgliederVerwaltung`) die Methode `testBeitritt` implementiert. Mit
> dieser Methode wird geprüft, ob neue Mitglieder in den Radsportverein
> aufgenommen werden können.
>
> ``` java
> public class MitgliederVerwaltung {
>
>     /**
>      * Testet, ob ein Mitglied in den Verein aufgenommen werden kann.
>      *
>      * <p>Interessierte Personen müssen mindestens 16 Jahre alt sein, um aufgenommen
>      * werden zu können. Die Motivation darf nicht zu niedrig und auch nicht zu hoch
>      * sein und muss zwischen 4 und 7 (inklusive) liegen, sonst wird der Antrag
>      * abgelehnt.
>      *
>      * <p>Der Wertebereich beim Alter umfasst die natürlichen Zahlen zwischen 0 und 99
>      * (inklusive), bei der Motivation sind die natürlichen Zahlen zwischen 0 und 10
>      * (inklusive) erlaubt.
>      *
>      * <p>Bei Verletzung der zulässigen Wertebereiche der Parameter wird eine
>      * <code>IllegalArgumentException</code> geworfen.
>      *
>      * @param alter       Alter in Lebensjahren, Bereich [0, 99]
>      * @param motivation  Motivation auf einer Scala von 0 bis 10
>      * @return <code>true</code>, wenn das Mitglied aufgenommen werden kann,
>      *         sonst <code>false</code>
>      * @throws <code>IllegalArgumentException</code>, wenn Parameter außerhalb
>      *                                                der zulässigen Wertebereiche
>      */
>     public boolean testBeitritt(int alter, int motivation) {
>         // Implementierung versteckt
>     }
> }
> ```
>
> 1.  Führen Sie eine Äquivalenzklassenbildung durch und geben Sie die
>     gefundenen Äquivalenzklassen (*ÄK*) an: laufende Nummer,
>     Definition (Wertebereiche o.ä.), kurze Beschreibung
>     (gültige/ungültige ÄK, Bedeutung).
>
> 2.  Führen Sie zusätzlich eine Grenzwertanalyse durch und geben Sie
>     die jeweiligen Grenzwerte (*GW*) an.
>
> 3.  Erstellen Sie aus den ÄK und GW wie in der Vorlesung diskutiert
>     Testfälle. Geben Sie pro Testfall (*TF*) an, welche ÄK und/oder GW
>     abgedeckt sind, welche Eingaben Sie vorsehen und welche Ausgabe
>     Sie erwarten.
>
>     *Hinweis*: Erstellen Sie separate (zusätzliche) TF für die GW,
>     d.h. integrieren Sie diese *nicht* in die ÄK-TF.
>
> 4.  Implementieren Sie die Testfälle in JUnit (JUnit 4 oder 5).
>
>     -   Fassen Sie die Testfälle der gültigen ÄK in einem
>         parametrisierten Test zusammen.
>     -   Für die ungültigen ÄKs erstellen Sie jeweils eine eigene
>         JUnit-Testmethode. Beachten Sie, dass Sie auch die Exceptions
>         testen müssen.
>
> **ÄK/GW: LSF**
>
> Das LSF bestimmt mit der Methode `LSF#checkStudentCPS`, ob ein
> Studierender bereits zur Bachelorarbeit oder Praxisphase zugelassen
> werden kann:
>
> ``` java
> class LSF {
>     public static Status checkStudentCPS(Student student) {
>         if (student.credits() >= Status.BACHELOR.credits) return Status.BACHELOR;
>         else if (student.credits() >= Status.PRAXIS.credits) return Status.PRAXIS;
>         else return Status.NONE;
>     }
> }
>
> record Student(String name, int credits, int semester) { }
>
> enum Status {
>     NONE(0), PRAXIS(110), BACHELOR(190);  // min: 0, max: 210
>
>     public final int credits;
>     Status(int credits) { this.credits = credits; }
> }
> ```
>
> 1.  Führen Sie eine Äquivalenzklassenbildung für die Methode
>     `LSF#checkStudentCPS` durch.
> 2.  Führen Sie zusätzlich eine Grenzwertanalyse für die Methode
>     `LSF#checkStudentCPS` durch.
> 3.  Erstellen Sie aus den ÄK und GW wie in der Vorlesung diskutiert
>     Testfälle.
> 4.  Implementieren Sie die Testfälle in JUnit (JUnit 4 oder 5).
>     -   Fassen Sie die Testfälle der gültigen ÄK in einem
>         parametrisierten Test zusammen.
>     -   Für die ungültigen ÄKs erstellen Sie jeweils eine eigene
>         JUnit-Testmethode. Beachten Sie, dass Sie auch die Exceptions
>         testen müssen.
>
> </details>

<a id="id-ca381288eacf7fbdad309dee947ebee25635af6d"></a>

#### Mocking mit Mockito

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Häufig hat man es in Softwaretests mit dem Problem zu tun, dass die zu
> testenden Klassen von anderen, noch nicht implementierten Klassen oder
> von zufälligen oder langsamen Operationen abhängen.
>
> In solchen Situationen kann man auf "Platzhalter" für diese
> Abhängigkeiten zurückgreifen. Dies können einfache Stubs sein, also
> Objekte, die einfach einen festen Wert bei einem Methodenaufruf
> zurückliefern oder Mocks, wo man auf die Argumente eines
> Methodenaufrufs reagieren kann und passende unterschiedliche
> Rückgabewerte zurückgeben kann.
>
> Mockito ist eine Java-Bibliothek, die zusammen mit JUnit das Mocking
> von Klassen in Java erlaubt. Man kann hier zusätzlich auch die
> Interaktion mit dem gemockten Objekt überprüfen und testen, ob eine
> bestimmte Methode mit bestimmten Argumenten aufgerufen wurde und wie
> oft.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Mocking](https://youtu.be/8deFZKtjXSk)
> -   [Demo Mocking: Stubs](https://youtu.be/WNEedC7PrVQ)
> -   [Demo Mocking: Mocks](https://youtu.be/avUyYVePFCI)
> -   [Demo Mocking: Spy](https://youtu.be/dj3pmOZfS_A)
> -   [Demo Mocking: verify()](https://youtu.be/CPGqhyC8BjU)
> -   [Demo Mocking: Matcher](https://youtu.be/JNouzOd0s-w)
>
> </details>

##### Motivation: Entwicklung einer Studi-/Prüfungsverwaltung

###### Szenario

Zwei Teams entwickeln eine neue Studi-/Prüfungsverwaltung für die
Hochschule. Ein Team modelliert dabei die Studierenden, ein anderes Team
modelliert die Prüfungsverwaltung LSF.

-   Team A:

    ``` java
    public class Studi {
        String name;  LSF lsf;

        public Studi(String name, LSF lsf) {
            this.name = name;  this.lsf = lsf;
        }

        public boolean anmelden(String modul) { return lsf.anmelden(name, modul); }
        public boolean einsicht(String modul) { return lsf.ergebnis(name, modul) > 50; }
    }
    ```

-   Team B:

    ``` java
    public class LSF {
        public boolean anmelden(String name, String modul) { throw new UnsupportedOperationException(); }
        public int ergebnis(String name, String modul) { throw new UnsupportedOperationException(); }
    }
    ```

Team B kommt nicht so recht vorwärts, Team A ist fertig und will schon
testen.

Wie kann Team A seinen Code testen?

**Optionen**:

-   Gar nicht testen?!
-   Das LSF selbst implementieren? Wer pflegt das dann? =\> manuell
    implementierte Stubs
-   Das LSF durch einen Mock ersetzen =\> Einsatz der Bibliothek
    "mockito"

###### Motivation Mocking und Mockito

[Mockito](https://github.com/mockito/mockito) ist ein Mocking-Framework
für JUnit. Es simuliert das Verhalten eines realen Objektes oder einer
realen Methode.

Wofür brauchen wir denn jetzt so ein Mocking-Framework überhaupt?

Wir wollen die Funktionalität einer Klasse isoliert vom Rest testen
können. Dabei stören uns aber bisher so ein paar Dinge:

-   Arbeiten mit den echten Objekten ist langsam (zum Beispiel aufgrund
    von Datenbankenzugriffen)
-   Objekte beinhalten oft komplexe Abhängigkeiten, die in Tests schwer
    abzudecken sind
-   Manchmal existiert der zu testende Teil einer Applikation auch noch
    gar nicht, sondern es gibt nur die Interfaces.
-   Oder es gibt unschöne Seiteneffekte beim Arbeiten mit den realen
    Objekten. Zum Beispiel könnte es sein, das immer eine E-Mail
    versendet wird, wenn wir mit einem Objekt interagieren.

In solchen Situationen wollen wir eine Möglichkeit haben, das Verhalten
eines realen Objektes bzw. der Methoden zu simulieren, ohne dabei die
originalen Methoden aufrufen zu müssen. (Manchmal möchte man das
dennoch, aber dazu später mehr...)

Und genau hier kommt Mockito ins Spiel. Mockito hilft uns dabei, uns von
den externen Abhängigkeiten zu lösen, indem es sogenannte Mocks, Stubs
oder Spies anbietet, mit denen sich das Verhalten der realen Objekte
simulieren/überwachen und testen lässt.

###### Aber was genau ist denn jetzt eigentlich Mocking?

Ein Mock-Objekt ("etwas vortäuschen") ist im Software-Test ein Objekt,
das als Platzhalter (Attrappe) für das echte Objekt verwendet wird.

Mocks sind in JUnit-Tests immer dann nützlich, wenn man externe
Abhängigkeiten hat, auf die der eigene Code zugreift. Das können zum
Beispiel externe APIs sein oder Datenbanken etc. ... Mocks helfen einem
beim Testen nun dabei, sich von diesen externen Abhängigkeiten zu lösen
und seine Softwarefunktionalität dennoch schnell und effizient testen zu
können ohne evtl. auftretende Verbindungsfehler oder andere mögliche
Seiteneffekte der externen Abhängigkeiten auszulösen.

Dabei simulieren Mocks die Funktionalität der externen APIs oder
Datenbankzugriffe. Auf diese Weise ist es möglich Softwaretests zu
schreiben, die scheinbar die gleichen Methoden aufrufen, die sie auch im
regulären Softwarebetrieb nutzen würden, allerdings werden diese wie
oben erwähnt allerdings für die Tests nur simuliert.

Mocking ist also eine Technik, die in Softwaretests verwendet wird, in
denen die gemockten Objekte anstatt der realen Objekte zu Testzwecken
genutzt werden. Die gemockten Objekte liefern dabei bei einem vom
Programmierer bestimmten (Dummy-) Input, einen dazu passenden
gelieferten (Dummy-) Output, der durch seine vorhersagbare
Funktionalität dann in den eigentlichen Testobjekten gut für den Test
nutzbar ist.

Dabei ist es von Vorteil die drei Grundbegriffe "Mock", "Stub" oder
"Spy", auf die wir in der Vorlesung noch häufiger treffen werden,
voneinander abgrenzen und unterscheiden zu können.

###### Dabei bezeichnet ein

-   **Stub**: Ein Stub ist ein Objekt, dessen Methoden nur mit einer
    minimalen Logik für den Test implementiert wurden. Häufig werden
    dabei einfach feste (konstante) Werte zurückgeliefert, d.h. beim
    Aufruf einer Methode wird unabhängig von der konkreten Eingabe immer
    die selbe Ausgabe zurückgeliefert.
-   **Mock**: Ein Mock ist ein Objekt, welches im Gegensatz zum Stub bei
    vorher definierten Funktionsaufrufen mit vorher definierten
    Argumente eine definierte Rückgabe liefert.
-   **Spy**: Ein Spy ist ein Objekt, welches Aufrufe und übergebene
    Werte protokolliert und abfragbar macht. Es ist also eine Art
    Wrapper um einen Stub oder einen Mock.

###### Mockito Setup

-   Gradle: `build.gradle`

    ``` groovy
    dependencies {
        implementation 'junit:junit:4.13.2'
        implementation 'org.mockito:mockito-core:4.5.1'
    }
    ```

-   Maven: `pom.xml`

    ``` xml
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
        </dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>4.5.1</version>
        </dependency>
    </dependencies>
    ```

##### Manuell Stubs implementieren

Team A könnte manuell das LSF rudimentär implementieren (nur für die
Tests, einfach mit festen Rückgabewerten): **Stubs**

``` java
public class StudiStubTest {
    Studi studi;  LSF lsf;

    @Before
    public void setUp() { lsf = new LsfStub();  studi = new Studi("Harald", lsf); }

    @Test
    public void testAnmelden() { assertTrue(studi.anmelden("PM-Dungeon")); }
    @Test
    public void testEinsicht() { assertTrue(studi.einsicht("PM-Dungeon")); }


    // Stub für das noch nicht fertige LSF
    class LsfStub extends LSF {
        public boolean anmelden(String name, String modul) { return true; }
        public int ergebnis(String name, String modul) { return 80; }
    }
}
```

**Problem**: Wartung der Tests (wenn das richtige LSF fertig ist) und
Wartung der Stubs (wenn sich die Schnittstelle des LSF ändert, muss auch
der Stub nachgezogen werden).

**Problem**: Der Stub hat nur eine Art minimale Default-Logik (sonst
könnte man ja das LSF gleich selbst implementieren). Wenn man im Test
andere Antworten braucht, müsste man einen weiteren Stub anlegen ...

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/quality/src/mockito/src/test/java/hsbi/StudiStubTest.java">Demo hsbi.StudiStubTest</a></p>

##### Mockito: Mocking von ganzen Klassen

**Lösung**: Mocking der Klasse `LSF` mit Mockito für den Test von
`Studi`: `mock()`.

``` java
public class StudiMockTest {
    Studi studi;  LSF lsf;

    @Before
    public void setUp() { lsf = mock(LSF.class);  studi = new Studi("Harald", lsf); }

    @Test
    public void testAnmelden() {
        when(lsf.anmelden(anyString(), anyString())).thenReturn(true);
        assertTrue(studi.anmelden("PM-Dungeon"));
    }

    @Test
    public void testEinsichtI() {
        when(lsf.ergebnis("Harald", "PM-Dungeon")).thenReturn(80);
        assertTrue(studi.einsicht("PM-Dungeon"));
    }
    @Test
    public void testEinsichtII() {
        when(lsf.ergebnis("Harald", "PM-Dungeon")).thenReturn(40);
        assertFalse(studi.einsicht("PM-Dungeon"));
    }
}
```

Der Aufruf `mock(LSF.class)` erzeugt einen Mock der Klasse (oder des
Interfaces) `LSF`. Dabei wird ein Objekt vom Typ `LSF` erzeugt, mit dem
man dann wie mit einem normalen Objekt weiter arbeiten kann. Die
Methoden sind allerdings nicht implementiert ...

Mit Hilfe von `when().thenReturn()` kann man definieren, was genau beim
Aufruf einer bestimmten Methode auf dem Mock passieren soll, d.h.
welcher Rückgabewert entsprechend zurückgegeben werden soll. Hier kann
man dann für bestimmte Argumentwerte andere Rückgabewerte definieren.
`when(lsf.ergebnis("Harald", "PM-Dungeon")).thenReturn(80)` gibt also
für den Aufruf von `ergebnis` mit den Argumenten `"Harald"` und
`"PM-Dungeon"` auf dem Mock `lsf` den Wert 80 zurück.

Dies kann man in weiten Grenzen flexibel anpassen.

Mit Hilfe der Argument-Matcher `anyString()` wird jedes String-Argument
akzeptiert.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/quality/src/mockito/src/test/java/hsbi/StudiMockTest.java">Demo hsbi.StudiMockTest</a></p>

##### Mockito: Spy = Wrapper um ein Objekt

Team B hat das `LSF` nun implementiert und Team A kann es endlich für
die Tests benutzen. Aber das `LSF` hat eine Zufallskomponente
(`ergebnis()`). Wie kann man nun die Reaktion des Studis testen
(`einsicht()`)?

**Lösung**: Mockito-Spy als partieller Mock einer Klasse (Wrapper um ein
Objekt): `spy()`.

``` java
public class StudiSpyTest {
    Studi studi;  LSF lsf;

    @Before
    public void setUp() { lsf = spy(LSF.class);  studi = new Studi("Harald", lsf); }

    @Test
    public void testAnmelden() { assertTrue(studi.anmelden("PM-Dungeon")); }

    @Test
    public void testEinsichtI() {
        doReturn(80).when(lsf).ergebnis("Harald", "PM-Dungeon");
        assertTrue(studi.einsicht("PM-Dungeon"));
    }
    @Test
    public void testEinsichtII() {
        doReturn(40).when(lsf).ergebnis("Harald", "PM-Dungeon");
        assertFalse(studi.einsicht("PM-Dungeon"));
    }
}
```

Der Aufruf `spy(LSF.class)` erzeugt einen Spy um ein Objekt der Klasse
`LSF`. Dabei bleiben zunächst die Methoden in `LSF` erhalten und können
aufgerufen werden, sie können aber auch mit einem (partiellen) Mock
überlagert werden. Der Spy zeichnet wie der Mock die Interaktion mit dem
Objekt auf.

Mit Hilfe von `doReturn().when()` kann man definieren, was genau beim
Aufruf einer bestimmten Methode auf dem Spy passieren soll, d.h. welcher
Rückgabewert entsprechend zurückgegeben werden soll. Hier kann man
analog zum Mock für bestimmte Argumentwerte andere Rückgabewerte
definieren. `doReturn(40).when(lsf).ergebnis("Harald", "PM-Dungeon")`
gibt also für den Aufruf von `ergebnis` mit den Argumenten `"Harald"`
und `"PM-Dungeon"` auf dem Spy `lsf` den Wert 40 zurück.

Wenn man die Methoden nicht mit einem partiellen Mock überschreibt, dann
wird einfach die originale Methode aufgerufen (Beispiel: In
`studi.anmelden("PM-Dungeon")` wird
`lsf.anmelden("Harald", "PM-Dungeon")` aufgerufen.).

Auch hier können Argument-Matcher wie `anyString()` eingesetzt werden.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/quality/src/mockito/src/test/java/hsbi/StudiSpyTest.java">Demo hsbi.StudiSpyTest</a></p>

##### Wurde eine Methode aufgerufen?

``` java
public class VerifyTest {
    @Test
    public void testAnmelden() {
        LSF lsf = mock(LSF.class);  Studi studi = new Studi("Harald", lsf);

        when(lsf.anmelden("Harald", "PM-Dungeon")).thenReturn(true);

        assertTrue(studi.anmelden("PM-Dungeon"));


        verify(lsf).anmelden("Harald", "PM-Dungeon");
        verify(lsf, times(1)).anmelden("Harald", "PM-Dungeon");

        verify(lsf, atLeast(1)).anmelden("Harald", "PM-Dungeon");
        verify(lsf, atMost(1)).anmelden("Harald", "PM-Dungeon");

        verify(lsf, never()).ergebnis("Harald", "PM-Dungeon");

        verifyNoMoreInteractions(lsf);
    }
}
```

Mit der Methode `verify()` kann auf einem Mock oder Spy überprüft
werden, ob und wie oft und in welcher Reihenfolge Methoden aufgerufen
wurden und mit welchen Argumenten. Auch hier lassen sich wieder
Argument-Matcher wie `anyString()` einsetzen.

Ein einfaches `verify(mock)` prüft dabei, ob die entsprechende Methode
exakt einmal vorher aufgerufen wurde. Dies ist äquivalent zu
`verify(mock, times(1))`. Analog kann man mit den Parametern `atLeast()`
oder `atMost` bestimmte Unter- oder Obergrenzen für die Aufrufe angeben
und mit `never()` prüfen, ob es gar keinen Aufruf vorher gab.

`verifyNoMoreInteractions(lsf)` ist interessant: Es ist genau dann
`true`, wenn es außer den vorher abgefragten Interaktionen keinerlei
sonstigen Interaktionen mit dem Mock oder Spy gab.

``` java
LSF lsf = mock(LSF.class);
Studi studi = new Studi("Harald", lsf);

when(lsf.anmelden("Harald", "PM-Dungeon")).thenReturn(true);

InOrder inOrder = inOrder(lsf);

assertTrue(studi.anmelden("PM-Dungeon"));
studi.anmelden("Wuppie");

inOrder.verify(lsf).anmelden("Harald", "Wuppie");
inOrder.verify(lsf).anmelden("Harald", "PM-Dungeon");
```

Mit `InOrder` lassen sich Aufrufe auf einem Mock/Spy oder auch auf
verschiedenen Mocks/Spies in eine zeitliche Reihenfolge bringen und so
überprüfen.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/quality/src/mockito/src/test/java/hsbi/VerifyTest.java">Demo hsbi.VerifyTest</a></p>

##### Fangen von Argumenten

``` java
public class MatcherTest {
    @Test
    public void testAnmelden() {
        LSF lsf = mock(LSF.class);  Studi studi = new Studi("Harald", lsf);

        when(lsf.anmelden(anyString(), anyString())).thenReturn(false);
        when(lsf.anmelden("Harald", "PM-Dungeon")).thenReturn(true);

        assertTrue(studi.anmelden("PM-Dungeon"));
        assertFalse(studi.anmelden("Wuppie?"));

        verify(lsf, times(1)).anmelden("Harald", "PM-Dungeon");
        verify(lsf, times(1)).anmelden("Harald", "Wuppie?");

        verify(lsf, times(2)).anmelden(anyString(), anyString());
        verify(lsf, times(1)).anmelden(eq("Harald"), eq("Wuppie?"));
        verify(lsf, times(2)).anmelden(argThat(new MyHaraldMatcher()), anyString());
    }


    class MyHaraldMatcher implements ArgumentMatcher<String> {
        public boolean matches(String s) { return s.equals("Harald"); }
    }
}
```

Sie können die konkreten Argumente angeben, für die der Aufruf gelten
soll. Alternativ können Sie mit vordefinierten `ArgumentMatchers` wie
`anyString()` beispielsweise auf beliebige Strings reagieren oder selbst
einen eigenen `ArgumentMatcher<T>` für Ihren Typ `T` erstellen und
nutzen.

**Wichtig**: Wenn Sie für einen Parameter einen `ArgumentMatcher`
einsetzen, müssen Sie für die restlichen Parameter der Methode dies
ebenfalls tun. Sie können keine konkreten Argumente mit
`ArgumentMatcher` mischen.

Sie finden viele weitere vordefinierte Matcher in der Klasse
`ArgumentMatchers`. Mit der Klasse `ArgumentCaptor<T>` finden Sie eine
alternative Möglichkeit, auf Argumente in gemockten Methoden zu
reagieren. Schauen Sie sich dazu die Javadoc von
[Mockito](https://javadoc.io/doc/org.mockito/mockito-core/) an.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/quality/src/mockito/src/test/java/hsbi/MatcherTest.java">Demo hsbi.MatcherTest</a></p>

##### Ausblick: PowerMock

Mockito sehr mächtig, aber unterstützt (u.a.) keine

-   Konstruktoren
-   private Methoden
-   final Methoden
-   static Methoden (ab Version 3.4.0 scheint auch [Mockito statische
    Methoden](https://www.baeldung.com/mockito-mock-static-methods) zu
    unterstützen)

=\> Lösung: [PowerMock](https://github.com/powermock/powermock)

##### Ausführlicheres Beispiel: WuppiWarenlager

**Credits**: Der Dank für die Erstellung des nachfolgenden Beispiels und
Textes geht an [@jedi101](https://github.com/jedi101).

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/mockito/src/test/java/wuppie/stub/">Demo: WuppiWarenlager (wuppie.stub)</a></p>

Bei dem gezeigten Beispiel unseres `WuppiStores` sieht man, dass dieser
normalerweise von einem fertigen Warenlager die Wuppis beziehen möchte.
Da dieses Lager aber noch nicht existiert, haben wir uns kurzerhand
einfach einen Stub von unserem `IWuppiWarenlager`-Interface erstellt, in
dem wir zu Testzwecken händisch ein Paar Wuppis ins Lager geräumt haben.

Das funktioniert in diesem Mini-Testbeispiel ganz gut aber, wenn unsere
Stores erst einmal so richtig Fahrt aufnehmen und wir irgendwann
weltweit Wuppis verkaufen, wird der Code des `IWuppiWarenlagers`
wahrscheinlich sehr schnell viel komplexer werden, was unweigerlich dann
zu Maintenance-Problemen unserer händisch angelegten Tests führt. Wenn
wir zum Beispiel einmal eine Methode hinzufügen wollen, die es uns
ermöglicht, nicht immer alle Wuppis aus dem Lager zu ordern oder
vielleicht noch andere Methoden, die Fluppis orderbar machen,
hinzufügen, müssen wir immer dafür sorgen, dass wir die getätigten
Änderungen händisch in den Stub des Warenlagers einpflegen.

Das will eigentlich niemand...

###### Einsatz von Mockito

Aber es gibt da einen Ausweg. Wenn es komplexer wird, verwenden wir
Mocks.

Bislang haben wir noch keinen Gebrauch von Mockito gemacht. Das ändern
wir nun.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/mockito/src/test/java/wuppie/mock/">Demo: WuppiWarenlager (wuppie.mock)</a></p>

Wie in diesem Beispiel gezeigt, müssen wir nun keinen Stub mehr von Hand
erstellen, sondern überlassen dies Mockito.

``` java
IWuppiWarenlager lager = mock(IWuppiWarenlager.class);
```

Anschließend können wir, ohne die Methode `getAllWuppis()` implementiert
zu haben, dennoch so tun als, ob die Methode eine Funktionalität hätte.

``` java
// Erstellen eines imaginären Lagerbestands.
List<String> wuppisImLager = Arrays.asList("GruenerWuppi","RoterWuppi");
when(lager.getAlleWuppis()).thenReturn(wuppisImLager);
```

Wann immer nun die Methode `getAlleWuppis()` des gemockten Lagers
aufgerufen wird, wird dieser Aufruf von Mockito abgefangen und wie oben
definiert verändert. Das Ergebnis können wir abschließend einfach in
unserem Test testen:

``` java
// Erzeugen des WuppiStores.
WuppiStore wuppiStore = new WuppiStore(lager);

// Bestelle alle Wuppis aus dem gemockten Lager List<String>
bestellteWuppis = wuppiStore.bestelleAlleWuppis(lager);

// Hat die Bestellung geklappt?
assertEquals(2,bestellteWuppis.size());
```

###### Mockito Spies

Manchmal möchten wir allerdings nicht immer gleich ein ganzes Objekt
mocken, aber dennoch Einfluss auf die aufgerufenen Methoden eines
Objekts haben, um diese testen zu können. Vielleicht gibt es dabei ja
sogar eine Möglichkeit unsere JUnit-Tests, mit denen wir normalerweise
nur Rückgabewerte von Methoden testen können, zusätzlich auch das
Verhalten also die Interaktionen mit einem Objekt beobachtbar zu machen.
Somit wären diese Interaktionen auch testbar.

Und genau dafür bietet Mockito eine Funktion: der sogenannte "Spy".

Dieser Spion erlaubt es uns nun zusätzlich das Verhalten zu testen. Das
geht in die Richtung von [BDD - Behavior Driven
Development](https://de.wikipedia.org/wiki/Behavior_Driven_Development).

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/mockito/src/test/java/wuppie/spy/">Demo: WuppiWarenlager (wuppie.spy)</a></p>

``` java
// Spion erstellen, der unser wuppiWarenlager überwacht.
this.wuppiWarenlager = spy(WuppiWarenlager.class);
```

Hier hatten wir uns einen Spion erzeugt, mit dem sich anschließend das
Verhalten verändern lässt:

``` java
when(wuppiWarenlager.getAlleWuppis()).thenReturn(Arrays.asList(new Wuppi("Wuppi007")));
```

Aber auch der Zugriff lässt sich kontrollieren/testen:

``` java
verify(wuppiWarenlager).addWuppi(normalerWuppi);
verifyNoMoreInteractions(wuppiWarenlager);
```

Die normalen Testmöglichkeiten von JUnit runden unseren Test zudem ab.

``` java
assertEquals(1,wuppiWarenlager.lager.size());
```

##### Mockito und Annotationen

In Mockito können Sie wie oben gezeigt mit `mock()` und `spy()` neue
Mocks bzw. Spies erzeugen und mit `verify()` die Interaktion überprüfen
und mit `ArgumentMatcher<T>` bzw. den vordefinierten `ArgumentMatchers`
auf Argumente zuzugreifen bzw. darauf zu reagieren.

Zusätzlich/alternativ gibt es in Mockito zahlreiche Annotationen, die
**ersatzweise** statt der genannten Methoden genutzt werden können. Hier
ein kleiner Überblick über die wichtigsten in Mockito verwendeten
Annotation:

-   `@Mock` wird zum Markieren des zu mockenden Objekts verwendet.

    ``` java
    @Mock
    WuppiWarenlager lager;
    ```

-   `@RunWith(MockitoJUnitRunner.class)` ist der entsprechende
    JUnit-Runner, wenn Sie Mocks mit `@Mock` anlegen.

    ``` java
    @RunWith(MockitoJUnitRunner.class)
    public class ToDoBusinessMock {...}
    ```

-   `@Spy` erlaubt das Erstellen von partiell gemockten Objekten. Dabei
    wird eine Art Wrapper um das zu mockende Objekt gewickelt, der dafür
    sorgt, dass alle Methodenaufrufe des Objekts an den Spy delegiert
    werden. Diese können über den Spion dann abgefangen/verändert oder
    ausgewertet werden.

    ``` java
    @Spy
    ArrayList<Wuppi> arrayListenSpion;
    ```

-   `@InjectMocks` erlaubt es, Parameter zu markieren, in denen Mocks
    und/oder Spies injiziert werden. Mockito versucht dann (in dieser
    Reihenfolge) per Konstruktorinjektion, Setterinjektion oder
    Propertyinjektion die Mocks zu injizieren. Weitere Informationen
    darüber findet man hier: [Mockito
    Dokumentation](https://javadoc.io/static/org.mockito/mockito-core/4.5.1/org/mockito/InjectMocks.html)

    **Anmerkung**: Es ist aber nicht ratsam "Field- oder
    Setterinjection" zu nutzen, da man nur bei der Verwendung von
    "Constructorinjection" sicherstellen kann, das eine Klasse nicht
    ohne die eigentlich notwendigen Parameter instanziiert wurde.

    ``` java
    @InjectMocks
    Wuppi fluppi;
    ```

-   `@Captor` erlaubt es, die Argumente einer Methode
    abzufangen/auszuwerten. Im Zusammenspiel mit Mockitos
    `verify()`-Methode kann man somit auch die einer Methode übergebenen
    Argumente verifizieren.

    ``` java
    @Captor
    ArgumentCaptor<String> argumentCaptor;
    ```

-   `@ExtendWith(MockitoExtension.class)` wird in JUnit5 verwendet, um
    die Initialisierung von Mocks zu vereinfachen. Damit entfällt zum
    Beispiel die noch unter JUnit4 nötige Initialisierung der Mocks
    durch einen Aufruf der Methode `MockitoAnnotations.openMocks()` im
    Setup des Tests (`@Before` bzw. `@BeforeEach`).

###### Prüfen der Interaktion mit *verify()*

Mit Hilfe der umfangreichen `verify()`-Methoden, die uns Mockito
mitliefert, können wir unseren Code unter anderem auf unerwünschte
Seiteneffekte testen. So ist es mit `verify` zum Beispiel möglich
abzufragen, ob mit einem gemockten Objekt interagiert wurde, wie damit
interagiert wurde, welche Argumente dabei übergeben worden sind und in
welcher Reihenfolge die Interaktionen damit erfolgt sind.

Hier nur eine kurze Übersicht über das Testen des Codes mit Hilfe von
Mockitos `verify()`-Methoden.

``` java
@Test
public void testVerify_DasKeineInteraktionMitDerListeStattgefundenHat() {
    // Testet, ob die spezifizierte Interaktion mit der Liste nie stattgefunden hat.
    verify(fluppisListe, never()).clear();
}
```

``` java
@Test
public void testVerify_ReihenfolgeDerInteraktionenMitDerFluppisListe() {
    // Testet, ob die Reihenfolge der spezifizierten Interaktionen mit der Liste eingehalten wurde.
    fluppisListe.clear();
    InOrder reihenfolge = inOrder(fluppisListe);
    reihenfolge.verify(fluppisListe).add("Fluppi001");
    reihenfolge.verify(fluppisListe).clear();
}
```

``` java
@Test
public void testVerify_FlexibleArgumenteBeimZugriffAufFluppisListe() {
    // Testet, ob schon jemals etwas zu der Liste hinzugefügt wurde.
    // Dabei ist es egal welcher String eingegeben wurde.
    verify(fluppisListe).add(anyString());
}
```

``` java
@Test
public void testVerify_InteraktionenMitHilfeDesArgumentCaptor() {
    // Testet, welches Argument beim Methodenaufruf übergeben wurde.
    fluppisListe.addAll(Arrays.asList("BobDerBaumeister"));
    ArgumentCaptor<List> argumentMagnet = ArgumentCaptor.forClass(FluppisListe.class);
    verify(fluppisListe).addAll(argumentMagnet.capture());
    List<String> argumente = argumentMagnet.getValue();
    assertEquals("BobDerBaumeister", argumente.get(0));
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/mockito/src/test/java/wuppie/verify/">Demo: WuppiWarenlager (wuppie.verify)</a></p>

##### Wrap-Up

-   Gründliches Testen ist ebenso viel Aufwand wie Coden!

<!-- -->

-   Mockito ergänzt JUnit:
    -   Mocken ganzer Klassen (`mock()`, `when().thenReturn()`)
    -   Wrappen von Objekten (`spy()`, `doReturn().when()`)
    -   Auswerten, wie häufig Methoden aufgerufen wurden (`verify()`)
    -   Auswerten, mit welchen Argumenten Methoden aufgerufen wurden
        (`anyString`)

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kann die Begriffe: Mocking, Mock, Stub, Spy unterscheiden
>     und erklären
> -   k3: Ich kann Mocks in Mockito anlegen und nutzen
> -   k3: Ich kann Spies in Mockito anlegen und nutzen
> -   k3: Ich kann die Interaktion mit Mocks/Spies über verify() prüfen
> -   k3: Ich kann den ArgumentMatcher praktisch einsetzen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Betrachten Sie die drei Klassen `Utility.java`, `Evil.java` und
> `UtilityTest.java`:
>
> ``` java
> public class Utility {
>     private int intResult = 0;
>     private Evil evilClass;
>
>     public Utility(Evil evilClass) {
>         this.evilClass = evilClass;
>     }
>
>     public void evilMethod() {
>         int i = 2 / 0;
>     }
>
>     public int nonEvilAdd(int a, int b) {
>         return a + b;
>     }
>
>     public int evilAdd(int a, int b) {
>         evilClass.evilMethod();
>         return a + b;
>     }
>
>     public void veryEvilAdd(int a, int b) {
>         evilMethod();
>         evilClass.evilMethod();
>         intResult = a + b;
>     }
>
>     public int getIntResult() {
>         return intResult;
>     }
> }
>
> public class Evil {
>     public void evilMethod() {
>         int i = 3 / 0;
>     }
> }
>
> public class UtilityTest {
>     private Utility utilityClass;
>     // Initialisieren Sie die Attribute entsprechend vor jedem Test.
>
>     @Test
>     void test_nonEvilAdd() {
>         Assertions.assertEquals(10, utilityClass.nonEvilAdd(9, 1));
>     }
>
>     @Test
>     void test_evilAdd() {
>         Assertions.assertEquals(10, utilityClass.evilAdd(9, 1));
>     }
>
>     @Test
>     void test_veryEvilAdd() {
>         utilityClass.veryEvilAdd(9, 1);
>         Assertions.assertEquals(10, utilityClass.getIntResult());
>     }
> }
> ```
>
> Testen Sie die Methoden `nonEvilAdd`, `evilAdd` und `veryEvilAdd` der
> Klasse `Utility.java` mit dem [JUnit-](https://junit.org/) und dem
> [Mockito-Framework](https://github.com/mockito/mockito).
>
> Vervollständigen Sie dazu die Klasse `UtilityTest.java` und nutzen Sie
> Mocking mit [Mockito](https://github.com/mockito/mockito), um die
> Tests zum Laufen zu bringen. Die Tests dürfen Sie entsprechend
> verändern, aber die Aufrufe aus der Vorgabe müssen erhalten bleiben.
> Die Klassen `Evil.java` und `Utility.java` dürfen Sie nicht ändern.
>
> *Hinweis:* Die Klasse `Evil.java` und die Methode `evilMethod()` aus
> `Utility.java` lösen eine ungewollte bzw. "zufällige" Exception aus,
> auf deren Auftreten jedoch *nicht* getestet werden soll. Stattdessen
> sollen diese Klassen bzw. Methoden mit Mockito "weggemockt" werden, so
> dass die vorgegebenen Testmethoden (wieder) funktionieren.
>
> </details>

<a id="id-41be9b68119185a3c165c600670ba548b3bf2cfd"></a>

#### Code Smells

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Code entsteht nicht zum Selbstzweck, er muss von anderen Menschen
> leicht verstanden und gewartet werden können: Entwickler verbringen
> einen wesentlichen Teil ihrer Zeit mit dem **Lesen** von (fremdem)
> Code. Dabei helfen "Coding Conventions", die eine gewisse einheitliche
> äußerliche Erscheinung des Codes vorgeben (Namen, Einrückungen, ...).
> Die Beachtung von grundlegenden Programmierprinzipien hilft ebenso,
> die Lesbarkeit und Verständlichkeit zu verbessern.
>
> Code, der diese Konventionen und Regeln verletzt, zeigt sogenannte
> "**Code Smells**" oder "Bad Smells". Das sind Probleme im Code, die
> noch nicht direkt zu einem Fehler führen, die aber im Laufe der Zeit
> die Chance für echte Probleme deutlich erhöht.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Code Smells](https://youtu.be/ALDuLxm71tg)
>
> </details>

##### Code Smells: Ist das Code oder kann das weg?

``` java
class checker {
    static public void CheckANDDO(DATA1 inp, int c, FH.Studi
    CustD, int x, int y, int in, int out,int c1, int c2, int c3 = 4)
{
    public int i; // neues i
for(i=0;i<10;i++) // fuer alle i
{
        inp.kurs[0] = 10; inp.kurs[i] = CustD.cred[i]/c;
}
      SetDataToPlan(  CustD  );
    public double myI = in*2.5; // myI=in*2.5
    if (c1)
        out = myI; //OK
    else if(  c3 == 4  )
    {
        myI = c2 * myI;
    if (c3 != 4 || true ) { // unbedingt beachten!
        //System.out.println("x:"+(x++));
        System.out.println("x:"+(x++)); // x++
        System.out.println("out: "+out);
    } }}   }
```

Der Code im obigen Beispiel lässt sich möglicherweise kompilieren. Und
möglicherweise tut er sogar das, was er tun soll.

Dennoch: **Der Code "stinkt"** (zeigt **Code Smells**):

-   Nichtbeachtung üblicher Konventionen (Coding Rules)
-   Schlechte Kommentare
-   Auskommentierter Code
-   Fehlende Datenkapselung
-   Zweifelhafte Namen
-   Duplizierter Code
-   "Langer" Code: Lange Methoden, Klassen, Parameterlisten, tief
    verschachtelte `if/then`-Bedingungen, ...
-   Feature Neid
-   `switch/case` oder `if/else` statt Polymorphie
-   Globale Variablen, lokale Variablen als Attribut
-   Magic Numbers

Diese Liste enthält die häufigsten "Smells" und ließe sich noch beliebig
fortsetzen. Schauen Sie mal in die unten angegebene Literatur :-)

**Stinkender Code führt zu möglichen (späteren) Problemen.**

##### Was ist guter ("sauberer") Code ("Clean Code")?

Im Grunde bezeichnet "sauberer Code" ("Clean Code") die Abwesenheit von
Smells. D.h. man könnte Code als "sauberen" Code bezeichnen, wenn die
folgenden Eigenschaften erfüllt sind (keine vollständige Aufzählung!):

-   Gut ("angenehm") lesbar
-   Schnell verständlich: Geeignete Abstraktionen
-   Konzentriert sich auf **eine** Aufgabe
-   So einfach und direkt wie möglich
-   Ist gut getestet

In ([Martin 2009](#ref-Martin2009)) lässt der Autor Robert Martin
verschiedene Ikonen der SW-Entwicklung zu diesem Thema zu Wort kommen -
eine sehr lesenswerte Lektüre!

=\> Jemand kümmert sich um den Code; solides Handwerk

##### Warum ist guter ("sauberer") Code so wichtig?

> Any fool can write code that a computer can understand. Good
> programmers write code that humans can understand.
>
>  Quelle: "*Any fool...*": ([Fowler 2011](#ref-Fowler2011), p. 15)

Auch wenn das zunächst seltsam klingt, aber Code muss auch von Menschen
gelesen und verstanden werden können. Klar, der Code muss inhaltlich
korrekt sein und die jeweilige Aufgabe erfüllen, er muss kompilieren
etc. ... aber er muss auch von anderen Personen weiter entwickelt werden
und dazu gelesen und verstanden werden. Guter Code ist nicht einfach nur
inhaltlich korrekt, sondern kann auch einfach verstanden werden.

Code, der nicht einfach lesbar ist oder nur schwer verständlich ist,
wird oft in der Praxis später nicht gut gepflegt: Andere Entwickler
haben (die berechtigte) Angst, etwas kaputt zu machen und arbeiten "um
den Code herum". Nur leider wird das Konstrukt dann nur noch schwerer
verständlich ...

###### Code Smells

Verstöße gegen die Prinzipien von *Clean Code* nennt man auch *Code
Smells*: Der Code "stinkt" gewissermaßen. Dies bedeutet nicht unbedingt,
dass der Code nicht funktioniert (d.h. er kann dennoch compilieren und
die Anforderungen erfüllen). Er ist nur nicht sauber formuliert, schwer
verständlich, enthält Doppelungen etc., was im Laufe der Zeit die Chance
für tatsächliche Probleme deutlich erhöht.

Und weil es so wichtig ist, hier gleich noch einmal:

<div align="center">

**Stinkender Code führt zu möglichen (späteren) Problemen.**

</div>

###### "Broken Windows" Phänomen

Wenn ein Gebäude leer steht, wird es eine gewisse Zeit lang nur relativ
langsam verfallen: Die Fenster werden nicht mehr geputzt, es sammelt
sich Graffiti, Gras wächst in der Dachrinne, Putz blättert ab ...

Irgendwann wird dann eine Scheibe eingeworfen. Wenn dieser Punkt
überschritten ist, beschleunigt sich der Verfall rasant: Über Nacht
werden alle erreichbaren Scheiben eingeworfen, Türen werden zerstört, es
werden sogar Brände gelegt ...

Das passiert auch bei Software! Wenn man als Entwickler das Gefühl
bekommt, die Software ist nicht gepflegt, wird man selbst auch nur
relativ schlechte Arbeit abliefern. Sei es, weil man nicht versteht, was
der Code macht und sich nicht an die Überarbeitung der richtigen Stellen
traut und stattdessen die Änderungen als weiteren "Erker" einfach dran
pappt. Seit es, weil man keine Lust hat, Zeit in ordentliche Arbeit zu
investieren, weil der Code ja eh schon schlecht ist ... Das wird mit der
Zeit nicht besser ...

<p align="right"><a href="https://en.wikipedia.org/wiki/Broken_windows_theory">“Broken Windows” Phänomen</a></p>

###### Maßeinheit für Code-Qualität ;-)

Es gibt eine "praxisnahe" (und nicht ganz ernst gemeinte) Maßeinheit für
Code-Qualität: Die "WTF/m" (*What the Fuck per minute*): [Thom Holwerda:
www.osnews.com/story/19266/WTFs](https://www.osnews.com/story/19266/wtfsm/).

Wenn beim Code-Review durch Kollegen viele "WTF" kommen, ist der Code
offenbar nicht in Ordnung ...

##### Code Smells: Nichtbeachtung von Coding Conventions

-   Richtlinien für einheitliches Aussehen =\> Andere Programmierer
    sollen Code schnell lesen können
    -   Namen, Schreibweisen
    -   Kommentare (Ort, Form, Inhalt)
    -   Einrückungen und Spaces vs. Tabs
    -   Zeilenlängen, Leerzeilen
    -   Klammern

<!-- -->

-   Beispiele: [Sun Code
    Conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf),
    [Google Java
    Style](https://google.github.io/styleguide/javaguide.html)

<!-- -->

-   *Hinweis*: Betrifft vor allem die (äußere) Form!

##### Code Smells: Schlechte Kommentare I

-   Ratlose Kommentare

    ``` java
    /* k.A. was das bedeutet, aber wenn man es raus nimmt, geht's nicht mehr */
    /* TODO: was passiert hier, und warum? */
    ```

    Der Programmierer hat selbst nicht verstanden (und macht sich auch
    nicht die Mühe zu verstehen), was er da tut! Fehler sind
    vorprogrammiert!

<!-- -->

-   Redundante Kommentare:

    ``` java
    public int i; // neues i
    for(i=0;i<10;i++)
    // fuer alle i
    ```

    Was würden Sie Ihrem Kollegen erklären (müssen), wenn Sie ihm/ihr
    den Code vorstellen?

    Wiederholen Sie nicht, was der Code tut (das kann ich ja selbst
    lesen), sondern **beschreiben Sie, was der Code tun *sollte* und
    *warum***.

    Beschreiben Sie dabei auch das Konzept hinter einem Codebaustein und
    gerne auch die typische Anwendung der Methode oder Klasse.

##### Code Smells: Schlechte Kommentare II

-   Veraltete Kommentare

    Hinweis auf unsauberes Arbeiten: Oft wird im Zuge der Überarbeitung
    von Code-Stellen vergessen, auch den Kommentar anzupassen! Sollte
    beim Lesen extrem misstrauisch machen.

-   Auskommentierter Code

    Da ist jemand seiner Sache unsicher bzw. hat eine Überarbeitung
    nicht abgeschlossen. Die Chance, dass sich der restliche Code im
    Laufe der Zeit so verändert, dass der auskommentierte Code nicht
    mehr (richtig) läuft, ist groß! Auskommentierter Code ist gefährlich
    und dank Versionskontrolle absolut überflüssig!

-   Kommentare erscheinen zwingend nötig

    Häufig ein Hinweis auf ungeeignete Wahl der Namen (Klassen,
    Methoden, Attribute) und/oder auf ein ungeeignetes
    Abstraktionsniveau (beispielsweise Nichtbeachtung des Prinzips der
    "*Single Responsibility*")!

    Der Code soll im **Normalfall** für sich selbst sprechen: **WAS**
    wird gemacht. Der Kommentar erklärt im Normalfall, **WARUM** der
    Code das machen soll und die Konzepte und Design-Entscheidungen
    dahinter.

-   Unangemessene Information, z.B. Änderungshistorien

    Hinweise wie "wer hat wann was geändert" gehören in das
    Versionskontroll- oder ins Issue-Tracking-System. Die Änderung ist
    im Code sowieso nicht mehr sichtbar/nachvollziehbar!

##### Code Smells: Schlechte Namen und fehlende Kapselung

``` java
public class Studi extends Person {
    public String n;
    public int c;

    public void prtIf() { ... }
}
```

Nach drei Wochen fragen Sie sich, was `n` oder `c` oder `Studi#prtIf()`
wohl sein könnte! (Ein anderer Programmierer fragt sich das schon beim
**ersten** Lesen.) Klassen und Methoden sollten sich erwartungsgemäß
verhalten.

Wenn Dinge öffentlich angeboten werden, muss man damit rechnen, dass
andere darauf zugreifen. D.h. man kann nicht mehr so einfach Dinge wie
die interne Repräsentation oder die Art der Berechnung austauschen!
Öffentliche Dinge gehören zur Schnittstelle und damit Teil des
"Vertrags" mit den Nutzern!

-   Programmierprinzip "**Prinzip der minimalen Verwunderung**"

    -   Klassen und Methoden sollten sich erwartungsgemäß verhalten
    -   Gute Namen ersparen das Lesen der Dokumentation

-   Programmierprinzip "**Kapselung/Information Hiding**"

    -   Möglichst schlanke öffentliche Schnittstelle
    -   =\> "Vertrag" mit Nutzern der Klasse!

##### Code Smells: Duplizierter Code

``` java
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

-   Programmierprinzip "**DRY**" =\> "Don't repeat yourself!"

Im Beispiel wird das Formatieren der Adresse mehrfach identisch
implementiert, d.h. duplizierter Code. Auslagern in eigene Methode und
aufrufen!

Kopierter/duplizierter Code ist problematisch:

-   Spätere Änderungen müssen an mehreren Stellen vorgenommen werden
-   Lesbarkeit/Orientierung im Code wird erschwert (Analogie:
    Reihenhaussiedlung)
-   Verpasste Gelegenheit für sinnvolle Abstraktion!

##### Code Smells: Langer Code

-   Lange Klassen
    -   Faustregel: 5 Bildschirmseiten sind viel
-   Lange Methoden
    -   Faustregel: 1 Bildschirmseite
    -   ([Martin 2009](#ref-Martin2009)): deutlich weniger als 20 Zeilen
-   Lange Parameterlisten
    -   Faustregel: max. 3 ... 5 Parameter
    -   ([Martin 2009](#ref-Martin2009)): 0 Parameter ideal, ab 3
        Parameter gute Begründung nötig
-   Tief verschachtelte `if/then`-Bedingungen
    -   Faustregel: 2 ... 3 Einrückungsebenen sind viel

<!-- -->

-   Programmierprinzip "**Single Responsibility**"

    Jede Klasse ist für genau **einen Aspekt** des Gesamtsystems
    verantwortlich

###### Lesbarkeit und Übersichtlichkeit leiden

-   Der Mensch kann sich nur begrenzt viele Dinge im Kurzzeitgedächtnis
    merken
-   Klassen, die länger als 5 Bildschirmseiten sind, erfordern viel Hin-
    und Her-Scrollen, dito für lange Methoden
-   Lange Methoden sind schwer verständlich (erledigen viele Dinge?)
-   Mehr als 3 Parameter kann sich kaum jemand merken, vor allem beim
    Aufruf von Methoden
-   Die Testbarkeit wird bei zu komplexen Methoden/Klassen und vielen
    Parametern sehr erschwert
-   Große Dateien verleiten (auch mangels Übersichtlichkeit) dazu, neuen
    Code ebenfalls schluderig zu gliedern

###### Langer Code deutet auch auf eine Verletzung des Prinzips der Single Responsibility hin

-   Klassen fassen evtl. nicht zusammengehörende Dinge zusammen

    ``` java
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

    Warum sollte sich die Klasse `Student` um die Einzelheiten des
    Aufbaus einer Telefonnummer kümmern? Das Prinzip der "*Single
    Responsibility*" wird hier verletzt!

-   Methoden erledigen vermutlich mehr als nur eine Aufgabe

    ``` java
    public void credits() {
        for (Student s : students) {
            if (s.hasSemesterFinished()) {
                ECTS c = calculateEcts(s);
                s.setEctsSum(c);
            }
        }
    }

    // Diese Methode erledigt 4 Dinge: Iteration, Abfrage, Berechnung, Setzen ...
    ```

    =\> Erklären Sie die Methode jemandem. Wenn dabei das Wort "und"
    vorkommt, macht die Methode höchstwahrscheinlich zu viel!

-   Viele Parameter bedeuten oft fehlende Datenabstraktion

    ``` java
    Circle makeCircle(int x, int y, int radius);
    Circle makeCircle(Point center, int radius);  // besser!
    ```

##### Code Smells: Feature Neid

``` java
public class CreditsCalculator {
    public ECTS calculateEcts(Student s) {
        int semester = s.getSemester();
        int workload = s.getCurrentWorkload();
        int nrModuls = s.getNumberOfModuls();
        int total = Math.min(30, workload);
        int extra = Math.max(0, total - 30);
        if (semester < 5) {
             extra = extra * nrModuls;
        }
        return new ECTS(total + extra);
    }
}
```

-   Zugriff auf (viele) Interna der anderen Klasse! =\> Hohe Kopplung
    der Klassen!
-   Methode `CreditsCalculator#calculateEcts()` "möchte" eigentlich in
    `Student` sein ...

##### Weiterführende Links

-   ["Foundations: Clean Code" (The Odin
    Project)](https://www.theodinproject.com/lessons/foundations-clean-code)
-   ["Documentation Best Practices" (Google
    Styleguide)](https://github.com/google/styleguide/blob/gh-pages/docguide/best_practices.md)

##### Wrap-Up

-   Code entsteht nicht zum Selbstzweck =\> Lesbarkeit ist wichtig

<!-- -->

-   Code Smells: Code führt zu möglichen (späteren) Problemen

    -   Richtiges Kommentieren und Dokumentieren

        In dieser Sitzung haben wir vor allem auf Kommentare geschaut.
        Zum Thema Dokumentieren siehe die Einheit zu
        ["Javadoc"](#id-1a29f4d878c0dfd2692190d1ba8be56516408629).

    -   Einhalten von Coding Conventions

        -   Regeln zu Schreibweisen und Layout
        -   Leerzeichen, Einrückung, Klammern
        -   Zeilenlänge, Umbrüche
        -   Kommentare

    -   Einhalten von Prinzipien des objektorientierten Programmierens

        -   Jede Klasse ist für genau **einen** Aspekt des Systems
            verantwortlich. (*Single Responsibility*)
        -   Keine Code-Duplizierung! (*DRY* - Don't repeat yourself)
        -   Klassen und Methoden sollten sich erwartungsgemäß verhalten
        -   Kapselung: Möglichst wenig öffentlich zugänglich machen

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Martin ([2009](#ref-Martin2009))
> -   Passig und Jander ([2013](#ref-Passig2013))
> -   Inden ([2013, Kap. 10](#ref-Inden2013))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kann typische Programmierprinzipien wie 'Information
>     Hiding', 'DRY', 'Single Responsibility' erklären
> -   k3: Ich kann typische Code Smells erkennen und vermeiden
> -   k3: Ich kann leicht lesbaren von schwer lesbarem Code
>     unterscheiden
> -   k3: Ich kann Programmierprinzipien anwenden, um den Code sauberer
>     zu gestalten
> -   k3: Ich kann sinnvolle Kommentare schreiben
>
> </details>

<a id="id-89d3bbb734edbc0c4d593538c63ca0f4828e222b"></a>

#### Coding Conventions und Metriken

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Code entsteht nicht zum Selbstzweck, er muss von anderen Menschen
> leicht verstanden und gewartet werden können: Entwickler verbringen
> einen wesentlichen Teil ihrer Zeit mit dem **Lesen** von (fremdem)
> Code.
>
> Dabei helfen "Coding Conventions", die eine gewisse einheitliche
> äußerliche Erscheinung des Codes vorgeben (Namen, Einrückungen, ...).
> Im Java-Umfeld ist der "Google Java Style" bzw. der recht ähnliche
> "AOSP Java Code Style for Contributors" häufig anzutreffen. Coding
> Conventions beinhalten typischerweise Regeln zu
>
> -   Schreibweisen und Layout
> -   Leerzeichen, Einrückung, Klammern
> -   Zeilenlänge, Umbrüche
> -   Kommentare
>
> Die Beachtung von grundlegenden Programmierprinzipien hilft ebenso,
> die Lesbarkeit und Verständlichkeit zu verbessern.
>
> Metriken sind Kennzahlen, die aus dem Code berechnet werden, und
> können zur Überwachung der Einhaltung von Coding Conventions und
> anderen Regeln genutzt werden. Nützliche Metriken sind dabei NCSS
> (*Non Commenting Source Statements*), McCabe (*Cyclomatic
> Complexity*), BEC (*Boolean Expression Complexity*) und DAC (*Class
> Data Abstraction Coupling*).
>
> Für die Formatierung des Codes kann man die IDE nutzen, muss dort dann
> aber die Regeln detailliert manuell einstellen. Das Tool **Spotless**
> lässt sich dagegen in den Build-Prozess einbinden und kann die
> Konfiguration über ein vordefiniertes Regelset passend zum Google Java
> Style/AOSP automatisiert vornehmen.
>
> Die Prüfung der Coding Conventions und Metriken kann durch das Tool
> **Checkstyle** erfolgen. Dieses kann beispielsweise als Plugin in der
> IDE oder direkt in den Build-Prozess eingebunden werden und wird mit
> Hilfe einer XML-Datei konfiguriert.
>
> Um typische Anti-Pattern zu vermeiden, kann man den Code mit
> sogenannten *Lintern* prüfen. Ein Beispiel für die Java-Entwicklung
> ist **SpotBugs**, welches sich in den Build-Prozess einbinden lässt
> und über 400 typische problematische Muster im Code erkennt.
>
> Für die Praktika in der Veranstaltung Programmiermethoden wird der
> Google Java Style oder AOSP genutzt. Für die passende
> Checkstyle-Konfiguration wird eine minimale
> [checkstyle.xml](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/checkstyle.xml)
> bereitgestellt (vgl. Folie "Konfiguration für das PM-Praktikum").
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Coding Conventions](https://youtu.be/nLAEak6Fwfk)
> -   [Demo Formatter und Spotless](https://youtu.be/oCMwyDrPkFI)
> -   [Demo Checkstyle](https://youtu.be/NR070ZimbH4)
> -   [Demo Checkstyle: Konfiguration mit
>     Eclipse-CS](https://youtu.be/0ny6e6CNTF8)
> -   [Demo SpotBugs](https://youtu.be/tSczcf_EOwI)
>
> </details>

##### Coding Conventions: Richtlinien für einheitliches Aussehen von Code

=\> Ziel: Andere Programmierer sollen Code schnell lesen können

-   **Namen, Schreibweisen**: UpperCamelCase vs. lowerCamelCase
    vs. UPPER_SNAKE_CASE
-   **Kommentare** (Ort, Form, Inhalt): Javadoc an allen `public` und
    `protected` Elementen
-   **Einrückungen und Spaces vs. Tabs**: 4 Spaces
-   **Zeilenlängen**: 100 Zeichen
-   **Leerzeilen**: Leerzeilen für Gliederung
-   **Klammern**: Auf selber Zeile wie Code

Beispiele: [Sun Code
Conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf),
[Google Java Style](https://google.github.io/styleguide/javaguide.html),
[AOSP Java Code Style for
Contributors](https://source.android.com/docs/setup/contribute/code-style)

##### Beispiel nach Google Java Style/AOSP formatiert

``` java
package wuppie.deeplearning.strategy;

/**
 * Demonstriert den Einsatz von AOSP/Google Java Style ................. Umbruch nach 100 Zeichen |
 */
public class MyWuppieStudi implements Comparable<MyWuppieStudi> {
    private static String lastName;
    private static MyWuppieStudi studi;

    private MyWuppieStudi() {}

    /** Erzeugt ein neues Exemplar der MyWuppieStudi-Spezies (max. 40 Zeilen) */
    public static MyWuppieStudi getMyWuppieStudi(String name) {
        if (studi == null) {
            studi = new MyWuppieStudi();
        }
        if (lastName == null) lastName = name;

        return studi;
    }

    @Override
    public int compareTo(MyWuppieStudi o) {
        return lastName.compareTo(lastName);
    }
}
```

Dieses Beispiel wurde nach Google Java Style/AOSP formatiert.

Die Zeilenlänge beträgt max. 100 Zeichen. Pro Methode werden max. 40
Zeilen genutzt. Zwischen Attributen, Methoden und Importen wird jeweils
eine Leerzeile eingesetzt (zwischen den einzelnen Attributen *muss* aber
keine Leerzeile genutzt werden). Zur logischen Gliederung können
innerhalb von Methoden weitere Leerzeilen eingesetzt werden, aber immer
nur eine.

Klassennamen sind UpperCamelCase, Attribute und Methoden und Parameter
lowerCamelCase, Konstanten (im Beispiel nicht vorhanden)
UPPER_SNAKE_CASE. Klassen sind Substantive, Methoden Verben.

Alle `public` und `protected` Elemente werden mit einem
Javadoc-Kommentar versehen. Überschriebene Methoden müssen nicht mit
Javadoc kommentiert werden, müssen aber mit `@Override` markiert werden.

Geschweifte Klammern starten immer auf der selben Codezeile. Wenn bei
einem `if` nur ein Statement vorhanden ist und dieses auf die selbe
Zeile passt, kann auf die umschließenden geschweiften Klammern
ausnahmsweise verzichtet werden.

Es wird mit Leerzeichen eingerückt. [Google Java
Style](https://google.github.io/styleguide/javaguide.html#s4.2-block-indentation)
arbeitet mit 2 Leerzeichen, während
[AOSP](https://source.android.com/docs/setup/contribute/code-style#use-spaces-for-indentation)
hier 4 Leerzeichen vorschreibt. Im Beispiel wurde nach AOSP eingerückt.

Darüber hinaus gibt es vielfältige weitere Regeln für das Aussehen des
Codes. Lesen Sie dazu entsprechend auf [Google Java
Style](https://google.github.io/styleguide/javaguide.html) und auch auf
[AOSP](https://source.android.com/docs/setup/contribute/code-style)
nach.

##### Formatieren Sie Ihren Code (mit der IDE)

Sie können den Code manuell formatieren, oder aber (sinnvollerweise)
über Tools formatieren lassen. Hier einige Möglichkeiten:

-   IDE: Code-Style einstellen und zum Formatieren nutzen

-   [google-java-format](https://github.com/google/google-java-format):
    `java -jar google-java-format.jar --replace *.java` (auch als
    IDE-Plugin)

-   [**Spotless**](https://github.com/diffplug/spotless) in Gradle:

    ``` groovy
    plugins {
        id "java"
        id "com.diffplug.spotless" version "7.0.3"
    }

    spotless {
        java {
            // googleJavaFormat()
            googleJavaFormat().aosp()  // indent w/ 4 spaces
        }
    }
    ```

    Prüfen mit `./gradlew spotlessCheck` (Teil von `./gradlew check`)
    und Formatieren mit `./gradlew spotlessApply`

###### Einstellungen der IDE's

-   Eclipse:
    -   `Project > Properties > Java Code Style > Formatter`:
        Coding-Style einstellen/einrichten
    -   Code markieren, `Source > Format`
    -   Komplettes Aufräumen: `Source > Clean Up` (Formatierung,
        Importe, Annotationen, ...) Kann auch so eingestellt werden,
        dass ein "Clean Up" immer beim Speichern ausgeführt wird!
-   IntelliJ verfügt über ähnliche Fähigkeiten:
    -   Einstellen über `Preferences > Editor > Code Style > Java`
    -   Formatieren mit `Code > Reformat Code` oder
        `Code > Reformat File`

Die Details kann/muss man einzeln einstellen. Für die "bekannten" Styles
(Google Java Style) bringen die IDE's oft aber schon eine
Gesamtkonfiguration mit.

**Achtung**: Zumindest in Eclipse gibt es mehrere Stellen, wo ein
Code-Style eingestellt werden kann ("Clean Up", "Formatter", ...). Diese
sollten dann jeweils auf den selben Style eingestellt werden, sonst gibt
es unter Umständen lustige Effekte, da beim Speichern ein anderer Style
angewendet wird als beim "Clean Up" oder beim "Format Source" ...

Analog sollte man bei der Verwendung von Checkstyle auch in der IDE im
Formatter die entsprechenden Checkstyle-Regeln (s.u.) passend
einstellen, sonst bekommt man durch Checkstyle Warnungen angezeigt, die
man durch ein automatisches Formatieren *nicht* beheben kann.

###### Google Java Style und google-java-format

Wer direkt den [Google Java
Style](https://google.github.io/styleguide/javaguide.html) nutzt, kann
auch den dazu passenden Formatter von Google einsetzen:
[google-java-format](https://github.com/google/google-java-format).
Diesen kann man entweder als Plugin für IntelliJ/Eclipse einsetzen oder
als Stand-alone-Tool (Kommandozeile oder Build-Skripte) aufrufen. Wenn
man sich noch einen entsprechenden Git-Hook definiert, wird vor jedem
Commit der Code entsprechend den Richtlinien formatiert :)

###### Spotless und google-java-format in Gradle

*Hinweis*: Bei Spotless in Gradle müssen je nach den Versionen von
Spotless/google-java-format bzw. des JDK noch Optionen in der Datei
`gradle.properties` eingestellt werden (siehe
[Demo](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/formatter/)
und [Spotless \> google-java-format
(Web)](https://github.com/diffplug/spotless/tree/main/plugin-gradle#google-java-format)).

**Tipp**: Die Formatierung über die IDE ist angenehm, aber in der Praxis
leider oft etwas hakelig: Man muss alle Regeln selbst einstellen (und es
gibt *einige* dieser Einstellungen), und gerade IntelliJ "greift"
manchmal nicht alle Code-Stellen beim Formatieren. Nutzen Sie Spotless
und bauen Sie die Konfiguration in Ihr Build-Skript ein und
konfigurieren Sie über den Build-Prozess.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/quality/src/formatter/">Demo: Konfiguration Formatter (IDE), Spotless/Gradle</a></p>

##### Metriken: Kennzahlen für verschiedene Aspekte zum Code

Metriken messen verschiedene Aspekte zum Code und liefern eine Zahl
zurück. Mit Metriken kann man beispielsweise die Einhaltung der Coding
Rules (Formate, ...) prüfen, aber auch die Einhaltung verschiedener
Regeln des objektorientierten Programmierens.

###### Beispiele für wichtige Metriken (jeweils Max-Werte für PM)

Die folgenden Metriken und deren Maximal-Werte sind gute Erfahrungswerte
aus der Praxis und helfen, den Code Smell "Langer Code" (vgl. ["Code
Smells"](#id-41be9b68119185a3c165c600670ba548b3bf2cfd)) zu erkennen und
damit zu vermeiden. Über die Metriken *BEC*, *McCabe* und *DAC* wird
auch die Einhaltung elementarer Programmierregeln gemessen.

-   **NCSS** (*Non Commenting Source Statements*)
    -   Zeilen pro Methode: 40; pro Klasse: 250; pro Datei: 300
        *Annahme*: Eine Anweisung je Zeile ...
-   **Anzahl der Methoden** pro Klasse: 10
-   **Parameter** pro Methode: 3
-   **BEC** (*Boolean Expression Complexity*) Anzahl boolescher
    Ausdrücke in `if` etc.: 3
-   **McCabe** (*Cyclomatic Complexity*)
    -   Anzahl der möglichen Verzweigungen (Pfade) pro Methode + 1
    -   1-4 gut, 5-7 noch OK
-   **DAC** (*Class Data Abstraction Coupling*)
    -   Anzahl der genutzten (instantiierten) "Fremdklassen"
    -   Werte kleiner 7 werden i.A. als normal betrachtet

Die obigen Grenzwerte sind typische Standardwerte, die sich in der
Praxis allgemein bewährt haben (vergleiche u.a. ([Martin
2009](#ref-Martin2009)) oder auch in [AOSP: Write short
methods](https://source.android.com/docs/setup/contribute/code-style#write-short-methods)
und [AOSP: Limit line
length](https://source.android.com/docs/setup/contribute/code-style#limit-line-length)).

Dennoch sind das keine absoluten Werte an sich. Ein Übertreten der
Grenzen ist ein **Hinweis** darauf, dass **höchstwahrscheinlich** etwas
nicht stimmt, muss aber im konkreten Fall hinterfragt und diskutiert und
begründet werden!

###### Metriken im Beispiel von oben

``` java
    private static String lastName;
    private static MyWuppieStudi studi;

    public static MyWuppieStudi getMyWuppieStudi(String name) {
        if (studi == null) {
            studi = new MyWuppieStudi();
        }
        if (lastName == null) lastName = name;

        return studi;
    }
```

-   BEC: 1 (nur ein boolescher Ausdruck im `if`)
-   McCabe: 3 (es gibt zwei mögliche Verzweigungen in der Methode plus
    die Methode selbst)
-   DAC: 1 (eine "Fremdklasse": `String`)

*Anmerkung*: In Checkstyle werden für einige häufig verwendete
Standard-Klassen Ausnahmen definiert, d.h. `String` würde im obigen
Beispiel *nicht* bei DAC mitgezählt/angezeigt.

=\> Verweis auf LV Softwareengineering

##### Tool-Support: Checkstyle

Metriken und die Einhaltung von Coding-Conventions werden
sinnvollerweise nicht manuell, sondern durch diverse Tools erfasst, etwa
im Java-Bereich mit Hilfe von
[**Checkstyle**](https://github.com/checkstyle).

Das Tool lässt sich [Standalone über
CLI](https://checkstyle.org/cmdline.html) nutzen oder als Plugin für
IDE's ([Eclipse](https://checkstyle.org/eclipse-cs) oder
[IntelliJ](https://github.com/jshiell/checkstyle-idea)) einsetzen.
Gradle bringt ein eigenes
[Plugin](https://docs.gradle.org/current/userguide/checkstyle_plugin.html)
mit.

-   IDE: diverse
    [Plugins](https://checkstyle.org/index.html#Related_Tools):
    [Eclipse-CS](https://checkstyle.org/eclipse-cs),
    [CheckStyle-IDEA](https://github.com/jshiell/checkstyle-idea)

-   [CLI](https://checkstyle.org/cmdline.html):
    `java -jar checkstyle-10.2-all.jar -c google_checks.xml *.java`

-   [Plugin
    "**checkstyle**"](https://docs.gradle.org/current/userguide/checkstyle_plugin.html)
    in Gradle:

    ``` groovy
    plugins {
        id "java"
        id "checkstyle"
    }

    checkstyle {
        configFile file('checkstyle.xml')
        toolVersion '10.23.0'
    }
    ```

    -   Aufruf: Prüfen mit `./gradlew checkstyleMain` (Teil von
        `./gradlew check`)
    -   Konfiguration: `<projectDir>/config/checkstyle/checkstyle.xml`
        (Default) bzw. mit der obigen Konfiguration direkt im
        Projektordner
    -   Report: `<projectDir>/build/reports/checkstyle/main.html`

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/checkstyle/">Demo: IntelliJ, Checkstyle/Gradle</a></p>

##### Checkstyle: Konfiguration

Die auszuführenden Checks lassen sich über eine
[XML-Datei](https://checkstyle.org/config.html) konfigurieren. In
[Eclipse-CS](https://checkstyle.org/eclipse-cs) kann man die
Konfiguration auch in einer GUI bearbeiten.

Das Checkstyle-Projekt stellt eine passende Konfiguration für den
[Google Java
Style](https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml)
bereit. Diese ist auch in den entsprechenden Plugins oft bereits
enthalten und kann direkt ausgewählt oder als Startpunkt für eigene
Konfigurationen genutzt werden.

Der Startpunkt für die Konfigurationsdatei ist immer das Modul
"Checker". Darin können sich "FileSetChecks" (Module, die auf einer
Menge von Dateien Checks ausführen), "Filters" (Module, die Events bei
der Prüfung von Regeln filtern) und "AuditListeners" (Module, die
akzeptierte Events in einen Report überführen) befinden. Der
"TreeWalker" ist mit der wichtigste Vertreter der FileSetChecks-Module
und transformiert die zu prüfenden Java-Sourcen in einen *Abstract
Syntax Tree*, also eine Baumstruktur, die dem jeweiligen Code unter der
Java-Grammatik entspricht. Darauf können dann wiederum die meisten
Low-Level-Module arbeiten.

Eine Reihe von [Standard-Checks](https://checkstyle.org/checks.html)
sind bereits in Checkstyle implementiert und benötigen keine weitere
externe Abhängigkeiten. Man kann aber zusätzliche Regeln aus anderen
Projekten beziehen (etwa via Gradle/Maven) oder sich eigene zusätzliche
Regeln in Java schreiben. Die einzelnen Checks werden in der Regel als
"Modul" dem "TreeWalker" hinzugefügt und über die jeweiligen Properties
näher konfiguriert.

Sie finden in der [Doku](https://checkstyle.org/checks.html) zu jedem
Check das entsprechende Modul, das Eltern-Modul (also wo müssen Sie das
Modul im XML-Baum einfügen) und auch die möglichen Properties und deren
Default-Einstellungen.

``` xml
<module name="Checker">
    <module name="LineLength">
        <property name="max" value="100"/>
    </module>

    <module name="TreeWalker">
        <module name="AvoidStarImport"/>
        <module name="MethodCount">
            <property name="maxPublic" value="10"/>
            <property name="maxTotal" value="40"/>
        </module>
    </module>
</module>
```

Alternativen/Ergänzungen: beispielsweise
[MetricsReloaded](https://github.com/BasLeijdekkers/MetricsReloaded).

<p align="right"><a href="https://youtu.be/0ny6e6CNTF8">Demo: Konfiguration mit Eclipse-CS, Hinweis auf Formatter</a></p>

##### SpotBugs: Finde Anti-Pattern und potentielle Bugs (Linter)

-   [**SpotBugs**](https://github.com/spotbugs/spotbugs) sucht nach über
    400 potentiellen Bugs im Code
    -   Anti-Pattern (schlechte Praxis, "dodgy" Code)
    -   Sicherheitsprobleme
    -   Korrektheit

<!-- -->

-   CLI: `java -jar spotbugs.jar options ...`

-   IDE: [IntelliJ SpotBugs
    plugin](https://github.com/JetBrains/spotbugs-intellij-plugin),
    [SpotBugs Eclipse
    plugin](https://spotbugs.readthedocs.io/en/latest/eclipse.html)

-   Gradle: [SpotBugs Gradle
    Plugin](https://github.com/spotbugs/spotbugs-gradle-plugin)

    ``` groovy
    plugins {
        id "java"
        id "com.github.spotbugs" version "5.0.6"
    }
    spotbugs {
        ignoreFailures = true
        showStackTraces = false
    }
    ```

    Prüfen mit `./gradlew spotbugsMain` (in `./gradlew check`)

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/spotbugs/">Demo: SpotBugs/Gradle</a></p>

##### Konfiguration für das PM-Praktikum (Format, Metriken, Checkstyle, SpotBugs)

Im PM-Praktikum beachten wir die obigen Coding Conventions und Metriken
mit den dort definierten Grenzwerten. Diese sind bereits in der bereit
gestellten Minimal-Konfiguration für Checkstyle (s.u.) konfiguriert.

###### Formatierung

-   Google Java Style/AOSP: **Spotless**

Zusätzlich wenden wir den [Google Java
Style](https://google.github.io/styleguide/javaguide.html) an. Statt der
dort vorgeschriebenen Einrückung mit 2 Leerzeichen (und 4+ Leerzeichen
bei Zeilenumbruch in einem Statement) können Sie auch mit 4 Leerzeichen
einrücken (8 Leerzeichen bei Zeilenumbruch)
([AOSP](https://source.android.com/docs/setup/contribute/code-style)).
Halten Sie sich in Ihrem Team an eine einheitliche Einrückung (Google
Java Style *oder* AOSP).

Formatieren Sie Ihren Code vor den Commits mit **Spotless** (über
Gradle) oder stellen Sie den Formatter Ihrer IDE entsprechend ein.

###### Checkstyle

-   Minimal-Konfiguration für **Checkstyle** (Coding Conventions,
    Metriken)

Nutzen Sie die folgende **Minimal-Konfiguration** für **Checkstyle** für
Ihre Praktikumsaufgaben. Diese beinhaltet die Prüfung der wichtigsten
Formate nach Google Java Style/AOSP sowie der obigen Metriken. Halten
Sie diese Regeln ein.

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE module PUBLIC "-//Checkstyle//DTD Checkstyle Configuration 1.3//EN" "https://checkstyle.org/dtds/configuration_1_3.dtd">

<module name="Checker">
  <property name="severity" value="warning"/>

  <module name="TreeWalker">
    <module name="JavaNCSS">
      <property name="methodMaximum" value="40"/>
      <property name="classMaximum" value="250"/>
      <property name="fileMaximum" value="300"/>
    </module>
    <module name="BooleanExpressionComplexity"/>
    <module name="CyclomaticComplexity">
      <property name="max" value="7"/>
    </module>
    <module name="ClassDataAbstractionCoupling">
      <property name="max" value="6"/>
    </module>
    <module name="MethodCount">
      <property name="maxTotal" value="10"/>
      <property name="maxPrivate" value="10"/>
      <property name="maxPackage" value="10"/>
      <property name="maxProtected" value="10"/>
      <property name="maxPublic" value="10"/>
    </module>
    <module name="ParameterNumber">
      <property name="max" value="3"/>
    </module>
    <module name="MethodLength">
      <property name="max" value="40"/>
    </module>
    <module name="Indentation">
      <property name="basicOffset" value="4"/>
      <property name="lineWrappingIndentation" value="8"/>
      <property name="caseIndent" value="4"/>
      <property name="throwsIndent" value="4"/>
      <property name="arrayInitIndent" value="4"/>
    </module>
    <module name="TypeName"/>
    <module name="MethodName"/>
    <module name="MemberName"/>
    <module name="ParameterName"/>
    <module name="ConstantName"/>
    <module name="OneStatementPerLine"/>
    <module name="MultipleVariableDeclarations"/>
    <module name="MissingOverride"/>
    <module name="MissingJavadocMethod"/>
    <module name="AvoidStarImport"/>
  </module>

  <module name="LineLength">
    <property name="max" value="100"/>
  </module>
  <module name="FileTabCharacter">
    <property name="eachLine" value="true"/>
  </module>
  <module name="NewlineAtEndOfFile"/>
</module>
```

Sie können diese Basis-Einstellungen auch aus dem
Programmiermethoden-CampusMinden/Prog2-Lecture-Repo direkt
herunterladen:
[checkstyle.xml](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/checkstyle.xml).

Sie können zusätzlich gern noch die weiteren (und strengeren) Regeln aus
der vom Checkstyle-Projekt bereitgestellten Konfigurationsdatei für den
[Google Java
Style](https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml)
nutzen. *Hinweis*: Einige der dort konfigurierten Checkstyle-Regeln
gehen allerdings über den Google Java Style hinaus.

###### Linter: SpotBugs

-   Vermeiden von Anti-Pattern mit **SpotBugs**

Setzen Sie zusätzlich **SpotBugs** mit ein. Ihre Lösungen dürfen keine
Warnungen oder Fehler beinhalten, die SpotBugs melden würde.

##### Wrap-Up

-   Code entsteht nicht zum Selbstzweck =\> Regeln nötig!
    -   Coding Conventions

        -   Regeln zu Schreibweisen und Layout
        -   Leerzeichen, Einrückung, Klammern
        -   Zeilenlänge, Umbrüche
        -   Kommentare

    -   Formatieren mit **Spotless**

    -   Prinzipien des objektorientierten Programmierens (vgl. ["Code
        Smells"](#id-41be9b68119185a3c165c600670ba548b3bf2cfd))

        -   Jede Klasse ist für genau **einen** Aspekt des Systems
            verantwortlich. (*Single Responsibility*)
        -   Keine Code-Duplizierung! (*DRY* - Don't repeat yourself)
        -   Klassen und Methoden sollten sich erwartungsgemäß verhalten
        -   Kapselung: Möglichst wenig öffentlich zugänglich machen

<!-- -->

-   Metriken: Einhaltung von Regeln in Zahlen ausdrücken
-   Prüfung manuell durch Code Reviews oder durch Tools wie
    **Checkstyle** oder **SpotBugs**
-   Definition des
    ["PM-Styles"](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/quality/src/checkstyle.xml)
    (siehe Folie "Konfiguration für das PM-Praktikum")

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Martin ([2009](#ref-Martin2009))
> -   Inden ([2013, Kap. 13](#ref-Inden2013))
> -   Google Open Source ([2022](#ref-googlestyleguide))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kann verschiedene Coding Conventions erklären
> -   k2: Ich kann die Metriken NCSS, McCabe, BEC, DAC erklären
> -   k3: Ich kann das Tool Spotless zur Formatierung des Codes nutzen
> -   k3: Ich kann das Tool Checkstyle zum Überprüfen von Coding
>     Conventions und Metriken nutzen
> -   k2: Ich kenne das Tool SpotBugs zum Vermeiden von Anti-Pattern
>
> </details>

<a id="id-d5584aa5535595f1fb5da2daccb6110c719a3c59"></a>

#### Refactoring

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Refactoring bedeutet Änderung der inneren Struktur des Codes ohne
> Beeinflussung äußeren Verhaltens.
>
> Mit Hilfe von Refactoring kann man Code Smells beheben, und
> Lesbarkeit, Verständlichkeit und Wartbarkeit von Software verbessern.
>
> Es ist wichtig, immer nur einzelne Schritte zu machen und anschließend
> die Testsuite laufen zu lassen, damit nicht versehentlich Fehler oder
> Verhaltensänderungen beim Refactoring eingebaut werden.
>
> Prinzipiell kann man Refactoring manuell mit Search&Replace
> durchführen, aber es bietet sich an, hier die IDE-Unterstützung zu
> nutzen. Es stehen verschiedene Methoden zur Verfügung, die nicht
> unbedingt einheitlich benannt sein müssen oder in jeder IDE vorkommen.
> Zu den häufig genutzten Methoden zählen *Rename*, *Extract*, *Move*
> und *Push Up/Pull Down*.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Refactoring](https://youtu.be/n0RaQ_Qve0Y)
> -   [Demo Refactoring: Rename](https://youtu.be/zZ2RGKRBVz4)
> -   [Demo Refactoring: Encapsulate](https://youtu.be/PR4mEjBl_No)
> -   [Demo Refactoring: Extract Method](https://youtu.be/4VbxgqZ68ng)
> -   [Demo Refactoring: Move Method](https://youtu.be/Wr92Oboh05E)
> -   [Demo Refactoring: Pull up](https://youtu.be/t24c88RshL8)
>
> </details>

##### Was ist Refactoring?

> Refactoring ist, wenn einem auffällt, daß der Funktionsname `foobar`
> ziemlich bescheuert ist, und man die Funktion in `sinus` umbenennt.
>
>  Quelle: ["356:
> Refactoring"](http://altlasten.lutz.donnerhacke.de/mitarb/lutz/usenet/Fachbegriffe.der.Informatik.html#356)
> by [Andreas Bogk](mailto:andreas@andreas.org) on Lutz Donnerhacke:
> "Fachbegriffe der Informatik"

> Refactoring (noun): a change made to the internal structure of
> software to make it easier to understand and cheaper to modify without
> changing its observable behaviour.
>
>  Quelle: "*Refactoring*": ([Fowler 2011](#ref-Fowler2011), p. 53)

**Refactoring:** Änderungen an der **inneren Struktur** einer Software

-   Beobachtbares (äußeres) Verhalten ändert sich dabei **nicht**
    -   Keine neuen Features einführen
    -   Keine Bugs fixen
    -   Keine öffentliche Schnittstelle ändern (*Anmerkung*: Bis auf
        Umbenennungen oder Verschiebungen von Elementen innerhalb der
        Software)
-   Ziel: Verbesserung von Verständlichkeit und Änderbarkeit

##### Anzeichen, dass Refactoring jetzt eine gute Idee wäre

-   Code "stinkt" (zeigt/enthält *Code Smells*)

    Code Smells sind strukturelle Probleme, die im Laufe der Zeit zu
    Problemen führen können. Refactoring ändert die innere Struktur des
    Codes und kann entsprechend genutzt werden, um die Smells zu
    beheben.

<!-- -->

-   Schwer erklärbarer Code

    Könnten Sie Ihren Code ohne Vorbereitung in der Abgabe erklären? In
    einer Minute? In fünf Minuten? In zehn? Gar nicht?

    In den letzten beiden Fällen sollten Sie definitiv über eine
    Vereinfachung der Strukturen nachdenken.

-   Verständnisprobleme, Erweiterungen

    Sie grübeln in der Abgabe, was Ihr Code machen sollte?

    Sie überlegen, was Ihr Code bedeutet, um herauszufinden, wo Sie die
    neue Funktionalität anbauen können?

    Sie suchen nach Codeteilen, finden diese aber nicht, da die sich in
    anderen (falschen?) Stellen/Klassen befinden?

    Nutzen Sie die (neuen) Erkenntnisse, um den Code leichter
    verständlich zu gestalten.

<div align="center">

> "Three strikes and you refactor."
>
>  Quelle: "*Three strikes...*": ([Fowler 2011](#ref-Fowler2011), p. 58)

</div>

Wenn Sie sich zum dritten Mal über eine suboptimale Lösung ärgern, dann
werden Sie sich vermutlich noch öfter darüber ärgern. Jetzt ist der
Zeitpunkt für eine Verbesserung.

Schauen Sie sich die entsprechenden Kapitel in ([Passig und Jander
2013](#ref-Passig2013)) und ([Fowler 2011](#ref-Fowler2011)) an, dort
finden Sie noch viele weitere Anhaltspunkte, ob und wann Refactoring
sinnvoll ist.

##### Bevor Sie loslegen ...

1.  **Unit Tests** schreiben
    -   Normale und ungültige Eingaben
    -   Rand- und Spezialfälle

<!-- -->

2.  **Coding Conventions** einhalten
    -   Sourcecode formatieren (lassen)

<!-- -->

3.  Haben Sie die fragliche Codestelle auch wirklich verstanden?!

##### Vorgehen beim Refactoring

###### Überblick über die Methoden des Refactorings

Die Refactoring-Methoden sind nicht einheitlich definiert, es existiert
ein großer und uneinheitlicher "Katalog" an möglichen Schritten.
Teilweise benennt jede IDE die Schritte etwas anders, teilweise werden
unterschiedliche Möglichkeiten angeboten.

Zu den am häufigsten genutzten Methoden zählen

-   Rename Method/Class/Field
-   Encapsulate Field
-   Extract Method/Class
-   Move Method
-   Pull Up, Push Down (Field, Method)

###### Best Practice

Eine Best Practice (oder nennen Sie es einfach eine wichtige Erfahrung)
ist, beim Refactoring langsam und gründlich vorzugehen. Sie ändern die
Struktur der Software und können dabei leicht Fehler oder echte Probleme
einbauen. Gehen Sie also langsam und sorgsam vor, machen Sie einen
Schritt nach dem anderen und sichern Sie sich durch eine gute Testsuite
ab, die Sie nach jedem Schritt erneut ausführen: Das Verhalten der
Software soll sich ja nicht ändern, d.h. die Tests müssen nach jedem
einzelnen Refactoring-Schritt immer grün sein (oder Sie haben einen
Fehler gemacht).

-   Kleine Schritte: immer nur **eine** Änderung zu einer Zeit

-   Nach **jedem** Refactoring-Schritt **Testsuite** laufen lassen

    =\> Nächster Refactoring-Schritt erst, wenn alle Tests wieder "grün"

-   Versionskontrolle nutzen: **Jeden** Schritt **einzeln** committen

##### Refactoring-Methode: Rename Method/Class/Field

###### Motivation

Name einer Methode/Klasse/Attributs erklärt nicht ihren Zweck.

###### Durchführung

Name selektieren, "`Refactor > Rename`"

###### Anschließend ggf. prüfen

Aufrufer? Superklassen?

###### Beispiel

**Vorher**

``` java
public String getTeN() {}
```

**Nachher**

``` java
public String getTelefonNummer() {}
```

##### Refactoring-Methode: Encapsulate Field

###### Motivation

Sichtbarkeit von Attributen reduzieren.

###### Durchführung

Attribut selektieren, "`Refactor > Encapsulate Field`"

###### Anschließend ggf. prüfen

Superklassen? Referenzen? (Neue) JUnit-Tests?

###### Beispiel

**Vorher**

``` java
int cps;

public void printDetails() {
    System.out.println("Credits: " + cps);
}
```

**Nachher**

``` java
private int cps;

int getCps() { return cps; }
void setCps(int cps) {  this.cps = cps;  }

public void printDetails() {
    System.out.println("credits: " + getCps());
}
```

##### Refactoring-Methode: Extract Method/Class

###### Motivation

-   Codefragment stellt eigenständige Methode dar
-   "Überschriften-Code"
-   Code-Duplizierung
-   Code ist zu "groß"
-   Klasse oder Methode erfüllt unterschiedliche Aufgaben

###### Durchführung

Codefragment selektieren, "`Refactor > Extract Method`" bzw.
"`Refactor > Extract Class`"

###### Anschließend ggf. prüfen

-   Aufruf der neuen Methode? Nutzung der neuen Klasse?
-   Neue JUnit-Tests nötig? Veränderung bestehender Tests nötig?
-   Speziell bei Methoden:
    -   Nutzung lokaler Variablen: Übergabe als Parameter!
    -   Veränderung lokaler Variablen: Rückgabewert in neuer Methode und
        Zuweisung bei Aufruf; evtl. neue Typen nötig!

###### Beispiel

**Vorher**

``` java
public void printInfos() {
    printHeader();
    // Details ausgeben
    System.out.println("name:    " + name);
    System.out.println("credits: " + cps);
}
```

**Nachher**

``` java
public void printInfos() {
    printHeader();
    printDetails();
}
private void printDetails() {
    System.out.println("name:    " + name);
    System.out.println("credits: " + cps);
}
```

##### Refactoring-Methode: Move Method

###### Motivation

Methode nutzt (oder wird genutzt von) mehr Eigenschaften einer fremden
Klasse als der eigenen Klasse.

###### Durchführung

Methode selektieren, "`Refactor > Move`" (ggf. "Keep original method as
delegate to moved method" aktivieren)

###### Anschließend ggf. prüfen

-   Aufruf der neuen Methode (Delegation)?
-   Neue JUnit-Tests nötig? Veränderung bestehender Tests nötig?
-   Nutzung lokaler Variablen: Übergabe als Parameter!
-   Veränderung lokaler Variablen: Rückgabewert in neuer Methode und
    Zuweisung bei Aufruf; evtl. neue Typen nötig!

###### Beispiel

**Vorher**

``` java
public class Kurs {
    int cps;
    String descr;
}

public class Studi extends Person {
    String name;
    int cps;
    Kurs kurs;

    public void printKursInfos() {
        System.out.println("Kurs:    " + kurs.descr);
        System.out.println("Credits: " + kurs.cps);
    }
}
```

**Nachher**

``` java
public class Kurs {
    int cps;
    String descr;

    public void printKursInfos() {
        System.out.println("Kurs:    " + descr);
        System.out.println("Credits: " + cps);
    }
}

public class Studi extends Person {
    String name;
    int cps;
    Kurs kurs;

    public void printKursInfos() { kurs.printKursInfos(); }
}
```

##### Refactoring-Methode: Pull Up, Push Down (Field, Method)

###### Motivation

-   Attribut/Methode nur für die Oberklasse relevant: **Pull Up**
-   Subklassen haben identische Attribute/Methoden: **Pull Up**
-   Attribut/Methode nur für eine Subklasse relevant: **Push Down**

###### Durchführung

Name selektieren, "`Refactor > Pull Up`" oder "`Refactor > Push Down`"

###### Anschließend ggf. prüfen

Referenzen/Aufrufer? JUnit-Tests?

###### Beispiel

**Vorher**

``` java
public class Person { }

public class Studi extends Person {
    String name;
    public void printDetails() { System.out.println("name:    " + name); }
}
```

**Nachher**

``` java
public class Person { protected String name; }

public class Studi extends Person {
    public void printDetails() { System.out.println("name:    " + name); }
}
```

##### Wrap-Up

Behebung von **Bad Smells** durch **Refactoring**

=\> Änderung der inneren Struktur ohne Beeinflussung des äußeren
Verhaltens

-   Verbessert Lesbarkeit, Verständlichkeit, Wartbarkeit
-   Immer nur kleine Schritte machen
-   Nach jedem Schritt Testsuite laufen lassen
-   Katalog von Maßnahmen, beispielsweise *Rename*, *Extract*, *Move*,
    *Push Up/Pull Down*, ...
-   Unterstützung durch IDEs wie Eclipse, Idea, ...

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Fowler ([2011](#ref-Fowler2011))
> -   Inden ([2013, Kap. 11](#ref-Inden2013))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kann den Begriff sowie die Notwendigkeit und das Vorgehen
>     des/beim Refactoring erklären
> -   k2: Ich kann die Bedeutung kleiner Schritte beim Refactoring
>     erklären
> -   k2: Ich kann die Bedeutung einer sinnvollen Testsuite beim
>     Refactoring erklären
> -   k2: Ich habe verstanden, dass 'Refactoring' bedeutet: Nur die
>     innere Struktur ändern, nicht das von außen sichtbare Verhalten!
> -   k3: Ich kann die wichtigsten Refactoring-Methoden anwenden:
>     Rename, Extract, Move, Push Up/Pull Down
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Betrachten Sie das [Theatrical Players Refactoring
> Kata](https://github.com/emilybache/Theatrical-Players-Refactoring-Kata).
> Dort finden Sie im Unterordner
> [java/](https://github.com/emilybache/Theatrical-Players-Refactoring-Kata/tree/main/java)
> einige Klassen mit unübersichtlichem und schlecht strukturierten Code.
>
> Welche *Bad Smells* können Sie hier identifizieren?
>
> Beheben Sie die Smells durch die *schrittweise Anwendung* von den aus
> der Vorlesung bekannten Refactoring-Methoden. Denken Sie auch daran,
> dass Refactoring immer durch eine entsprechende Testsuite abgesichert
> sein muss - ergänzen Sie ggf. die Testfälle.
>
> **Real-Life Refactoring**
>
> Betrachten Sie das folgende Code-Beispiel, welches aus dem
> [Dungeon-Projekt](https://github.com/Dungeon-CampusMinden/Dungeon)
> stammt:
>
> ``` java
> public void shootFireBall() {
>     AmmunitionComponent heroAC =
>         hero.fetch(AmmunitionComponent.class)
>             .orElseThrow(() -> MissingComponentException.build(hero, AmmunitionComponent.class));
>     if (!heroAC.checkAmmunition()) return;
>     utils.Direction viewDirection =
>         convertPosCompDirectionToUtilsDirection(EntityUtils.getViewDirection(hero));
>     Skill fireball =
>         new Skill(
>             new FireballSkill(
>                 () -> {
>                 CollideComponent collider =
>                     hero.fetch(CollideComponent.class)
>                         .orElseThrow(
>                             () -> MissingComponentException.build(hero, CollideComponent.class));
>                 Point start = collider.center(hero);
>                 return start.add(new Point(viewDirection.x(), viewDirection.y()));
>                 }),
>             1);
>     fireball.execute(hero);
>     heroAC.spendAmmo();
>     waitDelta();
> }
> ```
>
> 1.  Analysieren Sie den Code und versuchen Sie zu verstehen, was hier
>     passiert. Welche Typen müssen die unterschiedlichen Operationen
>     haben (Parametertypen, Rückgabetypen)?
> 2.  Welche Funktionseinheiten können Sie identifizieren? Entwickeln
>     Sie Ideen, wie dieser Code zu mittels Refactoring lesbarer und
>     verständlicher gemacht werden kann. Nutzen Sie dabei möglichst
>     geschickt u.a. die Java-Stream-API und Optionals und überlegen
>     Sie, welche der Exceptions wirklich relevant sind ...
> 3.  Kopieren Sie den Code in einen Editor (mit Syntaxunterstützung -
>     die IDE geht auch, wird aber wegen der fehlenden Klassen und
>     Variablen keine wirkliche Hilfe sein). Führen Sie das Refactoring
>     "zu Fuß" durch. Vergleichen Sie Ihr Ergebnis und den
>     ursprünglichen Code.
>
> (*Sie brauchen im Dungeon-Projekt nicht zu suchen, diese Code-Stelle
> ist längst bereinigt ...*)
>
> </details>

<a id="id-1a29f4d878c0dfd2692190d1ba8be56516408629"></a>

#### Javadoc

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Mit Javadoc kann aus speziell markierten Block-Kommentaren eine
> externe Dokumentation im HTML-Format erzeugt werden. Die
> Block-Kommentare, auf die das im JDK enthaltene Programm `javadoc`
> reagiert, beginnen mit `/**` (also einem zusätzlichen Stern, der für
> den Java-Compiler nur das erste Kommentarzeichen ist).
>
> Die erste Zeile eines Javadoc-Kommentars ist eine "Zusammenfassung"
> und an fast allen Stellen der generierten Doku sichtbar. Diese Summary
> sollte kurz gehalten werden und eine Idee vermitteln, was die Klasse
> oder die Methode oder das Attribut macht.
>
> Für die Dokumentation von Parametern, Rückgabetypen, Exceptions und
> veralteten Elementen existieren spezielle Annotationen: `@param`,
> `@return`, `@throws` und `@deprecated`.
>
> Als Faustregel gilt: Es werden **alle** `public` und `protected`
> Elemente (Klassen, Methoden, Attribute) mit Javadoc kommentiert. Alle
> nicht-öffentlichen Elemente bekommen normale Java-Kommentare (Zeilen-
> oder Blockkommentare).
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Javadoc](https://youtu.be/Qo2TTD593eQ)
>
> </details>

##### Dokumentation mit Javadoc

``` java
/**
 * Beschreibung Beschreibung (Summary).
 *
 * <p>Hier kommt dann ein laengerer Text, der die Dinge
 * bei Bedarf etwas ausfuehrlicher erklaert.
 */
public void wuppie() {}
```

Javadoc-Kommentare sind (aus Java-Sicht) normale Block-Kommentare, wobei
der Beginn mit `/**` eingeleitet wird. Dieser Beginn ist für das Tool
`javadoc` (Bestandteil des JDK, genau wie `java` und `javac`) das
Signal, dass hier ein Kommentar anfängt, den das Tool in eine
HTML-Dokumentation übersetzen soll.

Typischerweise wird am Anfang jeder Kommentarzeile ein `*` eingefügt;
dieser wird von Javadoc ignoriert.

Sie können neben normalem Text und speziellen Annotationen auch
HTML-Elemente wie `<p>` und `<code>` oder `<ul>` nutzen.

Mit `javadoc *.java` können Sie in der Konsole aus den Java-Dateien die
Dokumentation generieren lassen. Oder Sie geben das in Ihrer IDE in
Auftrag ... (die dann diesen Aufruf gern für Sie tätigt).

##### Standard-Aufbau

``` java
/**
 * Beschreibung Beschreibung (Summary).
 *
 * <p> Hier kommt dann ein laengerer Text, der die Dinge
 * bei Bedarf etwas ausfuehrlicher erklaert.
 *
 * @param   date  Tag, Wert zw. 1 .. 31
 * @return  Anzahl der Sekunden seit 1.1.1970
 * @throws  NumberFormatException
 * @deprecated As of JDK version 1.1
 */
public int setDate(int date) {
    setField(Calendar.DATE, date);
}
```

-   Erste Zeile bei Methoden/Attributen geht in die generierte "Summary"
    in der Übersicht, der Rest in die "Details"
    -   Die "Summary" sollte kein kompletter Satz sein, wird aber wie
        ein Satz geschrieben (Groß beginnen, mit Punkt beenden). Es
        sollte nicht beginnen mit "Diese Methode macht ..." oder "Diese
        Klasse ist ...". Ein gutes Beispiel wäre "Berechnet die
        Steuerrückerstattung."
    -   Danach kommen die Details, die in der generierten Dokumentation
        erst durch Aufklappen der Elemente sichtbar sind. Erklären Sie,
        wieso der Code was machen soll und welche Designentscheidungen
        getroffen wurden (und warum).
-   Leerzeilen gliedern den Text in Absätze. Neue Absätze werden mit
    einem `<p>` eingeleitet. (Ausnahmen: Wenn der Text mit `<ul>` o.ä.
    beginnt oder der Absatz mit den Block-Tags.)
-   Die "Block-Tags" `@param`, `@return`, `@throws`, `@deprecated`
    werden durch einen Absatz von der restlichen Beschreibung getrennt
    und tauchen in exakt dieser Reihenfolge auf. Die Beschreibung dieser
    Tags ist nicht leer - anderenfalls lässt man das Tag weg. Falls die
    Zeile für die Beschreibung nicht reicht, wird umgebrochen und die
    Folgezeile mit vier Leerzeichen (beginnend mit dem `@`) eingerückt.
    -   Mit `@param` erklären Sie die Bedeutung eines Parameters (von
        links nach rechts) einer Methode. Beispiel:
        `@param   date   Tag, Wert zw. 1 .. 31`. Wiederholen Sie dies
        für jeden Parameter.
    -   Mit `@return` beschreiben Sie den Rückgabetyp/-wert. Beispiel:
        `@return  Anzahl der Sekunden seit 1.1.1970`. Bei Rückgabe von
        `void` wird diese Beschreibung weggelassen (die Beschreibung
        wäre dann ja leer).
    -   Mit `@throws` geben Sie an, welche "checked" Exceptions die
        Methode wirft.
    -   Mit `@deprecated` können Sie im Kommentar sagen, dass ein
        Element veraltet ist und möglicherweise mit der nächsten Version
        o.ä. entfernt wird. (siehe nächste Folie)

=\> Dies sind die Basis-Regeln aus dem populären Google-Java-Style
([Google Open Source 2022](#ref-googlestyleguide)).

##### Veraltete Elemente

``` java
/**
 * Beschreibung Beschreibung Beschreibung.
 *
 * @deprecated As of v102, replaced by <code>Foo.fluppie()</code>.
 */
@Deprecated
public void wuppie() {}
```

-   Annotation zum Markieren als "veraltet" (in der generierten
    Dokumentation): `@deprecated`
-   Für Sichtbarkeit zur Laufzeit bzw. im Tooling/IDE: normale
    Code-Annotation `@Deprecated`

Dies ist ein guter Weg, um Elemente einer öffentlichen API als
"veraltet" zu kennzeichnen. Üblicherweise wird diese Kennzeichnung für
einige wenige Releases beibehalten und danach das veraltete Element aus
der API entfernt.

##### Autoren, Versionen, ...

``` java
/**
 * Beschreibung Beschreibung Beschreibung.
 *
 * @author  Dagobert Duck
 * @version V1
 * @since   schon immer
 */
```

-   Annotationen für Autoren und Version: `@author`, `@version`,
    `@since`

Diese Annotationen finden Sie vor allem in Kommentaren zu Packages oder
Klassen.

##### Was muss kommentiert werden?

-   Alle `public` Klassen
-   Alle `public` und `protected` Elemente der Klassen

<!-- -->

-   Ausnahme: `@Override` (An diesen Methoden *kann*, aber *muss* nicht
    kommentiert werden.)

Alle anderen Elemente bei Bedarf mit *normalen* Kommentaren versehen.

###### Beispiel aus dem JDK: ArrayList

Schauen Sie sich gern mal Klassen aus der Java-API an, beispielsweise
eine `java.util.ArrayList`:

-   Generierte Dokumentation: [zu "ArrayList"
    runterscrollen](https://docs.oracle.com/javase/8/docs/api/index.html?java/util/package-summary.html)
    bzw.
    [direkt](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
-   Quellcode:
    [ArrayList.java](https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/tip/src/share/classes/java/util/ArrayList.java)

###### Best Practices: Was beschreibe ich eigentlich?

Unter [Documentation Best
Practices](https://github.com/google/styleguide/blob/gh-pages/docguide/best_practices.md#documentation-is-the-story-of-your-code)
finden Sie eine sehr gute Beschreibung, was das Ziel der Dokumentation
sein sollte. Versuchen Sie, dieses zu erreichen!

Etwas technisch, aber ebenfalls sehr lesenswert ist der Style-Guide für
Java-Software [How to Write Doc Comments for the Javadoc
Tool](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html)
von

1.  

##### Wrap-Up

-   Javadoc-Kommentare sind normale Block-Kommentare beginnend mit `/**`
-   Generierung der HTML-Dokumentation mit `javadoc *.java`
-   Erste Zeile ist eine Zusammenfassung (fast immer sichtbar)
-   Längerer Text danach als "Description" einer Methode/Klasse
-   Annotationen für besondere Elemente: `@param`, `@return`, `@throws`,
    `@deprecated`

<!-- -->

-   Faustregel: Alle `public` und `protected` Elemente mit Javadoc
    kommentieren!

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Ullenboom ([2021, 23.4](#ref-Ullenboom2021))
> -   Google Open Source ([2022, Kap. 7](#ref-googlestyleguide))
> -   1
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich verstehe den Sinn von Javadoc-Kommentaren
> -   k2: Ich kenne den typischen Aufbau von Javadoc-Kommentaren
> -   k3: Ich kann sämtliche öffentlich sichtbaren Elemente mit Javadoc
>     dokumentieren
> -   k3: Ich kann eine sinnvolle Summary schreiben
> -   k3: Ich kann verschiedene Annotationen zur Dokumentation von
>     Parametern, Rückgabetypen, Exceptions, veralteten Elementen
>     einsetzen
> -   k3: Ich kann die Dokumentation generieren
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Betrachten Sie die Javadoc einiger Klassen im Dungeon-Projekt:
> [dojo.rooms.LevelRoom](https://github.com/Dungeon-CampusMinden/Dungeon/blob/31c0e3aaf25eb412a33751c897df43eb21bf2744/dojo-dungeon/src/dojo/rooms/LevelRoom.java),
> [dojo.rooms.MonsterRoom](https://github.com/Dungeon-CampusMinden/Dungeon/blob/31c0e3aaf25eb412a33751c897df43eb21bf2744/dojo-dungeon/src/dojo/rooms/MonsterRoom.java),
> und
> [contrib.components.HealthComponent](https://github.com/Dungeon-CampusMinden/Dungeon/blob/master/dungeon/src/contrib/components/HealthComponent.java).
>
> Stellen Sie sich vor, Sie müssten diese Klassen in einer Übungsaufgabe
> nutzen (das könnte tatsächlich passieren!) ...
>
> Können Sie anhand der Javadoc verstehen, wozu die drei Klassen dienen
> und wie Sie diese Klassen benutzen sollten? Vergleichen Sie die
> Qualität der Dokumentation. Was würden Sie gern in der Dokumentation
> finden? Was würden Sie ändern?
> </details>

<a id="id-1acf41f101a98dd8c16ac174d37f4b3a920d7041"></a>

### Entwurfsmuster

<a id="id-ff6c3f74c23480f2273b18c9777709c80ff62a7e"></a>

#### Visitor-Pattern

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Häufig bietet es sich bei Datenstrukturen an, die Traversierung nicht
> direkt in den Klassen der Datenstrukturen zu implementieren, sondern
> in Hilfsklassen zu verlagern. Dies gilt vor allem dann, wenn die
> Datenstruktur aus mehreren Klassen besteht (etwa ein Baum mit
> verschiedenen Knotentypen) und/oder wenn man nicht nur eine
> Traversierungsart ermöglichen will oder/und wenn man immer wieder neue
> Arten der Traversierung ergänzen will. Das würde nämlich bedeuten,
> dass man für jede weitere Form der Traversierung in *allen* Klassen
> eine entsprechende neue Methode implementieren müsste.
>
> Das Visitor-Pattern lagert die Traversierung in eigene Klassenstruktur
> aus.
>
> Die Klassen der Datenstruktur bekommen nur noch eine
> `accept()`-Methode, in der ein Visitor übergeben wird und rufen auf
> diesem Visitor einfach dessen `visit()`-Methode auf (mit einer
> Referenz auf sich selbst als Argument).
>
> Der Visitor hat für jede Klasse der Datenstruktur eine Überladung der
> `visit()`-Methode. In diesen kann er je nach Klasse die gewünschte
> Verarbeitung vornehmen. Üblicherweise gibt es ein Interface oder eine
> abstrakte Klasse für die Visitoren, von denen dann konkrete Visitoren
> ableiten.
>
> Bei Elementen mit "Kindern" muss man sich entscheiden, wie die
> Traversierung implementiert werden soll. Man könnte in der
> `accept()`-Methode den Visitor an die Kinder weiter reichen (also auf
> den Kindern `accept()` mit dem Visitor aufrufen), bevor man die
> `visit()`-Methode des Visitors mit sich selbst als Referenz aufruft.
> Damit ist die Form der Traversierung in den Klassen der Datenstruktur
> fest verankert und über den Visitor findet "nur" noch eine
> unterschiedliche Form der Verarbeitung statt. Alternativ überlässt man
> es dem Visitor, die Traversierung durchzuführen: Hier muss in den
> `visit()`-Methoden für die einzelnen Elemente entsprechend auf
> mögliche Kinder reagiert werden.
>
> In diesem Pattern findet ein sogenannter "Double-Dispatch" statt: Zur
> Laufzeit wird ein konkreter Visitor instantiiert und über `accept()`
> an ein Element der Datenstruktur übergeben. Dort ist zur Compile-Zeit
> aber nur der Obertyp der Visitoren bekannt, d.h. zur Laufzeit wird
> hier der konkrete Typ bestimmt und entsprechend die richtige
> `visit()`-Methode auf der "echten" Klasse des Visitors aufgerufen
> (erster Dispatch). Da im Visitor die `visit()`-Methoden für jeden Typ
> der Datenstrukur überladen sind, findet nun zur Laufzeit die Auflösung
> der korrekten Überladung statt (zweiter Dispatch).
>
> Das Pattern wird traditionell gern für die Traversierung von
> Datenstrukturen eingesetzt. Es hilft aber auch, wenn man einer
> gewissen Anzahl von Klassen je eine neue Hilfsmethode hinzufügen
> möchte - normalerweise müsste man jetzt jede Klasse einzeln ergänzen.
> Mit dem Visitor-Pattern muss lediglich ein neuer Visitor mit den
> Hilfsmethoden implementiert werden.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Visitor-Pattern](https://youtu.be/zW_2oQmjp8M)
> -   [Demo Visitor-Pattern (Part I: Traversierung ohne
>     Visitor)](https://youtu.be/9dvcufpyQdw)
> -   [Demo Visitor-Pattern (Part II: Traversierung mit
>     Visitor)](https://youtu.be/4rBRkXKhuN4)
>
> </details>

##### Motivation: Parsen von "5\*4+3"

Zum Parsen von Ausdrücken (*Expressions*) könnte man diese einfache
Grammatik einsetzen. Ein Ausdruck ist dabei entweder ein einfacher
Integer oder eine Addition oder Multiplikation zweier Ausdrücke.

``` yacc
expr : e1=expr '*' e2=expr      # MUL
     | e1=expr '+' e2=expr      # ADD
     | INT                      # NUM
     ;
```

Beim Parsen von "5\*4+3" würde dabei der folgende Parsetree entstehen:

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/pattern/images/parsetree.png" width="20%" /></p>

##### Strukturen für den Parsetree

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/pattern/images/parsetree_classes_uml.png" width="70%" /></p>

Der Parsetree für diese einfache Grammatik ist ein Binärbaum. Die Regeln
werden auf Knoten im Baum zurückgeführt. Es gibt Knoten mit zwei
Kindknoten, und es gibt Knoten ohne Kindknoten ("Blätter").

Entsprechend kann man sich einfache Klassen definieren, die die
verschiedenen Knoten in diesem Parsetree repräsentieren. Als Obertyp
könnte es ein (noch leeres) Interface `Expr` geben.

``` java
public interface Expr {}

public class NumExpr implements Expr {
    private final int d;

    public NumExpr(int d) { this.d = d; }
}

public class MulExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    public MulExpr(Expr e1, Expr e2) {
        this.e1 = e1;  this.e2 = e2;
    }
}

public class AddExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    public AddExpr(Expr e1, Expr e2) {
        this.e1 = e1;  this.e2 = e2;
    }
}


public class DemoExpr {
    public static void main(final String... args) {
        // 5*4+3
        Expr e = new AddExpr(new MulExpr(new NumExpr(5), new NumExpr(4)), new NumExpr(3));
    }
}
```

##### Ergänzung I: Ausrechnen des Ausdrucks

Es wäre nun schön, wenn man mit dem Parsetree etwas anfangen könnte.
Vielleicht möchte man den Ausdruck ausrechnen?

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/pattern/images/parsetree_eval_uml.png" width="70%" /></p>

Zum Ausrechnen des Ausdrucks könnte man dem Interface eine
`eval()`-Methode spendieren. Jeder Knoten kann für sich entscheiden, wie
die entsprechende Operation ausgewertet werden soll: Bei einer `NumExpr`
ist dies einfach der gespeicherte Wert, bei Addition oder Multiplikation
entsprechend die Addition oder Multiplikation der Auswertungsergebnisse
der beiden Kindknoten.

``` java
public interface Expr {
    int eval();
}

public class NumExpr implements Expr {
    private final int d;

    public NumExpr(int d) { this.d = d; }
    public int eval() { return d; }
}

public class MulExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    public MulExpr(Expr e1, Expr e2) {
        this.e1 = e1;  this.e2 = e2;
    }
    public int eval() { return e1.eval() * e2.eval(); }
}

public class AddExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    public AddExpr(Expr e1, Expr e2) {
        this.e1 = e1;  this.e2 = e2;
    }
    public int eval() { return e1.eval() + e2.eval(); }
}


public class DemoExpr {
    public static void main(final String... args) {
        // 5*4+3
        Expr e = new AddExpr(new MulExpr(new NumExpr(5), new NumExpr(4)), new NumExpr(3));

        int erg = e.eval();
    }
}
```

##### Ergänzung II: Pretty-Print des Ausdrucks

Nachdem das Ausrechnen so gut geklappt hat, will der Chef nun noch flink
eine Funktion, mit der man den Ausdruck hübsch ausgeben kann:

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/pattern/images/parsetree_eval_print_uml.png" width="70%" /></p>

Das fängt an, sich zu wiederholen. Wir implementieren immer wieder
ähnliche Strukturen, mit denen wir diesen Parsetree traversieren ... Und
wir müssen für *jede* Erweiterung immer *alle* Expression-Klassen
anpassen!

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/pattern/src/visitor/direct/DemoExpr.java">Beispiel: direct.DemoExpr</a></p>

**Das geht besser.**

##### Visitor-Pattern (Besucher-Entwurfsmuster)

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/pattern/images/visitor.png" width="80%" /></p>

Das Entwurfsmuster "Besucher" (*Visitor Pattern*) lagert die Aktion beim
Besuchen eines Knotens in eine separate Klasse aus.

Dazu bekommt jeder Knoten im Baum eine neue Methode, die einen Besucher
akzeptiert. Dieser Besucher kümmert sich dann um die entsprechende
Verarbeitung des Knotens, also um das Auswerten oder Ausgeben im obigen
Beispiel.

Die Besucher haben eine Methode, die für jeden zu bearbeitenden Knoten
überladen wird. In dieser Methode findet dann die eigentliche
Verarbeitung statt: Auswerten des Knotens oder Ausgeben des Knotens ...

``` java
public interface Expr {
    void accept(ExprVisitor v);
}

public class NumExpr implements Expr {
    private final int d;

    public NumExpr(int d) { this.d = d; }
    public int getValue() { return d; }

    public void accept(ExprVisitor v) { v.visit(this); }
}

public class MulExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    public MulExpr(Expr e1, Expr e2) {
        this.e1 = e1;  this.e2 = e2;
    }
    public Expr getE1() { return e1; }
    public Expr getE2() { return e2; }

    public void accept(ExprVisitor v) { v.visit(this); }
}

public class AddExpr implements Expr {
    private final Expr e1;
    private final Expr e2;

    public AddExpr(Expr e1, Expr e2) {
        this.e1 = e1;  this.e2 = e2;
    }
    public Expr getE1() { return e1; }
    public Expr getE2() { return e2; }

    public void accept(ExprVisitor v) { v.visit(this); }
}


public interface ExprVisitor {
    void visit(NumExpr e);
    void visit(MulExpr e);
    void visit(AddExpr e);
}

public class EvalVisitor implements ExprVisitor {
    private final Stack<Integer> erg = new Stack<>();

    public void visit(NumExpr e) { erg.push(e.getValue()); }
    public void visit(MulExpr e) {
        e.getE1().accept(this);  e.getE2().accept(this);
        erg.push(erg.pop() * erg.pop());
    }
    public void visit(AddExpr e) {
        e.getE1().accept(this);  e.getE2().accept(this);
        erg.push(erg.pop() + erg.pop());
    }
    public int getResult() { return erg.peek(); }
}

public class PrintVisitor implements ExprVisitor {
    private final Stack<String> erg = new Stack<>();

    public void visit(NumExpr e) { erg.push("NumExpr(" + e.getValue() + ")"); }
    public void visit(MulExpr e) {
        e.getE1().accept(this);  e.getE2().accept(this);
        erg.push("MulExpr(" + erg.pop() + ", " + erg.pop() + ")");
    }
    public void visit(AddExpr e) {
        e.getE1().accept(this);  e.getE2().accept(this);
        erg.push("AddExpr(" + erg.pop() + ", " + erg.pop() + ")");
    }
    public String getResult() { return erg.peek(); }
}


public class DemoExpr {
    public static void main(final String... args) {
        // 5*4+3
        Expr e = new AddExpr(new MulExpr(new NumExpr(5), new NumExpr(4)), new NumExpr(3));

        EvalVisitor v1 = new EvalVisitor();
        e.accept(v1);
        int erg = v1.getResult();

        PrintVisitor v2 = new PrintVisitor();
        e.accept(v2);
        String s = v2.getResult();
    }
}
```

###### Implementierungsdetail

In den beiden Klasse `AddExpr` und `MulExpr` müssen auch die beiden
Kindknoten besucht werden, d.h. hier muss der Baum weiter traversiert
werden.

Man kann sich überlegen, diese Traversierung in den Klassen `AddExpr`
und `MulExpr` selbst anzustoßen.

Alternativ könnte auch der Visitor die Traversierung vornehmen. Gerade
bei der Traversierung von Datenstrukturen ist diese Variante oft von
Vorteil, da man hier unterschiedliche Traversierungsarten haben möchte
(Breitensuche vs. Tiefensuche, Pre-Order vs. Inorder vs. Post-Order,
...) und diese elegant in den Visitor verlagern kann.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/pattern/src/visitor/visit/intrav/DemoExpr.java">Beispiel Traversierung intern (in den Knotenklassen): visitor.visit.intrav.DemoExpr</a></p>

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/pattern/src/visitor/visit/extrav/DemoExpr.java">Beispiel Traversierung extern (im Visitor): visitor.visit.extrav.DemoExpr</a></p>

###### (Double-) Dispatch

> [!TIP]
>
> Zur Laufzeit wird in `accept()` mit dem Aufruf von `visit()` der
> konkrete Typ des Visitors aufgelöst und dann für `visit(this)` durch
> den Typ der besuchten Klasse (`this`) die korrekte Überladung
> ausgewählt. Dies nennt man auch "**Double-Dispatch**".

In den `accept()`-Methoden der besuchten Klassen ist nur der gemeinsame
Obertyp der Visitoren bekannt. Dies ist wichtig, weil man sonst ja für
jeden neuen Visitor neue passende `accept()`-Methoden in allen zu
besuchenden Klassen implementieren müsste!

Zur Laufzeit wird hier ein konkreter Visitor (also ein Objekt von einem
Untertyp der Visitoren-Oberklasse) als Parameter übergeben.

Beim Aufruf von `visit(this)` in der `accept()`-Methode des besuchten
Objekts wird durch die Laufzeitumgebung der tatsächliche konkrete Typ
des Visitors bestimmt und die in der Typhierarchie in Bezug auf den Typ
des Visitors "tiefste" Implementierung der `visit`-Methode (also die
Implementierung in der Visitorklasse selbst oder, falls dort nicht
vorhanden, in der jeweils nächsthöheren Elternklasse). Über das Argument
`this` wird die tatsächliche konkrete Klasse des besuchten Objekts
ermittelt, so dass die passende Überladung der `visit`-Methode im
konkreten Visitor ausgewählt und aufgerufen werden kann.

###### Hinweis I

Man könnte nun versucht sein, eine dieser zwei Stufen zu überspringen -
man könnte ja die `visit`-Methode des `EvalVisitors` direkt aufrufen und
dabei die Wurzel des Baums (das Objekt `e`) übergeben.

``` java
// Beispiel von oben (Ausschnitt)
Expr e = new AddExpr(new MulExpr(new NumExpr(5), new NumExpr(4)), new NumExpr(3));
EvalVisitor v = new EvalVisitor();
e.accept(v);

// Direkter Aufruf - Autsch?!
v.visit(e);
```

Fragen Sie sich selbst: Kann das funktionieren? Was ist die Begründung?

###### Hinweis II

Man könnte versucht sein, die `accept()`-Methode aus den Knotenklassen
in die gemeinsame Basisklasse zu verlagern: Statt

``` java
    public void accept(ExprVisitor v) {
        v.visit(this);
    }
```

in *jeder* Knotenklasse einzeln zu definieren, könnte man das doch
*einmalig* in der Basisklasse definieren:

``` java
public abstract class Expr {
    /** Akzeptiere einen Visitor für die Verarbeitung */
    public void accept(ExprVisitor v) {
        v.visit(this);
    }
}
```

Dies wäre tatsächlich schön, weil man so Code-Duplizierung vermeiden
könnte. Aber es funktioniert in Java leider nicht. (Warum?)

###### Hinweis III

Während die `accept()`-Methode nicht in die Basisklasse der besuchten
Typen (im Bild oben die Klasse `Elem` bzw. im Beispiel oben die Klasse
`Expr`) verlagert werden kann, kann man die `visit()`-Methoden im
Interface `Visitor` durchaus als Default-Methoden im Interface
implementieren.

##### Ausrechnen des Ausdrucks mit einem Visitor

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/pattern/images/parsetree_visitor_uml.png"  /></p>

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/pattern/src/visitor/visit/extrav/DemoExpr.java">Demo: visitor.visit.extrav.DemoExpr</a></p>

##### Diskussion

In der typischen OO-Denkweise geht man davon aus, dass man eher neue
Klassen über Vererbung hinzufügt als dass man in einer bestehenden
Vererbungshierarchie in jeder der beteiligten Klassen neue Methoden
einbaut. Man leitet einfach von der gewünschten Klasse ab und definiert
mittels Überschreiben von Methoden o.ä. das geänderte Verhalten und erbt
den Rest - es wird also nur eine neue Klasse hinzugefügt samt den
überschriebenen Teilen.

Wenn man allerdings in einer solchen Hierarchie in allen Klassen eine
neue Methode einbauen muss, die dann auch noch in den einzelnen Klassen
individuell implementiert werden muss, dann kommt das Visitor-Pattern
zur Hilfe und erspart Arbeit. Es muss nämlich in der Klassenhierarchie
nur einmal die Schnittstelle für den Visitor einbaut werden (pro Klasse
eine `accept`-Methode). Danach kann man von außen sehr einfach neue
Methoden (also neue Visitoren) erstellen und nutzen, ohne die
Klassenhierarchie noch einmal ändern zu müssen.

Siehe auch [When should I use the Visitor Design
Pattern?](https://stackoverflow.com/a/478672).

Ein anderer Blick ist auf die Rolle der jeweiligen Klassen: Es gibt
Objekte für/in Datenstrukturen, und es gibt Algorithmen, die auf diesen
Objekten bzw. Datenstrukturen arbeiten. Im Sinne des sauberen OO-Designs
würde man diese Strukturen trennen: "Trenne Algorithmen von den
Objekten, auf denen die Algorithmen arbeiten."

Vergleiche auch die Darstellung des Visitor-Patterns in [Visitor
(Refactoring Guru)](https://refactoring.guru/design-patterns/visitor).

##### Wrap-Up

**Visitor-Pattern**: Auslagern der Traversierung in eigene
Klassenstruktur

-   Klassen der Datenstruktur
    -   bekommen eine `accept()`-Methode für einen Visitor
    -   rufen den Visitor mit sich selbst als Argument auf

<!-- -->

-   Visitor
    -   hat für jede Klasse eine Überladung der `visit()`-Methode
    -   Rückgabewerte schwierig: Intern halten oder per `return` (dann
        aber unterschiedliche `visit()`-Methoden für die verschiedenen
        Rückgabetypen!)

<!-- -->

-   (Double-) Dispatch: Zur Laufzeit wird in `accept()` der Typ des
    Visitors und in `visit()` der Typ der zu besuchenden Klasse
    aufgelöst

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Eilebrecht und Starke ([2013](#ref-Eilebrecht2013))
> -   Gamma u. a. ([2011](#ref-Gamma2011))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich verstehe den Aufbau des Visitor-Patterns und kann den
>     Double-Dispatch erklären
> -   k3: Ich kann das Visitor-Pattern auf konkrete Beispiele anwenden
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Visitor-Pattern praktisch (und einfach)**
>
> Betrachten Sie den folgenden Code und erklären Sie das Ergebnis:
>
> ``` java
> interface Fruit { }
> class Apple implements Fruit { }
> class Orange implements Fruit { }
> class Banana implements Fruit { }
> class Foo extends Apple { }
>
> public class FruitBasketDirect {
>     public static void main(String... args) {
>         List<Fruit> basket = List.of(new Apple(), new Apple(), new Banana(), new Foo());
>
>         int oranges = 0;  int apples = 0;  int bananas = 0;  int foo = 0;
>
>         for (Fruit f : basket) {
>             if (f instanceof Apple) apples++;
>             if (f instanceof Orange) oranges++;
>             if (f instanceof Banana) bananas++;
>             if (f instanceof Foo) foo++;
>         }
>     }
> }
> ```
>
> Das Verwenden von `instanceof` ist unschön und fehleranfällig.
> Schreiben Sie den Code unter Einsatz des Visitor-Patterns um.
>
> Diskutieren Sie Vor- und Nachteile des Visitor-Patterns.
> </details>

<a id="id-c50f087222495d1cb378b27fc952f32b2ccb2054"></a>

#### Observer-Pattern

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Eine Reihe von Objekten möchte über eine Änderung in einem anderen
> ("zentralen") Objekt informiert werden. Dazu könnte das "zentrale"
> Objekt eine Zugriffsmethode anbieten, die die anderen Objekte
> regelmäßig abrufen ("pollen").
>
> Mit dem Observer-Pattern kann man das aktive Polling vermeiden. Die
> interessierten Objekte "registrieren" sich beim "zentralen" Objekt.
> Sobald dieses eine Änderung erfährt oder Informationen bereitstehen
> o.ä., wird das "zentrale" Objekt alle registrierten Objekte über den
> Aufruf einer Methode benachrichtigen. Dazu müssen diese eine
> gemeinsame Schnittstelle implementieren.
>
> Das "zentrale" Objekt, welches abgefragt wird, nennt man
> "*Observable*" oder "*Subject*". Die Objekte, die die Information
> abfragen möchten, nennt man "*Observer*".
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Observer-Pattern](https://youtu.be/833lHcoxeog)
> -   [Demo Observer-Pattern](https://youtu.be/0mgB8RfcNuM)
>
> </details>

##### Verteilung der Prüfungsergebnisse

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/pattern/images/lsf.png" width="80%" /></p>

Die Studierenden möchten nach einer Prüfung wissen, ob für einen
bestimmten Kurs die/ihre Prüfungsergebnisse im LSF bereit stehen.

Dazu modelliert man eine Klasse `LSF` und implementiert eine
Abfragemethode, die dann alle Objekte regelmäßig aufrufen können. Dies
sieht dann praktisch etwa so aus:

``` java
final Person[] persons = { new Lecturer("Frau Holle"),
                           new Student("Heinz"),
                           new Student("Karla"),
                           new Tutor("Kolja"),
                           new Student("Wuppie") };
final LSF lsf = new LSF();

for (Person p : persons) {
    lsf.getGradings(p, "My Module");   // ???!
}
```

##### Elegantere Lösung: Observer-Entwurfsmuster

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/pattern/images/observerexample.png" width="80%" /></p>

Sie erstellen im `LSF` eine Methode `register()`, mit der sich
interessierte Objekte beim `LSF` registrieren können.

Zur Benachrichtigung der registrierten Objekte brauchen diese eine
geeignete Methode, die traditionell `update()` genannt wird.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/pattern/src/observer/">Demo: observer</a></p>

##### Observer-Pattern verallgemeinert

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/pattern/images/observer.png" width="80%" /></p>

Im vorigen Beispiel wurde die Methode `update()` einfach der gemeinsamen
Basisklasse `Person` hinzugefügt. Normalerweise möchte man die Aspekte
`Person` und `Observer` aber sauber trennen und definiert sich dazu ein
*separates* Interface `Observer` mit der Methode `update()`, die dann
alle "interessierten" Klassen (zusätzlich zur bestehenden
Vererbungshierarchie) implementieren.

Die Klasse für das zu beobachtende Objekt benötigt dann eine Methode
`register()`, mit der sich Observer registrieren können. Die
Objektreferenzen werden dabei einfach einer internen Sammlung
hinzugefügt.

Häufig findet sich dann noch eine Methode `unregister()`, mit der sich
bereits registrierte Beobachter wieder abmelden können. Weiterhin findet
man häufig eine Methode `notifyObservers()`, die man von außen auf dem
beobachteten Objekt aufrufen kann und die dann auf allen registrierten
Beobachtern deren Methoden `update()` aufruft. (Dieser Vorgang kann aber
auch durch eine sonstige Zustandsänderung im beobachteten Objekt
durchgeführt werden.)

In der Standarddefinition des Observer-Patterns nach ([Gamma u. a.
2011](#ref-Gamma2011)) werden beim Aufruf der Methode `update()` keine
Werte an die Beobachter mitgegeben. Der Beobachter muss sich
entsprechend eine eigene Referenz auf das beobachtete Objekt halten, um
dort dann weitere Informationen erhalten zu können. Dies kann
vereinfacht werden, indem das beobachtete Objekt beim Aufruf der
`update()`-Methode die Informationen als Parameter mitgibt,
beispielsweise eine Referenz auf sich selbst o.ä. ... Dies muss dann
natürlich im `Observer`-Interface nachgezogen werden.

**Hinweis**: Es gibt in Swing bereits die Interfaces `Observer` und
`Observable`, die aber als "deprecated" gekennzeichnet sind.
Sinnvollerweise nutzen Sie nicht diese Interfaces aus Swing, sondern
implementieren Ihre eigenen Interfaces, wenn Sie das Observer-Pattern
einsetzen wollen!

##### Wrap-Up

Observer-Pattern: Benachrichtige registrierte Objekte über
Statusänderungen

-   Interface `Observer` mit Methode `update()`
-   Interessierte Objekte
    1.  implementieren das Interface `Observer`
    2.  registrieren sich beim zu beobachtenden Objekt (`Observable`)
-   Beobachtetes Objekt ruft auf allen registrierten Objekten `update()`
    auf
-   `update()` kann auch Parameter haben

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Nystrom ([2014, Kap. 4](#ref-Nystrom2014))
> -   Gamma u. a. ([2011](#ref-Gamma2011))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kenne den Aufbau des Observer-Patterns und kann dies an
>     einem Beispiel erklären
> -   k3: Ich kann das Observer-Pattern auf konkrete Beispiele (etwa den
>     PM-Dungeon) anwenden
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Observer: Restaurant**
>
> Stellen Sie sich ein Restaurant vor, in welchem man nicht eine
> komplette Mahlzeit bestellt, sondern aus einzelnen Komponenten
> auswählen kann. Die Kunden bestellen also die gewünschten Komponenten,
> suchen sich einen Tisch und warten auf die Fertigstellung ihrer
> Bestellung. Da die Küche leider nur sehr klein ist, werden immer alle
> Bestellungen einer bestimmten Komponente zusammen bearbeitet - also
> beispielsweise werden alle bestellten Salate angerichtet oder die alle
> bestellten Pommes-Portionen zubereitet. Sobald eine solche Komponente
> fertig ist, werden alle Kunden aufgerufen, die diese Komponente
> bestellt haben ...
>
> Modellieren Sie dies in Java. Nutzen Sie dazu das Observer-Pattern,
> welches Sie ggf. leicht anpassen müssen.
>
> **Observer: Einzel- und Großhandel**
>
> In den
> [Vorgaben](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/pattern/src/challenges/observer)
> finden Sie ein Modell für eine Lieferkette zwischen Großhandel und
> Einzelhandel.
>
> Wenn beim Einzelhändler eine Bestellung von einem Kunden eingeht
> (`Einzelhandel#bestellen`), speichert dieser den `Auftrag` zunächst in
> einer Liste ab. In regelmäßigen Abständen (`Einzelhandel#loop`) sendet
> der Einzelhändler die offenen Bestellungen an seinen Großhändler
> (`Grosshandel#bestellen`). Hat der Großhändler die benötigte Ware
> vorrätig, sendet er diese an den Einzelhändler
> (`Einzelhandel#empfangen`). Dieser kann dann den Auftrag gegenüber
> seinem Kunden erfüllen (keine Methode vorgesehen).
>
> Anders als der Einzelhandel speichert der Großhandel keine Aufträge
> ab. Ist die benötigte Ware bei einer Bestellung also nicht oder nicht
> in ausreichender Zahl auf Lager, wird diese nicht geliefert und der
> Einzelhandel muss (später) eine neue Bestellung aufgeben.
>
> Der Großhandel bekommt regelmäßig (`Grosshandel#loop`) neue Ware für
> die am wenigsten vorrätigen Positionen.
>
> Im aktuellen Modell wird der Einzelhandel nicht über den neuen
> Lagerbestand des Großhändlers informiert und kann daher nur "zufällig"
> neue Bestellanfragen an den Großhändler senden.
>
> Verbessern Sie das Modell, indem Sie das Observer-Pattern integrieren.
> Wer ist Observer? Wer ist Observable? Welche Informationen werden bei
> einem `update` mitgeliefert?
>
> Bauen Sie in alle Aktionen vom Einzelhändler und vom Großhändler
> passendes Logging ein.
>
> *Anmerkung*: Sie dürfen nur die Vorgaben-Klassen `Einzelhandel` und
> `Grosshandel` verändern, die anderen Vorgaben-Klassen dürfen Sie nicht
> bearbeiten. Sie können zusätzlich benötigte eigene Klassen/Interfaces
> implementieren.
> </details>

<a id="id-d65790dd2d165c56e13ec1cea6619359f6def01b"></a>

#### Template-Method-Pattern

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Das Template-Method-Pattern ist ein Entwurfsmuster, bei dem ein
> gewisses Verhalten in einer Methode implementiert wird, die wie eine
> Schablone agiert, der sogenannten "Template-Methode". Darin werden
> dann u.a. Hilfsmethoden aufgerufen, die in der Basisklasse entweder
> als `abstract` markiert sind oder mit einem leeren Body implementiert
> sind ("Hook-Methoden"). Über diese Template-Methode legt also die
> Basisklasse ein gewisses Verhaltensschema fest ("Template") - daher
> auch der Name.
>
> In den ableitenden Klassen werden dann die abstrakten Methoden
> und/oder die Hook-Methoden implementiert bzw. überschrieben und damit
> das Verhalten verfeinert.
>
> Zur Laufzeit ruft man auf den Objekten die Template-Methode auf. Dabei
> wird von der Laufzeitumgebung der konkrete Typ der Objekte bestimmt
> (auch wenn man sie unter dem Typ der Oberklasse führt) und die am
> tiefsten in der Vererbungshierarchie implementierten Methoden
> aufgerufen. D.h. die Aufrufe der Hilfsmethoden in der Template-Methode
> führen zu den in der jeweiligen ableitenden Klasse implementierten
> Varianten.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Template-Method-Pattern](https://youtu.be/EE-n2T6AO-g)
>
> </details>

##### Motivation: Syntax-Highlighting im Tokenizer

In einem Compiler ist meist der erste Arbeitsschritt, den Eingabestrom
in einzelne Token aufzubrechen. Dies sind oft die verschiedenen
Schlüsselwörter, Operationen, Namen von Variablen, Methoden, Klassen
etc. ... Aus der Folge von Zeichen (also dem eingelesenen Programmcode)
wird ein Strom von Token, mit dem die nächste Stufe im Compiler dann
weiter arbeiten kann.

``` java
public class Lexer {
    private final List<Token> allToken;  // alle verfügbaren Token-Klassen

    public List<Token> tokenize(String string) {
        List<Token> result = new ArrayList<>();

        while (string.length() > 0) {
            for (Token t : allToken) {
                Token token = t.match(string);
                if (token != null) {
                    result.add(token);
                    string = string.substring(
                                token.getContent().length(),
                                string.length());
                }
            }
        }

        return result;
    }
}
```

Dazu prüft man jedes Token, ob es auf den aktuellen Anfang des
Eingabestroms passt. Wenn ein Token passt, erzeugt man eine Instanz
dieser Token-Klasse und speichert darin den gematchten Eingabeteil, den
man dann vom Eingabestrom entfernt. Danach geht man in die Schleife und
prüft wieder alle Token ... bis irgendwann der Eingabestrom leer ist und
man den gesamten eingelesenen Programmcode in eine dazu passende Folge
von Token umgewandelt hat.

*Anmerkung*: Abgesehen von fehlenden Javadoc etc. hat das obige
Code-Beispiel mehrere Probleme: Man würde im realen Leben nicht mit
`String`, sondern mit einem Zeichenstrom arbeiten. Außerdem fehlt noch
eine Fehlerbehandlung, wenn nämlich keines der Token in der Liste
`allToken` auf den aktuellen Anfang des Eingabestroms passt.

##### Token-Klassen mit formatiertem Inhalt

Um den eigenen Tokenizer besser testen zu können, wurde beschlossen,
dass jedes Token seinen Inhalt als formatiertes HTML-Schnipsel
zurückliefern soll. Damit kann man dann alle erkannten Token formatiert
ausgeben und erhält eine Art Syntax-Highlighting für den eingelesenen
Programmcode.

``` java
public abstract class Token {
    protected String content;

    abstract protected String getHtml();
}
public class KeyWord extends Token {
    @Override
    protected String getHtml() {
        return "<font color=\"red\"><b>" +  this.content + "</b></font>";
    }
}
public class StringContent extends Token {
    @Override
    protected String getHtml() {
        return "<font color=\"green\">" +  this.content + "</font>";
    }
}


Token t = new KeyWord();
LOG.info(t.getHtml());
```

In der ersten Umsetzung erhält die Basisklasse `Token` eine weitere
abstrakte Methode, die jede Token-Klasse implementieren muss und in der
die Token-Klassen einen String mit dem Token-Inhalt und einer
Formatierung für HTML zurückgeben.

Dabei fällt auf, dass der Aufbau immer gleich ist: Es werden ein oder
mehrere Tags zum Start der Format-Sequenz mit dem Token-Inhalt
verbunden, gefolgt mit einem zum verwendeten startenden HTML-Format-Tag
passenden End-Tag.

Auch wenn die Inhalte unterschiedlich sind, sieht das stark nach einer
Verletzung von
[DRY](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself) aus ...

##### Don't call us, we'll call you

``` java
public abstract class Token {
    protected String content;

    public final String getHtml() {
        return htmlStart() + this.content + htmlEnd();
    }

    abstract protected String htmlStart();
    abstract protected String htmlEnd();
}
public class KeyWord extends Token {
    @Override protected String htmlStart() { return "<font color=\"red\"><b>"; }
    @Override protected String htmlEnd() { return "</b></font>"; }
}
public class StringContent extends Token {
    @Override protected String htmlStart() { return "<font color=\"green\">"; }
    @Override protected String htmlEnd() { return "</font>"; }
}


Token t = new KeyWord();
LOG.info(t.getHtml());
```

Wir können den Spaß einfach umdrehen (["inversion of
control"](https://en.wikipedia.org/wiki/Inversion_of_control)) und die
Methode zum Zusammenbasteln des HTML-Strings bereits in der Basisklasse
implementieren. Dazu "rufen" wir dort drei Hilfsmethoden auf, die die
jeweiligen Bestandteile des Strings (Format-Start, Inhalt, Format-Ende)
erzeugen und deren konkrete Implementierung wir in der Basisklasse nicht
kennen. Dies ist dann Sache der ableitenden konkreten Token-Klassen.

Objekte vom Typ `KeyWord` sind dank der Vererbungsbeziehung auch `Token`
(Vererbung: *is-a-Beziehung*). Wenn man nun auf einem `Token t` die
Methode `getHtml()` aufruft, wird zur Laufzeit geprüft, welchen Typ `t`
tatsächlich hat (im Beispiel `KeyWord`). Methodenaufrufe werden dann mit
den am tiefsten in der vorliegenden Vererbungshierarchie implementierten
Methoden durchgeführt: Hier wird also die von `Token` geerbte Methode
`getHtml()` in `KeyWord` aufgerufen, die ihrerseits die Methoden
`htmlStart()` und `htmlEnd()` aufruft. Diese sind in `KeyWord`
implementiert und liefern nun die passenden Ergebnisse.

Die Methode `getHtml()` wird auch als "*Template-Methode*" bezeichnet.
Die beiden darin aufgerufenen Methoden `htmlStart()` und `htmlEnd()` in
`Token` werden auch als "Hilfsmethoden" (oder "*Helper Methods*")
bezeichnet.

Dies ist ein Beispiel für das
**[Template-Method-Pattern](https://en.wikipedia.org/wiki/Template_method_pattern)**.

##### Template-Method-Pattern

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/pattern/images/template-method.png" width="50%" /></p>

###### Aufbau Template-Method-Pattern

In der Basisklasse implementiert man eine Template-Methode (in der
Skizze `templateMethod`), die sich auf anderen in der Basisklasse
deklarierten (Hilfs-) Methoden "abstützt" (diese also aufruft; in der
Skizze `method1`, `method2`, `method3`). Diese Hilfsmethoden können als
`abstract` markiert werden und *müssen* dann von den ableitenden Klassen
implementiert werden (in der Skizze `method1` und `method2`). Man kann
aber auch einige/alle dieser aufgerufenen Hilfsmethoden in der
Basisklasse implementieren (beispielsweise mit einem leeren Body -
sogenannte "Hook"-Methoden) und die ableitenden Klassen *können* dann
diese Methoden überschreiben und das Verhalten so neu formulieren (in
der Skizze `method3`).

Damit werden Teile des Verhaltens an die ableitenden Klassen
ausgelagert.

###### Verwandtschaft zum Strategy-Pattern

Das Template-Method-Pattern hat eine starke Verwandtschaft zum
Strategy-Pattern.

Im Strategy-Pattern haben wir Verhalten komplett an andere Objekte
*delegiert*, indem wir in einer Methode einfach die passende Methode auf
dem übergebenen Strategie-Objekt aufgerufen haben.

Im Template-Method-Pattern nutzen wir statt Delegation die Mechanismen
Vererbung und dynamische Polymorphie und definieren in der Basis-Klasse
abstrakte oder Hook-Methoden, die wir bereits in der Template-Methode
der Basis-Klasse aufrufen. Damit ist das grobe Verhalten in der
Basis-Klasse festgelegt, wird aber in den ableitenden Klassen durch das
dortige Definieren oder Überschreiben der Hilfsmethoden verfeinert. Zur
Laufzeit werden dann durch die dynamische Polymorphie die tatsächlich
implementierten Hilfsmethoden in den ableitenden Klassen aufgerufen.
Damit lagert man im Template-Method-Pattern gewissermaßen nur Teile des
Verhaltens an die ableitenden Klassen aus.

##### Wrap-Up

Template-Method-Pattern: Verhaltensänderung durch Vererbungsbeziehungen

-   Basis-Klasse:
    -   Template-Methode, die Verhalten definiert und Hilfsmethoden
        aufruft
    -   Hilfsmethoden: Abstrakte Methoden (oder "Hook":
        Basis-Implementierung)
-   Ableitende Klassen: Verfeinern Verhalten durch Implementieren der
    Hilfsmethoden
-   Zur Laufzeit: Dynamische Polymorphie: Aufruf der Template-Methode
    nutzt die im tatsächlichen Typ des Objekts implementierten
    Hilfsmethoden

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Eilebrecht und Starke ([2013](#ref-Eilebrecht2013))
> -   Gamma u. a. ([2011](#ref-Gamma2011))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k3: Ich kann das Template-Method-Entwurfsmuster praktisch anwenden
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Schreiben Sie eine abstrakte Klasse Drucker. Implementieren Sie die
> Funktion `kopieren`, bei der zuerst die Funktion `scannen` und dann
> die Funktion `drucken` aufgerufen wird. Der Kopiervorgang ist für alle
> Druckertypen identisch, das Scannen und Drucken ist abhängig vom
> Druckertyp.
>
> Implementieren Sie zusätzlich zwei unterschiedliche Druckertypen:
>
> -   `Tintendrucker extends Drucker`
>     -   `Tintendrucker#drucken` loggt den Text "Drucke das Dokument
>         auf dem Tintendrucker."
>     -   `Tintendrucker#scannen` loggt den Text "Scanne das Dokument
>         mit dem Tintendrucker."
> -   `Laserdrucker extends Drucker`
>     -   `Laserdrucker#drucken` loggt den Text "Drucke das Dokument auf
>         dem Laserdrucker."
>     -   `Laserdrucker#scannen` loggt den Text "Scanne das Dokument mit
>         dem Laserdrucker."
>
> Nutzen Sie das Template-Method-Pattern.
>
> </details>

<a id="id-fa18d796f1346e2d468abc3703e53374e2005b7f"></a>

#### Command-Pattern

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Das **Command-Pattern** ist die objektorientierte Antwort auf
> Callback-Funktionen: Man kapselt Befehle in einem Objekt.
>
> 1.  Die `Command`-Objekte haben eine Methode `execute()` und führen
>     dabei Aktion auf einem bzw. "ihrem" Receiver aus.
>
> 2.  `Receiver` sind Objekte, auf denen Aktionen ausgeführt werden, im
>     Dungeon könnten dies etwa Hero, Monster, ... sein. Receiver müssen
>     keine der anderen Akteure in diesem Pattern kennen.
>
> 3.  Damit die `Command`-Objekte aufgerufen werden, gibt es einen
>     `Invoker`, der `Command`-Objekte hat und zu gegebener Zeit auf
>     diesen die Methode `execute()` aufruft. Der Invoker muss dabei die
>     konkreten Kommandos und die Receiver nicht kennen (nur die
>     `Command`-Schnittstelle).
>
> 4.  Zusätzlich gibt es einen `Client`, der die anderen Akteure kennt
>     und alles zusammen baut.
>
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Command-Pattern](https://youtu.be/F7RJ7YCVMS4)
>
> </details>

##### Motivation

Irgendwo im Dungeon wird es ein Objekt einer Klasse ähnlich wie
`InputHandler` geben mit einer Methode ähnlich zu `handleInput()`:

``` java
public class InputHandler {
    public void handleInput() {
        switch (keyPressed()) {
            case BUTTON_W -> hero.jump();
            case BUTTON_A -> hero.moveX();
            case ...
            default -> { ... }
        }
    }
}
```

Diese Methode wird je Frame einmal aufgerufen, um auf eventuelle
Benutzereingaben reagieren zu können. Je nach gedrücktem Button wird auf
dem Hero eine bestimmte Aktion ausgeführt ...

Das funktioniert, ist aber recht unflexibel. Die Aktionen sind den
Buttons fest zugeordnet und erlauben keinerlei Konfiguration.

##### Auflösen der starren Zuordnung über Zwischenobjekte

``` java
public interface Command { void execute(); }

public class Jump implements Command {
    private Entity e;
    public void execute() { e.jump(); }
}

public class InputHandler {
    private final Command wbutton = new Jump(hero);  // Über Ctor/Methoden setzen!
    private final Command abutton = new Move(hero);  // Über Ctor/Methoden setzen!

    public void handleInput() {
        switch (keyPressed()) {
            case BUTTON_W -> wbutton.execute();
            case BUTTON_A -> abutton.execute();
            case ...
            default -> { ... }
        }
    }
}
```

Die starre Zuordnung "Button : Aktion" wird aufgelöst und über
Zwischenobjekte konfigurierbar gemacht.

Für die Zwischenobjekte wird ein Typ `Command` eingeführt, der nur eine
`execute()`-Methode hat. Für jede gewünschte Aktion wird eine Klasse
davon abgeleitet, diese Klassen können auch einen Zustand pflegen.

Den Buttons wird nun an geeigneter Stelle (Konstruktor, Methoden, ...)
je ein Objekt der jeweiligen Command-Unterklassen zugeordnet. Wenn ein
Button betätigt wird, wird auf dem Objekt die Methode `execute()`
aufgerufen.

Damit die Kommandos nicht nur auf den Helden wirken können, kann man den
Kommando-Objekten beispielsweise noch eine Entität mitgeben, auf der das
Kommando ausgeführt werden soll. Im Beispiel oben wurde dafür der `hero`
genutzt.

##### Command: Objektorientierte Antwort auf Callback-Funktionen

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/pattern/images/command.png" width="80%" /></p>

Im Command-Pattern gibt es vier beteiligte Parteien: Client, Receiver,
Command und Invoker.

Ein Command ist die objektorientierte Abstraktion eines Befehls. Es hat
möglicherweise einen Zustand, und und kennt "seinen" Receiver und kann
beim Aufruf der `execute()`-Methode eine vorher verabredete Methode auf
diesem Receiver-Objekt ausführen.

Ein Receiver ist eine Klasse, die Aktionen durchführen kann. Sie kennt
die anderen Akteure nicht.

Der Invoker (manchmal auch "Caller" genannt) ist eine Klasse, die
Commands aggregiert und die die Commandos "ausführt", indem hier die
`execute()`-Methode aufgerufen wird. Diese Klasse kennt nur das
`Command`-Interface und keine spezifischen Kommandos (also keine der
Sub-Klassen). Es kann zusätzlich eine gewisse Buchführung übernehmen,
etwa um eine Undo-Funktionalität zu realisieren.

Der Client ist ein Programmteil, der ein Command-Objekt aufbaut und
dabei einen passenden Receiver übergibt und der das Command-Objekt dann
zum Aufruf an den Invoker weiterreicht.

In unserem Beispiel lassen sich die einzelnen Teile so sortieren:

-   Client: Klasse `InputHandler` (erzeugt neue `Command`-Objekte im
    obigen Code) bzw. `main()`, wenn man die `Command`-Objekte dort
    erstellt und an den Konstruktor von `InputHandler` weiterreicht
-   Receiver: Objekt `hero` der Klasse `Hero` (auf diesem wird eine
    Aktion ausgeführt)
-   Command: `Jump` und `Move`
-   Invoker: `InputHandler` (in der Methode `handleInput()`)

##### Undo

Wir könnten das `Command`-Interface um ein paar Methoden erweitern:

``` java
public interface Command {
    void execute();
    void undo();
    Command newCommand(Entity e);
}
```

Jetzt kann jedes Command-Objekt eine neue Instanz erzeugen mit der
Entity, die dann dieses Kommando empfangen soll:

``` java
public class Move implements Command {
    private Entity e;
    private int x, y, oldX, oldY;

    public void execute() { oldX = e.getX();  oldY = e.getY();  x = oldX + 42;  y = oldY;  e.moveTo(x, y); }
    public void undo() { e.moveTo(oldX, oldY); }
    public Command newCommand(Entity e) { return new Move(e); }
}

public class InputHandler {
    private final Command wbutton;
    private final Command abutton;
    private final Stack<Command> s = new Stack<>();

    public void handleInput() {
        Entity e = getSelectedEntity();
        switch (keyPressed()) {
            case BUTTON_W -> { s.push(wbutton.newCommand(e)); s.peek().execute(); }
            case BUTTON_A -> { s.push(abutton.newCommand(e)); s.peek().execute(); }
            case BUTTON_U -> s.pop().undo();
            case ...
            default -> { ... }
        }
    }
}
```

Über den Konstruktor von `InputHandler` (im Beispiel nicht gezeigt)
würde man wie vorher die `Command`-Objekte für die Buttons setzen. Es
würde aber in jedem Aufruf von `handleInput()` abgefragt, was gerade die
selektierte Entität ist und für diese eine neue Instanz des zur
Tastatureingabe passenden `Command`-Objekts erzeugt. Dieses wird nun in
einem Stack gespeichert und danach ausgeführt.

Wenn der Button "U" gedrückt wird, wird das letzte `Command`-Objekt aus
dem Stack genommen (Achtung: Im echten Leben müsste man erst einmal
schauen, ob hier noch was drin ist!) und auf diesem die Methode `undo()`
aufgerufen. Für das Kommando `Move` ist hier skizziert, wie ein Undo
aussehen könnte: Man muss einfach bei jedem `execute()` die alte
Position der Entität speichern, dann kann man sie bei einem `undo()`
wieder auf diese Position verschieben. Da für jeden Move ein neues
Objekt angelegt wird und dieses nur einmal benutzt wird, braucht man
keine weitere Buchhaltung ...

##### Wrap-Up

**Command-Pattern**: Kapsele Befehle in ein Objekt

-   `Command`-Objekte haben eine Methode `execute()` und führen darin
    Aktion auf Receiver aus
-   `Receiver` sind Objekte, auf denen Aktionen ausgeführt werden (Hero,
    Monster, ...)
-   `Invoker` hat `Command`-Objekte und ruft darauf `execute()` auf
-   `Client` kennt alle und baut alles zusammen

**Objektorientierte Antwort auf Callback-Funktionen**

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Gamma u. a. ([2011](#ref-Gamma2011))
> -   Nystrom ([2014, Kap. 2](#ref-Nystrom2014))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kann den Aufbau des Command-Patterns erklären
> -   k3: Ich kann das Command-Pattern auf konkrete Beispiele, etwa den
>     PM-Dungeon, anwenden
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Schreiben Sie für den `Dwarf` in den
> [Vorgaben](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/pattern/src/challenges/command)
> einen Controller, welcher das Command-Pattern verwendet.
>
> -   "W" führt Springen aus
> -   "A" bewegt den Zwerg nach links
> -   "D" bewegt den Zwerg nach rechts
> -   "S" führt Ducken aus
>
> Schreiben Sie zusätzlich für den `Cursor` einen Controller, welcher
> das Command-Pattern mit Historie erfüllt (ebenfalls über die Tasten
> "W", "A", "S" und "D").
>
> Schreiben Sie eine Demo, um die Funktionalität Ihres Programmes zu
> demonstrieren.
>
> </details>

<a id="id-f7083be5fbfab945de3e25ca0bad1e1914731a7c"></a>

### Fortgeschrittene Java-Themen und Umgang mit JVM

<a id="id-cfd21c65be03a9536ad286c40c0f52ec3d376712"></a>

#### Reguläre Ausdrücke

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Mit Hilfe von regulären Ausdrücken kann man den Aufbau von
> Zeichenketten formal beschreiben. Dabei lassen sich direkt die
> gewünschten Zeichen einsetzen, oder man nutzt Zeichenklassen oder
> vordefinierte Ausdrücke. Teilausdrücke lassen sich gruppieren und über
> *Quantifier* kann definiert werden, wie oft ein Teilausdruck vorkommen
> soll. Die Quantifier sind per Default **greedy** und versuchen so viel
> wie möglich zu matchen.
>
> Auf der Java-Seite stellt man reguläre Ausdrücke zunächst als `String`
> dar. Dabei muss darauf geachtet werden, dass ein Backslash im
> regulären Ausdruck im Java-String geschützt (*escaped*) werden muss,
> indem jeweils ein weiterer Backslash voran gestellt wird. Mit Hilfe
> der Klasse `java.util.regex.Pattern` lässt sich daraus ein Objekt mit
> dem kompilierten regulären Ausdruck erzeugen, was insbesondere bei
> mehrfacher Verwendung günstiger in der Laufzeit ist. Dem
> Pattern-Objekt kann man dann den Suchstring übergeben und bekommt ein
> Objekt der Klasse `java.util.regex.Matcher` (dort sind regulärer
> Ausdruck/Pattern und der Suchstring kombiniert). Mit den Methoden
> `Matcher#find` und `Matcher#matches` kann dann geprüft werden, ob das
> Pattern auf den Suchstring passt: `find` sucht dabei nach dem ersten
> Vorkommen des Patterns im Suchstring, `match` prüft, ob der gesamte
> String zum Pattern passt.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL RegExp](https://youtu.be/K9R1Bwa73uI)
> -   [Demo StringSplit](https://youtu.be/j_pTZBI6Z3M)
> -   [Demo MatchFind](https://youtu.be/LYlPL1C_au8)
> -   [Demo Quantifier](https://youtu.be/xkD9PhCjXyY)
> -   [Demo Groups](https://youtu.be/ANLB2MdC_uY)
> -   [Demo Backref](https://youtu.be/SRZyT3EAB94)
>
> </details>

##### Suchen in Strings

Gesucht ist ein Programm zum Extrahieren von Telefonnummern aus E-Mails.

=\> **Wie geht das?**

Leider gibt es unzählig viele Varianten, wie man eine Telefonnummer
(samt Vorwahl und ggf. Ländervorwahl) aufschreiben kann:

    030 - 123 456 789, 030-123456789, 030/123456789,
    +49(30)123456-789, +49 (30) 123 456 - 789, ...

##### Definition Regulärer Ausdruck

> Ein **regulärer Ausdruck** ist eine Zeichenkette, die zur Beschreibung
> von Zeichenketten dient.

###### Anwendungen

-   Finden von Bestandteilen in Zeichenketten
-   Aufteilen von Strings in Tokens
-   Validierung von textuellen Eingaben =\> "Eine Postleitzahl besteht
    aus 5 Ziffern"
-   Compilerbau: Erkennen von Schlüsselwörtern und Strukturen und
    Syntaxfehlern

##### Einfachste reguläre Ausdrücke

| **Zeichenkette** | **Beschreibt**         |
|:-----------------|:-----------------------|
| `x`              | "x"                    |
| `.`              | ein beliebiges Zeichen |
| `\t`             | Tabulator              |
| `\n`             | Newline                |
| `\r`             | Carriage-return        |
| `\\`             | Backslash              |

###### Beispiel

-   `abc` =\> "abc"
-   `A.B` =\> "AAB" oder "A2B" oder ...
-   `a\\bc` =\> "a\\bc"

###### Anmerkung

In Java-Strings leitet der Backslash eine zu interpretierende
Befehlssequenz ein. Deshalb muss der Backslash i.d.R. geschützt
("escaped") werden. =\> Statt "`\n`" müssen Sie im Java-Code "`\\n`"
schreiben!

##### Zeichenklassen

| **Zeichenkette** | **Beschreibt**                                           |
|:------------------|:----------------------------------------------------|
| `[abc]`          | "a" oder "b" oder "c"                                    |
| `[^abc]`         | alles außer "a", "b" oder "c" (Negation)                 |
| `[a-zA-Z]`       | alle Zeichen von "a" bis "z" und "A" bis "Z" (Range)     |
| `[a-z&&[def]]`   | "d", "e" oder "f" (Schnitt)                              |
| `[a-z&&[^bc]]`   | "a" bis "z", außer "b" und "c": `[ad-z]` (Subtraktion)   |
| `[a-z&&[^m-p]]`  | "a" bis "z", außer "m" bis "p": `[a-lq-z]` (Subtraktion) |

Zeichenklassen werden über eine Zeichenkette formuliert, die in `[` und
`]` eingeschlossen wird. Dabei werden alle Zeichen aufgezählt, die in
dieser Zeichenklasse enthalten sein sollen. Die Zeichenklasse verhält
sich von außen betrachtet wie ein beliebiges Zeichen aus der Menge der
aufgezählten Zeichen.

Beispiel: `[abc]` meint ein "a" oder "b" oder "c" ...

Wenn dem ersten Zeichen der so geformten Zeichenklasse ein `^`
vorangestellt wird, sind alle Zeichen *außer* den in der Zeichenklasse
bezeichneten Zeichen gemeint (Negation). In der Tabelle oben (erste
Zeile) könnte man dem `abc` noch ein `^` voranstellen und hätte dann
*alle* Zeichen *außer* "a", "b" und "c".

Für den Schnitt kann als zweite Zeichenklasse eine Negation verwendet
werden, damit würde eine Subtraktion erreicht werden: Alle Zeichen in
der vorderen Zeichenklasse abzüglich der Zeichen in der zweiten
Zeichenklasse. In der Tabelle oben (vierte Zeile) würde man dem `def`
noch ein `^` voranstellen und hätte dann die Zeichen "a" bis "z" *ohne*
"d", "e" und "f".

*Anmerkung*: Das Minus-Zeichen hat in der Zeichenklasse eine besondere
Bedeutung (es bildet einen Range). Deshalb muss es escaped werden, wenn
es sich selbst darstellen soll.

###### Beispiel

-   `[abc]` =\> "a" oder "b" oder "c"
-   `[a-c]` =\> "a" oder "b" oder "c"
-   `[a-c][a-c]` =\> "aa", "ab", "ac", "ba", "bb", "bc", "ca", "cb" oder
    "cc"
-   `A[a-c]` =\> "Aa", "Ab" oder "Ac"

##### Vordefinierte Ausdrücke

| **Zeichenkette** | **Beschreibt**                               |
|:-----------------|:---------------------------------------------|
| `^`              | Zeilenanfang                                 |
| `$`              | Zeilenende                                   |
| `\d`             | eine Ziffer: `[0-9]`                         |
| `\w`             | beliebiges Wortzeichen: `[a-zA-Z_0-9]`       |
| `\s`             | Whitespace (Leerzeichen, Tabulator, Newline) |
| `\D`             | jedes Zeichen außer Ziffern: `[^0-9]`        |
| `\W`             | jedes Zeichen außer Wortzeichen: `[^\w]`     |
| `\S`             | jedes Zeichen außer Whitespaces: `[^\s]`     |

###### Beispiel

-   `\d\d\d\d\d` =\> "12345"
-   `\w\wA` =\> "aaA", "a0A", "a_A", ...

##### Nutzung in Java

-   `java.lang.String`:

    ``` java
    public String[] split(String regex)
    public boolean matches(String regex)
    ```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/regexp/StringSplit.java">Demo: regexp.StringSplit</a></p>

-   `java.util.regex.Pattern`:

    ``` java
    public static Pattern compile(String regex)
    public Matcher matcher(CharSequence input)
    ```

    -   Schritt 1: Ein Pattern compilieren (erzeugen) mit
        `Pattern#compile` =\> liefert ein Pattern-Objekt für den
        regulären Ausdruck zurück
    -   Schritt 2: Dem Pattern-Objekt den zu untersuchenden Zeichenstrom
        übergeben mit `Pattern#matcher` =\> liefert ein Matcher-Objekt
        zurück, darin gebunden: Pattern (regulärer Ausdruck) und die zu
        untersuchende Zeichenkette

<!-- -->

-   `java.util.regex.Matcher`:

    ``` java
    public boolean find()
    public boolean matches()
    public int groupCount()
    public String group(int group)
    ```

    -   Schritt 3: Mit dem Matcher-Objekt kann man die Ergebnisse der
        Anwendung des regulären Ausdrucks auf eine Zeichenkette
        auswerten

        Bedeutung der unterschiedlichen Methoden siehe folgende Folien

        `Matcher#group`: Liefert die Sub-Sequenz des Suchstrings zurück,
        die erfolgreich gematcht wurde (siehe unten "Fangende
        Gruppierungen")

**Hinweis**:

In Java-Strings leitet der Backslash eine zu interpretierende
Befehlssequenz ein. Deshalb muss der Backslash i.d.R. extra geschützt
("escaped") werden.

=\> Statt "`\n`" (regulärer Ausdruck) müssen Sie im Java-String "`\\n`"
schreiben!

=\> Statt "`a\\bc`" (regulärer Ausdruck, passt auf die Zeichenkette
"a\\bc") müssen Sie im Java-String "`a\\\\bc`" schreiben!

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/regexp/MatchFind.java">Demo: regexp.MatchFind</a></p>

##### Unterschied zw. Finden und Matchen

-   `Matcher#find`:

    Regulärer Ausdruck muss im Suchstring **enthalten** sein. =\> Suche
    nach **erstem Vorkommen**

<!-- -->

-   `Matcher#matches`:

    Regulärer Ausdruck muss auf **kompletten** Suchstring passen.

###### Beispiel

-   Regulärer Ausdruck: `abc`, Suchstring: "blah blah abc blub"
    -   `Matcher#find`: erfolgreich
    -   `Matcher#matches`: kein Match - Suchstring entspricht nicht dem
        Muster

##### Quantifizierung

| **Zeichenkette** | **Beschreibt**                                   |
|:-----------------|:-------------------------------------------------|
| `X?`             | ein oder kein "X"                                |
| `X*`             | beliebig viele "X" (inkl. kein "X")              |
| `X+`             | mindestens ein "X", ansonsten beliebig viele "X" |
| `X{n}`           | exakt $n$ Vorkommen von "X"                      |
| `X{n,}`          | mindestens $n$ Vorkommen von "X"                 |
| `X{n,m}`         | zwischen $n$ und $m$ Vorkommen von "X"           |

###### Beispiel

-   `\d{5}` =\> "12345"
-   `-?\d+\.\d*` =\> ???

##### Interessante Effekte

``` java
Pattern p = Pattern.compile("A.*A");
Matcher m = p.matcher("A 12 A 45 A");

if (m.matches())
    String result = m.group(); // ???
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/regexp/Quantifier.java">Demo: regexp.Quantifier</a></p>

`Matcher#group` liefert die Inputsequenz, auf die der Matcher
angesprochen hat. Mit `Matcher#start` und `Matcher#end` kann man sich
die Indizes des ersten und letzten Zeichens des Matches im
Eingabezeichenstrom geben lassen. D.h. für einen Matcher `m` und eine
Eingabezeichenkette `s` ist `m.group()` und
`s.substring(m.start(), m.end())` äquivalent.

Da bei `Matcher#matches` das Pattern immer auf den gesamten Suchstring
passen muss, verwundert das Ergebnis für `Matcher#group` nicht. Bei
`Matcher#find` wird im Beispiel allerdings ebenfalls der gesamte
Suchstring "gefunden" ... Dies liegt am "*greedy*" Verhalten der
Quantifizierer.

##### Nicht gierige Quantifizierung mit "?"

| **Zeichenkette** | **Beschreibt**               |
|:-----------------|:-----------------------------|
| `X*?`            | non-greedy Variante von `X*` |
| `X+?`            | non-greedy Variante von `X+` |

###### Beispiel

-   Suchstring "A 12 A 45 A":
    -   `A.*A` findet/passt auf "A 12 A 45 A"

        normale **greedy** Variante

    -   `A.*?A`

        -   findet "A 12 A"
        -   passt auf "A 12 A 45 A" (!)

        **non-greedy** Variante der Quantifizierung; `Matcher#matches`
        muss trotzdem auf den gesamten Suchstring passen!

##### (Fangende) Gruppierungen

`Studi{2}` passt nicht auf "StudiStudi" (!)

Quantifizierung bezieht sich auf das direkt davor stehende Zeichen. Ggf.
Gruppierungen durch Klammern verwenden!

| **Zeichenkette** | **Beschreibt** |
|:-----------------|:---------------|
| `X\|Y`           | X oder Y       |
| `(C)`            | Gruppierung    |

###### Beispiel

-   `(A)(B(C))`
    -   Gruppe 0: `ABC`
    -   Gruppe 1: `A`
    -   Gruppe 2: `BC`
    -   Gruppe 3: `C`

Die Gruppen heißen auch "fangende" Gruppen (engl.: *"capturing
groups"*).

Damit erreicht man eine Segmentierung des gesamten regulären Ausdrucks,
der in seiner Wirkung aber nicht durch die Gruppierungen geändert wird.
Durch die Gruppierungen von Teilen des regulären Ausdrucks erhält man
die Möglichkeit, auf die entsprechenden Teil-Matches (der Unterausdrücke
der einzelnen Gruppen) zuzugreifen:

-   `Matcher#groupCount`: Anzahl der "fangenden" Gruppen im regulären
    Ausdruck

-   `Matcher#group(i)`: Liefert die Subsequenz der Eingabezeichenkette
    zurück, auf die die jeweilige Gruppe gepasst hat. Dabei wird von
    links nach rechts durchgezählt, beginnend bei 1(!).

    Konvention: Gruppe 0 ist das gesamte Pattern, d.h.
    `m.group(0) == m.group();` ...

*Hinweis*: Damit der Zugriff auf die Gruppen klappt, muss auch erst ein
Match gemacht werden, d.h. das Erzeugen des Matcher-Objekts reicht noch
nicht, sondern es muss auch noch ein `matcher.find()` oder
`matcher.matches()` ausgeführt werden. Danach kann man bei Vorliegen
eines Matches auf die Gruppen zugreifen.

`(Studi){2}` =\> "StudiStudi"

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/regexp/Groups.java">Demo: regexp.Groups</a></p>

##### Gruppen und Backreferences

Matche zwei Ziffern, gefolgt von den selben zwei Ziffern

<div align="center">

`(\d\d)\1`

</div>

-   Verweis auf bereits gematchte Gruppen: `\num`

    `num` Nummer der Gruppe (1 ... 9)

    =\> Verweist nicht auf regulären Ausdruck, sondern auf jeweiligen
    Match!

    *Anmerkung*: Laut Literatur/Doku nur 1 ... 9, in Praxis geht auch
    mehr per Backreference ...

<!-- -->

-   Benennung der Gruppe: `(?<name>X)`

    `X` ist regulärer Ausdruck für Gruppe, spitze Klammern wichtig

    =\> Backreference: `\k<name>`

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/regexp/Backref.java">Demo: regexp.Backref</a></p>

##### Beispiel Gruppen und Backreferences

Regulärer Ausdruck: Namen einer Person matchen, wenn Vor- und Nachname
identisch sind.

Lösung: `([A-Z][a-zA-Z]*)\s\1`

##### Umlaute und reguläre Ausdrücke

-   Keine vordefinierte Abkürzung für Umlaute (wie etwa `\d`)

-   Umlaute nicht in `[a-z]` enthalten, aber in `[a-ü]`

    ``` java
    "helloüA".matches(".*?[ü]A");
    "azäöüß".matches("[a-ä]");
    "azäöüß".matches("[a-ö]");
    "azäöüß".matches("[a-ü]");
    "azäöüß".matches("[a-ß]");
    ```

-   Strings sind Unicode-Zeichenketten

    =\> Nutzung der passenden Unicode Escape Sequence `\uFFFF`

    ``` java
    System.out.println("\u0041 :: A");
    System.out.println("helloüA".matches(".*?A"));
    System.out.println("helloüA".matches(".*?\u0041"));
    System.out.println("helloü\u0041".matches(".*?A"));
    ```

-   RegExp vordefinieren und mit Variablen zusammenbauen ala Perl nicht
    möglich =\> Umweg String-Repräsentation

##### Wrap-Up

-   RegExp: Zeichenketten, die andere Zeichenketten beschreiben
-   `java.util.regex.Pattern` und `java.util.regex.Matcher`
-   Unterschied zwischen `Matcher#find` und `Matcher#matches`!
-   Quantifizierung ist möglich, aber **greedy** (Default)

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k1: Ich kenne die wichtigsten Methoden von java.util.regex.Pattern
>     und java.util.regex.Matcher
> -   k2: Ich kann den Unterschied zwischen Matcher#find und
>     Matcher#matches erklären
> -   k2: Ich kann zwischen greedy und non-greedy Verhalten bei
>     regulären Ausdrücken unterscheiden
> -   k3: Ich kann einfache reguläre Ausdrücke bilden
> -   k3: Ich kann Zeichenklassen und deren Negation einsetzen
> -   k3: Ich kann die vordefinierten regulären Ausdrücke einsetzen
> -   k3: Ich kann Quantifizierer gezielt einsetzen
> -   k3: Ich kann komplexe Ausdrücke (u.a. mit Gruppen) konstruieren
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Schreiben Sie eine Methode, die mit Hilfe von regulären Ausdrücken
> überprüft, ob der eingegebene String eine nach dem folgenden Schema
> gebildete EMail-Adresse ist:
>
> <div align="center">
>
> `name@firma.domain`
>
> </div>
>
> Dabei sollen folgende Regeln gelten:
>
> -   Die Bestandteile `name` und `firma` können aus Buchstaben,
>     Ziffern, Unter- und Bindestrichen bestehen.
> -   Der Bestandteil `name` muss mindestens ein Zeichen lang sein.
> -   Der Bestandteil `firma` kann entfallen, dann entfällt auch der
>     nachfolgende Punkt (`.`) und der Teil `domain` folgt direkt auf
>     das `@`-Zeichen.
> -   Der Bestandteil `domain` besteht aus 2 oder 3 Kleinbuchstaben.
>
> Hinweis: Sie dürfen keinen Oder-Operator verwenden.
>
> </details>

<a id="id-b7dfad1ad3e9e01252e54933152728b9552b3735"></a>

#### Annotationen

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Annotationen sind Metadaten zum Programm: Sie haben keinen (direkten)
> Einfluss auf die Ausführung des annotierten Codes, sondern enthalten
> Zusatzinformationen über ein Programm, die selbst nicht Teil des
> Programms sind. Verschiedene Tools werten Annotationen aus,
> beispielsweise der Compiler, Javadoc, JUnit, ...
>
> Annotationen können auf Deklarationen (Klassen, Felder, Methoden)
> angewendet werden und werden meist auf eine eigene Zeile geschrieben
> (Konvention).
>
> Annotationen können relativ einfach selbst erstellt werden: Die
> Definition ist fast wie bei einem Interface. Zusätzlich kann man noch
> über Meta-Annotationen die Sichtbarkeit, Verwendbarkeit und
> Dokumentation einschränken. Annotationen können zur Übersetzungszeit
> mit einem Annotation-Processor verarbeitet werden oder zur Laufzeit
> über Reflection ausgewertet werden.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Annotationen](https://youtu.be/7u4_I4W_1JY)
> -   [Demo Annotationen: `@Override`,
>     `@Deprecated`](https://youtu.be/wt-Dq_Nv5UU)
> -   [Demo `@NotNull`](https://youtu.be/ayWWf_ALObs)
> -   [Demo Annotationen selbst gebastelt](https://youtu.be/8vTMgYCstLE)
> -   [Demo Annotation-Prozessor](https://youtu.be/ypHMxunNZpg)
>
> </details>

##### Was passiert hier?

``` java
public class A {
    public String getInfo() { return "Klasse A"; }
}

public class B extends A {
    public String getInfo(String s) { return s + "Klasse B"; }

    public static void main(String[] args) {
        B s = new B();
        System.out.println(s.getInfo("Info: "));
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/annotations/B.java">Beispiel: annotations.B</a></p>

**Hilft `@Override`?**

Tja, da sollte wohl die Methode `B#getInfo` die geerbte Methode
`A#getInfo` **überschreiben**. Dummerweise wird hier die Methode aber
nur **überladen** (mit entsprechenden Folgen beim Aufruf)!

Ein leider relativ häufiges Versehen, welches u.U. schwer zu finden ist.
Annotationen (hier `@Override`) können dagegen helfen - der Compiler
"weiß" dann, dass wir überschreiben wollen und meckert, wenn wir das
nicht tun.

IDEs wie Eclipse können diese Annotation bereits beim Erstellen einer
Klasse generieren:
`Preferences > Java > Code Style > Add @Override annotation ...`.

##### Annotationen: Metadaten für Dritte

-   **Zusatzinformationen** für Tools, Bibliotheken, ...
-   Kein direkter Einfluss auf die Ausführung des annotierten Codes

<!-- -->

-   Beispiele:
    -   Compiler (JDK): `@Override`, `@Deprecated`, ...
    -   Javadoc: `@author`, `@version`, `@see`, `@param`, `@return`, ...
    -   JUnit: `@Test`, `@Before`, `@BeforeClass`, `@After`,
        `@AfterClass`
    -   [IntelliJ](https://www.jetbrains.com/help/idea/annotating-source-code.html#jetbrains-annotations):
        `@NotNull`, `@Nullable`
    -   [Checker
        Framework](https://github.com/typetools/checker-framework):
        `@NonNull`, `@Nullable`, ...
    -   [Project Lombok](https://github.com/projectlombok/lombok):
        `@Getter`, `@Setter`, `@NonNull`, ...
    -   Webservices: `@WebService`, `@WebMethod`
    -   ...

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/annotations/B.java">Demo: annotations.B: @Override, @Deprecated</a></p>

Jetzt schauen wir uns erst einmal die Auswirkungen von `@Override` und
`@Deprecated` auf den Compiler (via Eclipse) an. Anschließend lernen Sie
die Dokumentation mittels Javadoc-Annotationen kennen.

Das Thema JUnit ist in einer anderen VL dran. Webservices ereilen Sie
dann in späteren Semestern :-)

###### @Override

Die mit `@Override` annotierte Methode überschreibt eine Methode aus der
Oberklasse oder implementiert eine Methode einer Schnittstelle. Dies
wird durch den Compiler geprüft und ggf. mit einer Fehlermeldung
quittiert.

`@Override` ist eine im JDK im Paket `java.lang` enthaltene Annotation.

###### @Deprecated

Das mit `@Deprecated` markierte Element ist veraltet ("*deprecated*")
und sollte nicht mehr benutzt werden. Typischerweise werden so markierte
Elemente in zukünftigen Releases aus der API entfernt ...

Die Annotation `@Deprecated` wird direkt im Code verwendet und
entspricht der Annotation `@deprecated` im Javadoc. Allerdings kann
letzteres nur von Javadoc ausgewertet werden.

`@Deprecated` ist eine im JDK im Paket `java.lang` enthaltene
Annotation.

###### Weitere Annotationen aus *java.lang*

Im Paket `java.lang` finden sich weitere Annotationen. Mit Hilfe von
`@SuppressWarnings` lassen sich bestimmte Compilerwarnungen unterdrücken
(**so etwas sollte man NIE tun!**), und mit `@FunctionalInterface`
lassen sich Schnittstellen auszeichnen, die genau eine (abstrakte)
Methode besitzen (Verweis auf spätere Vorlesung).

Weitere Annotationen aus dem JDK finden sich in den Paketen
`java.lang.annotation` und `javax.annotation`.

##### Dokumentation mit Javadoc

``` java
/**
 * Beschreibung Beschreibung Beschreibung
 *
 * @param date Tag, Wert zw. 1 .. 31
 * @return true, falls Datum gesetzt wurde; false sonst
 * @see java.util.Calendar
 * @deprecated As of JDK version 1.1
 */
public boolean setDate(int date) {
    setField(Calendar.DATE, date);
}
```

Die Dokumentation mit Javadoc hatten wir uns bereits in der Einheit
["Javadoc"](#id-1a29f4d878c0dfd2692190d1ba8be56516408629) angesehen.

Hier noch einmal exemplarisch die wichtigsten Elemente, die an
"`public`" sichtbaren Methoden verwendet werden.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/annotations/B.java">Beispiel: annotations.B (Javadoc)</a></p>

##### @NotNull mit IntelliJ

[IntelliJ](https://www.jetbrains.com/help/idea/annotating-source-code.html)
bietet im Paket `org.jetbrains.annotations` u.a. die Annotation
`@NotNull` an.

Damit lassen sich Rückgabewerte von Methoden sowie Variablen (Attribute,
lokale Variablen, Parameter) markieren: Diese dürfen nicht `null`
werden.

IntelliJ prüft beim Compilieren, dass diese Elemente nicht `null` werden
und warnt gegebenenfalls (zur Compilezeit). Zusätzlich baut IntelliJ
entsprechende Assertions in den Code ein, die zur Laufzeit einen
`null`-Wert abfangen und dann das Programm abbrechen.

Dadurch können entsprechende Dokumentationen im Javadoc und/oder
manuelle Überprüfungen im Code entfallen. Außerdem hat man durch die
Annotation gewissermaßen einen sichtbaren Vertrag (*Contract*) mit den
Nutzern der Methode. Bei einem Aufruf mit `null` würde dieser Contract
verletzt und eine entsprechende Exception geworfen (automatisch) statt
einfach das Programm und die JVM "abzuschießen".

Nachteil: Die entsprechende Bibliothek muss bei allen Entwicklern
vorhanden und in das Projekt eingebunden sein.

``` java
/* o should not be null */
public void bar(Object o) {
    int i;
    if (o != null) {
        i = o.hashCode();
    }
}
```

``` java
/* o must not be null */
public void foo(@NotNull Object o) {
    // assert(o != null);  //  Wirkung (von IntelliJ eingefügt)
    int i = o.hashCode();
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/annotations/WuppieAnnotation.java">Demo: annotations.WuppieAnnotation: @NotNull</a></p>

###### IntelliJ inferiert mit @NotNull mögliche *null*-Werte

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/java-classic/images/screenshot_infer-notnull.png"  /></p>

###### IntelliJ baut bei @NotNull passende Assertions ein

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/java-classic/images/screenshot_nullpointerexception-notnull.png"  /></p>

##### Eigene Annotationen erstellen

In Java kann man sich selbst Annotationen definieren mit dem
Schlüsselwort `@interface`.

Annotationen können Parameter bekommen und im Javadoc dokumentiert sein.
Es gibt die Möglichkeit zu definieren, wo im Code die eigenen
Annotationen verwendet werden dürfen (Auszeichnung mit der Annotation
`@Target`). Ebenso kann über die Annotation `@Retention` festgelegt
werden, wann im Verarbeitungsprozess der Java-Sourcen bzw. des
-Bytecodes die eigenen Annotationen sichtbar sein sollen.

``` java
public @interface MyFirstAnnotation {}

public @interface MyThirdAnnotation {
    String author();

    int vl() default 1;
}

@MyFirstAnnotation
@MyThirdAnnotation(author = "Carsten Gips", vl = 3)
public class C {}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/annotations/C.java">Demo: annotations.C</a></p>

###### Definition einer Annotation

Definition einer Annotation wie Interface, aber mit "`@`"-Zeichen vor
dem `interface`-Schlüsselwort

###### Parameter für Annotation

Parameter für Annotation werden über entsprechende Methoden-Deklaration
realisiert

-   "Rückgabetyp" der deklarierten "Methode" ist der erlaubte Typ der
    später verwendeten Parameter

-   Name der "Methoden" wird bei der Belegung der Parameter verwendet,
    beispielsweise `author = ...`

-   Vereinfachung: "Methodenname" `value` erlaubt das Weglassen des
    Schlüsselworts bei der Verwendung:

    ``` java
    public @interface MySecondAnnotation {
        String value();
    }

    @MySecondAnnotation("wuppie")
    public class D {}

    @MySecondAnnotation(value = "wuppie")
    public class E {}
    ```

-   Defaultwerte mit dem nachgestellten Schlüsselwort `default` sowie
    dem Defaultwert selbst

###### Dokumentation der Annotation mit/im Javadoc

Soll die Annotation in der Javadoc-Doku dargestellt werden, muss sie mit
der Meta-Annotation `@Documented` ausgezeichnet werden (aus
`java.lang.annotation.Documented`)

*Hinweis*: Die Annotation wird lediglich in die Doku aufgenommen, d.h.
es erfolgt keine weitere Verarbeitung oder Hervorhebung o.ä.

###### Wann ist eine Annotation sichtbar (Beschränkung der Sichtbarkeit mit `@Retention`)

Annotationen werden vom Compiler und/oder anderen Tools ausgewertet. Man
kann entsprechend die Sichtbarkeit einer Annotation beschränken: Sie
kann ausschließlich im Source-Code verfügbar sein, sie kann in der
generierten Class-Datei eingebettet sein oder sie kann sogar zur
Laufzeit (mittels *Reflection*, vgl. spätere Vorlesung) ausgelesen
werden.

Beschränkung der Sichtbarkeit: Meta-Annotation `@Retention` aus
`java.lang.annotation.Retention`

-   `RetentionPolicy.SOURCE`: Nur Bestandteil der Source-Dateien, wird
    nicht in kompilierten Code eingebettet
-   `RetentionPolicy.CLASS`: Wird vom Compiler in die Class-Datei
    eingebettet, steht aber zur Laufzeit *nicht* zur Verfügung
    (Standardwert, wenn nichts angegeben)
-   `RetentionPolicy.RUNTIME`: Wird vom Compiler in die Class-Datei
    eingebettet und steht zur Laufzeit zur Verfügung und kann via
    *Reflection*[^7] ausgelesen werden

Ohne explizite Angabe gilt für die selbst definierte Annotation die
Einstellung `RetentionPolicy.CLASS`.

###### Wo darf eine Annotation verwendet werden

####### Anwendungsmöglichkeiten von Annotationen im Code

``` java
@ClassAnnotation
public class Wuppie {
    @InstanceFieldAnnotation
    private String foo;

    @ConstructorAnnotation
    public Wuppie() {}

    @MethodAnnotation1
    @MethodAnnotation2
    @MethodAnnotation3
    public void fluppie(@ParameterAnnotation final Object arg1) {
        @VariableAnnotation
        final String bar = (@TypeAnnotation String) arg1;
    }
}
```

####### Einschränkung des Einsatzes eines Annotation mit `@Target`

Für jede Annotation kann eingeschränkt werden, wo (an welchen
Java-Elementen) sie verwendet werden darf.

Beschränkung der Verwendung: Meta-Annotation `@Target` aus
`java.lang.annotation.Target`

-   `ElementType.TYPE`: alle Typdeklarationen: Klassen, Interfaces,
    Enumerations, ...
-   `ElementType.CONSTRUCTOR`: nur Konstruktoren
-   `ElementType.METHOD`: nur Methoden
-   `ElementType.FIELD`: nur statische Variablen und Objektvariablen
-   `ElementType.PARAMETER`: nur Parametervariablen
-   `ElementType.PACKAGE`: nur an Package-Deklarationen

Ohne explizite Angabe ist die selbst definierte Annotation für alle
Elemente verwendbar.

##### Annotationen beim Compilieren bearbeiten: Java Annotation-Prozessoren

Der dem `javac`-Compiler vorgelegte Source-Code wird eingelesen und in
einen entsprechenden Syntax-Tree (*AST*) transformiert (dazu mehr im
Modul "Compilerbau" :)

Anschließend können sogenannte "Annotation Processors" über den AST
laufen und ihre Analysen machen und/oder den AST modifizieren. (Danach
kommen die üblichen weiteren Analysen und die Code-Generierung.)

(Vgl. [OpenJDK: Compilation
Overview](https://openjdk.java.net/groups/compiler/doc/compilation-overview/index.html).)

An dieser Stelle kann man sich einklinken und einen eigenen
Annotation-Prozessor ausführen lassen. Zur Abgrenzung: Diese Auswertung
der Annotationen findet zur **Compile-Zeit** statt! In einer späteren
Vorlesung werden wir noch über die Auswertung zur **Laufzeit** sprechen:
*Reflection*.

Im Prinzip muss man lediglich das Interface
`javax.annotation.processing.Processor` implementieren oder die
abstrakte Klasse `javax.annotation.processing.AbstractProcessor`
erweitern. Für die Registrierung im `javac` muss im Projekt (oder
Jar-File) die Datei
`META-INF/services/javax.annotation.processing.Processor` angelegt
werden, die den vollständigen Namen des Annotation-Prozessors enthält.
Dieser Annotation-Prozessor wird dann vom `javac` aufgerufen und läuft
in einer eigenen JVM. Er kann die Annotationen, für die er registriert
ist, auslesen und verarbeiten und neue Java-Dateien schreiben, die
wiederum eingelesen und compiliert werden.

Im nachfolgenden Beispiel beschränke ich mich auf das Definieren und
Registrieren eines einfachen Annotation-Prozessors, der lediglich die
Annotationen liest.

``` java
@SupportedAnnotationTypes("annotations.MySecondAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class Foo extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> as, RoundEnvironment re) {
        for (TypeElement annot : as) {
            for (Element el : re.getElementsAnnotatedWith(annot)) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE,
                    "found @MySecondAnnotation at " + el);
            }
        }
        return true;
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/java-classic/src/META-INF/">Demo: annotations.C und annotations.Foo, META-INF</a></p>

1.  Der Annotation-Processor sollte von `AbstractProcessor` ableiten
2.  Über `@SupportedAnnotationTypes` teilt man mit, für welche
    Annotationen sich der Prozessor interessiert (d.h. für welche er
    aufgerufen wird); "`*`" oder eine Liste mit String ist auch möglich
3.  Mit `@SupportedSourceVersion` wird die (höchste) unterstützte
    Java-Version angegeben (neuere Versionen führen zu einer Warnung)
4.  Die Methode `process` erledigt die Arbeit:
    -   Der erste Parameter enthält alle gefundenen Annotationen, für
        die der Processor registriert ist
    -   Der zweite Parameter enthält die damit annotierten Elemente
    -   Iteration: Die äußere Schleife läuft über alle gefundenen
        Annotationen, die innere über die mit der jeweiligen Annotation
        versehenen Elemente
    -   Jetzt könnte man mit den Elementen etwas sinnvolles anfangen,
        beispielsweise alle Attribute sammeln, die mit `@Getter`
        markiert sind und für diese neuen Code generieren
    -   Im Beispiel wird lediglich der eigene Logger
        (`processingEnv.getMessager()`) aufgerufen, um beim
        Compiliervorgang eine Konsolenmeldung zu erzeugen ...
5.  Der Annotation-Processor darf keine Exception werfen, da sonst der
    Compiliervorgang abgebrochen würde. Zudem wäre der Stack-Trace der
    des Annotation-Processors und nicht der des compilierten Programms
    ... Stattdessen wird ein Boolean zurückgeliefert, um anzudeuten, ob
    die Verarbeitung geklappt hat.

Für ein umfangreicheres Beispiel mit Code-Erzeugung vergleiche
beispielsweise die Artikelserie unter
[cloudogu.com/en/blog/Java-Annotation-Processors_1-Intro](https://cloudogu.com/en/blog/Java-Annotation-Processors_1-Intro).
Siehe auch [OpenJDK: Compilation
Overview](https://openjdk.java.net/groups/compiler/doc/compilation-overview/index.html).

Im Projekt muss jetzt noch der Ordner `META-INF/services/` angelegt
werden mit der Datei `javax.annotation.processing.Processor`. Deren
Inhalt ist für das obige Beispiel die Zeile `annotations.Foo`. Damit ist
der Annotation-Processor `annotations.Foo` für das Übersetzen im eigenen
Projekt registriert.

Zum Compilieren des Annotation-Processors selbst ruft man beispielsweise
folgenden Befehl auf:

    javac -cp . -proc:none annotations/Foo.java

Die Option `-proc:none` sorgt für das Beispiel dafür, dass beim
Compilieren des Annotation-Processors dieser nicht bereits aufgerufen
wird (was sonst wg. der Registrierung über
`META-INF/services/javax.annotation.processing.Processor` passieren
würde).

Zum Compilieren der Klasse `C` kann man wie sonst auch den Befehl
nutzen:

    javac -cp . annotations/C.java

Dabei läuft dann der Annotation-Processor `annotations.Foo` und erzeugt
beim Verarbeiten von `annotations.C` die folgende Ausgabe:

    Note: found @MySecondAnnotation at main(java.lang.String[])

##### Wrap-Up

-   Annotationen: Metadaten zum Programm

    -   **Zusatzinformationen** über ein Programm, aber nicht selbst
        Teil des Programms
    -   **Kein (direkter) Einfluss** auf die **Ausführung** des
        annotierten Codes

<!-- -->

-   Typische Anwendungen: Compiler-Hinweise, Javadoc, Tests

    -   Compiler: Erkennen von logischen Fehlern, Unterdrücken von
        Warnungen =\> `java.lang`: `@Override`, `@Deprecated`,
        `@SuppressWarnings`
    -   Javadoc: Erkennen von Schlüsselwörtern (`@author`, `@return`,
        `@param`, ...)
    -   JUnit: Erkennen von Tests-Methoden (`@Test`)
    -   ...

<!-- -->

-   Annotationen können auf Deklarationen (Klassen, Felder, Methoden)
    angewendet werden
-   Annotationen können relativ einfach selbst erstellt werden
    -   Definition fast wie ein Interface
    -   Einstellung der Sichtbarkeit und Verwendbarkeit und
        Dokumentation über Meta-Annotationen
-   Verarbeitung von Annotationen zur Compilier-Zeit mit
    Annotation-Processor
-   Verarbeitung von Annotationen zur Laufzeit mit Reflection (siehe
    spätere VL)

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Ullenboom ([2021, 10.8](#ref-Ullenboom2021) und 23.4)
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
> -   Oracle Corporation ([2026](#ref-LernJava))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kann den Begriff der 'Annotation' erklären an einem
>     Beispiel
> -   k3: Ich kann `@Override` und auch die Javadoc-Annotationen
>     praktisch anwenden
> -   k3: Ich kann eigene Annotationen erstellen und dabei die
>     Sichtbarkeit und Verwendbarkeit einstellen
> -   k3: Ich kann einen eigenen einfachen Annotation-Processors
>     erstellen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> Schreiben Sie drei eigene Annotationen:
>
> -   `@MeineKlasse` darf nur an Klassendefinitionen stehen und
>     speichert den Namen des Autoren ab.
> -   `@MeineMethode` darf nur an Methoden stehen.
> -   `@TODO` darf an Methoden und Klassen stehen, ist aber nur in den
>     Source-Dateien sichtbar.
>
> Implementieren Sie einen Annotation-Prozessor, welcher Ihren Quellcode
> nach der `@MeineKlasse`-Annotation durchsucht und dann den Namen der
> Klasse und den Namen des Autors ausgibt.
>
> Zeigen Sie die Funktionen anhand einer Demo.
> </details>

<a id="id-359cf00c9c9fee1016f00310e99654e8f237b413"></a>

#### Generics: Generische Klassen & Methoden

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Generische Klassen und Methoden sind ein wichtiger Baustein in der
> Programmierung mit Java. Dabei werden Typ-Variablen eingeführt, die
> dann bei der Instantiierung der generischen Klassen oder beim Aufruf
> von generischen Methoden mit existierenden Typen konkretisiert werden
> ("Typ-Parameter").
>
> Syntaktisch definiert man die Typ-Variablen in spitzen Klammern hinter
> dem Klassennamen bzw. vor dem Rückgabetyp einer Methode:
> `public class Stack<E> { }` und `public <T> T foo(T m) { }`.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Generische Klassen & Methoden](https://youtu.be/k6MFPW-shh8)
> -   [Demo Generische Methoden](https://youtu.be/ekXBXge6VvE)
>
> </details>

##### Generische Strukturen

``` java
Vector speicher = new Vector();
speicher.add(1); speicher.add(2); speicher.add(3);
speicher.add("huhu");

int summe = 0;
for (Object i : speicher) { summe += (Integer)i; }
```

Problem: Nutzung des "*raw*" Typs `Vector` ist nicht typsicher!

-   Mögliche Fehler fallen erst zur Laufzeit und u.U. erst sehr spät
    auf: Offenbar werden im obigen Beispiel `int`-Werte erwartet, d.h.
    das Hinzufügen von `"huhu"` ist vermutlich ein Versehen (wird vom
    Compiler aber nicht bemerkt)
-   Die Iteration über `speicher` kann nur allgemein als `Object`
    erfolgen, d.h. in der Schleife muss auf den vermuteten/gewünschten
    Typ gecastet werden: Hier würde dann der String `"huhu"` Probleme
    zur Laufzeit machen

``` java
Vector<Integer> speicher = new Vector<Integer>();
speicher.add(1); speicher.add(2); speicher.add(3);
speicher.add("huhu");

int summe = 0;
for (Integer i : speicher) { summe += i; }
```

Vorteile beim Einsatz von Generics:

-   Datenstrukturen/Algorithmen nur einmal implementieren, aber für
    unterschiedliche Typen nutzen
-   Keine Vererbungshierarchie nötig
-   Nutzung ist typsicher, Casting unnötig
-   Geht nur für Referenztypen
-   Beispiel: Collections-API

##### Generische Klassen/Interfaces definieren

-   **Definition**: "`<Typ>`" hinter Klassennamen

    ``` java
    public class Stack<E> {
        public E push(E item) {
            addElement(item);
            return item;
        }
    }
    ```

    -   `Stack<E>` =\> Generische (parametrisierte) Klasse (auch:
        "*generischer Typ*")
    -   `E` =\> Formaler Typ-Parameter (auch: "*Typ-Variable*")

<!-- -->

-   **Einsatz**:

    ``` java
    Stack<Integer> stack = new Stack<Integer>();
    ```

    -   `Integer` =\> Typ-Parameter
    -   `Stack<Integer>` =\> Parametrisierter Typ

##### Generische Klassen instantiieren

-   Typ-Parameter in spitzen Klammern hinter Klasse bzw. Interface

    ``` java
    ArrayList<Integer> il = new ArrayList<Integer>();
    ArrayList<Double>  dl = new ArrayList<Double>();
    ```

##### Beispiel I: Einfache generische Klassen

``` java
class Tutor<T> {
    // T kann in Tutor *fast* wie Klassenname verwendet werden
    private T x;
    public T foo(T t) { ... }
}
```

``` java
Tutor<String>  a = new Tutor<String>();
Tutor<Integer> b = new Tutor<>();  // ab Java7: "Diamond Operator"

a.foo("wuppie");
b.foo(1);
b.foo("huhu");  // Fehlermeldung vom Compiler
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/classes/GenericClasses.java">Beispiel: classes.GenericClasses</a></p>

###### Typ-Inferenz

Typ-Parameter kann bei `new()` auf der rechten Seite oft weggelassen
werden =\> **Typ-Inferenz**

``` java
Tutor<String> x = new Tutor<>();  // <>: "Diamantoperator"
```

(gilt seit Java 1.7)

##### Beispiel II: Vererbung mit Typparametern

``` java
interface Fach<T1, T2> {
    public void machWas(T1 a, T2 b);
}

class SHK<T> extends Tutor<T> { ... }

class PM<X, Y, Z> implements Fach<X, Z> {
    public void machWas(X a, Z b) { ... }
    public Y getBla() { ... }
}

class Studi<A,B> extends Person { ... }
class Properties extends Hashtable<Object,Object> { ... }
```

Auch Interfaces und abstrakte Klassen können parametrisierbar sein.

Bei der Vererbung sind alle Varianten bzgl. der Typ-Variablen denkbar.
Zu beachten ist dabei vor allem, dass die Typ-Variablen der Oberklasse
(gilt analog für Interfaces) entweder durch Typ-Variablen der
Unterklasse oder durch konkrete Typen spezifiziert sind. Die
Typ-Variablen der Oberklasse dürfen nicht "in der Luft hängen" (siehe
auch nächste Folie)!

##### Beispiel III: Überschreiben/Überladen von Methoden

``` java
class Mensch { ... }

class Studi<T extends Mensch> {
    public void f(T t) { ... }
}

class Prof<T> extends Mensch { ... }

class Tutor extends Studi<Mensch> {
    public void f(Mensch t) { ... }      // Ueberschreiben
    public void f(Tutor t) { ... }       // Ueberladen
}
```

##### Vorsicht: So geht es nicht!

``` java
class Foo<T> extends T { ... }

class Fluppie<T> extends Wuppie<S> { ... }
```

-   Generische Klasse `Foo<T>` kann nicht selbst vom Typ-Parameter `T`
    ableiten (warum?)
-   Bei Ableiten von generischer Klasse `Wuppie<S>` muss deren
    Typ-Parameter `S` bestimmt sein: etwa durch den Typ-Parameter der
    ableitenden Klasse, beispielsweise `Fluppie<S>` (statt `Fluppie<T>`)

##### Generische Methoden definieren

-   "`<Typ>`" vor Rückgabetyp

    ``` java
    public class Mensch {
        public <T> T myst(T m, T n) {
            return Math.random() > 0.5 ? m : n;
        }
    }
    ```

<!-- -->

-   "Mischen possible":

    ``` java
    public class Mensch<E> {
        public <T> T myst(T m, T n) { ... }
        public String myst(String m, String n) { ... }
    }
    ```

##### Aufruf generischer Methoden

###### Aufruf

-   Aufruf mit Typ-Parameter vor Methodennamen, oder
-   Inferenz durch Compiler

###### Finden der richtigen Methode durch den Compiler

1.  Zuerst Suche nach exakt passender Methode,
2.  danach passend mit Konvertierungen =\> Compiler sucht gemeinsame
    Oberklasse in Typhierarchie

###### Beispiel

``` java
class Mensch {
    <T> T myst(T m, T n) { ... }
}
Mensch m = new Mensch();


m.<String>myst("Essen", "lecker");  // Angabe Typ-Parameter


m.myst("Essen", 1);          // String, Integer => T: Object
m.myst("Essen", "lecker");   // String, String  => T: String
m.myst(1.0, 1);              // Double, Integer => T: Number
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/methods/GenericMethods.java">Beispiel methods.GenericMethods</a></p>

Reihenfolge der Suche nach passender Methode gilt auch für
nicht-generisch überladene Methoden

``` java
class Mensch {
    public <T> T myst(T m, T n) {
        System.out.println("X#myst: T");
        return m;
    }

    // NICHT gleichzeitig erlaubt wg. Typ-Löschung (s.u.):
/*
    public <T1, T2> T1 myst(T1 m, T2 n) {
        System.out.println("X#myst: T");
        return m;
    }
*/

    public String myst(String m, String n) {
        System.out.println("X#myst: String");
        return m;
    }

    public int myst(int m, int n) {
        System.out.println("X#myst: int");
        return m;
    }
}


public class GenericMethods {
    public static void main(String[] args) {
        Mensch m = new Mensch();

        m.myst("Hello World", "m");
        m.myst("Hello World", 1);
        m.myst(3, 4);
        m.myst(m, m);
        m.<Mensch>myst(m, m);
        m.myst(m, 1);
        m.myst(3.0, 4);
        m.<Double>myst(3, 4);
    }
}
```

##### Wrap-Up

-   Begriffe:
    -   Generischer Typ: `Stack<T>`
    -   Formaler Typ-Parameter: `T`
    -   Parametrisierter Typ:`Stack<Long>`
    -   Typ-Parameter: `Long`
    -   Raw Type: `Stack`

<!-- -->

-   Generische Klassen: `public class Stack<E> { }`
    -   "`<Typ>`" hinter Klassennamen

<!-- -->

-   Generische Methoden: `public <T> T foo(T m) { }`
    -   "`<Typ>`" vor Rückgabewert

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Ullenboom ([2021, 11.1](#ref-Ullenboom2021))
> -   Oracle Corporation ([2026](#ref-LernJava))
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
> -   Bloch ([2018](#ref-Bloch2018))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k1: Ich kenne die Begriffe 'generischer Typ', 'parametrisierter
>     Typ', 'formaler Typ-Parameter', 'Typ-Parameter'
> -   k3: Ich kann generische Klassen und Interfaces definieren und
>     praktisch einsetzen
> -   k3: Ich kann generische Methoden definieren und praktisch
>     einsetzen
>
> </details>

<a id="id-b5a72bc0878f8a0c3efaa1126dc28bfb1261adfb"></a>

#### Generics: Bounds & Wildcards

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Typ-Variablen können weiter eingeschränkt werden, in dem man einen
> verpflichtenden Ober- oder Untertyp angibt mit `extends` bzw. `super`.
> Damit muss der später bei der Instantiierung verwendete Typ-Parameter
> entweder die Oberklasse selbst sein oder davon ableiten (bei
> `extends`) bzw. der Typ-Parameter muss eine Oberklasse der angegebenen
> Schranke sein (`super`).
>
> Durch die Einschränkung mit `extends` können in der Klasse/Methode auf
> der Typ-Variablen alle Methoden des angegebenen Obertyps verwendet
> werden.
>
> Ein Wildcard (`?`) als Typ-Parameter steht für einen beliebigen Typ,
> wobei die Typ-Variable keinen Namen bekommt und damit innerhalb der
> Klasse/Methode nicht zugreifbar ist.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Generics: Bounds & Wildcards](https://youtu.be/OV2vEn2EkWo)
> -   [Demo Wildcards](https://youtu.be/D2hIicsho7I)
>
> </details>

##### Bounds: Einschränken der generischen Typen

``` java
public class Cps<E extends Number> {
    // Obere Schranke: E muss Number oder Subklasse sein
    // => Zugriff auf Methoden aus Number moeglich
}
Cps<Double> a;
Cps<Number> b;
Cps<String> c;  // Fehler!!!
```

-   Schlüsselwort `extends` gilt hier auch für Interfaces

-   Mehrere Interfaces: nach `extends` Klasse oder Interface, danach mit
    "`&`" getrennt die restlichen Interfaces:

    ``` java
    class Cps<E extends KlasseOderInterface & I1 & I2 & I3> {}
    ```

*Anmerkung*: Der Typ-Parameter ist analog auch mit `super` (nach unten)
einschränkbar

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/bounds/Cps.java">Beispiel bounds.Cps</a></p>

##### Wildcards: Dieser Typ ist mir nicht so wichtig

<div align="center">

Wildcard mit "`?`" =\> steht für unbestimmten Typ

</div>

``` java
public class Wuppie {
    public void m1(List<?> a) { ... }
    public void m2(List<? extends Number> b) { ... }
}
```

-   `m1`: `List` beliebig parametrisierbar =\> In `m1` für Objekte in
    Liste `a` nur Methoden von `Object` nutzbar!

-   `m2`: `List` muss mit `Number` oder Subklasse parametrisiert werden.
    =\> Dadurch für Objekte in Liste `b` alle Methoden von `Number`
    nutzbar ...

Weitere Eigenschaften:

-   Durch Wildcard kein Zugriff auf den Typ
-   Wildcard kann durch upper bound eingeschränkt werden
-   Geht nicht bei Klassen-/Interface-Definitionen

Bloch ([2018](#ref-Bloch2018)): Nur für Parameter und nicht für
Rückgabewerte nutzen!

##### Hands-On: Ausgabe für generische Listen

Ausgabe für Listen gesucht, die sowohl Elemente der Klasse `A` als auch
Elemente der Klasse `B` enthalten können

``` java
class A { void printInfo() { System.out.println("A"); } }
class B extends A { void printInfo() { System.out.println("B"); } }

public class X {
    public static void main(String[] args) {
        List<A> x = new ArrayList<A>();
        x.add(new A());  x.add(new B());
        printInfo(x);    // Klassenmethode in X, gesucht
        List<B> y = new ArrayList<B>();
        y.add(new B());  y.add(new B());
        printInfo(y);    // Klassenmethode in X, gesucht
    }
}
```

**Hinweis**: Dieses Beispiel beinhaltet auch Polymorphie bei/mit
generischen Datentypen, bitte vorher auch das Video zum vierten Teil
"Generics und Polymorphie" anschauen

###### Erster Versuch (*A* und *B* und *main()* wie oben)

``` java
public class X {
    public static void printInfo(List<A> list) {
        for (A a : list) { a.printInfo(); }
    }
}
```

=\> **So gehts nicht!** Eine `List<B>` ist **keine** `List<A>` (auch
wenn ein `B` ein `A` ist, vgl. spätere Sitzung zu Generics und Vererbung
...)!

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/wildcards/v1/X.java">Beispiel wildcards.v1.X</a></p>

###### Zweiter Versuch mit Wildcards (*A* und *B* und *main()* wie oben)

``` java
public class X {
    public static void printInfo(List<?> list) {
        for (Object a : list) { a.printInfo(); }
    }
}
```

=\> **So gehts auch nicht!** Im Prinzip passt das jetzt für `List<A>`
und `List<B>`. Dummerweise hat man durch das Wildcard keinen Zugriff
mehr auf den Typ-Parameter und muss für den Typ der Laufvariablen in der
`for`-Schleife dann `Object` nehmen. Aber `Object` kennt unser
`printInfo` nicht ... Außerdem könnte man die Methode `X#printInfo` dank
des Wildcards auch mit allen anderen Typen aufrufen ...

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/wildcards/v2/X.java">Beispiel wildcards.v2.X</a></p>

###### Dritter Versuch (Lösung) mit Wildcards und Bounds (*A* und *B* und *main()* wie oben)

``` java
public class X {
    public static void printInfo(List<? extends A> list) {
        for (A a : list) { a.printInfo(); }
    }
}
```

Das ist die Lösung. Man erlaubt als Argument nur `List`-Objekte und
fordert, dass sie mit `A` oder einer Unterklasse von `A` parametrisiert
sind. D.h. in der Schleife kann man sich auf den gemeinsamen Obertyp `A`
abstützen und hat dann auch wieder die `printInfo`-Methode zur Verfügung
...

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/java-classic/src/wildcards/v3">Konsole wildcards.v3.X</a></p>

##### Wrap-Up

-   Ein Wildcard (`?`) als Typ-Parameter steht für einen beliebigen Typ
    -   Ist in Klasse oder Methode dann aber nicht mehr zugreifbar

<!-- -->

-   Mit Bounds kann man Typ-Parameter nach oben oder nach unten
    einschränken (im Sinne einer Vererbungshierarchie)
    -   `extends`: Der Typ-Parameter muss eine Unterklasse eines
        bestimmten Typen sein
    -   `super`: Der Typ-Parameter muss eine Oberklasse eines bestimmten
        Typen sein

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Ullenboom ([2021, 11.3](#ref-Ullenboom2021))
> -   Oracle Corporation ([2026](#ref-LernJava))
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
> -   Bloch ([2018](#ref-Bloch2018))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k3: Ich kann Wildcards und Bounds bei generischen Klassen/Methoden
>     einsetzen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Spieler, Mannschaften und Ligen** Modellieren Sie in Java
> verschiedene Spielertypen sowie generische Mannschaften und Ligen, die
> jeweils bestimmte Spieler (-typen) bzw. Mannschaften aufnehmen können.
>
> 1.  Implementieren Sie die Klasse `Spieler`, die das Interface
>     `ISpieler` erfüllt.
>
>     ``` java
>     public interface ISpieler {
>         String getName();
>     }
>     ```
>
> 2.  Implementieren Sie die beiden Klassen `FussballSpieler` und
>     `BasketballSpieler` und sorgen Sie dafür, dass beide Klassen vom
>     Compiler als Spieler betrachtet werden (geeignete
>     Vererbungshierarchie).
>
> 3.  Betrachten Sie das nicht-generische Interface `IMannschaft`.
>     Erstellen Sie daraus ein generisches Interface `IMannschaft` mit
>     einer Typ-Variablen. Stellen Sie durch geeignete Beschränkung der
>     Typ-Variablen sicher, dass nur Mannschaften mit von `ISpieler`
>     abgeleiteten Spielern gebildet werden können.
>
>     ``` java
>     public interface IMannschaft {
>         boolean aufnehmen(ISpieler spieler);
>         boolean rauswerfen(ISpieler spieler);
>     }
>     ```
>
> 4.  Betrachten Sie das nicht-generische Interface `ILiga`. Erstellen
>     Sie daraus ein generisches Interface `ILiga` mit einer
>     Typvariablen. Stellen Sie durch geeignete Beschränkung der
>     Typvariablen sicher, dass nur Ligen mit von `IMannschaft`
>     abgeleiteten Mannschaften angelegt werden können.
>
>     ``` java
>     public interface ILiga {
>         boolean aufnehmen(IMannschaft mannschaft);
>         boolean rauswerfen(IMannschaft mannschaft);
>     }
>     ```
>
> 5.  Leiten Sie von `ILiga` das **generische** Interface `IBundesLiga`
>     ab. Stellen Sie durch geeignete Formulierung der Typvariablen
>     sicher, dass nur Ligen mit Mannschaften angelegt werden können,
>     deren Spieler vom Typ `FussballSpieler` (oder abgeleitet) sind.
>
>     Realisieren Sie nun noch die Funktionalität von `IBundesLiga` als
>     **nicht-generisches** Interface `IBundesLiga2`.
>
> </details>

<a id="id-74a1e4a0fe24c2ac4e4d580db16b6f832fb2d888"></a>

#### Generics: Type Erasure

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
> Generics existieren eigentlich nur auf Quellcode-Ebene. Nach der
> Typ-Prüfung etc. entfernt der Compiler alle generischen Typ-Parameter
> und alle `<...>` (=\> "Type-Erasure"), d.h. im Byte-Code stehen nur
> noch Raw-Typen bzw. die oberen Typ-Schranken der Typ-Parameter, in der
> Regel `Object`. Zusätzlich baut der Compiler die nötigen Casts ein.
> Als Anwender merkt man davon nichts, muss das "Type-Erasure" wegen der
> Auswirkungen aber auf dem Radar haben!
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Generics: Type Erasure](https://youtu.be/vo0WKkPBMAM)
>
> </details>

##### Typ-Löschung (*Type-Erasure*)

Der Compiler ersetzt nach Prüfung der Typen und ihrer Verwendung alle
Typ-Parameter durch

1.  deren obere (Typ-)Schranke und
2.  passende explizite Cast-Operationen (im Byte-Code).

Die obere Typ-Schranke ist in der Regel der Typ der ersten
Bounds-Klausel oder `Object`, wenn keine Einschränkungen formuliert
sind.

Bei parametrisierten Typen wie `List<T>` wird der Typ-Parameter
entfernt, es entsteht ein sogenannter *Raw*-Typ (`List`, quasi implizit
mit `Object` parametrisiert).

=\> Ergebnis: Nur **eine** (untypisierte) Klasse! Zur Laufzeit gibt es
keine Generics mehr!

**Hinweis**: In C++ ist man den anderen möglichen Weg gegangen und
erzeugt für jede Instantiierung die passende Klasse. Siehe Modul
"Systemprogrammierung" :)

**Beispiel**: Aus dem folgenden harmlosen Code-Fragment:

``` java
class Studi<T> {
    T myst(T m, T n) { return n; }

    public static void main(String[] args) {
        Studi<Integer> a = new Studi<>();
        int i = a.myst(1, 3);
    }
}
```

wird nach der Typ-Löschung durch Compiler (das steht dann quasi im
Byte-Code):

``` java
class Studi {
    Object myst(Object m, Object n) { return n; }

    public static void main(String[] args) {
        Studi a = new Studi();
        int i = (Integer) a.myst(1, 3);
    }
}
```

Die obere Schranke meist `Object` =\> `new T()` verboten/sinnfrei
(s.u.)!

##### Type-Erasure bei Nutzung von Bounds

vor der Typ-Löschung durch Compiler:

``` java
class Cps<T extends Number> {
    T myst(T m, T n) {
        return n;
    }

    public static void main(String[] args) {
        Cps<Integer> a = new Cps<>();
        int i = a.myst(1, 3);
    }
}
```

nach der Typ-Löschung durch Compiler:

``` java
class Cps {
    Number myst(Number m, Number n) {
        return n;
    }

    public static void main(String[] args) {
        Cps a = new Cps();
        int i = (Integer) a.myst(1, 3);
    }
}
```

##### Raw-Types: Ich mag meine Generics "well done" :-)

Raw-Types: Instanziierung ohne Typ-Parameter =\> `Object`

``` java
Stack s = new Stack(); // Stack von Object-Objekten
```

-   Wegen Abwärtskompatibilität zu früheren Java-Versionen noch erlaubt.
-   Nutzung wird nicht empfohlen! (Warum?)

###### Anmerkung

Raw-Types darf man zwar selbst im Quellcode verwenden (so wie im
Beispiel hier), **sollte** die Verwendung aber vermeiden wegen der
Typ-Unsicherheit: Der Compiler sieht im Beispiel nur noch einen Stack
für `Object`, d.h. dort dürfen Objekte aller Typen abgelegt werden - es
kann keine Typprüfung durch den Compiler stattfinden. Auf einem
`Stack<String>` kann der Compiler prüfen, ob dort wirklich nur
`String`-Objekte abgelegt werden und ggf. entsprechend Fehler melden.

Etwas anderes ist es, dass der Compiler im Zuge von Type-Erasure selbst
Raw-Types in den Byte-Code schreibt. Da hat er vorher bereits die
Typsicherheit geprüft und er baut auch die passenden Casts ein.

Das Thema ist eigentlich nur noch aus Kompatibilität zu Java5 oder
früher da, weil es dort noch keine Generics gab (wurden erst mit Java6
eingeführt).

##### Folgen der Typ-Löschung: *new*

<div align="center">

`new` mit parametrisierten Klassen ist nicht erlaubt!

</div>

``` java
class Fach<T> {
    public T foo() {
        return new T();  // nicht erlaubt!!!
    }
}
```

Grund: Zur Laufzeit keine Klasseninformationen über `T` mehr

Im Code steht `return (CAST) new Object();`. Das neue Object kann man
anlegen, aber ein Cast nach irgendeinem anderen Typ ist sinnfrei: Jede
Klasse ist ein Untertyp von `Object`, aber eben nicht andersherum.
Außerdem fehlt dem Objekt vom Typ `Object` auch sämtliche Information
und Verhalten, die der Cast-Typ eigentlich mitbringt ...

##### Folgen der Typ-Löschung: *static*

<div align="center">

`static` mit generischen Typen ist nicht erlaubt!

</div>

``` java
class Fach<T> {
    static T t;                    // nicht erlaubt!!!
    static Fach<T> c;              // nicht erlaubt!!!
    static void foo(T t) { ... };  // nicht erlaubt!!!
}

Fach<String>  a;
Fach<Integer> b;
```

Grund: Compiler generiert nur eine Klasse! Beide Objekte würden sich die
statischen Attribute teilen (Typ zur Laufzeit unklar!).

*Hinweis*: Generische (statische) Methoden sind erlaubt.

##### Folgen der Typ-Löschung: *instanceof*

<div align="center">

`instanceof` mit parametrisierten Klassen ist nicht erlaubt!

</div>

``` java
class Fach<T> {
    void printType(Fach<?> p) {
        if (p instanceof Fach<Number>)
            ...
        else if (p instanceof Fach<String>)
            ...
    }
}
```

Grund: Unsinniger Code nach Typ-Löschung:

``` java
class Fach {
void printType(Fach p) {
    if (p instanceof Fach)
        ...
    else if (p instanceof Fach)
        ...
    }
}
```

##### Folgen der Typ-Löschung: *.class*

<div align="center">

`.class` mit parametrisierten Klassen ist nicht erlaubt!

</div>

``` java
boolean x;
List<String>  a = new ArrayList<String>();
List<Integer> b = new ArrayList<Integer>();

x = (List<String>.class == List<Integer>.class);  // Compiler-Fehler
x = (a.getClass() == b.getClass());               // true
```

Grund: Es gibt nur `List.class` (und kein `List<String>.class` bzw.
`List<Integer>.class`)!

##### Wrap-Up

-   Generics existieren eigentlich nur auf Quellcode-Ebene
-   "Type-Erasure":
    -   Compiler entfernt nach Typ-Prüfungen etc. generische
        Typ-Parameter etc. =\> im Byte-Code nur noch Raw-Typen bzw. die
        oberen Typ-Schranken der Typ-Parameter, in der Regel `Object`
    -   Compiler baut passende Casts in Byte-Code ein
    -   Transparent für User; Auswirkungen beachten!

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Ullenboom ([2021, 12.2](#ref-Ullenboom2021) und 12.6)
> -   Oracle Corporation ([2026](#ref-LernJava))
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
> -   Bloch ([2018](#ref-Bloch2018))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich verstehe 'Typ-Löschung' bei Generics und kann die
>     Auswirkungen erklären
>
> </details>

<a id="id-4c89bee19163dac6a373bfc5c5b362e8ebe61ae3"></a>

#### Generics: Generics und Polymorphie

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Auch mit generischen Klassen stehen die Mechanismen Vererbung und
> Überladen zur Verfügung. Dabei muss aber beachtet werden, dass
> generische Klassen sich **"invariant"** verhalten: Der Typ selbst
> folgt der Vererbungsbeziehung, eine Vererbung des Typ-Parameters
> begründet *keine* Vererbungsbeziehung! D.h. aus `U extends O` folgt
> **nicht** `A<U> extends A<O>`.
>
> Bei Arrays ist es genau anders herum: Wenn `U extends O` dann gilt
> auch `U[] extends O[]` ... (Dies nennt man "*kovariantes*" Verhalten.)
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Generics und Polymorphie](https://youtu.be/RiTA43wTixQ)
>
> </details>

##### Generische Polymorphie

<div align="center">

`B<E> extends A<E>`

</div>

``` java
class A<E> { ... }
class B<E> extends A<E> { ... }

A<Double> ad = new B<Double>();
A<String> as = new B<String>();
```

``` java
class Vector<E> { ... }
class Stack<E> extends Vector<E> { ... }

Vector<Double> vd = new Stack<Double>();
Vector<String> vs = new Stack<String>();
```

=\> Polymorphie bei Generics bezieht sich auf **Typ** (nicht
Typ-Parameter)

**Invarianz**: Generics sind *invariant*, d.h. ein `HashSet<String>` ist
ein Untertyp von `Set<String>`. Bei der Vererbung muss der Typ-Parameter
identisch sein.

##### Polymorphie bei Generics bezieht sich nur auf Typ!

<div align="center">

"`B extends A`" **bedeutet nicht** "`C<B> extends C<A>`"

</div>

``` java
Stack<Number> s = new Stack<Integer>(); // DAS GEHT SO NICHT!

// Folgen (wenn obiges gehen wuerde):
s.push(new Integer(3)); // das ginge sowieso ...

// Folgen (wenn obiges gehen wuerde):
// Stack<Number> waere Oberklasse auch von Stack<Double>
s.push(new Double(2.0)); // waere dann auch erlaubt ...

// Das Objekt (Stack<Integer>) kann aber keine Double speichern!
// Zur Laufzeit keine Typ-Informationen mehr!
```

-   Typ-Löschung =\> zur Laufzeit keine Typinformationen vorhanden
-   Compiler muss Typen prüfen (können)!

##### Abgrenzung: Polymorphie bei Arrays

<div align="center">

Wenn "`B extends A`" dann "`B[] extends A[]`"

</div>

``` java
Object[] x = new String[] {"Hello", "World", ":-)"};
x[0] = "Hallo";
x[0] = new Double(2.0);  // Laufzeitfehler
String[] y = x;  // String[] ist KEIN Object[]!!!
```

-   Arrays besitzen Typinformationen über gespeicherte Elemente
-   Prüfung auf Typ-Kompatibilität zur **Laufzeit** (nicht
    Kompilierzeit!)

<p align="right"><a href="https://openbook.rheinwerk-verlag.de/javainsel/11_002.html#u11.2.2">Hinweis auf Java-Geschichte (Java-Insel: “Type Erasure”)</a></p>

Arrays gab es sehr früh, Generics erst relativ spät (ab Java6) =\> bei
Arrays fand man das Verhalten natürlich und pragmatisch (trotz der
Laufzeit-Überprüfung).

Bei der Einführung von Generics musste man Kompatibilität sicherstellen
(alter Code soll auch mit neuen Compilern übersetzt werden können -
obwohl im alten Code Raw-Types verwendet werden). Außerdem wollte man
von Laufzeit-Prüfung hin zu Compiler-Prüfung. Da würde das von Arrays
bekannte Verhalten Probleme machen ...

**Kovarianz**: Arrays sind *kovariant*, d.h. ein Array vom Typ
`String[]` ist wegen `String extends Object` ein Untertyp von
`Object[]`.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/arrays/X.java">Beispiel arrays.X</a></p>

##### Arrays vs. parametrisierte Klassen

=\> Keine Arrays mit parametrisierten Klassen!

``` java
Foo<String>[] x = new Foo<String>[2];   // Compilerfehler

Foo<String[]> y = new Foo<String[]>();  // OK :)
```

Arrays mit parametrisierten Klassen sind nicht erlaubt! Arrays brauchen
zur Laufzeit Typinformationen, die aber durch die Typ-Löschung entfernt
werden.

##### Diskussion Vererbung vs. Generics

**Vererbung:**

-   *IS-A*-Beziehung
-   Anwendung: Vererbungsbeziehung vorliegend, Eigenschaften verfeinern
-   Beispiel: Ein Student *ist eine* Person

**Generics:**

-   Schablone (Template) für viele Datentypen
-   Anwendung: Identischer Code für unterschiedliche Typen
-   Beispiel: Datenstrukturen, Algorithmen generisch realisieren

##### Wrap-Up

-   Generics: Vererbung und Überladen möglich, aber: Aus "`U extends O`"
    folgt **nicht** "`A<U> extends A<O>`"

<!-- -->

-   Achtung: Bei Arrays gilt aber: Wenn "`U extends O`" dann gilt auch
    "`U[] extends O[]`" ...

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Ullenboom ([2021, 11.5](#ref-Ullenboom2021))
> -   Oracle Corporation ([2026](#ref-LernJava))
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
> -   Bloch ([2018](#ref-Bloch2018))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k3: Ich kann Vererbungsbeziehungen mit generischen Klassen bilden
> -   k3: Ich kann mit Arrays und generischen Typen umgehen
>
> </details>

<a id="id-f6029a94ea1cbcba66e37c103b162b90e62bea1d"></a>

#### Threads: Einführung in die nebenläufige Programmierung mit Threads

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Threads sind weitere Kontrollflussfäden, die von der Java-VM (oder
> (selten) vom OS) verwaltet werden. Damit ist sind sie
> leichtgewichtiger als der Start neuer Prozesse direkt auf
> Betriebssystem-Ebene.
>
> Beim Start eines Java-Programms wird die `main()`-Methode automatisch
> in einem (Haupt-) Thread ausgeführt. Alle Anweisungen in einem Thread
> werden sequentiell ausgeführt.
>
> Um einen neuen Thread zu erzeugen, leitet man von `Thread` ab oder
> implementiert das Interface `Runnable`. Von diesen eigenen Klassen
> kann man wie üblich ein neues Objekt anlegen. Die Methode `run()`
> enthält dabei den im Thread auszuführenden Code. Um einen Thread als
> neuen parallelen Kontrollfluss zu starten, muss man die geerbte
> Methode `start()` auf dem Objekt aufrufen. Im Fall der Implementierung
> von `Runnable` muss man das Objekt zuvor noch in den Konstruktor von
> `Thread` stecken und so ein neues `Thread`-Objekt erzeugen, auf dem
> man dann `start()` aufrufen kann.
>
> Threads haben einen Lebenszyklus: Nach dem Erzeugen der Objekte mit
> `new` wird der Thread noch nicht ausgeführt. Durch den Aufruf der
> Methode `start()` gelangt der Thread in einen Zustand
> "ausführungsbereit". Sobald er vom Scheduler eine Zeitscheibe
> zugeteilt bekommt, wechselt er in den Zustand "rechnend". Von hier
> kann er nach Ablauf der Zeitscheibe durch den Scheduler wieder nach
> "ausführungsbereit" zurück überführt werden. Dieses Wechselspiel
> passiert automatisch und i.d.R. schnell, so dass selbst auf Maschinen
> mit nur einem Prozessor/Kern der Eindruck einer parallelen
> Verarbeitung entsteht. Nach Abarbeitung der `run()`-Methode wird der
> Thread beendet und kann nicht wieder neu gestartet werden. Bei Zugriff
> auf gesperrte Ressourcen oder durch `sleep()` oder `join()` kann ein
> Thread blockiert werden. Aus diesem Zustand gelangt er durch
> Interrupts oder nach Ablauf der Schlafzeit oder durch `notify` wieder
> zurück nach "ausführungsbereit".
>
> Die Thread-Objekte sind normale Java-Objekte. Man kann hier Attribute
> und Methoden haben und diese entsprechend zugreifen/aufrufen. Das
> klappt auch, wenn der Thread noch nicht gestartet wurde oder bereits
> abgearbeitet wurde.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Threads Intro](https://youtu.be/ClfXbNPRl_8)
> -   [Demo Threads Intro: Erzeugen von
>     Threads](https://youtu.be/zcVqFAx5D0E)
> -   [Demo Threads Intro: Arbeiten mit Threads
>     (`join()`)](https://youtu.be/lQ_JSHBGhdU)
>
> </details>

##### 42

<p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/java-classic/images/screenshot_swingworker.png" width="50%" /></p>

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/misc/SwingWorkerDemo.java">Demo: misc.SwingWorkerDemo (GUI ausprobieren)</a></p>

##### Einführung in nebenläufige Programmierung

###### Traditionelle Programmierung

-   Aufruf einer Methode verlagert Kontrollfluss in diese Methode
-   Code hinter Methodenaufruf wird erst **nach Beendigung** der Methode
    ausgeführt

``` java
public class Traditional {
    public static void main(String... args) {
        Traditional x = new Traditional();

        System.out.println("main(): vor run()");
        x.run();
        System.out.println("main(): nach run()");
    }

    public void run() {
        IntStream.range(0, 10).mapToObj(i -> "in run()").forEach(System.out::println);
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/intro/Traditional.java">Demo: intro.Traditional</a></p>

###### Nebenläufige Programmierung

-   Erzeugung eines neuen Kontrollflussfadens (Thread)
    -   **Läuft (quasi-) parallel zu bisherigem Kontrollfluss**
-   Threads können unabhängig von einander arbeiten
-   Zustandsverwaltung durch Java-VM (oder Unterstützung durch
    Betriebssystem)
    -   Aufruf einer bestimmten Methode erzeugt neuen Kontrollflussfaden
    -   Der neue Thread arbeitet "parallel" zum bisherigen Thread
    -   Kontrolle kehrt sofort wieder zurück: Code hinter dem
        Methodenaufruf wird ausgeführt ohne auf die Beendigung der
        aufgerufenen Methode zu warten
    -   Verteilung der Threads auf die vorhandenen Prozessorkerne
        abhängig von der Java-VM

``` java
public class Threaded extends Thread {
    public static void main(String... args) {
        Threaded x = new Threaded();

        System.out.println("main(): vor run()");
        x.start();
        System.out.println("main(): nach run()");
    }

    @Override
    public void run() {
        IntStream.range(0, 10).mapToObj(i -> "in run()").forEach(System.out::println);
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/intro/Threaded.java">Demo: intro.Threaded</a></p>

##### Erzeugen von Threads

-   Ableiten von `Thread` oder Implementierung von `Runnable`

    <p align="center"><img src="https://raw.githubusercontent.com/Programmiermethoden-CampusMinden/Prog2-Lecture/_s26/lecture/java-classic/images/ThreadRunnable.png" width="60%" /></p>

-   Methode `run()` implementieren, aber nicht aufrufen

-   Methode `start()` aufrufen, aber (i.d.R.) nicht implementieren

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/creation/">Demo: creation.*</a></p>

###### Ableiten von *Thread*

-   `start()` startet den Thread und sorgt für Ausführung von `run()`
-   `start()` nur einmal aufrufen

###### Implementierung von *Runnable*

-   Ebenfalls `run()` implementieren
-   Neues `Thread`-Objekt erzeugen, Konstruktor das eigene Runnable
    übergeben
-   Für Thread-Objekt die Methode `start()` aufrufen
    -   Startet den Thread (das Runnable) und sorgt für Ausführung von
        `run()`

Vorteil von `Runnable`: Ist ein Interface, d.h. man kann noch von einer
anderen Klasse erben

##### Zustandsmodell von Threads (vereinfacht)

Threads haben einen Lebenszyklus: Nach dem Erzeugen der Objekte mit
`new` wird der Thread noch nicht ausgeführt. Er ist sozusagen in einem
Zustand "erzeugt". Man kann bereits mit dem Objekt interagieren, also
auf Attribute zugreifen und Methoden aufrufen.

Durch den Aufruf der Methode `start()` gelangt der Thread in einen
Zustand "ausführungsbereit", er läuft also aus Nutzersicht. Allerdings
hat er noch keine Ressourcen zugeteilt (CPU, ...), so dass er
tatsächlich noch nicht rechnet. Sobald er vom Scheduler eine Zeitscheibe
zugeteilt bekommt, wechselt er in den Zustand "rechnend" und führt den
Inhalt der `run()`-Methode aus. Von hier kann er nach Ablauf der
Zeitscheibe durch den Scheduler wieder nach "ausführungsbereit" zurück
überführt werden. Dieses Wechselspiel passiert automatisch und i.d.R.
schnell, so dass selbst auf Maschinen mit nur einem Prozessor/Kern der
Eindruck einer parallelen Verarbeitung entsteht.

Nach der Abarbeitung der `run()`-Methode oder bei einer nicht gefangenen
Exception wird der Thread beendet und kann nicht wieder neu gestartet
werden. Auch wenn der Thread abgelaufen ist, kann man mit dem Objekt wie
üblich interagieren (nur eben nicht mehr parallel).

Bei Zugriff auf gesperrte Ressourcen oder durch Aufrufe von Methoden wie
`sleep()` oder `join()` kann ein Thread blockiert werden. Hier führt der
Thread nichts aus, bekommt durch den Scheduler aber auch keine neue
Zeitscheibe zugewiesen. Aus diesem Zustand gelangt der Thread wieder
heraus, etwa durch Interrupts (Aufruf der Methode `interrupt()` auf dem
Thread-Objekt) oder nach Ablauf der Schlafzeit (in `sleep()`) oder durch
ein `notify`, und wird wieder zurück nach "ausführungsbereit" versetzt
und wartet auf die Zuteilung einer Zeitscheibe durch den Scheduler.

Sie finden in ([Boles 2008, 5.2](#ref-Boles2008) "Thread-Zustände") eine
schöne ausführliche Darstellung.

###### Threads können wie normale Objekte kommunizieren

-   Zugriff auf (`public`) Attribute (oder eben über Methoden)
-   Aufruf von Methoden

###### Threads können noch mehr

-   Eine Zeitlang schlafen: `Thread.sleep(<duration_ms>)`

    -   Statische Methode der Klasse `Thread` (Klassenmethode)
    -   Aufrufender Thread wird bis zum Ablauf der Zeit oder bis zum
        Aufruf der `interrupt()`-Methode des Threads blockiert
    -   "Moderne" Alternative: `TimeUnit`, beispielsweise
        `TimeUnit.SECONDS.sleep( 2 );`

-   Prozessor abgeben und hinten in Warteschlange einreihen: `yield()`

-   Andere Threads stören: `otherThreadObj.interrupt()`

    -   Die Methoden `sleep()`, `wait()` und `join()` im empfangenden
        Thread `otherThreadObj` lösen eine `InterruptedException` aus,
        wenn sie durch die Methode `interrupt()` unterbrochen werden.
        Das heißt, `interrupt()` beendet diese Methoden mit der
        Ausnahme.
    -   Empfangender Thread verlässt ggf. den Zustand "blockiert" und
        wechselt in den Zustand "ausführungsbereit"

-   Warten auf das Ende anderer Threads: `otherThreadObj.join()`

    -   Ausführender Thread wird blockiert (also nicht
        `otherThreadObj`!)
    -   Blockade des Aufrufers wird beendet, wenn der andere Thread
        (`otherThreadObj`) beendet wird.

*Hinweis:* Ein Thread wird beendet, wenn

-   die `run()`-Methode normal endet, oder
-   die `run()`-Methode durch eine nicht gefangene Exception beendet
    wird, oder
-   von außen die Methode `stop()` aufgerufen wird (Achtung: Deprecated!
    Einen richtigen Ersatz gibt es aber auch nicht.).

*Hinweis:* Die Methoden `wait()`, `notify()`/`notifyAll()` und die
"`synchronized`-Sperre" werden in der Sitzung ["Threads:
Synchronisation"](#id-fd5317305f8c0a4a45cfacf12f8feac51a2ed5df)
besprochen.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/intro/Join.java">Demo: intro.Join</a></p>

##### Wrap-Up

Threads sind weitere Kontrollflussfäden, von Java-VM (oder (selten) von
OS) verwaltet

-   Ableiten von `Thread` oder implementieren von `Runnable`
-   Methode `run` enthält den auszuführenden Code
-   Starten des Threads mit `start` (nie mit `run`!)

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Ullenboom ([2021, Kap. 16](#ref-Ullenboom2021))
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
> -   Boles ([2008](#ref-Boles2008))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kenne den grundsätzlichen Unterschied zw. Threads und
>     Prozessen
> -   k2: Ich kenne den Lebenszyklus von Threads
> -   k3: Ich kann Threads erzeugen und starten
>
> </details>

<a id="id-fd5317305f8c0a4a45cfacf12f8feac51a2ed5df"></a>

#### Threads: Synchronisation: Verteilter Zugriff auf gemeinsame Ressourcen

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Bei verteiltem Zugriff auf gemeinsame Ressourcen besteht
> Synchronisierungsbedarf, insbesondere sollten nicht mehrere Threads
> gleichzeitig geteilte Daten modifizieren. Dazu kommt das Problem, dass
> ein Thread in einer komplexen Folge von Aktionen die Zeitscheibe
> verlieren kann und dann später mit veralteten Daten weiter macht.
>
> Um den Zugriff auf gemeinsame Ressourcen oder den Eintritt in
> kritische Bereiche zu schützen und zu synchronisieren, kann man diese
> Zugriffe oder Bereiche in einen `synchronized`-Block legen. Dazu
> benötigt man noch ein beliebiges (gemeinsam sichtbares) Objekt,
> welches als Wächter- oder Sperr-Objekt fungiert. Beim Eintritt in den
> geschützten Block muss ein Thread einen Lock auf dem Sperr-Objekt
> erlangen. Hat bereits ein anderer Thread den Lock, wird der neue
> Thread so lange blockiert, bis der Lock wieder "frei" ist. Beim
> Eintritt in den Bereich wird dann durch den Thread auf dem
> Sperr-Objekt der Lock gesetzt und beim Austritt automatisch wieder
> aufgehoben. Dies nennt man auch **mehrseitige Synchronisierung**
> (mehrere Threads "stimmen" sich quasi untereinander über den Zugriff
> auf eine Ressource ab).
>
> Um auf den Eintritt eines Ereignisses oder die Erfüllung einer
> Bedingung zu warten, kann man `wait` und `notify` nutzen. In einem
> `synchronized`-Block prüft man, ob die Bedingung erfüllt oder ein
> Ereignis eingetreten ist, und falls ja arbeitet man damit normal
> weiter. Falls die Bedingung nicht erfüllt ist oder das Ereignis nicht
> eingetreten ist, kann man auf dem im `synchronized`-Block genutzten
> Sperr-Objekt die Methode `wait()` aufrufen. Damit wird der Thread in
> die entsprechende Schlange auf dem Sperr-Objekt eingereiht und
> blockiert. Zusätzlich wird der Lock auf dem Sperr-Objekt freigegeben.
> Zum "Aufwecken" nutzt man an geeigneter Stelle auf dem **selben
> Sperr-Objekt** die Methode `notify()` oder `notifyALl()` (erstere
> weckt einen in der Liste des Sperr-Objekts wartenden Thread, die
> letztere alle). Nach dem Aufwachen macht der Thread nach seinem
> `wait()` weiter. Es ist also wichtig, dass die Bedingung, wegen der
> ursprünglich das `wait()` aufgerufen wurde, erneut abgefragt wird und
> ggf. erneut in das `wait()` gegangen wird. Dies nennt man **einseitige
> Synchronisierung**.
>
> Es gibt darüber hinaus viele weitere Mechanismen und Probleme, die
> aber den Rahmen dieser Lehrveranstaltung deutlich übersteigen. Diese
> werden teilweise in den Veranstaltungen "Betriebssysteme" und/oder
> "Verteilte Systeme" besprochen.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Threads Synchronisation](https://youtu.be/FtVaobn4NqA)
> -   [Demo Teaser: Falscher Zugriff auf gemeinsame
>     Ressourcen](https://youtu.be/SB1ngVkQdLM)
> -   [Demo Mehrseitige Synchronisation (Sperr-Objekt, synchronisierte
>     Methode)](https://youtu.be/YTV-oT-vmpE)
> -   [Demo Mehrseitige Synchronisation:
>     Deadlock](https://youtu.be/D4B5xHqCZ-0)
> -   [Demo Einseitige Synchronisation](https://youtu.be/akCl01ZAaGo)
>
> </details>

##### Motivation: Verteilter Zugriff auf gemeinsame Ressourcen

``` java
public class Teaser implements Runnable {
    private int val = 0;

    public static void main(String... args) {
        Teaser x = new Teaser();
        new Thread(x).start();
        new Thread(x).start();
    }

    private void incrVal() {
        ++val;
        System.out.println(Thread.currentThread().getId() + ": " + val);
    }

    public void run() {
        IntStream.range(0, 5).forEach(i -> incrVal());
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/synchronised/Teaser.java">Demo: synchronised.Teaser</a></p>

##### Zugriff auf gemeinsame Ressourcen: Mehrseitige Synchronisierung

``` java
synchronized (<Object reference>) {
    <statements (synchronized)>
}
```

=\> **"Mehrseitige Synchronisierung"**

Fallunterscheidung: Thread T1 führt `synchronized`-Anweisung aus:

-   Sperre im Sperr-Objekt nicht gesetzt:
    1.  T1 setzt Sperre beim Eintritt,
    2.  führt den Block aus, und
    3.  löst Sperre beim Verlassen
-   Sperre durch T1 gesetzt:
    1.  T1 führt den Block aus, und
    2.  löst Sperre beim Verlassen **nicht**
-   Sperre durch T2 gesetzt: =\> T1 wird blockiert, bis T2 die Sperre
    löst

*Anmerkung*: Das für die Synchronisierung genutzte Objekt nennt man
"Wächter-Objekt" oder auch "Sperr-Objekt" oder auch
"Synchronisations-Objekt".

Damit könnte man den relevanten Teil der Methode `incrVal()`
beispielsweise in einen geschützten Bereich einschließen und als
Sperr-Objekt das eigene Objekt (`this`) einsetzen:

``` java
    private void incrVal() {
        synchronized (this) { ++val; }
    }
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/synchronised/ObjSync.java">Demo: synchronised.ObjSync</a></p>

##### Synchronisierte Methoden

``` java
void f() {
    synchronized (this) {
        ...
    }
}
```

... ist äquivalent zu ...

``` java
synchronized void f() {
    ...
}
```

Kurzschreibweise: Man spart das separate Wächter-Objekt und
synchronisiert auf sich selbst ...

Die Methode `incrVal()` könnte entsprechend so umgeschrieben werden:

``` java
    private synchronized void incrVal() {
        ++val;
    }
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/synchronised/MethodSync.java">Demo: synchronised.MethodSync</a></p>

##### Probleme bei der (mehrseitigen) Synchronisierung: Deadlocks

``` java
public class Deadlock {
    private final String name;

    public synchronized String getName() { return name; }
    public synchronized void foo(Deadlock other) {
        System.out.format("%s: %s.foo() \n", Thread.currentThread().getName(), name);
        System.out.format("%s: %s.name()\n", Thread.currentThread().getName(), other.getName());
    }

    public static void main(String... args) {
        final Deadlock a = new Deadlock("a");
        final Deadlock b = new Deadlock("b");

        new Thread(() -> a.foo(b)).start();
        new Thread(() -> b.foo(a)).start();
    }
}
```

Viel hilft hier nicht viel! Durch zu großzügige mehrseitige
Synchronisierung kann es passieren, dass Threads gegenseitig aufeinander
warten: Thread A belegt eine Ressource, die ein anderer Thread B haben
möchte und Thread B belegt eine Ressource, die A gerne bekommen würde.
Da es dann nicht weitergeht, nennt man diese Situation auch "Deadlock"
("Verklemmung").

Im Beispiel ruft der erste Thread für das Objekt `a` die `foo()`-Methode
auf und holt sich damit den Lock auf `a`. Um die Methode beenden zu
können, muss noch die `getName()`-Methode vom Objekt `b` durch diesen
ersten Thread aufgerufen werden. Dafür muss der erste Thread den Lock
auf `b` bekommen.

Dummerweise hat parallel der zweite Thread auf dem Objekt `b` die
`foo()`-Methode aufgerufen und sich damit den Lock auf `b` geholt. Damit
muss der erste Thread so lange warten, bis der zweite Thread den Lock
auf `b` freigibt.

Das wird allerdings nicht passieren, da der zweite Thread zur Beendigung
der `foo()`-Methode noch `getName()` auf `a` ausführen muss und dazu den
Lock auf `b` holen, den aber aktuell der erste Thread hält.

Und schon geht's nicht mehr weiter :-)

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/synchronised/Deadlock.java">Demo: synchronised.Deadlock</a></p>

##### Warten auf andere Threads: Einseitige Synchronisierung

###### Problem

-   Thread T1 wartet auf Arbeitsergebnis von T2
-   T2 ist noch nicht fertig

###### Mögliche Lösungen

1.  Aktives Warten (Polling): Permanente Abfrage
    -   Kostet unnötig Rechenzeit
2.  Schlafen mit `Thread.sleep()`
    -   Etwas besser; aber wie lange soll man idealerweise schlafen?
3.  Warten mit `T2.join()`
    -   Macht nur Sinn, wenn T1 auf das *Ende* von T2 wartet
4.  **Einseitige Synchronisierung** mit `wait()` und `notify()`
    -   Das ist DIE Lösung für das Problem :)

##### Einseitige Synchronisierung mit *wait* und *notify*

-   **wait**: Warten auf Erfüllung einer Bedingung (Thread blockiert):

    ``` java
    synchronized (obj) {    // Geschützten Bereich betreten
        while (!condition) {
            try {
                obj.wait(); // Thread wird blockiert
            } catch (InterruptedException e) {}
        }
        ...     // Condition erfüllt: Tue Deine Arbeit
    }
    ```

    =\> Bedingung nach Rückkehr von `wait` erneut prüfen!

###### Eigenschaften von *wait*

-   Thread ruft auf Synchronisations-Objekt die Methode `wait` auf
-   Prozessor wird entzogen, Thread blockiert
-   Thread wird in interne Warteschlange des Synchronisations-Objekts
    eingetragen
-   Sperre auf Synchronisations-Objekt wird freigegeben

=\> Geht nur innerhalb der `synchronized`-Anweisung für das
Synchronisations-Objekt!

##### Einseitige Synchronisierung mit *wait* und *notify* (cnt.)

-   **notify**: Aufwecken von wartenden (blockierten) Threads:

    ``` java
    synchronized (obj) {
        obj.notify();       // einen Thread "in" obj aufwecken
        obj.notifyAll();    // alle Threads "in" obj wecken
    }
    ```

###### Eigenschaften von *notify* bzw. *notifyAll*

-   Thread ruft auf einem Synchronisations-Objekt die Methode `notify`
    oder `notifyAll` auf
-   Falls Thread(s) in Warteschlange des Objekts vorhanden, dann
    -   `notify`: Ein *zufälliger* Thread wird aus Warteschlange
        entfernt und in den Zustand "ausführungsbereit" versetzt
    -   `notifyAll`: Alle Threads werden aus Warteschlange entfernt und
        in den Zustand "ausführungsbereit" versetzt

=\> Geht nur innerhalb der `synchronized`-Anweisung für das
Synchronisations-Objekt!

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/synchronised/Staffel.java">Demo: synchronised.Staffel</a></p>

##### Wrap-Up

Synchronisierungsbedarf bei verteiltem Zugriff auf gemeinsame
Ressourcen:

-   Vorsicht mit konkurrierendem Ressourcenzugriff: Synchronisieren mit
    `synchronized` =\> **Mehrseitige Synchronisierung**

<!-- -->

-   Warten auf Ereignisse mit `wait` und `notify`/`notifyAll` =\>
    **Einseitige Synchronisierung**

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
> -   Boles ([2008](#ref-Boles2008))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kann die Notwendigkeit zur Synchronisation erklären
> -   k2: Ich kann den Unterschied zwischen einseitiger und mehrseitiger
>     Synchronisation erklären
> -   k3: Ich kann die Synchronisation mit synchronized, wait, notify
>     und notifyAll praktisch einsetzen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> **Hamster-Welt**
>
> In den
> [Vorgaben](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/java-classic/src/challenges/threads)
> finden Sie eine Modellierung für eine Hamsterwelt.
>
> Es gibt rote und blaue Hamster, die sich unabhängig von einander
> bewegen können. Es gibt einen Tunnel, den die Hamster betreten und
> durchqueren können. In der Vorgabe ist ein kleines Hauptprogramm
> enthalten, welches einige Hamster anlegt und herumlaufen lässt.
>
> **Teil I: Stau im Tunnel**
>
> Die Hamster sind sehr neugierig und wollen gern durch den Tunnel
> gehen, um die Höhle auf der anderen Seite zu erkunden. Leider mussten
> sie feststellen, dass immer nur ein Hamster zu einem Zeitpunkt im
> Tunnel sein darf, sonst wird die Luft zu knapp.
>
> Ergänzen Sie die Vorgaben, so dass sich immer nur ein paralleler
> Hamster (egal welcher Farbe) im Tunnel aufhalten kann. Wenn ein
> Hamster in den Tunnel will, aber nicht hinein kann, dann soll er am
> Eingang warten, also nicht noch einmal in seiner Höhle herumlaufen.
> (Das passiert eigentlich automatisch, wenn Sie alles richtig machen.)
>
> **Teil II: Schlaue Hamster**
>
> Die Hamster sind schlau und haben bemerkt, dass die Einschränkung aus
> der letzten Aufgabe zu stark war. Sie überleben auch, wenn sich
> beliebig viele blaue Hamster oder nur genau ein roter Hamster im
> Tunnel aufhalten.
>
> Erweitern Sie die Implementierung aus der letzten Aufgabe, so dass
> folgende Bedingungen eingehalten werden:
>
> -   Es dürfen sich beliebig viele blaue Hamster gleichzeitig im Tunnel
>     befinden.
>
>     Das bedeutet, dass in diesem Fall zwar weitere blaue Hamster den
>     Tunnel betreten dürfen, aber kein roter Hamster in den Tunnel
>     hinein darf.
>
> -   Wenn sich ein roter Hamster im Tunnel aufhält, dürfen keine
>     anderen Hamster (unabhängig von deren Farbe) den Tunnel betreten.
>
> </details>

<a id="id-658174d5a85775f31f62a05f3f7d486f9391ba11"></a>

#### Threads: High-Level Concurrency

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Das Erzeugen von Threads über die Klasse `Thread` oder das Interface
> `Runnable` und das Hantieren mit `synchronized` und
> `wait()`/`notify()` zählt zu den grundlegenden Dingen beim
> Multi-Threading mit Java. Auf diesen Konzepten bauen viele weitere
> Konzepte auf, die ein flexibleres Arbeiten mit Threads in Java
> ermöglichen.
>
> Dazu zählt unter anderem das Arbeiten mit `Lock`-Objekten und
> dazugehörigen `Conditions`, was `synchronized` und `wait()`/`notify()`
> entspricht, aber feingranulareres und flexibleres Locking bietet.
>
> Statt Threads immer wieder neu anzulegen (das Anlegen von Objekten
> bedeutet einen gewissen Aufwand zur Laufzeit), kann man Threads über
> sogenannte Thread-Pools wiederverwenden und über das
> Executor-Interface benutzen.
>
> Schließlich bietet sich das Fork/Join-Framework zum rekursiven
> Zerteilen von Aufgaben und zur parallelen Bearbeitung der Teilaufgaben
> an.
>
> Die in Swing integrierte Klasse `SwingWorker` ermöglicht es, in Swing
> Berechnungen in einen parallel ausgeführten Thread auszulagern.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL High-Level Concurrency](https://youtu.be/bb_kuuhXC6A)
> -   [Demo Lock-Objekte](https://youtu.be/1tJRUJddtlw)
> -   [Demo Executor](https://youtu.be/VvzlwZ6n3SI)
> -   [Demo Fork/Join](https://youtu.be/Wfq_MDFoWYY)
> -   [Demo SwingWorker](https://youtu.be/Hu3RbqiNy4M)
>
> </details>

##### Explizite Lock-Objekte

Sie kennen bereits die Synchronisierung mit dem Schlüsselwort
`synchronized`.

``` java
// Synchronisierung der gesamten Methode
public synchronized int incrVal() {
    ...
}
```

``` java
// Synchronisierung eines Blocks (eines Teils einer Methode)
public int incrVal() {
    ...
    synchronized (someObj) {
        ...
    }
    ...
}
```

Dabei wird implizit ein Lock über ein Objekt (das eigene Objekt im
ersten Fall, das Sperrobjekt im zweiten Fall) benutzt.

Seit Java5 kann man alternativ auch explizite Lock-Objekte nutzen:

``` java
// Synchronisierung eines Teils einer Methode über ein
// Lock-Objekt (seit Java 5)
// Package `java.util.concurrent.locks`
public int incrVal() {
    Lock waechter = new ReentrantLock();
    ...
    waechter.lock();
    ... // Geschützter Bereich
    waechter.unlock();
    ...
}
```

Locks aus dem Paket `java.util.concurrent.locks` arbeiten analog zum
impliziten Locken über `synchronized`. Sie haben darüber hinaus aber
einige Vorteile:

-   Methoden zum Abfragen, ob ein Lock möglich ist: `Lock#tryLock`
-   Methoden zum Abfragen der aktuellen Warteschlangengröße:
    `Lock#getQueueLength`
-   Verfeinerung `ReentrantReadWriteLock` mit Methoden `readLock` und
    `writeLock`
    -   Locks nur zum Lesen bzw. nur zum Schreiben
-   `Lock#newCondition` liefert ein Condition-Objekt zur
    Benachrichtigung ala `wait`/`notify`: `await`/`signal` =\>
    zusätzliches Timeout beim Warten möglich

Nachteile:

-   Bei Exceptions werden implizite Locks durch `synchronized`
    automatisch durch das Verlassen der Methode freigegeben. Explizite
    Locks müssen **durch den Programmierer** freigegeben werden! =\>
    Nutzung des `finally`-Block!

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/java-classic/src/lock/">Demo: lock.*</a></p>

##### Thread-Management: Executor-Interface und Thread-Pools

###### Wiederverwendung von Threads

-   Normale Threads sind immer Einmal-Threads: Man kann sie nur
    **einmal** in ihrem Leben starten (auch wenn das Objekt anschließend
    noch auf Nachrichten bzw. Methodenaufrufe reagiert)

-   Zusätzliches Problem: Threads sind Objekte:

    -   Threads brauchen relativ viel Arbeitsspeicher
    -   Erzeugen und Entsorgen von Threads kostet Ressourcen
    -   Zu viele Threads: Gesamte Anwendung hält an

-   Idee: Threads wiederverwenden und Thread-Management auslagern =\>
    **Executor-Interface** und **Thread-Pool**

###### Executor-Interface

``` java
public interface Executor {
    void execute(Runnable command);
}
```

-   Neue Aufgaben als Runnable an einen Executor via `execute` übergeben
-   Executor könnte damit sofort neuen Thread starten (oder alten
    wiederverwenden): `e.execute(r);` =\> entspricht in der Wirkung
    `(new Thread(r)).start();`

###### Thread-Pool hält Menge von "Worker-Threads"

-   Statische Methoden von `java.util.concurrent.Executors` erzeugen
    Thread-Pools mit verschiedenen Eigenschaften:

    -   `Executors#newFixedThreadPool` erzeugt ExecutorService mit
        spezifizierter Anzahl von Worker-Threads
    -   `Executors#newCachedThreadPool` erzeugt Pool mit Threads, die
        nach 60 Sekunden Idle wieder entsorgt werden

-   Rückgabe: `ExecutorService` (Thread-Pool)

    ``` java
    public interface ExecutorService extends Executor { ... }
    ```

-   `Executor#execute` übergibt Runnable dem nächsten freien
    Worker-Thread (oder erzeugt ggf. neuen Worker-Thread bzw. hängt
    Runnable in Warteschlange, je nach erzeugtem Pool)

-   Methoden zum Beenden eines Thread-Pools (Freigabe): `shutdown()`,
    `isShutdown()`, ...

``` java
MyThread x = new MyThread();    // Runnable oder Thread

ExecutorService pool = Executors.newCachedThreadPool();

pool.execute(x);    // x.start()
pool.execute(x);    // x.start()
pool.execute(x);    // x.start()

pool.shutdown();    // Feierabend :)
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/executor/ExecutorDemo.java">Demo: executor.ExecutorDemo</a></p>

###### Hintergrund (vereinfacht)

Der Thread-Pool reserviert sich "nackten" Speicher, der der Größe von
$n$ Threads entspricht, und "prägt" die Objektstruktur durch einen Cast
direkt auf (ohne wirkliche neue Objekte zu erzeugen). Dieses Vorgehen
ist in der C-Welt wohlbekannt und schnell (vgl. Thema Speicherverwaltung
in der LV "Systemprogrammierung"). In Java wird dies durch eine
wohldefinierte Schnittstelle vor dem Nutzer verborgen.

###### Ausblick

Hier haben wir nur die absoluten Grundlagen angerissen. Wir können auch
`Callables` anstatt von `Runnables` übergeben, auf Ergebnisse aus der
Zukunft warten (`Futures`), Dinge zeitgesteuert (immer wieder) starten,
...

Schauen Sie sich bei Interesse die weiterführende Literatur an,
beispielsweise die Oracle-Dokumentation oder auch ([Ullenboom
2021](#ref-Ullenboom2021)) (insbesondere den Abschnitt 16.4 ["Der
Ausführer (Executor)
kommt"](https://openbook.rheinwerk-verlag.de/javainsel/16_004.html#u16.4)).

##### Fork/Join-Framework: Teile und Herrsche

Spezieller Thread-Pool zur rekursiven Bearbeitung parallelisierbarer
Tasks

-   `java.util.concurrent.ForkJoinPool#invoke` startet Task

-   Task muss von `RecursiveTask<V>` erben:

    ``` java
    public abstract class RecursiveTask<V> extends ForkJoinTask<V> {
        protected abstract V compute();
    }
    ```

Prinzipieller Ablauf:

``` java
public class RecursiveTask extends ForkJoinTask<V> {
    protected V compute() {
        if (task klein genug) {
            berechne task sequentiell
        } else {
            teile task in zwei subtasks:
                left, right = new RecursiveTask(task)
            rufe compute() auf beiden subtasks auf:
                left.fork();          // starte neuen Thread
                r = right.compute();  // nutze aktuellen Thread
            warte auf ende der beiden subtasks: l = left.join()
            kombiniere die ergebnisse der beiden subtasks: l+r
        }
    }
}
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/forkjoin/ForkJoin.java">Demo: forkjoin.ForkJoin</a></p>

##### Swing und Threads

###### Lange Berechnungen in Listenern blockieren Swing-GUI

-   Problem: Events werden durch **einen** *Event Dispatch Thread* (EDT)
    **sequentiell** bearbeitet
-   Lösung: Berechnungen in neuen Thread auslagern
-   **Achtung**: Swing ist **nicht Thread-safe**! Komponenten nicht
    durch verschiedene Threads manipulieren!

###### Lösung

=\> `javax.swing.SwingWorker` ist eine spezielle Thread-Klasse, eng mit
Swing/Event-Modell verzahnt.

-   Implementieren:
    -   `SwingWorker#doInBackground`: Für die langwierige Berechnung
        (muss man selbst implementieren)
    -   `SwingWorker#done`: Wird vom EDT aufgerufen, wenn
        `doInBackground` fertig ist

<!-- -->

-   Aufrufen:
    -   `SwingWorker#execute`: Started neuen Thread nach Anlegen einer
        Instanz und führt dann automatisch `doInBackground` aus
    -   `SwingWorker#get`: Return-Wert von `doInBackground` abfragen

###### Anmerkungen

-   `SwingWorker#done` ist optional: *kann* überschrieben werden
    -   Beispielweise, wenn nach Beendigung der langwierigen Berechnung
        GUI-Bestandteile mit dem Ergebnis aktualisiert werden sollen
-   `SwingWorker<T, V>` ist eine generische Klasse:
    -   `T` Typ für das Ergebnis der Berechnung, d.h. Rückgabetyp für
        `doInBackground` und `get`
    -   `V` Typ für Zwischenergebnisse

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/misc/SwingWorkerDemo.java">Demo: misc.SwingWorkerDemo</a></p>

##### Letzte Worte :-)

-   Viele weitere Konzepte
    -   Semaphoren, Monitore, ...
    -   Leser-Schreiber-Probleme, Verklemmungen, ...

    =\> Verweis auf LV "Betriebssysteme" und "Verteilte Systeme"

<!-- -->

-   **Achtung**: Viele Klassen sind nicht Thread-safe!

    Es gibt aber meist ein "Gegenstück", welches Thread-safe ist.

    Beispiel Listen:

    -   `java.util.ArrayList` ist **nicht** Thread-safe
    -   `java.util.Vector` ist Thread-sicher

    =\> Siehe Javadoc in den JDK-Klassen!

<!-- -->

-   Thread-safe bedeutet **Overhead** (Synchronisierung)!

##### Wrap-Up

Multi-Threading auf höherem Level: Thread-Pools und Fork/Join-Framework

-   Feingranulareres und flexibleres Locking mit Lock-Objekten und
    Conditions
-   Wiederverwendung von Threads: Thread-Management mit
    Executor-Interface und Thread-Pools
-   Fork/Join-Framework zum rekursiven Zerteilen von Aufgaben und zur
    parallelen Bearbeitung der Teilaufgaben
-   `SwingWorker` für die parallele Bearbeitung von Aufgaben in Swing

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Ullenboom ([2021, Kap. 16](#ref-Ullenboom2021))
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
> -   Urma u. a. ([2014, 7.2](#ref-Urma2014))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k3: Ich kann High-Level-Abstraktionen einsetzen: Lock-Objekten und
>     Conditions, Executor-Interface und Thread-Pools,
>     Fork/Join-Framework, SwingWorker
>
> </details>

<a id="id-cd1f3b4bd043849ddb3a3d41c9c280e6f0547ce4"></a>

#### Reflection

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> Mit Hilfe der Reflection-API kann man Programme zur **Laufzeit**
> inspizieren und Eigenschaften von Elementen wie Klassen oder Methoden
> abfragen, aber auch Klassen instantiieren und Methoden aufrufen, die
> eigentlich auf `private` gesetzt sind oder die beispielsweise mit
> einer bestimmten Annotation markiert sind.
>
> Die Laufzeitumgebung erzeugt zu jedem Typ ein Objekt der Klasse
> `java.lang.Class`. Über dieses `Class`-Objekt einer Klasse können dann
> Informationen über diese Klasse abgerufen werden, beispielsweise
> welche Konstruktoren, Methoden und Attribute es gibt.
>
> Man kann über auch Klassen zur Laufzeit nachladen, die zur
> Compile-Zeit nicht bekannt waren. Dies bietet sich beispielsweise für
> User-definierte Plugins an.
>
> Reflection ist ein mächtiges Werkzeug. Durch das Arbeiten mit Strings
> und die Interaktion/Inspektion zur *Laufzeit* verliert man aber viele
> Prüfungen, die der Compiler normalerweise zur Compile-Zeit vornimmt.
> Auch das Refactoring wird dadurch eher schwierig.
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [VL Reflection](https://youtu.be/7wTKl8-KYd0)
> -   [Demo Reflection](https://youtu.be/e7rLH1f0fKM)
> -   [Demo Class-Loader](https://youtu.be/HI_ZJFbvoNY)
>
> </details>

##### Ausgaben und Einblicke zur Laufzeit

``` java
public class FactoryBeispielTest {
    @Test
    public void testGetTicket() {
        fail("not implemented");
    }
}
```

``` java
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Wuppie {}
```

Reflection wird allgemein genutzt, um zur Laufzeit von Programmen
Informationen über Klassen/Methoden/... zu bestimmen. Man könnte damit
auch das Verhalten der laufenden Programme ändern oder Typen
instantiieren und/oder Methoden aufrufen ...

Wenn Sie nicht (mehr) wissen, wie man eigene Annotationen definiert,
schauen Sie doch bitte einfach kurz im Handout zu Annotationen nach :-)

##### Wer bin ich? ... Informationen über ein Programm (zur Laufzeit)

<div align="center">

`java.lang.Class`: Metadaten über Klassen

</div>

``` java
// usual way of life
Studi heiner = new Studi();
heiner.hello();

// let's use reflection
try {
    Object eve = Studi.class.getDeclaredConstructor().newInstance();
    Method m = Studi.class.getDeclaredMethod("hello");
    m.invoke(eve);
} catch (ReflectiveOperationException ignored) {}
```

Für jeden Typ instantiiert die JVM eine nicht veränderbare Instanz der
Klasse `java.lang.Class`, über die Informationen zu dem Typ abgefragt
werden können.

Dies umfasst u.a.:

-   Klassenname
-   Implementierte Interfaces
-   Methoden
-   Attribute
-   Annotationen
-   ...

`java.lang.Class` bildet damit den Einstiegspunkt in die Reflection.

##### Vorgehen

1.  Gewünschte Klasse über ein `Class`-Objekt laden

<!-- -->

2.  Informationen abrufen (welche Methoden, welche Annotationen, ...)

<!-- -->

3.  Eine Instanz dieser Klasse erzeugen, und
4.  Methoden aufrufen

Das Vorgehen umfasst vier Schritte: Zunächst die gewünschte Klasse über
ein `Class`-Objekt laden und anschließend Informationen abrufen (etwa
welche Methoden vorhanden sind, welche Annotationen annotiert wurden,
...) und bei Bedarf eine Instanz dieser Klasse erzeugen sowie Methoden
aufrufen.

Ein zweiter wichtiger Anwendungsfall (neben dem Abfragen von
Informationen und Aufrufen von Methoden) ist das Laden von Klassen, die
zur Compile-Zeit nicht mit dem eigentlichen Programm verbunden sind. Auf
diesem Weg kann beispielsweise ein Bildbearbeitungsprogramm zur Laufzeit
dynamisch Filter aus einem externen Ordner laden und nutzen, oder der
Lexer kann die Tokendefinitionen zur Laufzeit einlesen (d.h. er könnte
mit unterschiedlichen Tokensätzen arbeiten, die zur Compile-Zeit noch
gar nicht definiert sind). Damit werden die Programme dynamischer.

##### Schritt 1: *Class*-Objekt erzeugen und Klasse laden

``` java
// Variante 1 (package.MyClass dynamisch zur Laufzeit laden)
Class<?> c = Class.forName("package.MyClass");


// Variante 2 (Objekt)
MyClass obj = new MyClass();
Class<?> c = obj.getClass();

// Variante 3 (Klasse)
Class<?> c = MyClass.class;
```

=\> Einstiegspunkt der Reflection API

Eigentlich wird nur in **Variante 1 die über den String angegebene
Klasse dynamisch von der Laufzeitumgebung (nach-) geladen** (muss also
im gestarteten Programm nicht vorhanden sein). Die angegebene Klasse
muss aber in Form von Byte-Code an der angegebenen Stelle (Ordner
`package`, Dateiname `MyClass.class`) vorhanden sein.

Die anderen beiden Varianten setzen voraus, dass die jeweilige Klasse
**bereits geladen** ist (also ganz normal mit den restlichen Sourcen zu
Byte-Code (`.class`-Dateien) kompiliert wurde und mit dem Programm
geladen wurde).

Alle drei Varianten ermöglichen die Introspektion der jeweiligen Klassen
zur Laufzeit.

##### Schritt 2: In die Klasse reinschauen

``` java
// Studi-Klasse dynamisch (nach-) laden
Class<?> c = Class.forName("reflection.Studi");


// Parametersatz für Methode zusammenbasteln
Class<?>[] paramT = new Class<?>[] { String.class };

// public Methode aus dem **Class**-Objekt holen
Method pubMethod = c.getMethod("setName", paramT);
// beliebige Methode aus dem **Class**-Objekt holen
Method privMethod = c.getDeclaredMethod("setName", paramT);


Method[] publicMethods = c.getMethods();  // all public methods (incl. inherited)
Method[] allMethods = c.getDeclaredMethods();  // all methods (excl. inherited)
```

-   `public` Methode laden (auch von Superklasse/Interface geerbt):
    `Class<?>.getMethod(String, Class<?>[])`
-   Beliebige (auch `private`) Methoden (in der Klasse selbst
    deklariert): `Class<?>.getDeclaredMethod(...)`

*Anmerkung*: Mit `Class<?>.getDeclaredMethods()` erhalten Sie alle
Methoden, die direkt in der Klasse deklariert werden (ohne geerbte
Methoden!), unabhängig von deren Sichtbarkeit. Mit
`Class<?>.getMethods()` erhalten Sie dagegen alle `public` Methoden, die
in der Klasse selbst oder ihren Superklassen bzw. den implementierten
Interfaces deklariert sind.

Vgl. Javadoc
[`getMethods`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Class.html#getMethods())
und
[`getDeclaredMethods`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Class.html#getDeclaredMethods()).

Die Methoden-Arrays können Sie nach bestimmten Eigenschaften
durchsuchen, bzw. auf das Vorhandensein einer bestimmten Annotation
prüfen (etwa mit `isAnnotationPresent()`) etc.

Analog können Sie weitere Eigenschaften einer Klasse abfragen,
beispielsweise Attribute (`Class<?>.getDeclaredFields()`) oder
Konstruktoren (`Class<?>.getDeclaredConstructors()`).

##### Schritt 3: Instanz der geladenen Klasse erzeugen

``` java
// Class-Objekt erzeugen
Class<?> c = Class.forName("reflection.Studi");


// Variante 1
Studi s = (Studi) c.newInstance();

// Variante 2
Constructor<?> ctor = c.getConstructor();
Studi s = (Studi) ctor.newInstance();

// Variante 3
Class<?>[] paramT = new Class<?>[] {String.class, int.class};
Constructor<?> ctor = c.getDeclaredConstructor(paramT);
Studi s = (Studi) ctor.newInstance("Beate", 42);
```

###### Parameterlose, öffentliche Konstruktoren:

-   `Class<?>.newInstance()` (seit Java9 *deprecated*!)
-   `Class<?>.getConstructor()` =\> `Constructor<?>.newInstance()`

###### Sonstige Konstruktoren:

Passenden Konstruktor explizit holen:
`Class<?>.getDeclaredConstructor(Class<?>[])`, Parametersatz
zusammenbasteln (hier nicht dargestellt) und aufrufen
`Constructor<?>.newInstance(...)`

###### Unterschied *new* und *Constructor.newInstance()*:

`new` ist nicht identisch zu `Constructor.newInstance()`: `new` kann
Dinge wie Typ-Prüfung oder Auto-Boxing mit erledigen, während man dies
bei `Constructor.newInstance()` selbst explizit angeben oder erledigen
muss.

Vgl.
[docs.oracle.com/javase/tutorial/reflect/member/ctorTrouble.html](https://docs.oracle.com/javase/tutorial/reflect/member/ctorTrouble.html).

##### Schritt 4: Methoden aufrufen ...

``` java
// Studi-Klasse dynamisch (nach-) laden
Class<?> c = Class.forName("reflection.Studi");
// Studi-Objekt anlegen (Defaultkonstruktor)
Studi s = (Studi) c.newInstance();
// Parametersatz für Methode zusammenbasteln
Class<?>[] paramT = new Class<?>[] { String.class };
// Methode aus dem **Class**-Objekt holen
Method method = c.getMethod("setName", paramT);


// Methode auf dem **Studi**-Objekt aufrufen
method.invoke(s, "Holgi");
```

Die Reflection-API bietet neben dem reinen Zugriff auf (alle) Methoden
noch viele weitere Möglichkeiten. Beispielsweise können Sie bei einer
Methode nach der Anzahl der Parameter und deren Typ und Annotationen
fragen etc. ... Schauen Sie am besten einmal selbst in die API hinein.

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/reflection/ReflectionDemo.java">Demo: reflection.ReflectionDemo</a></p>

##### Hinweis: Klassen außerhalb des Classpath laden

``` java
File folder = new File("irgendwo");
URL[] ua = new URL[]{folder.toURI().toURL()};

URLClassLoader ucl = URLClassLoader.newInstance(ua);
Class<?> c1 = Class.forName("org.wuppie.Fluppie", true, ucl);
Class<?> c2 = ucl.loadClass("org.wuppie.Fluppie");
```

<p align="right"><a href="https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/blob/master/lecture/java-classic/src/reflection/ClassLoaderDemo.java">Bemerkung zu Ordnerstruktur und Classpath; Demo: reflection.ClassLoaderDemo</a></p>

Mit `Class.forName("reflection.Studi")` können Sie die Klasse `Studi` im
Package `reflection` laden. Dabei muss sich aber die entsprechende
`.class`-Datei (samt der der Package-Struktur entsprechenden
Ordnerstruktur darüber) **im Java-Classpath** befinden!

Mit einem weiteren `ClassLoader` können Sie auch aus Ordnern, die sich
nicht im Classpath befinden, `.class`-Dateien laden. Dies geht dann
entweder wie vorher über `Class.forName()`, wobei hier der neue
Class-Loader als Parameter mitgegeben wird, oder direkt über den neuen
Class-Loader mit dessen Methode `loadClass()`.

##### Licht und Schatten

**Nützlich**:

-   Erweiterbarkeit: Laden von "externen" (zur Kompilierzeit
    unbekannter) Klassen in eine Anwendung
-   Klassen-Browser, Debugger und Test-Tools

**Nachteile**:

-   Verlust von Kapselung, Compiler-Unterstützung und Refactoring
-   Performance: Dynamisches Laden von Klassen etc.
-   Sicherheitsprobleme/-restriktionen

<div align="center">

Reflection ist ein nützliches Werkzeug. Aber: **Gibt es eine Lösung ohne
Reflection, wähle diese!**

</div>

##### Wrap-Up

-   Inspektion von Programmen zur Laufzeit: **Reflection**
    -   `java.lang.Class`: Metadaten über Klassen
    -   Je Klasse ein `Class`-Objekt
    -   Informationen über Konstruktoren, Methoden, Felder
    -   Anwendung: Laden und Ausführen von zur Compile-Zeit unbekanntem
        Code
    -   Vorsicht: Verlust von Refactoring und Compiler-Zusicherungen!

> [!TIP]
>
> <details open>
> <summary><strong>📖 Zum Nachlesen</strong></summary>
>
> -   Oracle Corporation ([2024](#ref-Java-SE-Tutorial))
> -   Inden ([2013, Kap. 8](#ref-Inden2013))
>
> </details>

> [!NOTE]
>
> <details >
> <summary><strong>✅ Lernziele</strong></summary>
>
> -   k2: Ich kenne typische Probleme beim Einsatz von Reflection
> -   k2: Ich kann die Bedeutung der verschiedenen Exceptions beim
>     Aufruf von Methoden per Reflection erklären
> -   k3: Ich kann zur Laufzeit mit Reflection Information zu Klassen
>     und Methoden erlangen
> -   k3: Ich kann zur Compilezeit unbekannte Klassen einbinden und
>     deren Konstruktoren und Methoden (mit und ohne
>     Parameter/Rückgabewerte) aufrufen
>
> </details>

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🏅 Challenges</strong></summary>
>
> In den
> [Vorgaben](https://github.com/Programmiermethoden-CampusMinden/Prog2-Lecture/tree/master/lecture/java-classic/src/challenges/reflection)
> finden Sie eine einfache Implementierung für einen Taschenrechner mit
> Java-Swing. Dieser Taschenrechner kann nur mit `int`-Werten rechnen.
> Der Taschenrechner verfügt über keinerlei vordefinierte mathematische
> Operationen (Addieren, Subtrahieren etc.).
>
> Erstellen Sie eigene mathematische Operationen, die `IOperation`
> implementieren. Jede Ihrer Klassen soll mit einer Annotation vermerkt
> werden, in welcher der Name der jeweiligen Operation gespeichert wird.
>
> Der Taschenrechner lädt seine Operationen dynamisch über die statische
> Methode `OperationLoader.loadOperations` ein. In den Vorgaben ist
> diese Methode noch nicht ausimplementiert. Implementieren Sie die
> Funktion so, dass sie mit Hilfe von Reflection Ihre Operationen
> einliest. Geben Sie dazu den Ordner an, in dem die entsprechenden
> `.class`-Dateien liegen. (Dieser Ordner soll sich außerhalb Ihres
> Java-Projekts befinden!) Verändern Sie nicht die Signatur der Methode.
>
> Ihre Operation-Klassen dürfen Sie nicht vorher bekannt machen. Diese
> müssen in einem vom aktuellen Projekt separierten Ordner/Projekt
> liegen.
> </details>

<a id="id-a264d337dcfeece8936f208b6f89bb1efe99ea0f"></a>

## Praktikum

Hier finden Sie die Übungsblätter.

<a id="id-989147f48baba6a594eb9665934ae2623dc84964"></a>

### Blatt 01: Hangman (Wiederholung Swing)

#### Zusammenfassung

Dieses Blatt ist bewusst einfach gestaltet und dient der Wiederholung
Ihrer Kenntnisse aus der LV "Programmieren 1".

Implementieren Sie in Java das Spiel
[Hangman](https://en.wikipedia.org/wiki/Hangman_(game)).

#### Aufgaben

##### Installation JDK und IDE, Deaktivierung AI-Support

Sie benötigen für die Bearbeitung der Übungsaufgaben ein *Java
Development Kit* (JDK). Wir verwenden in der Lehrveranstaltung
"Programmieren 2" aus verschiedenen Gründen die *Long-Term Support
(LTS)*-Variante, d.h. aktuell das "Java SE Development Kit 21 (LTS)"
(JDK 21).

Sofern noch nicht geschehen, installieren Sie bitte auf Ihrem Rechner
**Java SE 21 (LTS)** in einer *64-bit Version*. Wenn Sie mehrere JDKs
installiert haben sollten, stellen Sie bitte sicher, dass Sie für
"Programmieren 2" tatsächlich das Java SE 21 (LTS) verwenden. Der
Anbieter des JDKs sollte keine Rolle spielen.

Installieren Sie auf Ihrem Rechner eine IDE für Java Ihrer Wahl. Machen
Sie sich mit der Arbeitsweise Ihrer IDE vertraut. Wenn Sie im Verlauf
des Praktikums feststellen, dass die gewählte IDE nicht für Sie gemacht
ist, können Sie jederzeit auf eine andere IDE wechseln.

Da Sie das Programmierhandwerk erlernen und üben und vertiefen sollen,
dürfen Sie im Rahmen dieser Lehrveranstaltung noch keine KI-gestützten
Assistenten benutzen. Bitte schalten Sie sämtliche KI-Unterstützung wie
beispielsweise Copilot, JetBrains AI Assistant, Cursor, CodeGPT,
Codeium, Tabnine, Windsurf, ... (Liste nicht vollständig) für die
Bearbeitung der Übungsaufgaben in dieser Lehrveranstaltung ab.

##### Anlegen eines Java-Projektes

Legen Sie für die Bearbeitung der Aufgabe ein neues Java-Projekt in
Ihrer IDE an. Achten Sie bitte darauf, dass im Projektpfad **keine
Leerzeichen** und **keine Sonderzeichen** (Umlaute o.ä.) vorkommen! Dies
kann zu teilweise seltsamen Fehler führen.

Wir werden in dieser Lehrveranstaltung das Build-Tool **Gradle**
verwenden, dieses aber erst später im Verlauf der Lehrveranstaltung
besprechen. Für dieses erste Übungsblatt können Sie Ihr Projekt noch so
konfigurieren, dass es ohne Build-Tool arbeitet und direkt in der IDE
kompiliert und gestartet wird.

Testen Sie bitte die genutzte Java-Version:

1.  Konsole: Geben Sie den Befehl `java -version` auf der Konsole ein.
    Die Ausgabe sollte `java version "21.0.6" 2025-01-21 LTS` (oder
    ähnlich) ergeben. Wichtig sind die "21" und "LTS".
2.  IDE: Erstellen Sie ein Programm, welches die Anweisung
    `System.out.println(System.getProperty("java.version"));` ausführt.
    Beim Start über die IDE sollte dabei die Ausgabe `21.0.6` (oder
    ähnlich) herauskommen. Wichtig ist die "21".

Korrigieren Sie Ihr Setup, wenn Sie andere Ausgaben erhalten.

##### Übersetzen und Starten und Debuggen von Programmen

Erstellen Sie in Ihrem neuen Projekt die folgende Klasse:

``` java
public class Main {
    public static void main(String... args) {
        String version = System.getProperty("java.version");
        System.out.println(version);
    }
}
```

Worin besteht der Unterschied zwischen dem Übersetzen und dem Starten
des obigen Programms? Wie unterscheiden Sie das in Ihrer IDE? Wie können
Sie das Programm manuell auf der Konsole übersetzen und starten?
Demonstrieren Sie das live im Praktikum.

Worin besteht der Unterschied zwischen Compiler-Warnungen/-Fehlern und
Laufzeit-Fehlern? Erklären Sie das im Praktikum an selbst gewählten
Beispielen am obigen Programm.

Starten Sie das obige Programm im Debug-Modus Ihrer IDE. Halten Sie die
Ausführung am `System.out.println` an, verändern Sie den Wert der
Variablen `version` und führen Sie dann die nächste Anweisung (das
`System.out.println`) aus. Wie beenden Sie das Programm? Demonstrieren
Sie das live im Praktikum.

##### Swing und Java2D

Das Spiel soll vollständig über eine in Swing und Java2D realisierte GUI
bedient werden:

1.  Visualisieren Sie den Zustand des Galgenmännchens per Java2D.
2.  Visualisieren Sie den Zustand des zu ratenden Wortes geeignet.
3.  Es muss ein Eingabefeld geben, um den nächsten Buchstaben eingeben
    zu können.
4.  Die bisher eingegebenen Buchstaben sollen in der Reihenfolge der
    Eingabe angezeigt werden.
5.  Das Spiel soll per Knopfdruck abgebrochen und neu gestartet werden
    können.

##### Einlesen von Textdateien

Es soll die Möglichkeit geben, eine Textdatei mit zu ratenden Wörtern
einzulesen:

1.  Auf Anforderung des Nutzers soll ein Auswahldialog erscheinen.
2.  Startverzeichnis ist der Ordner, in dem das Spiel gestartet wurde.
3.  Es sollen nur Textdateien mit der Endung `.txt` ausgewählt werden
    können.
4.  Es soll nur eine Datei ausgewählt werden können (also keine
    Mehrfachselektion).
5.  Die ausgewählte Textdatei soll eingelesen werden (Format: pro Zeile
    ein Wort). Alle eingelesenen Wörter sollen in eine Menge überführt
    und für das Spiel nutzbar gemacht werden.
6.  Es soll für jedes neue Spiel ein zufälliges Wort aus der Menge der
    eingelesenen Wörter zum Raten ausgewählt werden.

##### Dokumentation

Erstellen Sie ein UML-Klassendiagramm für Ihre Lösung.

##### Ausprobieren von fortgeschrittenen Widgets

1.  Heben Sie in der Anzeige der eingegebenen Buchstaben die korrekt
    geratenen Buchstaben in grüner Farbe hervor.
2.  Passen Sie die Visualisierung des Galgenmännchens farblich an die
    Tageszeit an, beispielsweise könnte es in den Nachtstunden eine Art
    Dark-Mode geben und tagsüber einen Light-Mode. Alternativ könnten
    Sie auch die Farbe der Zeichnung mit der Uhrzeit variieren.
3.  Lassen Sie den Nutzer per Slider die Schwierigkeit variieren:
    Steuerung der Länge des zu ratenden Wortes und/oder Steuerung der
    Anzahl der erlaubten Fehlversuche.

#### Bearbeitung und Abgabe

-   Bearbeitung: Einzelbearbeitung oder bis zu 3er Teams
-   Abgabe:
    -   Post Mortem [im
        ILIAS](https://www.hsbi.de/elearning/goto.php?target=exc_1514856&client_id=FH-Bielefeld)
        eintragen:

        Verfassen Sie im ILIAS pro Blatt und pro Team-Mitglied ein
        aussagekräftiges und nachvollziehbares "*Post Mortem*". Gehen
        Sie dabei auf folgende Punkte ein:

        1.  Zusammenfassung: Was wurde gemacht?
        2.  Implementierungsdetails: Kurze Beschreibung besonders
            interessanter Aspekte der Umsetzung.
        3.  Was war der schwierigste Teil bei der Bearbeitung? Wie haben
            Sie dieses Problem gelöst?
        4.  Was haben Sie gelernt oder (besser) verstanden?
        5.  Team: Mit wem haben Sie zusammengearbeitet?

        Das Post Mortem muss von **jeder Person** im Team
        **individuell** verfasst und abgegeben werden. Der Umfang des
        Textes soll zwischen 200 und 400 Wörtern liegen.

        Laden Sie hier bitte **nicht** Ihre Lösungen hoch!

    -   Deadline: 25. April, 08:00 Uhr
-   Vorstellung im Praktikum: 25. April

<a id="id-61b291653cdae0b4da99c50e5ab714c878aede10"></a>

### Blatt 02: Git-Quest & Calculator (Git Basics, Lambda-Ausdrücke, Gradle)

#### Zusammenfassung

Auf diesem Blatt üben Sie den Umgang mit Git (Repo und Commits -
zunächst auf der Konsole) sowie den Einsatz von Lambda-Ausdrücken und
das Schreiben von Gradle-Build-Skripten.

#### Aufgaben

##### Git

###### Git Status erklären

Betrachten Sie die folgende Ausgabe von `git status` in einer lokalen
Workingcopy (*Arbeitskopie*):

    pm-lecture % git status
    On branch b03

    Changes not staged for commit:
      (use "git add <file>..." to update what will be committed)
      (use "git restore <file>..." to discard changes in working directory)
            modified:   CONTRIBUTING.md
            modified:   homework/b03.md

    Untracked files:
      (use "git add <file>..." to include in what will be committed)
            foo.java

    no changes added to commit (use "git add" and/or "git commit -a")

Erklären Sie die Ausgabe.

Geben Sie eine Befehlssequenz an, mit der Sie nur die Änderungen in
`foo.java` committen können.

###### Git-Spiel

Klonen Sie die [Vorgaben
"Git-Quest"](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_gitquest).
Sie finden die Geschichte des Helden Markus im Dungeon.[^8]

1.  Öffnen Sie eine Konsole und beantworten Sie mit Hilfe der Befehle
    `git checkout`, `git log` und `git show` sowie `git diff` folgende
    Fragen:

    -   Was passierte an `tag 01`?
    -   Wann hat der Held zum ersten Mal 4 `experience` Punkte?
    -   Wann hat der Held zum ersten Mal 10 `hunger` Punkte?
    -   Wie viele Heiltränke hat der Held insgesamt in seinem Rucksack
        gehabt?
    -   Was hat der Held im Shop gekauft? Und wie viel Gold hat er dafür
        bezahlt?
    -   Was passierte zwischen `tag 03` und `tag 04`, d.h. was änderte
        sich zwischen diesen Commits?
    -   Hat der Held etwas gegessen? Falls ja, was und wann?

2.  Beim letzten Commit (`tag 04.5`) ist etwas schief gelaufen, es
    wurden versehentlich zu wenig `experience` Punkte eingestellt.
    Ändern Sie diesen letzten Commit und passen Sie die `experience`
    Punkte auf 42 an.

3.  Schreiben Sie die Geschichte in der Datei `questlog.md` fort und
    erzeugen Sie einen neuen Commit für `tag 04.6`. Ändern Sie bitte
    hierzu nur die eine Datei `questlog.md`.

4.  Schreiben Sie die Geschichte noch weiter fort (`tag 04.7`), aber
    ändern Sie diesmal mehrere Dateien, die an diesem Tag (neuer Commit)
    gemeinsam eingecheckt werden sollen.

5.  Fälschlicherweise wurden die Statuspunkte und die Ausrüstung bisher
    gemeinsam in der Datei `stats.md` geführt. Korrigieren Sie das und
    verschieben Sie die Ausrüstungsgegenstände aus der Datei `stats.md`
    in eine neue Datei `gear.md`. Checken Sie Ihre Änderungen als
    `tag 04.8` (neuer Commit) gemeinsam ein. (*Hinweis*: Es reicht, wenn
    diese Änderung als letzter Commit auf der Spitze des
    `master`-Branches existiert. Sie brauchen/sollen die Trennung von
    Statuspunkten und Ausrüstung **nicht rückwirkend** in die Historie
    einbauen!)

Demonstrieren Sie Ihr Vorgehen im Praktikum jeweils live.

###### Commit-Meldungen

Gute Commit-Meldungen schreiben erfordert Übung. Schauen Sie sich die
beiden Commits
[Dungeon-CampusMinden/Dungeon/commit/46530b6](https://github.com/Dungeon-CampusMinden/Dungeon/commit/46530b6dc970a8cedb0610b92268b9c78345e067)
und
[Dungeon-CampusMinden/Dungeon/commit/3e37472](https://github.com/Dungeon-CampusMinden/Dungeon/commit/3e3747220ade538b4c974a520cc9104121789aa1)
an.

Diskutieren Sie jeweils, was Ihnen an den Commits auffällt: Was gefällt
Ihnen, was stört Sie? Schlagen Sie Verbesserungen vor.

##### Gradle

Folgen Sie der Anleitung auf [gradle.org](https://gradle.org/) und
installieren Sie Gradle auf Ihrem Rechner. Legen Sie in der Konsole ein
neues Gradle-Projekt für eine Java-Applikation an (ohne IDE!). Das
Build-Script soll in Groovy erzeugt und als Test-API soll JUnit4
verwendet werden.

Wie finden Sie auf der Konsole heraus, welche Tasks es gibt? Erklären
Sie das Projektlayout, d.h. wo kommen beispielsweise die Java-Dateien
hin?

Erklären Sie, in welche Abschnitte das generierte Buildskript unterteilt
ist und welche Aufgaben diese Abschnitte jeweils erfüllen. Gehen Sie
dabei im *Detail* auf das Plugin `application` und die dort
bereitgestellten Tasks und deren Abhängigkeiten untereinander ein.

Öffnen Sie das Projekt in Ihrer IDE. Wie können Sie hier die
verschiedenen Tasks ansteuern?

Machen Sie sich Notizen, welche Sie im Praktikum nutzen dürfen, um dort
das Buildskript zu erklären.

##### Calculator: Anonyme Klassen und Lambda-Ausdrücke

Klonen Sie die [Vorgaben
"Calculator"](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_calculator)
und laden Sie das Projekt als Gradle-Projekt in Ihre IDE.

In den Vorgaben wird das Package `calculator` verwendet. Recherchieren
Sie und erklären Sie im Praktikum, was Packages in Java sind und wie man
damit die Code-Basis strukturieren kann. Gehen Sie dabei auch auf
Sichtbarkeiten ein.

Im Package `calculator` finden Sie einige Interfaces und Klassen, mit
denen man einen einfachen Taschenrechner modellieren kann: Dieser kann
einfache mathematische Operationen auf zwei Integern ausführen.

In der Klasse `calculator.Calculator` finden Sie vier mit `TODO`
markierte Stellen in der Methode `setupOperationSelector`:

1.  Erstellen Sie eine neue **Java-Klasse** `Sub`, die das Interface
    `Operation` implementiert und eine Subtraktion bereitstellt.
    Erweitern Sie den `Calculator` und binden Sie eine **Instanz dieser
    Klasse** ein. Nutzen Sie hier keine anonymen Klassen oder
    Lambda-Ausdrücke.
2.  Erstellen Sie eine weitere Operation "Mul" (Multiplikation von zwei
    Integern). Nutzen Sie dazu eine passende **anonyme Klasse**.
3.  Erstellen Sie eine weitere Operation "Div" (Integerdivision).
    Erstellen Sie einen passenden **Lambda-Ausdruck**.
4.  Für die `JComboBox` `operationSelector` wird ein `ActionListener`
    mit Hilfe einer *anonymen Klasse* definiert. Konvertieren Sie dies
    in einen entsprechenden **Lambda-Ausdruck**.

#### Bearbeitung und Abgabe

-   Bearbeitung: Einzelbearbeitung oder bis zu 3er Teams
-   Abgabe:
    -   Post Mortem [im
        ILIAS](https://www.hsbi.de/elearning/goto.php?target=exc_1514856&client_id=FH-Bielefeld)
        eintragen:

        Verfassen Sie im ILIAS pro Blatt und pro Team-Mitglied ein
        aussagekräftiges und nachvollziehbares "*Post Mortem*". Gehen
        Sie dabei auf folgende Punkte ein:

        1.  Zusammenfassung: Was wurde gemacht?
        2.  Implementierungsdetails: Kurze Beschreibung besonders
            interessanter Aspekte der Umsetzung.
        3.  Was war der schwierigste Teil bei der Bearbeitung? Wie haben
            Sie dieses Problem gelöst?
        4.  Was haben Sie gelernt oder (besser) verstanden?
        5.  Team: Mit wem haben Sie zusammengearbeitet?

        Das Post Mortem muss von **jeder Person** im Team
        **individuell** verfasst und abgegeben werden. Der Umfang des
        Textes soll zwischen 200 und 400 Wörtern liegen.

        Laden Sie hier bitte **nicht** Ihre Lösungen hoch!

    -   Deadline: 02. Mai, 08:00 Uhr
-   Vorstellung im Praktikum: 02. Mai

<a id="id-6c99b0278590e1866d400dbbb6fc3eeafad60e55"></a>

### Blatt 03: Git-Quest & LSF-Contact (Git Branches, Methoden-Referenzen, Logging)

#### Zusammenfassung

Auf diesem Blatt üben Sie den Umgang mit Git (Branches und Mergen -
zunächst auf der Konsole) sowie den Einsatz von Methoden-Referenzen und
den Einsatz von Logging.

#### Aufgaben

##### Git-Spiel

Betrachten Sie erneut die [Vorgaben zur
"Git-Quest"](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_gitquest).
Die Geschichte des Helden Markus findet im `master`-Branch kein Ende,
sondern erst im Hilfsbranch `end`.

Machen Sie nun verschiedene Experimente mit Branches in Git, und starten
Sie dabei jeweils mit einem frischen Klon der Vorgaben.

1.  Ändern Sie eine Datei, die im Branch `end` nicht verändert wurde.
    Erzeugen Sie mit diesen Änderungen auf dem `master` einen neuen
    Commit. Mergen Sie danach den Branch `end` in den `master`-Branch.
2.  Ändern Sie nun eine Datei, die auch im Branch `end` verändert wurde.
    Achten Sie dabei darauf, die Änderung an einer anderen Stelle in der
    Datei vorzunehmen. Erzeugen Sie mit diesen Änderungen auf dem
    `master` einen neuen Commit. Mergen Sie danach den Branch `end` in
    den `master`-Branch.
3.  Wie (2), aber ändern Sie nun eine Stelle, die auch im Branch `end`
    verändert wurde. Erzeugen Sie mit diesen Änderungen auf dem `master`
    einen neuen Commit. Mergen Sie danach den Branch `end` in den
    `master`-Branch. Was passiert, wenn die Änderung im `master`
    identisch zu der in `end` ist? Was passiert, wenn die Änderung im
    `master` anders ist als in `end`?
4.  Wie (2), aber setzen Sie bitte den Branch `end` auf die Spitze von
    `master`, bevor Sie `end` in `master` mergen.

Was beobachten Sie jeweils? Erklären Sie Ihre Beobachtungen. Wenn es
Konflikte gibt: Wie lösen Sie diese auf? Demonstrieren Sie das Vorgehen
im Praktikum live.

##### LSF-Contact

Betrachten Sie die [Vorgaben
"LSF-Contact"](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_lsfcontact).
Klonen Sie das Repo und laden Sie das Projekt als Gradle-Projekt in Ihre
IDE.

###### Methoden-Referenzen

Sie finden im Package `lsfcontact` eine Klasse `Student`. Jede Instanz
dieser Klasse hat mindestens einen Namen (`String`), und man kann
verschiedene Konktaktmöglichkeiten per Setter setzen: EMail-Adresse,
Telefonnummer, Post-Adresse (alle `String`).

Die Klasse `LsfContactUtil` soll ein Hilfsmodul im LSF simulieren, mit
der man die Studierenden kontaktieren kann. Es gibt drei verschiedene
Methoden, die jeweils mit einer Liste mit `Student`-Objekten aufgerufen
werden und die alle Studierenden mit der entsprechend gesetzten
Kontaktoption über diesen Kontaktweg ansprechen. *Beispiel*: Die Methode
`emailStudents` filtert alle Studierenden, deren EMail-Adresse gesetzt
ist (d.h. deren EMail-Adresse ein nicht-leerer String ist) und "schickt"
diesen Studierenden eine "EMail" über den Aufruf der privaten
Hilfsmethode `email`.

Die Klasse `Main` erzeugt einige `Student`-Objekte, gruppiert sie in
einer Liste und demonstriert die Aufrufe der Methoden in
`LsfContactUtil`.

Es fällt auf, dass die drei Methoden `emailStudents`, `phoneStudents`
und `writeStudents` algorithmisch identisch sind und sich nur in der
Abfrage der entsprechenden Kontaktoption und dem Aufruf der internen
Kontakt-Methode unterscheiden. Auch die internen Kontakt-Methoden
`email`, `phone` und `write` sind recht einfallslose Code-Duplikate.

Schreiben Sie die Klasse `LsfContactUtil` so um, dass es nur noch eine
`public` Methode für das Kontaktieren einer Liste von `Student`-Objekten
gibt. Fassen Sie ebenfalls die drei `private` Hilfsmethoden zu einer
neuen Hilfsmethode zusammen - dabei soll es inhaltlich bei dem
`System.out.println()` mit den aktuell verwendeten Informationen
bleiben. Überlegen Sie, wie Sie die Abfrage der Kontaktmöglichkeit und
auch die Kriterien für die Prüfung der Strings von außen als Parameter
in die Methode hineingeben können. Passen Sie die Schnittstellen an, so
dass der neuen `public` Methode zusätzlich zur `List<Student>` passende
Methodenreferenzen übergeben werden können. Ändern Sie die Demo-Aufrufe
in `Main` entsprechend. Die Klasse `Student` verändern Sie bitte nicht.

*Tipp*: Gehen Sie schrittweise vor und starten zunächst mit geeigneten
Lambda-Ausdrücken. Schaffen Sie es, diese durch Methodenreferenzen zu
ersetzen?

Achten Sie darauf, alle Schritte nachvollziehbar in Ihrer Arbeitskopie
per Git Commit festzuhalten. Demonstrieren Sie dies im Praktikum.

###### Logging

Bauen Sie für das `LsfContactUtil` ein Logging auf der Basis von
`java.util.logging` ein: Jede Benachrichtigung von Studierenden soll in
ein gemeinsames CSV-File geloggt werden. Dabei soll pro Logging-Vorgang
eine neue Zeile mit den folgenden Informationen angehängt werden:

-   Log-Level,
-   Name der den Log-Vorgang auslösenden Methode,
-   Name der Klasse, in der die den Log-Vorgang auslösenden Methode
    angesiedelt ist,
-   Log-Meldung, bestehend aus
    -   Name des kontaktierten Studierenden,
    -   genutzte Adresse des Studierenden (Mail- oder Postadresse oder
        Telefonnummer),
    -   Kontaktmodus (wird eine Mail geschickt oder ein Brief
        geschrieben oder ein Anruf getätigt).

Demonstrieren Sie in der Abgabe, wie Sie im Test oder im Hauptprogramm
den Logger steuern können, beispielsweise Änderung der Log-Level oder
Abschalten des Loggings.

#### Bearbeitung und Abgabe

-   Bearbeitung: Einzelbearbeitung oder bis zu 3er Teams
-   Abgabe:
    -   Post Mortem [im
        ILIAS](https://www.hsbi.de/elearning/goto.php?target=exc_1514856&client_id=FH-Bielefeld)
        eintragen:

        Verfassen Sie im ILIAS pro Blatt und pro Team-Mitglied ein
        aussagekräftiges und nachvollziehbares "*Post Mortem*". Gehen
        Sie dabei auf folgende Punkte ein:

        1.  Zusammenfassung: Was wurde gemacht?
        2.  Implementierungsdetails: Kurze Beschreibung besonders
            interessanter Aspekte der Umsetzung.
        3.  Was war der schwierigste Teil bei der Bearbeitung? Wie haben
            Sie dieses Problem gelöst?
        4.  Was haben Sie gelernt oder (besser) verstanden?
        5.  Team: Mit wem haben Sie zusammengearbeitet?

        Das Post Mortem muss von **jeder Person** im Team
        **individuell** verfasst und abgegeben werden. Der Umfang des
        Textes soll zwischen 200 und 400 Wörtern liegen.

        Laden Sie hier bitte **nicht** Ihre Lösungen hoch!

    -   Deadline: 09. Mai, 08:00 Uhr
-   Vorstellung im Praktikum: 09. Mai

<a id="id-d392f8d0f4dd93faa938c9737b2317ba03f5aa12"></a>

### Blatt 04: Stream-API (Git Remote, Streams, Lambda-Ausdrücke)

#### Zusammenfassung

Auf diesem Blatt üben Sie den Umgang mit Git Remotes sowie die
Erstellung von Pull-Requests auf GitHub. Darüber hinaus üben wir den
Umgang mit der Java-Stream-API und noch einmal mit Lambda-Ausdrücken.

> [!IMPORTANT]
>
> **Hinweis**: Bitte denken Sie daran, dass Sie spätestens ab diesem
> Blatt die Bearbeitung der Aufgaben in Ihren öffentlich sichtbaren
> Git-Repos durchführen sollen.
>
> Erstellen Sie ab diesem Blatt für **alle** Ihre Lösungen passende
> Pull-Requests gegen **Ihre eigenen Repos** (auch wenn dies nicht
> explizit in den Aufgaben gefordert wird).
>
> Die Links zu Ihren Pull-Requests mit den Lösungen geben Sie bitte ab
> sofort immer in Ihrem *Post Mortem* mit an.

#### Aufgaben

##### Stream-API

###### Git: Pull-Requests (und Code-Formatierung und -Dokumentation)

Forken Sie das
["Stream-API"](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_streamapi)-Repo
und erzeugen Sie eine lokale Arbeitskopie von Ihrem Fork.

Sie finden die Vorgaben für jede Teilaufgabe in einem eigenen Branch.
Checken Sie diese Branches lokal als Tracking-Branches aus und
bearbeiten Sie die Teilaufgaben jeweils in ihrem eigenen Branch. Pushen
Sie Ihre Änderungen in Ihren Fork zurück und erstellen Sie dort je einen
Pull-Request auf **Ihren** eigenen `master`-Branch.

**Bitte lassen Sie die Pull-Requests bis zur Vorstellung im Praktikum
offen.**

Achten Sie darauf, alle Schritte nachvollziehbar in Ihrer Arbeitskopie
per Git-Commit festzuhalten. Demonstrieren Sie im Praktikum, wie Sie mit
den Pull-Requests arbeiten.

###### Stream-API: Task I

Betrachten Sie den Branch `task_i`. Sie finden im Package `streamapi`
einige Hilfsklassen sowie in der Datei
[`Main.java`](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_streamapi/blob/task_i/src/main/java/streamapi/Main.java)
einen Starter für diese erste Teilaufgabe.

In der Funktion `Main#students` wird für eine Liste von
`Student`-Objekten die Summe der gesammelten ECTS berechnet.

Schreiben Sie den Body dieser Methode so um, dass die selbe
Funktionalität unter Nutzung der
[Java-Stream-API](https://dev.java/learn/api/streams/) erreicht wird.
Bevorzugen Sie dabei nach Möglichkeit Methoden-Referenzen vor
Lambda-Ausdrücken.

###### Stream-API: Task II

Betrachten Sie nun den Branch `task_ii`. Sie finden wieder im Package
`streamapi` einige Hilfsklassen sowie in der Datei
[`Main.java`](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_streamapi/blob/task_ii/src/main/java/streamapi/Main.java)
einen Starter für diese zweite Teilaufgabe.

In der Funktion `Main#ifmCps` wird für eine Liste von `Student`-Objekten
die Menge der gesammelten ECTS bestimmt. Dabei werden nur Studierende
des Informatik-Studiengangs berücksichtigt.

Was bedeutet "die Menge der gesammelten ECTS", was ist die
Mengen-Eigenschaft?

Schreiben Sie den Body dieser Methode so um, dass die selbe
Funktionalität unter Nutzung der
[Java-Stream-API](https://dev.java/learn/api/streams/) erreicht wird.
Bevorzugen Sie dabei nach Möglichkeit Methoden-Referenzen vor
Lambda-Ausdrücken.

###### Stream-API: Task III

Betrachten Sie nun den Branch `task_iii`. Sie finden wieder im Package
`streamapi` einige Hilfsklassen sowie in der Datei
[`Main.java`](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_streamapi/blob/task_iii/src/main/java/streamapi/Main.java)
einen Starter für diese dritte Teilaufgabe.

In der Funktion `Main#random` werden zunächst zehn zufällige
Integerwerte im Bereich zwischen 0 (inklusive) und 10 (exklusive)
berechnet. Anschließend werden diese Zahlen weiter verarbeitet und das
Ergebnis zurückgeliefert.

Schreiben Sie den Body dieser Methode so um, dass die selbe
Funktionalität unter Nutzung der
[Java-Stream-API](https://dev.java/learn/api/streams/) erreicht wird.
Bevorzugen Sie dabei nach Möglichkeit Methoden-Referenzen vor
Lambda-Ausdrücken.

###### Stream-API: Task IV+V

Betrachten Sie nun den Branch `task_iv_v`. Sie finden wieder im Package
`streamapi` einige Hilfsklassen sowie in der Datei
[`Main.java`](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_streamapi/blob/task_iv_v/src/main/java/streamapi/Main.java)
einen Starter für diese vierte Teilaufgabe.

1.  Ressourcen in Java

    In der Funktion `Main#getResourceAsStream` soll eine Textdatei als
    `InputStream` zum Einlesen geöffnet werden. Die Datei soll dabei im
    Ressourcen-Ordner des Projekts gesucht werden.

    Informieren Sie sich im Web über den Umgang in Java mit Ressourcen.
    Welcher Ordner wurde in der vorgegebenen Gradle-Konfiguration als
    Ressourcen-Ordner für das Projekt definiert?

    Schreiben Sie den Body dieser Methode so um, dass die zu dem
    übergebenen Dateinamen passende Ressource im Kontext der aktuellen
    Klasse als `InputStream` geöffnet wird und geben Sie diesen als
    Ergebnis zurück.

    *Hinweis*: Diese Teilaufgabe ist die Voraussetzung für die
    Bearbeitung der nächsten Teilaufgabe. Wenn Sie diese Aufgabe nicht
    hinbekommen sollten, dann definieren Sie sich ersatzweise einen
    *Text Block* (Multi-line String) mit dem Inhalt der Textdatei und
    erzeugen daraus einen `InputStream`. Das zählt dann aber nicht als
    "bearbeitet".

2.  Einlesen von Textdateien

    In der Funktion `Main#resources` wird eine Textdatei im
    Ressourcen-Ordner über eine interne Hilfsfunktion (siehe vorige
    Teilaufgabe) als `InputStream` zum Einlesen geöffnet. Über einen
    `BufferedReader` werden alle Zeilen eingelesen und anschließend alle
    Zeilen, die mit dem Buchstaben "a" beginnen und mindestens zwei
    Zeichen lang sind, wieder zusammen gefügt (mit einem Zeilenumbruch
    `\n` als Trenner).

    Schreiben Sie den Body dieser Methode so um, dass die selbe
    Funktionalität unter Nutzung der
    [Java-Stream-API](https://dev.java/learn/api/streams/) erreicht
    wird. Bevorzugen Sie dabei nach Möglichkeit Methoden-Referenzen vor
    Lambda-Ausdrücken.

##### Record-Klassen

Machen Sie aus der Klasse `streamapi.Student` eine Record-Klasse.

#### Bearbeitung und Abgabe

-   Bearbeitung: Einzelbearbeitung oder bis zu 3er Teams
-   Abgabe:
    -   Post Mortem [im
        ILIAS](https://www.hsbi.de/elearning/goto.php?target=exc_1514856&client_id=FH-Bielefeld)
        eintragen:

        Verfassen Sie im ILIAS pro Blatt und pro Team-Mitglied ein
        aussagekräftiges und nachvollziehbares "*Post Mortem*". Gehen
        Sie dabei auf folgende Punkte ein:

        1.  Zusammenfassung: Was wurde gemacht?
        2.  Implementierungsdetails: Kurze Beschreibung besonders
            interessanter Aspekte der Umsetzung.
        3.  Was war der schwierigste Teil bei der Bearbeitung? Wie haben
            Sie dieses Problem gelöst?
        4.  Was haben Sie gelernt oder (besser) verstanden?
        5.  Team: Mit wem haben Sie zusammengearbeitet?
        6.  Links zu Ihren Pull-Requests mit der Lösung.

        Das Post Mortem muss von **jeder Person** im Team
        **individuell** verfasst und abgegeben werden. Der Umfang des
        Textes soll zwischen 200 und 400 Wörtern liegen.

        Laden Sie hier bitte **nicht** Ihre Lösungen hoch!

    -   Deadline: 23. Mai, 08:00 Uhr
-   Vorstellung im Praktikum: 23. Mai

<a id="id-96a6e702ef5bbea0815334b0b819b91864e526c7"></a>

### Blatt 05: Katzen-Café (Streams, JUnit, Optional\<\>, Visitor)

#### Zusammenfassung

Auf diesem Blatt üben Sie den Umgang mit der Java-Stream-API und
`Optional<>`. Sie erstellen erste JUnit-Tests und implementieren das
Visitor-Pattern für ein einfaches Beispiel.

> [!IMPORTANT]
>
> **Hinweis**: Bitte denken Sie daran, dass Sie spätestens seit Blatt 04
> die Bearbeitung der Aufgaben in Ihren öffentlich sichtbaren Git-Repos
> durchführen sollen.
>
> Erstellen Sie für **alle** Ihre Lösungen passende Pull-Requests gegen
> **Ihre eigenen Repos** (auch wenn dies nicht explizit in den Aufgaben
> gefordert wird).
>
> Die Links zu Ihren Pull-Requests mit den Lösungen geben Sie bitte
> immer in Ihrem *Post Mortem* mit an.

#### Aufgaben

##### Katzen-Café

Forken Sie das
["Cat-Cafe"](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_catcafe)-Repo
und erzeugen Sie sich eine lokale Arbeitskopie von Ihrem Fork.

###### Code-Analyse

Analysieren Sie die Modellierung des Binärbaums (`Tree`, `Empty`,
`Node`) und erklären Sie die Funktionsweise:

-   Was sind Vorteile, was sind Nachteile dieser Modellierung?
-   Was musste getan werden, um die selbst implementierten Bäume in
    Schleifen (`Tree<X> mytree; for (Tree<X> t: mytree) {...}`) und in
    Streams `Tree<X> mytree; mytree.stream(). ...` nutzen zu können?
-   Wie funktioniert der `TreeIterator`?

###### Umgang mit `Optional<>`

Bauen Sie die beiden Methoden `CatCafe#getCatByName` und
`CatCafe#getCatByWeight` so um, dass ein passendes `Optional<>`
zurückgeliefert wird. Passen Sie die entsprechenden Methodenaufrufe in
`Main#main` entsprechend an.

*Tipp*: Stellen Sie in den beiden Methoden auf die
[Java-Stream-API](https://dev.java/learn/api/streams/) um, dann ergibt
sich die Nutzung von `Optional<>` fast von selbst.

###### JUnit

Erstellen Sie mit JUnit 4 oder 5 mindestens 10 unterschiedliche
Testfälle für die Klasse `CatCafe`.

*Tipp*: In der Gradle-Konfiguration der Vorgabe ist bereits JUnit5
konfiguriert, d.h. die entsprechenden Abhängigkeiten werden durch Gradle
aufgelöst. Wenn Sie die Vorgaben als Gradle-Projekt in Ihrer IDE öffnen,
dann steht Ihnen dort auch die JUnit5-Bibliothek automatisch zur
Verfügung. Wenn Sie JUnit4 nutzen möchten, müssten Sie bitte die
Gradle-Konfiguration entsprechend anpassen. Mit `./gradlew test` können
Sie entsprechende Testfälle ausführen.

###### Visitor-Pattern

Die Klasse `CatCafe` hat eine Methode `CatCafe#accept`, die einen
Visitor mit dem parametrischen Typ `TreeVisitor` an das intern genutzte
Feld `Tree<FelineOverLord> clowder` weiterleitet.

Implementieren Sie das Visitor-Pattern für den Baum (`Tree`), indem Sie
das Interface `TreeVisitor` implementieren:

1.  Erstellen Sie einen konkreten Visitor `InOrderVisitor`, der den Baum
    **inorder** traversiert.
2.  Erstellen Sie einen weiteren konkreten Visitor `PostOrderVisitor`,
    der den Baum **postorder** traversiert.

Beim Besuch eines Knotens soll jeweils die Methode `toString()` für den
Datenanteil aufgerufen werden und passend mit den Ergebnissen der
Traversierung der linken und rechten Teilbäume konkateniert werden und
der resultierende String zurückgeben werden.

Fügen Sie passende Aufrufe der beiden Visitoren in `Main#main` hinzu.

#### Bearbeitung und Abgabe

-   Bearbeitung: Einzelbearbeitung oder bis zu 3er Teams
-   Abgabe:
    -   Post Mortem [im
        ILIAS](https://www.hsbi.de/elearning/goto.php?target=exc_1514856&client_id=FH-Bielefeld)
        eintragen:

        Verfassen Sie im ILIAS pro Blatt und pro Team-Mitglied ein
        aussagekräftiges und nachvollziehbares "*Post Mortem*". Gehen
        Sie dabei auf folgende Punkte ein:

        1.  Zusammenfassung: Was wurde gemacht?
        2.  Implementierungsdetails: Kurze Beschreibung besonders
            interessanter Aspekte der Umsetzung.
        3.  Was war der schwierigste Teil bei der Bearbeitung? Wie haben
            Sie dieses Problem gelöst?
        4.  Was haben Sie gelernt oder (besser) verstanden?
        5.  Team: Mit wem haben Sie zusammengearbeitet?
        6.  Links zu Ihren Pull-Requests mit der Lösung.

        Das Post Mortem muss von **jeder Person** im Team
        **individuell** verfasst und abgegeben werden. Der Umfang des
        Textes soll zwischen 200 und 400 Wörtern liegen.

        Laden Sie hier bitte **nicht** Ihre Lösungen hoch!

    -   Deadline: 30. Mai, 08:00 Uhr
-   Vorstellung im Praktikum: 30. Mai

<a id="id-f80f5e162e1aaa7ad98f24b776c109c056062b7c"></a>

### Blatt 06: Cycle Chronicles (ÄK&GW, Mocking)

#### Zusammenfassung

Auf diesem Blatt üben Sie die Erstellung von Testfällen mit der
Äquivalenzklassenbildung und Grenzwertanalyse. Sie üben den Einsatz mit
Mockito. Zusätzlich haben Sie die Gelegenheit, noch einmal mit Logging
und Record-Klassen zu arbeiten.

> [!IMPORTANT]
>
> **Hinweis**: Bitte denken Sie daran, dass Sie spätestens seit Blatt 04
> die Bearbeitung der Aufgaben in Ihren öffentlich sichtbaren Git-Repos
> durchführen sollen.
>
> Erstellen Sie für **alle** Ihre Lösungen passende Pull-Requests gegen
> **Ihre eigenen Repos** (auch wenn dies nicht explizit in den Aufgaben
> gefordert wird).
>
> Die Links zu Ihren Pull-Requests mit den Lösungen geben Sie bitte
> immer in Ihrem *Post Mortem* mit an.

#### Aufgaben

Forken Sie das ["Cycle
Chronicles"](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_cyclechronicles)-Repo
und erzeugen Sie sich eine lokale Arbeitskopie von Ihrem Fork.

##### Analyse: Äquivalenzklassen & Grenzwerte

Die Methode `Shop#accept` dient zur Annahme eines neuen Auftrags eines
Kunden.

Neue Aufträge sollen nur unter bestimmten Bedingungen angenommen werden:

-   Es darf sich nicht um ein E-Bike handeln.
-   Es darf sich nicht um ein Gravel-Bike handeln.
-   Der Kunde darf nicht noch andere offene Aufträge beim Shop haben (es
    kann pro Kunden immer nur maximal einen offenen Auftrag in der
    Warteschlange geben).
-   Es sind aktuell höchstens vier andere offene Aufträge vorhanden (es
    dürfen zu jeder Zeit maximal fünf offene Aufträge in der
    Warteschlange sein).

Der Rückgabewert der Methode signalisiert, ob der Auftrag angenommen
wurde und in die Warteschlange der offenen Aufträge eingereiht wurde
(`true`) oder ob er abgelehnt wurde (`false`).

Aufgaben:

1.  Erstellen Sie eine Äquivalenzklassen- und Grenzwert-Analyse.
2.  Erstellen Sie aus den ermittelten ÄK und GW konkrete Testfälle.
    (**Noch keine Implementierung!**)

##### Mocking I

Implementieren Sie nun die in der vorigen Aufgabe ermittelten Testfälle
für die Methode `Shop#accept` mit Hilfe von JUnit (Version 4 oder 5).

Leider gibt es beim Ausführen vieler Ihrer JUnit-Testmethoden eine
`UnsupportedOperationException`-Exception, da die Klasse `Order` bisher
nur unvollständig implementiert ist: Es existieren praktisch nur die
Methodensignaturen, der Aufruf der Methoden liefert nur eine
`UnsupportedOperationException`.

Setzen Sie aktiv Mocking mit Mockito ein, um Ihre JUnit-Tests für
`Shop#accept` ausführbar zu machen. Begründen Sie die Anwendung von
Mockito.

**Wichtig**: Die zu testende Methode `Shop#accept` soll in der
vorliegenden Implementierung im Test genutzt werden, d.h. sie darf nicht
"weg-gemockt" werden!

*Tipp*: In der Gradle-Konfiguration der Vorgabe ist bereits JUnit5 und
Mockito vorkonfiguriert, d.h. die entsprechenden Abhängigkeiten werden
durch Gradle aufgelöst. Wenn Sie die Vorgaben als Gradle-Projekt in
Ihrer IDE öffnen, dann steht Ihnen dort auch die JUnit5-Bibliothek
automatisch zur Verfügung. Wenn Sie JUnit4 nutzen möchten, müssten Sie
bitte die Gradle-Konfiguration entsprechend anpassen. Mit
`./gradlew test` können Sie Ihre Testfälle ausführen.

##### Mocking II

Die Methoden `Shop#repair` und `Shop#deliver` sind auch noch nicht
implementiert. Nutzen Sie geeignetes Mocking, um für diese beiden
Methoden Tests in JUnit zu implementieren. Begründen Sie die Anwendung
von Mockito.

*Hinweis*: Sie *müssen* hier keine ÄK/GW-Analyse machen, können das aber
natürlich gern tun.

##### Record-Klassen

Die Klasse `Order` ist zwar bisher nur unvollständig implementiert, aber
Sie können bereits deutlich erkennen, dass es zwei Attribute geben muss
(welche?).

Bauen Sie die Klasse in eine passende Record-Klasse mit den
entsprechenden Attributen um. Sie dürfen die beiden Methoden in `Order`
auch geeignet "implementieren" und umbenennen - die Umbenennung muss
dann aber auch in den Aufrufen in `Shop` und in Ihren JUnit-Tests
passieren!

##### Logging

Bauen Sie für den `Shop` ein Logging auf der Basis von
`java.util.logging` ein: Jede Änderung an der Auftrags-Warteschlange
`pendingOrders` und auch an der Menge der fertigen Aufträge
`completedOrders` soll in ein gemeinsames CSV-File geloggt werden. Dabei
soll pro Logging-Vorgang eine neue Zeile mit den folgenden Informationen
angehängt werden:

-   Log-Level,
-   Name der den Log-Vorgang auslösenden Methode,
-   Name der Klasse, in der die den Log-Vorgang auslösenden Methode
    angesiedelt ist,
-   Log-Meldung, bestehend aus
    -   den beiden Details der Order (Fahrradtyp, Name des Kunden), und
    -   dem Namen der betroffenen Datenstruktur ("pendingOrders" oder
        "completedOrders").

Demonstrieren Sie in der Abgabe, wie Sie im Test oder im Hauptprogramm
den Logger steuern können, beispielsweise Änderung der Log-Level oder
Abschalten des Loggings.

*Tipp*: Der Aufruf von `Shop#repair` ändert sowohl `pendingOrders` als
auch `completedOrders` - hier müssen also beim Logging zwei neue Zeilen
im Logfile angelegt werden.

**Hinweis**: Da in den Klassen der Vorgabe die meisten Methoden nicht
implementiert sind, müssen Sie dies für diese Aufgabe selbst flink
erledigen. Es handelt sich um die vier Methoden `Shop#repair` und
`Shop#deliver` sowie `Order#getBicycleType` und
`Order#getBicycleType`.[^9]

#### Bearbeitung und Abgabe

-   Bearbeitung: Einzelbearbeitung oder bis zu 3er Teams
-   Abgabe:
    -   Post Mortem [im
        ILIAS](https://www.hsbi.de/elearning/goto.php?target=exc_1514856&client_id=FH-Bielefeld)
        eintragen:

        Verfassen Sie im ILIAS pro Blatt und pro Team-Mitglied ein
        aussagekräftiges und nachvollziehbares "*Post Mortem*". Gehen
        Sie dabei auf folgende Punkte ein:

        1.  Zusammenfassung: Was wurde gemacht?
        2.  Implementierungsdetails: Kurze Beschreibung besonders
            interessanter Aspekte der Umsetzung.
        3.  Was war der schwierigste Teil bei der Bearbeitung? Wie haben
            Sie dieses Problem gelöst?
        4.  Was haben Sie gelernt oder (besser) verstanden?
        5.  Team: Mit wem haben Sie zusammengearbeitet?
        6.  Links zu Ihren Pull-Requests mit der Lösung.

        Das Post Mortem muss von **jeder Person** im Team
        **individuell** verfasst und abgegeben werden. Der Umfang des
        Textes soll zwischen 200 und 400 Wörtern liegen.

        Laden Sie hier bitte **nicht** Ihre Lösungen hoch!

    -   Deadline: 06. Juni, 08:00 Uhr
-   Vorstellung im Praktikum: 06. Juni

<a id="id-83476d78577cf7ca1cbc9b26afe056c03f1836fc"></a>

### Blatt 07: Bike-Shop (Refactoring, Javadoc)

#### Zusammenfassung

Auf diesem Blatt üben Sie den Einsatz von Refactoring und das
Dokumentieren von Code mit Javadoc.

> [!IMPORTANT]
>
> **Hinweis**: Bitte denken Sie daran, dass Sie spätestens seit Blatt 04
> die Bearbeitung der Aufgaben in Ihren öffentlich sichtbaren Git-Repos
> durchführen sollen.
>
> Erstellen Sie für **alle** Ihre Lösungen passende Pull-Requests gegen
> **Ihre eigenen Repos** (auch wenn dies nicht explizit in den Aufgaben
> gefordert wird).
>
> Die Links zu Ihren Pull-Requests mit den Lösungen geben Sie bitte
> immer in Ihrem *Post Mortem* mit an.

#### Aufgaben

##### Javadoc-Kommentare

Gute Javadoc-Kommentare schreiben erfordert Übung. Schauen Sie sich die
in Commit
[Dungeon-CampusMinden/Dungeon/commit/46530b6](https://github.com/Dungeon-CampusMinden/Dungeon/commit/46530b6dc970a8cedb0610b92268b9c78345e067)
neu hinzugefügte Datei
[code/core/src/controller/ControllerLayer.java](https://github.com/Dungeon-CampusMinden/Dungeon/blob/46530b6dc970a8cedb0610b92268b9c78345e067/code/core/src/controller/ControllerLayer.java)
an.

Diskutieren Sie jeweils, was Ihnen an der Dokumentation dieser Klasse
auffällt: Was gefällt Ihnen, was stört Sie? Schlagen Sie Verbesserungen
vor.

##### Refactoring im Bike-Shop

Forken Sie das
[Refactoring](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_refactoring)-Repo
und erzeugen Sie sich eine lokale Arbeitskopie von Ihrem Fork.
Analysieren Sie die Klassen im Package `refactoring`. Sie finden
unübersichtlichen und schlecht strukturierten und schlecht benannten und
schlecht dokumentierten Code.

1.  Welche *Bad Smells* können Sie hier identifizieren?

2.  Erstellen Sie eine Testsuite, um potentielle Verhaltensänderungen
    beim Refactoring identifizieren zu können.

3.  Beheben Sie die Smells durch die **schrittweise Anwendung** von den
    aus der Vorlesung bekannten Refactoring-Methoden. Wenden Sie dabei
    *mindestens* die unten genannten Methoden an:

    -   Extract Method/Class
    -   Move Method/Field
    -   Encapsulate Method/Field
    -   Pull Up oder Push Down

    Ergänzend zu der Übersicht aus der Vorlesung finden sie unter
    [Refactoring Guru](https://refactoring.guru/refactoring/techniques)
    eine erweiterte Darstellung gängiger Refactoring-Techniken.

    Machen Sie pro Refactoring-Schritt einen Commit, und halten Sie alle
    Commits in einem gemeinsamen Pull-Request fest. An diesem können Sie
    im Praktikum Ihr Vorgehen vorstellen.

Nach dem Refactoring sollte ein `./gradlew check` keine Probleme bzgl.
Formatierung und Dokumentation[^10] mehr finden.

*Tipp*: Schauen Sie schlechter Namensgebung, nach redundantem Code, nach
übermäßig komplexer Logik, nach Code/Logik in der falschen Klasse (am
falschen Ort), nach übermäßig vielen Parametern, nach fehlendem Javadoc,
....

#### Bearbeitung und Abgabe

-   Bearbeitung: Einzelbearbeitung oder bis zu 3er Teams
-   Abgabe:
    -   Post Mortem [im
        ILIAS](https://www.hsbi.de/elearning/goto.php?target=exc_1514856&client_id=FH-Bielefeld)
        eintragen:

        Verfassen Sie im ILIAS pro Blatt und pro Team-Mitglied ein
        aussagekräftiges und nachvollziehbares "*Post Mortem*". Gehen
        Sie dabei auf folgende Punkte ein:

        1.  Zusammenfassung: Was wurde gemacht?
        2.  Implementierungsdetails: Kurze Beschreibung besonders
            interessanter Aspekte der Umsetzung.
        3.  Was war der schwierigste Teil bei der Bearbeitung? Wie haben
            Sie dieses Problem gelöst?
        4.  Was haben Sie gelernt oder (besser) verstanden?
        5.  Team: Mit wem haben Sie zusammengearbeitet?
        6.  Links zu Ihren Pull-Requests mit der Lösung.

        Das Post Mortem muss von **jeder Person** im Team
        **individuell** verfasst und abgegeben werden. Der Umfang des
        Textes soll zwischen 200 und 400 Wörtern liegen.

        Laden Sie hier bitte **nicht** Ihre Lösungen hoch!

    -   Deadline: 20. Juni, 08:00 Uhr
-   Vorstellung im Praktikum: 20. Juni

<a id="id-f446a81e524a27594ec457a16742d232a92912c6"></a>

### Blatt 08: Syntax Highlighting (Reguläre Ausdrücke, Template-Method, Command)

#### Zusammenfassung

Auf diesem Blatt üben Sie den Umgang mit regulären Ausdrücken in Java.
Wir nutzen diese zusammen mit dem Template-Method-Pattern für die
Implementierung eines einfachen Syntax-Highlightings.

> [!IMPORTANT]
>
> **Hinweis**: Bitte denken Sie daran, dass Sie spätestens seit Blatt 04
> die Bearbeitung der Aufgaben in Ihren öffentlich sichtbaren Git-Repos
> durchführen sollen.
>
> Erstellen Sie für **alle** Ihre Lösungen passende Pull-Requests gegen
> **Ihre eigenen Repos** (auch wenn dies nicht explizit in den Aufgaben
> gefordert wird).
>
> Die Links zu Ihren Pull-Requests mit den Lösungen geben Sie bitte
> immer in Ihrem *Post Mortem* mit an.

#### Aufgaben

##### Syntaxhighlighting mit RegExp

Klonen Sie die [Vorgaben "Syntax
Highlighting"](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_highlighting)
und laden Sie das Projekt als Gradle-Projekt in Ihre IDE.

Im Package `highlighting` finden Sie einige Klassen, mit denen man ein
einfaches Syntax Highlighting durchführen kann. Dazu arbeitet der Lexer
mit sogenannten "Token" (Instanzen der Klasse `Token`). Diese haben
einen regulären Ausdruck, um bestimmte Teile im Code zu erkennen,
beispielsweise Keywords oder Kommentare und anderes. Der Lexer wendet
alle Token auf den aktuellen Eingabezeichenstrom an (Methode
`Token#test()`), und die Token prüfen mit "ihrem" regulären Ausdruck, ob
die jeweils passende Eingabesequenz vorliegt. Die regulären Ausdrücke
übergeben Sie dem `Token`-Konstruktor als entsprechendes
`Pattern`-Objekt.

-   Die Klasse `Token` speichert dazu ein `Pattern` (einen
    vorkompilierten regulären Ausdruck) sowie eine Farbe, die später
    beim Syntax Highlighting für dieses Token genutzt werden soll. Bei
    der Anwendung eines Tokens auf einen String (Methode `Token#test`)
    wird das gespeicherte Pattern auf den String angewendet und eine
    Liste aller passenden Stellen im String zurückgegeben
    (`List<Lexem>`).

    Neben dem jeweiligen Pattern kennt jedes Token noch eine
    `matchingGroup`: Dies ist ein Integer, der die relevante
    Matching-Group im regulären Ausdruck bezeichnet. Wenn Sie keine
    eigenen Gruppen in einem regulären Ausdruck eingebaut haben, nutzen
    Sie hier einfach den Wert 0.

    Zusätzlich kennt jedes Token noch die Farbe für das
    Syntax-Highlighting in der von uns als Vorgabe realisierten
    Swing-GUI (Instanz von `Color`).

-   Der `Lexer` sammelt eine Liste von `Token` und wendet sie in der
    übergebenen Reihenfolge auf den Eingabestring an (Methode
    `Lexer#tokenize`).

-   Die Klasse `LexerUI` dient zum Anzeigen des ursprünglichen Textes
    und des Ergebnisses. Hier sieht man recht schnell, ob die Pattern
    bereits passen ... Man kann auf der linken Seite auch den Text
    editieren, und auf der rechten Seite des Fensters wird dann
    automatisch das Syntax Highlighting erneut durchgeführt.

-   Die Klasse `Main` dient zum Definieren der konkreten Token (=\>
    Aufgabe) und auch zum Starten der Demo.

**Aufgabe**: Definieren Sie alle in `Main#setupTokens` genannten Token,
indem Sie jeweils einen passenden regulären Ausdruck formulieren und als
Pattern in den Konstruktor geben zusammen mit einer Farbe, mit der
dieses Token hervorgehoben werden soll:

-   Strings: alles zwischen `"` und dem nächsten `"`
-   Character: genau ein Zeichen zwischen `'` und `'`
-   Keywords: `package`, `import`, `class`, `public`, `private`,
    `final`, `return`, `null`, `new` (jeweils freistehend, also nicht
    "newx" o.ä.)
-   Annotation: beginnt mit `@`, enthält Buchstaben oder Minuszeichen
-   Einzeiliger Kommentar: beginnend mit `//` bis zum Zeilenende
-   Mehrzeiliger Kommentar: alles zwischen `/*` und dem nächsten `*/`
-   Javadoc-Kommentar: alles zwischen `/**` und dem nächsten `*/`

Sie können auch mit *Matching Groups* arbeiten und im Token eine
bestimmte Gruppe hervorheben lassen. Dazu geben Sie einfach die Nummer
der Matching-Group mit in den Token-Konstruktor. (Wenn Sie nichts
übergeben, wird der gesamte Match genommen - das entspricht dem Wert 0).

Sollten Token ineinander geschachtelt sein, erkennt der Lexer dies
automatisch. Sie brauchen sich keine Gedanken dazu machen, in welcher
Reihenfolge die Token eingefügt und abgearbeitet werden. Beispiel: Im
regulären Ausdruck für den einzeiligen Kommentar brauchen Sie keine
Keywords, Annotationen, Strings usw. erkennen.

#### Bearbeitung und Abgabe

-   Bearbeitung: Einzelbearbeitung oder bis zu 3er Teams
-   Abgabe:
    -   Post Mortem [im
        ILIAS](https://www.hsbi.de/elearning/goto.php?target=exc_1514856&client_id=FH-Bielefeld)
        eintragen:

        Verfassen Sie im ILIAS pro Blatt und pro Team-Mitglied ein
        aussagekräftiges und nachvollziehbares "*Post Mortem*". Gehen
        Sie dabei auf folgende Punkte ein:

        1.  Zusammenfassung: Was wurde gemacht?
        2.  Implementierungsdetails: Kurze Beschreibung besonders
            interessanter Aspekte der Umsetzung.
        3.  Was war der schwierigste Teil bei der Bearbeitung? Wie haben
            Sie dieses Problem gelöst?
        4.  Was haben Sie gelernt oder (besser) verstanden?
        5.  Team: Mit wem haben Sie zusammengearbeitet?
        6.  Links zu Ihren Pull-Requests mit der Lösung.

        Das Post Mortem muss von **jeder Person** im Team
        **individuell** verfasst und abgegeben werden. Der Umfang des
        Textes soll zwischen 200 und 400 Wörtern liegen.

        Laden Sie hier bitte **nicht** Ihre Lösungen hoch!

    -   Deadline: 27. Juni, 08:00 Uhr
-   Vorstellung im Praktikum: 27. Juni

<a id="id-31c5e287bbe09bf1d8bf14a0cb61f2cfc1f85986"></a>

### Blatt 09: Zoo (Generics)

#### Zusammenfassung

Auf diesem Blatt üben Sie das Erstellen und den Einsatz von generischen
Klassen und Methoden in Java.

> [!IMPORTANT]
>
> **Hinweis**: Bitte denken Sie daran, dass Sie spätestens seit Blatt 04
> die Bearbeitung der Aufgaben in Ihren öffentlich sichtbaren Git-Repos
> durchführen sollen.
>
> Erstellen Sie für **alle** Ihre Lösungen passende Pull-Requests gegen
> **Ihre eigenen Repos** (auch wenn dies nicht explizit in den Aufgaben
> gefordert wird).
>
> Die Links zu Ihren Pull-Requests mit den Lösungen geben Sie bitte
> immer in Ihrem *Post Mortem* mit an.

#### Aufgaben

Sie finden in den
[Vorgaben](https://github.com/Programmiermethoden-CampusMinden/prog2_ybel_zoo)
im Package `zoo` einige Interfaces und Klassen, mit denen man einen Zoo
modellieren kann. Klonen Sie das Vorgabe-Repo und laden Sie das Projekt
als Gradle-Projekt in Ihre IDE.

##### Nicht-generische Klassen

Sie finden einige Interfaces, die das Interface `Animal` erweitern,
beispielsweise `Fish`, `Reptile`, `Cat`, ...

Erstellen Sie für jedes dieser Interfaces jeweils zwei Java-Klassen, die
konkrete Mitglieder der jeweiligen Tier-Klasse bzw. -Familie[^11]
repräsentieren und die jeweils das Interface implementieren.
Beispielsweise könnte eine Forelle eine Art in der Klasse der Fische
sein, d.h. die Java-Klasse `Trout` könnte das Interface `Fish`
implementieren.

Diese Java-Klassen sollen nicht-generisch sein. Die `move()`-Methode
soll einfach einen String auf der Konsole ausgeben, wie sich dieses Tier
bewegen würde. Mit der `getName()`-Methode soll ein kurzer Name,
beispielsweise der Tierklasse, zurückgegeben werden.

*Hinweis*: Die mit `default` markierten Methoden in `Fish`, `Mammal` und
`Reptile` brauchen Sie in Ihren Klassen nicht implementieren. Wir werden
später im Semester noch über die sogenannten
["Default-Methoden"](#id-83d9242997f09b086df2b42d7c636f083f0ab02e)
sprechen.

##### Generische Klassen

Um Gehege zu modellieren, erstellen Sie in eine generische Klasse
`Habitat` mit einer Typ-Variablen. Stellen Sie durch geeignete
Beschränkung der Typ-Variablen sicher, dass nur Gehege mit von `Animal`
abgeleiteten Typen gebildet werden können.

Es sollen (mindestens) folgende Methoden existieren:

-   `void add(Animal animal)` zur Aufnahme eines Tieres in das Gehege
-   `void remove(Animal animal)` um ein Tier aus einem Gehege zu
    entfernen
-   `String getName()` um den Namen des Geheges zu bestimmen

*Hinweis*: Der Parametertyp `Animal` in den Methoden muss entsprechend
angepasst werden.

Jedes einzelne Tier im Gehege kann maximal einmal vorkommen. Begründen
Sie die Wahl der Datenstruktur.

Legen Sie in Ihrer `main()`-Methode mindestens zwei konkrete Gehege als
Instanzen der neuen generischen Klasse `Habitat` an. Dabei sollen in
diesen konkreten Gehegen nur jeweils verschiedene Tiere einer "Art"
(beispielweise Löwen, Hamster, ...) vorkommen. Fügen Sie einige passende
Tiere in die beiden Gehege ein.

##### Generische Klassen reloaded

Für die Repräsentation eines Zoologischen Gartens mit mehreren
verschiedenen Gehegen erstellen Sie nun eine generische Klasse `Zoo` mit
einer Typ-Variablen. Stellen Sie durch geeignete Beschränkung der
Typ-Variablen sicher, dass nur Zoos mit von `Habitat` abgeleiteten Typen
gebildet werden können.

Ein Zoo soll (mindestens) folgende Methoden besitzen:

-   `void build(Habitat habitat)` zur Aufnahme eines neuen Geheges in
    den Zoo
-   `void abandon(Habitat habitat)` um ein Gehege aus dem Zoo zu
    entfernen
-   `void visitAllHabitats()` um die Gehege in der Reihenfolge des
    Hinzufügens zu besuchen (d.h. ihren Namen auf der Konsole
    auszugeben)

*Hinweis*: Der Parametertyp `Habitat` in den Methoden muss entsprechend
angepasst werden.

Jedes Gehege gibt es pro Zoo nur maximal einmal, und die Reihenfolge des
Errichtens definiert eine Ordnung auf den Gehegen. Begründen Sie die
Wahl der Datenstruktur.

Legen Sie in Ihrer `main()`-Methode einen konkreten Zoo als Instanz der
neuen generischen Klasse `Zoo` an. Dieser Zoo soll einige Gehege für
verschiedene Tiere beinhalten.

##### Ableiten nicht-generischer Klassen

Leiten Sie von `Zoo` eine nicht-generische Klasse `Aquarium` ab.
Aquarien können nur mit Gehegen angelegt werden, deren Tiere vom Typ
`Fish` (oder abgeleitet) sind.

Legen Sie in Ihrer `main()`-Methode ein konkretes Aquarium als Instanz
der neuen nicht-generischen Klasse `Aquarium` an und gruppieren Sie
darin verschiedene Fisch-"Gehege".

#### Bearbeitung und Abgabe

-   Bearbeitung: Einzelbearbeitung oder bis zu 3er Teams
-   Abgabe:
    -   Post Mortem [im
        ILIAS](https://www.hsbi.de/elearning/goto.php?target=exc_1514856&client_id=FH-Bielefeld)
        eintragen:

        Verfassen Sie im ILIAS pro Blatt und pro Team-Mitglied ein
        aussagekräftiges und nachvollziehbares "*Post Mortem*". Gehen
        Sie dabei auf folgende Punkte ein:

        1.  Zusammenfassung: Was wurde gemacht?
        2.  Implementierungsdetails: Kurze Beschreibung besonders
            interessanter Aspekte der Umsetzung.
        3.  Was war der schwierigste Teil bei der Bearbeitung? Wie haben
            Sie dieses Problem gelöst?
        4.  Was haben Sie gelernt oder (besser) verstanden?
        5.  Team: Mit wem haben Sie zusammengearbeitet?
        6.  Links zu Ihren Pull-Requests mit der Lösung.

        Das Post Mortem muss von **jeder Person** im Team
        **individuell** verfasst und abgegeben werden. Der Umfang des
        Textes soll zwischen 200 und 400 Wörtern liegen.

        Laden Sie hier bitte **nicht** Ihre Lösungen hoch!

    -   Deadline: 04. Juli, 08:00 Uhr
-   Vorstellung im Praktikum: 04. Juli

<a id="id-d033e22ae348aeb5660fc2140aec35850c4da997"></a>

## Organisatorisches

<a id="id-5020900ace8eaeeefbf1af116d61d159ae6dba2b"></a>

### Prüfungsvorbereitung

> [!IMPORTANT]
>
> <details open>
> <summary><strong>🎯 TL;DR</strong></summary>
>
> **Durchführung: Präsenz oder Open-Book (je nach Corona-Lage)**
>
> Die Klausur wird dieses Semester elektronisch stattfinden. Dazu werden
> wir den Prüfungs-ILIAS der HSBI nutzen.
>
> Sofern die Situation dies zulässt, wird die Klausur in den Räumen der
> HSBI am Campus Minden unter Aufsicht durchgeführt. Hier werden Ihnen
> Rechner für den Zugang zum Prüfungs-ILIAS zur Verfügung gestellt, Sie
> benötigen nur Ihre HSBI-Zugangsdaten (User, Passwort), einen
> Studierendenausweis und Personalausweis sowie Ihren
> DIN-A4-Spickzettel.
>
> Wenn die Corona-Lage eine Durchführung in Präsenz nicht erlaubt, wird
> die Klausur stattdessen als *Open-Book-Ausarbeitung* aus dem
> Home-Office durchgeführt. Sie benötigen dazu einen normalen Rechner
> oder Laptop mit einem Standardbrowser. Tablets und Handys können wg.
> der Mobil-Version der Browser problematisch sein. Sie müssen
> JavaScript aktivieren und Cookies zulassen, der Privacy-Modus ist
> bitte ebenfalls zu deaktivieren. Sie erreichen den Prüfungs-ILIAS
> [eassessment.hsbi.de](https://eassessment.hsbi.de) nur über VPN.
>
> Die Entscheidung über die konkrete Durchführung wird spätestens zwei
> Wochen vor der Prüfung getroffen und Ihnen per EMail über das LSF
> mitgeteilt.
>
> **Ablauf der Klausur**
>
> Die Prüfung (das ILIAS-Objekt) selbst schalte ich erst zum Start der
> Prüfung online. Bei der Durchführung als Open-Book-Ausarbeitung wird
> parallel zur Prüfung eine Zoom-Sitzung laufen, in der Sie Fragen
> stellen können.
>
> **Hilfsmittel und Themen**
>
> Bei der Durchführung in Präsenz am Campus Minden ist ein Spickzettel
> (DIN A4, beidseitig beschrieben) als Hilfsmittel zugelassen.
>
> Bei der Durchführung als "Open-Book-Ausarbeitung" im Home-Office sind
> alle Hilfsmittel zugelassen.
>
> Die Unterstützung durch Dritte bzw. jegliche Kommunikation mit Dritten
> ist in keinem Fall zugelassen. Sie sollen die Prüfung selbstständig
> bearbeiten.
>
> Es wird keines der behandelten Themen ausgeschlossen, allerdings
> eignen sich manche Themen etwas besser für Klausurfragen als andere
> ;-)
> </details>

> [!TIP]
>
> <details open>
> <summary><strong>🎦 Videos</strong></summary>
>
> -   [Hinweise zur Prüfung:
>     Fragetypen-Demo](https://youtu.be/warjJ9ZXvEM)
> -   [Hinweise zur Prüfung: Technische
>     Vorbereitung](https://youtu.be/_cVhJX-D6zM)
>
> </details>

#### Elektronische Klausur: Termin, Materialien

##### Termin

Die schriftliche Prüfung erfolgt durch eine Klausur, die als digitale
Prüfung auf einem Prüfungs-ILIAS durchgeführt wird.

Es wird angestrebt, die Klausur in Präsenz in den Rechnerpools am Campus
Minden durchzuführen. Falls dies wegen der Corona-Situation oder anderer
Umstände nicht möglich sein sollte, wird die Klausur als
"Open-Book-Ausarbeitung" im Home-Office durchgeführt.

Es wird in beiden Prüfungszeiträumen ein Termin angeboten. Die Termine
werden vom Prüfungsamt bekannt gegeben.

Dauer jeweils 90 Minuten.

-   Die konkrete Durchführungsform (in Präsenz am Campus Minden oder im
    Home-Office) wird Ihnen spätestens zwei Wochen vor der Prüfung über
    das LSF bekanntgegeben

##### Zugelassene Hilfsmittel

<details>
<summary><strong>Präsenz (in Minden)</strong></summary>

**Zugelassene Materialien**: **DIN-A4-Spickzettel (beidseitig)**

Sie dürfen **einen** Spickzettel im **DIN-A4**-Format benutzen, der
beidseitig beschrieben sein kann.

Ich möchte Sie hier noch einmal ermuntern, diesen Zettel tatsächlich
manuell zu erstellen (also ganz traditionell zu **schreiben**), da
bereits der Schreibvorgang einen gewissen Lerneffekt bewirkt!
</details>
<details>
<summary><strong>Open-Book-Ausarbeitung (Homeoffice)</strong></summary>

Falls die Prüfung als Open-Book-Ausarbeitung im Home-Office durchgeführt
werden sollte, dürfen Sie alle Unterlagen benutzen.

-   Ausnahme: **Keine Hilfe durch Dritte!** (insbesondere keine
    Zusammenarbeit, keine Kommunikation)

    Sie sollen die Prüfung eigenständig bearbeiten. Hilfe von Dritten
    sowie jegliche Kommunikation mit Dritten ist in keinem Fall
    zugelassen und wird als Täuschungsversuch gewertet.

</details>

##### Einsicht

-   Prüfungseinsicht: Zeitnah; Bekanntgabe per Mail

#### Technische Vorbereitungen

<details>
<summary><strong>Präsenz (in Minden)</strong></summary>

Diese Bemerkungen betreffen die Durchführung als Präsenzprüfung in den
Räumen am Campus Minden.

-   **HSBI-Zugangsdaten**: Username, Passwort

    Bei der Durchführung der Prüfung am Campus Minden wird Ihnen ein
    Rechner zur Verfügung gestellt. Dort läuft voraussichtlich ein
    Browser im Kiosk-Mode, wo Sie sich am Prüfungs-ILIAS anmelden. Dazu
    benötigen Sie ihre HSBI-Zugangsdaten, mit denen Sie sich auch im
    "normalen" ILIAS anmelden.

-   **Studierendenausweis** und Personalausweis

    An der Prüfung dürfen nur Personen teilnehmen, die dafür im LSF
    angemeldet sind. Es findet eine entsprechende Kontrolle statt.
    Halten Sie Ihren Studierendenausweis und Personalausweis bereit.

</details>
<details>
<summary><strong>Open-Book-Ausarbeitung (Homeoffice)</strong></summary>

Diese Bemerkungen betreffen die Durchführung aus dem Home-Office mit
Ihrer Hardware. Bei der Durchführung in Präsenz in den Räumen am Campus
Minden werden die technischen Details von uns für Sie vorbereitet sein.

-   **Rechner**: Nutzen Sie für die Prüfung einen stationären Rechner
    oder ein Notebook.

    Vermeiden Sie die Verwendung von Tablets und Smartphones! Bei der
    Verwendung von Tablets kann es unter Umständen zu
    Darstellungsproblemen kommen. Smartphones sind aufgrund des kleinen
    Bildschirms für die Prüfungsdurchführung schlicht ungeeignet.

    Bei fehlendem Zugang zu einem entsprechenden Endgerät kontaktieren
    Sie bitte frühzeitig die Prüfungsverantwortlichen.

-   **Netz**: Stabil genug? Belastbar genug?

    Wenn Sie keinen Zugang zu einer ausreichend stabilen
    Internetverbindung haben, setzen Sie sich frühzeitig mit Ihren
    Prüfungsverantwortlichen in Verbindung.

-   **VPN**: Der Prüfungs-ILIAS ist nur im HSBI-VPN erreichbar.

    Installieren Sie den VPN-Client (Anleitung:
    [hsbi.de/dvz/faq/cat/7](https://www.hsbi.de/dvz/faq/cat/7)) und
    testen Sie im Vorfeld der Prüfung bei aktivierter VPN-Verbindung den
    Zugang zur Prüfungsplattform
    [eassessment.hsbi.de](https://eassessment.hsbi.de). Zugangsdaten wie
    im normalen ILIAS.

    Achtung: Auch wenn Sie sich in den Räumen der HSBI befinden, müssen
    Sie oft die VPN-Verbindung aktivieren, um Zugang zur
    Prüfungsplattform zu erhalten.

-   **Browser**: Nutzen Sie einen der Standardbrowser (Edge, Firefox,
    Safari, Chrome/Chromium) in der Standardeinstellung: insbesondere
    JavaScript und Cookies müssen aktiviert/erlaubt sein.

    Deaktivieren Sie sämtliche Browser-Erweiterungen wie z.B. Ad-Blocker
    (AdBlockPlus, uBlock, ...) oder JavaScript-Blocker (No-Script,
    Ghostery, ...) für den Prüfungszeitraum.

    **Nutzen Sie Ihren Browser nicht im Privacy-Modus!**

-   **HSBI-Zugangsdaten**: Username, Passwort

    Bei der Durchführung der Prüfung als Open-Book-Ausarbeitung führen
    Sie die Prüfung auf Ihrer eigenen Hardware im Home-Office durch.
    Auch hier müssen Sie sich am Prüfungs-ILIAS anmelden. Dazu benötigen
    Sie ihre HSBI-Zugangsdaten, mit denen Sie sich auch im "normalen"
    ILIAS anmelden.

</details>

#### Bearbeitung des E-Assessment

1.  Lesen Sie sich die Hinweise auf der Startseite durch

2.  Bearbeiten Sie die Aufgaben in **einem einzigen** Browser-Tab

    **Öffnen Sie die Aufgaben *NICHT* in parallelen Tabs!** Es kann
    sonst zu Fehlfunktionen von ILIAS kommen.

    Bewegen Sie sich nicht per Browser-Navigation ("vor", "zurück" im
    Browser) durch die Aufgaben, sondern nutzen Sie dafür die Buttons
    "nächste Frage", "Weiter" oder "Zurück" vom ILIAS!

3.  Hinweis zu Anzeige der restlichen Bearbeitungsdauer

    Wenn Sie den Browser bzw. das Tab mit der Prüfung im Laufe der
    Prüfung verlassen, wird Ihnen bei der Rückkehr unter Umständen eine
    falsche restliche Bearbeitungsdauer angezeigt. Sie können die
    Anzeige korrigieren/aktualisieren, indem Sie einfach zu einer
    vorigen oder nächsten Aufgabe navigieren.

    Hinweis: Die restliche Bearbeitungsdauer wird im Test nur dann
    angezeigt, wenn diese Funktion von den Prüfenden aktiviert wurde.

4.  Parallel zum E-Assessment läuft eine Zoom-Session, dort können Sie
    Fragen stellen

5.  Verbindungsprobleme (Home-Office):

    -   Bei kurzzeitigen Verbindungsabbrüchen loggen Sie sich einfach
        wieder ein
    -   Wenn die Probleme länger dauern, gilt der Versuch als nicht
        unternommen (außer Sie haben die Probleme aktiv herbeigeführt,
        dann kann das als Täuschungsversuch gewertet werden, vgl. RPO
        §22a (4))

#### Fragetypen-Demo

In Ihrem ILIAS-Kurs finden Sie eine
[**Fragetypen-Demo**](https://www.hsbi.de/elearning/goto.php?target=tst_1352273&client_id=FH-Bielefeld)
mit den wichtigsten Fragetypen. Machen Sie sich mit der Mechanik der
Fragetypen vertraut und schauen Sie sich die Kommentare bei den
einzelnen Aufgaben an. Sie können die Demo bei Bedarf beliebig oft
wiederholen.

#### Hinweise zu den Inhalten

-   Klausurrelevant: Vorlesung und Praktikum
-   Für Verständnis u.U. hilfreich: Studium der vertiefenden
    Literaturangaben

<!-- -->

-   **Fragen**:
    -   Schauen Sie sich die Challenges und/oder Quizzes an ...
    -   Schauen Sie sich die Praktikumsaufgaben an ...
    -   Überlegen Sie sich, was zu einem Themengebiet im Rahmen einer
        Prüfung möglich ist und (wie) gefragt werden könnte :)

<div align="center">

**Können vor Kennen :-)**

</div>

#### Beispiele für mögliche Fragen

##### Vererbung und Polymorphie

Betrachten Sie den folgenden Java-Code:

``` java
public class Person {
    public String getInfo(Person p) { return "Person"; }
}

public class Studi extends Person {
    public String getInfo(Studi s) { return "Studi"; }

    public static void main(String[] args) {
        Studi s = new Studi(); Person p = s;
        System.out.println(s.getInfo(p));
        System.out.println(s.getInfo(s));
    }
}
```

Geben Sie alle Ausgaben, die das obige Programm produziert, an.

Begründen Sie Ihre Antwort kurz und stichhaltig (für *jede* Ausgabe!).
Was geschieht, bzw. wieso kommt es zu der jeweiligen Ausgabe?

##### Multithreading und Synchronisierung

``` java
public class StaffelKaputt extends Thread {
    private Object stab;
    StaffelKaputt(Object stab) { this.stab = stab; }
    public void run() {nimmStab(); laufen(); stabAbgeben();}
    private void stabAbgeben() {
        synchronized (stab) { stab.notifyAll(); }
    }
    private void nimmStab() {
        synchronized (stab) {
            try { stab.wait(); } catch (Exception e) { }
        }}
    void laufen() { System.out.println("laufe ... "); }
    public static void main(String[] args) {
        Object stab = new Object();
        StaffelKaputt l1 = new StaffelKaputt(stab);
        StaffelKaputt l2 = new StaffelKaputt(stab);
        l1.start(); l2.start();
    }}
```

Das Programm enthält einen Fehler, der sich zur Laufzeit offenbart.
Welche Ausgabe erwarten Sie (angenommen, das Programm wäre fehlerfrei;
eine mögliche Variante reicht)? Welche Ausgabe erhalten Sie stattdessen?
Korrigieren Sie den Fehler.

##### Reguläre Ausdrücke

Auf welche Strings passt (im Sinne von "match") der folgende reguläre
Ausdruck: `\s*([a-zA-Z0-9_.\-]+)\s*=\s*(-?\d+\.?\d*)\s;?\s*`

##### Versionieren mit Git

-   Erklären Sie, wie man mit Git die Unterschiede zwischen zwei
    bestimmten Versionsständen einer Datei herausfindet.

-   Was ist der Unterschied zwischen einer Workingcopy und einem
    Repository?

-   Worin liegt der Unterschied zwischen folgenden Arbeitsschritten:

    a.  Editieren von Datei `A.txt`
    b.  `git add A.txt`
    c.  Editieren von Datei `A.txt`
    d.  `git commit`

    versus

    a.  Editieren von Datei `A.txt`
    b.  Editieren von Datei `A.txt`
    c.  `git add A.txt`
    d.  `git commit`

-   Was würde `git diff` jeweils nach Schritt 2 anzeigen?

##### Kommandozeilenparameter

Schreiben Sie ein Programm, welches auf zwei Kommandozeilenparameter
reagieren kann. Die erkannten Parameter sollen auf der Konsole
ausgegeben werden. Nutzen Sie Apache Commons CLI (API siehe Anhang).

-   Beim Aufruf ohne Parameter soll eine Hilfe zum korrekten Aufruf
    ausgegeben werden und das Programm soll sich anschließend beenden.
-   Das Programm soll den Parameter `-debug` erkennen.
-   Das Programm soll den Parameter `-x=10` erkennen, wobei der Wert
    beim Aufruf variieren kann (Integer).
-   Die Parameter können in unterschiedlicher Reihenfolge auftreten.
-   Es kann auch nur ein Parameter angegeben werden.

##### Build mit Ant

-   Was ist der Unterschied zwischen Ant-Targets und Ant-Tasks?
-   Wie kann man Ant-Properties von außen (beim Aufruf) setzen?
-   Schreiben Sie ein Ant-Target, welches alle `.class`-Dateien in einem
    Ordner umbenennt.
-   Schreiben Sie ein Ant-Target, mit dem Sie die Javadoc-Dokumentation
    erzeugen, packen und das resultierende `.zip`-File in den Ordner
    `dist/` verschieben.
-   Schreiben Sie Ant-Targets, mit denen Sie JUnit-Testfälle ausführen
    und auswerten können.

##### Generics

Was kommt hier raus? Und warum?

``` java
public class X {
    void methode(int a) {
        System.out.println("non-generic");
    }
    <T> void methode(T a) {
        System.out.println("generisch");
    }
    public static void main(String[] args) {
        X x = new X();
        x.methode(3);
        x.methode(new Integer(4));
        x.methode("huhu");
    }
}
```

##### Logging

Erklären Sie den Code. Was passiert?

``` java
class MyFormatter extends SimpleFormatter {
    public String format(LogRecord record) {
        return super.format(record) + "---- FAKE ----\n";
    }
}
public class MoreLogging {
    public static void main(String[] argv) {
        Logger l = Logger.getLogger("MoreLogging");
        l.setLevel(Level.FINE);

        ConsoleHandler myHandler = new ConsoleHandler();
        myHandler.setFormatter(new MyFormatter());
        myHandler.setLevel(Level.FINER);
        l.addHandler(myHandler);

        l.info("Hello World :-)");
        l.fine("fine");
        l.finer("finer");
        l.finest("finest");
    }
}
```

##### Methodenreferenzen

-   Was bedeutet der folgende Code?

    ``` java
    List<String> str = Arrays.asList("a", "b", "A", "B");
    str.sort(String::compareToIgnoreCase);
    ```

------------------------------------------------------------------------

> [!NOTE]
>
> <details >
> <summary><strong>👀 Quellen</strong></summary>
>
> <div id="refs" class="references csl-bib-body hanging-indent">
>
> <div id="ref-AtlassianGit" class="csl-entry">
>
> Atlassian Pty Ltd. 2022. „Become a Git Guru."
> <https://www.atlassian.com/git/tutorials>.
>
> </div>
>
> <div id="ref-Bloch2018" class="csl-entry">
>
> Bloch, J. 2018. *Effective Java*. 3. Aufl. Addison-Wesley.
>
> </div>
>
> <div id="ref-Boles2008" class="csl-entry">
>
> Boles, D. 2008. *Parallele Programmierung spielend gelernt mit dem
> Java-Hamster-Modell*. Vieweg+Teubne.
> <http://www.boles.de/hamster/band3.html>.
>
> </div>
>
> <div id="ref-GitHubFlow" class="csl-entry">
>
> Chacon, S. 2013. „GitHub Flow". <https://githubflow.github.io/>.
>
> </div>
>
> <div id="ref-Chacon2014" class="csl-entry">
>
> Chacon, S., und B. Straub. 2014. *Pro Git*. 2. Aufl. Apress.
> <https://git-scm.com/book/en/v2>.
>
> </div>
>
> <div id="ref-GitlabCI" class="csl-entry">
>
> „Documentation Gitlab CI". o. J. Zugegriffen 10. März 2022.
> <http://git03-ifm-min.ad.hsbi.de/help/ci/>.
>
> </div>
>
> <div id="ref-GitFlow" class="csl-entry">
>
> Driessen, V. 2010. „Git-Flow: A Successful Git Branching Model".
> <https://nvie.com/posts/a-successful-git-branching-model/>.
>
> </div>
>
> <div id="ref-Eilebrecht2013" class="csl-entry">
>
> Eilebrecht, K., und G. Starke. 2013. *Patterns kompakt*. Springer.
>
> </div>
>
> <div id="ref-Fowler2011" class="csl-entry">
>
> Fowler, M. 2011. *Refactoring*. Addison-Wesley.
>
> </div>
>
> <div id="ref-Gamma2011" class="csl-entry">
>
> Gamma, E., R. Helm, R. E. Johnson, und J. Vlissides. 2011. *Design
> Patterns*. Addison-Wesley.
>
> </div>
>
> <div id="ref-GitHubCI" class="csl-entry">
>
> GitHub Inc. 2022a. „Documentation GitHub CI".
> <https://resources.github.com/ci-cd/>.
>
> </div>
>
> <div id="ref-GitCheatSheet" class="csl-entry">
>
> Github Inc. 2022. „Git Cheat Sheets". <https://training.github.com/>.
>
> </div>
>
> <div id="ref-GitHubFlowGH" class="csl-entry">
>
> GitHub Inc. 2022b. „GitHub Flow".
> <https://docs.github.com/en/get-started/quickstart/github-flow>.
>
> </div>
>
> <div id="ref-googlestyleguide" class="csl-entry">
>
> Google Open Source. 2022. „Google Java Style Guide".
> <https://google.github.io/styleguide/javaguide.html>.
>
> </div>
>
> <div id="ref-Gradle" class="csl-entry">
>
> Gradle Inc. 2022. „Gradle Build Tool". <https://gradle.org/>.
>
> </div>
>
> <div id="ref-Inden2013" class="csl-entry">
>
> Inden, M. 2013. *Der Weg zum Java-Profi*. 2. Aufl. Dpunkt.verlag.
>
> </div>
>
> <div id="ref-Kleuker2019" class="csl-entry">
>
> Kleuker, S. 2019. *Qualitätssicherung durch Softwaretests*. Springer
> Vieweg. <https://doi.org/10.1007/978-3-658-24886-4>.
>
> </div>
>
> <div id="ref-Martin2009" class="csl-entry">
>
> Martin, R. 2009. *Clean Code*. Mitp.
>
> </div>
>
> <div id="ref-DockerInPractice" class="csl-entry">
>
> Miell, I., und A. H. Sayers. 2019. *Docker in Practice*. Manning
> Publications.
>
> </div>
>
> <div id="ref-DockerInAction" class="csl-entry">
>
> Nickoloff, D. 2019. *Docker in Action*. Manning Publications.
>
> </div>
>
> <div id="ref-Nystrom2014" class="csl-entry">
>
> Nystrom, R. 2014. *Game Programming Patterns*. Genever Benning.
> <https://github.com/munificent/game-programming-patterns>.
>
> </div>
>
> <div id="ref-JDK-Doc" class="csl-entry">
>
> Oracle Corporation. 2022. „Java Core Libraries Developer Guide".
> <https://docs.oracle.com/en/java/javase/17/core/index.html>.
>
> </div>
>
> <div id="ref-Java-SE-Tutorial" class="csl-entry">
>
> Oracle Corporation. 2024. „The Java Tutorials".
> <https://docs.oracle.com/javase/tutorial/>.
>
> </div>
>
> <div id="ref-LernJava" class="csl-entry">
>
> Oracle Corporation. 2026. „Learn Java". <https://dev.java/learn/>.
>
> </div>
>
> <div id="ref-Osherove2014" class="csl-entry">
>
> Osherove, R. 2014. *The Art of Unit Testing*. Manning.
>
> </div>
>
> <div id="ref-Passig2013" class="csl-entry">
>
> Passig, K., und J. Jander. 2013. *Weniger schlecht programmieren*.
> O'Reilly.
>
> </div>
>
> <div id="ref-Spillner2012" class="csl-entry">
>
> Spillner, A., und T. Linz. 2012. *Basiswissen Softwaretest*. 5. Aufl.
> Dpunkt.
>
> </div>
>
> <div id="ref-junit4" class="csl-entry">
>
> The JUnit Team. 2022. „JUnit 5". <https://junit.org/>.
>
> </div>
>
> <div id="ref-fernunihagenJunit" class="csl-entry">
>
> Thies, A., C. Noelke, und Ungerc. o. J. „Einführung in JUnit".
> Fernuniversität in Hagen. Zugegriffen 14. April 2020.
> <https://wiki.fernuni-hagen.de/eclipse/index.php/Einführung_in_JUnit>.
>
> </div>
>
> <div id="ref-Ullenboom2021" class="csl-entry">
>
> Ullenboom, C. 2021. *Java ist auch eine Insel*. 16. Aufl.
> Rheinwerk-Verlag.
> <https://openbook.rheinwerk-verlag.de/javainsel/index.html>.
>
> </div>
>
> <div id="ref-Urma2014" class="csl-entry">
>
> Urma, R.-G., M. Fusco, und A. Mycroft. 2014. *Java 8 in Action:
> Lambdas, Streams, and Functional-Style Programming*. Manning
> Publications.
>
> </div>
>
> <div id="ref-vogellaJUnit" class="csl-entry">
>
> <span class="nocase">vogella GmbH</span>. 2021. „JUnit 5 Tutorial -
> Learn How to Write Unit Tests".
> <https://www.vogella.com/tutorials/JUnit/article.html>.
>
> </div>
>
> <div id="ref-SWEGoogle" class="csl-entry">
>
> Winters, T., T. Manshreck, und H. Wright. 2020. *Software Engineering
> at Google: Lessons Learned from Programming Over Time*. O'Reilly.
>
> </div>
>
> </div>
>
> </details>

------------------------------------------------------------------------

<p align="center"><img src="https://licensebuttons.net/l/by-sa/4.0/88x31.png"  /></p>

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.

**Exceptions:**

-   ["A Note About Git Commit
    Messages"](https://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html)
    by [Tim Pope](https://tpo.pe/) on tbaggery.com
-   ["356:
    Refactoring"](http://altlasten.lutz.donnerhacke.de/mitarb/lutz/usenet/Fachbegriffe.der.Informatik.html#356)
    by [Andreas Bogk](mailto:andreas@andreas.org) on Lutz Donnerhacke:
    "Fachbegriffe der Informatik"
-   "*Refactoring*": ([Fowler 2011](#ref-Fowler2011), p. 53)
-   "*Any fool...*": ([Fowler 2011](#ref-Fowler2011), p. 15)
-   "*Three strikes...*": ([Fowler 2011](#ref-Fowler2011), p. 58)

<blockquote><p><sup><sub><strong>Last modified:</strong> 35cb41d 2026-03-30 orga: update dates in timetable<br></sub></sup></p></blockquote>

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

[^5]: Anmerkung: Das obige Beispiel dient als Überblick gebräuchlicher
    terminaler Operationen, es ist nicht als lauffähiges Programm
    gedacht! Auf einem Stream kann immer nur **eine** terminale
    Operation ausgeführt werden - d.h. nach der Ausführung von
    `s.count()` wäre der Stream `s` verarbeitet und es können keine
    weiteren Operationen auf diesem Stream durchgeführt werden. Dito für
    die anderen gezeigten terminalen Operationen.

[^6]: Naja, ein kläglicher Versuch. Namen sind eines der schwierigen
    Probleme in der Informatik.

[^7]: Reflection ist Thema einer späteren Vorlesung

[^8]: Für alle, die schon mit Branches umgehen können: Betrachten Sie
    auf diesem Blatt bitte nur den Branch `master`.

[^9]: Die Methoden `Order#getBicycleType` und `Order#getBicycleType`
    haben Sie sogar schon bei der Umsetzung der Record-Klassen-Aufgaben
    "implementiert" :-)

[^10]: d.h. Sie müssen gegebenenfalls auch Javadoc ergänzen ...

[^11]: Ok, wir machen hier Informatik. Vermutlich ist die Biologie nicht
    ganz korrekt ;-)
