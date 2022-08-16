---
archetype: assignment
title: "Inventar (text basiert)"
author: "André Matutat (FH Bielefeld)"
points: 3
weight: 4
hidden: true
---

## Voraussetzungen

Um diese Aufgabe bearbeiten zu können, sollten Sie vorher die Aufgabe `["Item" aus Pool C]({{< ref "/assignments/pool_dungeon/group_c/item" >}})`{=markdown} gelöst haben.

## Ziel

In dieser Aufgabe sollen Sie ein textbasiertes, also über die Konsole einseh- und steuerbares, Inventar implementieren.
Im Inventar können bestimmte Gegenstände gelagert, ausgerüstet oder verwendet werden.

## Inventar (text basiert)

Der Spieler soll verschiedene Items im Inventar haben können. Stellen Sie sich das Inventar als eine Art Rucksack vor, in den gesammelte Gegenstände gepackt und mitgeführt werden können.

Implementieren Sie dabei mindestens folgende Anforderungen:
-   Das Inventar des Spielers soll begrenzt sein (begrenzte Kapazität).
-   Der Spieler soll Items aus dem Inventar wieder herausnehmen können (*droppen*).
-   Der Spieler soll Items aus dem Inventar ausrüsten können, d.h. in die Hand nehmen können. Dabei soll immer nur eine begrenzte Zahl von Gegenständen ausgerüstet werden können (beispielsweise ein Schwert und ein Schild o.ä.).
-   Wenn ein Spieler Items aus dem Inventar ausrüstet, sollen die bisher ausgerüsteten Gegenstände automatisch ins Inventar wandern.
-   Der Spieler soll ausgerüstete Gegenstände verwenden können. Eine ausgerüstete Waffe kann beispielsweise während eines Kampfes verwendet werden.
-   Für diese Aufgabe reicht es, das Inventar über die Konsole auszugeben/zu steuern.
