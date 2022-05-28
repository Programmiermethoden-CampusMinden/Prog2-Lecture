---
type: lecture-cg
title: "Interfaces: Default-Methoden"
menuTitle: "Default-Methoden"
author: "Carsten Gips (FH Bielefeld)"
weight: 1
readings:
  - key: "Java-SE-tutorial"
    comment: "Learning the Java Language: Interfaces and Inheritance: Abschnitt Default Methods"
  - key: "Urma2014"
    comment: "Kapitel 9: Default Methods"
tldr: |
    Java8: Interfaces mit Implementierung: **Default-Methoden**

    *   Methoden mit dem zusätzlichen Schlüsselwort `default`
        können eine Implementierung im Interface haben.
    *   Die Implementierung wird vererbt und kann bei Bedarf überschrieben werden.
    *   Unterschied zu abstrakten Klassen: kein Zustand!
outcomes:
  - k2: "Interfaces mit Default-Methoden, Unterschied zu abstrakten Klassen"
  - k2: "Problem der Mehrfachvererbung"
  - k3: "Erstellen von Interfaces mit Default-Methoden"
  - k3: "Regeln zum Auflösen der Mehrfachvererbung"
quizzes:
  - link: "https://www.fh-bielefeld.de/elearning/goto.php?target=tst_1085302&client_id=FH-Bielefeld"
    name: "Quiz Default-Methoden (ILIAS)"
assignments:
  - topic: sheet08
youtube:
  - link: "https://youtu.be/qQ8BPkL9X5o"
    name: "VL Default-Methoden"
  - link: ""
    name: "Demo "
  - link: ""
    name: "Demo "
  - link: ""
    name: "Demo "
fhmedia:
  - link: ""
    name: "VL Default-Methoden"
---


## Problem: Etablierte API (Interfaces) erweitern

```java
interface Klausur {
    void anmelden(Studi s);
    void abmelden(Studi s);
}
```

\bigskip
\pause

=> Nachträglich noch `void schreiben(Studi s);`{.java} ergänzen?

::: notes
Wenn ein Interface nachträglich erweitert wird, müssen alle Kunden (also
alle Klassen, die das Interface implementieren) auf die neuen Signaturen
angepasst werden. Dies kann viel Aufwand verursachen und API-Änderungen
damit unmöglich machen.
:::


## Default-Methoden: Interfaces mit Implementierung

::: notes
Seit Java8 können Interfaces auch Methoden implementieren.
Es gibt zwei Varianten: Default-Methoden und statische Methoden.
:::

```java
interface Klausur {
    void anmelden(Studi s);
    void abmelden(Studi s);

    default void schreiben(Studi s) {
        ...     // Default-Implementierung
    }

    default void wuppie() {
        throw new java.lang.UnsupportedOperationException();
    }
}
```

::: notes
Methoden können in Interfaces seit Java8 implementiert werden. Für Default-Methoden
muss das Schlüsselwort `default` vor die Signatur gesetzt werden. Klassen, die das
Interface implementieren, können diese Default-Implementierung erben oder selbst
neu implementieren (überschreiben). Alternativ kann die Klasse eine Default-Methode
neu *deklarieren* und wird damit zur abstrakten Klasse.

Dies ähnelt abstrakten Klassen. Allerdings kann in abstrakten Klassen neben dem
Verhalten (implementieren Methoden) auch Zustand über die Attribute gespeichert werden.
:::


::: notes
## Problem: Mehrfachvererbung

Drei Regeln zum Auflösen bei Konflikten:

1.  **Klassen gewinnen**:
    Methoden aus Klasse oder Superklasse haben höhere Priorität als Default-Methoden
2.  **Sub-Interfaces gewinnen**:
    Methode aus am meisten spezialisiertem Interface mit Default-Methode wird gewählt
    Beispiel: Wenn `B extends A` dann ist `B` spezialisierter als `A`
3.  Sonst: Klasse muss **Methode explizit auswählen**:
    Methode überschreiben und gewünschte (geerbte) Variante aufrufen:
    `X.super.m(...)` (`X` ist das gewünschte Interface)

Auf den folgenden Folien wird dies anhand kleiner Beispiele verdeutlicht.
:::

[[Hinweis: Mehrfachvererbung]{.bsp}]{.slides}


## Auflösung Mehrfachvererbung: 1. Klassen gewinnen

```java
interface A {
    default void hello() { System.out.println("A"); }
}
class E implements A {
    public void hello() { System.out.println("E"); }
}
class F extends E implements A { }


public class DefaultTest {
    public static void main(String... args) {
        new F().hello();  // ???
    }
}
```

[Demo: [defaultmethods.DefaultTest](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/defaultmethods/DefaultTest.java)]{.bsp}

::: notes
Die Klasse `F` erbt sowohl von Klasse `E` als auch vom Interface `A` die Methode `hello()`
(Mehrfachvererbung). In diesem Fall "gewinnt" die Implementierung aus Klasse `E`.

**1. Regel**: Klassen gewinnen immer. Deklarationen einer Methode in einer Klasse oder
einer Oberklasse haben Vorrang von allen Default-Methoden.
:::


## Auflösung Mehrfachvererbung: 2. Sub-Interfaces gewinnen

```java
interface A {
    default void hello() { System.out.println("A"); }
}
interface B extends A {
    default void hello() { System.out.println("B"); }
}
class D implements A, B { }


public class DefaultTest {
    public static void main(String... args) {
        new D().hello();  // ???
    }
}
```

[Demo: [defaultmethods.DefaultTest](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/defaultmethods/DefaultTest.java)]{.bsp}

::: notes
Die Klasse `D` erbt sowohl vom Interface `A` als auch vom Interface `B` die Methode `hello()`
(Mehrfachvererbung). In diesem Fall "gewinnt" die Implementierung aus Klasse `B`: Interface
`B` ist spezialisierter als `A`.

**2. Regel**: Falls Regel 1 nicht zutrifft, gewinnt die Default-Methode, die am meisten
spezialisiert ist.
:::


## Auflösung Mehrfachvererbung: 3. Methode explizit auswählen

```java
interface A {
    default void hello() { System.out.println("A"); }
}
interface C {
    default void hello() { System.out.println("C"); }
}
class G implements A, C {
    public void hello() { A.super.hello(); }  // explizite Auswahl
}


public class DefaultTest {
    public static void main(String... args) {
        new G().hello();  // ???
    }
}
```

[Demo: [defaultmethods.DefaultTest](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/defaultmethods/DefaultTest.java)]{.bsp}

::: notes
Die Klasse `G` erbt sowohl vom Interface `A` als auch vom Interface `C` die Methode `hello()`
(Mehrfachvererbung). In diesem Fall *muss* zur Auflösung die Methode in `G` neu implementiert
werden und die gewünschte geerbte Methode explizit aufgerufen werden. (Wenn dies unterlassen
wird, führt das selbst bei Nicht-Nutzung der Methode `hello()` zu einem Compiler-Fehler!)

*Achtung*: Der Aufruf der Default-Methode aus Interface `A` erfolgt mit `A.super.hello();`
(nicht einfach durch `A.hello();`)!

**3. Regel**: Falls weder Regel 1 noch 2 zutreffen bzw. die Auflösung noch uneindeutig ist,
muss man manuell durch die explizite Angabe der gewünschten Methode auflösen.
:::


## Quiz: Was kommt hier raus?


```java
interface A {
    default void hello() { System.out.println("A"); }
}
interface B extends A {
    default void hello() { System.out.println("B"); }
}
class E implements A {
    public void hello() { System.out.println("E"); }
}
class H extends E implements B, A { }


public class DefaultTest {
    public static void main(String... args) {
        new H().hello();  // ???
    }
}
```

::: notes
Die Klasse `H` erbt sowohl von Klasse `E` als auch von den Interfaces `A` und `B` die Methode
`hello()` (Mehrfachvererbung). In diesem Fall "gewinnt" die Implementierung aus Klasse `H`: Klassen
gewinnen immer (Regel 1).
:::


::: notes
## Statische Methoden in Interfaces

```java
public interface Collection<E> extends Iterable<E> {
    boolean add(E e);
    ...
}
public class Collections {
    private Collections() { }
    public static <T> boolean addAll(Collection<? super T> c, T... elements) {...}
    ...
}
```

Typisches Pattern in Java: Interface plus Utility-Klasse (Companion-Klasse) mit statischen Hilfsmethoden
zum einfacheren Umgang mit Instanzen des Interfaces (mit Objekten, deren Klasse das Interface implementiert).
Beispiel: `Collections` ist eine Hilfs-Klasse zum Umgang mit `Collection`-Objekten.

Seit Java8 können in Interfaces neben Default-Methoden auch statische Methoden implementiert werden.


Die Hilfsmethoden können jetzt ins Interface wandern => Utility-Klassen werden obsolet ... Aus
Kompatibilitätsgründen würde man die bisherige Companion-Klasse weiterhin anbieten, wobei die Implementierungen
auf die statischen Methoden im Interface verweisen (*SKIZZE, nicht real!*):

```java
public interface CollectionX<E> extends Iterable<E> {
    boolean add(E e);
    static <T> boolean addAll(CollectionX<? super T> c, T... elements) { ... }
    ...
}
public class CollectionsX {
    public static <T> boolean addAll(CollectionX<? super T> c, T... elements) {
        return CollectionX.addAll(c, elements);  // Verweis auf Interface
    }
    ...
}
```
:::


## Interfaces vs. Abstrakte Klassen

*   **Abstrakte Klassen**: Schnittstelle und Verhalten und Zustand

*   **Interfaces**:
    *   vor Java 8 nur Schnittstelle
    *   ab Java 8 Schnittstelle und Verhalten

    ::: notes
    Unterschied zu abstrakten Klassen: Kein Zustand, d.h. keine Attribute
    :::

\bigskip

*   Design:
    *   Interfaces sind beinahe wie abstrakte Klassen, nur ohne Zustand
    *   Klassen können nur von **einer** (abstrakten) Klasse erben, aber
        **viele** Interfaces implementieren


## Wrap-Up

Seit Java8: Interfaces mit Implementierung: **Default-Methoden**

\bigskip

*   Methoden mit dem Schlüsselwort `default` können Implementierung im Interface haben
*   Die Implementierung wird vererbt und kann bei Bedarf überschrieben werden
*   Auflösung von Mehrfachvererbung:
    *   Regel 1: Klassen gewinnen
    *   Regel 2: Sub-Interfaces gewinnen
    *   Regel 3: Methode explizit auswählen
*   Unterschied zu abstrakten Klassen: **Kein Zustand**







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
