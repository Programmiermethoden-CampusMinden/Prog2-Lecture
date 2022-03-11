---
type: assignment
title: "Erfahrungspunkte"
author: "Andre Matutat (FH Bielefeld)"
points: 2
weight: 6
hidden: true
---

## Ziel

In dieser Aufgabe implementieren Sie Erfahrungspunkte, die der Spieler sammeln kann, um in der Charakterstufe aufzusteigen.

## Voraussetzung

Um die Aufgabe lösen zu können, brauchen Sie `["Monster"]({{< ref "/assignments/pool_b/monster" >}})`{=markdown} und ein beliebiges `["Kampfsystem"]({{< ref "/assignments/pool_b/nahkampf" >}})`{=markdown} oder `["Fernkampf"]({{< ref "/assignments/pool_b/fernkampf" >}})`{=markdown}.

## Erfahrungspunkte

Wenn Ihr Held Monster besiegt, soll er mit Erfahrungspunkten belohnt werden.

Unterschiedliche Monster geben unterschiedlich viele Erfahrungspunkte.

Wenn genug Erfahrungspunkte erlangt wurden, soll der Spieler eine Stufe aufsteigen. Überlegen Sie sich hierfür eine Belohnung.
Lassen Sie Ihr Stufen-System skalieren. Es soll keine Maximal-Stufe geben, es soll aber immer schwerer werden (mehr Erfahrungspunkte brauchen), um die nächste Stufe zu erreichen.

Sie dürfen **keine** `static` oder `public` Variablen benutzen, um die Erfahrungspunkte zu verteilen.
