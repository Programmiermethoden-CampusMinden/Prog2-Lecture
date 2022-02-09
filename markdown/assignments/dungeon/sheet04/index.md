---
title: "Blatt 04: HUD, Fallen, Erfahrung und Skills"
author: "Carsten Gips (FH Bielefeld)"
disableToc: true
hidden: true
---


## HUD, Fallen, Erfahrung und Skills

*   **Abgabefrist**:
    Sonntag, 09.05.2021, 18:00 Uhr
*   **Einreichung**:
    Upload der Lösungen plus Lerntagebuch als Zip-File im ILIAS
    (1x je Team, Team-Mitglieder im ILIAS mit angeben)
*   **Rücksprache**:
    Freitag, 14.05.2021 in Ihrem Praktikumsslot
*   **Benotung**:
    [0 bis 3 Punkte](pm_orga.html#punkte)
*   **Relevante Themen**:
    [Generics 3: Type Erasure](pm_generics3.html),
    [Generics 4: Polymorphie](pm_generics4.html),
    [Defaultmethoden](pm_defaultmethods.html),
    [Observer-Pattern](pm_observer.html)

## Aufgabe 4.1: HUD

-   Implementieren Sie ein *HUD*
    ([*heads-up display*](https://en.wikipedia.org/wiki/Heads-up_display_(video_games))),
    um den Spieler mit Informationen zu versorgen. Das HUD soll mindestens
    die Lebenspunkte des Helden, das Inventar des Helden und den Inhalt von
    Schatztruhen (sobald der Spieler diese öffnet) anzeigen.

## Aufgabe 4.2: Erfahrung und Skills

-   Ihr Held soll durch das Besiegen von Monstern Erfahrungspunkte erhalten.
-   Hat der Held genug Erfahrung gesammelt, soll er ein Level aufsteigen.
-   Zeigen Sie den Levelfortschritt im HUD an.
-   Überlegen Sie sich verschiedene Belohnungen für das Erreichen eines neuen
    Levels (mehr Leben, mehr Schaden beim Kampf o.ä.).
-   Entwickeln Sie mindestens zwei neue Fähigkeit, die der Held auf Level 2
    und 5 erhält (Zauber, Sprinten o.ä.).

## Aufgabe 4.3: Fallen

-   Implementieren Sie Fallen, die Sie im Dungeon verteilen. Eine Falle kann
    aktiviert werden, indem ein Held oder ein Monster darauf tritt oder ein
    Gegenstand darauf abgelegt wird. Fallen können verschiedene Wirkungen
    haben: Sie können bei der Aktivierung Schadenspunkte verteilen oder einen
    Gegenstand/Held/Monster im aktuellen Spiel-Level teleportieren oder
    zufällige Monster "hervorzaubern". Fallen können gut sichtbar sein oder
    auch versteckt sein und nur unter der Wirkung eines bestimmten Zaubertranks
    oder Zauberspruchs sichtbar sein. Fallen können einmal aktiviert werden
    oder auch mehrfach wirken.
