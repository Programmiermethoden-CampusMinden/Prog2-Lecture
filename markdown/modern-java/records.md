---
type: lecture-cg
title: "Record-Klassen"
menuTitle: "Records"
author: "Carsten Gips (FH Bielefeld)"
weight: 5
readings:
  - key: "LernJava"
    comment: "Tutorials > Using Record to Model Immutable Data"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k2: ""
  - k3: ""
quizzes:
  - link: ""
    name: "Quiz Record-Klassen (ILIAS)"
assignments:
  - topic: sheet09
youtube:
  - link: ""
    name: "VL Record-Klassen"
  - link: ""
    name: "Demo Record-Klassen"
fhmedia:
  - link: ""
    name: "VL Record-Klassen"
---


## Motivation

ToDo: Herkömmliche Klasse mit Gettern/Settern/Ctor


## Folie 2

ToDo: Ersatz mit Record-Klasse

Erklärung: `public record Point(int x, int y) {}`:
-   Immutable Klasse mit Feldern x, y (beide int)
    => "(int x, int y)" werden auch "Komponenten" des Records genannt
-   Standardkonstruktor setzt diese Felder (Kopie) ("Kanonischer Konstruktor")
-   Getter für beide Felder: `public int x() { return this.x; }`... (Namen wie die Felder!)


## Folie 3

-   Records erweitern implizit die Klasse `java.lang.Record`:
    Keine andere Klassen mehr erweiterbar! (Interfaces kein Problem)
-   Keine weiteren (Instanz-) Attribute definierbar (nur die Komponenten)
-   Keine Setter definierbar für die Komponenten
-   Statische Attribute mit Initialisierung geht


## Folie 4

Konstruktor erweiterbar

```java
public record Point(int x, int y) {
    public Point(int x, int y) {
        if (x <= y) {
            throw new IllegalArgumentException("End cannot be lesser than start");
        }
        if (x < 0) {
            this.x = 0;
        } else {
            this.x = x;
        }
    }
}
```

alternativ in kompakter Form (Attribute können hier nicht direkt gesetzt werden,
also kein `this.x = x`. Aber man kann die Parameter des Konstruktors ändern ...):

```java
public record Point(int x, int y) {
    public Point {
        if (x <= y) {
            throw new IllegalArgumentException("End cannot be lesser than start");
        }
        if (x < 0) {
            x = 0;
        }
    }
}
```

Weitere Konstruktoren definierbar, müssen den kanonischen Konstruktor aufrufen:

```java
public record Point(int x, int y) {
    public Point() {this(0,0);}
}
```

...

## Folie 5

Getter: automatisch generierte Methoden, Namen wie die Attribute

```java
public record Point(int x, int y) {}

Point p = new Point();
p.x(); p.y()
```

Getter überschreibbar

```java
public record Point(int x, int y) {
    public int x() {
        return x*42;
    }
}
```


## Wrap-Up

https://dev.java/learn/using-record-to-model-immutable-data/

...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
