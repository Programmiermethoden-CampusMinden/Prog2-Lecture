---
title: "Blatt 06: Fernkampf, schlaue Monster und Refactoring"
author: "Carsten Gips (FH Bielefeld)"
disableToc: true
hidden: true
---


## Fernkampf, schlaue Monster und Refactoring

*   **Abgabefrist**:
    Sonntag, 30.05.2021, 18:00 Uhr
*   **Einreichung**:
    Upload der Lösungen plus Lerntagebuch als Zip-File im ILIAS
    (1x je Team, Team-Mitglieder im ILIAS mit angeben)
*   **Rücksprache**:
    Freitag, 04.06.2021 in Ihrem Praktikumsslot
*   **Benotung**:
    [0 bis 3 Punkte](pm_orga.html#punkte)
*   **Relevante Themen**:
    [Bad Smells](pm_badsmells.html),
    [Refactoring](pm_refactoring.html),
    [Git 7: Bisect](pm_git7.html),
    [Strategy-Pattern](pm_strategy.html)

## Aufgabe 6.1: Fernkampf

-   Implementieren Sie einen "Fernkampf" für den Helden und die Monster. Bisher
    haben der Held und die Monster nur agiert, wenn sie auf das selbe Feld
    gelangt sind. Erweitern Sie dieses System, so dass beispielsweise auch auf
    benachbarten Feldern ein Kampf stattfinden kann. Es kann auch Waffen mit
    unterschiedlicher Reichweite geben (Bogen, Zauberstab), die über eine
    gewisse Distanz wirksam sind. Dabei kann auch die Wirksamkeit und/oder die
    Genauigkeit mit zunehmender Distanz abnehmen.

## Aufgabe 6.2: Schlaue Monster

-   Verwenden Sie das Strategy-Pattern, um Monster verschiedene Bewegung und
    Angriffsstrategien zu ermöglichen. Überlegen und implementieren Sie mindestens
    drei verschiedene Strategien.
-   Implementieren Sie ein Monster, welches zwischen Nah- und Fernkampf wechselt,
    je nachdem wie weit der Held entfernt ist.

## Aufgabe 6.3: Refactoring

-   Räumen Sie Ihr Projekt auf. Identifizieren Sie Bad Smells (manuelles Review,
    Durchlauf von Checkstyle) und führen Sie ein schrittweises Refactoring zur
    Behebung durch. Denken Sie daran, dass ein Refactoring immer nur in kleinen
    Schritten durchgeführt werden soll und durch Tests abgesichert sein soll.
    Machen Sie nach jedem Schritt einen Commit, so dass man Ihr Vorgehen anhand
    der Git-Historie nachvollziehen kann.
-   Tragen Sie ggf. fehlende Dokumentation nach.
-   "OOP-Character": Sie haben zu diesen Zeitpunkt mindestens eine Heldenklasse und
    mehrere Monster implementiert. Bauen Sie per Refactoring eine sinnvolle Klassen-
    und Interfaces-Struktur auf, um Gemeinsamkeiten dieser Implementierungen unter
    einer gemeinsamen (abstrakten) Oberklasse oder Interface zu gruppieren.
-   Verbessern Sie die Datenstruktur für die Kollisionserkennung. Implementieren Sie
    dazu einen aus der Lehrveranstaltung "ADS" bekannten *Hashtable* selbst und nutzen
    Sie als Key die Position eines Objekts/Akteurs und als Value das/den Objekt/Akteur.

*Hinweis*: Diese Aufgabe dient zum Üben der verschiedenen Refactoring-Techniken,
aber auch zur Vorbereitung für das Projekt in den kommenden Wochen.
