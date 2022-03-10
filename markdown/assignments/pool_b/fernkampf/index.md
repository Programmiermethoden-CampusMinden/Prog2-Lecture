---
type: assignment
title: "Fernkampf"
author: "Andre Matutat (FH Bielefeld)"
points: 2
weight: 4
hidden: true
---


## Ziel

In dieser Aufgabe implementieren Sie ein einfaches Nahkampfsystem, damit der Held gegen die Monster kämpfen kann.

## Voraussetzung

Um diese Aufgae lösen zu können, müssen Sie vorher `["Monster"]({{< ref "/assignments/pool_b/monster" >}})`{=markdown} implementiert haben.

## Fernkampf

Implementieren Sie eine rudimentäre Form eines Kampf-Systems. Dabei soll es zum Kampf kommen, wenn der Held und ein Monster auf demselben Feld stehen (sich berühren).

Bei einem erfolgreichen Angriff wird dem angegriffenen Gegner ein bestimmter Schaden zugefügt (dieser verliert dann Lebenspunkte).

Ob ein Angriff erfolgreich ist, kann mit einem Zufallsgenerator bestimmt werden: Beispielsweise könnten 60% aller Angriffe erfolgreich sein.

Wird der Held von einem Monster getroffen, soll er eine eine kurze Distanz zurückgeschleudert werden. Beachten Sie dabei, dass der Held nicht durch eine Wand bewegt wird.
