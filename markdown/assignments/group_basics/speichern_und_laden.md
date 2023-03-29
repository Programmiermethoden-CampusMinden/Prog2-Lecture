---
archetype: assignment
title: "Speichern und Laden"
author: "André Matutat (FH Bielefeld)"
points: 5
weight: 4

hidden: true
---

## Ziel

In dieser Aufgaben sollen Sie ein Konzept zum Speichern und Laden des Spielzustandes implementieren.

## Speichern und Laden

Nutzen Sie [Serializable](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/Serializable.html), um im Spielverlauf Ihre Entitäts-Instanzen zu speichern und in einer Datei abzulegen.
Beim Start des Spiels sollen alle Entitäten aus der Datei eingelesen und im neuen Level platziert werden.
