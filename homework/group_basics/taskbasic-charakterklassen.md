---
title: "Charakterklassen"
author: "André Matutat (HSBI)"
points: "5 Punkte"

hidden: true
---

## Ziel

In Rollenspielen gibt die Charakterklasse an, welche Werte (Anzahl der Lebenspunkte,
Kampfschaden, [Mana-Punkte](https://de.wikipedia.org/wiki/Mana_(Spiele)) etc.) die
Spielfigur hat, welche Waffen sie verwenden und welche Fähigkeiten sie erlernen kann.
Typische Charakterklassen sind Krieger, Zauberer oder Schurke.

In dieser Aufgabe sollen Sie verschiedene Charakterklassen implementieren.

## Voraussetzungen

Um diese Aufgabe zu lösen, sollten Sie am besten bereits ein Kampfsystem
(["Nahkampf"](../group_monster/tasknpc-nahkampf.md) oder
["Fernkampf"](../group_monster/tasknpc-fernkampf.md) und
["Fähigkeiten"](taskbasic-skills.md)) umgesetzt haben.

## Charakterklassen

Überlegen Sie sich zuerst, welche Charakterklassen Sie implementieren wollen. Sie sollen
mindestens drei unterschiedliche Charakterklassen anbieten.

Überlegen UND notieren Sie dabei, was diese Charakterklassen gemeinsam haben und worin sie
sich unterscheiden. Geben Sie jeder Charakterklasse eine passende Bezeichnung.

In den Vorgaben existiert bereits ein
[Stats-Component](https://github.com/Dungeon-CampusMinden/Dungeon/blob/master/dungeon/src/contrib/entities/EntityFactory.java).
Führen Sie eine Codeanalyse durch und erklären Sie die Funktionalität des Components.

Implementieren Sie nun die verschiedenen Charakterklassen im Sinne des ECS-Gedankens.
Überlegen Sie auch, welche Pattern Sie ggf. verwenden können. Begründen Sie Ihre
Entscheidungen schriftlich.

Zu Beginn des Spiels soll der Spieler die Klasse auswählen können (oder haben Sie eine
bessere Idee?).
