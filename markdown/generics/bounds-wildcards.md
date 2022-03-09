---
type: lecture-cg
title: "Bounds & Wildcards"
menuTitle: "Bounds & Wildcards"
author: "Carsten Gips (FH Bielefeld)"
weight: 2
eadings:
  - key: "Ullenboom2021"
    comment: "Kapitel 11.3"
  - key: "LernJava"
    comment: "Kapitel Generics"
  - key: "Java-SE-Tutorial"
    comment: "Specialized Trails: Generics"
  - key: "Bloch2018"
tldr: |
  TODO

  *   Ein Wildcard (`?`) als Typparameter steht für einen beliebigen Typ
    -   Ist in Klasse oder Methode dann aber nicht mehr zugreifbar
  *   Mit Bounds kann man Typparameter nach oben oder nach unten einschränken
    (im Sinne einer Vererbungshierarchie)
    -   `extends`: Der Typparameter muss eine Unterklasse eines bestimmten Typen sein
    -   `super`: Der Typparamenter muss einer Oberklasse eines bestimmten Typen sein

outcomes:
  - k3: "Umgang mit Wildcards und Bounds bei generischen Klassen/Methoden"
quizzes:
  - link: "XYZ"
assignments:
  - topic: sheet01
youtube:
  - link: "https://youtu.be/XYZ"
fhmedia:
  - link: "https://www.fh-bielefeld.de/medienportal/m/XYZ"
---


## Bounds: Einschränken der generischen Typen

```java
public class Cps<E extends Number> {
    // Obere Schranke: E muss Number oder Subklasse sein
    // => Zugriff auf Methoden aus Number moeglich
}
Cps<Double> a;
Cps<Number> b;
Cps<String> c;  // Fehler!!!
```

\bigskip
\smallskip

*   Schlüsselwort `extends` gilt hier auch für Interfaces
*   Mehrere Interfaces: nach `extends` Klasse oder Interface, danach
    mit "`&`" getrennt die restlichen Interfaces:

    ```java
    class Cps<E extends KlasseOderInterface & I1 & I2 & I3> {}
    ```

::: notes
*   Typ-Parameter analog auch mit `super` (nach unten) einschränkbar

[Beispiel bounds.Cps]{.bsp}
:::


## Wildcards: Dieser Typ ist mir nicht so wichtig

\bigskip

[Wildcard mit "`?`" => steht für unbestimmten Typ]{.cbox}

\bigskip

```java
public class Wuppie {
    public void m1(List<?> a) { ... }
    public void m2(List<? extends Number> b) { ... }
}
```

*   `m1`: `List` beliebig parametrisierbar \newline
    => In `m1` für Objekte in Liste `a` nur Methoden von `Object` nutzbar!

*   `m2`: `List` muss mit `Number` oder Subklasse parametrisiert werden. \newline
    => Dadurch für Objekte in Liste `b` alle Methoden von `Number` nutzbar ...


::: notes
Weitere Eigenschaften:

*   Durch Wildcard kein Zugriff auf den Typ
*   Wildcard kann durch upper bound eingeschränkt werden
*   Geht nicht bei Klassen-/Interface-Definitionen
:::

\bigskip
\bigskip

@Bloch2018: Nur für Parameter und nicht für Rückgabewerte nutzen!


## Hands-On: 10 Minuten

Ausgabe für Listen gesucht, die sowohl Elemente der Klasse `A` als auch
Elemente der Klasse `B` enthalten [können]{.notes}

\bigskip

```java
class A { void printInfo() { System.out.println("A"); } }
class B extends A { void printInfo() { System.out.println("B"); } }

public class X {
    public static void main(String[] args) {
        List<A> x = new ArrayList<A>();
        x.add(new A());  x.add(new B());
        printInfo(x);    // Klassenmethode in X, gesucht
        List<B> y = new ArrayList<B>();
        y.add(new B());  y.add(new B());
        printInfo(y);    // Klassenmethode in X, gesucht
    }
}
```

::::::::: notes
### Erster Versuch (_A_ und _B_ und _main()_ wie oben)

```java
public class X {
    public static void printInfo(List<A> list) {
        for (A a : list) { a.printInfo(); }
    }
}
```

=> **So gehts nicht!** Eine `List<B>` ist **keine** `List<A>`
(auch wenn ein `B` ein `A` ist, vgl. spätere Sitzung zu Generics und
Vererbung ...)!

[Beispiel wildcards.v1.X]{.bsp}

### Zweiter Versuch mit Wildcards (_A_ und _B_ und _main()_ wie oben)

```java
public class X {
    public static void printInfo(List<?> list) {
        for (Object a : list) { a.printInfo(); }
    }
}
```

=> **So gehts auch nicht!** Im Prinzip passt das jetzt
für `List<A>` und `List<B>`. Dummerweise hat man durch das Wildcard
keinen Zugriff mehr auf den Typparameter und muss für den Typ der
Laufvariablen in der `for`-Schleife dann `Object` nehmen. Aber
`Object` kennt unser `printInfo` nicht ... Außerdem könnte man die
Methode `X#printInfo` dank des Wildcards auch mit allen anderen
Typen aufrufen ...

[Beispiel wildcards.v2.X]{.bsp}

### Dritter Versuch (Lösung) mit Wildcards und Bounds (_A_ und _B_ und _main()_ wie oben)

```java
public class X {
    public static void printInfo(List<? extends A> list) {
        for (A a : list) { a.printInfo(); }
    }
}
```

Das ist die Lösung. Man erlaubt als Argument nur `List`-Objekte und fordert,
dass sie mit `A` oder einer Unterklasse von `A` parametrisiert sind. D.h.
in der Schleife kann man sich auf den gemeinsamen Obertyp `A` abstützen
und hat dann auch wieder die `printInfo`-Methode zur Verfügung ...
:::::::::

[Konsole wildcards.v3.X]{.bsp}


## Wrap-Up

*   Ein Wildcard (`?`) als Typparameter steht für einen beliebigen Typ
    -   Ist in Klasse oder Methode dann aber nicht mehr zugreifbar
*   Mit Bounds kann man Typparameter nach oben oder nach unten einschränken
    (im Sinne einer Vererbungshierarchie)
    -   `extends`: Der Typparameter muss eine Unterklasse eines bestimmten Typen sein
    -   `super`: Der Typparameter muss einer Oberklasse eines bestimmten Typen sein







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
