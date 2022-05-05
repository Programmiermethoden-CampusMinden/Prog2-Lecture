---
type: lecture-cg
title: "Type-Object-Pattern"
menuTitle: "Type-Object"
author: "Carsten Gips (FH Bielefeld)"
weight: 8
readings:
  - key: "Nystrom2014"
    comment: "Kap. 13: Type Object"
tldr: |
  hier kommt eine tolle inline-zusammenfassung!
  Formatierung _könnte_ auch **gehen**?
outcomes:
  - k1: "**wuppie**"
  - k2: "*foo*"
  - k3: "fluppie"
quizzes:
  - link: "XYZ"
    name: "Quiz Type-Object-Pattern (ILIAS)"
assignments:
  - topic: sheet06
youtube:
  - link: ""
    name: "VL Type-Object-Pattern"
  - link: ""
    name: "Demo Type-Object-Pattern"
fhmedia:
  - link: ""
    name: "VL Type-Object-Pattern"
---


## Motivation: Monster und spezialisierte Monster

```java
public abstract class Monster {
    protected int attackDamage;
    protected int movementSpeed;

    public Monster(int attackDamage, int movementSpeed) { ... }

    public void attack(Monster m)  { ... }
}

public class Rat extends Monster {
    public Rat() { super(10, 10); }  // Ratten haben 10 Damage und 10 Speed

    @Override
    public void attack(Monster m)  { ... }
}

public class Gnoll extends Monster { ... }


public static void main(String[] args) {
    Monster harald = new Rat();
    Monster eve = new Gnoll();
    ...
}
```

::: notes
Sie haben sich eine Monster-Basisklasse geschrieben. Darin gruppieren Sie typische
Eigenschaften eines Monsters: Es kann sich mit einer bestimmten Geschwindigkeit
bewegen und es kann anderen Monstern bei einem Angriff einen bestimmten Schaden
zufügen.

Um nun andere Monstertypen zu erzeugen, greifen Sie zur Vererbung und leiten von
der Basisklasse Ihre spezialisierten Monster ab und überschreiben die Defaultwerte
und bei Bedarf auch das Verhalten (die Methoden).

Damit entsteht aber recht schnell eine tiefe und verzweigte Vererbungshierarchie,
Sie müssen ja für jede Variation eine neue Unterklasse anlegen. Außerdem müssen
für jede (noch so kleine) Änderung an den Monster-Eigenschaften viele Klassen
editiert und das gesamte Projekt neu kompiliert werden.

Es würde auch nicht wirklich helfen, die Eigenschaften der Unterklassen über
deren Konstruktor einstellbar zu machen (die `Rat` könnte in ihrem Konstruktor
beispielsweise noch die Werte für Damage und Speed übergeben bekommen). Dann
werden die Eigenschaften an allen Stellen im Programm verstreut, wo Sie den
Konstruktor aufrufen.
:::


## Vereinfachen der Vererbungshierarchie (mit Enums als Type-Object)

```java
public enum Species { RAT, GNOLL, ... }

public final class Monster {
    private Species type;
    private int attackDamage;
    private int movementSpeed;

    public Monster(Species type) {
        switch (type) {
            case RAT: attackDamage = 10; movementSpeed = 10; break;
            ...
        }
    }

    public void attack(Monster m)  { ... }
}


public static void main(String[] args) {
    Monster harald = new Monster(Species.RAT);
    Monster eve = new Monster(Species.GNOLL);
    ...
}
```

::: notes
Die Lösung für die Vermeidung der Vererbungshierarchie: Die Monster-Basisklasse bekommt ein
Attribut, welches den Typ des Monsters bestimmt (das sogenannte "Type-Object"). Das könnte
wie im Beispiel ein einfaches Enum sein, das in den Methoden des Monsters abgefragt wird.
So kann zur Laufzeit bei der Erzeugung der Monster-Objekte durch Übergabe des Enums bestimmt
werden, was genau dieses konkrete Monster genau ist bzw. wie es sich verhält.

Allerdings ist das Hantieren mit den Enums etwas umständlich:  Man muss an allen Stellen,
wo das Verhalten der Monster unterschiedlich ist, ein `switch/case` einbauen und den Wert
des Type-Objects abfragen. Das bedeutet einerseits viel duplizierten Code und andererseits
muss man bei Erweiterungen des Enums alle `switch/case`-Blöcke auch anpassen.
:::


## Monster mit Strategie

```java
public final class Species {
    private int attackDamage;
    private int movementSpeed;
    private int xp;

    public Species(int attackDamage, int movementSpeed, int xp) { ... }

    public void attack(Monster m)  { ... }
}

public final class Monster {
    private Species type;
    private int xp;

    public Monster(Species type) {
        this.type = type;
        xp = type.xp;
    }

    public int movementSpeed() { return type.movementSpeed(); }

    public void attack(Monster m)  { type.attack(m); }
}


public static void main(String[] args) {
    Species rat = new Species(10, 10, 4);
    Species gnoll = new Species(...);

    Monster harald = new Monster(rat);
    Monster eve = new ...
}
```

::: notes
Statt des Enums nimmt man eine "echte" Klasse mit Methoden. Davon legt man zur Laufzeit
Objekte an (das sind dann die möglichen Monster-Typen) und bestückt damit die zu
erzeugenden Monster.

Im Monster selbst rufen die Monster-Methoden dann einfach nur die Methoden des Type-Objects
auf (Delegation => "Strategie-Pattern"). Man kann aber auch Attribute im Monster selbst
pflegen und durch das Type-Object nur initialisieren.

Vorteil: Änderungen erfolgen bei der Parametrisierung der Objekte (an **einer** Stelle im
Code, vermutlich `main()` oder beispielsweise durch Einlesen einer Konfig-Datei).
:::


## Fabrikmethode für die Type-Objects

```java
public final class Species {
    ...

    public Monster newMonster() {
        return new Monster(this);
    }
}


public static void main(String[] args) {
    Species rat = new Species(10, 10, 4);
    Species gnoll = new Species(...);

    Monster harald = rat.newMonster();
    Monster eve = gnoll.newMonster()
}
```

::: notes
Das Hantieren mit den Type-Objects und den Monstern ist nicht so schön. Deshalb kann man in
der Klasse für die Type-Objects noch eine Fabrikmethode (=> Factory-Method-Pattern) mit
einbauen, über die dann die Monster erzeugt werden.
:::


## Vererbung unter den Type-Objects

```java
public final class Species {
    ...

    public Species(int attackDamage, int movementSpeed, int xp) {
        this.attackDamage = attackDamage;  this.movementSpeed = movementSpeed;  this.xp = xp;
    }
    public Species(Species parent, int attackDamage) {
        this.attackDamage = attackDamage;
        movementSpeed = parent.movementSpeed;  xp = parent.xp;
    }
}


public static void main(String[] args) {
    Species rat = new Species(10, 10, 4);
    Species bossRat = new Species(rat, 100);
    Species gnoll = new Species(...);

    Monster harald = new Monster(rat);
    Monster eve = new ...
}
```

::: notes
Es wäre hilfreich, wenn die Type-Objects Eigenschaften untereinander teilen/weitergeben
könnten. Damit man aber jetzt nicht hier eine tiefe Vererbungshierarchie aufbaut und
damit wieder am Anfang des Problems wäre, baut man die Vererbung quasi selbst ein über
eine Referenz auf ein Eltern-Type-Object. Damit kann man zur Laufzeit einem Type-Object
sagen, dass es bestimmte Eigenschaften von einem anderen Type-Object übernehmen soll.

Im Beispiel werden die Eigenschaften `movementSpeed` und `xp` "vererbt" und entsprechend
aus dem Eltern-Type-Object übernommen (sofern dieses übergeben wird).
:::


## Erzeugen der Type-Objects dynamisch über eine Konfiguration

```json
{
  "Rat": {
    "attackDamage": 10,
    "movementSpeed": 10,
    "xp": 4
  },
  "BossRat": {
    "parent": "Rat",
    "attackDamage": 100
  },
  "Gnoll": {
    "attackDamage": ...,
    "movementSpeed": ...,
    "xp": ...
  }
}
```

::: notes

:::

Schritt 5: Die Konfiguration dieser Parameter legt man in einer Konfig-Datei ab, die vom Programm eingelesen wird. Damit muss am Code nichts mehr geändert werden und auch das Programm nicht mehr neu kompiliert werden, wenn man mal andere Eigenschaften ausprobieren oder Werte ändern möchte.


## Folie 7

UML-Diagramm (?!)

Anmerkung: Keines der "klassischen" Design-Pattern (vgl. https://en.wikipedia.org/wiki/Design_Patterns)
vgl. auch https://gameprogrammingpatterns.com/type-object.html


## Wrap-Up

Ziel: Anzahl der Klassen zu minimieren, indem die Typen in unser eigenes Objekt-Modell gehoben werden; flexibles Erzeugen von "Klassen" zur Laufzeit durch Konfiguration
Anmerkung: Große Ähnlichkeit zum Flyweight-Pattern, aber Ziele unterschiedlich: Hier Anzahl der Klassen minimieren, dort Effizienz erhöhen durch gemeinsam genutzte Objekte.

...







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
