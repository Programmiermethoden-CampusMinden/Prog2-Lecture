---
archetype: assignment
title: "Fernkampf"
author: "André Matutat (FH Bielefeld)"
points: 5
weight: 2

hidden: true
---


## Ziel

In dieser Aufgabe implementieren Sie Projektile für den Fernkampf, damit der Held gegen die Monster auf Distanz kämpfen kann.

## Voraussetzung

Um diese Aufgabe lösen zu können, müssen Sie vorher `["Monster"]({{< ref "/assignments/group_monster/monster" >}})`{=markdown} implementiert haben.

## Fernkampf

In den Vorgaben ist ein Konzept für den [Fernkampf mit Skills](https://github.com/Programmiermethoden/Dungeon/tree/master/game/src/ecs/components/skill) mit einen [Projektil System](https://github.com/Programmiermethoden/Dungeon/blob/master/game/src/ecs/systems/ProjectileSystem.java) implementiert.
Führen Sie eine Codeanalyse durch und erklären Sie, wie das Konzept funktioniert.

Implementieren Sie zwei unterschiedliche Projektile, die sich vom bereits implementierten Feuerball durch ihr Flugverhalten unterscheiden. Denkbar wäre ein Bumerang, der im Bogen zurück zum Spieler fliegt, oder ein Projektil, welches über die Distanz "nach unten fällt", oder ein Projektil, das an Wänden abprallt.

Trifft das Projektil auf einen Gegner (oder den Helden), verursacht es Schaden und fliegt nicht mehr weiter.
Trifft das Projektil auf eine Wand, fliegt es nicht mehr weiter.

Bei einem Treffer soll der Getroffene eine kurze Distanz zurückgeschleudert werden. Beachten Sie dabei, dass niemand durch eine Wand bewegt wird.


