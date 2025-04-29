---
title: "Monster"
author: "André Matutat (HSBI)"
points: "5 Punkte"
---

## Ziel

In dieser Aufgabe implementieren Sie simple Gegner, welche sich selbstständig im Dungeon
umherbewegen.

## Monster

Implementieren Sie analog zum Helden verschiedene Monster (mindestens drei) für das Dungeon.
Die Monster sollen auch jeweils eigene Animationen haben.

Überlegen Sie sich, welche Components die Monster haben sollen.

In den Vorgaben finden Sie das
[AI-System](https://github.com/Dungeon-CampusMinden/Dungeon/blob/master/dungeon/src/contrib/systems/AISystem.java).
Führen Sie eine Codeanalyse durch und erklären Sie, wie AI im Dungeon umgesetzt wurde.

Lassen Sie die Monster sich zufällig im Dungeon bewegen. Sie können dafür die vorgegebenen
[Strategien](https://github.com/Dungeon-CampusMinden/Dungeon/blob/master/dungeon/src/contrib/entities/AIFactory.java)
nutzen. Implementieren Sie jedoch mindestens eine weitere
[IIdleAI](https://github.com/Dungeon-CampusMinden/Dungeon/blob/master/dungeon/src/contrib/entities/AIFactory.java)-Strategie.

Verteilen Sie eine zufällige Anzahl von Monstern bei jedem Levelstart. Verteilen Sie mehr
und stärkere Monster, je tiefer der Spieler im Dungeon vorangeschritten ist.
