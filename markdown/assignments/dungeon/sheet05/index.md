---
title: "Blatt 05: Quests, JUnit"
author: "Carsten Gips (FH Bielefeld)"
disableToc: true
hidden: true
---


## Quests, JUnit

*   **Abgabefrist**:
    Sonntag, 16.05.2021, 18:00 Uhr
*   **Einreichung**:
    Upload der Lösungen plus Lerntagebuch als Zip-File im ILIAS
    (1x je Team, Team-Mitglieder im ILIAS mit angeben)
*   **Rücksprache**:
    Freitag, 21.05.2021 in Ihrem Praktikumsslot
*   **Benotung**:
    [0 bis 3 Punkte](pm_orga.html#punkte)
*   **Relevante Themen**:
    [JUnit 1: Testen mit JUnit](pm_junit1.html),
    [JUnit 2: Testfallerstellung](pm_junit2.html),
    [Observer-Pattern](pm_observer.html)

## Aufgabe 5.1: Quests

-   Implementieren Sie verschiedene Aufgaben (*Quests*), die der Held erfüllen
    muss. Dies könnte beispielsweise das Sammeln einer bestimmten Zahl von
    Gegenständen oder das Besiegen einer bestimmten Zahl einer bestimmten Art
    von Monstern sein. Nutzen Sie dazu das Observer-Pattern.
-   Für die Erfüllung der Aufgaben soll der Held mit Erfahrungspunkten und/oder
    Items (etwa ein Zauberstab) belohnt werden.
-   Die Quests müssen dem Helden geeignet angezeigt werden, beispielsweise über
    eine bestimmte Textur einer Bodenkachel oder über einen Geist, der die Quest
    vorschlägt.
-   Eine präsentierte Quest kann durch den Helden angenommen werden und ist dann
    aktiv. Der Held kann das Angebot aber auch ablehnen.
-   Zeigen Sie aktive (angenommene) Quests im HUD an. Erweitern Sie auch das
    Logging.
-   Implementieren Sie mindestens eine nicht kampfabhängige Quest.

## Aufgabe 5.2: JUnit

-   Überlegen Sie sich systematisch geeignete Testfälle für die Quests und
    implementieren Sie diese mit JUnit.
