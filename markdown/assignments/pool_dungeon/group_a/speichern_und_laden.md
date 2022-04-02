---
type: assignment
title: "Speichern und Laden"
author: "André Matutat (FH Bielefeld)"
points: 3
weight: 7
hidden: true
---

## Ziel

In dieser Aufgaben sollen Sie ein System zum Speichern und Laden des Spielzustandes implementieren.

## Speichern und Laden

Implementieren Sie eine Möglichkeit, um das Spiel und den aktuellen Zustand zu speichern und zu laden.

Speichern Sie die Informationen über den Spielzustand, damit Sie zu einem späteren Zeitpunkt ein neues Spiel starten und den jetzigen Spielzustand durch Laden der abgespeicherten Daten wiederherstellen können.

Überlegen Sie sich, was alles gespeichert werden muss und wie Sie die Daten dafür ablegen müssen. Sie sollen nur Daten speichern, die den aktuellen Spielzustand beschreiben.

Speichern Sie mindestens den aktuellen Zustand des Helden und das aktuelle Level sowie alle Elemente, die sich im Level befinden (und wo).

Sie können auch externe Bibliotheken oder andere Techniken verwenden. Binden Sie diese in Ihrem Buildscript mit ein.

Dokumentieren Sie Ihre Entscheidung.

_Tipp_: Um das aktuelle Level in JSON-Formatierung zu bekommen, verwenden Sie `Level#toJSON`.
