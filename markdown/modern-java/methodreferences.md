---
type: lecture-cg
title: "Methodenreferenzen"
menuTitle: "Methodenreferenzen"
author: "Carsten Gips (FH Bielefeld)"
weight: 3
readings:
  - key: "Java-SE-tutorial"
    comment: "Learning the Java Language: Classes and Objects: Abschnitt Method References und Abschnitt Lambda Expressions"
  - key: "Urma2014"
    comment: "Kapitel 3: Lambda Expressions, Kapitel 5: Working with streams"
tldr: |
    Seit Java8: **Methodenreferenzen** statt anonymer Klassen (**Funktionsinterface nötig**)

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

    *   Die Methodenreferenz muss von der Syntax her dieser einen abstrakten Methode
        entsprechen (bei der dritten Form wird die Methode auf dem ersten Parameter
        aufgerufen).
outcomes:
  - k2: "Funktionsinterfaces (Definition)"
  - k3: "Erstellen eigener Funktionsinterfaces"
  - k3: "Einsatz von Methodenreferenzen"
quizzes:
  - link: "XYZ"
    name: "Quiz Methodenreferenzen (ILIAS)"
assignments:
  - topic: sheet08
youtube:
  - link: ""
    name: "VL Methodenreferenzen"
  - link: ""
    name: "Demo "
  - link: ""
    name: "Demo "
  - link: ""
    name: "Demo "
  - link: ""
    name: "Demo "
fhmedia:
  - link: ""
    name: "VL Methodenreferenzen"
---


## Beispiel: Sortierung einer Liste

```java
List<Studi> sl = new ArrayList<Studi>();

// anonyme Klasse
Collections.sort(sl, new Comparator<Studi>() {
    public int compare(Studi o1, Studi o2) {
        return Studi.cmpCps(o1, o2);
    }
});

// Lambda-Ausdruck
Collections.sort(sl, (o1, o2) -> Studi.cmpCps(o1, o2);

// Methodenreferenz
Collections.sort(sl, Studi::cmpCps);
```

::: notes
### Anmerkung

Für das obige Beispiel wird davon ausgegangen, dass in der Klasse `Studi`
eine Methode `cmpCps()` existiert:

```java
public int cmpCps(Studi o) {
    return o.getCps() - this.getCps();
}
```

Wenn man im Lambda-Ausdruck nur Methoden der eigenen Klasse aufruft,
kann man das auch direkt per _Methodenreferenz_ abkürzen!

*   Erinnerung: `Comparator<T>` ist ein Funktionsinterface
*   Instanzen können wie üblich durch Ableiten bzw. anonyme Klassen erzeugt werden
*   Alternativ kann seit Java8 auch ein passender Lambda-Ausdruck verwendet werden
*   Ab Java8: Referenzen auf passende Methoden (Signatur!) können ein
    Funktionsinterface "implementieren"
    *   Die (im Beispiel nicht gezeigte) statische Methode `int cmpCps(Studi o1, Studi o2)`
        hat die selbe Signatur wie `int compare(Studi o1, Studi o2)` aus `Comparator<Studi>`
    *   Kann deshalb wie eine Instanz von `Comparator<Studi>` genutzt werden
        *   Name der Methode spielt dabei keine Rolle
:::


::: notes
## Überblick: Arten von Methodenreferenzen

1.  Referenz auf eine statische Methode
    *   Form: `ClassName::staticMethodName`
    *   Wirkung: Aufruf mit `(args)` => `ClassName.staticMethodName(args)`

\smallskip

2.  Referenz auf Instanz-Methode eines bestimmten Objekts
    *   Form: `objectref::instanceMethodName`
    *   Wirkung: Aufruf mit `(args)` => `objectref.instanceMethodName(args)`

\smallskip

3.  Referenz auf Instanz-Methode eines bestimmten Typs
    *   Form: `ClassName::instanceMethodName`
    *   Wirkung: Aufruf mit `(arg0, rest)` => `arg0.instanceMethodName(rest)` \newline
        (`arg0` ist vom Typ `ClassName`)


_Anmerkung_: Analog zur Referenz auf eine statische Methode gibt es noch die
Form der Referenz auf einen Konstruktor: `ClassName::new`. Für Referenzen auf
Konstruktoren mit mehr als 2 Parametern muss ein eigenes passendes
Funktionsinterface mit entsprechend vielen Parametern definiert werden ...
:::


## Methodenreferenz 1: Referenz auf statische Methode

```java
public class Studi {
    public static int cmpName(Studi o1, Studi o2) {
        return o1.getName().compareTo(o2.getName());
    }


    public static void main(String[] args) {
        List<Studi> sl = new ArrayList<Studi>();

        // 1. Referenz auf statische Methode
        Collections.sort(sl, StudiList::cmpName);

        // entsprechender Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> StudiList.cmpName(o1, o2));
    }
}
```

[Demo: [methodreferences.StudiListMethodreference](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/StudiListMethodreference.java)]{.bsp}

::: notes
`Collections.sort()` erwartet in diesem Szenario als zweites Argument eine Instanz
von `Comparator<Studi>` mit einer Methode `int compare(Studi o1, Studi o2)`.

Die übergebene Referenz auf die **statische Methode `cmpName` der Klasse `StudiList`**
hat die selbe Signatur und wird entsprechend von `Collections.sort()` genauso genutzt
wie die eigentlich erwartete Methode `Comparator<Studi>#compare(Studi o1, Studi o2)`,
d.h. statt `compare(o1, o2)` wird nun für jeden Vergleich **`StudiList.cmpName(o1, o2)`**
aufgerufen.
:::


## Methodenreferenz 2: Referenz auf Instanz-Methode (Objekt)

```java
public class StudiList {
    List<Studi> list = new ArrayList<Studi>();
    public int cmpCredits(Studi o1, Studi o2) {
        return o1.getCredits() - o2.getCredits();
    }

    public static void main(String[] args) {
        StudiList sl = new StudiList();

        // 2. Referenz auf Instanz-Methode eines Objekts
        Collections.sort(sl.list, sl::cmpCredits);

        // entsprechender Lambda-Ausdruck
        Collections.sort(sl.list, (o1, o2) -> sl.cmpCredits(o1, o2));
    }
}
```

[Demo: [methodreferences.StudiListMethodreference](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/StudiListMethodreference.java)]{.bsp}

::: notes
`Collections.sort()` erwartet in diesem Szenario als zweites Argument wieder eine Instanz
von `Comparator<Studi>` mit einer Methode `int compare(Studi o1, Studi o2)`.

Die übergebene Referenz auf die **Instanz-Methode `cmpCredits` des Objekts `sl`**
hat die selbe Signatur und wird entsprechend von `Collections.sort()` genauso genutzt
wie die eigentlich erwartete Methode `Comparator<Studi>#compare(Studi o1, Studi o2)`,
d.h. statt `compare(o1, o2)` wird nun für jeden Vergleich **`sl.cmpCredits(o1, o2)`**
aufgerufen.
:::


## Methodenreferenz 3: Referenz auf Instanz-Methode (Typ)

```java
public class Studi {
    public int compareCredits(Studi o) {
        return o.getCredits() - this.getCredits();
    }
}
public class StudiList {
    public static void main(String[] args) {
        List<Studi> sl = new ArrayList<Studi>();

        // 3. Referenz auf Instanz-Methode eines Typs
        Collections.sort(sl, Studi::compareCredits);

        // entsprechender Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> o1.compareCredits(o2));
    }
}
```

[Demo: [methodreferences.StudiListMethodreference](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/StudiListMethodreference.java)]{.bsp}

::: notes
`Collections.sort()` erwartet in diesem Szenario als zweites Argument wieder eine Instanz
von `Comparator<Studi>` mit einer Methode `int compare(Studi o1, Studi o2)`.

Die übergebene Referenz auf die **Instanz-Methode `compareCredits` des Typs `Studi`**
hat die Signatur `int compareCredits(Studi o)` und wird von `Collections.sort()` so genutzt:
Statt `compare(o1, o2)` wird nun für jeden Vergleich **`o1.compareCredits(o2)`**
aufgerufen.
:::


## Anwendung: Threads

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
public class Wuppie {
    public static void wuppie() { System.out.println("wuppie"); }
}


Thread t1 = new Thread(new Runnable() {
    public void run() {
        System.out.println("wuppie");
    }
});

Thread t2 = new Thread(() -> {System.out.println("wuppie");});

Thread t3 = new Thread(Wuppie::wuppie);
```

[[Beispiel: [methodreferences.Wuppie](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/Wuppie.java)]{.bsp}]{.notes}


## Ausblick: Datenstrukturen als Streams

::: notes
Erinnerung an bzw. Vorgriff auf `["Stream-API"]({{< ref "/modern-java/stream-api" >}})`{=markdown}:
:::

```java
class X {
    public static boolean gtFour(int x) {
        return (x > 4) ? true : false;
    }
}

List<String> words = Arrays.asList("Java8", "Lambdas", "In",
        "Action", "Manning", "Working", "with", "streams");

List<Integer> wordLengths = words.stream()
        .map(String::length)
        .filter(X::gtFour)
        .sorted()
        .collect(toList());
```

[[Beispiel: [methodreferences.CollectionStreams](https://github.com/PM-Dungeon/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/CollectionStreams.java)]{.bsp}]{.notes}

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

Seit Java8: **Methodenreferenzen** statt anonymer Klassen (**Funktionsinterface nötig**)

\bigskip

*   Drei mögliche Formen:
    *   Form 1: Referenz auf statische Methode: `Classname::staticMethodName` \newline
        (verwendet wie `(o1, o2) -> Classname.staticMethodName(o1, o2)`)
    *   Form 2: Referenz auf Instanz-Methode eines Objekts: `objectref::instanceMethodName` \newline
        (verwendet wie `(o1, o2) -> objectref.instanceMethodName(o1, o2)`)
    *   Form 3: Referenz auf Instanz-Methode eines Typs: `ClassName::instanceMethodName` \newline
        (verwendet wie `(o1, o2) -> o1.instanceMethodName(o2)`)

\smallskip

*   Im jeweiligen Kontext muss ein Funktionsinterface verwendet werden,
    d.h. ein Interface mit **genau** einer abstrakten Methode

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
