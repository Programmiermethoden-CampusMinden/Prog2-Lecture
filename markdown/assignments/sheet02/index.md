---
title: "Blatt 02: Logging, Monster und Kampf"
author: "Carsten Gips (FH Bielefeld)"
disableToc: true
hidden: true
---


## Logging, Monster und Kampf

*   **Abgabefrist**:
    Sonntag, 25.04.2021, 18:00 Uhr
*   **Einreichung**:
    Upload der Lösungen plus Lerntagebuch als Zip-File im ILIAS
    (1x je Team, Team-Mitglieder im ILIAS mit angeben)
*   **Rücksprache**:
    Freitag, 30.04.2021 in Ihrem Praktikumsslot
*   **Benotung**:
    [0 bis 3 Punkte](pm_orga.html#punkte)
*   **Relevante Themen**:
    [Git 3: Branches](pm_git3.html),
    [Git 4: Branching-Strategien](pm_git4.html),
    [Logging](pm_logging.html)

## Aufgabe 2.1: Logging

-   Implementieren Sie Logging-Mechanismen für Ihr Projekt. Loggen Sie
    mindestens alle Exceptions, die Erstellung einer neuen Character-Instanz
    (beispielsweise das Spawnen neuer Monster), das Laden eines neuen
    Spiel-Levels sowie alle Bewegungen und Eingaben. Verwenden Sie
    passende (unterschiedliche) Logging-Level.
-   Geben Sie alle Log-Meldungen ab einer bestimmten Stufe auf der Konsole
    aus. Schreiben Sie zusätzlich alle Log-Meldungen geeignet in eine Datei.
    In beiden Fällen soll jeweils der Zeitstempel, das Log-Level, die Herkunft
    und die Log-Meldung ersichtlich sein.
-   Halten Sie Ihr Logging im Laufe des Projektes *up to date*, ziehen Sie
    also bei Erweiterungen auch das Logging passend nach. Das hilft Ihnen
    dabei, mögliche Fehler besser nachzuvollziehen.

## Aufgabe 2.2: Einfache Monster

-   Implementieren Sie analog zum Helden verschiedene Monster (mindestens
    zwei) für das Dungeon.
-   Überlegen Sie sich, welche Eigenschaften die Monster haben sollen. Dies
    könnte beispielsweise die Geschwindkeit sein, die Kampfstärke oder die
    Zahl der Lebenspunkte ("Gesundheit").
-   Lassen Sie die Monster sich zufällig im Dungeon bewegen.

## Aufgabe 2.3: Kampf-System

-   Implementieren Sie eine rudimentäre Form eines Kampf-Systems. Dabei
    soll es zum Kampf kommen, wenn der Held und ein Monster auf demselben
    Feld stehen.
-   Bei einem erfolgreichen Angriff wird dem angegriffenen Gegner ein
    bestimmter Schaden zugefügt (dieser verliert dann Lebenspunkte).
-   Ob ein Angriff erfolgreich ist, kann mit einem Zufallsgenerator bestimmt
    werden: Beispielsweise könnten 60% aller Angriffe erfolgreich sein.
    (*Hinweis*: Das Verhalten kann zusätzlich noch mit dem Level des Helden
    oder dem Typ der Monster oder in Abhängigkeit der genutzten Waffen und
    Tränke o.ä. ergänzt werden -- Waffen und Tränke implementieren Sie später
    in [Blatt 3](#b3).)
-   Erweitern Sie den Helden um Lebenspunkte und loggen Sie diese. Verliert
    der Held all seine Lebenspunkte, ist das Spiel beendet. Es soll "GAME OVER"
    geloggt werden und ein neues Spiel gestartet werden.
-   Lebenspunkte werden initial vergeben. Lebenspunkte können aufgefrischt
    werden, beispielsweise bei einem erfolgreichen Kampf ...
-   Wird der Held von einem Monster getroffen, soll er ein eine kurze Distanz
    zurückgeschleudert werden. Beachten Sie dabei, dass der Held nicht durch
    eine Wand bewegt wird.
