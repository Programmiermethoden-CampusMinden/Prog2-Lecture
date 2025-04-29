---
title: "Items"
author: "André Matutat (HSBI)"
points: "5 Punkte"
---

## Ziel

In dieser Aufgabe implementieren Sie verschiedene Gegenstände, die der Spieler verwenden
kann.

## Items

In den Vorgaben sind bereits
[Items](https://github.com/Dungeon-CampusMinden/Dungeon/blob/master/dungeon/src/contrib/item/Item.java) und
ein
[Inventory-Component](https://github.com/Dungeon-CampusMinden/Dungeon/blob/master/dungeon/src/contrib/components/InventoryComponent.java)
implementiert. Führen Sie eine Codeanalyse durch und erklären Sie die Funktionalität.

Implementieren Sie mindestens drei verschiedene Typen von Gegenständen (beispielsweise
Tränke, Nahrung, Zaubersprüchen, Rüstungen, Waffen, ...).

Jeder Gegenstand soll vom Spieler verwendbar sein. Überlegen Sie sich passende "Funktionen",
die die einzelnen Gegenstände erfüllen.

Jeder Gegenstand soll graphisch dargestellt werden.

## Taschen

Implementieren Sie Taschen, die das Inventar des Spielers erweitern.

Taschen nehmen selbst **einen** Inventarplatz ein, können aber wiederum selbst **mehrere**
Gegenstände **eines** Typus (z.B. Waffen oder Tränke) aufbewahren. Taschen können nur eine
begrenzte Anzahl an Gegenständen beinhalten.
