---
type: lecture-cg
title: "Flyweight-Pattern"
menuTitle: "Flyweight"
author: "Carsten Gips (FH Bielefeld)"
weight: 7
readings:
  - key: "Nystrom2014"
    comment: "Kap. 3: Flyweight"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k1: "**wuppie**"
  - k2: "*foo*"
  - k3: "fluppie"
quizzes:
  - link: "https://www.fh-bielefeld.de/elearning/goto.php?target=tst_1077973&client_id=FH-Bielefeld"
    name: "Quiz Flyweight-Pattern (ILIAS)"
assignments:
  - topic: sheet06
youtube:
  - link: ""
    name: "VL Flyweight-Pattern"
  - link: ""
    name: "Demo Flyweight-Pattern"
fhmedia:
  - link: ""
    name: "VL Flyweight-Pattern"
---


## Motivation: Modellierung eines Levels

::: notes
### Variante I: Einsatz eines Enums für die Felder
:::

```{.java size="footnotesize"}
public enum Tile { WATER, FLOOR, WALL, ... }

public class Level {
    private Tile[][] tiles;

    public boolean isAccessible(int x, int y) {
        switch (tiles[x][y]) {
            case: WATER: return false;
            case: FLOOR: return true;
            ...
        }
    }
    ...
}
```

::: notes
Ein Level kann als Array mit Feldern modelliert werden. Die Felder selbst könnten mit
Hilfe eines Enums repräsentiert werden.

Allerdings muss dann bei jedem Zugriff auf ein Feld und dessen Eigenschaften eine
entsprechende `switch/case`-Fallunterscheidung eingebaut werden. Damit verstreut man
die Eigenschaften über die gesamte Klasse, und bei jeder Änderung am Enum für die Tiles
müssen _alle_ `switch/case`-Blöcke entsprechend angepasst werden.
:::


::: slides
## Motivation: Modellierung eines Levels (cnt.)
:::

::: notes
### Variante II: Einsatz einer Klasse für die Felder
:::

```{.java size="footnotesize"}
public abstract class Tile {
    protected boolean isAccessible;
    protected Texture texture;
    public abstract boolean isAccessible() { return isAccessible; }
}
public class Floor extends Tile {
    protected boolean isAccessible = true;
    protected Texture texture = Texture.loadTexture("path/to/floor.png");
}
public class Water extends Tile {
    protected boolean isAccessible = false;
    protected Texture texture = Texture.loadTexture("path/to/water.png");
}

public class Level {
    private Tile[][] tiles;

    public boolean isAccessible(int x, int y) {
        return tiles[x][y].isAccessible();
    }
}
```

::: notes
Hier werden die Felder über eine Klassenhierarchie mit gemeinsamer Basisklasse modelliert.

Allerdings wird hier die Klassenhierarchie unter Umständen sehr schnell sehr umfangreich.
Außerdem werden Eigenschaften wie Texturen beim Anlegen der Tile-Objekte immer wieder neu
geladen und entsprechend mehrfach im Speicher gehalten.
:::


## Folie 2

Idee: Eigenschaften, die nicht an einem konkreten Tile hängen, werden in gemeinsam genutzte Objekte ausgelagert (Shared Objects/Memory)

Modell I: Klasse Tile mit Texturen und Eigenschaften; im Level werden dann Singletons angelegt mit konkreten Eigenschaften, im Tile-Array nur noch Referenzen auf diese Singletons
Modell II: Klasse Tile mit Referenz auf TileModel, dort dann Texturen und andere Eigenschaften; TileModel-Objekte werden von Tiles der gleichen Klasse gemeinsam genutzt


## Folie 3

UML-Diagramm

Verbindung zu Factory-Pattern (Erzeugung der geteilten Objekte)

Begriffe:
- speichere **intrinsic** state (invariant, context-independent und shareable)
- interface um **extrinsic** state (variant, context-dependent und kann nicht geteilt werden) zu übergeben

vgl. auch https://en.wikipedia.org/wiki/Flyweight_pattern
vgl. auch https://gameprogrammingpatterns.com/flyweight.html


::: notes
## Vor- und Nachteile des Flyweight-Pattern

### Vorteil

TODO

### Nachteil

TODO

### Verwandtschaft zum Type-Object-Pattern

Das Flyweight-Pattern ist sehr ähnlich zum `[Type-Object-Pattern]({{< ref "/pattern/type-object" >}})`{=markdown}.
In beiden Pattern teilen sich mehrere Objekte gemeinsame Daten, die über Referenzen auf
gemeinsame Hilfsobjekte eingebunden werden. Die Zielrichtung unterscheidet sich aber deutlich:

*   Beim Flyweight-Pattern ist das Ziel vor allem die Erhöhung der Speichereffizienz, und die
    dort geteilten Daten müssen nicht unbedingt den "Typ" des nutzenden Objekts definieren.
*   Beim Type-Objekt-Pattern ist das Ziel die Flexibilität auf Code-Ebene, indem man die Anzahl
    der Klassen minimiert und die Typen in ein eigenes Objekt-Modell verschiebt. Das Teilen von
    Speicher ist hier nur ein Nebeneffekt.
:::


## Wrap-Up

Ziel: Steigerung der Effizienz durch gemeinsame Nutzung von Objekten (Shared Memory)
Anmerkung: Große Ähnlichkeit zum Type-Object-Pattern, aber Ziele unterschiedlich: Dort Anzahl der Klassen minimieren, hier Effizienz erhöhen durch gemeinsam genutzte Objekte.

...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
