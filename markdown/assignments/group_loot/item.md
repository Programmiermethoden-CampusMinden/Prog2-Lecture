---
archetype: assignment
title: "Items"
author: "André Matutat (FH Bielefeld)"
points: 5
weight: 1

hidden: true
---

## Ziel

In dieser Aufgabe implementieren Sie verschiedene Gegenstände, die der Spieler verwenden kann.

## Items

In den Vorgaben sind bereits [Items](https://github.com/Programmiermethoden/Dungeon/tree/master/game/src/ecs/items) und ein [Inventory-Component](https://github.com/Programmiermethoden/Dungeon/blob/master/game/src/ecs/components/InventoryComponent.java) implementiert. Führen Sie eine Codeanalyse durch und erklären Sie die Funktionalität. 

Implementieren Sie mindestens drei verschiedene Typen von Gegenständen (beispielsweise Tränke, Nahrung, Zaubersprüchen, Rüstungen, Waffen, ...).

Jeder Gegenstand soll vom Spieler verwendbar sein. Überlegen Sie sich passende "Funktionen", die die einzelnen Gegenstände erfüllen.

Jeder Gegenstand soll grafisch dargestellt werden.

## Taschen

Implementieren Sie Taschen, die das Inventar des Spielers erweitern.

Taschen nehmen selbst **einen** Inventarplatz ein, können aber wiederum selbst **mehrere** Gegenstände **eines** Typus (z.B. Waffen oder Tränke) aufbewahren. Taschen können nur eine begrenzte Anzahl an Gegenständen beinhalten.
