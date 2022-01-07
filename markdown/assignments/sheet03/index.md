---
title: "Blatt 03: Loot, Taschen und Kisten"
author: "Carsten Gips (FH Bielefeld)"
disableToc: true
hidden: true
---


## Loot, Taschen und Kisten

*   **Abgabefrist**:
    Sonntag, 02.05.2021, 18:00 Uhr
*   **Einreichung**:
    Upload der Lösungen plus Lerntagebuch als Zip-File im ILIAS
    (1x je Team, Team-Mitglieder im ILIAS mit angeben)
*   **Rücksprache**:
    Freitag, 07.05.2021 in Ihrem Praktikumsslot
*   **Benotung**:
    [0 bis 3 Punkte](pm_orga.html#punkte)
*   **Relevante Themen**:
    [Git 5: Remote](pm_git5.html),
    [Visitor-Pattern](pm_visitor.html),
    [Generics 1: Klassen & Methoden](pm_generics1.html),
    [Generics 2: Bounds & Wildcards](pm_generics2.html)

## Aufgabe 3.1: Items (*Loot*)

-   Implementieren Sie unterschiedliche vom Spieler einsammelbare und
    (ins Inventar) aufnehmbare Gegenstände wie Waffen oder Heiltränke
    oder Zaubersprüche.
-   Machen Sie sich Gedanken, wie Sie Items im Sinne des OOP-Gedankens
    umsetzen können.

## Aufgabe 3.2: Inventar

-   Der Spieler soll verschiedene Items im Inventar haben können. Stellen
    Sie sich das Inventar als eine Art Rucksack vor, in den gesammelte
    Gegenstände gepackt und mitgeführt werden können.
-   Das Inventar des Spielers soll begrenzt sein (begrenzte Kapazität).
-   Der Spieler soll Items aus dem Inventar wieder herausnehmen können
    (*droppen*).
-   Der Spieler soll Items aus dem Inventar auszurüsten können, d.h.
    in die Hand nehmen können. Dabei soll immer nur eine begrenzte
    Zahl von Gegenständen ausgerüstet werden können (beispielsweise
    ein Schwert und ein Schild o.ä.).
-   Wenn ein Spieler Items aus dem Inventar ausrüstet, sollen die bisher
    ausgerüsteten Gegenstände automatisch ins Inventar wandern.
-   Der Spieler soll ausgerüstete Gegenstände verwenden können. Eine
    ausgerüstete Waffe kann beispielsweise während eines Kampfes
    verwendet werden.
-   Implementieren Sie verschiedene Aktionen, die ein Spieler mit den
    Gegenständen tun kann. Im Sinne des OOP-Gedanken sind das Methoden
    in den Klassen der Gegenstände. Mit einer (ausgerüsteten) Waffe
    kann man (je nach Typ) dem Gegner bestimmte Schadenspunkte zufügen,
    ein Trank kann getrunken werden oder ein Zauberspruch kann gelesen
    werden. Dabei nutzen sich Waffen möglicherweise ab, Tränke und Sprüche
    werden verbraucht.
-   Lassen Sie den Held ein Monster aktiv angreifen und besiegen, indem
    der Spieler eine bestimmte Eingabe tätigt. Dies soll auch durch eine
    passende Animation visualisiert werden.
-   Loggen Sie das Inventar per Tastendruck. Da alle Log-Meldungen ab
    einer bestimmten Stufe (auch) auf der Konsole ausgegeben werden sollten
    (vgl. [Blatt 2](#b2)), können Sie sich so jederzeit einen schnellen
    Überblick verschaffen. Nutzen Sie dazu das Visitor-Pattern. Später in
    [Blatt 4](#b4) implementieren Sie ein HUD, wodurch Sie dann das Inventar
    auch ohne Logging stets im Blick behalten können.

## Aufgabe 3.3: Schätze und Taschen

-   Implementieren Sie Schatzkisten, die im Dungeon verteilt werden und
    von den Spielern geöffnet ("aktiviert") werden können.
-   Schatzkisten beinhalten (zufällige) Items, die der Spieler aufsammeln
    kann. -- Schatzkisten haben damit auch ein Inventar.
-   Das Inventar geöffneter Schatzkisten soll ebenfalls auf der Konsole
    geloggt werden können (sofern der Held auf einem Nachbarfeld steht).
-   Schatzkisten sollen nur in der Nähe des Spielers aktivierbar sein.
-   Implementieren Sie Taschen, die das Inventar des Spielers erweitern.
    Taschen nehmen selbst **einen** Inventarplatz ein, können aber wiederum
    selbst **mehrere** Gegenstände **eines** Typus (z.B. Waffen oder Tränke)
    aufbewahren.
-   Verwenden Sie für die Implementierung der Taschen und Kisten Generics.
