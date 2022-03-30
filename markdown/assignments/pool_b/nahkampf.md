---
type: assignment
title: "Nahkampf"
author: "Andre Matutat (FH Bielefeld)"
points: 2
weight: 2
hidden: true
---

## Ziel

In dieser Aufgabe implementieren Sie ein einfaches Nahkampfsystem, damit der Held gegen die Monster kämpfen kann.

## Voraussetzung

Um diese Aufgabe lösen zu können, müssen Sie vorher `["Monster"]({{< ref "/assignments/pool_b/monster" >}})`{=markdown} implementiert haben.

## Nahkampf

Implementieren Sie eine rudimentäre Form eines Kampf-Systems. Dabei soll es zum Kampf kommen, wenn der Held und ein Monster auf demselben Feld stehen.

Bei einem erfolgreichen Angriff wird dem angegriffenen Gegner ein bestimmter Schaden zugefügt (dieser verliert dann Lebenspunkte).

Ob ein Angriff erfolgreich ist, kann mit einem Zufallsgenerator bestimmt werden: Beispielsweise könnten 60% aller Angriffe erfolgreich sein.

Die Trefferchance oder der Schaden können auch durch die Stufe des Spielers/des Monster oder der verwendeten Ausrüstung bestimmt werden.

Wird jemand von einem Angriff getroffen, soll er eine kurze Distanz zurückgeschleudert werden. Beachten Sie dabei, dass niemand durch eine Wand bewegt wird.

