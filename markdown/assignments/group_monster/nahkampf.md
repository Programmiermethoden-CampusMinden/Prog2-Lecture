---
archetype: assignment
title: "Nahkampf"
author: "André Matutat (FH Bielefeld)"
points: 5
weight: 2

hidden: true
---

## Ziel

In dieser Aufgabe implementieren Sie ein einfaches Nahkampfsystem, damit der Held gegen die Monster kämpfen kann.

## Voraussetzung

Um diese Aufgabe lösen zu können, müssen Sie vorher `["Monster"]({{< ref "/assignments/group_monster/monster" >}})`{=markdown} implementiert haben.

## Nahkampf

In den Vorgaben ist ein System für den Fernkampf mit Projektilen implementiert.
Führen Sie eine Codeanalyse durch und erklären Sie, wie das System funktioniert.
Erweitern Sie das System so, dass es auch für den Nahkampf genutzt werden kann. 
Implementieren Sie mindestens einen Nahkampfangriff. 

Trifft der Angriff auf einen Gegner (oder den Helden), verursacht es Schaden.

Bei einem Treffer soll der Getroffene eine kurze Distanz zurückgeschleudert werden. Beachten Sie dabei, dass niemand durch eine Wand bewegt wird.

