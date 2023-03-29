---
archetype: assignment
title: "Schatzkisten"
author: "André Matutat (FH Bielefeld)"
points: 1
weight: 5

hidden: true
---

## Ziel

In dieser Aufgabe implementieren Sie Schatzkisten, die der Spieler im Level finden und plündern kann.

## Voraussetzung

Um diese Aufgabe lösen zu können, müssen Sie vorher `["Inventar"]({{< ref "/assignments/pool_dungeon/group_a/inventar_text_based" >}})`{=markdown} und `["Item"]({{< ref "/assignments/pool_dungeon/group_c/item" >}})`{=markdown} gelöst haben.

## Schatzkiste

Implementieren Sie Schatzkisten, die im Dungeon verteilt werden und von den Spielern geöffnet ("aktiviert") werden können. Die Kisten sind zunächst geschlossen und können durch eine (neue) Aktion des Helden geöffnet werden, sofern er in ausreichender Nähe ist. Erst dann ist der Inhalt sichtbar und für den Helden zugreifbar.

Schatzkisten beinhalten (zufällige) Items, die der Spieler aufsammeln kann. Schatzkisten haben damit auch ein Inventar.

Schatzkisten sollen nur in der Nähe des Spielers aktivierbar sein.
