---
title: "Methoden-Referenzen"
linkTitle: "Methoden-Referenzen"
author: "Carsten Gips (HSBI)"
readings:
  - key: "Java-SE-tutorial"
    comment: "Learning the Java Language: Classes and Objects: Abschnitt Method References und Abschnitt Lambda Expressions"
  - key: "Urma2014"
    comment: "Kapitel 3: Lambda Expressions, Kapitel 5: Working with streams"
tldr: |
  Seit Java8 können **Referenzen auf Methoden** statt anonymer Klassen eingesetzt werden
  (**funktionales Interface nötig**).

  Dabei gibt es drei mögliche Formen:
  *   Form 1: Referenz auf eine statische Methode: `ClassName::staticMethodName`
      (wird verwendet wie `(args) -> ClassName.staticMethodName(args)`)
  *   Form 2: Referenz auf eine Instanz-Methode eines Objekts: `objectref::instanceMethodName`
      (wird verwendet wie `(args) -> objectref.instanceMethodName(args)`)
  *   Form 3: Referenz auf eine Instanz-Methode eines Typs: `ClassName::instanceMethodName`
      (wird verwendet wie `(o1, args) -> o1.instanceMethodName(args)`)

  Im jeweiligen Kontext muss ein passendes funktionales Interface verwendet werden, d.h. ein
  Interface mit **genau** einer abstrakten Methode. Die Methoden-Referenz muss von der
  Syntax her dieser einen abstrakten Methode entsprechen (bei der dritten Form wird die
  Methode auf dem ersten Parameter aufgerufen).
outcomes:
  - k2: "Funktionales Interfaces (Definition)"
  - k3: "Einsatz von Methoden-Referenzen"
quizzes:
  - link: "https://www.hsbi.de/elearning/goto.php?target=tst_1106524&client_id=FH-Bielefeld"
    name: "Quiz Methoden-Referenzen (ILIAS)"
youtube:
  - link: "https://youtu.be/z0mfvvrsRzc"
    name: "VL Methoden-Referenzen"
  - link: "https://youtu.be/YFdPcxE_1Eo"
    name: "Demo Referenz auf statische Methode"
  - link: "https://youtu.be/ImJTywhXrJo"
    name: "Demo Referenz auf Instanz-Methode (Objekt)"
  - link: "https://youtu.be/DVz2x27WHU8"
    name: "Demo Referenz auf Instanz-Methode (Typ)"
fhmedia:
  - link: "https://www.hsbi.de/medienportal/m/662003c5cb2cdef08b5d35cefd49b05f561fa26471cf3da22c4ff4310596909d0e21300133fc2fac353dfc4a391c8bb9af0dd47293efabfa8c3464429534d719"
    name: "VL Methoden-Referenzen"
challenges: |
    In den [Vorgaben](https://github.com/Programmiermethoden-CampusMinden/PM-Lecture/tree/master/markdown/modern-java/src/challenges/lambda)
    finden Sie die Klassen `Student` und `StudentSort` mit
    vorgefertigten Methoden  zu den Teilaufgaben sowie eine Testsuite
    `SortTest` mit einzelnen Testfälllen zu den Teilaufgaben, mit der Ihre
    Implementierung aufgerufen und getestet wird.

    Ziel dieser Aufgabe ist es, eine Liste von Studierenden mithilfe verschiedener
    syntaktischer Strukturen (Lambda-Ausdrücke, Methoden-Referenzen) zu sortieren.
    Dabei soll bei allen Teilaufgaben die Methode
    [java.util.List#sort](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html#sort(java.util.Comparator))
    für das eigentliche Sortieren verwendet werden.

    1.  Erweitern Sie die Klasse `Student` um eine _statische_ Methode, die zwei
        `Student`-Objekte anhand des Alters miteinander vergleicht. Die Methode
        soll die Signatur `static int compareByAge(Student a, Student b)` besitzen
        und die folgenden Werte zurückliefern:

        -   a > b -> -1
        -   a < b -> 1
        -   a == b -> 0

        Verwenden Sie die neue statische Methode `compareByAge` zum Sortieren
        der Liste in `sort_2b()`. Nutzen Sie dabei eine **Methodenreferenz**.

    2.  Erweitern Sie die Klasse `Student` um eine Instanz-Methode, die das
        `Student`-Objekt mit einem anderen (als Parameter übergebenen) `Student`-Objekt
        vergleicht. Die Methode soll die Signatur `int compareByName(Student other)`
        besitzen und die folgenden Werte zurückliefern:

        -   self > other -> -1
        -   self < other -> 1
        -   self == other -> 0

        Verwenden Sie die neue Methode `compareByName` zum Sortieren der Liste in `sort_3b()`.
        Nutzen Sie dabei eine **Methodenreferenz**.
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

*   Erinnerung: `Comparator<T>` ist ein funktionales Interface
*   Instanzen können wie üblich durch Ableiten bzw. anonyme Klassen erzeugt werden
*   Alternativ kann seit Java8 auch ein passender Lambda-Ausdruck verwendet werden
*   Ab Java8: Referenzen auf passende Methoden (Signatur!) können ein funktionales
    Interface "implementieren"
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
Konstruktoren mit mehr als 2 Parametern muss ein eigenes passendes funktionales
Interface mit entsprechend vielen Parametern definiert werden ...
:::

[[Hinweis: Klassen- vs. Instanz-Methoden]{.bsp}]{.slides}


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

[Demo: methodreferences.DemoStaticMethodReference]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/DemoStaticMethodReference.java"}

::: notes
`Collections.sort()` erwartet in diesem Szenario als zweiten Parameter eine Instanz von
`Comparator<Studi>` mit einer Methode `int compare(Studi o1, Studi o2)`.

Die übergebene Referenz auf die **statische Methode `cmpCpsClass` der Klasse `Studi`**
hat die **selbe Signatur** und wird deshalb von `Collections.sort()` genauso genutzt wie
die eigentlich erwartete Methode `Comparator<Studi>#compare(Studi o1, Studi o2)`, d.h.
statt `compare(o1, o2)` wird nun für jeden Vergleich **`Studi.cmpCpsClass(o1, o2)`**
aufgerufen.
:::


## Methoden-Referenz 2: Referenz auf Instanz-Methode (Objekt)

```java
public class Studi {
    public int cmpCpsInstance(Studi s1, Studi s2) {
        return s1.getCredits() - s2.getCredits();
    }

    public static void main(String... args) {
        List<Studi> sl = new ArrayList<Studi>();
        Studi holger = new Studi("Holger", 42);

        // Referenz auf Instanz-Methode eines Objekts
        Collections.sort(sl, holger::cmpCpsInstance);

        // Entsprechender Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> holger.cmpCpsInstance(o1, o2));
    }
}
```

[Demo: methodreferences.DemoInstanceMethodReferenceObject]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/DemoInstanceMethodReferenceObject.java"}

::: notes
`Collections.sort()` erwartet in diesem Szenario als zweites Argument wieder eine Instanz
von `Comparator<Studi>` mit einer Methode `int compare(Studi o1, Studi o2)`.

Die übergebene Referenz auf die **Instanz-Methode `cmpCpsInstance` des Objekts `holger`**
hat die selbe Signatur und wird entsprechend von `Collections.sort()` genauso genutzt wie
die eigentlich erwartete Methode `Comparator<Studi>#compare(Studi o1, Studi o2)`, d.h.
statt `compare(o1, o2)` wird nun für jeden Vergleich **`holger.cmpCpsInstance(o1, o2)`**
aufgerufen.
:::


## Methoden-Referenz 3: Referenz auf Instanz-Methode (Typ)

```java
public class Studi {
    public int cmpCpsInstance(Studi studi) {
        return this.getCredits() - studi.getCredits();
    }

    public static void main(String... args) {
        List<Studi> sl = new ArrayList<Studi>();

        // Referenz auf Instanz-Methode eines Typs
        Collections.sort(sl, Studi::cmpCpsInstance);

        // Entsprechender Lambda-Ausdruck
        Collections.sort(sl, (o1, o2) -> o1.cmpCpsInstance(o2));
    }
}
```

[Demo: methodreferences.DemoInstanceMethodReferenceType]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/DemoInstanceMethodReferenceType.java"}

::: notes
`Collections.sort()` erwartet in diesem Szenario als zweites Argument wieder eine Instanz
von `Comparator<Studi>` mit einer Methode `int compare(Studi o1, Studi o2)`.

Die übergebene Referenz auf die **Instanz-Methode `cmpCpsInstance` des Typs `Studi`** hat
die Signatur `int cmpCpsInstance(Studi studi)` und wird von `Collections.sort()` so genutzt:
Statt `compare(o1, o2)` wird nun für jeden Vergleich **`o1.cmpCpsInstance(o2)`**
aufgerufen.
:::


## Ausblick: Threads

::: notes
Erinnerung an bzw. Vorgriff auf ["Threads: Intro"](../threads/threads-intro.md):

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

Thread t3 = new Thread(ThreadStarter::wuppie);
```

[Beispiel: methodreferences.ThreadStarter]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/ThreadStarter.java"}


## Ausblick: Datenstrukturen als Streams

::: notes
Erinnerung an bzw. Vorgriff auf ["Stream-API"](stream-api.md):
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

[Beispiel: methodreferences.CollectionStreams]{.bsp href="https://github.com/Programmiermethoden-CampusMinden/PM-Lecture/blob/master/markdown/modern-java/src/methodreferences/CollectionStreams.java"}

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

Seit Java8: **Methoden-Referenzen** statt anonymer Klassen (**funktionales Interface nötig**)

\bigskip

*   Drei mögliche Formen:
    *   Form 1: Referenz auf statische Methode: `ClassName::staticMethodName` \newline
        (verwendet wie `(args) -> ClassName.staticMethodName(args)`)
    *   Form 2: Referenz auf Instanz-Methode eines Objekts: `objectref::instanceMethodName` \newline
        (verwendet wie `(args) -> objectref.instanceMethodName(args)`)
    *   Form 3: Referenz auf Instanz-Methode eines Typs: `ClassName::instanceMethodName` \newline
        (verwendet wie `(o1, args) -> o1.instanceMethodName(args)`)

\smallskip

*   Im jeweiligen Kontext muss ein passendes funktionales Interface verwendet werden
    [(d.h. ein Interface mit **genau** einer abstrakten Methode)]{.notes}







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
