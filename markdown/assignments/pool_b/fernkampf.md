---
type: assignment
title: "Fernkampf"
author: " André Matutat (FH Bielefeld)"
points: 2
weight: 4
hidden: true
---


## Ziel

In dieser Aufgabe implementieren Sie ein Fernkampfsystem, damit der Held gegen die Monster auf Distanz kämpfen kann.

## Voraussetzung

Um diese Aufgabe lösen zu können, müssen Sie vorher `["Monster"]({{< ref "/assignments/pool_b/monster" >}})`{=markdown} implementiert haben.

## Fernkampf

Implementieren Sie ein Fernkampfsystem. Dabei soll der Spieler (oder auch Monster) ein Projektil verschießen.

Das Projektil (Feuerball, Pfeil, etc.) hat eine eigene Textur und eine Flugbahn.

Trifft das Projektil auf einen Gegner (oder den Helden) verursacht es Schaden und fliegt nicht mehr weiter.
Trifft das Projektil auf eine Wand, fliegt es nicht mehr weiter.

Überlegen Sie sich unterschiedliche Flugbahnen für unterschiedliche Projektile. Vielleicht können manche Projektile auch von der Wand abprallen.

Bei einem Treffer soll der Getroffene eine kurze Distanz zurückgeschleudert werden. Beachten Sie dabei, dass niemand durch eine Wand bewegt wird.
