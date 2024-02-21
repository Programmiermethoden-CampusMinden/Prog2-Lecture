---
archetype: assignment
title: "Nahkampf"
author: "André Matutat (HSBI)"
points: "5 Punkte"

hidden: true
---

## Ziel

In dieser Aufgabe implementieren Sie ein einfaches Nahkampfkonzept, damit der Held gegen die
Monster kämpfen kann.

## Voraussetzung

Um diese Aufgabe lösen zu können, müssen Sie vorher
["Monster"](tasknpc-monster.md) implementiert haben.

## Nahkampf

In den Vorgaben ist ein Konzept für den
[Fernkampf mit Skills](https://github.com/Dungeon-CampusMinden/Dungeon/tree/master/dungeon/src/contrib/utils/components/skill)
mit einen
[Projektil System](https://github.com/Dungeon-CampusMinden/Dungeon/blob/master/dungeon/src/contrib/systems/ProjectileSystem.java)
implementiert. Führen Sie eine Codeanalyse durch und erklären Sie, wie das Konzept
funktioniert.

Erweitern Sie das Konzept so, dass es auch für den Nahkampf genutzt werden kann.
Implementieren Sie mindestens einen Nahkampfangriff.

Trifft der Angriff auf einen Gegner (oder den Helden), verursacht es Schaden.

Bei einem Treffer soll der Getroffene eine kurze Distanz zurückgeschleudert werden. Beachten
Sie dabei, dass niemand durch eine Wand bewegt wird.
