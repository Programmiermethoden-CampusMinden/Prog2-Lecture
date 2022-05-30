---
type: lecture-cg
title: "Verhaltens-Parametrisierung: Lambda-Ausdrücke und funktionale Interfaces"
menuTitle: "Lambda-Ausdrücke"
author: "Carsten Gips (FH Bielefeld)"
weight: 2
readings:
  - key: "Java-SE-tutorial"
    comment: "Learning the Java Language: Classes and Objects: Abschnitt Nested Classes, Abschnitt Anonymous Classes und Abschnitt Lambda Expressions"
  - key: "Urma2014"
    comment: "Kapitel 3: Lambda Expressions, Kapitel 5: Working with streams"
tldr: |
    *   Anonyme Klassen: "Wegwerf"-Innere Klassen
        *   Müssen Interface implementieren oder Klasse erweitern
    *   Java8: **Lambda-Ausdrücke** statt anonymer Klassen (**funktionales Interface nötig**)
        *   Zwei mögliche Formen:
            *   Form 1: `(parameters) -> expression`
            *   Form 2: `(parameters) -> { statements; }`
        *   Im jeweiligen Kontext muss ein **funktionales Interface** verwendet werden,
            d.h. ein Interface mit **genau** einer abstrakten Methode
        *   Der Lambda-Ausdruck muss von der Syntax her dieser einen abstrakten Methode
            entsprechen.
outcomes:
  - k2: "funktionales Interfaces (Definition)"
  - k3: "Einsatz innerer und anonymer Klassen"
  - k3: "Erstellen eigener funktionaler Interfaces"
  - k3: "Einsatz von Lambda-Ausdrücken"
quizzes:
  - link: "https://www.fh-bielefeld.de/elearning/goto.php?target=tst_1087248&client_id=FH-Bielefeld"
    name: "Quiz Lambda-Ausdrücke und funktionale Interfaces (ILIAS)"
assignments:
  - topic: sheet08
youtube:
  - link: ""
    name: "VL Lambda-Ausdrücke und funktionale Interfaces"
  - link: ""
    name: "Demo "
  - link: ""
    name: "Demo "
fhmedia:
  - link: ""
    name: "VL Lambda-Ausdrücke und funktionale Interfaces"
---


## Problem: Sortieren einer Studi-Liste

```java
public class StudiList implements Iterable<Studi> {
    List<Studi> list = new ArrayList<Studi>();

    public void sortName() {
        // ???
    }
}
```


::::::::: notes
## Erinnerung: Verschachtelte Klassen ("_Nested Classes_")

Man kann Klassen innerhalb von Klassen definieren: Verschachtelte Klassen.

*   Implizite Referenz auf Instanz der äußeren Klasse, Zugriff auf **alle** Elemente
*   **Begriffe**:
    *   "normale" innere Klassen: "_inner classes_"
    *   statische innere Klassen: "_static nested classes_"
*   Einsatzzweck:
    *   Hilfsklassen: Zusätzliche Funktionalität kapseln; Nutzung **nur** in äußerer Klasse
    *   Kapselung von Rückgabewerten

Sichtbarkeit: Wird u.U. von äußerer Klasse "überstimmt"

### Innere Klassen ("_Inner Classes_")

*   Objekt der äußeren Klasse muss existieren
*   Innere Klasse ist normales Member der äußeren Klasse
*   Implizite Referenz auf Instanz äußerer Klasse
*   Zugriff auf **alle** Elemente der äußeren Klasse
*   Sonderfall: Definition innerhalb von Methoden ("local classes")
    *   Nur innerhalb der Methode sichtbar
    *   Kennt zusätzlich `final` Attribute der Methode

Beispiel:

```java
public class Outer {
    ...
    private class Inner {
        ...
    }

    Outer.Inner inner = new Outer().new Inner();
}
```

[Beispiel mit Iterator als innere Klasse: [nested.StudiListNested](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/nested/StudiListNested.java)]{.bsp}

### Statische innere Klassen ("_Static Nested Classes_")

*   Keine implizite Referenz auf Objekt
*   Nur Zugriff auf Klassenmethoden und -attribute

Beispiel:

```java
class Outer {
    ...
    static class StaticNested {
        ...
    }
}

Outer.StaticNested nested = new Outer.StaticNested();
```
:::::::::


## Lösung: Comparator als innere Klasse

```java
public class StudiList implements Iterable<Studi> {
    List<Studi> list = new ArrayList<Studi>();

    public void sortName() {
        Comparator<Studi> c = new StudiNameComp();
        Collections.sort(list, c);
    }

    class StudiNameComp implements Comparator<Studi> {
        @Override
        public int compare(Studi o1, Studi o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
```

::: notes
=> Innere Hilfsklasse außerhalb nicht mehr sichtbar

=> Aber: Komplette Hilfsklasse, wo nur **eine** Methode benötigt

[Beispiel: [nested.StudiListInnerComparator](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/nested/StudiListInnerComparator.java)]{.bsp}
:::


## Verbesserung: Anonyme innere Klassen

```java
public void sortName() {
    Comparator<Studi> c = new Comparator<Studi>() {
        @Override
        public int compare(Studi o1, Studi o2) {
            ...
        }
    };  // Semikolon beachten!!!

    Collections.sort(list, c);
}
```

::: notes
=> Instanz einer anonymen Klasse, die das Interface `Comparator<Studi>` implementiert

*   Für spezielle, einmalige Aufgabe: nur eine Instanz möglich
*   Kein Name, kein Konstruktor, oft nur eine Methode
*   Müssen Interface implementieren oder andere Klasse erweitern
    *   Achtung Schreibweise: ohne `implements` oder `extends`!
*   Konstruktor kann auch Parameter aufweisen
*   Zugriff auf alle Attribute der äußeren Klasse plus alle `final` lokalen
    Variablen
*   Nutzung typischerweise bei GUIs: Event-Handler etc.

[Beispiel: [nested.StudiListAnonymComparator](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/nested/StudiListAnonymComparator.java)]{.bsp}
:::


## Verbesserung: Parametrisierung mit Verhalten

::: notes
Die Sortiermethode kann allerdings trotzdem immer noch nur nach
Namen sortieren! Besser wäre eine **Parametrisierung mit Verhalten**
("_behaviour parametrisation_"):
:::

```java
public class StudiList implements Iterable<Studi> {
    List<Studi> list = new ArrayList<Studi>();

    public void sort(Comparator<Studi> c) {
        Collections.sort(list, c);
    }

    public static void main(String[] args) {
        StudiList sl = new StudiList();

        sl.sort(new Comparator<Studi>() {
            @Override public int compare(Studi o1, Studi o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
}
```

::: notes
Die Methode `sort()` wird parametrisiert mit Verhalten: Beim Aufruf wird
eine neue anonyme Klasse, die das aktuell gewünschte Verhalten codiert,
als Argument mitgegeben.

[Beispiel: [nested.StudiListBehaviourParametrisation](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/nested/StudiListBehaviourParametrisation.java)]{.bsp}
:::


## Vereinfachung mit Lambda-Ausdruck

```java
StudiList sl = new StudiList();

// Parametrisierung mit anonymer Klasse
sl.sort(new Comparator<Studi>() {
    @Override public int compare(Studi o1, Studi o2) {
        return o1.getName().compareTo(o2.getName());
    }
});

// Parametrisierung mit Lambda-Ausdruck
sl.sort( (o1, o2) -> o1.getName().compareTo(o2.getName()) );
```

[[Hinweis auf funktionales Interface]{.bsp}]{.slides}

::: notes
[Beispiel: [nested.StudiListLambda](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/nested/StudiListLambda.java)]{.bsp}

**Anmerkung**: Damit für den Parameter alternativ auch ein Lambda-Ausdruck verwendet
werden kann, muss der erwartete Parameter ein "**funktionales Interface**" (s.u.) sein!
:::


## Syntax für Lambdas

```java
(Studi o1, Studi o2) -> o1.getName().compareTo(o2.getName())
```

::: notes
Ein Lambda-Ausdruck ist eine Funktion ohne Namen und besteht aus drei Teilen:

1.  Parameterliste (in runden Klammern),
2.  Pfeil
3.  Funktionskörper (rechte Seite)

Falls es genau einen Parameter gibt, können die runden Klammern um den Parameter entfallen.

Dabei kann der Funktionskörper aus *einem Ausdruck* ("_expression_") bestehen oder
einer _Menge von Anweisungen_ ("_statements"_), die dann in geschweifte Klammern
eingeschlossen werden müssen (Block mit Anweisungen).

Der Wert des Ausdrucks ist zugleich der Rückgabewert des Lambda-Ausdrucks.
:::

\bigskip
\bigskip

Varianten:

*   **`(parameters) -> expression`**

\smallskip

*   **`(parameters) -> { statements; }`**


## Quiz: Welches sind keine gültigen Lambda-Ausdrücke?

1.  `() -> {}`
2.  `() -> "wuppie"`
3.  `() -> { return "fluppie"; }`
4.  `(Integer i) -> return i + 42;`
5.  `(String s) -> { "foo"; }`
6.  `(String s) -> s.length()`
7.  `(Studi s) -> s.getCredits() > 300`
8.  `(List<Studi> sl) -> sl.isEmpty()`
9.  `(int x, int y) -> { System.out.println("Erg: "); System.out.println(x+y); }`
10. `() -> new Studi()`
11. `s -> s.getCps() > 100 && s.getCps() < 300`
12. `s -> { return s.getCps() > 100 && s.getCps() < 300; }`


:::::: notes
::: showme
Auflösung:
(4) und (5): `return` ist eine Anweisung, d.h. bei (4) fehlen die geschweiften
Klammern. `"foo"` ist ein String und als solcher ein Ausdruck, d.h. hier sind
die geschweiften Klammern zu viel (oder man ergänze den String mit einem `return`,
also `return "foo";` ...).
:::
::::::


## Funktionale Interfaces ("_functional interfaces_")

```java
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);
    boolean equals(Object obj);
    default Comparator<T> reversed() {
        return Collections.reverseOrder(this);
    }
}
```

\bigskip

`Comparator<T>` ist ein [**funktionales Interface**]{.alert}  ("_functional interface_") [(seit Java 8)]{.notes}

*   Genau eine abstrakte Methode
*   Evtl. weitere Default-Methoden
*   Evtl. weitere abstrakte Methoden, die `public` Methoden von
    `java.lang.Object` überschreiben

::: notes
=> Instanzen können zusätzlich mit Methodenreferenzen (u.a.) erzeugt werden

Die Annotation `@FunctionalInterface` selbst ist nur für den Compiler: Falls das Interface
_kein_ funktionales Interface ist, würde er beim Vorhandensein dieser Annotation einen Fehler
werfen. Oder anders herum: Allein durch das Annotieren mit `@FunctionalInterface` wird aus
einem Interface noch kein funktionales Interface!

Vergleichbar mit `@Override` ...

[**Während man für eine anonyme Klasse lediglich ein normales Interface benötigt, braucht man
 für Lambda-Ausdrücke zwingend ein passendes funktionales Interface!**]{.alert}

_Anmerkung_: Es scheint keine einheitliche deutsche Übersetzung für den Begriff
_functional interface_ zu geben. Es wird häufig mit "funktionales Interface", manchmal
aber auch mit "Funktionsinterface" übersetzt.
:::


## Quiz: Welches ist kein funktionales Interface?

```java
public interface Wuppie {
    int wuppie(int a);
}

public interface Fluppie extends Wuppie {
    int wuppie(double a);
}

public interface Foo {
}

public interface Bar extends Wuppie {
    default int bar() { return 42; }
}
```

:::::: notes
::: showme
Auflösung:

*   `Wuppie` hat *genau eine* abstrakte Methode => funktionales Interface
*   `Fluppie` hat zwei abstrakte Methoden => **kein** funktionales Interface
*   `Foo` hat gar keine abstrakte Methode => **kein** funktionales Interface
*   `Bar` hat *genau eine* abstrakte Methode (und eine Default-Methode) => funktionales Interface
:::
::::::


## Lambdas und funktionale Interfaces, Typprüfung

```java
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);    // abstrakte Methode
}
```

\bigskip

```java
// ohne weitere Typinferenz
Comparator<Studi> c1 = (Studi o1, Studi o2) -> o1.getCps() - o2.getCps();

// mit Typinferenz
Comparator<Studi> c2 = (o1, o2) -> o1.getCps() - o2.getCps();
```

::: notes
Der Compiler prüft in etwa folgende Schritte, wenn er über einen Lambda-Ausdruck stolpert:

1.  In welchem Kontext habe ich den Lambda-Ausdruck gesehen?
2.  OK, der Zieltyp ist hier `Comparator<Studi>`.
3.  Wie lautet die eine abstrakte Methode im `Comparator<T>`-Interface?
4.  OK, das ist `int compare(T o1, T o2);`
5.  Da `T` hier an `Studi` gebunden ist, muss der Lambda-Ausdruck
    der Methode `int compare(Studi o1, Studi o2);` entsprechen:
    2x `Studi` als Parameter und als Ergebnis ein `int`
6.  Ergebnis:
    a)  Cool, passt zum Lambda-Ausdruck `c1`. Fertig.
    b)  D.h. in `c2` müssen `o1` und `o2` vom Typ `Studi` sein.
        Cool, passt zum Lambda-Ausdruck `c2`. Fertig.
:::


## Offizielle funktionale Interfaces (Auswahl)

::: notes
Im Package `java.util.function` sind einige wichtige funktionale Interfaces
bereits vordefiniert. Diese kann man auch in eigenen Projekten nutzen!

Hier eine kleine Auswahl:
:::

| Interface                  | abstrakte Methode   |
|:---------------------------|:--------------------|
| `interface Predicate<T>`   | `boolean test(T t)` |
| `interface Function<T, R>` | `R apply(T t)`      |
| `interface Consumer<T>`    | `void accept(T t)`  |
| `interface Supplier<T>`    | `T get()`           |

[Quelle: Package [java.util.function](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/package-summary.html)]{.origin}


## Wrap-Up

*   Anonyme Klassen: "Wegwerf"-Innere Klassen
    *   Müssen Interface implementieren oder Klasse erweitern
*   Java8: **Lambda-Ausdrücke** statt anonymer Klassen (**funktionales Interface nötig**)
    *   Zwei mögliche Formen:
        *   Form 1: `(parameters) -> expression`
        *   Form 2: `(parameters) -> { statements; }`
    *   Im jeweiligen Kontext muss ein **funktionales Interface** verwendet werden,
        d.h. ein Interface mit **genau** einer abstrakten Methode
    *   Der Lambda-Ausdruck muss von der Syntax her dieser einen abstrakten Methode
        entsprechen.







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
