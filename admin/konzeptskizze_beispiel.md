---
title: "Konzeptskizze für Zyklus X (Beispiel)"
author: "André Matutat, Carsten Gips"

hidden: true
---


# Beschreibung der Aufgabe

Das Dungeon soll um mindestens zwei Monster erweitert werden. Die Monster sollen
unterschiedliche Eigenschaften haben und sich zufällig im Dungeon bewegen.


# Beschreibung der Lösung

Wir wollen zwei Monster realisieren, die sich sowohl vertikal als auch horizontal
im Dungeon bewegen. Pro Frame wird per Zufallsfunktion bestimmt, ob sich das Monster
horizontal und/oder vertikal bewegt. Dabei soll eines der beiden Monster eine höhere
Geschwindigkeit haben, und das andere sich nur in einer Achse bewegen.

Die Monster sollen animiert werden: Das eine Monster soll als kleiner Igel dargestellt
werden, das andere Monster ist eine Art Schleimkugel. Bei der Bewegung soll sich die
Textur in fünf Schritten ändern, so dass ein optischer Bewegungseffekt entsteht.

Die Monster sollen vom Helden angegriffen werden können und dabei Schaden erleiden.
Wenn sie dabei zu viel Schaden erleiden, "sterben" sie und werden aus dem Spiel
entfernt.


# Methoden und Techniken

Für die Realisierung der Monster nutzen wir das Type-Object-Pattern aus der Vorlesung.
Damit vermeiden wir eine Vererbungshierarchie, die im Laufe des Sommersemesters recht
tief werden könnte.

Unser Code wird entsprechend den Regeln aus der Vorlesung mit Javadoc dokumentiert,
die Formatierung erfolgt nach dem ASOP-Style. Es soll keine Warnings oder Fehlermeldungen
von Checkstyle geben.


# Ansatz und Modellierung

Wir erstellen eine `Monster`-Klasse mit den grundlegenden Eigenschaften und Funktionen
eines Monsters.

Da Monster auch im Dungeon gezeichnet werden müssen, implementiert die Klasse `Monster`
das Interface `IDrawable`. Die Monster sollen vom `EntityController` verwaltet werden,
daher implementiert die Klasse auch das Interface `IEntity`.

## Monster haben zusätzlich folgende Grundeigenschaften:

-   `float lebenspunkte`: Geben die verbleibenden Lebenspunkte des Monsters an
    -   Hat das Monster 0 Lebenspunkte, wird es mit Hilfe der `deletable`-Methode
        aus dem `EntityController`entfernt.
-   `float hSpeed`: Die Geschwindigkeit, in der sich das Monster horizontal bewegt
-   `float vSpeed`: Die Geschwindigkeit, in der sich das Monster vertikal bewegt
-   `float dmg`: Den Schaden, den das Monster im Kampf macht
-   `dungeonWorld level`: Genau wie der Held müssen auch Monster das Level kennen,
    um sich darin zu bewegen. Wird im Konstruktor gesetzt.

## Monster haben zusätzlich folgende Grundfunktionen:

-   `void move()`: Bewegt das Monster in eine zufällige Richtung

    Dafür verwenden wir zwei Zufallszahlen: Die erste Zahl gibt an, ob sich das
    Monster nach rechts oder links bewegt, die zweite Zahl, ob sich das Monster
    nach oben oder unten bewegt. Zusätzlich gibt es die Chance, dass ein Monster
    sich gar nicht bewegt.

    ```java
    int linksOrechts = getRandomZahl(0,1);
    int obenOunten = getRandomZahl(0,1);

    //30% Chance, sich nicht zu bewegen
    if (getRandomZahl(0,100) > 30) {
        //horizontal
        if (linksOrechts == 0) {
            this.x += this.hSpeed;
        } else {
            this.x -= this.hSpeed;
        }

        //vertikal
        if (obenOunten == 0) {
            this.y += this.vSpeed;
        } else {
            this.y -= this.vSpeed;
        }
    }
    ```

-   `void getHit(float dmg)`: Zieht dem Monster Lebenspunkte ab
-   `float getDMG()`: Gibt Schaden zurück
-   `getRandomPosition()`: Wird im Konstruktor aufgerufen, sucht sich eine
    zufällige Position im Dungeon als Spawn-Punkt

## Daraus ergibt sich folgendes UML:

![Klassendiagramm der angedachten Lösung](images/tagebuch_uml.png)

## Beschreibung der konkreten Monster:

1.  Igel:
    -   Hat 5 Lebenspunkte
    -   Macht 0.5 Schaden
    -   Bewegt sich sowohl vertikal als auch horizontal mit 0.1f
    -   Bewegt sich in eine zufällige Richtung

2.  Schleimkugel:
    -   Hat 3 Lebenspunkte
    -   Macht 1 Schaden
    -   Bewegt sich nur horizontal
        -   hSpeed=0.2f;
        -   vSpeed=0f;

Monster werden beim Laden eines Levels im Dungeon verteilt. Dafür erstellen
wir die Funktion `spawnMonster` in unserem `MainController`, welche in der
`onLevelLoad`-Methode aufgerufen wird.

`spawnMonster` erstellt eine zufällige Anzahl an Monstern (zwischen 5 und 10),
platziert diese mit Hilfe von `getRandomPointInDungeon` (wie beim Helden) im
Dungeon und fügt Sie dem `EntityController` hinzu.

Verlässt der Spieler das Level, werden alle Monster aus dem `EntityController`
gelöscht. Dafür wird die gesamte Liste des `EntityController` gelöscht und der
Held neu hinzugefügt.
