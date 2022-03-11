---
type: assignment
title: "Game-Over"
author: "Andre Matutat (FH Bielefeld)"
points: 1
weight: 3
hidden: true
---

## Ziel

In dieser Aufgabe implementieren Sie den Spieler Tot.

## Voraussetzung

Um die Aufgabe lösen zu können, brauchen Sie `["Monster"]({{< ref "/assignments/pool_b/monster" >}})`{=markdown} und ein beliebiges `["Kampfsystem"]({{< ref "/assignments/pool_b/nahkampf" >}})`{=markdown} oder `["Fernkampf"]({{< ref "/assignments/pool_b/fernkampf" >}})`{=markdown}.

## Energiepunkte

Erweitern Sie den Helden um Lebenspunkte. Im Kampf kann der Held Lebenspunkte verlieren. Hat der Held all seine Lebenspunkte "verbraucht", ist das Spiel beendet.

Lebenspunkte werden initial vergeben. Lebenspunkte können aufgefrischt werden, beispielsweise bei einem erfolgreichen Kampf oder durch Heiltränke oder Zaubersprüche.

Wenn der Held stirbt, soll "Game Over" ausgegeben werden und das Spiel auf Tastendruck neu gestartet werden können.
