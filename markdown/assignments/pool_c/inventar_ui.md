---
type: assignment
title: "Inventar UI "
author: "Andre Matutat (FH Bielefeld)"
points: 2
weight: 5
hidden: true
---

## Ziel

In dieser Aufgabe implementieren Sie eine grafische Benutzeroberfläche für das Inventar.

## Voraussetzung

Um diese Aufgabe lösen zu können, müssen Sie vorher `["Inventar"]({{< ref "/assignments/pool_a/inventar_text_based" >}})`{=markdown} implementieren.

## Inventar UI

Implementieren Sie eine grafische Oberfläche für das Inventar. Ergänzen Sie passende Befehle, so dass das Inventar ein- und auch wieder ausgeblendet werden kann.

Stellen Sie die verschiedenen Items grafisch dar und erlauben Sie es, Items mithilfe der Maus zu verwenden oder fallen zu lassen.

Bedenken Sie, dass die Game-Loop zeitgesteuert weiterläuft und entsprechend die Gegner und NPCs im Prinzip auch angreifen können, wenn der Spieler sein Inventar anschaut. Eventuell möchten Sie einen Mechanismus implementieren, so dass die Gegner keinen Zug machen, so lange das Inventar angezeigt wird und der Held handlungsunfähig ist.
