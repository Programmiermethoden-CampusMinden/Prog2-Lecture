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
  Das Flyweight-Pattern dient der Steigerung der (Speicher-) Effizienz, indem gemeinsame
  Daten durch gemeinsam genutzte Objekte repräsentiert werden.

  Den sogenannten _Intrinsic State_, also die Eigenschaften, die sich alle Objekte teilen,
  werden in gemeinsam genutzte Objekte ausgelagert, und diese werden in den ursprünglichen
  Klassen bzw. Objekten nur referenziert. So werden diese Eigenschaften nur einmal in den
  Speicher geladen.

  Den sogenannten _Extrinsic State_, also alle individuellen Eigenschaften, werden
  entsprechend individuell je Objekt modelliert/eingestellt.
outcomes:
  - k2: "Unterscheiden von Intrinsic State und Extrinsic State"
  - k2: "Verschieben des Intrinsic States in gemeinsam genutzte Objekte"
  - k2: "Erklären der Ähnlichkeit zum Type-Object-Pattern"
  - k3: "Praktischer Einsatz des Flyweight-Patterns"
quizzes:
  - link: "https://www.fh-bielefeld.de/elearning/goto.php?target=tst_1077973&client_id=FH-Bielefeld"
    name: "Quiz Flyweight-Pattern (ILIAS)"
youtube:
  - link: ""
    name: "VL Flyweight-Pattern"
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

    public Level() {
        tiles[0][0] = Tile.WALL;  tiles[1][0] = Tile.WALL;   tiles[2][0] = Tile.WALL;  ...
        tiles[0][1] = Tile.WALL;  tiles[1][1] = Tile.FLOOR;  tiles[2][1] = Tile.FLOOR; ...
        tiles[0][2] = Tile.WALL;  tiles[1][2] = Tile.WATER;  tiles[2][2] = Tile.FLOOR; ...
        ...
    }

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
### Variante II: Einsatz einer Klasse/Klassenhierarchie für die Felder
:::

```{.java size="footnotesize"}
public abstract class Tile {
    protected boolean isAccessible;
    protected Texture texture;
    public boolean isAccessible() { return isAccessible; }
}
public class Floor extends Tile {
    public Floor() { isAccessible = true;  texture = Texture.loadTexture("path/to/floor.png"); }
}
...

public class Level {
    private final Tile[][] tiles;

    public Level() {
        tiles[0][0] = new Wall();  tiles[1][0] = new Wall();   tiles[2][0] = new Wall();  ...
        tiles[0][1] = new Wall();  tiles[1][1] = new Floor();  tiles[2][1] = new Floor(); ...
        tiles[0][2] = new Wall();  tiles[1][2] = new Water();  tiles[2][2] = new Floor(); ...
        ...
    }
    public boolean isAccessible(int x, int y) { return tiles[x][y].isAccessible(); }
}
```

::: notes
Hier werden die Felder über eine Klassenhierarchie mit gemeinsamer Basisklasse modelliert.

Allerdings wird hier die Klassenhierarchie unter Umständen sehr schnell sehr umfangreich.
Außerdem werden Eigenschaften wie Texturen beim Anlegen der Tile-Objekte immer wieder neu
geladen und entsprechend mehrfach im Speicher gehalten (großer Speicherbedarf).
:::


## Flyweight: Nutze gemeinsame Eigenschaften gemeinsam

::: notes
Idee: Eigenschaften, die nicht an einem konkreten Objekt hängen, werden in gemeinsam genutzte
Objekte ausgelagert (Shared Objects/Memory).

Ziel: Erhöhung der Speichereffizienz (geringerer Bedarf an Hauptspeicher, geringere Bandbreite
bei der Übertragung der Daten/Objekt an die GPU, ...).

### Lösungsvorschlag I
:::

```{.java size="footnotesize"}
public final class Tile {
    private boolean isAccessible;
    private Texture texture;
    public boolean isAccessible() { return isAccessible; }
}

public class Level {
    private static final Tile FLOOR = new Tile(true,  Texture.loadTexture("path/to/floor.png"));
    private static final Tile WALL  = new Tile(false, Texture.loadTexture("path/to/wall.png"));
    private static final Tile WATER = new Tile(false, Texture.loadTexture("path/to/water.png"));

    private final Tile[][] tiles;

    public Level() {
        tiles[0][0] = WALL;  tiles[1][0] = WALL;   tiles[2][0] = WALL;  ...
        tiles[0][1] = WALL;  tiles[1][1] = FLOOR;  tiles[2][1] = FLOOR; ...
        tiles[0][2] = WALL;  tiles[1][2] = WATER;  tiles[2][2] = FLOOR; ...
        ...
    }
    public boolean isAccessible(int x, int y) { return tiles[x][y].isAccessible(); }
}
```

::: notes
Man legt die verschiedenen Tiles nur je _einmal_ an und nutzt dann Referenzen auf diese Objekte.
Dadurch werden die speicherintensiven Elemente wie Texturen o.ä. nur je einmal geladen und im
Speicher vorgehalten.

Bei dieser Modellierung können die einzelnen Felder aber keine individuellen Eigenschaften haben,
wie etwa, ob ein Feld bereits durch den Helden untersucht/betreten wurde o.ä. ...
:::


::: slides
## Flyweight: Nutze gemeinsame Eigenschaften gemeinsam (cnt.)
:::

::: notes
### Lösungsvorschlag II
:::

```{.java size="scriptsize"}
public final class TileModel {
    private boolean isAccessible;
    private Texture texture;
    public boolean isAccessible() { return isAccessible; }
}
public final class Tile {
    private boolean wasEntered;
    private TileModel model;
    public boolean isAccessible() { return model.isAccessible(); }
    public boolean wasEntered() { return wasEntered; }
}

public class Level {
    private static final TileModel FLOOR = new TileModel(true,  Texture.loadTexture("path/to/floor.png"));
    ...

    private final Tile[][] tiles;

    public Level() {
        tiles[0][0] = new Tile(WALL);  tiles[1][0] = new Tile(WALL);   tiles[2][0] = new Tile(WALL);  ...
        tiles[0][1] = new Tile(WALL);  tiles[1][1] = new Tile(FLOOR);  tiles[2][1] = new Tile(FLOOR); ...
        tiles[0][2] = new Tile(WALL);  tiles[1][2] = new Tile(WATER);  tiles[2][2] = new Tile(FLOOR); ...
        ...
    }
    public boolean isAccessible(int x, int y) { return tiles[x][y].isAccessible(); }
}
```

::: notes
In dieser Variante werden die Eigenschaften eines `Tile` in Eigenschaften aufgeteilt, die von den
Tiles geteilt werden können (im Beispiel Textur und Betretbarkeit) und in Eigenschaften, die je
Feld individuell modelliert werden müssen (im Beispiel: wurde das Feld bereits betreten?).

Entsprechend könnte man für das Level-Beispiel ein `TileModel` anlegen, welches die gemeinsamen
Eigenschaften verwaltet. Man erzeugt dann im Level die nötigen Modelle je genau einmal und nutzt
sie, um damit dann die konkreten Felder zu erzeugen und im Level-Array zu referenzieren. Damit
werden Tile-Modelle von Tiles der gleichen "Klasse" gemeinsam genutzt und die Texturen u.ä. nur
je einmal im Speicher repräsentiert.
:::


## Flyweight-Pattern: Begriffe

-   **Intrinsic** State: invariant, Kontext-unabhängig, gemeinsam nutzbar \newline
    => auslagern in gemeinsame Objekte

\bigskip

-   **Extrinsic** State: variant, Kontext-abhängig und kann nicht geteilt werden \newline
    => individuell modellieren


::: notes
## Verwandtschaft zum Type-Object-Pattern

Das [Flyweight-Pattern](https://gameprogrammingpatterns.com/flyweight.html) ist sehr ähnlich zum
`[Type-Object-Pattern]({{< ref "/pattern/type-object" >}})`{=markdown}. In beiden Pattern teilen
sich mehrere Objekte gemeinsame Daten, die über Referenzen auf gemeinsame Hilfsobjekte eingebunden
werden. Die Zielrichtung unterscheidet sich aber deutlich:

*   Beim Flyweight-Pattern ist das Ziel vor allem die Erhöhung der Speichereffizienz, und die
    dort geteilten Daten müssen nicht unbedingt den "Typ" des nutzenden Objekts definieren.
*   Beim Type-Objekt-Pattern ist das Ziel die Flexibilität auf Code-Ebene, indem man die Anzahl
    der Klassen minimiert und die Typen in ein eigenes Objekt-Modell verschiebt. Das Teilen von
    Speicher ist hier nur ein Nebeneffekt.
:::


## Wrap-Up

Flyweight-Pattern: Steigerung der (Speicher-) Effizienz durch gemeinsame Nutzung von Objekten

\smallskip

-   Lagere _Intrinsic State_ in gemeinsam genutzte Objekte aus
-   Modelliere _Extrinsic State_ individuell







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
