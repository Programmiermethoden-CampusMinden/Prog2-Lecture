---
type: lecture-cg
title: "Methoden-Referenzen"
menuTitle: "Methoden-Referenzen"
author: "Carsten Gips (FH Bielefeld)"
weight: 3
readings:
  - key: "Java-SE-tutorial"
    comment: "Learning the Java Language: Classes and Objects: Abschnitt Method References und Abschnitt Lambda Expressions"
  - key: "Urma2014"
    comment: "Kapitel 3: Lambda Expressions, Kapitel 5: Working with streams"
tldr: |
    Seit Java8: **Methoden-Referenzen** statt anonymer Klassen (**Funktionsinterface nötig**)

    *   Drei mögliche Formen:
        *   Form 1: Referenz auf statische Methode: `Classname::staticMethodName`
            (verwendet wie `(o1, o2) -> Classname.staticMethodName(o1, o2)`)
        *   Form 2: Referenz auf Instanz-Methode eines Objekts: `objectref::instanceMethodName`
            (verwendet wie `(o1, o2) -> objectref.instanceMethodName(o1, o2)`)
        *   Form 3: Referenz auf Instanz-Methode eines Typs: `ClassName::instanceMethodName`
            (verwendet wie `(o1, o2) -> o1.instanceMethodName(o2)`)

    *   Im jeweiligen Kontext muss ein Funktionsinterface verwendet werden,
        d.h. ein Interface mit **genau** einer abstrakten Methode

        Im obigen Beispiel für die Verwendung wäre eine Methode mit zwei Parametern nötig:

        ```java
        interface X<T,R> {
            R m(T o1, T o2);
        }
        ```

    *   Die Methoden-Referenz muss von der Syntax her dieser einen abstrakten Methode
        entsprechen (bei der dritten Form wird die Methode auf dem ersten Parameter
        aufgerufen).
outcomes:
  - k2: "Funktionsinterfaces (Definition)"
  - k3: "Erstellen eigener Funktionsinterfaces"
  - k3: "Einsatz von Methoden-Referenzen"
quizzes:
  - link: "XYZ"
    name: "Quiz Methoden-Referenzen (ILIAS)"
assignments:
  - topic: sheet08
youtube:
  - link: ""
    name: "VL Methoden-Referenzen"
  - link: ""
    name: "Demo Referenz auf statische Methode"
  - link: ""
    name: "Demo Referenz auf Instanz-Methode (Objekt)"
  - link: ""
    name: "Demo Referenz auf Instanz-Methode (Typ)"
fhmedia:
  - link: ""
    name: "VL Methoden-Referenzen"
---


## Beispiel: Sortierung einer Liste

```java
List<Studi> sl = new ArrayList<Studi>();

// Anonyme innere Klasse
Collections.sort(sl, new Comparator<Studi>() {
    @Override public int compare(Studi o1, Studi o2) {
        return Studi.cmpCpsClass(o1, o2);
    }
});


// Lambda-Ausdruck
Collections.sort(sl, (o1, o2) -> Studi.cmpCpsClass(o1, o2));

// Methoden-Referenz
Collections.sort(sl, Studi::cmpCpsClass);
```

::: notes
### Anmerkung

Für das obige Beispiel wird davon ausgegangen, dass in der Klasse `Studi` eine
statische Methode `cmpCpsClass()` existiert:

```java
public static int cmpCpsClass(Studi s1, Studi s2) {
    return s1.getCps() - s2.getCps();
}
```

Wenn man im Lambda-Ausdruck nur Methoden der eigenen Klasse aufruft, kann man das
auch direkt per _Methoden-Referenz_ abkürzen!

*   Erinnerung: `Comparator<T>` ist ein Funktionsinterface
*   Instanzen können wie üblich durch Ableiten bzw. anonyme Klassen erzeugt werden
*   Alternativ kann seit Java8 auch ein passender Lambda-Ausdruck verwendet werden
*   Ab Java8: Referenzen auf passende Methoden (Signatur!) können ein
    Funktionsinterface "implementieren"
    *   Die statische Methode `static int cmpCpsClass(Studi s1, Studi s2)` hat die
        selbe Signatur wie `int compare(Studi s1, Studi s2)` aus `Comparator<Studi>`
    *   Kann deshalb wie eine Instanz von `Comparator<Studi>` genutzt werden
    *   Name der Methode spielt dabei keine Rolle
:::


::: notes
## Überblick: Arten von Methoden-Referenzen

1.  Referenz auf eine statische Methode
    *   Form: `ClassName::staticMethodName`
    *   Wirkung: Aufruf mit `(args) -> ClassName.staticMethodName(args)`

\smallskip

2.  Referenz auf Instanz-Methode eines bestimmten Objekts
    *   Form: `objectref::instanceMethodName`
    *   Wirkung: Aufruf mit `(args) -> objectref.instanceMethodName(args)`

\smallskip

3.  Referenz auf Instanz-Methode eines bestimmten Typs
    *   Form: `ClassName::instanceMethodName`
    *   Wirkung: Aufruf mit `(arg0, rest) -> arg0.instanceMethodName(rest)` \newline
        (`arg0` ist vom Typ `ClassName`)


_Anmerkung_: Analog zur Referenz auf eine statische Methode gibt es noch die
Form der Referenz auf einen Konstruktor: `ClassName::new`. Für Referenzen auf
Konstruktoren mit mehr als 2 Parametern muss ein eigenes passendes
Funktionsinterface mit entsprechend vielen Parametern definiert werden ...
:::


## Methoden-Referenz 1: Referenz auf statische Methode

```java
public class Studi {
    public static int cmpCpsClass(Studi s1, Studi s2) {
        return s1.getCredits() - s2.getCredits();
    }

    public static void main(String... args) {
        List<Studi> sl = new ArrayList<Studi>();

        // Referenz auf statische Methode
        Collections.sort(sl, Studi::cmpCpsClass);

        // Entsprechender Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> Studi.cmpCpsClass(o1, o2));
    }
}
```

[Demo: [methodreferences.DemoStaticMethodReference](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/DemoStaticMethodReference.java)]{.bsp}

::: notes
`Collections.sort()` erwartet in diesem Szenario als zweiten Parameter eine Instanz von
`Comparator<Studi>` mit einer Methode `int compare(Studi o1, Studi o2)`.

Die übergebene Referenz auf die **statische Methode `cmpCpsClass` der Klasse `Studi`**
hat die **selbe Signatur** und wird deshalb von `Collections.sort()` genauso genutzt wie
die eigentlich erwartete Methode `Comparator<Studi>#compare(Studi o1, Studi o2)`, d.h.
statt `compare(o1, o2)` wird nun für jeden Vergleich **`Studi.cmpNcmpCpsClassame(o1, o2)`**
aufgerufen.
:::


## Methoden-Referenz 2: Referenz auf Instanz-Methode (Objekt)

```java
public class Studi {
    public int cmpCpsInstanz(Studi s1, Studi s2) {
        return s1.getCredits() - s2.getCredits();
    }

    public static void main(String... args) {
        List<Studi> sl = new ArrayList<Studi>();
        Studi holger = new Studi("Holger", 42);

        // Referenz auf Instanz-Methode eines Objekts
        Collections.sort(sl, holger::cmpCpsInstanz);

        // Entsprechender Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> holger.cmpCpsInstanz(o1, o2));
    }
}
```

[Demo: [methodreferences.DemoInstanceMethodReferenceObject](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/DemoInstanceMethodReferenceObject.java)]{.bsp}

::: notes
`Collections.sort()` erwartet in diesem Szenario als zweites Argument wieder eine Instanz
von `Comparator<Studi>` mit einer Methode `int compare(Studi o1, Studi o2)`.

Die übergebene Referenz auf die **Instanz-Methode `cmpCpsInstanz` des Objekts `holger`**
hat die selbe Signatur und wird entsprechend von `Collections.sort()` genauso genutzt wie
die eigentlich erwartete Methode `Comparator<Studi>#compare(Studi o1, Studi o2)`, d.h.
statt `compare(o1, o2)` wird nun für jeden Vergleich **`holger.cmpCpsInstanz(o1, o2)`**
aufgerufen.
:::


## Methoden-Referenz 3: Referenz auf Instanz-Methode (Typ)

```java
public class Studi {
    public int cmpCpsInstanz(Studi studi) {
        return this.getCredits() - studi.getCredits();
    }

    public static void main(String... args) {
        List<Studi> sl = new ArrayList<Studi>();

        // Referenz auf Instanz-Methode eines Typs
        Collections.sort(sl, Studi::cmpCpsInstanz);

        // Entsprechender Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> o1.cmpCpsInstanz(o2));
    }
}
```

[Demo: [methodreferences.DemoInstanceMethodReferenceType](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/DemoInstanceMethodReferenceType.java)]{.bsp}

::: notes
`Collections.sort()` erwartet in diesem Szenario als zweites Argument wieder eine Instanz
von `Comparator<Studi>` mit einer Methode `int compare(Studi o1, Studi o2)`.

Die übergebene Referenz auf die **Instanz-Methode `cmpCpsInstanz` des Typs `Studi`** hat
die Signatur `int cmpCpsInstanz(Studi studi)` und wird von `Collections.sort()` so genutzt:
Statt `compare(o1, o2)` wird nun für jeden Vergleich **`o1.cmpCpsInstanz(o2)`**
aufgerufen.
:::


## Ausblick: Threads

::: notes
Erinnerung an bzw. Vorgriff auf `["Threads: Intro"]({{< ref "/threads/intro" >}})`{=markdown}:

```java
public interface Runnable {
    void run();
}
```

Damit lassen sich Threads auf verschiedene Arten erzeugen:
:::

```java
public class ThreadStarter {
    public static void wuppie() { System.out.println("wuppie(): wuppie"); }
}


Thread t1 = new Thread(new Runnable() {
    public void run() {
        System.out.println("t1: wuppie");
    }
});

Thread t2 = new Thread(() -> System.out.println("t2: wuppie"));

Thread t3 = new Thread(Wuppie::wuppie);
```

[Beispiel: [methodreferences.ThreadStarter](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/ThreadStarter.java)]{.bsp}


## Ausblick: Datenstrukturen als Streams

::: notes
Erinnerung an bzw. Vorgriff auf `["Stream-API"]({{< ref "/modern-java/stream-api" >}})`{=markdown}:
:::

```java
class X {
    public static boolean gtFour(int x) { return (x > 4) ? true : false; }
}

List<String> words = Arrays.asList("Java8", "Lambdas", "PM",
        "Dungeon", "libGDX", "Hello", "World", "Wuppie");

List<Integer> wordLengths = words.stream()
        .map(String::length)
        .filter(X::gtFour)
        .sorted()
        .collect(toList());
```

[Beispiel: [methodreferences.CollectionStreams](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/CollectionStreams.java)]{.bsp}

::: notes
*   Collections können als Datenstrom betrachtet werden: `stream()`
    *   Iteration über die Collection, analog zu externer Iteration mit `foreach`
*   Daten aus dem Strom filtern: `filter`, braucht Prädikat
*   Auf alle Daten eine Funktion anwenden: `map`
*   Daten im Strom sortieren: `sort` (auch mit Comparator)
*   Daten wieder einsammeln mit `collect`

=> Typische Elemente **funktionaler Programmierung**

=> Verweis auf Wahlfach "Spezielle Methoden der Programmierung"
:::


## Wrap-Up

Seit Java8: **Methoden-Referenzen** statt anonymer Klassen (**Funktionsinterface nötig**)

\bigskip

*   Drei mögliche Formen:
    *   Form 1: Referenz auf statische Methode: `Classname::staticMethodName` \newline
        (verwendet wie `(o1, o2) -> Classname.staticMethodName(o1, o2)`)
    *   Form 2: Referenz auf Instanz-Methode eines Objekts: `objectref::instanceMethodName` \newline
        (verwendet wie `(o1, o2) -> objectref.instanceMethodName(o1, o2)`)
    *   Form 3: Referenz auf Instanz-Methode eines Typs: `ClassName::instanceMethodName` \newline
        (verwendet wie `(o1, o2) -> o1.instanceMethodName(o2)`)

\smallskip

*   Im jeweiligen Kontext muss ein passendes Funktionsinterface verwendet werden
    [(d.h. ein Interface mit **genau** einer abstrakten Methode)]{.notes}

    ::: notes
    Im obigen Beispiel für die Verwendung wäre eine Methode mit zwei Parametern nötig:
    :::

    ```java
    interface X<T,R> {
        R m(T o1, T o2);
    }
    ```







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
