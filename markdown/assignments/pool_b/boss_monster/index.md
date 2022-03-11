---
type: assignment
title: "Boss-Monster"
author: "Andre Matutat (FH Bielefeld)"
points: 5
weight: 8
hidden: true
---

## Ziel

In dieser Aufgabe implementieren Sie ein einzigartiges Boss-Monster.

## Voraussetzung

Um diese Aufgabe lösen zu können, sollten Sie vorher `["Monster"]({{< ref "/assignments/pool_b/monster" >}})`{=markdown} implementieren.

## Boss-Monster

Zu jedem guten Spiel gehört ein guter Boss-Gegner. Boss-Monster sind oft deutlich stärker als die sonstigen Monster im Spiel.
Was sie jedoch besonders macht, ist das einzigartige Verhalten dieser Monster.

In dieser Aufgabe geht es nicht darum, ein wiederverwendbares Verhalten zu programmieren, sondern etwas Einzigartiges.

Konzeptionieren und implementieren Sie Ihren eigenen Boss-Gegner.

Folgende Kriterien müssen mindestens erfüllt sein: 

-    Eigene Texturen und Animationen
-    Eigenes Bewegungsmuster
-    Eigenes Angriffsmuster
-    Hat unterschiedliche Angriffe, je nachdem wie nah/fern der Held zum Boss steht
-    Eine zweite Phase, nachdem der Boss 50% seiner Lebenspunkte verloren hat. 
        - Der Boss soll neue Angriffe haben und aggressiver werden

