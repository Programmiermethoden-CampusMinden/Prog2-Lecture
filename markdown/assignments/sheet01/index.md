---
title: "Blatt 01: PM-Dungeon und Held"
author: "Carsten Gips (FH Bielefeld)"
disableToc: true
hidden: true
---


## PM-Dungeon und Held

*   **Abgabefrist**:
    Sonntag, 18.04.2021, 18:00 Uhr
*   **Einreichung**:
    Upload der Lösungen plus Lerntagebuch als Zip-File im ILIAS
    (1x je Team, Team-Mitglieder im ILIAS mit angeben)
*   **Rücksprache**:
    Freitag, 23.04.2021 in Ihrem Praktikumsslot
*   **Benotung**:
    [0 bis 3 Punkte](pm_orga.html#punkte)
*   **Relevante Themen**:
    [Orga](pm_orga.html),
    [Git 1: Intro](pm_git1.html),
    [Git 2: Basics](pm_git2.html)

## Aufgabe 1.1: PM-Dungeon

-   Legen Sie sich ein Java-Projekt an mit dem entpackten [Asset-Ordner](vorgaben/assets.zip)
    und der (entzippten) [Jar-Datei](vorgaben/pmdungeon.jar.zip) als Library. Passen Sie den
    Java-Classpath und/oder Ihre IDE-Einstellungen entsprechend an.
-   Erzeugen Sie sich ein `.gitignore`, um Ihre lokalen Konfigurationen (etwa die Einstellungen
    Ihrer IDE) sowie kompilierte Artefakte (`.class`-Dateien) nicht versehentlich mit in Ihr
    Git-Repo einzuchecken.
-   Lesen Sie sich die [Dokumentation](pm_dungeon_basics.html) zum PM-Dungeon durch.
-   Suchen Sie sich passende Texturen für Ihr Spiel heraus. Sie benötigen vor
    allem Texturen für Spielfiguren, Monster und Items. Achten Sie bei ihrer
    Auswahl auf passende Größenverhältnisse. Die in der Dokumentation verwendeten
    Texturen finden Sie [hier](https://0x72.itch.io/dungeontileset-ii).

## Aufgabe 1.2: Held

-   Implementieren Sie mithilfe der [Dokumentation](pm_dungeon_basics.html)
    Ihren Helden.
-   Erweitern Sie Ihren Helden um weitere Animationen: Fügen Sie jeweils eine
    Animation hinzu, die abgespielt wird, wenn sich der Held nach links bzw.
    rechts bewegt. Es soll automatisch zwischen Lauf- und Idle-Animation
    gewechselt werden.

*Tipp*: Oft finden Sie nur Animationen für eine Laufrichtung. Spiegeln Sie
diese mithilfe von externen (Bildbearbeitungs-) Programmen, um aus einer
rechtslaufenden Animation eine linklaufende zu machen.
