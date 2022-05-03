---
type: lecture-cg
title: "Singleton-Pattern"
menuTitle: "Singleton"
author: "Carsten Gips (FH Bielefeld)"
weight: 9
readings:
  - key: "Nystrom2014"
    comment: "Kap. 6: Singleton"
tldr: |
    *   Singleton-Pattern: Klasse, von der nur genau ein Objekt instantiiert werden kann
        *   Konstruktor "verstecken" (Sichtbarkeit auf `private` setzen)
        *   Methode zum Zugriff auf die eine Instanz
        *   Anlegen der Instanz beispielsweise beim Laden der Klasse ("Eager") oder
            beim Aufruf der Zugriffsmethode ("Lazy")
outcomes:
  - k2: "Was ist ein _Singleton_? Was ist der Unterschied zw. einem _Lazy_ und einem _Eager_ Singleton?"
  - k3: "Anwendung des Singleton-Patterns"
quizzes:
  - link: "XYZ"
    name: "Quiz Singleton-Pattern (ILIAS)"
assignments:
  - topic: sheet06
youtube:
  - link: ""
    name: "VL Singleton-Pattern"
  - link: ""
    name: "Demo Singleton-Pattern"
fhmedia:
  - link: ""
    name: "VL Singleton-Pattern"
---


## Motivation

...


## Ausflug Singleton-Pattern

Von den Enum-Konstanten soll es nur genau eine Instantiierung, also jeweils nur genau ein Objekt geben. Dies
ist uns bereits beim Thema ["Logging"](pm_logging.html) begegnet: Für jeden Namen soll/darf es nur einen
tatsächlichen Logger (== Objekt) geben.

Dies nennt man "**Singleton Pattern**".

Damit man von "außen" keine Instanzen einer Klasse anlegen kann, versteckt man den Konstruktor, d.h. man setzt
die Sichtbarkeit auf `private`. Zusätzlich benötigt man eine Methode, die das Objekt zurückliefern kann. Beim
Logger war dies einfach der Aufruf `Logger.getLogger("name")`.

Man kann verschiedene Ausprägungen bei der Umsetzung des Singleton Patterns beobachten. Die beiden wichtigsten
sind das "Eager Singleton Pattern" und das "Lazy Singleton Pattern". Der Unterschied liegt darin, wann genau
das Objekt erzeugt wird: Beim "Eager Singleton Pattern" wird es direkt beim Laden der Klasse erzeugt, beim
"Lazy Singleton Pattern" erst, wenn die Instanz benötigt wird (also beim Aufruf der `get`-Methode).

Hier zwei Skizzen:

```java
public class SingletonEager {
    private static final SingletonEager inst = new SingletonEager();

    // Privater Constructor: Niemand kann Objekte außerhalb der Klasse anlegen
    private SingletonEager() {
    }

    public static SingletonEager getInst() {
        return inst;
    }
}

public class SingletonLazy {
    private static SingletonLazy inst = null;

    // Privater Constructor: Niemand kann Objekte außerhalb der Klasse anlegen
    private SingletonLazy() {
    }

    public static SingletonLazy getInst() {
        synchronized (SingletonLazy.class) {  // Thread-safe. Kann weggelassen werden bei Single-Threaded Gebrauch
            if (inst == null) {
                inst = new SingletonLazy();
            }
        }
        return inst;
    }
}
```

[Code: singleton.SingletonEager vs. singleton.SingletonLazy]{.bsp}



## Wrap-Up

*   Singleton-Pattern: Klasse, von der nur genau ein Objekt instantiiert werden kann
    *   Konstruktor "verstecken" (Sichtbarkeit auf `private` setzen)
    *   Methode zum Zugriff auf die eine Instanz
    *   Anlegen der Instanz beispielsweise beim Laden der Klasse ("Eager") oder
        beim Aufruf der Zugriffsmethode ("Lazy")







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
