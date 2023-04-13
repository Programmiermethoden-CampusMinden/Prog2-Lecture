---
archetype: assignment
title: "Lockpicking"
author: "André Matutat (FH Bielefeld)"
points: "10 Punkte"
weight: 7

hidden: true
---

## Ziel

In dieser Aufgabe implementieren Sie ein
[Mini-Spiel](https://de.wikipedia.org/wiki/Minispiel), um verschlossene Schatzkiste zu
knacken.

## Voraussetzung

Um diese Aufgabe lösen zu können, müssen Sie vorher
`["Item"]({{< ref "/assignments/group_loot/item" >}})`{=markdown} gelöst haben.

## Lockpicking

In den Vorgaben finden Sie die Implementierung einer
[Schatzkiste](https://github.com/Programmiermethoden/Dungeon/blob/master/game/src/ecs/entities/Chest.java).
Führen Sie eine Codeanalyse durch und erklären Sie die Funktionalität.

Implementieren Sie eine Möglichkeit, dass Schatzkisten verschlossen sein können und nur mit
einen bestimmten Schlüssel geöffnet werden können.

Recherchieren Sie nach "Lockpicking-Minigames" aus anderen Spielen und implementieren Sie
eine Umsetzung für Ihr Spiel. Wenn der Spieler nicht den passenden Schlüssel zu einer
Schatzkiste gefunden hat, soll er die Schatzkiste durch das Lösen des Mini-Spiels öffnen
können.
