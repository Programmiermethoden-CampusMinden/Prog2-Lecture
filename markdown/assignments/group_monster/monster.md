---
archetype: assignment
title: "Monster"
author: "André Matutat (FH Bielefeld)"
points: 5
weight: 1

hidden: true
---

## Ziel

In dieser Aufgabe implementieren Sie simple Gegner, welche sich selbstständig im Dungeon umherbewegen.

## Monster

Implementieren Sie analog zum Helden verschiedene Monster (mindestens zwei) für das Dungeon. Die Monster sollen auch jeweils eigene Animationen haben.

Überlegen Sie sich, welche Components die Monster haben sollen. 

In den Vorgaben finden sie das `AIComponent` und das. `AISystem`. Führen Sie eine Codeanalyse durch und erklären Sie, wie AI im Dungeon umgesetzt wurde.
Lassen Sie die Monster sich zufällig im Dungeon bewegen. Nutzen Sie dafür dir vorgegebenen Strategien. Implementieren Sie jedoch mindestens eine weitere `IIdle` Strategie. 

Verteilen Sie eine zufällige Anzahl von Monstern beim jedem Levelstart. Verteilen Sie mehr und stärkere Monster, je tiefer der Spieler im Dungeon vorrangeschritten ist.
