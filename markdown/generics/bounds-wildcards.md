---
archetype: lecture-cg
title: "Bounds & Wildcards"
menuTitle: "Bounds & Wildcards"
author: "Carsten Gips (FH Bielefeld)"
weight: 2
readings:
  - key: "Ullenboom2021"
    comment: "Kapitel 11.3"
  - key: "LernJava"
    comment: "Kapitel Generics"
  - key: "Java-SE-Tutorial"
    comment: "Specialized Trails: Generics"
  - key: "Bloch2018"
tldr: |
  Typ-Variablen können weiter eingeschränkt werden, in dem man einen verpflichtenden
  Ober- oder Untertyp angibt mit `extends` bzw. `super`. Damit muss der später
  bei der Instantiierung verwendete Typ-Parameter entweder die Oberklasse selbst
  sein oder davon ableiten (bei `extends`) bzw. der Typ-Parameter muss eine Oberklasse
  der angegebenen Schranke sein (`super`).

  Durch die Einschränkung mit `extends` können in der Klasse/Methode auf der Typ-Variablen
  alle Methoden des angegebenen Obertyps verwendet werden.

  Ein Wildcard (`?`) als Typ-Parameter steht für einen beliebigen Typ, wobei die
  Typ-Variable keinen Namen bekommt und damit innerhalb der Klasse/Methode nicht
  zugreifbar ist.
outcomes:
  - k3: "Umgang mit Wildcards und Bounds bei generischen Klassen/Methoden"
quizzes:
  - link: "https://www.fh-bielefeld.de/elearning/goto.php?target=tst_1106236&client_id=FH-Bielefeld"
    name: "Quiz Generics: Bounds & Wildcards (ILIAS)"
assignments:
  - topic: sheet03
youtube:
  - link: "https://youtu.be/OV2vEn2EkWo"
    name: "VL Generics: Bounds & Wildcards"
  - link: "https://youtu.be/D2hIicsho7I"
    name: "Demo Wildcards"
fhmedia:
  - link: "https://www.fh-bielefeld.de/medienportal/m/08ef62f9367140e7ae75cd4e90fde1e63cc3ec6c9e7e4c11a1994065fd45e781f46bc6b3f1fbe4fbe8952db11812d52efe8cd8900fe88843e5eaefad62bbc7d3"
    name: "VL Generics: Bounds & Wildcards"
challenges: |
    Modellieren Sie in Java verschiedene Spielertypen sowie generische Mannschaften und Ligen,
    die jeweils bestimmte Spieler (-typen) bzw. Mannschaften aufnehmen können.

    1.  Implementieren Sie die Klasse `Spieler`, die das Interface `ISpieler` erfüllt.

        ```java
        public interface ISpieler {
            String getName();
        }
        ```

    2.  Implementieren Sie die beiden Klassen `FussballSpieler` und `BasketballSpieler` und
        sorgen Sie dafür, dass beide Klassen vom Compiler als Spieler betrachtet werden
        (geeignete Vererbungshierarchie).

    3.  Betrachten Sie das nicht-generische Interface `IMannschaft`. Erstellen Sie daraus ein
        generisches Interface `IMannschaft` mit einer Typ-Variablen. Stellen Sie durch geeignete
        Beschränkung der Typ-Variablen sicher, dass nur Mannschaften mit von `ISpieler` abgeleiteten
        Spielern gebildet werden können.

        ```java
        public interface IMannschaft {
            boolean aufnehmen(ISpieler spieler);
            boolean rauswerfen(ISpieler spieler);
        }
        ```
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
_Anmerkung_: Der Typ-Parameter ist analog auch mit `super` (nach unten) einschränkbar

[Beispiel bounds.Cps]{.bsp href="https://github.com/Programmiermethoden/PM-Lecture/blob/master/markdown/generics/src/bounds/Cps.java"}
:::


## Wildcards: Dieser Typ ist mir nicht so wichtig

\bigskip

::: cbox
Wildcard mit "`?`" => steht für unbestimmten Typ
:::

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


## Hands-On: Ausgabe für generische Listen

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

[**Hinweis**: Dieses Beispiel beinhaltet auch Polymorphie bei/mit generischen Datentypen, bitte vorher
 auch das Video zum vierten Teil "Generics und Polymorphie" anschauen]{.notes}

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

[Beispiel wildcards.v1.X]{.bsp href="https://github.com/Programmiermethoden/PM-Lecture/blob/master/markdown/generics/src/wildcards/v1/X.java"}

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
keinen Zugriff mehr auf den Typ-Parameter und muss für den Typ der
Laufvariablen in der `for`-Schleife dann `Object` nehmen. Aber
`Object` kennt unser `printInfo` nicht ... Außerdem könnte man die
Methode `X#printInfo` dank des Wildcards auch mit allen anderen
Typen aufrufen ...

[Beispiel wildcards.v2.X]{.bsp href="https://github.com/Programmiermethoden/PM-Lecture/blob/master/markdown/generics/src/wildcards/v2/X.java"}

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

[Konsole wildcards.v3.X]{.bsp href="https://github.com/Programmiermethoden/PM-Lecture/tree/master/markdown/generics/src/wildcards/v3"}


## Wrap-Up

*   Ein Wildcard (`?`) als Typ-Parameter steht für einen beliebigen Typ
    -   Ist in Klasse oder Methode dann aber nicht mehr zugreifbar

\smallskip

*   Mit Bounds kann man Typ-Parameter nach oben oder nach unten einschränken
    (im Sinne einer Vererbungshierarchie)
    -   `extends`: Der Typ-Parameter muss eine Unterklasse eines bestimmten Typen sein
    -   `super`: Der Typ-Parameter muss eine Oberklasse eines bestimmten Typen sein







<!-- DO NOT REMOVE - THIS IS A LAST SLIDE TO INDICATE THE LICENSE AND POSSIBLE EXCEPTIONS (IMAGES, ...). -->
::: slides
## LICENSE
![](https://licensebuttons.net/l/by-sa/4.0/88x31.png)

Unless otherwise noted, this work is licensed under CC BY-SA 4.0.
:::
